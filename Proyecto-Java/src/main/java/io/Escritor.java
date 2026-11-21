package io;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

// Escribe la respuesta de un escenario, tanto en fichero como por consola
public class Escritor implements Closeable {
	private final BufferedWriter salida;
	private final List<String> historia = new ArrayList<>();
    private String resultado;

    public Escritor(File archivo) throws IOException {
        // Abre el fichero de salida en UTF-8. Sobreescribe el contenido del fichero si es necesario
        salida = Files.newBufferedWriter(
                archivo.toPath(),
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING,
                StandardOpenOption.WRITE);
    }

    public void escribirLinea(Object mensaje) {
    	String texto = String.valueOf(mensaje);
        historia.add(texto);
        System.out.println(texto);
    }
    
    public void escribirResultado(Object mensaje) {
        // Misiones.drl establece cual es la conclusion al terminar las historias
        resultado = String.valueOf(mensaje);
        System.out.println(resultado);
    }

    @Override
    public void close() throws IOException {
        try {
            // Primero se escribe la conclusion en el fichero de salida, despues los acontecimientos en orden
            if (resultado != null) {
                salida.write(resultado);
                salida.newLine();
                salida.newLine();
            }

            for (String linea : historia) {
                salida.write(linea);
                salida.newLine();
            }
        } finally {
            salida.close();
        }
    }
}

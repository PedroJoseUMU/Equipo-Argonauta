package io;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// Escribe la respuesta de un escenario, tanto en fichero como por consola
public class Escritor implements Closeable {
	private final BufferedWriter salida;

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
        try {
            salida.write(texto);
            salida.newLine();
        } catch (IOException e) {
            // Las reglas DRL pueden usar este metodo sin declarar IOException
            throw new IllegalStateException("Error al escribir la respuesta", e);
        }
        System.out.println(texto);
    }

    @Override
    public void close() throws IOException {
        // Cierra y vuelca al disco los datos pendientes
        salida.close();
    }
}

package io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import modelo.Dios;
import modelo.Mortal;
import modelo.Objeto;
import modelo.Ser;
import relaciones.NoPoseeObjeto;
import relaciones.PoseeObjeto;
import relaciones.TieneEnojo;
import relaciones.TieneFavor;

public class Lector {
	 private static final int CI = Pattern.CASE_INSENSITIVE;
	    private static final Pattern PREGUNTA_SER =
	        Pattern.compile("^puede (\\S+) (liberar|matar|apresar) a (.+)\\?$", CI);
	    private static final Pattern PREGUNTA_OBJETO =
	        Pattern.compile("^puede (\\S+) obtener (.+)\\?$", CI);
	    private static final Pattern PREGUNTA_CAPACIDAD =
	        Pattern.compile("^puede (\\S+) tener la capacidad de (.+)\\?$", CI);

	    private static final Pattern FAVOR = Pattern.compile("^(.+) tiene el favor de (.+)$", CI);
	    private static final Pattern ENOJO = Pattern.compile("^(.+) tiene el enojo de (.+)$", CI);
	    private static final Pattern NO_POSEE = Pattern.compile("^(.+) no tiene (.+)$", CI);
	    private static final Pattern POSEE = Pattern.compile("^(.+) tiene (.+)$", CI);

	    private final Map<String, Ser> seres = new HashMap<>();
	    private final Map<String, Objeto> objetos = new HashMap<>();

	    public Lector(Collection<Ser> seres, Collection<Objeto> objetos) {
	        for (Ser s : seres) this.seres.put(clave(s.getNombre()), s);
	        for (Objeto o : objetos) this.objetos.put(clave(o.getNombre()), o);
	    }

	    public List<Object> leer(Path fichero) throws IOException {
	        List<String> lineas = Files.readAllLines(fichero, StandardCharsets.UTF_8);
	        List<Object> hechos = new ArrayList<>();
	        boolean preguntaLeida = false;

	        for (String bruta : lineas) {
	            String linea = limpiar(bruta);
	            if (linea.isEmpty()) continue;
	            if (!preguntaLeida) {
	                hechos.add(leerPregunta(linea));
	                preguntaLeida = true;
	            } else if (!linea.equalsIgnoreCase("Condiciones:")) {
	                hechos.add(leerCondicion(linea));
	            }
	        }
	        if (!preguntaLeida) {
	            throw new IllegalArgumentException("Escenario sin pregunta: " + fichero);
	        }
	        return hechos;
	    }

	    private Object leerPregunta(String linea) {
	        Matcher m = PREGUNTA_SER.matcher(linea);
	        if (m.matches()) {
	            return new Pregunta(m.group(2).toLowerCase(), ser(m.group(1)),
	                                ser(m.group(3)).getNombre());
	        }
	        m = PREGUNTA_OBJETO.matcher(linea);
	        if (m.matches()) {
	            return new Pregunta("obtener", ser(m.group(1)), objeto(m.group(2)).getNombre());
	        }
	        m = PREGUNTA_CAPACIDAD.matcher(linea);
	        if (m.matches()) {
	            return new Pregunta("capacidad", ser(m.group(1)), m.group(2).trim());
	        }
	        throw new IllegalArgumentException("Pregunta no reconocida: " + linea);
	    }

	    private Object leerCondicion(String linea) {
	        Matcher m = FAVOR.matcher(linea);
	        if (m.matches()) new TieneFavor(mortal(m.group(1)), dios(m.group(2)));

	        m = ENOJO.matcher(linea);
	        if (m.matches()) return new TieneEnojo(ser(m.group(1)), ser(m.group(2)));

	        m = NO_POSEE.matcher(linea);
	        if (m.matches()) return new NoPoseeObjeto(ser(m.group(1)), objeto(m.group(2)));

	        m = POSEE.matcher(linea);
	        if (m.matches()) return new PoseeObjeto(ser(m.group(1)), objeto(m.group(2)));

	        throw new IllegalArgumentException("Condicion no reconocida: " + linea);
	    }

	    private Ser ser(String nombre) {
	        Ser s = seres.get(clave(nombre));
	        if (s == null) throw new IllegalArgumentException("Ser desconocido: " + nombre);
	        return s;
	    }
	    
	    private Dios dios(String n) {
	        Ser s = ser(n);
	        if (!(s instanceof Dios)) throw new IllegalArgumentException(n + " no es un dios");
	        return (Dios) s;
	    }

	    private Mortal mortal(String n) {
	        Ser s = ser(n);
	        if (!(s instanceof Mortal)) throw new IllegalArgumentException(n + " no es mortal");
	        return (Mortal) s;
	    }
	    
	    private Objeto objeto(String nombre) {
	        Objeto o = objetos.get(clave(nombre));
	        if (o == null) throw new IllegalArgumentException("Objeto desconocido: " + nombre);
	        return o;
	    }

	    private static String limpiar(String s) {
	        s = s.replace("\uFEFF", "").replace("¿", "").trim();
	        if (s.endsWith(".")) s = s.substring(0, s.length() - 1).trim();
	        return s;
	    }

	    private static String clave(String s) {
	        return s.trim().toLowerCase();
	    }
}

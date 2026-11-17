package io;

import java.io.*;
import java.util.*;
import modelo.*;
import relaciones.*;

public class Lector {
	private final Map<String, Ser> seres;
    private final Map<String, Objeto> objetos;

    public Lector(Map<String, Ser> seres, Map<String, Objeto> objetos) {
        this.seres = seres;
        this.objetos = objetos;
    }

    public List<Object> leer(String ruta) throws FileNotFoundException {
        List<Object> hechos = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(ruta), "UTF-8")) {
            while (sc.hasNextLine()) {
                String l = sc.nextLine().replace("¿", "").trim();
                if (l.isEmpty() || l.equals("Condiciones:")) continue;
                hechos.add(l.endsWith("?") ? pregunta(l) : condicion(l));
            }
        }
        return hechos;
    }

    private Pregunta pregunta(String l) {
        String[] p = l.replace("Puede ", "").replace("?", "").split(" ", 3);
        String accion = p[1].toLowerCase();
        String objetivo = p[2];
        if (objetivo.startsWith("a ")) objetivo = objetivo.substring(2);
        if (accion.equals("tener")) {
            accion = "capacidad";
            objetivo = objetivo.replace("la capacidad de ", "");
        }
        return new Pregunta(accion, ser(p[0]), objetivo.trim());
    }

    private Object condicion(String l) {
        String[] p;
        if (l.contains(" tiene el favor de ")) {
            p = l.split(" tiene el favor de ");
            return new TieneFavor(mortal(p[0]), dios(p[1]));
        }
        if (l.contains(" tiene el enojo de ")) {
            p = l.split(" tiene el enojo de ");
            return new TieneEnojo(ser(p[0]), ser(p[1]));
        }
        if (l.contains(" no tiene ")) {
            p = l.split(" no tiene ");
            return new NoPoseeObjeto(ser(p[0]), objeto(p[1]));
        }
        p = l.split(" tiene ");
        return new PoseeObjeto(ser(p[0]), objeto(p[1]));
    }
    
    private Ser ser(String n) {
        Ser s = seres.get(n.trim().toLowerCase());
        if (s == null) throw new IllegalArgumentException("Ser desconocido: " + n);
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
    
    private Objeto objeto(String n) {
        Objeto o = objetos.get(n.trim().toLowerCase());
        if (o == null) throw new IllegalArgumentException("Objeto desconocido: " + n);
        return o;
    }
}

package io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.Arma;
import modelo.Dios;
import modelo.Objeto;
import modelo.Ser;
import relaciones.PoseeObjeto;

public class ConocimientoInicial {
	 	private final List<Object> hechos = new ArrayList<>();
	    private final Map<String, Ser> seres = new HashMap<>();
	    private final Map<String, Objeto> objetos = new HashMap<>();

	    public ConocimientoInicial() {
	        Dios atenea = ser(new Dios("Atenea", "Sabiduria"));
	        Objeto escudo = objeto(new Arma("Escudo de Bronce"));
	        hechos.add(new PoseeObjeto(atenea, escudo));
	    }

	    private <T extends Ser> T ser(T s) {
	        seres.put(s.getNombre().toLowerCase(), s);
	        hechos.add(s);
	        return s;
	    }

	    private Objeto objeto(Objeto o) {
	        objetos.put(o.getNombre().toLowerCase(), o);
	        hechos.add(o);
	        return o;
	    }

	    public List<Object> getHechos() { return hechos; }
	    public Map<String, Ser> getSeres() { return seres; }
	    public Map<String, Objeto> getObjetos() { return objetos; }
}

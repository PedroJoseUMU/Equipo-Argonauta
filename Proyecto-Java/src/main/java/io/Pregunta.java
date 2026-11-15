package io;

import modelo.Ser;

public class Pregunta {
	private final String accion;
    private final Ser sujeto;
    private final String objetivo;

    public Pregunta(String accion, Ser sujeto, String objetivo) {
        this.accion = accion;
        this.sujeto = sujeto;
        this.objetivo = objetivo;
    }

    public String getAccion() { return accion; }
    public Ser getSujeto() { return sujeto; }
    public String getObjetivo() { return objetivo; }

    @Override
    public String toString() {
        return "Puede " + sujeto.getNombre() + " " + accion + " " + objetivo + "?";
    }
}

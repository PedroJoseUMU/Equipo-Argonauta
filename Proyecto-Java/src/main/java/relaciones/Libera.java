package relaciones;

import modelo.Ser;

public class Libera  {
	private final Ser liberador;
	private final Ser preso;
	public Libera(Ser liberador, Ser preso) {
		super();
		this.liberador = liberador;
		this.preso = preso;
	}
	public Ser getLiberador() {
		return liberador;
	}
	public Ser getPreso() {
		return preso;
	}
	@Override
	public String toString() {
		return liberador + " libera a " + preso;
	}
	
}

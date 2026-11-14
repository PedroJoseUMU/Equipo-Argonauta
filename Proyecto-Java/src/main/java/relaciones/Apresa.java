package relaciones;

import modelo.Ser;

public class Apresa {
	private final Ser captor;
	private final Ser preso;
	public Apresa(Ser captor, Ser preso) {
		super();
		this.captor = captor;
		this.preso = preso;
	}
	public Ser getCaptor() {
		return captor;
	}
	public Ser getPreso() {
		return preso;
	}
	@Override
	public String toString() {
		return preso + " apresado por " + captor;
	}
	
	

}

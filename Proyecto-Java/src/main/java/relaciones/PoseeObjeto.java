package relaciones;

import modelo.Objeto;
import modelo.Ser;

public class PoseeObjeto {
	private final Ser ser;
	private final Objeto objeto;
	public PoseeObjeto(Ser ser, Objeto objeto) {
		super();
		this.ser = ser;
		this.objeto = objeto;
	}
	public Ser getSer() {
		return ser;
	}
	public Objeto getObjeto() {
		return objeto;
	}
	@Override
	public String toString() {
		return ser + " posee " + objeto;
	}
	
}

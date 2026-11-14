package relaciones;

import modelo.Ser;

public class TieneEnojo {
	private final Ser ser;
	private final Ser enojado;
	public TieneEnojo(Ser ser, Ser enojado) {
		super();
		this.ser = ser;
		this.enojado = enojado;
	}
	public Ser getSer() {
		return ser;
	}
	public Ser getEnojado() {
		return enojado;
	}
	@Override
	public String toString() {
		return  ser + " tiene el enojo de " + enojado ;
	}
	
}

package relaciones;

import modelo.Lugar;
import modelo.Ser;

public class EstaEn {
	private final Ser ser;
	private final Lugar lugar;
	public EstaEn(Ser ser, Lugar lugar) {
		super();
		this.ser = ser;
		this.lugar = lugar;
	}
	public Ser getSer() {
		return ser;
	}
	public Lugar getLugar() {
		return lugar;
	}
	@Override
	public String toString() {
		return ser + " está en " + lugar;
	}
	
}

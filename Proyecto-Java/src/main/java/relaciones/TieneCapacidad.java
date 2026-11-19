package relaciones;

import modelo.Capacidad;
import modelo.Ser;

public class TieneCapacidad {
	private final Ser ser;
	private final Capacidad capacidad;
	public TieneCapacidad(Ser ser, Capacidad capacidad) {
		super();
		this.ser = ser;
		this.capacidad = capacidad;
	}
	public Ser getSer() {
		return ser;
	}
	public Capacidad getCapacidad() {
		return capacidad;
	}
	@Override
	public String toString() {
		return  ser + " tiene capacidad " + capacidad;
	}
	
}

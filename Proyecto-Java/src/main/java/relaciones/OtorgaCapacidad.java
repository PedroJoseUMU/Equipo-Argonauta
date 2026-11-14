package relaciones;

import modelo.Capacidad;
import modelo.Objeto;

public class OtorgaCapacidad {
	private final Objeto objeto;
	private final Capacidad capacidad;
	public OtorgaCapacidad(Objeto objeto, Capacidad capacidad) {
		super();
		this.objeto = objeto;
		this.capacidad = capacidad;
	}
	public Objeto getObjeto() {
		return objeto;
	}
	public Capacidad getCapacidad() {
		return capacidad;
	}
	@Override
	public String toString() {
		return objeto + " otorga la capacidad de " + capacidad;
	}
	
}

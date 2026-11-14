package relaciones;

import modelo.Mortal;
import modelo.Ser;

public class Mata {
	private final Ser asesino;
	private final Mortal asesinado;
	public Mata(Ser asesino, Mortal asesinado) {
		super();
		this.asesino = asesino;
		this.asesinado = asesinado;
	}
	public Ser getAsesino() {
		return asesino;
	}
	public Mortal getAsesinado() {
		return asesinado;
	}
	@Override
	public String toString() {
		return asesino + " mata a " + asesinado;
	}
	
}

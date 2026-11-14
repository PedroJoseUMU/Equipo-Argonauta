package relaciones;

import modelo.Ser;

public class HijoDe {
	private final Ser hijo;
	private final Ser padre;
	public HijoDe(Ser hijo, Ser padre) {
		super();
		this.hijo = hijo;
		this.padre = padre;
	}
	public Ser getHijo() {
		return hijo;
	}
	public Ser getPadre() {
		return padre;
	}
	@Override
	public String toString() {
		return hijo + " es hijo de " + padre;
	}
	
}

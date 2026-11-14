package relaciones;

import modelo.Ser;

public class Localiza {
	private final Ser buscador;
	private final Ser localizado;
	public Localiza(Ser buscador, Ser localizado) {
		super();
		this.buscador = buscador;
		this.localizado = localizado;
	}
	public Ser getBuscador() {
		return buscador;
	}
	public Ser getLocalizado() {
		return localizado;
	}
	@Override
	public String toString() {
		return buscador + " localiza a " + localizado;
	}
	
}

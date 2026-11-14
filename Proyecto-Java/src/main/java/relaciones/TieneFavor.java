package relaciones;

import modelo.Dios;
import modelo.Mortal;

public class TieneFavor {
	private final Mortal mortal;
	private final Dios dios;
	public TieneFavor(Mortal mortal, Dios dios) {
		super();
		this.mortal = mortal;
		this.dios = dios;
	}
	public Mortal getMortal() {
		return mortal;
	}
	public Dios getDios() {
		return dios;
	}
	@Override
	public String toString() {
		return mortal + " tiene el favor de " + dios;
	}
	
}

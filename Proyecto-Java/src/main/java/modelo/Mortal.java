package modelo;

public abstract class Mortal extends Ser {
	private boolean estaVivo = true;
	private boolean esHeroe = false;
	public boolean isEsHeroe() {
		return esHeroe;
	}
	public void setEsHeroe(boolean esHeroe) {
		this.esHeroe = esHeroe;
	}
	public Mortal(String nombre) {
		super(nombre, true);
	}
	public boolean isEstaVivo() {
		return estaVivo;
	}
	public void setEstaVivo(boolean estaVivo) {
		this.estaVivo = estaVivo;
	}

}

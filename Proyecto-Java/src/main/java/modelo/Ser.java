package modelo;

public abstract class Ser {
	private final String nombre;
    private boolean estaLibre = true;
	public String getNombre() {
		return nombre;
	}

	public boolean isEstaLibre() {
		return estaLibre;
	}
	public void setEstaLibre(boolean estaLibre) {
		this.estaLibre = estaLibre;
	}
	public Ser(String nombre, boolean estaLibre) {
		super();
		this.nombre = nombre;
		this.estaLibre = estaLibre;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ser other = (Ser) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
}

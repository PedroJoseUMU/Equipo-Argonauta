package modelo;

public class Dios extends Inmortal {
	private final String tituloDivino;
	public Dios(String nombre, String tituloDivino) {
		super(nombre);
		this.tituloDivino = tituloDivino;
		
	}
	public String getTituloDivino() {
		return tituloDivino;
	}


}

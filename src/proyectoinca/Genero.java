package proyectoinca;

public class Genero {
	private int idGenero;
	private String genero;
	private static int idFinal;
	
	
	public Genero(String genero) {
		this.idGenero = ++idFinal;
		this.genero = genero;
	}


	public int getIdGenero() {
		return idGenero;
	}


	public void setIdGenero(int idGenero) {
		this.idGenero = idGenero;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
	
	
}

package proyectoinca;

public class Pelicula {
	private int idPelicula;
	private String pelicula;
	private Genero genero;
	private static int idFinal;
	
	public Pelicula(String pelicula,Genero genero) {
		this.idPelicula = ++idFinal;
		this.pelicula = pelicula;
		this.genero = genero;
	}

	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public String getPelicula() {
		return pelicula;
	}

	public void setPelicula(String pelicula) {
		this.pelicula = pelicula;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	
	
}

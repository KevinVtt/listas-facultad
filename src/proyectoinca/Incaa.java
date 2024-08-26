package proyectoinca;

import java.util.ArrayList;
import java.util.List;

public class Incaa {
	List<Pelicula> catalogo;
	
	public Incaa() { 
		this.catalogo = new ArrayList<>();
	}
	
	public List<Pelicula> getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(List<Pelicula> catalogo) {
		this.catalogo = catalogo;
	}


	public boolean agregarPelicula(String pelicula,Genero genero) throws Exception { 
		
		boolean pel = catalogo.stream()
				.anyMatch(n -> n.getPelicula().equalsIgnoreCase(pelicula));		
		
		
		if(pel) {	
			throw new Exception("La pelicula ya se encuentra!!");
		}
		
		catalogo.add(new Pelicula(pelicula,genero));
		return true;
		
//		for(Pelicula p: catalogo) {
//			if(p.getPelicula().equalsIgnoreCase(pelicula)) {
//				throw new Exception("La pelicula ya se encuentra llena");
//			}
//		}
		
		
	}
	
	
	public Pelicula traerPelicula(int id) throws Exception {
		
		Pelicula pel = catalogo.stream()
						.filter(n -> Integer.compare(n.getIdPelicula(),id) == 0)
						.findAny().orElseGet( () -> null);		
	
		
		
		if(pel == null) {
			System.out.println("La pelicula no existe");
			//Si es nulo tirar la exception 
			throw new Exception("La pelicula no existe");
		}
		
		
		// Manera basica
//		for(Pelicula p: catalogo) {
//			if(Integer.compare(p.getIdPelicula(), id) == 0 ) {
//				return p;
//			}
//		}
//		
//		return null;
		
		return pel;
		
		}
	
	
public Pelicula traerPelicula(Genero genero) throws Exception {
		
		Pelicula pel = catalogo.stream()
						.filter(n -> n.getGenero().getGenero().equalsIgnoreCase(genero.getGenero()))
						.findAny().orElseGet( () -> null);		
	
		
		
		if(pel == null) {
			System.out.println("La pelicula no existe");
			//Si es nulo tirar la exception 
			throw new Exception("La pelicula no existe");
		}
		
		
		// Manera basica
//		for(Pelicula p: catalogo) {
//			if(Integer.compare(p.getIdPelicula(), id) == 0 ) {
//				return p;
//			}
//		}
//		
//		return null;
		
		return pel;
		
		}
	
	public void modificarPelicula(int idPelicula, String pelicula) throws Exception {
		
		traerPelicula(idPelicula).setPelicula(pelicula);;
	}
	
	public boolean eliminarPelicula(int idPelicula) throws Exception {
		
		
		return catalogo.remove(traerPelicula(idPelicula));
		
		
		
	}
	
}

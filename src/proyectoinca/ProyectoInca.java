package proyectoinca;

import proyectoinca.Incaa;

public class ProyectoInca {
	public static void main(String[] args) {
		
		Incaa i1 = new Incaa();
		
		try {
			i1.agregarPelicula("San Martin",new Genero("Historia"));
			i1.agregarPelicula("Kratos",new Genero("Accion"));
			i1.agregarPelicula("Rocky 1",new Genero("Superacion"));
			i1.agregarPelicula("Rocky 2",new Genero("Amistades con negros"));
			i1.agregarPelicula("Rocky 3",new Genero("Pelea comunista"));
			
			for(Pelicula p:i1.getCatalogo()) {
				
				System.out.println("ID: " + p.getIdPelicula());
				System.out.println("Nombre: " + p.getPelicula());
				System.out.println("Genero: " + p.getGenero().getGenero());
			}
			
			System.out.println("traer pelicula: " + i1.traerPelicula(3).getPelicula());
			
			i1.modificarPelicula(3, "Yo antes de ti");
			
			System.out.println("Modificacion de la pelicula: ");
			for(Pelicula p:i1.getCatalogo()) {
				
				System.out.println("ID: " + p.getIdPelicula());
				System.out.println("Nombre: " + p.getPelicula());
				System.out.println("Genero: " + p.getGenero().getGenero());
			}
			
			String peliculaElimada = i1.traerPelicula(3).getPelicula();
			i1.eliminarPelicula(3);
			System.out.println("La pelicula " + peliculaElimada + " fue eliminada");
			
		
			System.out.println("ELiminar pelicula: ");
			for(Pelicula p:i1.getCatalogo()) {
				
				System.out.println("ID: " + p.getIdPelicula());
				System.out.println("Nombre: " + p.getPelicula());
				System.out.println("Genero: " + p.getGenero().getGenero());
			}
			
			System.out.println("Traer pelicula por genero: " + i1.traerPelicula(new Genero("accion")).getPelicula());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

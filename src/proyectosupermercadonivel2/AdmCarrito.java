package proyectosupermercadonivel2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AdmCarrito {
	
	private List<Carrito> carrito;
	
	public AdmCarrito() {
		this.carrito = new ArrayList<Carrito>();
	}

	public List<Carrito> getCarrito() {
		return carrito;
	}

	public void setCarrito(List<Carrito> carrito) {
		this.carrito = carrito;
	}
	
	
	public boolean agregarCarrito(LocalDate fecha, LocalTime hora, Cliente cliente) throws Exception {
		
		Carrito c = this.carrito.stream().filter(n -> Long.compare(n.getCliente().getDni(), cliente.getDni()) == 0).findAny().orElseGet( () -> null);
		
		if(c == null) {
			this.carrito.add(new Carrito(fecha,hora,cliente));
			return true;
		}else {
			throw new Exception("El carrito ya existe");	
		}
		
		
		
	}
	
	public Carrito traerCarrito(int idCarrito) {
		
		return this.carrito.stream().filter(n -> n.getIdCarrito() == idCarrito).findAny().orElseGet( () -> null);
		
		
	}
	
	public boolean eliminarCarrito(int idCarrito) throws Exception {
		
		Carrito c = traerCarrito(idCarrito);
		
		if(this.carrito.stream().anyMatch(n -> n.getIdCarrito() == idCarrito)){
			this.carrito.remove(c);
			return true;
		}else {
			throw new Exception("No se encuentra en el carro");
		}
		

		
		
	}
	
	
	@Override
	public String toString() {
		return "AdmCarrito [carrito=" + carrito + "]";
	}

	
	
	
	
}

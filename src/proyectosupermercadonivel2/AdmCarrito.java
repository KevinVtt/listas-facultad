package proyectosupermercadonivel2;

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

	@Override
	public String toString() {
		return "AdmCarrito [carrito=" + carrito + "]";
	}

	
	
	
	
}

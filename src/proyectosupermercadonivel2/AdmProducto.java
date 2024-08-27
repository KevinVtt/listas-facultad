package proyectosupermercadonivel2;

import java.util.ArrayList;
import java.util.List;

public class AdmProducto {
	
	private List<Producto> productos;
	
	public AdmProducto() {
		this.productos = new ArrayList<Producto>();
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public boolean agregarProducto(String producto, float precio) {
		
		if(!this.productos.stream().filter(n -> n.getProducto().equalsIgnoreCase(producto)).findAny().get().getProducto().equalsIgnoreCase(producto)) {
			this.productos.add(new Producto(producto, precio));
			return true;
		}
		
		return false;
		
	}
	
	public Producto traerProducto(int idProducto) {
		
		return this.productos.stream().filter(n -> Integer.compare(idProducto, n.getIdProducto()) == 0).findAny().orElseGet( () -> null);
	}
	
	public boolean eliminarProducto(int idProducto){
		
		Producto p = traerProducto(idProducto);
		
		if(p != null) {
			this.productos.remove(p);
			return true;
		}
		
		return false;
		
	}

	@Override
	public String toString() {
		return "AdmProducto [productos=" + productos + "]";
	}
	
	
	
}

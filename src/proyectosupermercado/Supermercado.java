package proyectosupermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import proyectosupermercado.Producto;

public class Supermercado {
	private List<Producto> gondola;
	
	public Supermercado() {
		this.gondola = new ArrayList<Producto>();
	}
	
	public List<Producto> getGondola() {
		return gondola;
	}

	public void setGondola(List<Producto> gondola) {
		this.gondola = gondola;
	}
	
	
	public boolean agregarProducto(String producto, float precio) throws Exception {
		
		AtomicBoolean bandera = new AtomicBoolean(false);
		
		for(Producto p: this.gondola) {
			if(p.getProducto().equalsIgnoreCase(producto)) {
				bandera.set(true);
			}
		}
		
		if(bandera.get()) {
			throw new Exception("El producto ya existe");
		}else {
			this.gondola.add(new Producto(producto,precio));
			return bandera.get();
		}
		
		
	}
	
	public Producto traerProducto(int idProducto) {
		
		Producto pro = this.gondola.stream()
						.filter(p -> p.getIdProducto() == idProducto)
						.findAny().orElseGet(null);
		
		
		return pro;
		
	}
	
	public boolean modificarProducto(int idProducto,String producto, float precio) throws Exception {
		
		Producto p = traerProducto(idProducto);
		
		if(p != null) {
			p.setProducto(producto);
			p.setPrecio(precio);
			return true;
		}else {
			throw new Exception("El objeto no se encuentra");
		}
		
		
	}
	
	public boolean eliminarProducto(int idProducto) throws Exception {
		
		Producto p = traerProducto(idProducto);
		
		if(p != null) {
			this.gondola.remove(p);
			return true;
		}else {
			throw new Exception("No existe el producto para eliminar");
		}
		
		
		
	}

	@Override
	public String toString() {
		return "Supermercado [gondola=" + gondola + "]";
	}
	
	
	
	
	
}

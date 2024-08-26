package proyectosupermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

import proyectosupermercado.Producto;

public class ItemCarrito {
	private int idItem;
	private List<Producto> producto;
	private int cantidad;
	private static int idFinal;
	
	
	
	public ItemCarrito() {
		this.idItem = ++idFinal; 
		producto = new ArrayList<Producto>();
	}
	
	public ItemCarrito(int cantidad) {
		this();
		this.cantidad = cantidad;
	}
	
	
	public int getIdItem() {
		return idItem;
	}
	
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	

	public List<Producto> getProducto() {
		return producto;
	}

	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public boolean agregarProducto(String producto, float precio) throws Exception{
		
		AtomicBoolean bandera = new AtomicBoolean(false);
		
		this.producto.forEach(n -> {
			if(n.getProducto().equalsIgnoreCase(producto)){
				bandera.set(true);
			}
		});
		
		
		if(!bandera.get()) {
			this.producto.add(new Producto(producto,precio));
			return bandera.get();
		}else {
			throw new Exception("Ya se encuentra el producto");
		}
		
	}
	
	public Producto traerProducto(int idProducto) throws Exception{
		
		Producto pro = null;
		
		for(Producto p: this.producto) {
			if(p.getIdProducto() == idProducto) {
				pro = p;
			}
		}
		return pro;
	}
		
	public boolean eliminarProducto(int idProducto) throws Exception {
		
		Producto p = traerProducto(idProducto);
		
		if(p != null) {
			this.producto.remove(traerProducto(idProducto));
			return true;
		}else {
			throw new Exception("El prducto no existe o se encuentra en otro carrito");
		}
		
	}

	@Override
	public String toString() {
		return "ItemCarrito [idItem=" + idItem + ", producto=" + producto + ", cantidad=" + cantidad + "]";
	}
	
	
		
}

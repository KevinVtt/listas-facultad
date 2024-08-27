package proyectosupermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

import proyectosupermercado.Producto;

public class ItemCarrito {
	private int idItem;
	private Producto producto;
	private int cantidad;
	private static int idFinal;
	
	
	
	public ItemCarrito() {
		this.idItem = ++idFinal; 
	}
	
	public ItemCarrito(int cantidad, Producto producto) {
		this();
		this.cantidad = cantidad;
		this.producto = producto;
	}
	
	
	public int getIdItem() {
		return idItem;
	}
	
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	

	@Override
	public String toString() {
		return "ItemCarrito [idItem=" + idItem + ", producto=" + producto + ", cantidad=" + cantidad + "]";
	}
	
	
		
}

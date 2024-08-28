package proyectosupermercadonivel2;

import java.time.LocalDate;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import proyectosupermercadonivel2.*;



public class Carrito {
	
	private int idCarrito;
	private LocalDate fecha;
	private LocalTime hora;
	private List<ItemCarrito> listItem = new ArrayList<>();
	private Cliente cliente;
	private static int idFinal;
	
	public Carrito(LocalDate fecha, LocalTime hora,Cliente cliente) {
		this.idCarrito = ++idFinal;
		this.fecha = fecha;
		this.hora = hora;
		this.cliente = cliente;
	}

	public int getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<ItemCarrito> getListItem() {
		return listItem;
	}

	public void setListItem(List<ItemCarrito> listItem) {
		this.listItem = listItem;
	}
	
	public boolean agregarItem(Producto producto, int cantidad) {
		
		AtomicBoolean bandera = new AtomicBoolean(false);
		
		this.listItem.stream()
					.forEach(p -> {
						if(p.getProducto().getIdProducto() == producto.getIdProducto()) {
							bandera.set(true);
							p.setCantidad(cantidad + 1);
						}
					});
		
		
		ItemCarrito itemCa = new ItemCarrito(cantidad,producto);
		
		if(!bandera.get()) {
			
			this.listItem.add(itemCa);
			return bandera.get();
			
		}else {
			return bandera.get();
		}
		
	}
	

	public boolean eliminarItem(Producto producto, int cantidad) throws Exception {
		
		AtomicBoolean bandera = new AtomicBoolean(false);
		
		ItemCarrito itemCarro = this.listItem.stream()
						.filter(it -> it.getProducto().getProducto().equalsIgnoreCase(producto.getProducto()))
						.findAny().orElseThrow( () -> new Exception("El producto no existe"));
		
		
		this.listItem.forEach(it -> {
			
			if(it.getCantidad() == cantidad) {
				bandera.set(true);
			}else if(it.getCantidad() > cantidad) {
				bandera.set(false);
			}
		});
		
		if(bandera.get()) {
			this.listItem.remove(itemCarro);
			return bandera.get();
		}else {
			itemCarro.setCantidad(cantidad-1);
			return bandera.get();
		}
		
		
	}
	
	public float calcularTotal() {
		
		DoubleStream total = this.listItem.stream()
						.mapToDouble(n -> n.getCantidad() * n.getProducto().getPrecio());
		
		return (float)total.sum();
	}

	@Override
	public String toString() {
		return "Carrito [idCarrito=" + idCarrito + ", fecha=" + fecha + ", hora=" + hora + ", listItem=" + listItem
				+ ", cliente=" + cliente + "]";
	}

	
	
	
	
	
	
	
}

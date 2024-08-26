package proyectosupermercado;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;


import proyectosupermercado.*;



public class Carrito {
	private int idCarrito;
	private LocalDate fecha;
	private LocalTime hora;
	private List<ItemCarrito> listItem;
	private static int idFinal;
	
	public Carrito(LocalDate fecha, LocalTime hora) {
		this.idCarrito = ++idFinal;
		this.fecha = fecha;
		this.hora = hora;
		this.listItem = new ArrayList<>();
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

	
	public List<ItemCarrito> getListItem() {
		return listItem;
	}

	public void setListItem(List<ItemCarrito> listItem) {
		this.listItem = listItem;
	}

	
	public boolean agregarItem(Producto producto, int cantidad) throws Exception {
		
		AtomicBoolean bandera = new AtomicBoolean(false);
		
		this.listItem.forEach(n ->{
			
			try {
				if(n.traerProducto(producto.getIdProducto()) != null) {
						
						bandera.set(true);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		
		ItemCarrito it = new ItemCarrito(cantidad);
		it.agregarProducto(producto.getProducto(), producto.getPrecio());
		if(bandera.get()) {
			it.setCantidad(++cantidad);
			this.listItem.add(it);
		
		}else {
			this.listItem.add(it);
		}
		
//		this.listItem.add(new Ite)
		return bandera.get();
		
	}
	

	@Override
	public String toString() {
		return "Carrito [idCarrito=" + idCarrito + ", fecha=" + fecha + ", hora=" + hora + ", listItem=" + listItem
				+ "]";
	}
	
	
	
	
	
}

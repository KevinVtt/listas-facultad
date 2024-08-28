package proyectosupermercadonivel2;

import java.time.LocalDate;
import java.time.Month;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.DoubleStream;

import proyectosupermercadonivel2.*;

public class Supermercado{
	
	private AdmCliente admCliente;
	private AdmCarrito admCarrito;
	private AdmProducto admProducto;
	
	public Supermercado() {
		
	}
	
	public AdmCliente getAdmCliente() {
		return admCliente;
	}



	public void setAdmCliente(AdmCliente admCliente) {
		this.admCliente = admCliente;
	}



	public AdmCarrito getAdmCarrito() {
		return admCarrito;
	}



	public void setAdmCarrito(AdmCarrito admCarrito) {
		this.admCarrito = admCarrito;
	}



	public AdmProducto getAdmProducto() {
		return admProducto;
	}



	public void setAdmProducto(AdmProducto admProducto) {
		this.admProducto = admProducto;
	}



	public boolean agregarClientes(String cliente, long dni, String direccion) throws Exception {
		
		if(this.admCliente.getCliente().stream().mapToLong(n -> Long.compare(n.getDni(), dni)).findAny().orElseGet( () -> -1 ) == 0 ) {
			throw new Exception("El cliente ya se encuentra");
		}else {
			this.admCliente.getCliente().add(new Cliente(cliente,dni,direccion));
			return true;
		}
	}
	
	public Cliente traerCliente(int idCliente) {
		
		return this.admCliente.getCliente().stream().filter(n -> Integer.compare(n.getIdCliente(), idCliente) == 0).findAny().orElseGet(() -> null );
		
	}
	
	public boolean eliminarCliente(int idCliente) throws Exception{
		
		Cliente c = traerCliente(idCliente);
		System.out.println(c);
		if(c != null && !this.getAdmCarrito().getCarrito().stream().anyMatch(n -> n.getCliente().getIdCliente() == c.getIdCliente())) {
			
			this.admCliente.getCliente().remove(c);
			return true;
			
		}else {
			throw new Exception("No se encuentra el cliente para eliminar o ya existe en otro carrito");
		}
		
		
	}
	
	public float calcularTotal(Cliente cliente) throws Exception {
		
		Optional<Carrito> carrito = this.admCarrito.getCarrito().stream().filter(n -> n.getCliente().getDni() == cliente.getDni()).findFirst();
		
		
		float total = 0.0f;
		
		if(this.admCliente.getCliente().stream().anyMatch(n -> n.getDni() == cliente.getDni())) {
			
			if(carrito.isPresent()) {
				total = (float)carrito.get().getListItem().stream().mapToDouble(e -> e.getProducto().getPrecio() * e.getCantidad()).sum();
			}
			
		}else {
			throw new Exception("El cliente no existe");
		}
		
		
		
			
		return total;
	}
		
	
	
	public float calcularTotal(int idCliente) throws Exception {
		
		Optional<Carrito> carrito = this.admCarrito.getCarrito().stream().filter(n -> n.getCliente().getIdCliente() == idCliente).findFirst();
		
		
		float total = 0.0f;
		
		if(this.admCliente.getCliente().stream().anyMatch(n -> n.getIdCliente() == idCliente)) {
			
			if(carrito.isPresent()) {
				total = (float)carrito.get().getListItem().stream().mapToDouble(e -> e.getProducto().getPrecio() * e.getCantidad()).sum();
			}
			
		}else {
			throw new Exception("El cliente no existe");
		}
		
		
		
			
		return total;
	}
	
	public float calcularTotal(LocalDate fechaInicio, LocalDate fechaFin) {
		
		return (float)this.getAdmCarrito().getCarrito().stream()
											.filter(n -> n.getFecha().isAfter(fechaInicio) && n.getFecha().isBefore(fechaFin))
											.flatMap(c -> c.getListItem().stream())
											.mapToDouble(p -> p.getProducto().getPrecio()  * p.getCantidad())
											.sum();
		
	}
	
	
	public float calcularTotal(LocalDate fecha) {
		
		return (float)this.getAdmCarrito().getCarrito().stream()
											.filter(n -> n.getFecha().isEqual(fecha))
											.flatMap(c -> c.getListItem().stream())
											.mapToDouble(p -> p.getProducto().getPrecio() * p.getCantidad())
											.sum();
		
	}
	
	public float calcularTotal(int mes, int anio) throws Exception{
		
		if(mes > 12) {
			throw new Exception("El mes es incorrecto");
		}
		
		
		return (float)this.getAdmCarrito().getCarrito().stream()
				.filter(n -> n.getFecha().getYear() == anio &&  n.getFecha().getMonth() == Month.of(mes))
				.flatMap(c -> c.getListItem().stream())
				.mapToDouble(p -> p.getProducto().getPrecio() * p.getCantidad())
				.sum();
		
		
		
	}
	
	public float calcularTotal(LocalDate fechaInicio, LocalDate fechaFin, Cliente cliente) throws Exception {
		
		if(traerCliente(cliente.getIdCliente()) != null) {
			return (float)this.getAdmCarrito().getCarrito().stream()
					.filter(n -> n.getFecha().isAfter(fechaInicio) && n.getFecha().isBefore(fechaFin))
					.flatMap(c -> c.getListItem().stream())
					.mapToDouble(p -> p.getProducto().getPrecio() * p.getCantidad())
					.sum();
		}
		
		throw new Exception("El cliente no existe");
		
	}
	
	public float calcularTotal(LocalDate fecha, Cliente cliente) throws Exception {
		
		if(traerCliente(cliente.getIdCliente()) != null) {
			return (float)this.getAdmCarrito().getCarrito().stream()
					.filter(n -> n.getFecha().equals(fecha))
					.flatMap(c -> c.getListItem().stream())
					.mapToDouble(p -> p.getProducto().getPrecio() * p.getCantidad())
					.sum();
		}
		
		throw new Exception("El cliente no existe");
		
	}
	
	public float calcularTotal(int mes, int anio, Cliente cliente) throws Exception {
		
		if(traerCliente(cliente.getIdCliente()) != null && mes <= 12) {
			return (float)this.getAdmCarrito().getCarrito().stream()
					.filter(n -> n.getFecha().getYear() == anio &&  n.getFecha().getMonth() == Month.of(mes))
					.flatMap(c -> c.getListItem().stream())
					.mapToDouble(p -> p.getProducto().getPrecio() * p.getCantidad())
					.sum();
		}
		
		throw new Exception("El cliente no existe o el mes esta incorrecto");
		
	}
	
	public float calcularTotal(int mes, int anio, long dniCliente) throws Exception {
		
		Cliente cliente = this.getAdmCliente().getCliente().stream().filter(cli -> Long.compare(cli.getDni(), dniCliente) == 0).findAny().orElseThrow( () -> new Exception("El cliente no existe") );
		
		
		if(traerCliente(cliente.getIdCliente()) != null && mes <= 12) {
			return (float)this.getAdmCarrito().getCarrito().stream()
					.filter(n -> n.getFecha().getYear() == anio &&  n.getFecha().getMonth() == Month.of(mes))
					.flatMap(c -> c.getListItem().stream())
					.mapToDouble(p -> p.getProducto().getPrecio() * p.getCantidad())
					.sum();
		}
		
		throw new Exception("El cliente no existe o el mes esta incorrecto");
		
	}
	

	@Override
	public String toString() {
		return "Supermercado [admCliente=" + admCliente + ", admCarrito=" + admCarrito + ", admProducto=" + admProducto
				+ "]";
	}
	
	
	
}

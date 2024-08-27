package proyectosupermercadonivel2;

import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.DoubleStream;

import proyectosupermercadonivel2.*;

public class Supermercado {
	
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
		
		return this.admCliente.getCliente().stream()
									.filter(n -> Integer.compare(n.getIdCliente(), idCliente) == 0)
									.findAny().orElseGet(() -> null );
		
	}
	
	public boolean eliminarCliente(int idCliente) throws Exception{
		
		Cliente c = traerCliente(idCliente);
		
		
		
		if(c != null) {
			if(this.getAdmCarrito().getCarrito().stream()
												.filter(n -> Integer.compare(n.getCliente().getIdCliente(),c.getIdCliente()) == 0)
												.findAny().orElseGet( () -> null) != null ) {
				this.admCliente.getCliente().remove(c);
				return true;
			}
		}else {
			throw new Exception("No se encuentra el cliente para eliminar o ya existe en otro carrito");
		}
		
		return false;
		
	}

	@Override
	public String toString() {
		return "Supermercado [admCliente=" + admCliente + ", admCarrito=" + admCarrito + ", admProducto=" + admProducto
				+ "]";
	}
	
	
	
}

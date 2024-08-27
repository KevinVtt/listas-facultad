package proyectosupermercadonivel2;

import java.util.ArrayList;
import java.util.List;

import proyectosupermercadonivel2.*;

public class AdmCliente {
	private List<Cliente> cliente;
	
	

	public AdmCliente() {
		this.cliente = new ArrayList<Cliente>();
	}

	public List<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "AdmCliente [cliente=" + cliente + "]";
	}
	
	
	

}

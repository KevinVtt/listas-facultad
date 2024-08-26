package proyectosupermercado;

import java.util.List;

import proyectosupermercado.Producto;

public class Supermercado {
	private List<Producto> gondola;
	
	public Supermercado(List<Producto> gondola) {
		this.gondola = gondola;
	}

	public List<Producto> getGondola() {
		return gondola;
	}

	public void setGondola(List<Producto> gondola) {
		this.gondola = gondola;
	}

	@Override
	public String toString() {
		return "Supermercado [gondola=" + gondola + "]";
	}
	
	
	
	
	
}

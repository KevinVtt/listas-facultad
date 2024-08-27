package test;

import proyectosupermercadonivel2.*;

public class TestSupermercado2 {
	public static void main(String[] args) {
		
		try {
			Supermercado supermercado = new Supermercado();
			supermercado.setAdmCliente(new AdmCliente());
			supermercado.agregarClientes("Kevin", 45299060, "Gaboto");
			supermercado.agregarClientes("Hernan", 45234541, "San ramon");
			supermercado.agregarClientes("Kevin", 43234565, "Avellaneda");
			
			supermercado.getAdmCliente().getCliente().forEach(System.out::println);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}

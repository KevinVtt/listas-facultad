package test;

import java.time.LocalDate;
import java.time.LocalTime;

import proyectosupermercadonivel2.*;

public class TestSupermercado2 {
	public static void main(String[] args) {
		
		try {
			Supermercado supermercado = new Supermercado();
			supermercado.setAdmCliente(new AdmCliente());
			supermercado.setAdmCarrito(new AdmCarrito());
			
			System.out.println("AGREGAR CLIENTES !!!");
			
			supermercado.agregarClientes("Kevin", 45299060, "Gaboto");
			supermercado.agregarClientes("Hernan", 45234541, "San ramon");
			supermercado.agregarClientes("Alfonso", 43234565, "Avellaneda");
			supermercado.agregarClientes("Jose", 12343556, "Avellaneda");
			supermercado.getAdmCliente().getCliente().forEach(System.out::println);
			
			System.out.println("--------------------------------------------");
			System.out.println("CLIENTE ELIMINADO !!!");
			System.out.println(supermercado.eliminarCliente(4));
			supermercado.getAdmCliente().getCliente().forEach(System.out::println);
			
			System.out.println("--------------------------------------------");
			
			System.out.println("CARRITO !!!!");
			supermercado.getAdmCarrito().agregarCarrito(LocalDate.of(2020, 12, 12), LocalTime.of(10, 10),supermercado.traerCliente(1));
			supermercado.getAdmCarrito().agregarCarrito(LocalDate.of(2021, 1, 1), LocalTime.of(10, 10),supermercado.traerCliente(2));
			supermercado.getAdmCarrito().agregarCarrito(LocalDate.of(2022, 2, 2), LocalTime.of(12, 12),supermercado.traerCliente(3));
			System.out.println("--------------------------------------------");
			System.out.println("Traer carrito");
			supermercado.getAdmCarrito().traerCarrito(1).agregarItem(new Producto("MAnaos de cola",1000f), 1);
			supermercado.getAdmCarrito().traerCarrito(1).agregarItem(new Producto("Coca cola",2000f), 2);
			supermercado.getAdmCarrito().traerCarrito(2).agregarItem(new Producto("MAnaos de cola",2000f), 2);
			supermercado.getAdmCarrito().traerCarrito(3).agregarItem(new Producto("MAnaos de cola",3000f), 1);
			supermercado.getAdmCarrito().traerCarrito(3).agregarItem(new Producto("Pepsi",2500f), 3);
			
			supermercado.getAdmCarrito().getCarrito().forEach(System.out::println);
			System.out.println("--------------------------------------------");
			
			System.out.println("ELIMINAR CARRITOO");
			
			//supermercado.getAdmCarrito().eliminarCarrito(2);
			supermercado.getAdmCarrito().getCarrito().forEach(System.out::println);
			System.out.println("--------------------------------------------");
			System.out.println("CALCULAR TOTAL");
			
			for(Cliente c: supermercado.getAdmCliente().getCliente()) {
				System.out.println("Cliente: " + c.getCliente() + " : " + supermercado.calcularTotal(c));
			}	
			System.out.println("--------------------------------------------");
			System.out.println("CALCULAR TOTAL POR ID");
			
			for(Cliente c: supermercado.getAdmCliente().getCliente()) {
				System.out.println("Cliente: " + c.getCliente() + " : " + supermercado.calcularTotal(c.getIdCliente()));
			}
			System.out.println("--------------------------------------------");
			
			System.out.println("CALCULAR TOTAL POR FECHAS");
			System.out.println(supermercado.calcularTotal(LocalDate.of(2020, 11, 12), LocalDate.of(2022, 2, 2)));
			System.out.println("--------------------------------------------");
			
			System.out.println("CALCULAR TOTAL POR UNA FECHA");
			System.out.println(supermercado.calcularTotal(LocalDate.of(2022, 2, 2)));
			System.out.println("--------------------------------------------");
			
			System.out.println("CALCULAR TOTAL POR UNA FECHA");
			System.out.println(supermercado.calcularTotal(2,2022));
			System.out.println("--------------------------------------------");
			
			System.out.println("CALCULAR TOTAL POR UNA FECHA");
			System.out.println(supermercado.calcularTotal(LocalDate.of(2020, 11, 12), LocalDate.of(2021, 1, 1),supermercado.traerCliente(1)));
			System.out.println("--------------------------------------------");
			
			System.out.println("CALCULAR TOTAL POR UNA FECHA");
			System.out.println(supermercado.calcularTotal(LocalDate.of(2020, 12, 12),supermercado.traerCliente(1)));
			System.out.println("--------------------------------------------");
			
			System.out.println("CALCULAR TOTAL POR UNA FECHA POR MES Y ANIO");
			System.out.println(supermercado.calcularTotal(12,2020,supermercado.traerCliente(1)));
			System.out.println("--------------------------------------------");
			
			System.out.println("CALCULAR TOTAL POR UNA FECHA POR MES Y ANIO");
			System.out.println(supermercado.calcularTotal(12,2020,3333));
			System.out.println("--------------------------------------------");
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}

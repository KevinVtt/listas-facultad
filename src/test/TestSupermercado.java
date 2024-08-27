package test;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.LocalTime;

import proyectosupermercado.*;

public class TestSupermercado {
	public static void main(String[] args) {
		
		try {
			
			
			// Supermercado test
			Supermercado supermercado = new Supermercado();
			System.out.println("Agregar productos gondola");
			supermercado.agregarProducto("Manaos de cola",1000f);
			supermercado.agregarProducto("Coca cola zero",3000f);
			supermercado.agregarProducto("Pepsi",1500f);
			
			supermercado.getGondola().forEach(System.out::println);
			System.out.println("---------------------------------");
			System.out.println("Traer producto gondola");
			System.out.println(supermercado.traerProducto(2));
			System.out.println("---------------------------------");
			
			System.out.println("Eliminar producto gondola");
			supermercado.eliminarProducto(1);
			
			supermercado.getGondola().forEach(System.out::println);
			System.out.println("---------------------------------");
			
			System.out.println("Modificar producto gondola");
			supermercado.modificarProducto(3, "Fanta", 2000f);
			
			supermercado.getGondola().forEach(System.out::println);
			System.out.println("---------------------------------");
			
			System.out.println();
			System.out.println();
			
			// Carrito test
			
			Carrito carrito = new Carrito(LocalDate.of(2020, 1, 1),LocalTime.of(1, 1));
			System.out.println("Agregar item carrito en carrito");
			carrito.agregarItem(new Producto("Manaos",1000f), 3);
			carrito.agregarItem(new Producto("Coca cola", 3000f), 1);
			carrito.getListItem().forEach(System.out::println);
			System.out.println("---------------------------------");
			
			System.out.println("Eliminar item carrito de carrito");
			
			carrito.eliminarItem(new Producto("Manaos",1000f),1);
			carrito.getListItem().forEach(System.out::println);
			System.out.println("---------------------------------");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

			
	}
		
}

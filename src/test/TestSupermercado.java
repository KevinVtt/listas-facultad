package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import proyectosupermercado.Carrito;
import proyectosupermercado.ItemCarrito;
import proyectosupermercado.Producto;

public class TestSupermercado {
	public static void main(String[] args) {
		
		try {
			
			Carrito c1 = new Carrito(LocalDate.of(2020, 2, 2), LocalTime.of(1, 1));
			
			c1.agregarItem(new Producto("Manaos cola", 2000f), 2);
			c1.agregarItem(new Producto("Coca cola", 3000f), 1);
			
			c1.getListItem().forEach(System.out::println);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//System.out.println(c1);
		
		
		
		
		//for(ItemCarrito it: c1.getListItem()) {
			//for(Producto p: it.getProducto()) {
				//System.out.println(p.toString());
			//}
		//}
			
			
	}
		
}

package Carrito;

import java.util.ArrayList;

import entidades.LineaVenta;



public class Carrito {
	private ArrayList<LineaVenta> items ;
	
	public Carrito() {
		items = new ArrayList<LineaVenta>();
	}

	public ArrayList<LineaVenta> getItems() {
		return items;
	}

	public void setItems(ArrayList<LineaVenta> items) {
		this.items = items;
	}
	
	public void agregarLinea (LineaVenta linea) {
		items.add(linea);	
	}
	
	public void removerLinea (int itemIndex) {
		items.remove(itemIndex);
	}
	
	
	
	
	

}

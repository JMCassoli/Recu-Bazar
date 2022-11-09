package Practica;

import java.util.ArrayList;

public abstract class ElementoBazar {
	
	private String nombre;
	
	public ElementoBazar(String nombre) {
		this.nombre = nombre;
	}
	
	public abstract int getPeso();
	
	public abstract double getPrecio();
	
	public abstract ArrayList<String> getCategorias();
	
	public abstract ArrayList<ElementoBazar> getProductos();
	
	public abstract ArrayList<ElementoBazar> getElementosCondicion(Condicion condicion);
	
	public abstract ElementoBazar CopiaRestringida(Condicion condicion);
	
	public abstract Producto productoMenorPeso();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}

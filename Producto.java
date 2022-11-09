package Practica;

import java.util.ArrayList;

public class Producto extends ElementoBazar {
	
	private double precio;
	private int peso;
	private ArrayList<String> categorias;
	
	public Producto(double precio, int peso, String nombre) {
		super(nombre);
		this.precio = precio;
		this.peso = peso;
		this.categorias = new ArrayList<String>();
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	@Override
	public int getPeso() {
		return this.peso;
	}

	@Override
	public double getPrecio() {
		return this.precio;
	}

	@Override
	public ArrayList<String> getCategorias() {
		return new ArrayList<String>(this.categorias);
	}

	@Override
	public ArrayList<ElementoBazar> getProductos() {
		ArrayList<ElementoBazar> productos = new ArrayList<>();
		productos.add(this);
		return productos;
	}

	@Override
	public ArrayList<ElementoBazar> getElementosCondicion(Condicion condicion) {
		ArrayList<ElementoBazar> productos = new ArrayList<>();
		if(condicion.cumple(this)) {
			productos.add(this);
		}
		return productos;
		
	}

	@Override
	public ElementoBazar CopiaRestringida(Condicion condicion) {
		if(condicion.cumple(this)) {
			ElementoBazar copia = new Producto(this.getPrecio(), this.getPeso(),this.getNombre());
			return copia;
		}
		return null;
	}

	@Override
	public Producto productoMenorPeso() {
		return this;
	}

}

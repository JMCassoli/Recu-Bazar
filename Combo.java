package Practica;

import java.util.ArrayList;

public class Combo extends ElementoBazar {
	
	private double descuentoMaximo;
	private double descuento;
	private ArrayList<ElementoBazar> elementos;
	
	public Combo (double descuento, String nombre, double descuentoMaximo) {
		super(nombre);
		this.descuento=descuento;
		this.descuentoMaximo=descuentoMaximo;
		elementos = new ArrayList<ElementoBazar>();
		
	}
	
	public ArrayList<ElementoBazar> getElementos() {
		return new ArrayList<ElementoBazar>(this.elementos);
	}

	public int cantidadProductos() {		
		return getProductos().size();
	}
	
	public void addElemento(ElementoBazar elemento, Condicion condicion) {
		if(condicion.cumple(elemento)) {
			this.elementos.add(elemento);
		}
	}
	
	
	
	public ArrayList<ElementoBazar> getElementosCondicion(Condicion condicion) {
		ArrayList<ElementoBazar> result = new ArrayList<ElementoBazar>();
		if (condicion.cumple(this)) {
			result.add(this);
		} else {

			for (ElementoBazar elem : this.getProductos()) {
				result.addAll(elem.getElementosCondicion(condicion));
			}
		}

		return result;
	}
	
	@Override
	public int getPeso() {
		int aux = 0;
		if (elementos != null) {			
			for(ElementoBazar elem : elementos) {
			aux += elem.getPeso();
			}
		}
		return aux;
		
	}

	@Override
	public double getPrecio() {
		double precioOriginal = 0;
		if (elementos != null) {			
			for(ElementoBazar elem : elementos) {
			precioOriginal += elem.getPrecio();
			}
			double precioConDescuento = precioOriginal - (this.descuento * this.cantidadProductos()); 
			if(precioConDescuento > precioOriginal * this.descuentoMaximo) {
				return precioConDescuento;
			}
			return precioOriginal * this.descuentoMaximo;
		}
		return precioOriginal;
	}

	@Override
	public ArrayList<String> getCategorias() {
		ArrayList<String> result = new ArrayList<String>();

		if (elementos != null) {
			for (ElementoBazar elem : elementos) {
				ArrayList<String> aux = new ArrayList();
				aux = elem.getCategorias();
				for (String categoria : aux) {
					if (!result.contains(categoria)) {
						result.add(categoria);
					}
				}
			}
		}
		return result;
	}

	@Override
	public ArrayList<ElementoBazar> getProductos() {
		ArrayList<ElementoBazar> result = new ArrayList<ElementoBazar>();
		for(ElementoBazar elem : elementos) {
			result.addAll(elem.getProductos());
		}
		return result;
	}

	@Override
	public ElementoBazar CopiaRestringida(Condicion condicion) {				
		ArrayList<ElementoBazar> elementosCumplen = new ArrayList();
		for(ElementoBazar elem: this.elementos) {
			if(elem.CopiaRestringida(condicion)!=null) {
				elementosCumplen.add(elem.CopiaRestringida(condicion));
			}
		}
		
		if (!elementosCumplen.isEmpty()) {
			Combo copia = new Combo (this.getDescuento(), this.getNombre(), this.getDescuentoMaximo());
			for(ElementoBazar elem : elementosCumplen)
			copia.addElemento(elem, condicion);			
		}
				
		return null;
	}

	public double getDescuentoMaximo() {
		return descuentoMaximo;
	}

	public void setDescuentoMaximo(double descuentoMaximo) {
		this.descuentoMaximo = descuentoMaximo;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	@Override
	public Producto productoMenorPeso() {
		int menorPeso = 0;
		ElementoBazar menosPesado = null;
		for(ElementoBazar elem : this.elementos) {
			if(menorPeso == 0) {
			menosPesado = elem.productoMenorPeso();
			menorPeso = menosPesado.getPeso();
			} else {
				if(elem.productoMenorPeso().getPeso()<menorPeso) {
					menosPesado = elem.productoMenorPeso();
					menorPeso = menosPesado.getPeso();
				}				
			}
		}
		return (Producto) menosPesado;
	}

}

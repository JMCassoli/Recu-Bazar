package Practica;

public class CondicionPrecio extends Condicion {

	private double precioMaximo;
	
	public CondicionPrecio(double precioMax) {
		this.precioMaximo = precioMax;
	}
	
	@Override
	protected boolean cumple(ElementoBazar elemento) {
		if(elemento.getPrecio()<this.precioMaximo) {
			return true;
		}
		return false;
	}

}

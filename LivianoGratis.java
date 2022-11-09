package Practica;

public class LivianoGratis extends Combo {

	public LivianoGratis(double descuento, String nombre, double descuentoMaximo) {
		super(descuento, nombre, descuentoMaximo);
		
	}
	
	public double getPrecio() {
		double precioOriginal = 0;
		if (this.getElementos() != null) {			
			for(ElementoBazar elem : getElementos()) {
			precioOriginal += elem.getPrecio();
			}
			precioOriginal = precioOriginal - productoMenorPeso().getPrecio();
			
		}
		return precioOriginal;

	}
}
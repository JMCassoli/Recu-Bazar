package Practica;

public class CondicionPeso extends Condicion {
	
	private int pesoMinimo;
	
	public CondicionPeso(int pesoMin) {
		this.pesoMinimo = pesoMin;
	}

	@Override
	protected boolean cumple(ElementoBazar elemento) {
		if(elemento.getPeso()>this.pesoMinimo) {
			return true;
		}
		return false;
	}

}

package Practica;

public class CondicionOr extends Condicion {
	
	private Condicion condicion1, condicion2;
	
	public CondicionOr(Condicion condicion1, Condicion condicion2) {
		this.condicion1 = condicion1;
		this.condicion2 = condicion2;
	}
	
	@Override
	protected boolean cumple(ElementoBazar elemento) {
		if(condicion1.cumple(elemento)|| condicion2.cumple(elemento)) {
			return true;
		}
		return false;
	}

}

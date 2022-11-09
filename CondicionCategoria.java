package Practica;

import java.util.ArrayList;

public class CondicionCategoria extends Condicion {
	
	private String categoriaBuscada;
	
	public CondicionCategoria(String categoria) {
		this.categoriaBuscada = categoria;
	}

	@Override
	protected boolean cumple(ElementoBazar elemento) {
		if(elemento.getCategorias().contains(categoriaBuscada)) {
			return true;
		}
		
		return false;
	}

}

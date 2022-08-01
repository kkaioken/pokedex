package br.com.digix.pokedigix.ataque;

public class PrecisaoInvalidaException extends Exception {

	public PrecisaoInvalidaException() {
		super("A precisão deve estar entre 0 e 100.");
	}	
}

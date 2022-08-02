package br.com.digix.pokedigix.pokemon;

public class NivelInvalidoException extends Exception {

	public NivelInvalidoException() {
		super("O nivel deve ser entre 0 e 100.");
	}
}

package br.com.digix.pokedigix.tipo;

import br.com.digix.pokedigix.ataque.Categoria;

public class TipoInvalidaParaCategoriaException extends Exception {
	public TipoInvalidaParaCategoriaException(Categoria categoria) {
	super("Não pode ter um ataque de" + categoria.name() + "sem tipo" );
	}
}

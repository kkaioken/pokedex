package br.com.digix.pokedigix.treinador;

import br.com.digix.pokedigix.endereco.Endereco;
import br.com.digix.pokedigix.endereco.EnderecoBuilder;
import br.com.digix.pokedigix.personagem.LimiteDePokemonException;
import br.com.digix.pokedigix.pokemon.Pokemon;
import br.com.digix.pokedigix.pokemon.PokemonBuilder;

public class TreinadorBuilder {

	private String nome;
	private Endereco endereco;
	private Pokemon pokemon;

	public TreinadorBuilder() {
		this.nome = "kkaioken";
		this.endereco = new EnderecoBuilder().construir();
		this.pokemon = new PokemonBuilder().construir();
	}

	public Treinador construir() throws LimiteDePokemonException {
		return new Treinador(nome, endereco, pokemon);
	}

	public TreinadorBuilder comPokemonInicial(Pokemon pokemonInicial) {
		this.pokemon = pokemonInicial;
		return this;
	}
}

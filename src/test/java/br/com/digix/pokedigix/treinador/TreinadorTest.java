package br.com.digix.pokedigix.treinador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.digix.pokedigix.personagem.LimiteDePokemonException;
import br.com.digix.pokedigix.pokemon.Pokemon;
import br.com.digix.pokedigix.pokemon.PokemonBuilder;

public class TreinadorTest {
	@Test 
	public void deve_comecar_com_um_pokemon() throws LimiteDePokemonException {
		//Arrange
		int quantidadeDepokemonEsperada = 1;
		Pokemon pokemonInicial = new PokemonBuilder().construir();
		//Action
		Treinador treinador = new TreinadorBuilder().comPokemonInicial(pokemonInicial).construir();
		//Assert
		assertTrue(treinador.getPokemons().contains(pokemonInicial));
		assertEquals(quantidadeDepokemonEsperada, treinador.getPokemons().size());
	}

	@Test
	public void deve_poder_capturar_um_pokemon() throws LimiteDePokemonException {
		//Arrange
		int quantidadeDepokemonEsperada = 2;
		Pokemon pokemonACapturar = new PokemonBuilder().construir();

		Treinador treinador = new TreinadorBuilder().construir();
		//Action
		treinador.capturar(pokemonACapturar);
		//Assert
		assertTrue(treinador.getPokemons().contains(pokemonACapturar));
		assertEquals(quantidadeDepokemonEsperada, treinador.getPokemons().size());
	}

	@Test 
	public void nao_pode_ter_mais_que_seis_pokemons_ao_mesmo_tempo() throws LimiteDePokemonException {
		Treinador treinador = new TreinadorBuilder().construir();
		for(int i = 1; i <= 5; i++) {
			treinador.capturar(new PokemonBuilder().construir());
		}

		assertThrows(LimiteDePokemonException.class,() -> {
			treinador.capturar(new PokemonBuilder().construir());
		});
	}
}

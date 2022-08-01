package br.com.digix.pokedigix.pokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.digix.pokedigix.ataque.Ataque;
import br.com.digix.pokedigix.ataque.AtaqueBuilder;
import br.com.digix.pokedigix.tipo.Tipo;

@DataJpaTest
public class PokemonRepositoryTest {

	@Autowired
	private PokemonRepository pokemonRepository;

	@Test
	public void deve_salvar_um_pokemon() {
		String nome = "Pikachu";
		double altura = 0.6;
		double peso = 13.3;
		Genero genero = Genero.MASCULINO;
		int nivel = 5;
		int numeroPokedex = 25;
		int felicidade = 100;
		List<Tipo> tipos = new ArrayList<>();
		List<Ataque> ataques = new ArrayList<>();
		tipos.add(new Tipo("Eletrico"));
		Pokemon pikachu = new Pokemon(nome, peso, altura, genero, nivel, numeroPokedex, felicidade, tipos, ataques);

		pokemonRepository.save(pikachu);

		assertNotNull(pikachu.getId());

	}

	@Test
	public void deve_salvar_um_pokemon_com_um_tipo() {
		int quantidadeDeTiposEsperada = 1;
		Tipo eletrico = new Tipo("Eletrico");
		Pokemon pikachu = new PokemonBuilder().comTipo(eletrico).construir();
		pokemonRepository.save(pikachu);

		Pokemon pikachuRetornado = 
			pokemonRepository.findById(pikachu.getId()).get();

		assertNotNull(pikachuRetornado.getTipos());
		assertEquals(quantidadeDeTiposEsperada,
				pikachuRetornado.getTipos().size());
		assertTrue(pikachuRetornado.getTipos().contains(eletrico));

	}

	@Test 
	public void deve_salvar_um_pokemon_com_ataque() throws Exception {
		Ataque ataque = new AtaqueBuilder().construir();
		Pokemon pokemon = new PokemonBuilder().comAtaque(ataque).construir();

		pokemonRepository.save(pokemon);

		assertTrue(pokemon.getAtaques().contains(ataque));
	}
}
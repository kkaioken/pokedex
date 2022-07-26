package br.com.digix.pokedigix.pokemon;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.digix.pokedigix.tipo.Tipo;

@DataJpaTest
public class PokemonrepositoryTest {
	
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
			tipos.add( new Tipo("Eletrico"));
			Pokemon pikachu = new Pokemon(nome, peso, altura, genero, nivel, numeroPokedex, felicidade, tipos);

			pokemonRepository.save(pikachu);

			assertNotNull(pikachu.getId());
	
	}

}

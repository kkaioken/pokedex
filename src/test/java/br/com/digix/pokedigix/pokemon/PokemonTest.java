package br.com.digix.pokedigix.pokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.digix.pokedigix.ataque.Ataque;
import br.com.digix.pokedigix.tipo.Tipo;

public class PokemonTest {
	@Test
	public void deve_criar_um_pokemon() {
		String nome = "Pikachu";
		double altura = 0.6;
		double peso = 13.3;
		Genero genero = Genero.MASCULINO;
		int nivel = 5;
		int numeroPokedex = 25;
		int felicidade = 100;
		List<Tipo> tipos = new ArrayList<>();
		List<Ataque> ataques = new ArrayList<>();
		tipos.add( new Tipo("Eletrico"));


		Pokemon pikachu = new Pokemon(nome, altura, peso, genero, nivel, numeroPokedex, felicidade, tipos, ataques);

		assertEquals(nome, pikachu.getNome());
		assertEquals(altura, pikachu.getAltura());
		assertEquals(peso, pikachu.getPeso());
		assertEquals(genero, pikachu.getGenero());
		assertEquals(nivel, pikachu.getNivel());
		assertEquals(numeroPokedex, pikachu.getNumeroPokedex());
		assertEquals(felicidade, pikachu.getFelicidade());
		assertEquals(tipos, pikachu.getTipos());
	}

	@Test
	public void deve_cadastrar_um_tipo_para_o_pokemon() {
		Tipo tipo = new Tipo("eletrico");

		Pokemon pikachu = new PokemonBuilder().comTipo(tipo).construir();
	

		assertTrue(pikachu.getTipos().contains(tipo));

	}
}

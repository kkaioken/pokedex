package br.com.digix.pokedigix.pokemon;

import java.util.ArrayList;
import java.util.Collection;

import br.com.digix.pokedigix.ataque.Ataque;
import br.com.digix.pokedigix.tipo.Tipo;

public class PokemonBuilder {

	private String nome;
	private double altura;
	private double peso;
	private Genero genero;
	private int nivel;
	private int numeroPokedex;
	private int felicidade;
	private Collection<Tipo> tipos;
	private Collection<Ataque> ataques;

		public PokemonBuilder() {
		this.nome = "Pikachu";
		this.altura = 0.6;
		this.peso = 13.3;
		this.genero = Genero.MASCULINO;
		this.nivel = 5;
		this.numeroPokedex = 25;
		this.felicidade = 100;
		this.tipos = new ArrayList<>();
		this.ataques = new ArrayList<>();
	}

	public PokemonBuilder comAtaque(Ataque ataque) {
		this.ataques.add(ataque);
		return this;
	}

	public Pokemon construir() throws Exception {
		return new Pokemon(nome, altura, peso, genero, nivel, numeroPokedex, felicidade, tipos, ataques);
	}

	public PokemonBuilder comTipo(Tipo tipo) {
		this.tipos.add(tipo);
		return this;
	}

    public PokemonBuilder comNivel(int nivel) {
        this.nivel = nivel;
        return this;
    }

    public PokemonBuilder comFelicidade(int felicidade) {
        this.felicidade = felicidade;
        return this;
    }
}
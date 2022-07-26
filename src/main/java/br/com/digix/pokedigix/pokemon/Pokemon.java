package br.com.digix.pokedigix.pokemon;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import br.com.digix.pokedigix.ataque.Ataque;
import br.com.digix.pokedigix.tipo.Tipo;

@Entity
public class Pokemon {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 15, nullable = false)
	private String nome;

	@Column(nullable = false)
	private double peso;

	@Column(nullable = false)
	private double altura;

	@Column(length = 10, nullable = false)
	private Genero genero;

	@Column(nullable = false)
	private int numeroPokedex;

	@Column(nullable = false)
	private int felicidade;

	@Column(nullable =  false)
	private int nivel;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "pokemon_tipo",
			joinColumns = @JoinColumn(name = "pokemon_id"),
			inverseJoinColumns = @JoinColumn(name = "tipo_id"))
	private Collection<Tipo> tipos;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
		name = "pokemon_ataque",
		joinColumns = @JoinColumn(name = "ataque_id"))
	private Collection<Ataque> ataques;

	
	public Pokemon(String nome, double altura, double peso, Genero genero, int nivel, int numeroPokedex, int felicidade, Collection<Tipo> tipos, Collection<Ataque> ataques2) {
		this.nome = nome;
		this.peso = peso;
		this.altura = altura;
		this.genero = genero;
		this.nivel = nivel;
		this.numeroPokedex = numeroPokedex;
		this.felicidade = felicidade;
		this.tipos = tipos;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public int getNumeroPokedex() {
		return numeroPokedex;
	}
	public void setNumeroPokedex(int numeroPokedex) {
		this.numeroPokedex = numeroPokedex;
	}
	public int getFelicidade() {
		return felicidade;
	}
	public void setFelicidade(int felicidade) {
		this.felicidade = felicidade;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public Collection<Tipo> getTipos() {
		return tipos;
	}
}

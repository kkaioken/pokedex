package br.com.digix.pokedigix.pokemon;

public class Pokemon {


	private int id;

	private String nome;

	private int peso;

	private int altura;

	private String genero;

	private int nmrPokedex;

	private int idTreinador;
	
	public Pokemon(String nome, int peso, int altura, String genero, int nmrPokedex, int idTreinador) {
		this.nome = nome;
		this.peso = peso;
		this.altura = altura;
		this.genero = genero;
		this.nmrPokedex = nmrPokedex;
		this.idTreinador = idTreinador;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getNmrPokedex() {
		return nmrPokedex;
	}
	public void setNmrPokedex(int nmrPokedex) {
		this.nmrPokedex = nmrPokedex;
	}
	public int getIdTreinador() {
		return idTreinador;
	}
	public void setIdTreinador(int idTreinador) {
		this.idTreinador = idTreinador;
	}
}

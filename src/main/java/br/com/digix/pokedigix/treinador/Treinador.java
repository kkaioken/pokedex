package br.com.digix.pokedigix.treinador;
public class Treinador {
	private int id;
	private String nome;
	private int dinheiro;
	private int nivel;
	private int idIndereco;
	
	public Treinador(int id, String nome, int dinheiro, int nivel, int idIndereco) {
		this.id = id;
		this.nome = nome;
		this.dinheiro = dinheiro;
		this.nivel = nivel;
		this.idIndereco = idIndereco;
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
	public int getDinheiro() {
		return dinheiro;
	}
	public void setDinheiro(int dinheiro) {
		this.dinheiro = dinheiro;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public int getIdIndereco() {
		return idIndereco;
	}
	public void setIdIndereco(int idIndereco) {
		this.idIndereco = idIndereco;
	}
}
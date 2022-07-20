package br.com.digix.pokedigix.evolucao;

public class Evolucao {
	private String nomeDaEvolucao;
   	private boolean	pedra;
	private boolean nivel;
	public Evolucao(String nomeDaEvolucao, boolean pedra, boolean nivel) {
		this.nomeDaEvolucao = nomeDaEvolucao;
		this.pedra = pedra;
		this.nivel = nivel;
	}
	public String getNomeDaEvolucao() {
		return nomeDaEvolucao;
	}
	public void setNomeDaEvolucao(String nomeDaEvolucao) {
		this.nomeDaEvolucao = nomeDaEvolucao;
	}
	public boolean isPedra() {
		return pedra;
	}
	public void setPedra(boolean pedra) {
		this.pedra = pedra;
	}
	public boolean isNivel() {
		return nivel;
	}
	public void setNivel(boolean nivel) {
		this.nivel = nivel;
	}
}

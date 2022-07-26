package br.com.digix.pokedigix.ataque;

import br.com.digix.pokedigix.tipo.Tipo;

public class AtaqueBuilder {

	private String nome;
	private int forca;
	private int precisao;
	private int pA;
	private Categoria categoria;
	private String descricao;
	private Tipo tipo;

	public AtaqueBuilder() {
		this.nome = "Choque do Trovão";
		this.forca = 90;
		this.precisao = 100;
		this.pA = 80;
		this.descricao = "Tomale choqueee!!";
		this.categoria = Categoria.ESPECIAL;
		this.tipo = new Tipo("Normal");
	}

	public Ataque construir() {
		return new Ataque(nome, pA, categoria, precisao, descricao, forca, tipo);
	}

	public AtaqueBuilder comTipo(Tipo tipoEsperado) {
		tipo = tipoEsperado;
		return this;
	}
	
}

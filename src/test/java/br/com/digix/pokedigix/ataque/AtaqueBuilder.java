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
		this.forca = 90;
		this.precisao = 100;
		this.pA = 80;
		this.categoria = Categoria.ESPECIAL;
		this.nome = "Choque do Trovão";
		this.descricao = "Tomale choqueee!!";
		this.tipo = new Tipo("Normal");
	}
	
	public Ataque construir() throws Exception {
		if(this.categoria.equals(Categoria.EFEITO)) {
			return new Ataque(nome, pA, precisao, descricao);
		} else {
			return new Ataque(nome, pA, categoria, precisao, descricao, forca, tipo);
		}
	}

	public AtaqueBuilder comCategoriaEfeito() {
		this.categoria = Categoria.EFEITO;
		return this;
	}


	public AtaqueBuilder comForca(int forca) {
		this.forca = forca;
		return this;
	}

	public AtaqueBuilder comCategoria(Categoria categoria) {
		this.categoria = categoria;
		return this;
	}

	public AtaqueBuilder comTipo(Tipo tipoEsperado) {
		tipo = tipoEsperado;
		return this;
	}
	
	public AtaqueBuilder comPrecisao(int precisao) {
		this.precisao = precisao;
		return this;
	}


}

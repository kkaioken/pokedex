package br.com.digix.pokedigix.ataque;

import br.com.digix.pokedigix.tipo.TipoResponseDTO;

public class AtaqueResponseDTO {

	private Long id;
	private int forca;
	private int precisao;
	private String nome;
	private int PA;
	private Categoria categoria;
	private String descricao;
	private TipoResponseDTO tipo;

	public AtaqueResponseDTO(
			Long id,
			int forca,
			int precisao,
			String nome,
			int pA,
			Categoria categoria,
			String descricao,
			TipoResponseDTO tipo
			) {

		this.id = id;
		this.forca = forca;
		this.precisao = precisao;
		this.nome = nome;
		this.PA = pA;
		this.categoria = categoria;
		this.descricao = descricao;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getForca() {
		return forca;
	}

	public void setForca(int forca) {
		this.forca = forca;
	}

	public int getPrecisao() {
		return precisao;
	}

	public void setPrecisao(int precisao) {
		this.precisao = precisao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPA() {
		return PA;
	}

	public void setPA(int pA) {
		PA = pA;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoResponseDTO getTipo() {
		return tipo;
	}

	public void setTipo(TipoResponseDTO tipo) {
		this.tipo = tipo;
	}

}

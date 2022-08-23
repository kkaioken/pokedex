package br.com.digix.pokedigix.ataque;

public class AtaqueRequestDTO {
	
	private int forca;
	private int precisao;
	private String nome;
	private int PA;
	private Categoria categoria;
	private String descricao;
	private Long tipoId;
	
	
	public AtaqueRequestDTO(int forca, int precisao, String nome, int pA, Categoria categoria, String descricao, Long tipoId) {
		this.forca = forca;
		this.precisao = precisao;
		this.nome = nome;
		PA = pA;
		this.categoria = categoria;
		this.descricao = descricao;
		this.tipoId = tipoId;
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
	public Long getTipoId() {
		return tipoId;
	}
	public void setTipoId(Long tipoId) {
		this.tipoId = tipoId;
	}

}

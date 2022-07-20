package br.com.digix.pokedigix.ataque;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ataque {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private int forca;
	
	@Column(nullable = false)
	private int precisao;

	@Column(nullable = false, length = 25)
	private String nome;

	@Column(nullable = false)
	private int PA;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Categoria categoria;

	@Column(nullable = false)
	private String descricao;

	public Ataque(String nome, int pA, Categoria categoria, int precisao, String descricao, int forca) {
		this.nome = nome;
		this.PA = pA;
		this.categoria = categoria;
		this.precisao = precisao;
		this.descricao = descricao;
		this.forca = forca;
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

	public int getPrecisao() {
		return precisao;
	}

	public void setPrecisao(int precisao) {
		this.precisao = precisao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getForca() {
		return forca;
	}

	public void setForca(int forca) {
		this.forca = forca;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
}

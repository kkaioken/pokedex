package br.com.digix.pokedigix.ataque;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import br.com.digix.pokedigix.pokemon.Pokemon;
import br.com.digix.pokedigix.tipo.Tipo;
import br.com.digix.pokedigix.tipo.TipoInvalidaParaCategoriaException;

@Entity
public class Ataque {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
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

	@ManyToOne
	private Tipo tipo;

	@ManyToMany(mappedBy = "ataques")
	private Collection<Pokemon> pokemons;

	public Ataque(String nome,
			int pA,
			Categoria categoria,
			int precisao,
			String descricao,
			int forca,
			Tipo tipo) throws Exception {

		validarPrecisao(precisao);
		validarForca(categoria, forca);
		validarTipo(categoria, tipo);
		this.nome = nome;
		this.PA = pA;
		this.categoria = categoria;
		this.precisao = precisao;
		this.descricao = descricao;
		this.forca = forca;
		this.tipo = tipo;
	}

	private void validarTipo(Categoria categoria, Tipo tipo) throws Exception {
		if (!categoria.equals(Categoria.EFEITO) && tipo == null) {
			throw new TipoInvalidaParaCategoriaException(categoria);
		}
	}

	private void validarForca(Categoria categoria, int forca) throws Exception {
		if (!categoria.equals(Categoria.EFEITO) && forca <= 0) {
			throw new ForcaInvalidaParaCategoriaException(categoria);
		}
	}

	public Ataque(String nome, int pA, int precisao, String descricao) throws Exception {
		validarPrecisao(precisao);
		this.precisao = precisao;
		this.PA = pA;
		this.nome = nome;
		this.descricao = descricao;
		this.categoria = Categoria.EFEITO;
	}

	private void validarPrecisao(int precisao) throws Exception {
		if (precisao < 0 || precisao > 100) {
			throw new PrecisaoInvalidaException();

		}
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

	public Tipo getTipo() {
		return tipo;
	}

	public Collection<Pokemon> getPokemons() {
		return pokemons;
	}
}

package br.com.digix.pokedigix.personagem;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;


import br.com.digix.pokedigix.endereco.Endereco;
import br.com.digix.pokedigix.pokemon.Pokemon;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Personagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable =  false)
	private String nome;
	@ManyToOne
	private Endereco endereco;
	@OneToMany
	protected Collection<Pokemon> pokemons;

	public Personagem(String nome, Endereco endereco) {
		this.nome = nome;	
		this.endereco = endereco;
		this.pokemons = new ArrayList<>();
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

    public Endereco getEndereco() {
        return endereco;
    }

    public Collection<Pokemon> getPokemons() {
        return pokemons;
    }
}
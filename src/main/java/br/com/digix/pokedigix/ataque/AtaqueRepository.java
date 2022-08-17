package br.com.digix.pokedigix.ataque;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;


public interface AtaqueRepository extends CrudRepository<Ataque, Long> {
	
	Collection<Ataque> findByTipoContaining(String nome);
	Collection<Ataque> findByCategoria(Categoria categoria);
}

package br.com.digix.pokedigix.ataque;

import java.util.Collection;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;

import org.springframework.data.repository.CrudRepository;

import br.com.digix.pokedigix.tipo.Tipo;

public interface AtaqueRepository extends CrudRepository<Ataque, Long> {
	
	Collection<Ataque> findByTipo(Tipo tipo);
	Collection<Ataque> findbyCategoria(Categoria categoria);
}

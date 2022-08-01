package br.com.digix.pokedigix.ataque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.digix.pokedigix.tipo.Tipo;
import br.com.digix.pokedigix.tipo.TipoRepository;

@DataJpaTest
public class AtaqueRepositoryTest {

	@Autowired
	private AtaqueRepository ataqueRepository;

	@Autowired 
	private TipoRepository  tipoRepository;

	@Test
	public void deve_salvar_um_ataque() throws Exception {
		String nome = "Choque do Trovão";
		int forca = 90;
		int precisao = 100;
		int pA = 80;
		String descricao = "Tomale choqueee!!";
		Categoria categoria = Categoria.ESPECIAL;
		Tipo tipo = new Tipo("Eletrico");

		Ataque ataque = new Ataque(nome, pA, categoria, precisao, descricao, forca, tipo);
		
		ataqueRepository.save(ataque);

		assertNotNull(ataque.getId());
	}

	@Test
	public void deve_salvar_um_tipo_para_um_ataque() throws Exception {
		int pA = 80;
		int forca = 90;
		int precisao = 100;
		String nome = "Choque do Trovão";
		Tipo tipo = new Tipo("Eletrico");
		String descricao = "Tomale choqueee!!";
		Categoria categoria = Categoria.ESPECIAL;		
		Ataque ataque = new Ataque(nome, pA, categoria, precisao, descricao, forca, tipo);
		tipoRepository.save(tipo); 
		ataqueRepository.save(ataque);

		Ataque ataqueRetornado = ataqueRepository.findById(ataque.getId()).get();

		assertEquals(tipo.getNome(), ataqueRetornado.getTipo().getNome());
		assertNotNull(ataqueRetornado.getTipo().getId());
	}


}
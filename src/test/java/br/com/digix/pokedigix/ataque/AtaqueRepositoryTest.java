package br.com.digix.pokedigix.ataque;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class AtaqueRepositoryTest {

	@Autowired
	private AtaqueRepository ataqueRepository;

	@Test
	public void deve_salvar_um_ataque() {
		String nome = "Choque do Trovão";
		int forca = 90;
		int precisao = 100;
		int pA = 80;
		String descricao = "Tomale choqueee!!";
		Categoria categoria = Categoria.ESPECIAL;

		Long idEsperado = 1L;
		Ataque ataque = new Ataque(nome, pA, categoria, precisao, descricao, forca);
		ataqueRepository.save(ataque);

		assertEquals(idEsperado, ataque.getId());
	}

}
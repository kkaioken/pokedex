package br.com.digix.pokedigix.ataque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.digix.pokedigix.tipo.Tipo;
import br.com.digix.pokedigix.tipo.TipoInvalidaParaCategoriaException;

public class AtaqueTest {
	@Test
	public void deve_criar_um_ataque() throws Exception {
		// Arrange
		String nome = "Choque do Trovão";
		int forca = 90;
		int precisao = 100;
		int pA = 80;
		String descricao = "Tomale choqueee!!";
		Categoria categoria = Categoria.ESPECIAL;
		Tipo tipo = new Tipo("Normal");
		// Act
		Ataque ataque = new Ataque(nome, pA, categoria, precisao, descricao, forca, tipo);

		// Assert
		assertEquals(nome, ataque.getNome());
		assertEquals(forca, ataque.getForca());
		assertEquals(precisao, ataque.getPrecisao());
		assertEquals(pA, ataque.getPA());
		assertEquals(descricao, ataque.getDescricao());
		assertEquals(categoria, ataque.getCategoria());
	}

	@Test
	public void deve_ser_obrigatorio_informar_um_tipo() throws Exception {
		Tipo tipoEsperado = new Tipo("Normal");
		Ataque ataque = new AtaqueBuilder().comTipo(tipoEsperado).construir();

		assertEquals(tipoEsperado, ataque.getTipo());
	}

	@Test
	public void nao_deve_ter_precisao_menor_que_zero() throws Exception {
		int precisao = -1;

		assertThrows(PrecisaoInvalidaException.class, () -> {
			new AtaqueBuilder().comPrecisao(precisao).construir();
		});

		assertThrows(PrecisaoInvalidaException.class, () -> {
			new AtaqueBuilder().comPrecisao(precisao).comCategoriaEfeito().construir();
		});

	}

	@Test
	public void nao_deve_ter_precisao_maior_que_cem() throws Exception {
		int precisao = 101;

		assertThrows(PrecisaoInvalidaException.class, () -> {
			new AtaqueBuilder().comPrecisao(precisao).construir();
		});

		assertThrows(PrecisaoInvalidaException.class, () -> {
			new AtaqueBuilder().comPrecisao(precisao).comCategoriaEfeito().construir();
		});
	}

	@Test
	public void deve_poder_ter_acuracia_igual_a_zero() throws Exception {
		int precisaoEsperada = 0;

		Ataque ataque = new AtaqueBuilder().comPrecisao(precisaoEsperada).construir();

		assertEquals(precisaoEsperada, ataque.getPrecisao());
	}

	@Test
	public void nao_deve_ter_forca_nem_tipo_quando_a_categoria_for_efeito() throws Exception {
		Categoria categoria = Categoria.EFEITO;
		int forca = 0;
		Tipo tipo = null;

		Ataque ataque = new AtaqueBuilder()
				.comCategoriaEfeito()
				.construir();

		assertEquals(categoria, ataque.getCategoria());
		assertEquals(forca, ataque.getForca());
		assertEquals(tipo, ataque.getTipo());

	}

	@Test
	public void nao_deve_ter_ataque_de_categoria_fisica_sem_forca() throws Exception {
		Categoria categoria = Categoria.FISICO;
		int forca = 0;

		assertThrows(ForcaInvalidaParaCategoriaException.class, () -> {
			new AtaqueBuilder().comForca(forca).comCategoria(categoria).construir();
		});
	}

	@Test
	public void nao_deve_ter_ataque_de_categoria_fisica_sem_tipo() throws Exception {
		Categoria categoria = Categoria.FISICO;
		Tipo tipo = null;

		assertThrows(TipoInvalidaParaCategoriaException.class, () -> {
			new AtaqueBuilder().comTipo(tipo).comCategoria(categoria).construir();
		});
	}

	@Test
	public void nao_deve_ter_ataque_de_categoria_especial_sem_forca() throws Exception {
		Categoria categoria = Categoria.ESPECIAL;
		int forca = 0;

		assertThrows(ForcaInvalidaParaCategoriaException.class, () -> {
			new AtaqueBuilder().comForca(forca).comCategoria(categoria).construir();
		});
	}

	@Test
	public void nao_deve_ter_ataque_de_categoria_especial_sem_tipo() throws Exception {
		Categoria categoria = Categoria.ESPECIAL;
		Tipo tipo = null;

		assertThrows(TipoInvalidaParaCategoriaException.class, () -> {
			new AtaqueBuilder().comTipo(tipo).comCategoria(categoria).construir();
		});
	}
}
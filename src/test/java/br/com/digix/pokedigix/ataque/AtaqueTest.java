package br.com.digix.pokedigix.ataque;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.digix.pokedigix.tipo.Tipo;

public class AtaqueTest {
	@Test
	void deve_criar_um_ataque() {
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
	public void deve_ser_obrigatorio_informar_um_tipo() {
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
		assertEquals(tipo, ataque.getTipo());
	}
}
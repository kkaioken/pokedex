package br.com.digix.pokedigix.tipo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TipoTest {
	@Test
	public void deve_poder_criar_um_tipo() {
		//Arrange		
		String nome = "Fogo";

		//Act
		Tipo tipo = new Tipo(nome);

		//Assert
		assertEquals(nome, tipo.getNome());
	}
}

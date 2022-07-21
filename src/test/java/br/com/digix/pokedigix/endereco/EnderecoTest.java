package br.com.digix.pokedigix.endereco;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EnderecoTest {
	@Test
	void deve_criar_um_endereco() {
		//Arrange
		String cidade = "Pallit";
		String regiao = "Kanto";
		//Act
		Endereco endereco = new Endereco(cidade, regiao);

		//Assert
		assertEquals(cidade, endereco.getCidade());
		assertEquals(regiao, endereco.getRegiao());
	}
}

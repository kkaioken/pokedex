package br.com.digix.pokedigix.endereco;


public class EnderecoBuilder {

	private String cidade;
	private String regiao;

	public EnderecoBuilder() {
		this.regiao = "Kanto";
		this.cidade = "Pallet";
	}

	public Endereco construir() {
		return new Endereco(cidade, regiao);
	}

}

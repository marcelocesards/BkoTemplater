package model;

public class Retorno {
	private String nome;
	private String dataType;
	
	public Retorno(String nome, String dataType) {
		this.nome = nome;
		this.dataType = dataType;
	}

	public String getNome() {
		return nome;
	}

	public String getDataType() {
		return dataType;
	}
}

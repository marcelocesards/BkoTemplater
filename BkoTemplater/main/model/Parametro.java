package model;

public class Parametro {
	private String nome;
	private String modo;
	private String dataType;
	private int precisao;
	private String defaultValue;

	public Parametro(String nome, String dataType, int precisao, String modo, String defaultValue) {
		super();
		this.nome = nome;
		this.modo = modo;
		this.dataType = dataType;
		this.precisao = precisao;
		this.setDefaultValue(defaultValue);
	}

	public String getNome() {
		return nome;
	}

	public String getModo() {
		return modo;
	}

	public String getData_type() {
		return dataType;
	}

	public int getPrecisao() {
		return precisao;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

}

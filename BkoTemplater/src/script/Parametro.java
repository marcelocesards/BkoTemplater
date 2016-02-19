package script;

public class Parametro {
	private String nome;
	private String dataType;
	private int precisao;
	private String modo;

	public Parametro(String nome, String dataType, int precisao, String modo) {
		super();
		this.nome = nome;
		this.dataType = dataType;
		this.precisao = precisao;
		this.modo = modo;
	}

	public String getData_type() {
		return dataType;
	}

	public int getPrecisao() {
		return precisao;
	}

	public String getModo() {
		return modo;
	}

	public String getNome() {
		return nome;
	}
}

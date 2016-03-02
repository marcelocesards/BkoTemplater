package model;

public class Parametro {
	private String nome;
	private String modo;
	private String dataType;
	private int precisao;
	private String defaultValue;

	public Parametro(String nome, String modo, String dataType, int precisao, String defaultValue) {
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
	
	public String parametroToString(){
		StringBuilder parametroTexto = new StringBuilder();
		
		parametroTexto.append(this.getNome());

		if (this.getModo() != null) {
			parametroTexto.append(" ");
			parametroTexto.append(this.getModo());

		}

		parametroTexto.append(" ");
		parametroTexto.append(this.getData_type());

		if (!this.getDefaultValue().isEmpty()) {
			parametroTexto.append(" default ");
			parametroTexto.append(this.getDefaultValue());
		}	
		return parametroTexto.toString();
	}
	
	public String campoParametroToString(){
		StringBuilder parametroTexto = new StringBuilder();
		
		parametroTexto.append(this.getNome());

		parametroTexto.append(" ");
		parametroTexto.append(this.getData_type());
		
		if (this.getPrecisao() != 0) {
			parametroTexto.append("(");
			parametroTexto.append(this.getPrecisao());
			parametroTexto.append(")");
		}
		return parametroTexto.toString();
	}
	
	public String ChamadaParametroToString(){
		StringBuilder parametroTexto = new StringBuilder();
		
		parametroTexto.append(this.getNome());

			parametroTexto.append(" => ");
			
			parametroTexto.append("v_bko." + this.getNome());
		return parametroTexto.toString();
	}

}

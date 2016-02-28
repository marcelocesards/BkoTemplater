package model;

import java.util.List;

public abstract class Metodo {
	private String nome;
	private List<Parametro> parametros;
	private String body;
	private Parametro retorno;
	
	public Metodo(String nome, List<Parametro> parametros, String body, Parametro retorno) {
		this.nome = nome;
		this.parametros = parametros;
		this.setBody(body);
		this.retorno = retorno;
	}

	public List<Parametro> getParametros() {
		return parametros;
	}

	public void addParametro(Parametro parametro) {
		this.parametros.add(parametro);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}

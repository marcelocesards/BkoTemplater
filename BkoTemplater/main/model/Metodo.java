package model;

import java.util.List;

public abstract class Metodo {
	private String nome;
	private List<Parametro> parametros;
	private String body;
	private Parametro retorno;
	private int indentacaoChamadaParametro;

	public Metodo(String nome, List<Parametro> parametros, String body, Parametro retorno) {
		this.nome = nome;
		this.parametros = parametros;
		this.setBody(body);
		this.setRetorno(retorno);
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

	public Parametro getRetorno() {
		return retorno;
	}

	public void setRetorno(Parametro retorno) {
		this.retorno = retorno;
	}

	public String getListaParametrosToString() {
		StringBuilder parametrosTexto = new StringBuilder();
		int quantidadeParametro = 0;

		for (Parametro parametro : parametros) {
			quantidadeParametro++;
			if (quantidadeParametro > 1) {
				parametrosTexto.append(",\n");
			}

			parametrosTexto.append("    ");
			parametrosTexto.append(parametro.parametroToString());
		}
		return parametrosTexto.toString();
	}

	public String getMetodoToString() {
		StringBuilder metodoTexto = new StringBuilder();

		metodoTexto.append("  ");
		metodoTexto.append(getTipoMetodo());

		metodoTexto.append(" ");
		metodoTexto.append(getNome());
		metodoTexto.append("(\n");

		metodoTexto.append(this.getListaParametrosToString());

		metodoTexto.append(") ");
		
		metodoTexto.append(getFinalMetodo());

		metodoTexto.append("\n  ");
		metodoTexto.append(getBody());

		return metodoTexto.toString();
	}

	private String getTipoMetodo() {
		if (this.retorno.getNome().isEmpty()) {
			return "PROCEDURE";
		}
		return "FUNCTION";
	}

	private String getFinalMetodo() {
		if (this.retorno.getNome().isEmpty()) {
			return "IS";
		}
		return "return " + retorno.getData_type() + " IS";
	}
	
	public String getChamadaMetodo(){
		StringBuilder parametrosTexto = new StringBuilder();
		int quantidadeParametro = 0;
		indentacaoChamadaParametro = 10;
		
		parametrosTexto.append("        ");
		
		parametrosTexto.append(getRetornoChamada());
		
		parametrosTexto.append(getNome()+"(\n");

		for (Parametro parametro : parametros) {
			quantidadeParametro++;
			if (quantidadeParametro > 1) {
				parametrosTexto.append(",\n");
			}

			parametrosTexto.append(getIndentacaoToString(indentacaoChamadaParametro));
			parametrosTexto.append(parametro.ChamadaParametroToString());			
		}
		parametrosTexto.append(");");
		return parametrosTexto.toString();
	}
	
	private String getIndentacaoToString(int indentacaoInt) {
		StringBuilder indentacao = new StringBuilder();
		for (int i = 0; i < indentacaoInt; i++) {
			indentacao.append(" ");
		}
		return indentacao.toString();
	}

	private String getRetornoChamada() {
		if (this.retorno.getNome().isEmpty()) {
			return "";
		}
		indentacaoChamadaParametro += (9 + retorno.getNome().length());
		return "v_bko." + retorno.getNome() + " = ";
	}
	
	public String getComandoSalvar(){
		StringBuilder parametrosTexto = new StringBuilder();
		indentacaoChamadaParametro = 10;
						
		for (Parametro parametro : parametros) {
			parametrosTexto.append("           ");
			parametrosTexto.append(parametro.comandoSalvarParametroToString());		
			parametrosTexto.append(",\n");
		}
		return parametrosTexto.toString();
	}
}

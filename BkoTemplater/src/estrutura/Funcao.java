package estrutura;

import java.util.List;

public class Funcao extends Metodo {
	private Parametro retorno;
	
	public Funcao(String nome, List<Parametro> parametros, String body, Parametro retorno) {
		super(nome, parametros, body);		
		this.retorno = retorno;
	}

	public Parametro getRetorno() {
		return retorno;
	}

	public void setRetorno(Parametro retorno) {
		this.retorno = retorno;
	}
}

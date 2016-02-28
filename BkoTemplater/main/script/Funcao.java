package script;

import java.util.List;

import model.Metodo;
import model.Parametro;

public class Funcao extends Metodo {
	private Parametro retorno;

	public Funcao(String nome, List<Parametro> parametros, String body, Parametro retorno) {
		super(nome, parametros, body, retorno);
	}

	public Parametro getRetorno() {
		return retorno;
	}

	public void setRetorno(Parametro retorno) {
		this.retorno = retorno;
	}
}

package factory;

import java.util.List;

import model.Metodo;
import model.Parametro;
import script.Funcao;
import script.Procedimento;

public class MetodoFactory {

	public Metodo getMetodo(String nome, String modo, List<Parametro> parametros, String body, Parametro retorno) {
		if (retorno == null) {
			return new Procedimento(nome, parametros, body);
		}
		return new Funcao(nome, parametros, body, retorno);
	}
}

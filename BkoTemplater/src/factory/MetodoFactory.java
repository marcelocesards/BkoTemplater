package factory;

import java.util.List;

import estrutura.Funcao;
import estrutura.Metodo;
import estrutura.Parametro;
import estrutura.Procedimento;

public class MetodoFactory {

	public Metodo getMetodo(String nome, String modo, List<Parametro> parametros, String body, Parametro retorno) {
		if (retorno == null) {
			return new Procedimento(nome, parametros, body);
		}
		return new Funcao(nome, parametros, body, retorno);
	}
}

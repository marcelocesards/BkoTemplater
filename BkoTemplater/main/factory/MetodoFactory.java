package factory;

import java.util.List;

import model.Metodo;
import model.Parametro;
import script.Funcao;

public class MetodoFactory {

	public Metodo getMetodo(String nome, String modo, List<Parametro> parametros, String body, Parametro retorno) {
		return new Funcao(nome, parametros, body, retorno);
	}
}

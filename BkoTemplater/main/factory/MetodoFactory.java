package factory;

import java.util.List;

import model.Metodo;
import model.Parametro;
import script.MetodoCriado;

public class MetodoFactory {

	public Metodo getMetodo(String nome, String modo, List<Parametro> parametros, String body, Parametro retorno) {
		return new MetodoCriado(nome, parametros, body, retorno);
	}
}

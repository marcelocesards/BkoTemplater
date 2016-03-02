package script;

import java.util.List;

import model.Metodo;
import model.Parametro;

public class Funcao extends Metodo {
	public Funcao(String nome, List<Parametro> parametros, String body, Parametro retorno) {
		super(nome, parametros, body, retorno);
	}
}

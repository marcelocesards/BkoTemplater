package script;

import java.util.List;

import model.Metodo;
import model.Parametro;

public class Procedimento extends Metodo {

	public Procedimento(String nome, List<Parametro> parametros, String body) {
		super(nome, parametros, body);
	}

}

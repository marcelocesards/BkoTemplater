package factory;

import model.Parametro;

public class ParametroFactory {

	public Parametro getParametro(String nome, String modo, String dataType, int precisao, String defaultValue) {
		return new Parametro(nome, dataType, precisao, modo, defaultValue);
	}
}

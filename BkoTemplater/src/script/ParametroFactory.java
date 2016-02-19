package script;

public class ParametroFactory {

	public Parametro getParametro(String nome, String modo, String dataType,  int precisao) {
		return new Parametro(nome, dataType, precisao, modo);
	}
}

package script;

import java.util.List;

public abstract class Metodo {
	private List<Parametro> parametros;
	private String body;

	public List<Parametro> getParametros() {
		return parametros;
	}

	public void addParametro(Parametro parametro) {
		this.parametros.add(parametro);
	}
}

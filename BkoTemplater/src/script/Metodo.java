package script;

import java.util.List;

public abstract class Metodo {
	private List<Parametro> parametros;

	public List<Parametro> getParametros() {
		return parametros;
	}

	public void setParametros(List<Parametro> parametros) {
		this.parametros = parametros;
	}
}

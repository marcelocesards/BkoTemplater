package script;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExtratorParametroMetodo {
	String metodo;

	public ExtratorParametroMetodo(String metodo) {
		this.metodo = metodo;
	}

	public List<String> getListNome() {
		List<String> nomes = new ArrayList<>();

		String parametrosString = metodo.substring(metodo.indexOf("(") + 1, metodo.indexOf(")") - 1).toLowerCase()
				.trim();
		parametrosString = parametrosString.replaceAll("\\n", " ");

		if (parametrosString.trim().isEmpty()) {
			nomes.add("sem parametros");
			return nomes;
		}

		ArrayList<String> listaParametros = new ArrayList<String>(Arrays.asList(parametrosString.split(",")));

		for (String parametro : listaParametros) {
			parametro = parametro.trim();

			parametro = parametro.replaceAll("(\\s)+", ",");

			nomes.add(parametro.substring(0, parametro.indexOf(",")));
		}
		return nomes;
	}

	public Map<String, String> getListModo() {
		Map<String, String> modo = new HashMap<>();
		return modo;
	}
}

package script;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExtratorParametroMetodo {
	String metodo;
	ArrayList<String> listaParametros;
	String regiaoDeclaracaoMetodo;
	String regiaoParametros;

	public ExtratorParametroMetodo(String metodo) {
		this.metodo = metodo;
		setRegiaoParametros();
		if (temParametro()){
			setListaParametro();
		}	
	}

	private void setRegiaoParametros() {
		String metodoSemQuebraDeLinha = metodo.replaceAll("\\n", " ").toLowerCase();
		regiaoDeclaracaoMetodo = metodoSemQuebraDeLinha.substring(0, metodoSemQuebraDeLinha.indexOf(" is ")).trim();
		
		if (temParametro())
			regiaoParametros = regiaoDeclaracaoMetodo
					.substring(regiaoDeclaracaoMetodo.indexOf("(") + 1, regiaoDeclaracaoMetodo.indexOf(")")).trim();
	}
	
	public boolean temParametro() {
		return regiaoDeclaracaoMetodo.contains("(") && regiaoDeclaracaoMetodo.contains(")");		
	}
	
	private void setListaParametro() {
		listaParametros = new ArrayList<String>(Arrays.asList(regiaoParametros.split(",")));		
	}

	public List<String> getListNome() {		
		List<String> nomes = new ArrayList<>();
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

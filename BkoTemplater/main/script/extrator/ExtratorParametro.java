package script.extrator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExtratorParametro extends Extrator{
	protected String regiaoParametros;	
	protected ArrayList<String> listaParametros;
	protected List<String> nomes;
	protected Map<String, String> modo;
	protected Map<String, String> parametroType;
	protected Map<String, String> valorDefault;
	
	public List<String> getListNome() {		
		return nomes;
	}

	public Map<String, String> getMapModo() {
		return modo;
	}
	
	public Map<String, String> getParametroType() {
		return parametroType;
	}
	
	public Map<String, String> getValorDefault() {
		return valorDefault;
	}

	public ExtratorParametro(String metodo) {
		super(metodo);		
		
		setRegiaoParametros();	
		
		if (temParametro()){
			setListaParametro();
			nomes = new ArrayList<>();
			modo = new HashMap<String, String>();
			parametroType = new HashMap<String, String>();
			valorDefault = new HashMap<String, String>();
			
			iteraPelosParametros();
		}			
	}

	private void setRegiaoParametros() {		
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
	
	private void iteraPelosParametros(){
		for (String parametro : listaParametros) {
			String nomeParametroAtual = extraiNome(parametro);
			extraiModoEType(parametro, nomeParametroAtual);
			extraiDefault(parametro, nomeParametroAtual);
		}
	}

	private String extraiNome(String parametro) {
		parametro = convertEspacosParaVirgula(parametro);
		String nomeParametroAtual = parametro.substring(0, parametro.indexOf(","));
		nomes.add(nomeParametroAtual);
		return nomeParametroAtual;
	}
	
	private String convertEspacosParaVirgula(String parametro) {
		parametro = parametro.trim();
		parametro = parametro.replaceAll("(\\s)+", ",");
		return parametro;
	}

	private void extraiModoEType(String parametro, String nomeParametroAtual) {
		parametro = convertEspacosParaVirgula(parametro);
		parametro = unificaInOutNocopyOuInsereIn(parametro);
		String parametroSemNome = removeValorAntesDaVirgula(parametro); 	
		
		extraiModo(nomeParametroAtual, parametroSemNome);		
		extraiType(nomeParametroAtual, parametroSemNome);	
	}

	private void extraiType(String nomeParametroAtual, String parametroSemNome) {
		String parametroSemNomeEModo = removeValorAntesDaVirgula(parametroSemNome); 
		parametroSemNomeEModo = removeDefault(parametroSemNomeEModo);
		parametroType.put(nomeParametroAtual, parametroSemNomeEModo);	
	}

	private void extraiModo(String nomeParametroAtual,String parametroSemNome) {
		parametroSemNome = separaInOutNocopyOuInsereIn(parametroSemNome);
		modo.put(nomeParametroAtual, parametroSemNome.substring(0,parametroSemNome.indexOf(",")));
	}

	private String separaInOutNocopyOuInsereIn(String parametro) {
		return parametro.replace("inoutnocopy", "in out nocopy").replace("inout", "in out");
    }
	
	private String removeDefault(String parametroSemNomeEModo) {
		if(parametroSemNomeEModo.contains(","))
			return parametroSemNomeEModo.substring(0, parametroSemNomeEModo.indexOf(","));
		
		return parametroSemNomeEModo;
	}

	private String removeValorAntesDaVirgula(String parametro) {
		StringBuilder parametroNew = new StringBuilder(parametro);
		return parametroNew.delete(0, parametroNew.indexOf(",")+1).toString();
	}

	private String unificaInOutNocopyOuInsereIn(String parametro) {
		if (parametro.contains(",in,") || parametro.contains(",out,")) {
			parametro = parametro.replace("in,out,nocopy", "inoutnocopy");
			return parametro.replace(",in,out,", ",inout,");
		} 
			StringBuilder parametroNew = new StringBuilder(parametro);
			parametroNew.insert(parametroNew.indexOf(","), ",in");
			return parametroNew.toString();			
	}
	
	private void extraiDefault(String parametro, String nomeParametroAtual) {
		if (parametro.contains("default"))
		valorDefault.put(nomeParametroAtual, parametro.substring(parametro.indexOf("default")+8));
	}
}

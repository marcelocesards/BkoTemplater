package script.extrator;

public class Extrator {
	protected String metodo;
	protected String regiaoDeclaracaoMetodo;

	public String getRegiaoDeclaracaoMetodo() {
		return regiaoDeclaracaoMetodo;
	}

	public Extrator(String metodo) {
		this.metodo = metodo;
		setRegiaoDeclaracao();
	}
	
	private void setRegiaoDeclaracao() {
		String metodoSemQuebraDeLinha = converteQuebraParaEspaco(metodo.toLowerCase());
		metodoSemQuebraDeLinha = convertAsToIs(metodoSemQuebraDeLinha);
		metodoSemQuebraDeLinha = removeEspacosDuplicados(metodoSemQuebraDeLinha);
		regiaoDeclaracaoMetodo = metodoSemQuebraDeLinha.substring(0, metodoSemQuebraDeLinha.indexOf(" is ")).trim();	
	}
	
	private String converteQuebraParaEspaco(String metodoComQuebraEEspacos){
		return metodoComQuebraEEspacos.replaceAll("\\n", " ");
	}
	
	private String removeEspacosDuplicados(String metodoSemQuebraDeLinha) {		
		return metodoSemQuebraDeLinha.replaceAll("(\\s)+", " ");
	}

	private String convertAsToIs(String metodoSemQuebraDeLinha) {
		return metodoSemQuebraDeLinha.replaceAll(" as "," is ");
	}
	
	public String getNomeMetodo(){
		return regiaoDeclaracaoMetodo.substring(regiaoDeclaracaoMetodo.indexOf(" "), getIndiceFimNome(regiaoDeclaracaoMetodo)).trim();
	}
	
	private int getIndiceFimNome(String regiaoDeclaracao) {
		return regiaoDeclaracao.contains("(") ? regiaoDeclaracao.indexOf("(")
				: regiaoDeclaracao.indexOf(" is ");
	}
}

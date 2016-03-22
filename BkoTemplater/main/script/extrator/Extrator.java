package script.extrator;

public class Extrator {
	protected String metodo;
	protected String regiaoDeclaracaoMetodo;

	public Extrator(String metodo) {
		this.metodo = metodo;
		setRegiaoDeclaracao();
	}
	
	private void setRegiaoDeclaracao() {
		String metodoSemQuebraDeLinha = metodo.replaceAll("\\n", " ").toLowerCase();
		metodoSemQuebraDeLinha = convertAsToIs(metodoSemQuebraDeLinha);
		regiaoDeclaracaoMetodo = metodoSemQuebraDeLinha.substring(0, metodoSemQuebraDeLinha.indexOf(" is ")).trim();	
	}
	
	private String convertAsToIs(String metodoSemQuebraDeLinha) {
		return metodoSemQuebraDeLinha.replaceAll(" as "," is ");
	}
}

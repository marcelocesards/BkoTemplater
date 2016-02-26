package script;

public class GeradorScript implements Gerador{
	private int inicioRegiaoDeclaracao;
	private int fimRegiaoDeclaracao;
	private int inicioRegiaoInvocacao;
	private int fimRegiaoInvocacao;	
	private Script script;
	private StringBuilder textoScript;

	@Override
	public void gerarScript(Script script) {
		this.script = script;
		textoScript = new StringBuilder();
		textoScript.append(this.script.getScript().toString()); 
		//System.out.println(textoScript.append("Marcelo").toString());
		script = this.script;
	}
}

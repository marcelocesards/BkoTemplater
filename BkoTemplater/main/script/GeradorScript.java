package script;

import model.Metodo;

public class GeradorScript implements Gerador {
	private int inicioRegiaoDeclaracao;
	private int fimRegiaoDeclaracao;
	private int inicioRegiaoInvocacao;
	private int fimRegiaoInvocacao;
	private int inicioRegiaoSave;
	private int fimRegiaoSave;
	private Script script;
	private StringBuilder textoScript;

	@Override
	public void gerarScript(Script script) {
		this.script = script;
		textoScript = new StringBuilder();
		textoScript.append(this.script.getScript().toString());

		insereMetodos();

		insereChamadaMetodos();
		
		insereSaveCampos();

		this.script.atualizaTemplateText(textoScript.toString());
		script = this.script;
	}

	private void insereSaveCampos() {
		for (Metodo metodo : script.getMetodoList()) {
			atualizaIndices();

			String metodoText = metodo.getComandoSalvar();

			textoScript.insert(fimRegiaoSave - 1, metodoText + "\n\n");
		}		
	}

	private void insereMetodos() {

		for (Metodo metodo : script.getMetodoList()) {
			atualizaIndices();

			String metodoText = metodo.getMetodoToString();

			textoScript.insert(fimRegiaoDeclaracao - 1, metodoText + "\n\n");
		}
	}

	private void insereChamadaMetodos() {
		for (Metodo metodo : script.getMetodoList()) {
			atualizaIndices();

			String metodoText = metodo.getChamadaMetodo();

			textoScript.insert(fimRegiaoInvocacao - 1, metodoText + "\n\n");
		}
	}

	private void atualizaIndices() {
		inicioRegiaoDeclaracao = textoScript.indexOf("/**region metod declaration*/");
		fimRegiaoDeclaracao = textoScript.indexOf("/**end region metod declaration*/");
		inicioRegiaoInvocacao = textoScript.indexOf("/**region target metod*/");
		fimRegiaoInvocacao = textoScript.indexOf("/**end region target metod*/");
		inicioRegiaoSave = textoScript.indexOf("/**region save*/");
		fimRegiaoSave = textoScript.indexOf("/**end region save*/");
	}
}

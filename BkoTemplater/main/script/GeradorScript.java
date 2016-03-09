package script;

import model.Metodo;

public class GeradorScript implements Gerador {
	private Script script;
	private StringBuilder textoScript;

	@Override
	public void gerarScript(Script script) {
		this.script = script;
		textoScript = new StringBuilder();
		textoScript.append(this.script.getScript().toString());

		for (Metodo metodo : script.getMetodoList()) {
			insereMetodos(metodo, textoScript.indexOf("/**fim_declaracao_metodo*/"));

			insereChamadaMetodos(metodo, textoScript.indexOf("/**fim_chamada_metodo*/"));

			insereSaveCampos(metodo, textoScript.indexOf("/**fim_salva_tabela*/"));
		}

		this.script.atualizaTemplateText(textoScript.toString());
		script = this.script;
	}

	private void insereMetodos(Metodo metodo, int indice) {
		textoScript.insert(indice - 1, metodo.getMetodoToString() + "\n\n");
	}

	private void insereChamadaMetodos(Metodo metodo, int indice) {
		textoScript.insert(indice - 1, metodo.getChamadaMetodo() + "\n\n");
	}

	private void insereSaveCampos(Metodo metodo, int indice) {
		textoScript.insert(indice - 1, metodo.getComandoSalvar());
	}
}

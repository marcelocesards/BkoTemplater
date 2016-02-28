package script;

import java.util.List;

import model.Metodo;
import model.Parametro;

public class GeradorScript implements Gerador {
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
		textoScript.append("\nMarcelo\nTeste");

		atualizaIndices();

		textoScript.insert(fimRegiaoDeclaracao - 1, "novoMetodo\n\n");

		insereMetodos();

		System.out.println(textoScript.substring(inicioRegiaoDeclaracao, fimRegiaoDeclaracao + 45));
		System.out.println(inicioRegiaoDeclaracao);
		System.out.println(fimRegiaoDeclaracao);

		textoScript.append(inicioRegiaoDeclaracao);

		this.script.atualizaTemplateText(textoScript.toString());
		script = this.script;
	}

	private void insereMetodos() {

		for (Metodo metodo : script.getMetodoList()) {
			atualizaIndices();

	    	String metodoText = uneParametrosAoMetodo(metodo);

			textoScript.insert(fimRegiaoDeclaracao - 1, metodoText + "\n\n");

		}
	}

	private String uneParametrosAoMetodo(Metodo metodo) {		
		String parametros = converteListaParametroParaString(metodo);
		
		return "";
	}

	private String converteListaParametroParaString(Metodo metodo) {
		StringBuilder metodoTexto = new StringBuilder();
		int quantidadeParametro = 0;
		List<Parametro> parametros =  metodo.getParametros();
		
		for (Parametro parametro :  parametros) {
			quantidadeParametro++;
			if (quantidadeParametro > 1) {
				metodoTexto.append(",\n");
			}

			metodoTexto.append(parametro.getNome());

			if (parametro.getModo() != null) {
				metodoTexto.append(" ");
				metodoTexto.append(parametro.getModo());

			}

			metodoTexto.append(" ");
			metodoTexto.append(parametro.getData_type());

			metodoTexto.append(" ");
			metodoTexto.append(parametro.getPrecisao());

			if (parametro.getDefaultValue() != null) {
				metodoTexto.append(" default ");
				metodoTexto.append(parametro.getDefaultValue());
			}

			System.out.println(metodoTexto);
		}
		return metodoTexto.toString();		
	}

	private void atualizaIndices() {
		inicioRegiaoDeclaracao = textoScript.indexOf("/**region metod declaration*/");
		fimRegiaoDeclaracao = textoScript.indexOf("/**end region metod declaration*/");
	}
}

package script;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import factory.ParametroFactory;
import model.Metodo;
import model.Parametro;

public class MetodoCompletoInserido implements Metodo {
	private String textoFuncao;
	private String nome;
	private List<Parametro> parametros;
	private String body;
	private Parametro retorno;
	private String tipoMetodo;
	private int indiceInicioParametros;
	private int indiceFimParametros;

	public MetodoCompletoInserido(String textoFuncao) {
		this.parametros = new ArrayList<>();
		this.textoFuncao = textoFuncao;
		extraiMetodo();

	}

	private void extraiMetodo() {
		setTipoMetodo();
		extraiIndices();
		extraiNomeMetodo();
		extraiListaParametros();
	}

	private void extraiIndices() {
		indiceInicioParametros = textoFuncao.indexOf("(") + 1;
		indiceFimParametros = textoFuncao.indexOf(")") - 1;
	}

	private void extraiNomeMetodo() {
		this.nome = textoFuncao.substring(textoFuncao.indexOf(" "), indiceInicioParametros - 1).trim();
	}

	private void setTipoMetodo() {
		if (this.textoFuncao.contains("procedure")) {
			this.tipoMetodo = "PROCEDURE";
		} else {
			this.tipoMetodo = "FUNCTION";
		}

	}

	@Override
	public List<Parametro> getListaParametros() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMetodoToString() {
		return textoFuncao;
	}

	@Override
	public String getChamadaMetodo() {
		return null;
	}

	@Override
	public String getComandoSalvar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNome() {
		return this.nome;
	}

	@Override
	public void addParametro(Parametro parametro) {
		// TODO Auto-generated method stub

	}

	private void extraiListaParametros() {
		String parametrosString = textoFuncao.substring(indiceInicioParametros, indiceFimParametros).toLowerCase()
				.trim();
		parametrosString = parametrosString.replaceAll("\\n", " ");

		if (parametrosString.trim().isEmpty()) {
			return;
		}

		ArrayList<String> listaParametros = new ArrayList<String>(Arrays.asList(parametrosString.split(",")));

		for (String parametro : listaParametros) {
			String parametroNome = "";
			String parametroType = "";
			String parametroModo = "";
			String parametroValorDefault = "null";

			parametro = parametro.trim();

			// trata o default
			if (parametro.contains("default")) {
				parametroValorDefault = parametro.substring(parametro.indexOf("default") + 8);
				parametro = parametro.replace(parametro.substring(parametro.indexOf("default")), "");
			}

			parametro = parametro.replaceAll("(\\s)+", ",");

			if (parametro.contains("in") || parametro.contains("out")) {
				parametro = parametro.replace("in,out,nocopy", "inoutnocopy");
				parametro = parametro.replace("in,out", "inout");
			} else {
				StringBuilder parametroNew = new StringBuilder(parametro);
				parametroNew.insert(parametroNew.indexOf(","), ",in");
				parametro = parametroNew.toString();
			}

			ArrayList<String> listaItensParametros = new ArrayList<String>(Arrays.asList(parametro.split(",")));

			int contadorLista = 0;

			for (String string : listaItensParametros) {
				String itemParametro = string.trim();
				if (itemParametro.isEmpty()) {
					continue;
				}
				contadorLista++;
				listaItensParametros.size();

				if (contadorLista == 1) {
					parametroNome = itemParametro;
				}
				if (contadorLista == 2) {
					parametroModo = itemParametro;
				}
				if (contadorLista == 3) {
					parametroType = itemParametro;
				}
			}
			parametros.add(new ParametroFactory().getParametro(parametroNome, parametroModo, parametroType, 0,
					parametroValorDefault));
		}
	}
}

package script;

import java.util.ArrayList;
import java.util.List;

import factory.ParametroFactory;
import model.Metodo;
import model.Parametro;
import script.extrator.Extrator;
import script.extrator.ExtratorParametro;

public class MetodoCompletoInserido implements Metodo {
	private String textoFuncao;
	private String nome;
	private List<Parametro> parametros;
	private String body;
	private Parametro retorno;
	private String tipoMetodo;

	public MetodoCompletoInserido(String textoFuncao) {
		this.parametros = new ArrayList<>();
		this.textoFuncao = textoFuncao;
		extraiMetodo();

	}

	private void extraiMetodo() {
		setTipoMetodo();
		extraiNomeMetodo();
		extraiListaParametros();
		extraiRetorno();
	}

	private void extraiRetorno() {
		
	}

	private void extraiNomeMetodo() {
		Extrator extrator = new Extrator(textoFuncao);
		this.nome = extrator.getNomeMetodo();
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
		StringBuilder parametrosTexto = new StringBuilder();
		int quantidadeParametro = 0;

		//parametrosTexto.append(getRetornoChamada());

		parametrosTexto.append(getNome() + "(\n");

		for (Parametro parametro : parametros) {
			quantidadeParametro++;
			if (quantidadeParametro > 1) {
				parametrosTexto.append(",\n");
			}

			parametrosTexto.append(parametro.ChamadaParametroToString());
		}
		parametrosTexto.append(");");
		return parametrosTexto.toString();
	}
	
	private String getRetornoChamada() {
			return this.retorno.getNome().isEmpty() ? "" : "v_bko." + retorno.getNome() + " := ";		
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
		ExtratorParametro extratorParametros = new ExtratorParametro(textoFuncao);

		if (extratorParametros.temParametro())
			return;

		for (String nome : extratorParametros.getListNome()) {
			parametros.add(new ParametroFactory().getParametro(nome, extratorParametros.getMapModo().get(nome),
					extratorParametros.getParametroType().get(nome), 0,
					extratorParametros.getValorDefault().get(nome)));
		}

	}
}

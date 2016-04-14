package script;

import java.util.ArrayList;
import java.util.List;

import factory.ParametroFactory;
import model.Metodo;
import model.Parametro;
import model.Retorno;
import script.extrator.Extrator;
import script.extrator.ExtratorParametro;

public class MetodoCompletoInserido implements Metodo {
	private String texto;
	private String nome;
	private List<Parametro> parametros;
	private Retorno retorno;
	private ExtratorParametro extratorParametros;

	public MetodoCompletoInserido(String textoMetodo) {
		this.parametros = new ArrayList<>();
		this.texto = textoMetodo;		
		extraiMetodo();

	}

	private void extraiMetodo() {
		extraiNomeMetodo();
		extraiListaParametros();
		extraiRetorno();
	}

	private void extraiRetorno() {
		
	}

	private void extraiNomeMetodo() {
		Extrator extrator = new Extrator(this.texto);
		this.nome = extrator.getNomeMetodo();
	}

	@Override
	public List<Parametro> getListaParametros() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMetodoToString() {
		return this.texto;
	}

	@Override
	public String getChamadaMetodo() {
		StringBuilder parametrosTexto = new StringBuilder();
		int quantidadeParametro = 0;

		parametrosTexto.append(getRetornoChamada());
		
		parametrosTexto.append(getNome() + "(");

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
			return "";//this.retorno.getNome().isEmpty() ? "" : "v_bko." + retorno.getNome() + " := ";		
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
		this.extratorParametros = new ExtratorParametro(this.texto);
		if (!extratorParametros.temParametro())
			return;

		for (String nome : extratorParametros.getListNome()) {
			
			parametros.add(new ParametroFactory().getParametro(nome, extratorParametros.getMapModo().get(nome),
					extratorParametros.getParametroType().get(nome), 0,
					extratorParametros.getValorDefault().get(nome)));
		}

	}
}

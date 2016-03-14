package model;

import java.util.List;

public interface Metodo {
	public List<Parametro> getListaParametros();

	public String getMetodoToString();

	public String getChamadaMetodo();

	public String getComandoSalvar();

	public String getNome();

	public void addParametro(Parametro parametro);
}

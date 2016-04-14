package script;

import java.util.List;

import model.Metodo;
import script.geradorDeCodigo.Gerador;

public interface Script {
	public void gerarScript();
	public List<Metodo> getMetodoList();
	public Template getScript();
	public void atualizaTemplateText(String novoTexto);
	public void setGerador(Gerador gerador);
	public void addMetodo(Metodo metodo);
}

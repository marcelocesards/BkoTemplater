package script;

import java.util.ArrayList;
import java.util.List;

import model.Metodo;

public abstract class Script {
	
	protected abstract Templates criarTemplate();
	
	private Template template = criarTemplate().getTemplate();
	private List<Metodo> metodos = new ArrayList<Metodo>();
	private Gerador gerador;
	
	public Template getScript() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public List<Metodo> getMetodoList() {
		return metodos;
	}

	public void setGerador(Gerador gerador) {
		this.gerador = gerador;
	}

	public void addMetodo(Metodo metodo) {
		this.metodos.add(metodo);
	}
	
	public void gerarScript(){
		gerador.gerarScript(this);
	}
}

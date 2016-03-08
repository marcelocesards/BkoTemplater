package script;

import java.util.ArrayList;
import java.util.List;

import factory.TemplateFactory;
import model.Metodo;

public class ScriptTratamento implements Script{
	
	protected Templates criarTemplate() {
		return new TemplateFactory("bin/Templates/Tratamento.tpt");
	}
	
	private Template template = criarTemplate().getTemplate();
	private List<Metodo> metodos = new ArrayList<Metodo>();
	private Gerador gerador;
	
	public Template getScript() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}
	
	public void atualizaTemplateText(String novoTexto){
		template.setTemplateText(novoTexto);
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
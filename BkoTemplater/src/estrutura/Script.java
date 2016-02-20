package estrutura;

import java.util.List;

public class Script {
	private Template template;
	private List<Metodo> metodos;
	
	public Script(Template template) {
		this.template = template;
	}

	public Template getScript() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public List<Metodo> getMetodoList() {
		return metodos;
	}

	public void addMetodo(Metodo metodo) {
		this.metodos.add(metodo);
	}

	public void gerarSrcript() {

	};
}

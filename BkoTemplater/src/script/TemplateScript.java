package script;

public class TemplateScript{
	String template;

	public TemplateScript(String textoArquivo) {
		template = textoArquivo;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String toString() {
		return this.template;
	}
}

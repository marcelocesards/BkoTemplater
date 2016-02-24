package script;

public class TemplateScript implements Template{
	String template;

	public TemplateScript(String textoArquivo) {
		template = textoArquivo;
	}

	public String getTemplateText() {
		return template;
	}
	
	public void setTemplate(String template) {
		this.template = template;
	}

	public String toString() {
		return this.template;
	}
}

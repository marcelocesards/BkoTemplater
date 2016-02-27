package model;

import script.Template;

public class TemplateScript implements Template{
	String template;

	public TemplateScript(String textoArquivo) {
		template = textoArquivo;
	}

	public String getTemplateText() {
		return template;
	}
	
	public void setTemplateText(String template) {
		this.template = template;
	}

	public String toString() {
		return this.template;
	}
}

package scriptTest;

public class TemplateScript implements Template {
	String template;

	public TemplateScript(String textoScript) {
		this.template = textoScript;
	}

	public String toString() {
		return this.template;
	}
}

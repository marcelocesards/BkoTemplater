package script;

import scriptTest.TemplateScript;

public class FactoryTemplate {

	public TemplateScript getTemplate(String string) {
		return new TemplateScript("texto arquivo");
	}

}

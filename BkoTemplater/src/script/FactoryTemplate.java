package script;

import scriptTest.copy.TemplateScript;

public class FactoryTemplate {

	public TemplateScript getTemplate(String string) {
		return new TemplateScript("texto arquivo");
	}

}

package script;

import factory.TemplateFactory;

public class ScriptTratamento extends Script{

	@Override
	protected Templates criarTemplate() {
		return (Templates) new TemplateFactory("arquivo");
	}
}

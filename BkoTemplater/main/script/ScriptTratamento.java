package script;

import factory.TemplateFactory;

public class ScriptTratamento extends Script{
	
	@Override
	protected Templates criarTemplate() {
		return new TemplateFactory("bin/Templates/Tratamento.tpt");
	}
}
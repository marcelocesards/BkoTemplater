package scriptTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import script.FactoryTemplate;

public class FactoryTemplateTest {
	FactoryTemplate criaTemplate = new FactoryTemplate();

	TemplateScript script = criaTemplate.getTemplate("arquivo.tpt");

	@Test
	public void testLeituraArquivo() {
		assertEquals("texto arquivo", script.toString());
	}
}

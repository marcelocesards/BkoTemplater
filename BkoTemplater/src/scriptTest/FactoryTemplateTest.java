package scriptTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import script.FactoryTemplate;

public class FactoryTemplateTest {
	FactoryTemplate criaTemplate = new FactoryTemplate();

	TemplateScript script = criaTemplate.getTemplate("arquivo.txt");

	@Test
	public void testLeituraArquivo() {
		assertEquals("texto", script.toString().trim());
	}
}

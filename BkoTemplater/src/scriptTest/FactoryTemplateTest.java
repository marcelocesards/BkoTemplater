package scriptTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import script.FactoryTemplate;
import script.TemplateScript;

public class FactoryTemplateTest {
	FactoryTemplate criaTemplate = new FactoryTemplate();

	TemplateScript script = criaTemplate.getTemplate("bin/scriptTest/arquivo.txt");

	@Test
	public void testLeituraArquivo() {
		assertEquals("texto", script.toString().trim());
	}
}

package scriptTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import factory.TemplateFactory;
import script.TemplateScript;

public class TemplateFactoryTest {
	TemplateFactory criaTemplate = new TemplateFactory();

	TemplateScript script = criaTemplate.getTemplate("bin/scriptTest/arquivo.txt");

	@Test
	public void testLeituraArquivo() {
		assertEquals("texto", script.toString().trim());
	}
}

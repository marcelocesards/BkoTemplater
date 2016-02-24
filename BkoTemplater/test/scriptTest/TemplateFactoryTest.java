package scriptTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import factory.TemplateFactory;
import model.TemplateScript;

public class TemplateFactoryTest {
	TemplateFactory criaTemplate = new TemplateFactory("bin/scriptTest/arquivo.txt");

	TemplateScript script = (TemplateScript) criaTemplate.getTemplate();

	@Test
	public void testLeituraArquivo() {
		assertEquals("texto", script.toString().trim());
	}
}

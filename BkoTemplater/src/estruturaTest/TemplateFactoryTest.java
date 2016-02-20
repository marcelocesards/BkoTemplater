package estruturaTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import estrutura.TemplateScript;
import factory.TemplateFactory;

public class TemplateFactoryTest {
	TemplateFactory criaTemplate = new TemplateFactory();

	TemplateScript script = criaTemplate.getTemplate("bin/estruturaTest/arquivo.txt");

	@Test
	public void testLeituraArquivo() {
		assertEquals("texto", script.toString().trim());
	}
}

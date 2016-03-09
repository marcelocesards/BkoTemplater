package scriptTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import factory.TemplateFactory;
import model.TemplateScript;

public class TemplateFactoryTest {
	TemplateFactory criaTemplate = new TemplateFactory("main/resources/Template.tpt");

	TemplateScript script = (TemplateScript) criaTemplate.getTemplate();

	@Test
	public void testLeituraArquivo() {
		assertEquals(true, script.toString().contains("DECLARE"));
	}
}

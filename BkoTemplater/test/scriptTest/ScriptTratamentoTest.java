package scriptTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import script.ScriptTratamento;

public class ScriptTratamentoTest {
	ScriptTratamento script = new ScriptTratamento("main/resources/Template.tpt");
	
	@Test
	public void testLeituraArquivo() {
		assertEquals(true, script.getScript().toString().contains("DECLARE"));
	}
}

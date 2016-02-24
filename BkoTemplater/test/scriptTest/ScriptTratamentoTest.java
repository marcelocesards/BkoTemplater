package scriptTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import script.ScriptTratamento;

public class ScriptTratamentoTest {
	ScriptTratamento script = new ScriptTratamento();
	
	@Test
	public void testLeituraArquivo() {
		assertEquals("texto", script.getScript().toString().trim());
	}
}

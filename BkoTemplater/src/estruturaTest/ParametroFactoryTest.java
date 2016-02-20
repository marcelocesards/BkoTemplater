package estruturaTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import estrutura.Parametro;
import factory.ParametroFactory;

public class ParametroFactoryTest {
	ParametroFactory factoryParametro = new ParametroFactory();

	Parametro parametro = factoryParametro.getParametro("valida_cliente", "in", "varchar2", 100, "null");

	@Test
	public void testLeituraArquivo() {
		assertEquals("valida_cliente", parametro.getNome());
	}
}

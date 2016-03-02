package scriptTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Parametro;

public class ParametroTest {
	Parametro parametro;

	@Before
	public void inicializaClasse() {
		parametro = new Parametro("nome_cliente", "in", "integer", 10, "0");
	}

	@Test
	public void convertParametroParaTexto() {
		assertEquals("nome_cliente in integer default 0", parametro.parametroToString());
	}

	@Test
	public void campoParametroToStringTest() {
		assertEquals("nome_cliente integer(10)", parametro.campoParametroToString());
	}

	@Test
	public void ChamadaParametroToString() {
		assertEquals("nome_cliente => v_bko.nome_cliente", parametro.ChamadaParametroToString());
	}	
	
}

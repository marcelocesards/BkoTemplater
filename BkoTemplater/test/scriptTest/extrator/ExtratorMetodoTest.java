package scriptTest.extrator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import script.extrator.ExtratorParametro;

public class ExtratorMetodoTest {
	ExtratorParametro extrator;
	ExtratorParametro extratorSemParamtro;
	
	@Before
	public void inicializa(){
		String metodo = 
		 		  "FUNCTION validar(valor in number default 0,\n"
		 		  + "descricao in varchar2,\n"
		 		  + "cliente varchar2,"
		 		  + "numero_cliente out number,"
		 		  + "tipo_cliente in out varchar2 default 'tipo vasio') return varchar2 is\n"
		 		  + "v_count number;\n"
		 		  + "BEGIN\n"
		 		  + "SELECT 1 INTO v_count FROM dual;\n"
		 		  + "return v_count;"
		 		  + "END validar;";
		
		extrator = new ExtratorParametro(metodo);
		
		String metodoSemParametro = 
		 		  "FUNCTION validar return varchar2 is\n"
		 		  + "v_count number;\n"
		 		  + "BEGIN\n"
		 		  + "SELECT 1 INTO v_count FROM dual;\n"
		 		  + "return v_count;"
		 		  + "END validar;";
		
		extratorSemParamtro = new ExtratorParametro(metodoSemParametro);
	}
	
	@Test
	public void getListNome(){
		assertEquals("valor", extrator.getListNome().get(0));
		assertEquals("descricao", extrator.getListNome().get(1));
		assertEquals("cliente", extrator.getListNome().get(2));
		assertEquals("numero_cliente", extrator.getListNome().get(3));
		assertEquals("tipo_cliente", extrator.getListNome().get(4));
	}
	
	@Test
	public void TemParametro(){
		assertEquals(false, extratorSemParamtro.temParametro());
	}
	
	@Test
	public void getMapModo(){
		assertEquals("in", extrator.getMapModo().get("valor"));
		assertEquals("in", extrator.getMapModo().get("descricao"));
		assertEquals("in", extrator.getMapModo().get("cliente"));
		assertEquals("out", extrator.getMapModo().get("numero_cliente"));
		assertEquals("in out", extrator.getMapModo().get("tipo_cliente"));
	}
	
	@Test
	public void getParametroType(){
		assertEquals("number", extrator.getParametroType().get("valor"));
		assertEquals("varchar2", extrator.getParametroType().get("descricao"));
		assertEquals("varchar2", extrator.getParametroType().get("cliente"));
		assertEquals("number", extrator.getParametroType().get("numero_cliente"));
		assertEquals("varchar2", extrator.getParametroType().get("tipo_cliente"));
	}
	
	@Test
	public void getParametroDefault(){
		assertEquals("0", extrator.getValorDefault().get("valor"));
		assertEquals(null, extrator.getValorDefault().get("descricao"));
		assertEquals(null, extrator.getValorDefault().get("cliente"));
		assertEquals(null, extrator.getValorDefault().get("numero_cliente"));
		assertEquals("'tipo vasio'", extrator.getValorDefault().get("tipo_cliente"));
	}
}

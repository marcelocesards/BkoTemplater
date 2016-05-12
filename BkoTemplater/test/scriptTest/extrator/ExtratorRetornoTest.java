package scriptTest.extrator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import script.extrator.ExtratorRetorno;

public class ExtratorRetornoTest {
	ExtratorRetorno extratorComRetorno;
	
	@Before
	public void inicializa(){
		String metodo = 
		 		  "FUNCTION resta_clientes_para_tratar(valor in number default 0,\n"
		 		  + "descricao in varchar2,\n"
		 		  + "cliente varchar2,"
		 		  + "numero_cliente out number,"
		 		  + "tipo_cliente in out varchar2 default 'tipo vasio') return varchar2 is\n"
		 		  + "v_count number;\n"
		 		  + "BEGIN\n"
		 		  + "SELECT 1 INTO v_count FROM dual;\n"
		 		  + "return v_count;"
		 		  + "END resta_clientes_para_tratar;";
		
		extratorComRetorno = new ExtratorRetorno(metodo);

	}
	
	@Test
	public void getNome(){
		assertEquals("resta_clientes_para_tratar_ret", extratorComRetorno.getNome());
	}
	
	@Test
	public void temRetorno(){
		assertTrue(extratorComRetorno.temRetorno());
	}
	
	@Test
	public void getType(){
		assertEquals("varchar2", extratorComRetorno.getType());
	}
}

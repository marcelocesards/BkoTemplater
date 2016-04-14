package scriptTest.extrator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import script.extrator.ExtratorRetorno;

public class ExtratorRetornoTest {
	ExtratorRetorno extratorComRetorno;
	ExtratorRetorno extratorSemRetorno;
	ExtratorRetorno extratorComRetornoNumber;
	
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
		
		extratorComRetorno = new ExtratorRetorno(metodo);
		
		String metodoComRetornoNumber = 
		 		  "FUNCTION validar(valor in number default 0,\n"
		 		  + "descricao in varchar2,\n"
		 		  + "cliente varchar2,"
		 		  + "numero_cliente out number,"
		 		  + "tipo_cliente in out varchar2 default 'tipo vasio') return varchar2 is\n"
		 		  + "v_count number;\n"
		 		  + "BEGIN\n"
		 		  + "SELECT 1 INTO v_count FROM dual;\n"
		 		  + "return 0;"
		 		  + "END validar;";
		
		extratorComRetornoNumber = new ExtratorRetorno(metodoComRetornoNumber);
		
		String metodoSemRetorno = 
		 		  "PROCEDURE validar is\n"
		 		  + "v_count number;\n"
		 		  + "BEGIN\n"
		 		  + "SELECT 1 INTO v_count FROM dual;\n"
		 		  + "return v_count;"
		 		  + "END validar;";
		
		extratorSemRetorno = new ExtratorRetorno(metodoSemRetorno);
	}
	
	@Test
	public void getNome(){
		assertEquals("validar_return", extratorComRetorno.getNome());
	}
	
	@Test
	public void temRetorno(){
		assertTrue(extratorComRetorno.temRetorno());
	}
}

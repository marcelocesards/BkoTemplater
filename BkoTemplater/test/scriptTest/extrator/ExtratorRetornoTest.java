package scriptTest.extrator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import script.extrator.ExtratorRetorno;

public class ExtratorRetornoTest {
	ExtratorRetorno extratorComRetorno;
	ExtratorRetorno extratorSemRetorno;
	
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
	public void getListNome(){
		assertEquals("valor", extratorComRetorno.geNome());
	}
	
	@Test
	public void TemParametro(){
		assertEquals(false, extratorSemRetorno.temRetorno());
	}
	
	
	@Test
	public void getRetornoType(){
		assertEquals("number", extratorComRetorno.getType());
	}
}

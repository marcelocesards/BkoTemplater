package scriptTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import script.ExtratorParametroMetodo;

public class ExtratorMetodoTest {
	ExtratorParametroMetodo extrator;
	
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
		
		extrator = new ExtratorParametroMetodo(metodo);
	}
	
	@Test
	public void getListNome(){
		assertEquals("valor", extrator.getListNome().get(0));
		assertEquals("descricao", extrator.getListNome().get(1));
		assertEquals("cliente", extrator.getListNome().get(2));
		assertEquals("numero_cliente", extrator.getListNome().get(3));
		assertEquals("tipo_cliente", extrator.getListNome().get(4));
	}
}

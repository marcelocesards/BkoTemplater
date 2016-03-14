package scriptTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.Metodo;
import model.Parametro;
import script.MetodoCompletoInserido;

public class FuncaoCompleaTest {
	Metodo metodo;
	Parametro parametro;
	Parametro retorno;
	
	@Before
	public void criarInstancias(){
		metodo = new MetodoCompletoInserido(
		 		  "FUNCTION validar(valor in number default 0,\n"
		 		  + "descricao in varchar2) return varchar2 is\n"
		 		  + "v_count number;\n"
		 		  + "BEGIN\n"
		 		  + "SELECT 1 INTO v_count FROM dual;\n"
		 		  + "END validar;");
	}
	
	@Test
	public void getNome(){
		assertEquals(
				 "validar", metodo.getNome());
	}
	
	@Test
	public void getMetodoToString(){
		assertEquals(
				 "FUNCTION validar(valor in number default 0,\n"
				 		  + "descricao in varchar2) return varchar2 is\n"
				 		  + "v_count number;\n"
				 		  + "BEGIN\n"
				 		  + "SELECT 1 INTO v_count FROM dual;\n"
				 		  + "END validar;", metodo.getMetodoToString());
	}
	
	@Test
	public void getChamadaMetodo(){
		assertEquals(
				  "        validar(\n"
				+ "          nome_cliente => v_bko.nome_cliente,\n"
				+ "          saldo_cliente => v_bko.saldo_cliente,\n"
				+ "          saldo_cliente => v_bko.saldo_cliente,\n"
				+ "          saldo_cliente => v_bko.saldo_cliente);", metodo.getChamadaMetodo());
	}
	
	@Test
	public void getSalvarCampo(){
		assertEquals(
				  "           nome_cliente = pbko.nome_cliente,\n"
				+ "           saldo_cliente = pbko.saldo_cliente,\n"
				+ "           saldo_cliente = pbko.saldo_cliente,\n"
				+ "           saldo_cliente = pbko.saldo_cliente,\n", metodo.getComandoSalvar());
	}

}

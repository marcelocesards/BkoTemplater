package scriptTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.Metodo;
import model.Parametro;
import script.MetodoCriado;

public class MetodoTest {
	Metodo metodo;
	Parametro parametro;
	Parametro retorno;
	
	@Before
	public void criarInstancias(){		  
		 parametro = new Parametro("nome_cliente", "in out","integer",10,"0");		 
		 List<Parametro> parametros = new ArrayList<>();
		 parametros.add(parametro);
		 
		 String defaultValue = "";
		 
		 retorno = new Parametro("", "","",0,"");	
		 
		 parametro = new Parametro("saldo_cliente", "in out","number",10, defaultValue);
		 parametros.add(parametro);
		 parametros.add(parametro);
		 parametros.add(parametro);
		 
		 metodo = new MetodoCriado("validar", parametros, "begin end;", retorno);
	}
	
	/*Deprecated - private
	@Test
	public void getListaParametroToString(){
		assertEquals("    nome_cliente in out integer default 0,\n"
				+ "    saldo_cliente in out number,\n"
				+ "    saldo_cliente in out number,\n"
				+ "    saldo_cliente in out number", metodo.getListaParametrosToString());
	}
	*/
	
	@Test
	public void getMetodoToString(){
		System.out.println("["+ metodo.getMetodoToString()+"]");
		assertEquals("  PROCEDURE validar(\n"
				+ "    nome_cliente in out integer default 0,\n"
				+ "    saldo_cliente in out number,\n"
				+ "    saldo_cliente in out number,\n"
				+ "    saldo_cliente in out number) IS\n"
				+ "  begin end;", metodo.getMetodoToString());
	}
	
	@Test
	public void getChamadaMetodo(){
		System.out.println("["+ metodo.getChamadaMetodo()+"]");
		assertEquals(
				  "        validar(\n"
				+ "          nome_cliente => v_bko.nome_cliente,\n"
				+ "          saldo_cliente => v_bko.saldo_cliente,\n"
				+ "          saldo_cliente => v_bko.saldo_cliente,\n"
				+ "          saldo_cliente => v_bko.saldo_cliente);", metodo.getChamadaMetodo());
	}
	
	@Test
	public void getSalvarCampo(){
		System.out.println("["+ metodo.getComandoSalvar()+"]");
		assertEquals(
				  "           nome_cliente = pbko.nome_cliente,\n"
				+ "           saldo_cliente = pbko.saldo_cliente,\n"
				+ "           saldo_cliente = pbko.saldo_cliente,\n"
				+ "           saldo_cliente = pbko.saldo_cliente,\n", metodo.getComandoSalvar());
	}
}

package scriptTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.Metodo;
import model.Parametro;
import script.Funcao;
import script.Script;
import script.ScriptTratamento;

public class MetodoTest {
	Script script; 
	Metodo metodo;
	Parametro parametro;
	Parametro retorno;
	
	@Before
	public void criarInstancias(){
		 script = new ScriptTratamento();
		  
		 parametro = new Parametro("nome_cliente", "in","integer",10,"0");		 
		 List<Parametro> parametros = new ArrayList<>();
		 parametros.add(parametro);
		 
		 String defaultValue = "";
		 
		 retorno = new Parametro("", "","",0,"");	
		 
		 parametro = new Parametro("saldo_cliente", "in","number",10, defaultValue);
		 parametros.add(parametro);
		 parametros.add(parametro);
		 parametros.add(parametro);
		 
		 metodo = new Funcao("validar", parametros, "begin end;", retorno);
	}
	
	@Test
	public void getListaParametroToString(){
		assertEquals("    nome_cliente in integer default 0,\n"
				+ "    saldo_cliente in number,\n"
				+ "    saldo_cliente in number,\n"
				+ "    saldo_cliente in number", metodo.getListaParametrosToString());
	}
	
	@Test
	public void getMetodoToString(){
		System.out.println("["+ metodo.getMetodoToString()+"]");
		assertEquals("  PROCEDURE validar(\n"
				+ "    nome_cliente in integer default 0,\n"
				+ "    saldo_cliente in number,\n"
				+ "    saldo_cliente in number,\n"
				+ "    saldo_cliente in number) IS\n"
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
}
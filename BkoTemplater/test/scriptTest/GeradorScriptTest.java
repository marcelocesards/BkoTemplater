package scriptTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.Metodo;
import model.Parametro;
import script.Funcao;
import script.GeradorScript;
import script.Script;
import script.ScriptTratamento;

public class GeradorScriptTest {
	Script script; 
	Metodo metodo;
	Parametro parametro;
	
	@Before
	public void criarInstancias(){
		 script = new ScriptTratamento();
		 
		 parametro = new Parametro("nome_cliente","in out","integer",10,"0");		 
		 List<Parametro> parametros = new ArrayList<>();
		 parametros.add(parametro);
		 
		 String retorno = "";
		 
		 parametro = new Parametro("saldo_cliente", "out","number",10, retorno);
		 parametros.add(parametro);
		 parametros.add(parametro);
		 parametros.add(parametro);
		 
		 metodo = new Funcao("validar", parametros, "begin end;", parametro);
		 		 
		 script.addMetodo(metodo);
		 		 
		 script.setGerador(new GeradorScript());
		 
		 script.gerarScript();
	}
	
	@Test
	public void scriptGerarScriptMetodos(){
		assertEquals("/**region metod declaration*/\n  \n"
				+ "   FUNCTION validar(\n"
                + "    nome_cliente in out integer default 0,\n"
                + "    saldo_cliente out number,\n"
                + "    saldo_cliente out number,\n"
                + "    saldo_cliente out number) return number IS\n"
                + "  begin end;\n\n"
				+ " /**end region metod declaration*/", script.getScript().toString().substring(407, 659));
	}
	
	@Test
	public void scriptGerarScriptChamadaMetodos(){	
		assertEquals("/**region target metod*/\n        \n"
				+ "               v_bko.saldo_cliente = validar(\n"
                + "                                nome_cliente => v_bko.nome_cliente,\n"
                + "                                saldo_cliente => v_bko.saldo_cliente,\n"
                + "                                saldo_cliente => v_bko.saldo_cliente,\n"
                + "                                saldo_cliente => v_bko.saldo_cliente);\n\n"
				+ " /**end region target metod*/", script.getScript().toString().substring(
						script.getScript().toString().indexOf("/**region target metod*/"),
						script.getScript().toString().indexOf("/**end region target metod*/") + 28));
	}
	
	@Test
	public void scriptGerarScriptSalvarCampo(){
		System.out.println(script.getScript().toString());
		assertEquals("/**region save*/\n"
				+ "           saldo_cliente = pbko.saldo_cliente,\n"
                + "           nome_cliente = pbko.nome_cliente,\n"
                + "           saldo_cliente = pbko.saldo_cliente,\n"
                + "           saldo_cliente = pbko.saldo_cliente,\n"
                + "           saldo_cliente = pbko.saldo_cliente,\n\n"
				+ "/**end region save*/", script.getScript().toString().substring(
						script.getScript().toString().indexOf("/**region save*/"),
						script.getScript().toString().indexOf("/**end region save*/") + 20));
	}
	
}

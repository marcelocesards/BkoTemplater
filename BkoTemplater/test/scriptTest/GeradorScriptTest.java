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
		 
		 parametro = new Parametro("nome_cliente","in","integer",10,"0");		 
		 List<Parametro> parametros = new ArrayList<>();
		 parametros.add(parametro);
		 
		 String retorno = "";
		 
		 parametro = new Parametro("saldo_cliente", "in","number",10, retorno);
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
                + "    nome_cliente in integer default 0,\n"
                + "    saldo_cliente in number,\n"
                + "    saldo_cliente in number,\n"
                + "    saldo_cliente in number) return number IS\n"
                + "  begin end;\n\n"
				+ " /**end region metod declaration*/", script.getScript().toString().substring(407, 652));
	}
	
	@Test
	public void scriptGerarScriptChamadaMetodos(){
		assertEquals("/**region metod declaration*/\n  \n"
				+ "   FUNCTION validar(\n"
                + "    nome_cliente in integer default 0,\n"
                + "    saldo_cliente in number,\n"
                + "    saldo_cliente in number,\n"
                + "    saldo_cliente in number) return number IS\n"
                + "  begin end;\n\n"
				+ " /**end region metod declaration*/", script.getScript().toString().substring(407, 652));
	}
	
}

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
		 parametro = new Parametro("nome_cliente","integer",10,"in","0");
		 List<Parametro> parametros = new ArrayList<>();
		 parametros.add(parametro);
		 metodo = new Funcao("validar", parametros, "begin end;", parametro);
		 
		 metodo.addParametro(parametro);
		 
		 script.addMetodo(metodo);
		 
		 script.setGerador(new GeradorScript());
		 
		 script.gerarScript();
	}
	
	@Test
	public void scriptGerarScript(){
		assertEquals("/**region metod declaration*/\n"
				+ "novoMetodo\n"
				+ "/**end region metod declaration*/", script.getScript().toString().trim());
	}
	
}

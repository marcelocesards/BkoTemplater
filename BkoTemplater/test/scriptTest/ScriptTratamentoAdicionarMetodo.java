package scriptTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.Metodo;
import model.Parametro;
import script.MetodoCriado;
import script.Script;
import script.ScriptTratamento;

public class ScriptTratamentoAdicionarMetodo {
	Script script; 
	Metodo metodo;
	Parametro parametro;
	
	@Before
	public void criarInstancias(){
		 script = new ScriptTratamento("/BkoTemplater/main/resources/Template.tpt");
		 parametro = new Parametro("nome_cliente","in","integer",10,"0");
		 List<Parametro> parametros = new ArrayList<>();
		 parametros.add(parametro);
		 metodo = new MetodoCriado("validar", parametros, "begin end;", parametro);
		 
		 metodo.addParametro(parametro);
		 
		 script.addMetodo(metodo);
	}
	
	@Test
	public void adicionarMetodo(){		
		assertEquals("validar", script.getMetodoList().get(0).getNome());
	}
}

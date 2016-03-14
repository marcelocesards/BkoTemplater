package scriptTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.Metodo;
import model.Parametro;
import script.MetodoCriado;
import script.GeradorScript;
import script.Script;
import script.ScriptTratamento;

public class GeradorScriptTest {
	Script script; 
	Metodo metodo;
	Parametro parametro;
	
	@Before
	public void criarInstancias(){
		 script = new ScriptTratamento("main/resources/Template.tpt");
		 
		 parametro = new Parametro("nome_cliente","in out","integer",10,"0");		 
		 List<Parametro> parametros = new ArrayList<>();
		 parametros.add(parametro);
		 
		 String retorno = "";
		 
		 parametro = new Parametro("saldo_cliente", "out","number",10, retorno);
		 parametros.add(parametro);
		 parametros.add(parametro);
		 parametros.add(parametro);
		 
		 metodo = new MetodoCriado("validar", parametros, "begin end;", parametro);
		 		 
		 script.addMetodo(metodo);
		 		 
		 script.setGerador(new GeradorScript());
		 
		 script.gerarScript();
	}
	
	@Test
	public void scriptGerarScriptMetodos(){
		assertEquals("/**declaracao_metodo*/\n"
				+ "  FUNCTION validar(\n"
                + "    nome_cliente in out integer default 0,\n"
                + "    saldo_cliente out number,\n"
                + "    saldo_cliente out number,\n"
                + "    saldo_cliente out number) return number IS\n"
                + "  begin end;\n\n\n"
				+ "/**fim_declaracao_metodo*/", script.getScript().toString().substring(
						script.getScript().toString().indexOf("/**declaracao_metodo*/"),
						script.getScript().toString().indexOf("/**fim_declaracao_metodo*/") + 26));
	}
	
	@Test
	public void scriptGerarScriptChamadaMetodos(){	
		assertEquals("/**chamada_metodo*/\n"
				+ "        v_bko.saldo_cliente = validar(\n"
                + "                                nome_cliente => v_bko.nome_cliente,\n"
                + "                                saldo_cliente => v_bko.saldo_cliente,\n"
                + "                                saldo_cliente => v_bko.saldo_cliente,\n"
                + "                                saldo_cliente => v_bko.saldo_cliente);\n\n\n"
				+ "/**fim_chamada_metodo*/", script.getScript().toString().substring(
						script.getScript().toString().indexOf("/**chamada_metodo*/"),
						script.getScript().toString().indexOf("/**fim_chamada_metodo*/") + 23));
	}
	
	@Test
	public void scriptGerarScriptSalvarCampo(){
		System.out.println(script.getScript().toString());
		assertEquals("/**salva_tabela*/\n"
				+ "           saldo_cliente = pbko.saldo_cliente,\n"
                + "           nome_cliente = pbko.nome_cliente,\n"
                + "           saldo_cliente = pbko.saldo_cliente,\n"
                + "           saldo_cliente = pbko.saldo_cliente,\n"
                + "           saldo_cliente = pbko.saldo_cliente,\n\n"
				+ "/**fim_salva_tabela*/", script.getScript().toString().substring(
						script.getScript().toString().indexOf("/**salva_tabela*/"),
						script.getScript().toString().indexOf("/**fim_salva_tabela*/") + 21));
	}
	
}

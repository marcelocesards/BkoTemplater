package scriptTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import factory.MetodoFactory;
import factory.ParametroFactory;
import script.Metodo;
import script.Parametro;

public class MetodoFactoryTest {
	MetodoFactory criaMetodo = new MetodoFactory();
	ParametroFactory factoryParametro = new ParametroFactory();
	
	Parametro parametro =  factoryParametro.getParametro("valida_cliente", "in", "varchar2", 100, "null");
	
	Parametro retorno /*= factoryParametro.getParametro("valida_cliente", "in", "varchar2", 100, "null")*/;
	
	List<Parametro> parametros = new ArrayList<>();
		
	@Test
	public void testCriacaoParametro() {
		this.parametros.add(parametro);
		
		Metodo metodo = criaMetodo.getMetodo("Valida", "IN", parametros,"texto funcao", retorno);
		
		assertEquals("Valida", metodo.getNome());
	}
	
	@Test
	public void testCriacaoFuncao() {
		this.parametros.add(parametro);
		
		Parametro retorno2 = factoryParametro.getParametro("valida_cliente", "in", "varchar2", 100, "null");
		
		Metodo metodo = criaMetodo.getMetodo("Valida Funcao", "IN", parametros,"texto funcao", retorno2);
		
		assertEquals("valida_cliente", metodo.getParametros().get(0).getNome());
	}
}

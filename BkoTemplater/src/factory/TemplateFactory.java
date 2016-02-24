package factory;

import java.io.FileInputStream;
import java.util.Scanner;

import script.Template;
import script.TemplateScript;
import script.Templates;

public class TemplateFactory implements Templates{
	String caminhoArquivo;
	
	public TemplateFactory(String caminhoArquivo) {
		this.caminhoArquivo = caminhoArquivo;
	}
	
	public Template getTemplate() {
		String textoArquivo = "";
		try (Scanner textoEntrada = new Scanner(new FileInputStream(caminhoArquivo))){
			
			while (textoEntrada.hasNextLine()) {
				textoArquivo += textoEntrada.nextLine() + "\n";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new TemplateScript(textoArquivo);
	}
}

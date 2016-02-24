package factory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

import script.Template;
import script.TemplateScript;

public class TemplateFactory implements Template{
	String caminhoArquivo;
	
	public TemplateFactory(String caminhoArquivo) {
		this.caminhoArquivo = caminhoArquivo;
	}
	
	public Template getTemplate() {
		Scanner textoEntrada = null;
		String textoArquivo = "";
		try {
			InputStream is = new FileInputStream(caminhoArquivo);
			textoEntrada = new Scanner(is);

			while (textoEntrada.hasNextLine()) {
				textoArquivo += textoEntrada.nextLine() + "\n";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			textoEntrada.close();
		}
		return new TemplateScript(textoArquivo);
	}
}

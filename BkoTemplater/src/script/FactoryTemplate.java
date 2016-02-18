package script;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

import scriptTest.TemplateScript;

public class FactoryTemplate {

	public TemplateScript getTemplate(String caminhoArquivo) {
		Scanner entrada = null;
		String textoArquivo = "";
		try {
			InputStream is = new FileInputStream(caminhoArquivo);
			entrada = new Scanner(is);
			
			while (entrada.hasNextLine()) {
				textoArquivo += entrada.nextLine() + "\n";
			}			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			entrada.close();
		}
		return new TemplateScript(textoArquivo);
	}

}

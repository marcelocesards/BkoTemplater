package script.extrator;

public class ExtratorRetorno extends Extrator {
	public ExtratorRetorno(String metodo) {
		super(metodo);
	}

	public String getNome() {
		return getSubstringMaxLength30(getNomeMetodo() + "_return");
	}

	private String getSubstringMaxLength30(String string) {
		return string.length() <= 30 ? string : string.substring(0, 30);
	}

	public boolean temRetorno() {
		return regiaoDeclaracaoMetodo.contains(" return ");
	}

	public String getType() {
		return regiaoDeclaracaoMetodo.substring(regiaoDeclaracaoMetodo.indexOf(" return ") + 8);
	}

}

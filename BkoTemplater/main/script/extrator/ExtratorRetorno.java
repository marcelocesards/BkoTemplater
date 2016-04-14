package script.extrator;

public class ExtratorRetorno extends Extrator {
	public ExtratorRetorno(String metodo) {
		super(metodo);
	}

	public String getNome() {	
			return getNomeMetodo() + "_return";
	}
	
	public boolean temRetorno() {
		return regiaoDeclaracaoMetodo.contains(" return ");
	}

	public Object getType() {
		// TODO Auto-generated method stub
		return null;
	}

}

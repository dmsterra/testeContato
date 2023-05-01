package sistemabancario;

public class NomeNuloException extends Exception {
	
	public static String NOME_NULO = "O nome e o email do contato são obrigatórios!";
	public static String EMAIL_NULO = "O nome e o email do contato são obrigatórios!";
	
	public NomeNuloException (String msg) {
		super(msg);
	}

}

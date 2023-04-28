package sistemabancario;

/**
 * Classe {@link Contato} que representa um contato
 */
public class Contato {

	private int id;
	private String nome;
	private int idade;
	private String email;
	

	public Contato(int id, String nome, int idade, String email) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.email = email;
	}

	/**
	 * M�todo que retorna o ID do contato. 
	 * @return ID do contato
	 */
	public int getId() {
		return id;
	}

	/**
	 * M�todo que atualiza o ID do contato. 
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * M�todo que retorna o nome do contato. 
	 * @return nome do contato
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * M�todo que atualiza o nome do contato. 
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * M�todo que retorna a idade do contato. 
	 * @return idade do contato
	 */
	public int getIdade() {
		return idade;
	}

	/**
	 * M�todo que atualiza a idade do contato. 
	 */
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	/**
	 * M�todo que retorna o email do contato. 
	 * @return email do contato
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * M�todo que atualiza o email do contato. 
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		
		String str ="=========================" 
					+"Id: " + this.id + "\n"
					+ "Nome: " + this.nome + "\n"
					+ "Email: " + this.email + "\n"
					+ "Idade: " + this.idade + "\n"
					+ "=========================";
		return str;
	}
	
}

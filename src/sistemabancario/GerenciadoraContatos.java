package sistemabancario;

import java.util.List;

/**
 * Classe de negocio para realizar operacoes sobre os contatos de uma agenda.
 */
public class GerenciadoraContatos {

	private List<Contato> contatosAgenda;

	public GerenciadoraContatos(List<Contato> contatosAgenda) {
		this.contatosAgenda = contatosAgenda;
	}
	
	/**
	 * Retorna uma lista com todos os contatos de uma agenda
	 * @return lista com todos os contatos de uma agenda
	 */
	public List<Contato> getContatosAgenda() {
		return contatosAgenda;
	}
	
	/**
	 * Pesquisa por um contato a partir do seu ID.
	 * @param idContato id do contato a ser pesquisado
	 * @return o contato pesquisado ou null, caso n�o seja encontrado
	 */
	public Contato pesquisaContato (int idContato) {

		for (Contato contato : contatosAgenda) {
			if(contato.getId() == idContato)
				return contato;
		}
		return null;
	}
	
	/**
	 * Adiciona um novo contato � lista de contatos do banco.
	 * @param novoContato novo contato a ser adicionado
	 */
	public void adicionaContato (Contato novoContato) {
		contatosAgenda.add(novoContato);
	}

	/**
	 * Remove contato da lista de contatos do banco.
	 * @param idContato ID do contato a ser removido 
	 * @return true se o contato foi removido. False, caso contr�rio.
	 */
	public boolean removeContato (int idContato) {
		boolean contatoRemovido = false;
		
		for (int i = 0; i < contatosAgenda.size(); i++) {
			Contato contato = contatosAgenda.get(i);
			if(contato.getId() == idContato){
				contatosAgenda.remove(i);
				contatoRemovido = true;
				break;
			}
		}
		
		return contatoRemovido;
	}

	
	/**
	 * Limpa a lista de contatos, ou seja, remove todos eles. 
	 */
	public void limpa() {
		this.contatosAgenda.clear();
	}

	
}

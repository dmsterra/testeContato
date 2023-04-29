package sistemabancario;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sistemabancario.Contato;
import sistemabancario.GerenciadoraContatos;

/**
 * Classe de teste criada para garantir o funcionamento das principais operacoes
 * sobre Contatos, realizadas pela classe {@link GerenciadoraContatos}.
 * 
 * @author Diego Morais e Wallace Neves
 * @date 29/04/2023
 */
public class GerenciadoraContatosTest2 {

	private GerenciadoraContatos gerContatos;
	
	private int idContato01 = 1;
	private int idContato02 = 2;


	@Before
	public void setUp() {
		//************* Montagem do cenário global **********//
		Contato contato01 = new Contato(idContato01, "Joao da Silva", 47, "joaodasilva@gmail.com");
		Contato contato02 = new Contato(idContato02, "Maria da Silva", 10, "mariadasilva@gmail.com");


		List<Contato> contatosAgenda = new ArrayList<>();
		contatosAgenda.add(contato01);
		contatosAgenda.add(contato02);


		gerContatos = new GerenciadoraContatos(contatosAgenda);
	}

	@After
	public void tearDown() {
		//************* Desmontagem do cenário global **********//
		gerContatos.limpa();
	}

	/**
	 * Teste basico da pesquisa de um contato a partir do seu ID.
	 * 
	 * @author Diego Morais e Wallace Neves
	 * @date 29/04/2023
	 */
	@Test
	public void testPesquisaContato() {

		/* ========== Montagem do cen�rio ========== */
		//int idcontato01 = 1;
		//int idcontato02 = 2;
		// criando alguns contatos
		//contato contato01 = new contato(idcontato01, "Joao da Silva", 47, "joaodasilva@gmail.com", 1, true);
		//contato contato02 = new contato(idcontato02, "Maria da Silva", 10, "mariadasilva@gmail.com", 1, true);

		// inserindo os contatos criados na lista de contatos do banco
		//List<contato> contatosDoBanco = new ArrayList<>();
		//contatosDoBanco.add(contato01);
		//contatosDoBanco.add(contato02);

		//gercontatos = new Gerenciadoracontatos(contatosDoBanco);

		/* ========== Execu��o ========== */
		Contato contato = gerContatos.pesquisaContato(idContato01);

		/* ========== Verifica��es ========== */
		assertThat(contato.getId(), is(idContato01));

	}
	
	@Test
	public void testPesquisaContatoInexistente() {
		
		/* ========== Execu��o ========== */
		Contato contato = gerContatos.pesquisaContato(10);

		/* ========== Verifica��es ========== */
		assertNull(contato);
	}
	

	/**
	 * Teste b�sico da remo��o de um contato a partir do seu ID.
	 * 
	 * @author Diego Morais e Wallace Neves
	 * @date 29/04/2023
	 */
	@Test
	public void testRemoveContato() {

		/* ========== Montagem do cen�rio ========== */
		//		int idcontato01 = 1;
		//		int idContato02 = 2;
		//		// criando alguns contatos
		//		Contato contato01 = new Contato(idContato01, "Joao da Silva", 47, "joaodasilva@gmail.com", 1, true);
		//		Contato contato02 = new Contato(idContato02, "Maria da Silva", 10, "mariadasilva@gmail.com", 1, true);
		//		
		//		// inserindo os contatos criados na lista de contatos do banco
		//		List<Contato> contatosDoBanco = new ArrayList<>();
		//		contatosDoBanco.add(contato01);
		//		contatosDoBanco.add(contato02);
		//		
		//		gerContatos = new GerenciadoraContatos(contatosDoBanco);

		/* ========== Execu��o ========== */
		boolean contatoRemovido = gerContatos.removeContato(idContato02);

		/* ========== Verifica��es ========== */
		assertThat(contatoRemovido, is(true));
		assertThat(gerContatos.getContatosAgenda().size(), is(1));
		assertNull(gerContatos.pesquisaContato(idContato02));

	}
	
	@Test
	public void testRemoveContatoInexistente() {

		/* ========== Execu��o ========== */
		boolean contatoRemovido = gerContatos.removeContato(10);

		/* ========== Verifica��es ========== */
		assertThat(contatoRemovido, is(false));
		assertFalse(contatoRemovido);
		assertThat(gerContatos.getContatosAgenda().size(), is(2));
	}
	
	@Test
	public void testAdicionaContato()throws Exception {
		
		//execucao do teste
		Contato contato = new Contato(3, "Diego", 32, "diego@gmail.com");
		gerContatos.adicionaContato(contato);
		
		//verificacao do teste
		assertTrue(true);
		
	}
	
}


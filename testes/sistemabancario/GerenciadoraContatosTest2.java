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
	private int idContato03 = 3;


	@Before
	public void setUp() {
		
		//************* Montagem do cenário global **********
		Contato contato01 = new Contato(idContato01, "Joao da Silva", 47, "joaodasilva@gmail.com");
		Contato contato02 = new Contato(idContato02, "Maria da Silva", 10, "mariadasilva@gmail.com");
		Contato contato03 = new Contato(idContato03, "Rafaela", 19, "rafaeladasilva@gmail.com");


		List<Contato> contatosAgenda = new ArrayList<>();
		contatosAgenda.add(contato01);
		contatosAgenda.add(contato02);
		contatosAgenda.add(contato03);
		


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

		/* ========== Execucao ========== */
		Contato contato = gerContatos.pesquisaContato(idContato01);

		/* ========== Verifica��es ========== */
		assertThat(contato.getId(), is(idContato01));
		assertNotNull(idContato01);
		assertThat(gerContatos.getContatosAgenda().size(),is(3));

	}
	
	@Test
	public void testPesquisaContatoInexistente() {
		
		/* ========== Execu��o ========== */
		Contato contato = gerContatos.pesquisaContato(10);

		/* ========== Verifica��es ========== */
		assertNull(contato);
	}
	

	/**
	 * Teste basico de remocao de um contato a partir do seu ID.
	 * 
	 * @author Diego Morais e Wallace Neves
	 * @date 29/04/2023
	 */
	@Test
	public void testRemoveContato() {
		
		//Execucao do teste
		boolean contatoRemovido = gerContatos.removeContato(idContato02);

		//Verificacao do teste
		assertThat(contatoRemovido, is(true));
		assertThat(gerContatos.getContatosAgenda().size(), is(1));
		assertNull(gerContatos.pesquisaContato(idContato02));

	}

	
	/**
	 * Teste basico de adicao de um contato
	 * 
	 * @author Diego Morais e Wallace Neves
	 * @date 30/04/2023
	 */
	@Test
	public void testAdicionaContato()throws Exception {
		
		//execucao do teste
		Contato contato = new Contato(4, "Diego", 32, "diego@gmail.com");
		gerContatos.adicionaContato(contato);
		
		//verificacao do teste
		assertTrue(true);
		
	}
	
	@Test
	public void testAdicionaContatoComNomeVazio() {
		
		//execucao do teste
		try {
			Contato contato = new Contato(4,"", 32, "diego@gmail.com");
			gerContatos.adicionaContato(contato);
			fail();
			
		//verificacao do teste	
		} catch (Exception e) {
			assertThat(e.getMessage(), is(NomeNuloException.NOME_NULO));
			assertNull(gerContatos.pesquisaContato(4));
		}
		
		
		
		
		
		
	}
	
}


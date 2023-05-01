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
public class GerenciadoraContatosTest {

	private GerenciadoraContatos gerContatos;
	
	private int idContato01 = 1;
	private int idContato02 = 2;
	private int idContato03 = 3;

	
	@Before
	public void setUp() {
		
		//Montagem do cenario global 
		Contato contato01 = new Contato(idContato01, "Robson Pomponet", 47, "robson@gmail.com");
		Contato contato02 = new Contato(idContato02, "Emanuel Martins", 10, "mariadasilva@gmail.com");
		Contato contato03 = new Contato(idContato03, "Johnny Tafur", 19, "johnnytafur@gmail.com");


		List<Contato> contatosAgenda = new ArrayList<>();
		contatosAgenda.add(contato01);
		contatosAgenda.add(contato02);
		contatosAgenda.add(contato03);
		


		gerContatos = new GerenciadoraContatos(contatosAgenda);
	}

	@After
	public void tearDown() {
		//Desmontagem do cenário global
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

		//Execucao
		Contato contato = gerContatos.pesquisaContato(idContato01);

		//Verificacao
		assertThat(contato.getId(), is(idContato01));
		assertNotNull(idContato01);
		assertThat(gerContatos.getContatosAgenda().size(),is(3));

	}
	
	
	@Test
	public void testPesquisaContatoInexistente() {
		
		//execucao do teste
		Contato contato = gerContatos.pesquisaContato(10);
		
		//verificacao do teste
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
		
		//execucao do teste
		boolean contatoRemovido = gerContatos.removeContato(idContato02);

		//verificacao do teste
		assertThat(contatoRemovido, is(true));
		assertThat(gerContatos.getContatosAgenda().size(), is(2));
		assertNull(gerContatos.pesquisaContato(idContato02));

	}
	
	@Test
	public void testRemoveContatoInexistente() {
		
		//execucao do teste
		boolean contatoRemovido = gerContatos.removeContato(idContato04);
		
		//verificacao do teste
		assertThat(contatoRemovido, is(false));
		assertThat(gerContatos.getContatosAgenda().size(), is(3));
		
		
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
		assertNotNull(contato);
		
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


package sistemabancario;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import sistemabancario.Contato;
import sistemabancario.GerenciadoraContatos;

/**
 * Classe de teste criada para garantir o funcionamento das principais opera��es
 * sobre clientes, realizadas pela classe {@link GerenciadoraContatos}.
 * 
 * @author Clayton Chagas
 * @date 30/09/2022 
 */
public class GerenciadoraClientesTest1 {

	private GerenciadoraContatos gerClientes;

	/**
	 * Teste b�sico da pesquisa de um cliente a partir do seu ID.
	 * 
	 * @author Clayton Chagas
	 * @date 30/09/2022
	 */
	@Test
	public void testPesquisaCliente() {

		/* ========== Montagem do cen�rio ========== */
		int idCliente01 = 1;
		int idCliente02 = 2;
		// criando alguns clientes
		Contato cliente01 = new Contato(idCliente01, "Joao da Silva", 47, "joaodasilva@gmail.com", 1, true);
		Contato cliente02 = new Contato(idCliente02, "Maria da Silva", 10, "mariadasilva@gmail.com", 1, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Contato> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerClientes = new GerenciadoraContatos(clientesDoBanco);

		/* ========== Execu��o ========== */
		Contato cliente = gerClientes.pesquisaCliente(idCliente01);
		
		/* ========== Verifica��es ========== */
		assertThat(cliente.getId(), is(idCliente01));
		
	}
	
	/**
	 * Teste b�sico da remo��o de um cliente a partir do seu ID.
	 * 
	 * @author Clayton Chagas
	 * @date 30/09/2022
	 */
	@Test
	public void testRemoveCliente() {

		/* ========== Montagem do cen�rio ========== */
		int idCliente01 = 1;
		int idCliente02 = 2;
		// criando alguns clientes
		Contato cliente01 = new Contato(idCliente01, "Joao da Silva", 47, "joaodasilva@gmail.com", 1, true);
		Contato cliente02 = new Contato(idCliente02, "Maria da Silva", 10, "mariadasilva@gmail.com", 1, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Contato> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerClientes = new GerenciadoraContatos(clientesDoBanco);
		
		/* ========== Execu��o ========== */
		boolean clienteRemovido = gerClientes.removeCliente(idCliente02);
		
		/* ========== Verifica��es ========== */
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(idCliente02));
		
	}
	
}

//Documenta��o e coment�rios
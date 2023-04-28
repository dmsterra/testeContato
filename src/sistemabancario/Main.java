package sistemabancario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static GerenciadoraContatos gerContatos;
	
	public static void main(String[] args) {
		
		inicializaSistemaBancario(); // criando alguns contatos ficticios
		
		Scanner sc = new Scanner(System.in);
		boolean continua = true;
		
		while (continua){
			
			printMenu();
			
			int opcao = sc.nextInt();
			
			switch (opcao) {
			// Consultar por um contato
			case 1:
				System.out.print("Digite o ID do contato: ");
				int idContato = sc.nextInt();
				Contato contato = gerContatos.pesquisaContato(idContato);
				
				if(contato != null)
					System.out.println(contato.toString());
				else
					System.out.println("Contato n�o encontrado!");
				
				pulalinha();
				break;

			// Consultar por uma conta corrente
			case 2:
				System.out.print("Digite o ID da conta: ");
				int idConta = sc.nextInt();
				ContaCorrente conta = gerContas.pesquisaConta(idConta);
				
				if(conta != null)
					System.out.println(conta.toString());
				else
					System.out.println("Conta n�o encontrado!");
				
				pulalinha();
				break;

			// Ativar um contato
			case 3:
				
				System.out.print("Digite o ID do contato: ");
				int idContato2 = sc.nextInt();
				Contato contato2 = gerContatos.pesquisaContato(idContato2);
				
				if(contato2 != null){
					contato2.setAtivo(true);
					System.out.println("Contato ativado com sucesso!");
				}
				else
					System.out.println("Contato n�o encontrado!");
			
				pulalinha();
				break;
				
			// Desativar um contato
			case 4:
				
				System.out.print("Digite o ID do contato: ");
				int idContato3 = sc.nextInt();
				Contato contato3 = gerContatos.pesquisaContato(idContato3);
				
				if(contato3 != null){
					contato3.setAtivo(false);
					System.out.println("Contato desativado com sucesso!");
				}
				else
					System.out.println("Contato n�o encontrado!");
				
				pulalinha();
				break;
			
			// Sair
			case 5:
				continua = false;
				System.out.println("################# Sistema encerrado #################");
				break;
				
			default:
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				break;
				
			} 
			
		}
	
		
	}

	private static void pulalinha() {
		System.out.println("\n");
	}

	/**
	 * Imprime menu de op��es do nosso sistema banc�rio
	 */
	private static void printMenu() {
		
		System.out.println("O que voc� deseja fazer? \n");
		System.out.println("1) Consultar por um contato");
		System.out.println("2) Consultar por uma conta corrente");
		System.out.println("3) Ativar um contato");
		System.out.println("4) Desativar um contato");
		System.out.println("5) Sair");
		System.out.println();
		
	}

	/**
	 * M�todo que cria e insere algumas contas e contatos no sistema do banco,
	 * apenas para realiza��o de testes manuais atrav�s do m�todo main acima.
	 */
	private static void inicializaSistemaBancario() {
		// criando lista vazia de contas e contatos
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		List<Contato> contatosDoBanco = new ArrayList<>();
		
		// criando e inserindo duas contas na lista de contas correntes do banco
		ContaCorrente conta01 = new ContaCorrente(1, 0, true);
		ContaCorrente conta02 = new ContaCorrente(2, 0, true);
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		// criando dois contatos e associando as contas criadas acima a eles
		Contato contato01 = new Contato(1, "Joao da Silva", 20, "joaodasilva@gmail.com", conta01.getId(), true);
		Contato contato02 = new Contato(2, "Maria da Silva", 30, "mariadasilva@gmail.com", conta02.getId(), true);
		// inserindo os contatos criados na lista de contatos do banco
		contatosDoBanco.add(contato01);
		contatosDoBanco.add(contato02);
		
		gerContatos = new GerenciadoraContatos(contatosDoBanco);

		
	}
	
}


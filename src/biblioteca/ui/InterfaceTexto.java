package biblioteca.ui;

import java.util.Scanner;

public class InterfaceTexto {
	private Scanner entrada;
	private Estado estadoAtual;
	
	private static final int OP_CLIENTE = 1;
	private static final int OP_CONTA = 2;
	private static final int OP_SAIR = 0;
	private static final int OP_ADICIONAR = 1;
	private static final int OP_EDITAR = 2;
	private static final int OP_EXCLUIR = 3;
	private static final int OP_LISTAR = 4;
	
	private enum Estado {PRINCIPAL, CLIENTE, CONTA};
	
	public InterfaceTexto() {
		entrada = new Scanner(System.in);
		estadoAtual = Estado.PRINCIPAL;
	}
	
	private void imprimeMenu() {
		
		System.out.println();
		
		switch (estadoAtual) {
		case CLIENTE:
			imprimeMenuAutor();
			break;
		case CONTA:
			imprimeMenuLivro();
			break;
		default:
			imprimeMenuPrincipal();
		}
		System.out.println();
		System.out.println("0 - Sair");
		
		System.out.println();
		System.out.print("Escolha uma opção: ");	
	}
	
	private int leOpcao() {
		int opcao = entrada.nextInt();
		entrada.nextLine();
		return opcao;
	}
	
	private void imprimeMenuPrincipal() {
		System.out.println("1 - Administração de Autores");
		System.out.println("2 - Administração de Livros");
	}
	
	private void imprimeMenuAutor() {
		System.out.println("1 - Adicionar cliente");
		System.out.println("2 - Editar cliente");
		System.out.println("3 - Excluir cliente");
		System.out.println("4 - Listar clientes");
	}
	
	private void imprimeMenuLivro() {
		System.out.println("1 - Adicionar livro");
		System.out.println("2 - Editar livro");
		System.out.println("3 - Excluir livro");
		System.out.println("4 - Listar livros");
	}
		
	public void executa() {
		InterfaceModeloTexto subMenu;
		
		imprimeMenu();
		int opcao = leOpcao();
		
		while (opcao != OP_SAIR) {
			if (estadoAtual == Estado.PRINCIPAL) {
				estadoAtual = opcao == OP_CLIENTE ? Estado.CLIENTE : Estado.CONTA;
			} else {
				subMenu = estadoAtual == Estado.CLIENTE ? 
						new InterfaceAutorTexto() : new InterfaceAutorTexto();
				
				switch (opcao) {
				case OP_ADICIONAR:
					subMenu.adicionar();
					break;
				case OP_EDITAR:
					subMenu.editar();
					break;
				case OP_EXCLUIR:
					subMenu.excluir();
					break;
				case OP_LISTAR:
					subMenu.listarTodos();
					break;
				default:
					System.out.println("Opção Inválida. Tente novamente!");
				}
			}
			
			imprimeMenu();
			opcao = leOpcao();
		}
		
	}
	
}

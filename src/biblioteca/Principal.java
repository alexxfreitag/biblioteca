package biblioteca;

import java.util.Scanner;

import biblioteca.ui.InterfaceTexto;
import biblioteca.ui.InterfaceLivroTexto;

public class Principal {
	
	
	public static void main(String[] args) {

		InterfaceTexto interfaceTexto = new InterfaceTexto();
		System.out.println("Biblioteca");
		
		interfaceTexto.executa();
		
		System.out.println("1 - Adicionar livro");
		System.out.println("2 - Editar livro");
		System.out.println("3 - Excluir livro");
		System.out.println("4 - Listar livros");
		
		System.out.println("Digite a opção desejada: ");
		int opcao = entrada.nextInt();
		entrada.nextLine();

		if (opcao == 1)
			InterfaceLivroTexto.adicionar();
		else if (opcao == 2)
			InterfaceLivroTexto.editar();
		else if (opcao == 3)
			InterfaceLivroTexto.excluir();
		else if (opcao == 4)
			InterfaceLivroTexto.listarTodos();
		else 
			System.out.println("Opção incorreta!");
	}

}

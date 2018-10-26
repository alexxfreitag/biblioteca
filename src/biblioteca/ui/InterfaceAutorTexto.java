package biblioteca.ui;

import java.util.List;

import biblioteca.dao.AutorDao;
import biblioteca.modelo.Autor;

public class InterfaceAutorTexto extends InterfaceModeloTexto {
	
	private AutorDao dao;
	
	public InterfaceAutorTexto() {
		super();
		dao = new AutorDao();
	}
	
	private Autor obtemDadosAutor(Autor autor) {
		
		boolean erro_processo = false;
		String nome_autor = "";
		Long cpf_autor;
		do {
			
			nome_autor = lerNome();
			if (nome_autor.trim().contains(" ")) {
				
				System.out.println("ATENÇÃO! Apenas o primeiro nome.\n");
				erro_processo = true;
			} else erro_processo = false;
			
		} while (erro_processo);
		
		do {
			
			cpf_autor = lerCPF();
			if (cpf_autor.toString().length() != 11) {
				
				System.out.println("ATENÇÃO! Deve-se digitar 11 números.\n");
				erro_processo = true;
			} else erro_processo = false;
			
		} while (erro_processo);
		
		Autor novoAutor = new Autor(0, nome_autor, cpf_autor);
		
		return novoAutor;
	}
	
	private String lerNome(){
		
		System.out.print("Insira o nome do autor: ");
		String nome = entrada.nextLine().toUpperCase();
		return nome;
		
	}
	
	private long lerCPF(){
		
		System.out.println("Insira o CPF do autor (somente números): ");
		Long cpf = entrada.nextLong();
		return cpf;
	}
	
	@Override
	public void adicionar() {
		System.out.println("Adicionar autor");
		System.out.println();
		
		Autor novoAutor = obtemDadosAutor(null);	
		dao.insert(novoAutor);
		
	}

	@Override
	public void listarTodos() {
		List<Autor> autores = dao.getAll();
		
		if (!autores.isEmpty()) {
			System.out.println("Lista de autores");
			System.out.println();
			
			System.out.println("id\tNome\tCPF");
			
			for (Autor autor : autores) {
				imprimeItem(autor);
			}
		} else {
			
			System.out.println("\nNão existem autores cadastrados. Caso deseja adicionar um, entre com o número 1.");
			int opcao = entrada.nextInt();
			System.out.println();
			
			if (opcao == 1)
				adicionar();
		}
	}

	@Override
	public void editar() {
		listarTodos();
		
		System.out.println("Editar autor");
		System.out.println();
		
		System.out.print("Entre o id do autor: ");
		int id = entrada.nextInt();
		entrada.nextLine();
		
		Autor autorAModifcar = dao.getByKey(id);
		
		Autor novoAutor = obtemDadosAutor(autorAModifcar);
		
		novoAutor.setId(id);
		
		dao.update(novoAutor);
		
	}

	@Override
	public void excluir() {
		listarTodos();
		
		System.out.println("Excluir autor");
		System.out.println();
		
		System.out.print("Entre o id do autor: ");
		int id = entrada.nextInt();
		entrada.nextLine();
		
		dao.delete(id);
		
	}

}

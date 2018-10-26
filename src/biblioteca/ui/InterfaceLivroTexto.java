package biblioteca.ui;

import java.util.List;

import biblioteca.Principal;
import biblioteca.dao.AutorDao;
import biblioteca.dao.Dao;
import biblioteca.modelo.Autor;
import biblioteca.modelo.Livro;
import biblioteca.dao.LivroDao;

public class InterfaceLivroTexto extends InterfaceModeloTexto{
	
	private AutorDao autorDao;
	private LivroDao livroDao;
	
	public InterfaceLivroTexto() {
		
		super();
		autorDao = new AutorDao();
		livroDao = new LivroDao();
	}
	
	@Override
	public void adicionar() {
		System.out.println("Adicionar livro");
		System.out.println();
		
		Livro novoLivro = obtemDadosLivro(null);
		livroDao.insert(novoLivro);
	}
	
	@Override
	public void editar() {
		listarTodos();
		
		System.out.println("Editar livro");
		System.out.println();
		
		System.out.print("Entre o id da livro: ");
		int id = entrada.nextInt();
		entrada.nextLine();
		
		Livro livroAModificar = livroDao.getByKey(id);
		
		Livro novoLivro = obtemDadosLivro(livroAModificar);
		
		novoLivro.setId(id);
		
		livroDao.update(novoLivro);
	}
	
	private Livro obtemDadosLivro(Livro livro){
		
		System.out.print("Insira o título do livro: ");
		String titulo = entrada.nextLine();
		
		System.out.println("Insira o ano da publicação do livro: ");
		int ano = entrada.nextInt();
		entrada.nextLine();
		
		System.out.println("Insira a editora do livro: ");
		String editora = entrada.nextLine();
		
		System.out.println("Insira o ID do autor: ");
		int idAutor = entrada.nextInt();
		entrada.nextLine();
		
		Autor autor = autorDao.getByKey(idAutor);
		
		return new Livro(0, titulo, ano, editora, autor);
		
	}
	
	@Override
	public void listarTodos() {
		List<Livro> livros = livroDao.getAll();
		
		System.out.println("Lista de livros");
		System.out.println();
		
		System.out.println("id\tTitulo\tAno de publicacao\tEditora\tID do Autor\tNome do Autor");
		
		for (Livro livro : livros) {
			imprimeItem(livro);
		}
	}
	
	@Override
	public void excluir() {
		listarTodos();
		
		System.out.println("Excluir livro");
		System.out.println();
		
		System.out.print("Entre o id da livro: ");
		int id = entrada.nextInt();
		entrada.nextLine();
		
		livroDao.delete(id);
	}
}

package biblioteca.ui;

import banco.modelo.Conta;
import biblioteca.Principal;
import biblioteca.dao.AutorDao;
import biblioteca.dao.Dao;
import biblioteca.modelo.Autor;
import biblioteca.modelo.Livro;

public class InterfaceLivroTexto extends Principal{
	
	private AutorDao autorDao;
	private LivroDao dao;
	
	public InterfaceLivroTexto() {
		
		super();
		autorDao = new AutorDao();
		dao = new LivroDao();
	}
	
	@Override
	public void adicionar() {
		System.out.println("Adicionar livro");
		System.out.println();
		
		Livro novoLivro = obtemDadosLivro(null);
		dao.insert(novoLivro);
	}
	
	@Override
	public void editarLivro() {
		listarTodos();
		
		System.out.println("Editar conta");
		System.out.println();
		
		System.out.print("Entre o id da conta: ");
		int id = entrada.nextInt();
		entrada.nextLine();
		
		Conta contaAModificar = dao.getByKey(id);
		
		Conta novaConta = obtemDadosConta(contaAModificar);
		
		novaConta.setId(id);
		
		dao.update(novaConta);
	}
	
	private Livro obtemDadosLivro(Livro livro){
		
		System.out.print("Insira o título do livro: ");
		String titulo = entrada.nextLine();
		
		System.out.print("Insira o ano da publicação do livro: ");
		int ano = entrada.nextInt();
		
		System.out.print("Insira a editora do livro: ");
		String editora = entrada.nextLine();
		
		System.out.print("Insira o ID do livro: ");
		int idLivro = entrada.nextInt();
		
		Autor autor = autorDao.getByKey(idLivro);
		
		return new Livro(0, titulo, ano, editora, autor);
		
	}
}

package biblioteca.modelo;

import biblioteca.modelo.Autor;

public class Livro implements Imprimivel{

	private int id;
	private String titulo;
	private int anoPublicacao;
	private Autor autor;
	private String editora;
	
	public Livro() { super(); }
	
	public Livro(int id, String titulo, int anoPublicacao, String editora, Autor autor) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.anoPublicacao = anoPublicacao;
		this.autor = autor;
		this.editora = editora;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	@Override
	public String imprimeEmLista() {
		return String.format("%d\t%s\t%d\t%s\t%d\t%s", getId(), getTitulo(), getAnoPublicacao(), getEditora(), 
				getAutor().getId(), getAutor().getNome());
	}

	@Override
	public String[] getColunas() {
		String[] colunas = {"id", "Titulo", "Ano de publicacao", "Editora", "Id Autor"};
		return colunas;
	}
	
	
}

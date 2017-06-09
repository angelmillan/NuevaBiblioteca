package Modelo;

public class Ejemplar {

	private int numero_ejemplar;
	private String isbn_Ejemplar;
	private String titulo;
	private String autor;
	private String editorial;
	private int edicion;
	
	public Ejemplar(String isbn_Ejemplar, int numero_ejemplar) {
		super();
		this.isbn_Ejemplar = isbn_Ejemplar;
		this.numero_ejemplar = numero_ejemplar;	
	}
	
	public Ejemplar(String isbn_Ejemplar, int numero_ejemplar, String titulo, String autor, String editorial, int edicion) {
		super();
		this.isbn_Ejemplar = isbn_Ejemplar;
		this.numero_ejemplar = numero_ejemplar;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.edicion = edicion;
		
	}
	
	
	
	/**
	 * @return the numero_ejemplar
	 */
	public int getNumero_ejemplar() {
		return numero_ejemplar;
	}
	/**
	 * @param numero_ejemplar the numero_ejemplar to set
	 */
	public void setNumero_ejemplar(int numero_ejemplar) {
		this.numero_ejemplar = numero_ejemplar;
	}
	/**
	 * @return the isbnEjemplar
	 */
	public String getIsbnEjemplar() {
		return isbn_Ejemplar;
	}
	/**
	 * @param isbnEjemplar the isbnEjemplar to set
	 */
	public void setIsbn_Ejemplar(String isbn_Ejemplar) {
		this.isbn_Ejemplar = isbn_Ejemplar;
	}

	
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * @param autor the autor to set
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * @return the editorial
	 */
	public String getEditorial() {
		return editorial;
	}

	/**
	 * @param editorial the editorial to set
	 */
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	/**
	 * @return the edicion
	 */
	public int getEdicion() {
		return edicion;
	}

	/**
	 * @param edicion the edicion to set
	 */
	public void setEdicion(int edicion) {
		this.edicion = edicion;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ejemplar [isbn_Ejemplar=" + isbn_Ejemplar + ", numero_ejemplar=" + numero_ejemplar + ", titulo="
				+ titulo + ", autor=" + autor + ", editorial=" + editorial + ", edicion=" + edicion + "]\n";
	}
	
	
	
	

}

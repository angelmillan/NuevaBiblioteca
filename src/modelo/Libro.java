package modelo;

public class Libro {

	private String isbnLibro;
	private String titulo;
	private String autor;
	private String editorial;
	private int edicion;
	public Libro(String isbnLibro, String titulo, String autor, String editorial, int edicion) {
		this.isbnLibro = isbnLibro;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.edicion = edicion;
	}
	
	/**
	 * @return the isbnLibro
	 */
	public String getIsbnLibro() {
		return isbnLibro;
	}
	/**
	 * @param isbnLibro the isbnLibro to set
	 */
	public void setIsbnLibro(String isbnLibro) {
		this.isbnLibro = isbnLibro;
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
		return "Libro ISBN = " + isbnLibro + ", TITULO = " + titulo + ", AUTOR = " + autor + ", EDITORIAL = " + editorial
				+ ", EDICION = " + edicion + "]\n";
	}

	
}

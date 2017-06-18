package modelo;

public class Prestamo {
	
	
	private String dni;
	private String nombre;
	private String apellidos;
	private String isbn;
	private String titulo;
	private String autor;
	private int ejemplar;
	private String prestamo;
	private String devolucion;
	
	public Prestamo(String dni, String nombre, String apellidos, String isbn, String titulo, String autor, int ejemplar,
			String prestamo) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.ejemplar = ejemplar;
		this.prestamo = prestamo;
	}

	public Prestamo(String dni, String nombre, String apellidos, String isbn, String titulo, String autor, int ejemplar,
			String prestamo, String devolucion) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.ejemplar = ejemplar;
		this.prestamo = prestamo;
		this.devolucion = devolucion;
	}
	
	

	public Prestamo(String isbn, String titulo, String autor) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
	}
	
	

	public Prestamo(String dni, String isbn, int ejemplar) {
		super();
		this.dni = dni;
		this.isbn = isbn;
		this.ejemplar = ejemplar;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
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
	 * @return the ejemplar
	 */
	public int getEjemplar() {
		return ejemplar;
	}

	/**
	 * @param ejemplar the ejemplar to set
	 */
	public void setEjemplar(int ejemplar) {
		this.ejemplar = ejemplar;
	}

	/**
	 * @return the prestamo
	 */
	public String getPrestamo() {
		return prestamo;
	}

	/**
	 * @param prestamo the prestamo to set
	 */
	public void setPrestamo(String prestamo) {
		this.prestamo = prestamo;
	}

	/**
	 * @return the devolucion
	 */
	public String getDevolucion() {
		return devolucion;
	}

	/**
	 * @param devolucion the devolucion to set
	 */
	public void setDevolucion(String devolucion) {
		this.devolucion = devolucion;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Prestamo [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", isbn=" + isbn
				+ ", titulo=" + titulo + ", autor=" + autor + ", ejemplar=" + ejemplar + ", prestamo=" + prestamo
				+ ", devolucion=" + devolucion + "]";
	}
	
	

	

}

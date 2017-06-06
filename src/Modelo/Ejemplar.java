package Modelo;

public class Ejemplar {

	private int numero_ejemplar;
	private String isbnEjemplar;
	public Ejemplar(int numero_ejemplar, String isbnEjemplar) {
		super();
		this.numero_ejemplar = numero_ejemplar;
		this.isbnEjemplar = isbnEjemplar;
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
		return isbnEjemplar;
	}
	/**
	 * @param isbnEjemplar the isbnEjemplar to set
	 */
	public void setIsbnEjemplar(String isbnEjemplar) {
		this.isbnEjemplar = isbnEjemplar;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ejemplar [numero_ejemplar=" + numero_ejemplar + ", isbnEjemplar=" + isbnEjemplar + "]";
	}
	
	

}

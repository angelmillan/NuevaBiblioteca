package modelo;

public class Usuario {

	private String dniUsuario;
	private String nombre;
	private String apellidos;
	private String direccion;
	
	public Usuario(String dniUsuario, String nombre, String apellidos, String direccion) {
		super();
		this.dniUsuario = dniUsuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
	}
	
	

	public Usuario(String dniUsuario) {
		super();
		this.dniUsuario = dniUsuario;
	}



	/**
	 * @return the dniUsuario
	 */
	public String getDniUsuario() {
		return dniUsuario;
	}

	/**
	 * @param dniUsuario the dniUsuario to set
	 */
	public void setDniUsuario(String dniUsuario) {
		this.dniUsuario = dniUsuario;
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
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Usuario [dniUsuario=" + dniUsuario + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion="
				+ direccion + "]\n";
	}

	
	
}

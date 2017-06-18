package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class PrestamoDAO {
	
	private boolean problemaSQLprestadosDAO = false;
	List<Prestamo> listaprestado = new ArrayList<Prestamo>();
	List<Prestamo> listadevuelto = new ArrayList<Prestamo>();
	List<Prestamo> listalibrosconejemplares = new ArrayList<Prestamo>();
	String sql="";
	PreparedStatement preparedStatement;
	Statement statement;
	ResultSet resultSet;
	int filas=0;	

	public List<Prestamo> obtenerListaPrestados() {

		sql = "SELECT * FROM prestamo where devolucion IS NULL;";
		Connection conexion = Conexion.getInstance();
		try {
			statement = conexion.createStatement();
			resultSet = statement.executeQuery(sql);
			//System.out.println(resultSet);
			while(resultSet.next()){
				String dni = resultSet.getString(1);
				String nombre = resultSet.getString(2);
				String apellidos = resultSet.getString(3);
				String isbn = resultSet.getString(4);
				String titulo = resultSet.getString(5);
				String autor = resultSet.getString(6);
				int ejemplar = resultSet.getInt(7);
				String fechaPrestamo = resultSet.getString(8);
				Prestamo prestamo = new Prestamo(dni,nombre,apellidos,isbn,titulo,autor,ejemplar,fechaPrestamo);
				listaprestado.add(prestamo);
			}
		} catch (SQLException e) {
			problemaSQLprestadosDAO = true;
			//System.out.println("Problema al leer los datos de la base de datos (obtenerListaLibros).");
			JOptionPane.showMessageDialog(null, "Problema leer la vista de prestamos", "Problema SQL", JOptionPane.ERROR_MESSAGE);
		}			
		return listaprestado;
	}
	public List<Prestamo> obtenerListaDevueltos() {

		sql = "SELECT * FROM prestamo  where devolucion IS NOT NULL;";
		Connection conexion = Conexion.getInstance();
		try {
			statement = conexion.createStatement();
			resultSet = statement.executeQuery(sql);
			//System.out.println(resultSet);
			while(resultSet.next()){
				String dni = resultSet.getString(1);
				String nombre = resultSet.getString(2);
				String apellidos = resultSet.getString(3);
				String isbn = resultSet.getString(4);
				String titulo = resultSet.getString(5);
				String autor = resultSet.getString(6);
				int ejemplar = resultSet.getInt(7);
				String fechaPrestamo = resultSet.getString(8);
				String devuelto = resultSet.getString(9);

				Prestamo prestamo = new Prestamo(dni,nombre,apellidos,isbn,titulo,autor,ejemplar,fechaPrestamo, devuelto);
				listadevuelto.add(prestamo);
			}
		} catch (SQLException e) {
			problemaSQLprestadosDAO = true;
			//System.out.println("Problema al leer los datos de la base de datos (obtenerListaLibros).");
			JOptionPane.showMessageDialog(null, "Problema leer la vista de prestamos", "Problema SQL", JOptionPane.ERROR_MESSAGE);
		}			
		return listadevuelto;
	}
	public List<Prestamo> obtenerLibrosConEjemplares() {
		sql = "select distinct isbn, titulo, autor from libros, ejemplares where libros.ISBN = ejemplares.ISBN_ejemplar order by titulo;";
		Connection conexion = Conexion.getInstance();
		try {
			statement = conexion.createStatement();
			resultSet = statement.executeQuery(sql);
			//System.out.println(resultSet);
			while(resultSet.next()){
				String isbn = resultSet.getString(1);
				String titulo = resultSet.getString(2);
				String autor = resultSet.getString(3);
				Prestamo prestamo = new Prestamo(isbn,titulo,autor);
				listalibrosconejemplares.add(prestamo);
			}
		} catch (SQLException e) {
			problemaSQLprestadosDAO = true;
			//System.out.println("Problema al leer los datos de la base de datos (obtenerListaLibros).");
			JOptionPane.showMessageDialog(null, "Problema leer la vista de prestamos", "Problema SQL", JOptionPane.ERROR_MESSAGE);
		}			
		return listalibrosconejemplares;

	}
	public boolean  devolverPrestamo(Prestamo prestamo) {
		problemaSQLprestadosDAO = false;
		filas = 0;
		//UPDATE prestamos SET fecha_devolucion = strftime('%d-%m-%Y',(SUBSTR(datetime(CURRENT_TIMESTAMP,'localtime'),1,10))) WHERE FECHA_PRESTAMO = '16-06-2017' AND DNI_PRESTAMO = '44558874N' AND  ISBN_PRESTAMO = '650797490-0' AND NUMERO_EJEMPLAR_PRESTAMO = 3;

		sql = "UPDATE prestamos SET fecha_devolucion = strftime('%d-%m-%Y',(SUBSTR(datetime(CURRENT_TIMESTAMP,'localtime'),1,10))) WHERE FECHA_PRESTAMO = ? AND DNI_PRESTAMO = ? AND  ISBN_PRESTAMO = ? AND NUMERO_EJEMPLAR_PRESTAMO = ?;";
		Connection conexion = Conexion.getInstance();			
		try {
			preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, prestamo.getPrestamo());
			preparedStatement.setString(2, prestamo.getDni());
			preparedStatement.setString(3, prestamo.getIsbn());
			preparedStatement.setInt(4, prestamo.getEjemplar());			
			filas = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			problemaSQLprestadosDAO = true;
			JOptionPane.showMessageDialog(null, "Problema al devolver el ejemplar", "Problema JBDC", JOptionPane.ERROR_MESSAGE);			
		}			
		if(filas!=0)
			return true;	
		return false;
	}
	public boolean  anularDevolución(Prestamo prestamo) {
		problemaSQLprestadosDAO = false;
		filas = 0;
		//insert into prestamos (DNI_PRESTAMO,ISBN_PRESTAMO,NUMERO_EJEMPLAR_PRESTAMO) VALUES ('10520880U','078849629-8',2);
		sql = "UPDATE prestamos SET fecha_devolucion = '' WHERE FECHA_PRESTAMO = ? AND DNI_PRESTAMO = ? AND  ISBN_PRESTAMO = ? AND NUMERO_EJEMPLAR_PRESTAMO = ?;";

		Connection conexion = Conexion.getInstance();			
		try {
			preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, prestamo.getPrestamo());
			preparedStatement.setString(2, prestamo.getDni());
			preparedStatement.setString(3, prestamo.getIsbn());
			preparedStatement.setInt(4, prestamo.getEjemplar());			
			filas = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			problemaSQLprestadosDAO = true;
			JOptionPane.showMessageDialog(null, "Problema al devolver el ejemplar", "Problema JBDC", JOptionPane.ERROR_MESSAGE);			
		}			
		if(filas!=0)
			return true;	
		return false;
	}
	public boolean prestarEjemplarAUsuario (Prestamo prestamo) {		
			problemaSQLprestadosDAO = false;
			filas=0;
			//insert into prestamos (DNI_PRESTAMO,ISBN_PRESTAMO,NUMERO_EJEMPLAR_PRESTAMO) VALUES ('10520880U','078849629-8',2);
			sql = "INSERT INTO prestamos(dni_prestamo, isbn_prestamo, numero_ejemplar_prestamo) values(?,?,?);";
			Connection conexion = Conexion.getInstance();		
			try {
				preparedStatement = conexion.prepareStatement(sql);
				preparedStatement.setString(1, prestamo.getDni());
				preparedStatement.setString(2, prestamo.getIsbn());
				preparedStatement.setInt(3, prestamo.getEjemplar());
				filas = preparedStatement.executeUpdate();	
			} catch (SQLException e) {
				problemaSQLprestadosDAO = true;
				JOptionPane.showMessageDialog(null, "Problema al insertar datos en crearLibro", 
						"Problema SQLite", JOptionPane.ERROR_MESSAGE);
			}
			if(filas!=0)
				return true;
			return false;		
	}
	
	public static Object [][] listaAMatrizPrestado (List<Prestamo> lista){

		Object [][] matriz = new Object [lista.size()][8];
		for (int i=0 ; i < lista.size() ;i++) {
			matriz[i][0] = lista.get(i).getDni() ;
			matriz[i][1] = lista.get(i).getNombre() ;
			matriz[i][2] = lista.get(i).getApellidos() ;
			matriz[i][3] = lista.get(i).getIsbn() ;
			matriz[i][4] = lista.get(i).getTitulo();
			matriz[i][5] = lista.get(i).getAutor();
			matriz[i][6] = lista.get(i).getEjemplar();
			matriz[i][7] = lista.get(i).getPrestamo();
		}		
		return matriz;	
	}
	public static Object [][] listaAMatrizDisponibles (List<Prestamo> lista){
		Object [][] matriz = new Object [lista.size()][9];			
		for (int i=0 ; i < lista.size() ;i++) {
			matriz[i][0] = lista.get(i).getDni() ;
			matriz[i][1] = lista.get(i).getNombre() ;
			matriz[i][2] = lista.get(i).getApellidos() ;
			matriz[i][3] = lista.get(i).getIsbn() ;
			matriz[i][4] = lista.get(i).getTitulo();
			matriz[i][5] = lista.get(i).getAutor();
			matriz[i][6] = lista.get(i).getEjemplar();
			matriz[i][7] = lista.get(i).getPrestamo();
			matriz[i][8] = lista.get(i).getDevolucion();
		}		
		return matriz;	
	}
	public static Object [][] listaAMatrizLibrosConEjemplares (List<Prestamo> lista){
		Object [][] matriz = new Object [lista.size()][9];			
		for (int i=0 ; i < lista.size() ;i++) {
			matriz[i][0] = lista.get(i).getIsbn() ;
			matriz[i][1] = lista.get(i).getTitulo() ;
			matriz[i][2] = lista.get(i).getAutor() ;
		}		
		return matriz;	
	}



	/**
	 * @return the problemaSQLprestadosDAO
	 */
	public boolean isProblemaSQLprestadosDAO() {
		return problemaSQLprestadosDAO;
	}

	/**
	 * @param problemaSQLprestadosDAO the problemaSQLprestadosDAO to set
	 */
	public void setProblemaSQLprestadosDAO(boolean problemaSQLprestadosDAO) {
		this.problemaSQLprestadosDAO = problemaSQLprestadosDAO;
	}

	/**
	 * @return the listaprestado
	 */
	public List<Prestamo> getListaprestado() {
		return listaprestado;
	}

	/**
	 * @param listaprestado the listaprestado to set
	 */
	public void setListaprestado(List<Prestamo> listaprestado) {
		this.listaprestado = listaprestado;
	}

	/**
	 * @return the listadevuelto
	 */
	public List<Prestamo> getListadevuelto() {
		return listadevuelto;
	}

	/**
	 * @param listadevuelto the listadevuelto to set
	 */
	public void setListadevuelto(List<Prestamo> listadevuelto) {
		this.listadevuelto = listadevuelto;
	}

	/**
	 * @return the listalibrosconejemplares
	 */
	public List<Prestamo> getListalibrosconejemplares() {
		return listalibrosconejemplares;
	}


}





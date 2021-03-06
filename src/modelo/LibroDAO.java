package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class LibroDAO implements ILibroDAO {
	private boolean problemaSQLLibroDAO = false; // Pra controlar  problemas con la base de datos desde el controlador
	List<Libro> listaLibros = new ArrayList<Libro>();
	
	String sql;
	PreparedStatement preparedStatement;
	Statement statement;
	ResultSet resultSet;
	int filas=0;

	

	public LibroDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Libro> obtenerListaLibros() {
		problemaSQLLibroDAO = false;
		sql = "SELECT * FROM libros ORDER BY isbn;";
		Connection conexion = Conexion.getInstance();
		try {
			statement = conexion.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
				String isbn = resultSet.getString("ISBN");
				String titulo = resultSet.getString("TITULO");
				String autor = resultSet.getString("AUTOR");
				String editorial = resultSet.getString("EDITORIAL");
				int edicion = Integer.parseInt(resultSet.getString("EDICION"));
				Libro libro = new Libro(isbn, titulo, autor, editorial, edicion);
				listaLibros.add(libro);
			}
		} catch (SQLException e) {
			//System.out.println("Problema al leer los datos de la base de datos (obtenerListaLibros).");
			JOptionPane.showMessageDialog(null, "Problema leer base de datos de Libros", "Problema JBDC", JOptionPane.ERROR_MESSAGE);
			problemaSQLLibroDAO = true;
		}
		
		return listaLibros;
	}

	
	@Override
	public boolean existeLibro(Libro libro) {
		problemaSQLLibroDAO = false;
		filas = 0;
		sql = "Select ISBN FROM libros WHERE ISBN=?;";
		Connection conexion = Conexion.getInstance();
		try {
			preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, libro.getIsbnLibro().toString());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()){
				filas++;
			}
		} catch (SQLException e) {
			problemaSQLLibroDAO = true;
			//System.out.println("Problema al comprobar existencia del libro.");
			JOptionPane.showMessageDialog(null, "Problema al comprobar existencia del Libro", "Problema JBDC", JOptionPane.ERROR_MESSAGE);
		}		
		if (filas != 0)		
			return true;
		return false;
	}

	@Override
	public boolean actualizarLibro(Libro libro) {
		problemaSQLLibroDAO = false;
		filas = 0;
		sql = "UPDATE Libros SET titulo=?, autor=?, editorial=?, edicion=? WHERE isbn=?;";
		Connection conexion = Conexion.getInstance();
		
		try {
			preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, libro.getTitulo());
			preparedStatement.setString(2, libro.getTitulo());
			preparedStatement.setString(3, libro.getEditorial());
			preparedStatement.setInt(4, libro.getEdicion());
			preparedStatement.setString(5, libro.getIsbnLibro());
			filas = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			problemaSQLLibroDAO = true;
			JOptionPane.showMessageDialog(null, "Problema al actualizar el Libro,es posible que la fecha de Edición no sea correcta", "Problema JBDC", JOptionPane.ERROR_MESSAGE);
			
		}
		
		if(filas!=0)
			return true;		
		return false;
		
	}

	@Override
	public boolean crearLibro (Libro libro) {
		problemaSQLLibroDAO = false;
		filas=0;
		sql = "INSERT INTO libros(isbn, titulo, autor, editorial, edicion) values(?,?,?,?,?);";
		Connection conexion = Conexion.getInstance();
	
		try {
			preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, libro.getIsbnLibro());
			preparedStatement.setString(2, libro.getTitulo());
			preparedStatement.setString(3, libro.getAutor());
			preparedStatement.setString(4, libro.getEditorial());
			preparedStatement.setInt(5, libro.getEdicion());
			filas = preparedStatement.executeUpdate();	
			System.out.println(libro);
		} catch (SQLException e) {
			problemaSQLLibroDAO = true;
			JOptionPane.showMessageDialog(null, "Problema al insertar datos en crearLibro", "Problema SQLite", JOptionPane.ERROR_MESSAGE);
			
		}
		if(filas!=0)
			return true;
		return false;
	}
	

	@Override
	public Libro obtenerLibro (Libro libro) {
		problemaSQLLibroDAO = false;
		Libro li=null;
		sql = "SELECT * FROM libros WHERE isbn=?;";
		Connection conexion = Conexion.getInstance();
		try {
			preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, libro.getIsbnLibro());
			resultSet = preparedStatement.executeQuery();
			String isbn = resultSet.getString("isbn");
			String titulo = resultSet.getString("titulo");
			String autor = resultSet.getString("autor");
			String editorial = resultSet.getString("editorial");
			int edicion = resultSet.getInt("edicion");
			li = new Libro(isbn, titulo, autor, editorial, edicion);	
		} catch (SQLException e) {
			problemaSQLLibroDAO = true;
			JOptionPane.showMessageDialog(null, "Problema obtener libro", "Problema SQLite", JOptionPane.ERROR_MESSAGE);
		}
		return li;
	}

	@Override
	public boolean borrarLibro(Libro libro) {
		problemaSQLLibroDAO = false;
		sql = "DELETE FROM libros WHERE isbn=?;";
		Connection conexion = Conexion.getInstance();
		filas = 0;
		try {
			PreparedStatement preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, libro.getIsbnLibro());
			filas = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			problemaSQLLibroDAO = true;
			JOptionPane.showMessageDialog(null, "Problema borrar el libro", "Problema SQLite", JOptionPane.ERROR_MESSAGE);
		}
		if(filas!=0)
			return true;
		return false;
	}
	
	public boolean libroprestado(Libro libro) {
		filas = 0;
		problemaSQLLibroDAO = false;
		// Select * from prestamos where ISBN_PRESTAMO = '650797490-0' AND FECHA_PRESTAMO  is not "" AND FECHA_DEVOLUCION is NULL;
		sql = "Select * from prestamos where isbn_prestamo = ?  AND fecha_prestamo is not null AND fecha_devolucion IS null;";
			
		Connection conexion = Conexion.getInstance();
		
			try {
				preparedStatement = conexion.prepareStatement(sql);
				preparedStatement.setString(1, libro.getIsbnLibro());				
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()){
					filas++;
				}
			} catch (SQLException e) {
				problemaSQLLibroDAO = true;
				JOptionPane.showMessageDialog(null, "Problema al comprobar existencia de Ejemplar ejemplarprestado()", "Problema SQL", JOptionPane.ERROR_MESSAGE);
			}
			if (filas != 0)
				return true;	
		return false;
	}

	public static Object [][] listaAMatriz (List<Libro> list){
		Object [][] matriz = new Object [list.size()][5];
			
			for (int i=0 ; i < list.size() ;i++){
			matriz[i][0] = list.get(i).getIsbnLibro();
			matriz[i][1] = list.get(i).getTitulo();
			matriz[i][2] = list.get(i).getAutor();
			matriz[i][3] = list.get(i).getEditorial();
			matriz[i][4] = list.get(i).getEdicion();
			}
		
		return matriz;	
		}
	

	

	/**
	 * @return the problemaSQLLibroDAO
	 */
	public boolean isProblemaSQLLibroDAO() {
		return problemaSQLLibroDAO;
	}

	/**
	 * @param problemaSQLLibroDAO the problemaSQLLibroDAO to set
	 */
	public void setProblemaSQLLibroDAO(boolean problemaSQLLibroDAO) {
		this.problemaSQLLibroDAO = problemaSQLLibroDAO;
	}

	//public static void main(String[] args) {
		//System.out.println(new LibroDAO().obtenerListaLibros());
		//List <Libro> listaLibros = new LibroDAO().obtenerListaLibros();
		//Libro l = new Libro("078859529-8","La Conjura de los necios","John Kennedy Tool","LaBellota",1979);
		//System.out.println(new LibroDAO().libroprestado(l));
		//System.out.println(new LibroDAO().actualizarLibro(l));
		//System.out.println(new LibroDAO().crearLibro(l));
		//System.out.println(new LibroDAO().existeLibro(l));
		//System.out.println(new LibroDAO().obtenerLibro(l));
		//System.out.println(l);
		//Object [][] data = new LibroDAO().listaAMatriz(new LibroDAO().obtenerListaLibros());
		//for (int i=0 ; i < listaLibros.size() ;i++){
		//	System.out.println("" + data[i][0] + "," + data[i][1] + "," + data[i][2] + "," + data[i][3] + "," + data[i][4]);
		//	}
	//}

	
	

}

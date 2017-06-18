package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class EjemplarDAO implements IEjemplarDAO {
	private boolean problemaSQLejemplarDAO = false;
	
	List<Ejemplar> listaEjemplares = new ArrayList<Ejemplar>();
	List<Ejemplar> listaEjemplaresDeUnLibro = new ArrayList<Ejemplar>();
	String sql="";
	String sql2="";
	PreparedStatement preparedStatement;
	Statement statement;
	ResultSet resultSet;
	int filas=0;	
	
	
	
	public EjemplarDAO() {
	}

	@Override
	public List<Ejemplar> obtenerListaEjemplares() {
		problemaSQLejemplarDAO = false;
		sql = "SELECT ejemplares.ISBN_ejemplar, ejemplares.NUMERO_ejemplar, libros.Titulo, libros.autor, libros.editorial, libros.edicion FROM libros, ejemplares WHERE ejemplares.ISBN_ejemplar=libros.ISBN ORDER BY ISBN_ejemplar, NUMERO_ejemplar;";
		//SELECT ejemplares.ISBN_ejemplar, ejemplares.NUMERO_ejemplar, libros.Titulo, libros.autor, libros.editorial, libros.edicion FROM libros, ejemplares WHERE ejemplares.ISBN_ejemplar=libros.ISBN ORDER BY ISBN_ejemplar, NUMERO_ejemplar;
		Connection conexion = Conexion.getInstance();
		try {
			statement = conexion.createStatement();
			resultSet = statement.executeQuery(sql);
			//System.out.println(resultSet);
			while(resultSet.next()){
				String isbn = resultSet.getString(1);
				int numero = resultSet.getInt(2);
				String titulo = resultSet.getString(3);
				String autor = resultSet.getString(4);
				String editorial = resultSet.getString(5);
				int edicion = resultSet.getInt(6);
				Ejemplar ejemplar = new Ejemplar(isbn, numero,titulo,autor,editorial,edicion);
				listaEjemplares.add(ejemplar);
			}
		} catch (SQLException e) {
			problemaSQLejemplarDAO = true;
			//System.out.println("Problema al leer los datos de la base de datos (obtenerListaLibros).");
			JOptionPane.showMessageDialog(null, "Problema leer base de datos de Ejemplares", "Problema SQL", JOptionPane.ERROR_MESSAGE);
		}			
		return listaEjemplares;
	}
	
	@Override
	public List<Ejemplar> obtenerListadeEjemplaresDelMismoLibro(Ejemplar ejemplar) {
		problemaSQLejemplarDAO = false;
		//     SELECT ejemplares.ISBN_ejemplar, ejemplares.NUMERO_ejemplar, libros.Titulo, libros.autor, libros.editorial, libros.edicion FROM libros, ejemplares WHERE ejemplares.ISBN_ejemplar='078849629-8' AND libros.ISBN='078849629-8' ORDER BY ISBN_ejemplar, NUMERO_ejemplar;
		sql = "SELECT ejemplares.ISBN_ejemplar, ejemplares.NUMERO_ejemplar, libros.Titulo, libros.autor, libros.editorial, libros.edicion FROM libros, ejemplares WHERE ejemplares.ISBN_ejemplar=? AND libros.ISBN=? ORDER BY ISBN_ejemplar, NUMERO_ejemplar;";
		Connection conexion = Conexion.getInstance();
		try {
			preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, ejemplar.getIsbnEjemplar());
			preparedStatement.setString(2, ejemplar.getIsbnEjemplar());			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				String isbn = resultSet.getString("ISBN_ejemplar");
				int numero = resultSet.getInt("NUMERO_ejemplar");
				String titulo = resultSet.getString("Titulo");
				String autor = resultSet.getString("autor");
				String editorial = resultSet.getString("editorial");
				int edicion = resultSet.getInt("edicion");
				Ejemplar ej = new Ejemplar(isbn, numero, titulo, autor, editorial, edicion);
				listaEjemplaresDeUnLibro.add(ej);
			}
		} catch (SQLException e) {
			problemaSQLejemplarDAO = true;
			//System.out.println("Problema al leer los datos de la base de datos (obtenerListaLibros).");
			JOptionPane.showMessageDialog(null, "Problema leer base de datos de Ejemplares", "Problema SQL", JOptionPane.ERROR_MESSAGE);
		}
		//System.out.println(listaEjemplaresDeUnLibro);
		return listaEjemplaresDeUnLibro;
	}
	
	@Override
	public Ejemplar obtenerEjemplar(Ejemplar ejemplar) {
		problemaSQLejemplarDAO = false;
		Ejemplar ejemplar_completo = null;
		sql = "SELECT ejemplares.ISBN_ejemplar, ejemplares.NUMERO_ejemplar, libros.Titulo, libros.autor, libros.editorial, libros.edicion FROM libros, ejemplares WHERE ejemplares.ISBN_ejemplar=? AND libros.ISBN=? AND ejemplares.NUMERO_ejemplar=?;";
		
		Connection conexion = Conexion.getInstance();
		try {
			preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, ejemplar.getIsbnEjemplar());
			preparedStatement.setString(2, ejemplar.getIsbnEjemplar());
			preparedStatement.setInt(3, ejemplar.getNumero_ejemplar());
			resultSet = preparedStatement.executeQuery();
			String isbn = resultSet.getString("ISBN_ejemplar");
			int numero_ejemplar = resultSet.getInt("NUMERO_ejemplar");
			String titulo = resultSet.getString("Titulo");
			String autor = resultSet.getString("autor");
			String editorial = resultSet.getString("editorial");
			int edicion = resultSet.getInt("edicion");			
			ejemplar_completo = new Ejemplar(isbn, numero_ejemplar, titulo, autor, editorial, edicion);	
		} catch (SQLException e) {
			problemaSQLejemplarDAO = true;
			JOptionPane.showMessageDialog(null, "Problema obtener ejemplar", "Problema SQLite", JOptionPane.ERROR_MESSAGE);
		}
		return ejemplar_completo;
	}

	@Override
	public boolean existeEjemplar(Ejemplar ejemplar) {
		problemaSQLejemplarDAO = false;
		filas = 0;
		sql = "Select * FROM ejemplares WHERE ISBN_ejemplar=? AND NUMERO_ejemplar=?;";
		Connection conexion = Conexion.getInstance();
		try {
			preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, ejemplar.getIsbnEjemplar());
			preparedStatement.setInt(2, ejemplar.getNumero_ejemplar());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()){
				filas++;
			}
			
		} catch (SQLException e) {
			problemaSQLejemplarDAO = true;
			//System.out.println("Problema al comprobar existencia del libro.");
			JOptionPane.showMessageDialog(null, "Problema al comprobar existencia de Ejemplar existeEjemplar()", "Problema SQL", JOptionPane.ERROR_MESSAGE);
		}		
		if (filas != 0)		
			return true;
		return false;
	}
	
	public boolean hayAlgunEjemplarActivo (Libro libro){
		problemaSQLejemplarDAO = false;
		filas = 0;
		sql = "Select * FROM ejemplares WHERE ISBN_ejemplar=?;";
		Connection conexion = Conexion.getInstance();
		try {
			preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, libro.getIsbnLibro());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()){
				filas++;
			}			
		} catch (SQLException e) {
			problemaSQLejemplarDAO = true;
			//System.out.println("Problema al comprobar existencia del libro.");
			JOptionPane.showMessageDialog(null, "Problema al comprobar existencia de Ejemplar existeEjemplar()", "Problema SQL", JOptionPane.ERROR_MESSAGE);
		}		
		if (filas != 0)		
			return true;
		return false;

	}
	
	public boolean ejemplarprestado(Ejemplar ejemplar) {
		problemaSQLejemplarDAO = false;
		filas = 0;
		// Select * from prestamos where ISBN_PRESTAMO = '650797490-0' AND NUMERO_EJEMPLAR_PRESTAMO = 3 AND FECHA_PRESTAMO  is not "" AND FECHA_DEVOLUCION is NULL;
		sql = "Select * from prestamos where isbn_prestamo = ? AND numero_ejemplar_prestamo = ? AND fecha_prestamo is not null AND fecha_devolucion IS null;";	
		Connection conexion = Conexion.getInstance();		
			try {
				preparedStatement = conexion.prepareStatement(sql);
				preparedStatement.setString(1, ejemplar.getIsbnEjemplar());
				preparedStatement.setInt(2, ejemplar.getNumero_ejemplar());
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()){
					filas++;
				}
			} catch (SQLException e) {
				problemaSQLejemplarDAO = true;
				JOptionPane.showMessageDialog(null, "Problema al comprobar existencia de Ejemplar ejemplarprestado()", "Problema SQL", JOptionPane.ERROR_MESSAGE);
			}			
		if (filas != 0)		
			return true;
		return false;
	}

	@Override
	public boolean crearEjemplar(Ejemplar ejemplar) {
		sql2 = "INSERT INTO ejemplares(ISBN_ejemplar, Numero_ejemplar) values(?,1);";	
		problemaSQLejemplarDAO = false;
		filas=0;
		
			if (existeEjemplar(ejemplar)) {
				sql2 = "INSERT INTO ejemplares(ISBN_ejemplar, Numero_ejemplar) values(?,(SELECT Max(Numero_ejemplar) +1 FROM EJEMPLARES WHERE ISBN_Ejemplar = ?));";
			}
		Connection conexion = Conexion.getInstance();	
		try {
			preparedStatement = conexion.prepareStatement(sql2);
			if (sql2 == "INSERT INTO ejemplares(ISBN_ejemplar, Numero_ejemplar) values(?,(SELECT Max(Numero_ejemplar) +1 FROM EJEMPLARES WHERE ISBN_Ejemplar = ?));"){
			preparedStatement.setString(1, ejemplar.getIsbnEjemplar());
			preparedStatement.setString(2, ejemplar.getIsbnEjemplar());
			} else {
				preparedStatement.setString(1, ejemplar.getIsbnEjemplar());	
			}
			filas = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			problemaSQLejemplarDAO = true;
			JOptionPane.showMessageDialog(null, "Problema crear el Ejemplar", "Problema SQLite", JOptionPane.ERROR_MESSAGE);
		}	
		if(filas!=0)
			return true;
		return false;
	}
	
	@Override
	public boolean borrarEjemplar(Ejemplar ejemplar) {
		problemaSQLejemplarDAO = false;
		filas=0;
		
		sql = "DELETE FROM ejemplares WHERE isbn_ejemplar=? AND numero_ejemplar=?;";
		Connection conexion = Conexion.getInstance();	
		try {
			preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, ejemplar.getIsbnEjemplar());
			preparedStatement.setInt(2, ejemplar.getNumero_ejemplar());
			filas = preparedStatement.executeUpdate();
			if (filas != 0)
				return true;
		} catch (SQLException e) {
			problemaSQLejemplarDAO = true;
			JOptionPane.showMessageDialog(null, "Problema borrar el libro", "Problema SQLite", JOptionPane.ERROR_MESSAGE);
		}		
		return false;
	}
	

	
	
	
	public static Object [][] listaAMatriz (List<Ejemplar> lista){
		Object [][] matriz = new Object [lista.size()][6];			
			for (int i=0 ; i < lista.size() ;i++) {
			matriz[i][0] = lista.get(i).getIsbnEjemplar() ;
			matriz[i][1] = lista.get(i).getNumero_ejemplar() ;
			matriz[i][2] = lista.get(i).getTitulo() ;
			matriz[i][3] = lista.get(i).getAutor() ;
			matriz[i][4] = lista.get(i).getEditorial() ;
			matriz[i][5] = lista.get(i).getEdicion();
			}		
		return matriz;	
	}

	public static Object [][] listaAMatrizPrestar (List<Ejemplar> lista){
		Object [][] matriz = new Object [lista.size()][3];			
			for (int i=0 ; i < lista.size() ;i++) {
			matriz[i][0] = lista.get(i).getIsbnEjemplar() ;
			matriz[i][1] = lista.get(i).getNumero_ejemplar() ;
			matriz[i][2] = lista.get(i).getTitulo() ;
			}		
		return matriz;	
	}
	/**
	 * @return the problemaSQLejemplarDAO
	 */
	public boolean isProblemaSQLejemplarDAO() {
		return problemaSQLejemplarDAO;
	}

	/**
	 * @param problemaSQLejemplarDAO the problemaSQLejemplarDAO to set
	 */
	public void setProblemaSQLejemplarDAO(boolean problemaSQLejemplarDAO) {
		this.problemaSQLejemplarDAO = problemaSQLejemplarDAO;
	}
	
	
	
	//public static void main(String[] args) {
		//System.out.println(new EjemplarDAO().obtenerListaEjemplares());
		//Ejemplar ejo = new Ejemplar("650797490-1",1);
		//System.out.println(new EjemplarDAO().obtenerListadeEjemplaresDelMismoLibro(new Ejemplar("078849629-8",1)));		
		//Ejemplar ej = new Ejemplar("890401890-0",1);
		//System.out.println(new EjemplarDAO().ejemplarprestado(ej));
		//System.out.println(new EjemplarDAO().actualizarEjemplar(ej));
		//System.out.println(new EjemplarDAO().crearEjemplar(ej));
		//System.out.println(new EjemplarDAO().existeEjemplar(ej));
		//System.out.println(new EjemplarDAO().obtenerEjemplar(ej));
		//System.out.println(new EjemplarDAO().borrarEjemplar(ej));
		//System.out.println(new EjemplarDAO().existeEjemplar(us));		
		//System.out.println(ej);
		//List <Ejemplar> lista = new EjemplarDAO().obtenerListaEjemplares();
		//new EjemplarDAO();
		//Object [][] data = EjemplarDAO.listaAMatriz(lista);
		//for (int i=0 ; i < lista.size() ;i++){
		//	System.out.println("" + data[i][0] + "," + data[i][1] + "," + data[i][2] + "," + data[i][3] + "," + data[i][4] + "," + data[i][5]);
		//}	
	//}
}

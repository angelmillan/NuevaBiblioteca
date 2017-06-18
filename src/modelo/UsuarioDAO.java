package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class UsuarioDAO implements IUsuarioDAO {
	private boolean problemaSQLusuarioDAO = false; // Para controlar  problemas con la base de datos desde el controlador
	List<Usuario> listaUsuarios = new ArrayList<Usuario>(); //Lista donde se carga la BD
	String sql;
	PreparedStatement preparedStatement;
	Statement statement;
	ResultSet resultSet;
	int filas=0;
	
	
	public UsuarioDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Usuario> obtenerListadeUsuarios() {
		problemaSQLusuarioDAO = false; 
		sql = "SELECT * FROM usuarios ORDER BY dni;";
		Connection conexion = Conexion.getInstance();
		try {
			statement = conexion.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
				String dni = resultSet.getString("dni");
				String nombre = resultSet.getString("nombre");
				String apellidos = resultSet.getString("apellidos");
				String direccion = resultSet.getString("direccion");
				Usuario usuario = new Usuario(dni, nombre, apellidos, direccion);
				listaUsuarios.add(usuario);
			}
		} catch (SQLException e) {
			problemaSQLusuarioDAO = true;
			JOptionPane.showMessageDialog(null, "Problema leer base de datos de Usuarios", "Problema SQL", JOptionPane.ERROR_MESSAGE);
		}	
		return listaUsuarios;
	}

	@Override
	public boolean existeUsuario(Usuario usuario) {
		problemaSQLusuarioDAO = false;
		filas = 0;
		sql = "Select dni FROM usuarios WHERE dni=?;";
		Connection conexion = Conexion.getInstance();
		try {
			preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getDniUsuario());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()){
				filas++;
			}
		} catch (SQLException e) {
			problemaSQLusuarioDAO = true;
			//System.out.println("Problema al comprobar existencia del usuario.");
			JOptionPane.showMessageDialog(null, "Problema al comprobar existencia Usuario existeUsuario()", "Problema JBDC", JOptionPane.ERROR_MESSAGE);
		}		
		if (filas != 0)		
			return true;
		return false;
	}

	@Override
	public boolean actualizarUsuario(Usuario usuario) {
		problemaSQLusuarioDAO = false;
		filas = 0;
		sql = "UPDATE usuarios SET nombre=?, apellidos=?, direccion=? WHERE dni=?;";
		Connection conexion = Conexion.getInstance();
		
		try {
			preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getNombre());
			preparedStatement.setString(2, usuario.getApellidos());
			preparedStatement.setString(3, usuario.getDireccion());
			preparedStatement.setString(4, usuario.getDniUsuario());
			filas = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			problemaSQLusuarioDAO = true;
			JOptionPane.showMessageDialog(null, "Problema al actualizar el Usuario", "Problema SQL", JOptionPane.ERROR_MESSAGE);
			System.out.println("Problema al actualizar el Libro");
		}
		
		if(filas!=0)
			return true;
		return false;
	}

	@Override
	public boolean crearUsuario(Usuario usuario) {
		problemaSQLusuarioDAO = false;
		filas=0;
		sql = "INSERT INTO usuarios(dni, nombre, apellidos, direccion) values(?,?,?,?);";
		Connection conexion = Conexion.getInstance();
	
		try {
			preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getDniUsuario());
			preparedStatement.setString(2, usuario.getNombre());
			preparedStatement.setString(3, usuario.getApellidos());
			preparedStatement.setString(4, usuario.getDireccion());
			filas = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			problemaSQLusuarioDAO = true;
			JOptionPane.showMessageDialog(null, "Problema crear el Usuario", "Problema SQLite", JOptionPane.ERROR_MESSAGE);
		}
		if(filas!=0)
			return true;
		return false;
	}
	

	@Override
	public Usuario obtenerUsuario(Usuario usuario) {
		problemaSQLusuarioDAO = false;
		Usuario user = null;
		sql = "SELECT * FROM usuarios WHERE dni=?;";
		Connection conexion = Conexion.getInstance();
		try {
			preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getDniUsuario());
			resultSet = preparedStatement.executeQuery();
			String dni = resultSet.getString("dni");
			String nombre = resultSet.getString("nombre");
			String apellidos = resultSet.getString("apellidos");
			String direccion = resultSet.getString("direccion");
			user = new Usuario(dni, nombre, apellidos, direccion);	
		} catch (SQLException e) {
			problemaSQLusuarioDAO = true;
			JOptionPane.showMessageDialog(null, "Problema obtener usuario", "Problema SQLite", JOptionPane.ERROR_MESSAGE);
		}
		return user;
	}

	@Override
	public boolean borrarUsuario(Usuario usuario) {
		problemaSQLusuarioDAO = false;
		sql = "DELETE FROM usuarios WHERE dni=?;";
		Connection conexion = Conexion.getInstance();
		filas = 0;
		try {
			PreparedStatement preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getDniUsuario());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()){
				filas++;
			}

		} catch (SQLException e) {
			problemaSQLusuarioDAO = true;
			JOptionPane.showMessageDialog(null, "Problema borrar el Usuario", "Problema SQLite", JOptionPane.ERROR_MESSAGE);
		}
		
		if(filas!=0)
			return true;
		return false;
	}
	
	public static Object [][] listaAMatriz (List<Usuario> lista){
		Object [][] matriz = new Object [lista.size()][4];
			
			for (int i=0 ; i < lista.size() ;i++){
			matriz[i][0] = lista.get(i).getDniUsuario() ;
			matriz[i][1] = lista.get(i).getNombre() ;
			matriz[i][2] = lista.get(i).getApellidos() ;
			matriz[i][3] = lista.get(i).getDireccion() ;
			}
		
		return matriz;	
	}
	
	public static Object [][] listaAMatrizPrestar (List<Usuario> lista){
		Object [][] matriz = new Object [lista.size()][3];
			
			for (int i=0 ; i < lista.size() ;i++){
			matriz[i][0] = lista.get(i).getDniUsuario() ;
			matriz[i][1] = lista.get(i).getNombre() ;
			matriz[i][2] = lista.get(i).getApellidos() ;
			}
		
		return matriz;	
	}

	/**
	 * @return the problemaSQLusuarioDAO
	 */
	public boolean isProblemaSQLusuarioDAO() {
		return problemaSQLusuarioDAO;
	}

	/**
	 * @param problemaSQLusuarioDAO the problemaSQLusuarioDAO to set
	 */
	public void setProblemaSQLusuarioDAO(boolean problemaSQLusuarioDAO) {
		this.problemaSQLusuarioDAO = problemaSQLusuarioDAO;
	}
	
	
	/*
	public static void main(String[] args) {
		//System.out.println(new UsuarioDAO().obtenerListadeUsuarios());
		
		//Usuario us = new Usuario("99973673D","Ángel","Millán Mirallles","Francisco Coello 19 - 23002 Jaén");
		//System.out.println(new UsuarioDAO().actualizarUsuario(us));
		//System.out.println(new UsuarioDAO().crearUsuario(us));
		//System.out.println(new UsuarioDAO().existeUsuario(us));
		//System.out.println(new UsuarioDAO().obtenerUsuario(us));
		//System.out.println(new UsuarioDAO().borrarUsuario(us));
		//System.out.println(new UsuarioDAO().existeUsuario(us));
		
		//System.out.println(l);
		//List <Usuario> lista = new UsuarioDAO().obtenerListadeUsuarios();
		//Object [][] data = new UsuarioDAO().listaAMatriz(new UsuarioDAO().obtenerListadeUsuarios());
		//for (int i=0 ; i < lista.size() ;i++){
		//	System.out.println("" + data[i][0] + "," + data[i][1] + "," + data[i][2] + "," + data[i][3] + "," + data[i][4]);
		//
		//	}
		
	}
	*/
}

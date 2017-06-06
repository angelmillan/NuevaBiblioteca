package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static Connection conexion = null;
	
	private Conexion(){
		
		try {
			Class.forName("org.sqlite.JDBC");
			try {
				conexion = DriverManager.
						getConnection("jdbc:sqlite:BD/biblioteca.db");
			} catch (SQLException e) {
				System.out.println("Error al acceso de la BD");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc no encotrador");
		}
	}
	// En caso de que no exista la conexión la crea
	public static Connection getInstance(){
		if (conexion == null)
			new Conexion();
		return conexion;
	}
	// main para probar que funciona la conexión
	public static void main(String[] args) {
		Conexion.getInstance();
		System.out.println(conexion);
	}
	
}

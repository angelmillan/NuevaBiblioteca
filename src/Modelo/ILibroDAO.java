package Modelo;


import java.util.List;

public interface ILibroDAO {
	
	List<Libro> obtenerListaLibros();
	
	boolean existeLibro(Libro libro);
	
	boolean actualizarLibro(Libro libro);
	
	boolean crearLibro(Libro libro);
	
	Libro obtenerLibro(Libro libro);
	
	boolean borrarLibro(Libro libro);
	
}

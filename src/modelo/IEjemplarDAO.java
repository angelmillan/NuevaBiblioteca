package modelo;

import java.util.List;

public interface IEjemplarDAO {

	List<Ejemplar> obtenerListaEjemplares();
	
	List<Ejemplar> obtenerListadeEjemplaresDelMismoLibro(Ejemplar ejemplar);
	
	boolean existeEjemplar(Ejemplar ejemplar);
	
	boolean actualizarEjemplar(Ejemplar ejemplar);
	
	boolean crearEjemplar(Ejemplar ejemplar);
	
	Ejemplar obtenerEjemplar(Ejemplar ejemplar);
	
	boolean borrarEjemplar(Ejemplar ejemplar);
	
}
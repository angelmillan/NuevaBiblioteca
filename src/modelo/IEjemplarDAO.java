package modelo;

import java.util.List;

public interface IEjemplarDAO {
	boolean problemaSQLejemplarDAO = false;

	List<Ejemplar> obtenerListaEjemplares();
	
	List<Ejemplar> obtenerListadeEjemplaresDelMismoLibro(Ejemplar ejemplar);
	
	boolean existeEjemplar(Ejemplar ejemplar);
	
	boolean crearEjemplar(Ejemplar ejemplar);
	
	Ejemplar obtenerEjemplar(Ejemplar ejemplar);
	
	boolean borrarEjemplar(Ejemplar ejemplar);
	
}
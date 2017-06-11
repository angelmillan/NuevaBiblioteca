package modelo;

import java.util.List;

public interface IUsuarioDAO {

	List<Usuario> obtenerListadeUsuarios();
	
	boolean existeUsuario(Usuario usuario);
	
	boolean actualizarUsuario(Usuario usuario);
	
	boolean crearUsuario(Usuario usuario);
	
	Usuario obtenerUsuario(Usuario usuario);
	
	boolean borrarUsuario(Usuario usuario);
	
}

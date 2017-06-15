package controlador;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.event.ListSelectionEvent;
import modelo.Ejemplar;
import modelo.EjemplarDAO;
import modelo.Libro;
import modelo.LibroDAO;
import modelo.UsuarioDAO;
import vista.Vista;
/**
 * Public class Controlador
 * {@link ActionListener}
 * {@link ListSelectionEvent}
 * {@link ActionEvent}
 * @author Angel Millan Miralles
 * @author angelmillan@me.com
 * @version 1.0
 */
public class Controlador implements ActionListener {
	private Vista vista;
	private EjemplarDAO ejemplarDAO;
	private LibroDAO libroDAO;
	private UsuarioDAO usuarioDAO;

	
	/**
	 * Controlador del modelo vista controlador, incorpora los Listeners 
	 * y coordina evetos entre la GUI y la capa de persistencia
	 * @param vista la GUI
	 * @param ejemplarDAO
	 * @param libroDAO
	 * @param usuarioDAO
	 */
	public Controlador(Vista vista, EjemplarDAO ejemplarDAO, LibroDAO libroDAO, UsuarioDAO usuarioDAO) {
		super();
		this.vista = vista;
		this.ejemplarDAO = ejemplarDAO;
		this.libroDAO = libroDAO;
		this.usuarioDAO = usuarioDAO;
		//listaUsuarios = ejemplarDAO.obtenerListaEjemplares() ;
		actionListener(this);
	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e){
		switch (e.getActionCommand()) {
		
		// botones del menu principal de la aplicacion
		
		case ("Gestionar Usuarios"): 
			vista.getPanelUsuarios().setVisible(true);
		    vista.getPanelEjemplares().setVisible(false);
		    vista.getPanelLibros().setVisible(false);
		    //vista.getPanelPrestamos().setVisible(false);
			break;
			
		case ("Gestionar Libros"):
			vista.getPanelUsuarios().setVisible(false);
	    		vista.getPanelEjemplares().setVisible(false);
	    		vista.getPanelLibros().setVisible(true);
	    		//vista.getPanelPrestamos().setVisible(false);
			break;
			
		case ("Gestionar Ejemplares"):
			vista.getPanelUsuarios().setVisible(false);
			vista.getPanelEjemplares().setVisible(true);	    		
	    		vista.getPanelLibros().setVisible(false);
	    		//vista.getPanelPrestamos().setVisible(false);
			break;
			
		case ("Gestionar Préstamos"):
			//vista.getPanelUsuarios().setVisible(false);
	    		//vista.getPanelEjemplares().setVisible(false);
	    		//vista.getPanelLibros().setVisible(false);
	    		//vista.getPanelPrestamos().setVisible(true);
			break;
			
		case ("Salir"):
			
			//vista.getPanelUsuarios().setVisible(false);
	    		//vista.getPanelEjemplares().setVisible(true);
	    		//vista.getPanelLibros().setVisible(false);
	    		//vista.getPanelPrestamos().setVisible(false);
			break;
		
		// Botones del Panel Ejemplares
		
		case ("Añadir nuevo ejemplar"):
		
			if (vista.getPanelEjemplares().getTabla_Ejemplares().getSelectedRow() >= 0) {
				Object isbn = vista.getPanelEjemplares().getTabla_Ejemplares().getValueAt(vista.getPanelEjemplares().getTabla_Ejemplares().getSelectedRow(), 0);
				ejemplarDAO.crearEjemplar(new Ejemplar(isbn.toString(), 1));	
				vista.getPanelEjemplares().getTextField_Mensajes().setForeground(Color.GREEN.darker());
				vista.getPanelEjemplares().getTextField_Mensajes().setText("Ejemplar añadido correctamente");
				limpiaCamposEjemplares();
				refrescarTablaEjemplares();			
			} else {
				vista.getPanelEjemplares().getTextField_Mensajes().setForeground(Color.RED.brighter());
				vista.getPanelEjemplares().getTextField_Mensajes().setText("No hay ejemplar seleccionado para añadir");
			}

			break;
		
		case ("Borrar Ejemplar"):
				
			if (vista.getPanelEjemplares().getTabla_Ejemplares().getSelectedRow() >= 0) {
				
				Object isbn = vista.getPanelEjemplares().getTabla_Ejemplares().getValueAt(vista.getPanelEjemplares().getTabla_Ejemplares().getSelectedRow(), 0);
				Object numero_ejemplar = vista.getPanelEjemplares().getTabla_Ejemplares().getValueAt(vista.getPanelEjemplares().getTabla_Ejemplares().getSelectedRow(), 1);
				Ejemplar aBorrar = new Ejemplar(isbn.toString(), (int) numero_ejemplar);
				System.out.println("Antes del if ejemplar prestado" + aBorrar);
				System.out.println(ejemplarDAO.ejemplarprestado(aBorrar));
				
					if (ejemplarDAO.ejemplarprestado(aBorrar)){
						System.out.println(ejemplarDAO.ejemplarprestado(aBorrar));
						System.out.println("buen camino");
						ejemplarDAO.borrarEjemplar(aBorrar);
						vista.getPanelEjemplares().getTextField_Mensajes().setForeground(Color.GREEN.darker());
						vista.getPanelEjemplares().getTextField_Mensajes().setText("Ejemplar borrado correctamente");
						refrescarTablaEjemplares();
						limpiaCamposEjemplares();
						break;
					} else {
						vista.getPanelEjemplares().getTextField_Mensajes().setForeground(Color.RED.brighter());
						vista.getPanelEjemplares().getTextField_Mensajes().setText("El ejemplar está prestado y no puede eliminarse");
						break;
					}
									
			} else {
				vista.getPanelEjemplares().getTextField_Mensajes().setForeground(Color.RED.brighter());
				vista.getPanelEjemplares().getTextField_Mensajes().setText("No hay ejemplar seleccionado para eliminar");
			}
			
			break;
			
			
		// Botones del Panel Libros
			
		case ("Añadir nuevo Libro"):
			System.out.println("boton Añadir nuevo Libro");
			limpiaCamposLibros();
			hacerEditablesTextFieldsPaneldeLibros();
			//logica
			refrescarTablaLibros();
			
			break;
		
		case ("Borrar Libro"):
			if (vista.getPanelLibros().getTablaLibros().getSelectedRow() >= 0) {
				int fila = vista.getPanelLibros().getTablaLibros().getSelectedRow();
				Object isbn = vista.getPanelLibros().getTablaLibros().getValueAt(fila, 0);
				
				Libro aBorrar = new Libro(isbn.toString());
					if (libroDAO.libroprestado(aBorrar)){
						System.out.println(libroDAO.libroprestado(aBorrar));
						System.out.println("buen camino");
						libroDAO.borrarLibro(aBorrar);
						vista.getPanelLibros().getTextMensajes().setForeground(Color.GREEN.darker());
						vista.getPanelLibros().getTextMensajes().setText("Libro borrado correctamente");
						refrescarTablaLibros();
						limpiaCamposLibros();
						break;
					} else {
						vista.getPanelLibros().getTextMensajes().setForeground(Color.RED.brighter());
						vista.getPanelLibros().getTextMensajes().setText("El Libro está prestado y no puede eliminarse");
						break;
					}
									
			} else {
				vista.getPanelLibros().getTextMensajes().setForeground(Color.RED.brighter());
				vista.getPanelLibros().getTextMensajes().setText("No hay libro seleccionado para eliminar");
			}
			System.out.println("boton Borrar Libro");
			break;
		
		case ("Modificar Libro"):
			System.out.println("boton Modificar Libro");
			hacerEditablesTextFieldsPaneldeLibros();
			vista.getPanelLibros().getTextISBN().setEditable(false);
			break;
		
		case ("Añadir nuevo ejemplar de libro"):
			System.out.println("boton Añadir nuevo ejemplar de libro");
			break;
			
		case("Guardar Libro"):
				
				if (!comprobarISBN(vista.getPanelLibros().getTextISBN().getText())) {
					vista.getPanelLibros().getTextMensajes().setForeground(Color.RED.brighter());
					vista.getPanelLibros().getTextMensajes().setText("El ISBN no es correcto formato debe ser xxxxxxxxx-x");
					vista.getPanelLibros().getTextISBN().setText("");
					break;
				}
				
				System.out.println(libroDAO.existeLibro(new Libro(vista.getPanelLibros().getTextISBN().getText())));
				if (libroDAO.existeLibro(new Libro(vista.getPanelLibros().getTextISBN().getText()))) {
					vista.getPanelLibros().getTextMensajes().setForeground(Color.RED.brighter());
					vista.getPanelLibros().getTextMensajes().setText("El ISBN del libro ya exite, no pueden estar duplicados");
					vista.getPanelLibros().getTextISBN().setText("");
					break;
				}
				
				if (vista.getPanelLibros().getTextTitulo().getText().length() == 0) {
					vista.getPanelLibros().getTextMensajes().setForeground(Color.RED.brighter());
					vista.getPanelLibros().getTextMensajes().setText("ISBN correcto pero el Título del Libro no puede está vacio");
					break;
				}
				// logica de guardado
				
				vista.getPanelLibros().getTextMensajes().setForeground(Color.GREEN.darker());
				vista.getPanelLibros().getTextMensajes().setText("Libro agregado correctamente a la base de datos");
				volverOcultosTextFieldsPaneldeLibros();
			break;
		
		// Botones del Panel Usuarios

		case("Añadir nuevo Usuario"):
			System.out.println("boton Añadir nuevo ejemplar de libro");
			break;
		
		case("Borrar Usuario"):
			System.out.println("boton Borrar Usuario");
			break;
		
		case("Modificar Usuario"):
			System.out.println("boton Modificar Usuario");
			break;
		
		default:
			break;
		}

	}
	/**
	 * Método del controlador donde se incluyen los Listeners de los elementos de la aplicacion
	 * @param escuchador
	 */
	private void actionListener(ActionListener escuchador) {
		// Listeners de botones del Menu general
		vista.getMntmSalir().addActionListener(escuchador);
		vista.getMntmGestionarEjemplares().addActionListener(escuchador);
		vista.getMntmGestionarLibros().addActionListener(escuchador);
		vista.getMntmGestionarUsuarios().addActionListener(escuchador);
		// Listeners de botones del panel Ejemplares
		vista.getPanelEjemplares().getButtonAddEjemplar().addActionListener(escuchador);
		vista.getPanelEjemplares().getButtonBorrarEjemplar().addActionListener(escuchador);
		vista.getPanelEjemplares().getButtonBuscarEjemplar().addActionListener(escuchador);
		// Listeners de botones del panel Libros
		vista.getPanelLibros().getBtnAadirNuevoEjemplar().addActionListener(escuchador);
		vista.getPanelLibros().getBtnAadirNuevoLibro().addActionListener(escuchador);
		vista.getPanelLibros().getBtnBorrarLibro().addActionListener(escuchador);
		vista.getPanelLibros().getBtnModificarLibro().addActionListener(escuchador);
		vista.getPanelLibros().getBtnGuardarLibro().addActionListener(escuchador);
		vista.getPanelLibros().getBtnCancelarLibro().addActionListener(escuchador);
		// Listeners de botones del panel Usuarios
		vista.getPanelUsuarios().getBtnAddNuevoUsuario().addActionListener(escuchador);
		vista.getPanelUsuarios().getBtnBorrarUsuario().addActionListener(escuchador);
		vista.getPanelUsuarios().getBtnModificarUsuario().addActionListener(escuchador);
		
		/** Listener para JTable del Panel Ejemplares
		 * Obtiene datos de la fila del JTable seleccionado 
		 * Los introduce en el JTextField correspondiente
		 */
		vista.getPanelEjemplares().getTabla_Ejemplares().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			try {
				int fila = vista.getPanelEjemplares().getTabla_Ejemplares().getSelectedRow();
                if (vista.getPanelEjemplares().getTabla_Ejemplares().getSelectedRow() >= 0) {
                		
                		Object isbn = vista.getPanelEjemplares().getTabla_Ejemplares().getValueAt(fila, 0);
                		Object numero_ejemplar = vista.getPanelEjemplares().getTabla_Ejemplares().getValueAt(fila, 1);
                    Object titulo = vista.getPanelEjemplares().getTabla_Ejemplares().getValueAt(fila, 2);
                    Object autor = vista.getPanelEjemplares().getTabla_Ejemplares().getValueAt(fila, 3);
                    Object editorial = vista.getPanelEjemplares().getTabla_Ejemplares().getValueAt(fila, 4);
                		Object edicion = vista.getPanelEjemplares().getTabla_Ejemplares().getValueAt(fila, 5);

                		vista.getPanelEjemplares().getTextField_ISBN_Ejemplar().setText(isbn.toString());
                		vista.getPanelEjemplares().getTextField_NUmero_Ejemplar().setText(numero_ejemplar.toString());
                		vista.getPanelEjemplares().getTextField_Titulo_Ejemplar().setText(titulo.toString());
                    vista.getPanelEjemplares().getTextField_Autor_Ejemplar().setText(autor.toString());
                    vista.getPanelEjemplares().getTextField_Editorial_Ejemplar().setText(editorial.toString());
                    vista.getPanelEjemplares().getTextField_Edicion_Ejemplar().setText(edicion.toString());
       
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
		});
		
		/** Listener para JTable del Panel Libros
		 * Obtiene datos de la fila del JTable seleccionado 
		 * Los introduce en el JTextField correspondiente
		 */
		vista.getPanelLibros().getTablaLibros().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			try {
				int fila = vista.getPanelLibros().getTablaLibros().getSelectedRow();
				if (vista.getPanelLibros().getTablaLibros().getSelectedRow() >= 0) {
					Object isbn = vista.getPanelLibros().getTablaLibros().getValueAt(fila, 0);
					Object titulo = vista.getPanelLibros().getTablaLibros().getValueAt(fila, 1);
					Object autor = vista.getPanelLibros().getTablaLibros().getValueAt(fila, 2);
					Object editorial = vista.getPanelLibros().getTablaLibros().getValueAt(fila, 3);
					Object edicion = vista.getPanelLibros().getTablaLibros().getValueAt(fila, 4);
					
					vista.getPanelLibros().getTextISBN().setText(isbn.toString());
					vista.getPanelLibros().getTextTitulo().setText(titulo.toString());
					vista.getPanelLibros().getTextAutor().setText(autor.toString());
					vista.getPanelLibros().getTextEditorial().setText(editorial.toString());
					vista.getPanelLibros().getTextEdicion().setText(edicion.toString());
	
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
			
		});
		
		/** Listener para JTable del Panel Usuarios
		 * Obtiene datos de la fila del JTable seleccionado 
		 * Los introduce en el JTextField correspondiente
		 */
		vista.getPanelUsuarios().getTableUsuarios().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			try {
				int fila = vista.getPanelUsuarios().getTableUsuarios().getSelectedRow();
				if (vista.getPanelUsuarios().getTableUsuarios().getSelectedRow() >= 0) {
					Object dni = vista.getPanelUsuarios().getTableUsuarios().getValueAt(fila, 0);
					Object nombre = vista.getPanelUsuarios().getTableUsuarios().getValueAt(fila, 1);
					Object apellidos = vista.getPanelUsuarios().getTableUsuarios().getValueAt(fila, 2);
					Object direccion = vista.getPanelUsuarios().getTableUsuarios().getValueAt(fila, 3);

					vista.getPanelUsuarios().getTextDNI().setText(dni.toString());
					vista.getPanelUsuarios().getTextNombre().setText(nombre.toString());
					vista.getPanelUsuarios().getTextApellidos().setText(apellidos.toString());
					vista.getPanelUsuarios().getTextDireccion().setText(direccion.toString());
					
	
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
			
			
		});
		
		
	}
	
	/**
	 * Método para poner los textField del JPanel Ejemplares en blanco
	 */
	public void limpiaCamposEjemplares() {
		vista.getPanelEjemplares().getTextField_ISBN_Ejemplar().setText("");
		vista.getPanelEjemplares().getTextField_NUmero_Ejemplar().setText("");
		vista.getPanelEjemplares().getTextField_Titulo_Ejemplar().setText("");
		vista.getPanelEjemplares().getTextField_Autor_Ejemplar().setText("");
		vista.getPanelEjemplares().getTextField_Editorial_Ejemplar().setText("");
		vista.getPanelEjemplares().getTextField_Edicion_Ejemplar().setText("");

	}
	
	/**
	 * Método para poner los textField del JPanel Libos en blanco
	 */
	public void limpiaCamposLibros() {
		vista.getPanelLibros().getTextISBN().setText("");
		vista.getPanelLibros().getTextTitulo().setText("");
		vista.getPanelLibros().getTextAutor().setText("");
		vista.getPanelLibros().getTextEditorial().setText("");
		vista.getPanelLibros().getTextEdicion().setText("");

	}
	
	/**
	 * Método para poner los textField del JPanel Usuarios en blanco
	 */
	public void limpiaCamposUsuarios() {
		vista.getPanelUsuarios().getTextDNI().setText("");
		vista.getPanelUsuarios().getTextNombre().setText("");
		vista.getPanelUsuarios().getTextApellidos().setText("");
		vista.getPanelUsuarios().getTextDireccion().setText("");

	}
	/**
	 * Método para refrecar los datos tras modificar la BD en JPanel Ejemplares 
	 * En este caso se modifica tambien el formato de las columnas
	 */
	public void refrescarTablaEjemplares() {
		ModeloTablaEjemplares.setData(EjemplarDAO.listaAMatriz(new EjemplarDAO().obtenerListaEjemplares()));
		vista.getPanelEjemplares().getTabla_Ejemplares().setModel(new controlador.ModeloTablaEjemplares());
		vista.getPanelEjemplares().getTabla_Ejemplares().getColumnModel().getColumn(0).setPreferredWidth(24);
		vista.getPanelEjemplares().getTabla_Ejemplares().getColumnModel().getColumn(1).setPreferredWidth(4);
		vista.getPanelEjemplares().getTabla_Ejemplares().getColumnModel().getColumn(2).setPreferredWidth(125);
		vista.getPanelEjemplares().getTabla_Ejemplares().getColumnModel().getColumn(3).setPreferredWidth(40);
		vista.getPanelEjemplares().getTabla_Ejemplares().getColumnModel().getColumn(4).setPreferredWidth(200);
		vista.getPanelEjemplares().getTabla_Ejemplares().getColumnModel().getColumn(5).setPreferredWidth(4);	
	}
	/**
	 * Método para refrecar los datos tras modificar la BD en JPanel Libros
	 */
	public void refrescarTablaLibros() {
		ModeloTablaLibros.setData(LibroDAO.listaAMatriz(new LibroDAO().obtenerListaLibros()));
		vista.getPanelLibros().getTablaLibros().setModel(new controlador.ModeloTablaLibros());
	}
	/**
	 * Método para refrecar los datos tras modificar la BD en JPanel Usuarios
	 */
	public void refrescarTablaUsuarios() {
		ModeloTablaUsuarios.setData(UsuarioDAO.listaAMatriz(new UsuarioDAO().obtenerListadeUsuarios()));	
		vista.getPanelUsuarios().getTableUsuarios().setModel(new controlador.ModeloTablaUsuarios());;
	}
	
	/**
	 * Este metodo activa los campos de TextFields del Panel de libros, los hace editables y les pone el
	 * fondo de color blanco para que se vea que son accesibles. El propósito es introducior datos
	 * para un nuevo libro o para otro tipo de entradas de datos
	 */
	public void hacerEditablesTextFieldsPaneldeLibros() {
		
		vista.getPanelLibros().getTextISBN().setEditable(true);
		vista.getPanelLibros().getTextTitulo().setEditable(true);
		vista.getPanelLibros().getTextAutor().setEditable(true);
		vista.getPanelLibros().getTextEditorial().setEditable(true) ;
		vista.getPanelLibros().getTextEdicion().setEditable(true);
		vista.getPanelLibros().getTextISBN().setBackground(Color.white);
		vista.getPanelLibros().getTextTitulo().setBackground(Color.white);
		vista.getPanelLibros().getTextAutor().setBackground(Color.white);
		vista.getPanelLibros().getTextEditorial().setBackground(Color.white);
		vista.getPanelLibros().getTextEdicion().setBackground(Color.white);
		vista.getPanelLibros().getBtnAadirNuevoLibro().setEnabled(false);
		vista.getPanelLibros().getBtnBorrarLibro().setEnabled(false);
		vista.getPanelLibros().getBtnBorrarLibro().setEnabled(false);
		vista.getPanelLibros().getBtnModificarLibro().setEnabled(false);
		vista.getPanelLibros().getBtnAadirNuevoEjemplar().setEnabled(false);
		vista.getPanelLibros().getBtnGuardarLibro().setVisible(true);
		vista.getPanelLibros().getBtnCancelarLibro().setVisible(true);
		
	}
	
	public void volverOcultosTextFieldsPaneldeLibros() {
		
		vista.getPanelLibros().getTextISBN().setEditable(false);
		vista.getPanelLibros().getTextTitulo().setEditable(false);
		vista.getPanelLibros().getTextAutor().setEditable(false);
		vista.getPanelLibros().getTextEditorial().setEditable(false) ;
		vista.getPanelLibros().getTextEdicion().setEditable(false);
		vista.getPanelLibros().getTextISBN().setBackground(SystemColor.window);
		vista.getPanelLibros().getTextTitulo().setBackground(SystemColor.window);
		vista.getPanelLibros().getTextAutor().setBackground(SystemColor.window);
		vista.getPanelLibros().getTextEditorial().setBackground(SystemColor.window);
		vista.getPanelLibros().getTextEdicion().setBackground(SystemColor.window);
		vista.getPanelLibros().getBtnAadirNuevoLibro().setEnabled(true);
		vista.getPanelLibros().getBtnBorrarLibro().setEnabled(true);
		vista.getPanelLibros().getBtnBorrarLibro().setEnabled(true);
		vista.getPanelLibros().getBtnModificarLibro().setEnabled(true);
		vista.getPanelLibros().getBtnAadirNuevoEjemplar().setEnabled(true);
		vista.getPanelLibros().getBtnGuardarLibro().setVisible(false);
		vista.getPanelLibros().getBtnCancelarLibro().setVisible(false);
		
	}
	/**
	 * Comprueba que el ISBN tiene el formato correcto
	 * @param Cadena
	 * @return coincide
	 */
	public boolean comprobarISBN (String cadena) {
		Pattern patron = Pattern.compile("^\\d{9}[-][\\d|X]$");
		Matcher mat = patron.matcher(cadena);
		return mat.matches();
	}
}
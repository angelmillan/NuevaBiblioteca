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
import modelo.Prestamo;
import modelo.PrestamoDAO;
import modelo.Usuario;
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
	private boolean nuevolibro = false;
	private boolean nuevousuario = false;
	Matcher mat = null;
	private Vista vista;
	private EjemplarDAO ejemplarDAO;
	private LibroDAO libroDAO;
	private UsuarioDAO usuarioDAO;
	private PrestamoDAO prestamoDAO;
	private Prestamo prestamo;


	/**
	 * Controlador del modelo vista controlador, incorpora los Listeners 
	 * y coordina evetos entre la GUI y la capa de persistencia
	 * @param vista la GUI
	 * @param ejemplarDAO
	 * @param libroDAO
	 * @param usuarioDAO
	 */
	public Controlador(Vista vista, EjemplarDAO ejemplarDAO, LibroDAO libroDAO, UsuarioDAO usuarioDAO, PrestamoDAO prestamoDAO) {
		super();
		this.vista = vista;
		this.ejemplarDAO = ejemplarDAO;
		this.libroDAO = libroDAO;
		this.usuarioDAO = usuarioDAO;
		this.prestamoDAO = prestamoDAO;
		//listaUsuarios = ejemplarDAO.obtenerListaEjemplares() ;
		actionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e){
		switch (e.getActionCommand()) {

		// boton de vuelta al menu principal de la aplicacion
		case ("Menú"):
			vista.getPanelAplicacion().setVisible(true);
			vista.getPanelUsuarios().setVisible(false);
			vista.getPanelEjemplares().setVisible(false);
			vista.getPanelLibros().setVisible(false);
			vista.getPanelprestados().setVisible(false);
			vista.getPanelPrestar().setVisible(false);
		break;

		// botones del menu principal de la aplicacion
		case ("Acerca de Biblioteca"):
			vista.getPanelAplicacion().setVisible(true);
			vista.getPanelUsuarios().setVisible(false);
			vista.getPanelEjemplares().setVisible(false);	    		
			vista.getPanelLibros().setVisible(false);
			vista.getPanelprestados().setVisible(false);
			vista.getPanelPrestar().setVisible(false);
		break;

		case ("Salir"):
			System.exit(0);
		break;

		// Botones Panel Aplicación y menus desplegables del frame
		case ("Gestión Usuarios"):
			vista.getPanelAplicacion().setVisible(false);
			vista.getPanelUsuarios().setVisible(true);
			vista.getPanelEjemplares().setVisible(false);
			vista.getPanelLibros().setVisible(false);
			vista.getPanelprestados().setVisible(false);
			vista.getPanelPrestar().setVisible(false);
		break;

		case ("Gestión Libros"):
			vista.getPanelAplicacion().setVisible(false);
			vista.getPanelUsuarios().setVisible(false);
			vista.getPanelEjemplares().setVisible(false);
			vista.getPanelLibros().setVisible(true);
			vista.getPanelprestados().setVisible(false);
			vista.getPanelPrestar().setVisible(false);
		break;

		case ("Gestión Ejemplares"):
			vista.getPanelAplicacion().setVisible(false);
			vista.getPanelUsuarios().setVisible(false);
			vista.getPanelEjemplares().setVisible(true);	    		
			vista.getPanelLibros().setVisible(false);
			vista.getPanelprestados().setVisible(false);
			vista.getPanelPrestar().setVisible(false);
		break;	

		case ("Gestión Préstamos"):
			vista.getPanelAplicacion().setVisible(false);
			vista.getPanelUsuarios().setVisible(false);
			vista.getPanelEjemplares().setVisible(false);	    		
			vista.getPanelLibros().setVisible(false);
			vista.getPanelprestados().setVisible(true);
			vista.getPanelPrestar().setVisible(false);
		break;

		case ("Prestar Ejemplares"):
			vista.getPanelAplicacion().setVisible(false);
			vista.getPanelUsuarios().setVisible(false);
			vista.getPanelEjemplares().setVisible(false);	    		
			vista.getPanelLibros().setVisible(false);
			vista.getPanelprestados().setVisible(false);
			vista.getPanelPrestar().setVisible(true);
		break;	

		// Botones del Panel Ejemplares
		case ("Añadir nuevo ejemplar"):

			if (vista.getPanelEjemplares().getTabla_Ejemplares().getSelectedRow() >= 0) {
				int fila = vista.getPanelEjemplares().getTabla_Ejemplares().getSelectedRow();
				Object isbn = vista.getPanelEjemplares().getTabla_Ejemplares().getValueAt(fila, 0);
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
				if (ejemplarDAO.ejemplarprestado(aBorrar)){
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
			nuevolibro = true;
			limpiaCamposLibros();
			hacerEditablesTextFieldsPaneldeLibros();
			refrescarTablaLibros();
		break;

		case ("Borrar Libro"):
			if (vista.getPanelLibros().getTablaLibros().getSelectedRow() >= 0) {
				int fila = vista.getPanelLibros().getTablaLibros().getSelectedRow();
				Object isbn = vista.getPanelLibros().getTablaLibros().getValueAt(fila, 0);				
				Libro aBorrar = new Libro(isbn.toString());
				Ejemplar abuscar = new Ejemplar(isbn.toString(),1);
				if (!libroDAO.libroprestado(aBorrar)){
					if (ejemplarDAO.ejemplarprestado(abuscar)) {
						vista.getPanelLibros().getTextMensajes().setForeground(Color.RED.brighter());
						vista.getPanelLibros().getTextMensajes().setText("El Libro tiene ejemplares activos no puede eliminarse");
						break;	
					}

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
			hacerEditablesTextFieldsPaneldeLibros();
			vista.getPanelLibros().getTextISBN().setEditable(false);
		break;

		case ("Añadir nuevo ejemplar de libro"):
			if (vista.getPanelLibros().getTablaLibros().getSelectedRow() >= 0) {
				int fila = vista.getPanelLibros().getTablaLibros().getSelectedRow();
				Object isbn = vista.getPanelLibros().getTablaLibros().getValueAt(fila, 0);
				ejemplarDAO.crearEjemplar(new Ejemplar(isbn.toString(), 1));	
					if (!ejemplarDAO.isProblemaSQLejemplarDAO()) {
						vista.getPanelLibros().getTextMensajes().setForeground(Color.GREEN.darker());
						vista.getPanelLibros().getTextMensajes().setText("Ejemplar añadido correctamente");	
					} else {
						vista.getPanelLibros().getTextMensajes().setForeground(Color.red.darker());
						vista.getPanelLibros().getTextMensajes().setText("Ejemplar no ha sido añadido correctamente");
					}
				limpiaCamposLibros();
				refrescarTablaEjemplares();
				refrescarTablaLibros();
			} else {
				vista.getPanelLibros().getTextMensajes().setForeground(Color.RED.brighter());
				vista.getPanelLibros().getTextMensajes().setText("No hay ejemplar seleccionado para añadir");
			}
		break;

		case("Guardar Libro"):			
			guardarLibro();
			volverOcultosTextFieldsPaneldeLibros();
			refrescarTablaLibros();
		break;

		case("Cancelar libro"):
			volverOcultosTextFieldsPaneldeLibros();
			refrescarTablaLibros();
		break;

		// Botones del Panel Usuarios

		case("Añadir nuevo Usuario"):
			nuevousuario = true;
			mat = null;
			limpiaCamposUsuarios();
			hacerEditablesTextFieldsPaneldeUsuarios();
			refrescarTablaUsuarios();
		break;

		case("Borrar Usuario"):
			System.out.println("boton Borrar Usuario");
		break;

		case("Modificar Usuario"):
			System.out.println("boton Modificar Usuario");
			hacerEditablesTextFieldsPaneldeUsuarios();
			vista.getPanelUsuarios().getTextDNI().setEditable(false);
		break;

		case("Guardar Usuario"):
			guardarUsuario()	;
			volverOcultosTextFieldsPaneldeUsuarios();
			refrescarTablaUsuarios();
		break;

		case("Cancelar Usuario"):
			volverOcultosTextFieldsPaneldeUsuarios();
			refrescarTablaUsuarios();
		break;

		case("Devolver Préstamo"):
			
			vista.getPanelprestados().getBtnDevolverEjemplar().setEnabled(false);
			if (vista.getPanelprestados().getTablePrestados().getSelectedRow() >= 0) {
				vista.getPanelprestados().getBtnDevolverEjemplar().setEnabled(true);
				int fila = vista.getPanelprestados().getTablePrestados().getSelectedRow();
				Object dni = vista.getPanelprestados().getTablePrestados().getValueAt(fila, 0);
				Object nombre = vista.getPanelprestados().getTablePrestados().getValueAt(fila, 1);
				Object apellido = vista.getPanelprestados().getTablePrestados().getValueAt(fila, 2);
				Object isbn = vista.getPanelprestados().getTablePrestados().getValueAt(fila, 3);
				Object titulo = vista.getPanelprestados().getTablePrestados().getValueAt(fila, 4);
				Object autor = vista.getPanelprestados().getTablePrestados().getValueAt(fila, 5);
				Object ejemplar = vista.getPanelprestados().getTablePrestados().getValueAt(fila, 6);
				Object fechaprestamo = vista.getPanelprestados().getTablePrestados().getValueAt(fila, 7);
				prestamo = new Prestamo(dni.toString(),nombre.toString(),apellido.toString(),isbn.toString(),titulo.toString(),autor.toString(),(int) ejemplar,fechaprestamo.toString());
				vista.getPanelprestados().getTextFieldMensaje().setForeground(Color.RED.brighter());
				vista.getPanelprestados().getTextFieldMensaje().setText("¿ Está seguro de devolver el ejemplar " + ejemplar +" del libro " + titulo.toString() + " prestado el " + fechaprestamo.toString() + " ?");
				vista.getPanelprestados().getBtnDevolverEjemplar().setEnabled(false);
				vista.getPanelprestados().getBtnConfirmar().setVisible(true);
				vista.getPanelprestados().getBtnCancelar().setVisible(true);
			} else {
				vista.getPanelprestados().getTextFieldMensaje().setForeground(Color.RED.brighter());
				vista.getPanelprestados().getTextFieldMensaje().setText("No hay prestamo seleccionado");
			}

		break;
		
		case("Confirmar Devolución"):
			devolverPrestamo(prestamo);
			vista.getPanelprestados().getBtnConfirmar().setVisible(false);
			vista.getPanelprestados().getBtnCancelar().setVisible(false);
			vista.getPanelprestados().getTextFieldMensaje().setText("Devolución completada correctamente");

		break;

		case ("Cancelar Devolución"):
			vista.getPanelprestados().getBtnConfirmar().setVisible(false);
			vista.getPanelprestados().getBtnCancelar().setVisible(false);
			vista.getPanelprestados().getTextFieldMensaje().setText("Devolución Cancelada");
		break;
		
		default:


			break;
		}

	}
	/**
	 * Método del controlador donde se incluyen los Listeners de los elementos de la aplicacion
	 * @param escuchador
	 * @param event
	 * {@link ActionListener}
	 * {@link ActionEvent}
	 * {@link ListSelectionEvent}
	 */
	private void actionListener(ActionListener escuchador) {
		// Listeners de botones del Menu general
		vista.getMntmAcercaDeBiblioteca().addActionListener(escuchador);
		vista.getMntmSalir().addActionListener(escuchador);
		vista.getMntmGestionarEjemplares().addActionListener(escuchador);
		vista.getMntmGestionarLibros().addActionListener(escuchador);
		vista.getMntmGestionarUsuarios().addActionListener(escuchador);
		vista.getMntmPrestarEjemplares().addActionListener(escuchador);
		vista.getMntmGestionarPrstamos().addActionListener(escuchador);
		// Listeners de botones del panel Ejemplares
		vista.getPanelEjemplares().getButtonAddEjemplar().addActionListener(escuchador);
		vista.getPanelEjemplares().getButtonBorrarEjemplar().addActionListener(escuchador);
		vista.getPanelEjemplares().getButtonBuscarEjemplar().addActionListener(escuchador);
		vista.getPanelEjemplares().getBtnMenu().addActionListener(escuchador);
		// Listeners de botones del panel Libros
		vista.getPanelLibros().getBtnAadirNuevoEjemplar().addActionListener(escuchador);
		vista.getPanelLibros().getBtnAadirNuevoLibro().addActionListener(escuchador);
		vista.getPanelLibros().getBtnBorrarLibro().addActionListener(escuchador);
		vista.getPanelLibros().getBtnModificarLibro().addActionListener(escuchador);
		vista.getPanelLibros().getBtnGuardarLibro().addActionListener(escuchador);
		vista.getPanelLibros().getBtnCancelarLibro().addActionListener(escuchador);
		vista.getPanelLibros().getBtnMenu().addActionListener(escuchador);
		// Listeners de botones del panel Usuarios
		vista.getPanelUsuarios().getBtnAddNuevoUsuario().addActionListener(escuchador);
		vista.getPanelUsuarios().getBtnBorrarUsuario().addActionListener(escuchador);
		vista.getPanelUsuarios().getBtnModificarUsuario().addActionListener(escuchador);
		vista.getPanelUsuarios().getBtnMenu().addActionListener(escuchador);
		vista.getPanelUsuarios().getBtnGuardarUsuario().addActionListener(escuchador);
		vista.getPanelUsuarios().getBtnCancelarUsuario().addActionListener(escuchador);
		// Listener de botones de panel Aplicacion
		vista.getPanelAplicacion().getBtnGestionUsuarios().addActionListener(escuchador);
		vista.getPanelAplicacion().getBtnGestionLibros().addActionListener(escuchador);
		vista.getPanelAplicacion().getBtnGestionEjemplares().addActionListener(escuchador);
		vista.getPanelAplicacion().getBtnGestionPrestamos().addActionListener(escuchador);
		vista.getPanelAplicacion().getBtnPrestarEjemplares().addActionListener(escuchador);
		//Listener de botones de panel devolución prestamos
		vista.getPanelprestados().getBtnDevolverEjemplar().addActionListener(escuchador);
		vista.getPanelprestados().getBtnConfirmar().addActionListener(escuchador);
		vista.getPanelprestados().getBtnCancelar().addActionListener(escuchador);
		vista.getPanelprestados().getBtnMenu().addActionListener(escuchador);
		//Listener de botones de panel prestar ejemplares
		vista.getPanelPrestar().getBtnPrestar().addActionListener(escuchador);
		vista.getPanelPrestar().getBtnMenu().addActionListener(escuchador);

		// Listener ListSelectionEvent para JTable del Panel Ejemplares Obtiene datos de la fila del JTable seleccionado 
		//Los introduce en el JTextField correspondiente mediante accionEventoTablaEjemplares();	

		vista.getPanelEjemplares().getTabla_Ejemplares().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			accionEventoTablaEjemplares();	
		});

		// Listener ListSelectionEvent para JTable del Panel Libros Obtiene datos de la fila del JTable seleccionado 
		// Los introduce en el JTextField correspondiente mediante accionEventoTablaLibros();
		vista.getPanelLibros().getTablaLibros().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			accionEventoTablaLibros();	
		});

		//Listener para JTable del Panel Usuarios Obtiene datos de la fila del JTable seleccionado 
		// Los introduce en el JTextField correspondiente ListSelectionEvent
		vista.getPanelUsuarios().getTableUsuarios().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			accionEventoTablaEsuarios();	
		});

		vista.getPanelprestados().getTableDevueltos().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			//accionEventoTablaDevueltos();
			//vista.getPanelprestados().getBtnDevolverEjemplar().setEnabled(false);
		});
		vista.getPanelprestados().getTablePrestados().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			vista.getPanelprestados().getBtnDevolverEjemplar().setEnabled(true);
			vista.getPanelprestados().getTextFieldMensaje().setText("");
		});
		vista.getPanelPrestar().getTableUsuarioPrestar().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			accionEventoTableUsuarioPrestar();	
		});
		vista.getPanelPrestar().getTableLibrosPrestar().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			accionEventoTableLibroPrestar();	
		});
		vista.getPanelPrestar().getTableEjemplaresPrestar().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			accionEventoTableEjemplarPrestar();	
		});

	}
	
		public void devolverPrestamo(Prestamo prestamo) {
			if (prestamoDAO.devolverPrestamo(prestamo)){
				vista.getPanelprestados().getTextFieldMensaje().setForeground(Color.GREEN.darker());
				vista.getPanelprestados().getTextFieldMensaje().setText("Exito al devolver el ejempla");
				refrescarTablasPrestamos();
			} else {
				vista.getPanelprestados().getTextFieldMensaje().setForeground(Color.GREEN.darker());
				vista.getPanelprestados().getTextFieldMensaje().setText("Problema al devolver el ejempla");
			}
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
	 * guarda usuario del panel usuario
	 */
	private void guardarUsuario() {
		Object dni = vista.getPanelUsuarios().getTextDNI().getText().trim();
		Object nombre = vista.getPanelUsuarios().getTextNombre().getText().trim();
		Object apellidos = vista.getPanelUsuarios().getTextApellidos().getText().trim();
		Object direccion = vista.getPanelUsuarios().getTextDireccion().getText().trim();

		//Comprueba formato del DNI con REGEXP
		if (!comprobarDNIoNIE(dni.toString())) {

			vista.getPanelUsuarios().getTextMensaje().setForeground(Color.RED.brighter());
			vista.getPanelUsuarios().getTextMensaje().setText("El DNI no es correcto formato debe ser #########-A regexp (^\\d{8}[A-Z]$)");
			vista.getPanelUsuarios().getTextDNI().setText("");
			//comprobarDNIoNIE(cadena)
			return;
		}

		// comprueba si existe el DNI en la BD	
		if (usuarioDAO.existeUsuario(new Usuario(dni.toString(),nombre.toString(),apellidos.toString(),direccion.toString())) && nuevousuario) {
			vista.getPanelUsuarios().getTextMensaje().setForeground(Color.RED.brighter());
			vista.getPanelUsuarios().getTextMensaje().setText("El DNI del usuario ya exite, no pueden estar duplicados");
			vista.getPanelUsuarios().getTextDNI().setText("");
			return;
		}

		// comprueba que el nombre y apellidos del usuario no está vacio
		if (nombre.toString().length() == 0 && apellidos.toString().length() == 0) {
			vista.getPanelUsuarios().getTextMensaje().setForeground(Color.RED.brighter());
			vista.getPanelUsuarios().getTextMensaje().setText("DNI correcto pero el Nombre y Apellido del usuario no puede está vacio");	
			return;
		}
		// Guarda o actualiza el libro en la BD
		if (nuevousuario) {
			usuarioDAO.crearUsuario(new Usuario(dni.toString(),nombre.toString(),apellidos.toString(),direccion.toString()));
			nuevousuario = false;
		} else {
			usuarioDAO.actualizarUsuario(new Usuario(dni.toString(),nombre.toString(),apellidos.toString(),direccion.toString()));	
		}
		// comprueba que no ha vulnera las reglas de la bd
		if (!usuarioDAO.isProblemaSQLusuarioDAO()) { 
			vista.getPanelUsuarios().getTextMensaje().setForeground(Color.GREEN.darker());
			vista.getPanelUsuarios().getTextMensaje().setText("Usuario guardado correctamente a la base de datos");
		} else {
			vista.getPanelUsuarios().getTextMensaje().setForeground(Color.RED.darker());
			vista.getPanelUsuarios().getTextMensaje().setText("Problema al acceder a la base de datos");	
		}	
	}
	/**
	 * guardarLibro en el panel Libros
	 */
	public void guardarLibro() {
		Object isbn = vista.getPanelLibros().getTextISBN().getText().trim();
		Object titulo = vista.getPanelLibros().getTextTitulo().getText().trim();
		Object autor = vista.getPanelLibros().getTextAutor().getText().trim();
		Object editorial = vista.getPanelLibros().getTextEditorial().getText().trim();
		Object edicion = vista.getPanelLibros().getTextEdicion().getText().toString();

		System.out.println(edicion);
		System.out.println(edicion.getClass());
		//Comprueba formato del ISBN con REGEXP
		if (!comprobarISBN(isbn.toString())) {				
			vista.getPanelLibros().getTextMensajes().setForeground(Color.RED.brighter());
			vista.getPanelLibros().getTextMensajes().setText("El ISBN no es correcto formato debe ser xxxxxxxxx-x regexp (^\\d{9}[-][\\d|X]$)");
			vista.getPanelLibros().getTextISBN().setText("");
			return;
		}				
		// comprueba si existe el ISBN en la BD	
		if (libroDAO.existeLibro(new Libro(isbn.toString())) && nuevolibro) {
			vista.getPanelLibros().getTextMensajes().setForeground(Color.RED.brighter());
			vista.getPanelLibros().getTextMensajes().setText("El ISBN del libro ya exite, no pueden estar duplicados");
			vista.getPanelLibros().getTextISBN().setText("");
			return;
		}			
		// comprueba que el titulo no está vacio
		if (titulo.toString().length() == 0) {
			vista.getPanelLibros().getTextMensajes().setForeground(Color.RED.brighter());
			vista.getPanelLibros().getTextMensajes().setText("ISBN correcto pero el Título del Libro no puede está vacio");
			return;
		}

		if (!comprobarEdicion(edicion.toString())){	

			Integer yyyy = new Integer("0000");
			System.out.println(yyyy);
			vista.getPanelLibros().getTextMensajes().setForeground(Color.RED.brighter());
			vista.getPanelLibros().getTextMensajes().setText("La Edición tiene que ser (yyyy) de año válido entre el año que se invetó la imprenta y el actual");
			vista.getPanelLibros().getTextEdicion().setText("");
			return;
		}

		// Guarda o actualiza el libro en la BD
		if (nuevolibro) {
			libroDAO.crearLibro(new Libro(isbn.toString(), titulo.toString(), autor.toString(), editorial.toString(), Integer.parseInt(edicion.toString())));
			nuevolibro = false;
		} else {
			libroDAO.actualizarLibro(new Libro(isbn.toString(), titulo.toString(), autor.toString(), editorial.toString(), Integer.parseInt(edicion.toString())));	
		}
		// comprueba que no ha vulnera las reglas de la bd
		if (!libroDAO.isProblemaSQLLibroDAO()) { 
			vista.getPanelLibros().getTextMensajes().setForeground(Color.GREEN.darker());
			vista.getPanelLibros().getTextMensajes().setText("Libro guardado correctamente a la base de datos");
		} else {
			vista.getPanelLibros().getTextMensajes().setForeground(Color.RED.darker());
			vista.getPanelLibros().getTextMensajes().setText("Problema al acceder a la base de datos");	
		}				
	}
	
	/*
	 * Métodos para refrecar los datos tras modificar la BD en JTables 
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
		// En este caso se modifica tambien el formato de las columnas
	}
	/**
	 * Método para refrecar los datos tras modificar la BD en JPanel Libros
	 */
	public void refrescarTablaLibros() {
		ModeloTablaLibros.setData(LibroDAO.listaAMatriz(new LibroDAO().obtenerListaLibros()));
		vista.getPanelLibros().getTablaLibros().repaint();
	}
	/**
	 * Método para refrecar los datos tras modificar la BD en JPanel Usuarios
	 */
	public void refrescarTablaUsuarios() {
		ModeloTablaUsuarios.setData(UsuarioDAO.listaAMatriz(new UsuarioDAO().obtenerListadeUsuarios()));	
		vista.getPanelUsuarios().getTableUsuarios().repaint();
	}
	
	public void refrescarTablasPrestamos() {
		ModeloTablaPrestados.setData(PrestamoDAO.listaAMatrizPrestado(new PrestamoDAO().obtenerListaPrestados()));
		vista.getPanelprestados().getTablePrestados().repaint();
		vista.getPanelprestados().getTablePrestados().setModel(new ModeloTablaPrestados());
		ModeloTableDevueltos.setData(PrestamoDAO.listaAMatrizDisponibles(new PrestamoDAO().obtenerListaDevueltos()));
		vista.getPanelprestados().getTableDevueltos().setModel(new ModeloTableDevueltos());
		vista.getPanelprestados().getTableDevueltos().repaint();
		vista.getPanelprestados().getBtnDevolverEjemplar().setEnabled(false);

	}
	/// fin de métodos de refresco de tablas
	
	/*
	 * Estos metodo activa los campos de TextFields del Panel de libros, los hace editables y les pone el
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
		vista.getPanelLibros().getBtnMenu().setEnabled(false);
		vista.getPanelLibros().getBtnGuardarLibro().setVisible(true);
		vista.getPanelLibros().getBtnCancelarLibro().setVisible(true);

	}
	/**
	 * volverOcultosTextFieldsPaneldeLibros() oculta los Texfiel y Botones necesario para añadir o editar Libros
	 */
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
		vista.getPanelLibros().getBtnMenu().setEnabled(true);
		vista.getPanelLibros().getBtnGuardarLibro().setVisible(false);
		vista.getPanelLibros().getBtnCancelarLibro().setVisible(false);	
	}

	public void hacerEditablesTextFieldsPaneldeUsuarios() {

		vista.getPanelUsuarios().getTextDNI().setEditable(true);
		vista.getPanelUsuarios().getTextNombre().setEditable(true);
		vista.getPanelUsuarios().getTextApellidos().setEditable(true);
		vista.getPanelUsuarios().getTextDireccion().setEditable(true);
		vista.getPanelUsuarios().getTextDNI().setBackground(Color.white);
		vista.getPanelUsuarios().getTextNombre().setBackground(Color.white);
		vista.getPanelUsuarios().getTextApellidos().setBackground(Color.white);
		vista.getPanelUsuarios().getTextDireccion().setBackground(Color.white);
		vista.getPanelUsuarios().getBtnAddNuevoUsuario().setEnabled(false);
		vista.getPanelUsuarios().getBtnBorrarUsuario().setEnabled(false);
		vista.getPanelUsuarios().getBtnModificarUsuario().setEnabled(false);
		vista.getPanelUsuarios().getBtnMenu().setEnabled(false);
		vista.getPanelUsuarios().getBtnGuardarUsuario().setVisible(true);
		vista.getPanelUsuarios().getBtnCancelarUsuario().setVisible(true);
	}

	public void volverOcultosTextFieldsPaneldeUsuarios() {
		vista.getPanelUsuarios().getTextDNI().setEditable(false);
		vista.getPanelUsuarios().getTextNombre().setEditable(false);
		vista.getPanelUsuarios().getTextApellidos().setEditable(false);
		vista.getPanelUsuarios().getTextDireccion().setEditable(false);
		vista.getPanelUsuarios().getTextDNI().setBackground(SystemColor.window);
		vista.getPanelUsuarios().getTextNombre().setBackground(SystemColor.window);
		vista.getPanelUsuarios().getTextApellidos().setBackground(SystemColor.window);
		vista.getPanelUsuarios().getTextDireccion().setBackground(SystemColor.window);
		vista.getPanelUsuarios().getBtnAddNuevoUsuario().setEnabled(true);
		vista.getPanelUsuarios().getBtnBorrarUsuario().setEnabled(true);
		vista.getPanelUsuarios().getBtnModificarUsuario().setEnabled(true);
		vista.getPanelUsuarios().getBtnMenu().setEnabled(true);
		vista.getPanelUsuarios().getBtnGuardarUsuario().setVisible(false);
		vista.getPanelUsuarios().getBtnCancelarUsuario().setVisible(false);
	}
	// fin de métodos para ocultar o visibilizar elementos en paneles al editarlos

	/// Comprobaciones con expresiones regulares //
	/**
	 * Comprueba que el ISBN tiene el formato correcto
	 * @param Cadena es un ISBN a comprobar
	 * @return true si coincide con la expresión regular (^\\d{9}[-][\\d|X]$)
	 */
	public boolean comprobarISBN (String cadena) {
		Matcher mat = null;
		Pattern patron = Pattern.compile("^\\d{9}[-][\\d|X]$");
		mat = patron.matcher(cadena);
		return mat.matches();
	}
	/**
	 * 
	 * @param cadena es un DNI o NIE a comprobar
	 * @return true si la cadena coincide con la expresion regular (^\\d{9}[-][\\d|X]$ (([X-Z]{1})([-]?)(\\d{7})([-]?)([A-Z]{1}))|((\\d{8})([-]?)([A-Z]{1})))
	 */
	public boolean comprobarDNIoNIE (String cadena) {

		Pattern patron = Pattern.compile("^\\d{8}[A-Z]$");
		mat = patron.matcher(cadena);
		return mat.matches();
	}
	/**
	 * 
	 * @param cadena para que el año tenga 4 dgitos
	 * @return
	 */
	public boolean comprobarEdicion (String cadena) {
		Pattern patron = Pattern.compile("^\\d{4}");
		mat = patron.matcher(cadena);
		return mat.matches();
	}
	/// fin de comprobaciones con expresiones regulares //


	/* Acciónes que dispara el Listener para los JTable de los diferentes Paneles
	 * Obtiene datos de la fila del JTable seleccionado 
	 * Los introduce en el JTextField correspondiente
	 */
	public void accionEventoTablaEjemplares() {
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
	}

	public void accionEventoTablaEsuarios() {
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
	}

	public void accionEventoTablaLibros() {
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
	}

	public void accionEventoTableUsuarioPrestar() {
		try {
			int fila = vista.getPanelPrestar().getTableUsuarioPrestar().getSelectedRow();
			if (vista.getPanelPrestar().getTableUsuarioPrestar().getSelectedRow() >= 0) {
				Object dni = vista.getPanelPrestar().getTableUsuarioPrestar().getValueAt(fila, 0);
				Object nombre = vista.getPanelPrestar().getTableUsuarioPrestar().getValueAt(fila, 1);
				Object apellidos = vista.getPanelPrestar().getTableUsuarioPrestar().getValueAt(fila, 2);

				vista.getPanelPrestar().getTextDniUsuario().setText(dni.toString());
				vista.getPanelPrestar().getTextNombreUsuario().setText(nombre.toString());
				vista.getPanelPrestar().getTextApellidosUsuarios().setText(apellidos.toString());

			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void accionEventoTableLibroPrestar() {
		try {
			int fila = vista.getPanelPrestar().getTableLibrosPrestar().getSelectedRow();
			if (vista.getPanelPrestar().getTableLibrosPrestar().getSelectedRow() >= 0) {
				Object isbn = vista.getPanelPrestar().getTableLibrosPrestar().getValueAt(fila, 0);
				Object titulo = vista.getPanelPrestar().getTableLibrosPrestar().getValueAt(fila, 1);
				Object autor = vista.getPanelPrestar().getTableLibrosPrestar().getValueAt(fila, 2);

				vista.getPanelPrestar().getTextIsbnLibro().setText(isbn.toString());
				vista.getPanelPrestar().getTextTituloLibro().setText(titulo.toString());
				vista.getPanelPrestar().getTextAutorLibro().setText(autor.toString());
				String isbn_Ejemplar = vista.getPanelPrestar().getTextIsbnLibro().getText();
				ModeloTablaPrestarEjemplares.setData(EjemplarDAO.listaAMatrizPrestar(new EjemplarDAO().obtenerListadeEjemplaresDelMismoLibro(new Ejemplar(isbn_Ejemplar,1))));
				vista.getPanelPrestar().getTableEjemplaresPrestar().setModel(new controlador.ModeloTablaPrestarEjemplares());
				vista.getPanelPrestar().getTextIsbnEjemplar().setText("");
				vista.getPanelPrestar().getTextNumeroEjemplar().setText("");
				vista.getPanelPrestar().getTextTituloEjemplar().setText("");
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void accionEventoTableEjemplarPrestar() {
		try {
			int fila = vista.getPanelPrestar().getTableEjemplaresPrestar().getSelectedRow();
			if (vista.getPanelPrestar().getTableEjemplaresPrestar().getSelectedRow() >= 0) {
				Object isbn = vista.getPanelPrestar().getTableEjemplaresPrestar().getValueAt(fila, 0);
				Object ejemplar = vista.getPanelPrestar().getTableEjemplaresPrestar().getValueAt(fila, 1);
				Object titulo = vista.getPanelPrestar().getTableEjemplaresPrestar().getValueAt(fila, 2);

				vista.getPanelPrestar().getTextIsbnEjemplar().setText(isbn.toString());
				vista.getPanelPrestar().getTextNumeroEjemplar().setText(ejemplar.toString());
				vista.getPanelPrestar().getTextTituloEjemplar().setText(titulo.toString());

				Ejemplar eje = new Ejemplar(isbn.toString(),Integer.parseInt(ejemplar.toString()));
				if (!ejemplarDAO.ejemplarprestado(eje)) {
					vista.getPanelPrestar().getTextMensaje().setForeground(Color.RED.brighter());
					vista.getPanelPrestar().getTextMensaje().setText("El ejemplar " + ejemplar.toString() + " del libro " + titulo.toString() +" está prestado.");	
				} else {
					vista.getPanelPrestar().getTextMensaje().setForeground(Color.GREEN.darker());
					vista.getPanelPrestar().getTextMensaje().setText("El ejemplar " + ejemplar.toString() + " del libro " + titulo.toString() +" está libre, puede prestarlo ");	
				}
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		/*
		 * Fin acciones de eventos en jTable 
		 */
		
		
	}
	
}
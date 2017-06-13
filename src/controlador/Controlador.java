package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;



import javax.swing.event.ListSelectionEvent;


import modelo.Ejemplar;
import modelo.EjemplarDAO;
import vista.Vista;

public class Controlador implements ActionListener {
	private Vista vista;


	private EjemplarDAO ejemplarDAO;
	private int contador1 = 1;
	List<Ejemplar> listaUsuarios;
	
	
	

	public Controlador(Vista vista, EjemplarDAO ejemplarDAO) {
		super();
		this.vista = vista;
		this.ejemplarDAO = ejemplarDAO;
		//listaUsuarios = ejemplarDAO.obtenerListaEjemplares() ;
		actionListener(this);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e){
		switch (e.getActionCommand()) {
		
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
				ejemplarDAO.borrarEjemplar(new Ejemplar(isbn.toString(), (int) numero_ejemplar));
				vista.getPanelEjemplares().getTextField_Mensajes().setForeground(Color.GREEN.darker());
				vista.getPanelEjemplares().getTextField_Mensajes().setText("Ejemplar borrado correctamente");
				refrescarTablaEjemplares();
				limpiaCamposEjemplares();				
			} else {
				vista.getPanelEjemplares().getTextField_Mensajes().setForeground(Color.RED.brighter());
				vista.getPanelEjemplares().getTextField_Mensajes().setText("No hay ejemplar seleccionado para eliminar");
			}
			
			break;
	
		default:
			break;
		}

	}

	private void actionListener(ActionListener escuchador) {
		// TODO Apéndice de método generado automáticamente
		//vista.getMntmSalir().addActionListener(escuchador);
		vista.getMntmGestionarEjemplares().addActionListener(escuchador);
		vista.getMntmGestionarLibros().addActionListener(escuchador);
		vista.getMntmGestionarUsuarios().addActionListener(escuchador);
		vista.getPanelEjemplares().getButtonAddEjemplar().addActionListener(escuchador);
		vista.getPanelEjemplares().getButtonBorrarEjemplar().addActionListener(escuchador);
		vista.getPanelEjemplares().getButtonBuscarEjemplar().addActionListener(escuchador);
		
		
		
		

		
		
		
		vista.getPanelEjemplares().getTabla_Ejemplares().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			try {
                if (vista.getPanelEjemplares().getTabla_Ejemplares().getSelectedRow() >= 0) {
                		
                		Object isbn = vista.getPanelEjemplares().getTabla_Ejemplares().getValueAt(vista.getPanelEjemplares().getTabla_Ejemplares().getSelectedRow(), 0);
                		Object numero_ejemplar = vista.getPanelEjemplares().getTabla_Ejemplares().getValueAt(vista.getPanelEjemplares().getTabla_Ejemplares().getSelectedRow(), 1);
                    Object titulo = vista.getPanelEjemplares().getTabla_Ejemplares().getValueAt(vista.getPanelEjemplares().getTabla_Ejemplares().getSelectedRow(), 2);
                    Object autor = vista.getPanelEjemplares().getTabla_Ejemplares().getValueAt(vista.getPanelEjemplares().getTabla_Ejemplares().getSelectedRow(), 3);
                    Object editorial = vista.getPanelEjemplares().getTabla_Ejemplares().getValueAt(vista.getPanelEjemplares().getTabla_Ejemplares().getSelectedRow(), 4);
                		Object edicion = vista.getPanelEjemplares().getTabla_Ejemplares().getValueAt(vista.getPanelEjemplares().getTabla_Ejemplares().getSelectedRow(), 5);

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
		
		
		
		
	}
	public void limpiaCamposEjemplares() {
		vista.getPanelEjemplares().getTextField_ISBN_Ejemplar().setText("");
		vista.getPanelEjemplares().getTextField_NUmero_Ejemplar().setText("");
		vista.getPanelEjemplares().getTextField_Titulo_Ejemplar().setText("");
		vista.getPanelEjemplares().getTextField_Autor_Ejemplar().setText("");
		vista.getPanelEjemplares().getTextField_Editorial_Ejemplar().setText("");
		vista.getPanelEjemplares().getTextField_Edicion_Ejemplar().setText("");

	}
	
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
}
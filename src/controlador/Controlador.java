package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.sql.rowset.Joinable;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.TableModel;
import javax.swing.text.TableView.TableRow;

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
		    vista.getPanelPrestamos().setVisible(false);
			break;
			
		case ("Gestionar Libros"):
			vista.getPanelUsuarios().setVisible(false);
	    		vista.getPanelEjemplares().setVisible(false);
	    		vista.getPanelLibros().setVisible(true);
	    		vista.getPanelPrestamos().setVisible(false);
			break;
			
		case ("Gestionar Ejemplares"):
			vista.getPanelUsuarios().setVisible(false);
	    		vista.getPanelEjemplares().setVisible(true);
	    		vista.getPanelLibros().setVisible(false);
	    		vista.getPanelPrestamos().setVisible(false);
			break;
			
		case ("Gestionar Préstamos"):
			vista.getPanelUsuarios().setVisible(false);
	    		vista.getPanelEjemplares().setVisible(false);
	    		vista.getPanelLibros().setVisible(false);
	    		vista.getPanelPrestamos().setVisible(true);
			break;
			
		case ("Salir"):
			vista.getPanelUsuarios().setVisible(false);
	    		vista.getPanelEjemplares().setVisible(false);
	    		vista.getPanelLibros().setVisible(true);
	    		vista.getPanelPrestamos().setVisible(false);
			break;
		
		case ("Añadir nuevo ejemplar"):
			if (vista.getTable().getSelectedRow() >= 0) {
				Object isbn = vista.getTable().getValueAt(vista.getTable().getSelectedRow(), 0);
				ejemplarDAO.crearEjemplar(new Ejemplar(isbn.toString(), 1));	
				vista.getTextFieldInformacionAlUsuario().setText("Ejemplar añadido correctamente");
				refrescarTabla();
				limpiaCampos();				
			} else {
				vista.getTextFieldInformacionAlUsuario().setText("No hay ejemplar seleccionado");
			}
			break;
		
		case ("Borrar Ejemplar"):
			if (vista.getTable().getSelectedRow() >= 0) {
				Object isbn = vista.getTable().getValueAt(vista.getTable().getSelectedRow(), 0);
				Object numero_ejemplar = vista.getTable().getValueAt(vista.getTable().getSelectedRow(), 1);
				ejemplarDAO.borrarEjemplar(new Ejemplar(isbn.toString(), (int) numero_ejemplar));	
				vista.getTextFieldInformacionAlUsuario().setText("Ejemplar borrado correctamente");
				refrescarTabla();
				limpiaCampos();				
			} else {
				vista.getTextFieldInformacionAlUsuario().setText("No hay ejemplar seleccionado");
			}
			break;
			
			
			
			
		case ("Borrar"):
			ejemplarDAO.borrarEjemplar(listaUsuarios.get(contador1));
			
			break;
		default:
			break;
		}

	}

	private void actionListener(ActionListener escuchador) {
		// TODO Apéndice de método generado automáticamente
		vista.getMntmSalir().addActionListener(escuchador);
		vista.getMnEjemplares().addActionListener(escuchador);
		vista.getMnPrestamos().addActionListener(escuchador);
		vista.getMnUsuarios().addActionListener(escuchador);
		vista.getMnLibros().addActionListener(escuchador);
		vista.getMntmGestionarEjemplares().addActionListener(escuchador);
		vista.getMntmGestionarLibros().addActionListener(escuchador);
		vista.getMntmGestionarPrstamos().addActionListener(escuchador);
		vista.getMntmGestionarUsuarios().addActionListener(escuchador);
		vista.getBtnAadirEjemplar().addActionListener(escuchador);
		vista.getBtnBorrarEjemplar().addActionListener(escuchador);
		vista.getBtnBuscarEjemplar().addActionListener(escuchador);
		vista.getTextFieldInformacionAlUsuario().addActionListener(escuchador);
		

		vista.getTable().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			try {
                if (vista.getTable().getSelectedRow() >= 0) {
                	
                    Object isbn = vista.getTable().getValueAt(vista.getTable().getSelectedRow(), 0);
                    Object numero_ejemplar = vista.getTable().getValueAt(vista.getTable().getSelectedRow(), 1);
                    Object titulo = vista.getTable().getValueAt(vista.getTable().getSelectedRow(), 2);
                    Object autor = vista.getTable().getValueAt(vista.getTable().getSelectedRow(), 3);
                    Object editorial = vista.getTable().getValueAt(vista.getTable().getSelectedRow(), 4);
                    Object edicion = vista.getTable().getValueAt(vista.getTable().getSelectedRow(), 5);


                    vista.getTxtIsbnejemplar().setText(isbn.toString());
                    vista.getTxtTitulo().setText(titulo.toString());
                    vista.getTxtAutor().setText(autor.toString());
                    vista.getTxtEditorial().setText(editorial.toString());
                    vista.getTxtEdicion().setText(edicion.toString());
                    vista.getTxtNumeroejemplar().setText(numero_ejemplar.toString());
                    
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
		});
		
	}
	public void limpiaCampos() {
		vista.getTxtIsbnejemplar().setText("");
        vista.getTxtTitulo().setText("");
        vista.getTxtAutor().setText("");
        vista.getTxtEditorial().setText("");
        vista.getTxtEdicion().setText("");
        vista.getTxtNumeroejemplar().setText("");
	}
	
	public void refrescarTabla() {
		ModeloTablaEjemplares.setData(EjemplarDAO.listaAMatriz(new EjemplarDAO().obtenerListaEjemplares()));
		vista.getTable().setModel(new controlador.ModeloTablaEjemplares());
		vista.getColumnModel().getColumn(0).setPreferredWidth(24);
		vista.getColumnModel().getColumn(1).setPreferredWidth(4);
		vista.getColumnModel().getColumn(2).setPreferredWidth(150);
		vista.getColumnModel().getColumn(3).setPreferredWidth(40);
		vista.getColumnModel().getColumn(4).setPreferredWidth(200);
		vista.getColumnModel().getColumn(5).setPreferredWidth(4);
	}

}

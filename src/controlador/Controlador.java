package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.sql.rowset.Joinable;
import javax.swing.JTable;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
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
		listaUsuarios = ejemplarDAO.obtenerListaEjemplares() ;
		pintarUsuario(vista.getTable().getSelectedRow()+1);
		actionListener(this);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e){
		switch (e.getActionCommand()) {
		case ("<"):
			contador1--;
			if (contador1 < 0)
				contador1 = listaUsuarios.size() - 1;
			System.out.println(listaUsuarios.size() + " " + contador1);
			pintarUsuario(contador1);
			break;
		case (">"):
			contador1++;
			if (contador1 == listaUsuarios.size())
				contador1 = 0;
			System.out.println(listaUsuarios.size() + " " + contador1);
			pintarUsuario(contador1);
			break;
		case (">>"):
			contador1 += 25;
			if (contador1 >= listaUsuarios.size())
				contador1 = 0;
			System.out.println(listaUsuarios.size() + " " + contador1);
			pintarUsuario(contador1);
			break;
		case ("<<"):
			contador1 -= 25;
			if (contador1 < 0)
				contador1 = listaUsuarios.size() - 1;
			System.out.println(listaUsuarios.size() + " " + contador1);
			pintarUsuario(contador1);
			break;
		case ("Salir"):
			System.out.println("porfin");
			int  o = vista.getTable().getSelectedRow();
			vista.getTxtIsbnejemplar().setText(listaUsuarios.get(vista.getTable().getSelectedRow()).getIsbnEjemplar());

			System.out.println(o);
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
		////vista.getTable().add;
		
		//vista.getBtnAvanzar25().addActionListener(escuchador);
		//vista.getBtnRetroceder1().addActionListener(escuchador);
		//vista.getBtnRetroceder25().addActionListener(escuchador);
		//vista.getBtnEliminar().addActionListener(escuchador);
		//vista.getBtnGuardar().addActionListener(escuchador);
		//vista.getBtnInsertar().addActionListener(escuchador);
		//vista.getMnCrud().addActionListener(escuchador);
		//vista.getMntmBorrar().addActionListener(escuchador);
		//vista.getMntmCrear().addActionListener(escuchador);
		//vista.getTxtIsbnejemplar()
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
	
	private void pintarUsuario(int i) {
		int o = vista.getTable().getSelectedRow();
		System.out.println(o);
		// TODO Apéndice de método generado automáticamente
		//vista.getTxtLogin().setText(listaUsuarios.get(i).getLogin());
		//vista.getTxtPassword().setText(listaUsuarios.get(i).getPassword());
		//vista.getTxtCode().setText(listaUsuarios.get(i).getCode());
		//vista.getTxtGender().setText(listaUsuarios.get(i).getGender());
		vista.getTxtIsbnejemplar().setText(listaUsuarios.get(vista.getTable().getSelectedRow()+1).getIsbnEjemplar());
	}
	
	private void ese(){

		}
}

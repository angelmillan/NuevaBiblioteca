package controlador;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import modelo.Ejemplar;
import modelo.EjemplarDAO;




@SuppressWarnings("serial")
public class ModeloTablaPrestarEjemplares extends AbstractTableModel implements TableModelListener {
	
	private static Ejemplar ejemplar_comodin = new Ejemplar("",1);
	
	private static String[] columnNames = {
           
            "ISBN",
            "Ejemplar",
            "Titulo",
            };
	//UsuarioDAO.listaAMatriz(new UsuarioDAO().obtenerListadeUsuarios())
	
	private static Object[][] data = EjemplarDAO.listaAMatrizPrestar(new EjemplarDAO().obtenerListadeEjemplaresDelMismoLibro(ejemplar_comodin));
			//PrestamoDAO.listaAMatrizDisponibles(new PrestamoDAO().obtenerListaDevueltos());
	
	
	
	
	public ModeloTablaPrestarEjemplares () {
		addTableModelListener(this);
	}

	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex < 8) {
            return false;
        } else {
            return true;
        }
	}
	
	@Override
	public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
	

	@Override
	public void tableChanged(TableModelEvent e) {
		
	}

	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	/**
	 * @return the columnNames
	 */
	public static String[] getColumnNames() {
		return columnNames;
	}

	/**
	 * @param columnNames the columnNames to set
	 */
	public static void setColumnNames(String[] columnNames) {
		ModeloTablaPrestarEjemplares.columnNames = columnNames;
	}

	/**
	 * @return the data
	 */
	public static Object[][] getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public static void setData(Object[][] data) {
		ModeloTablaPrestarEjemplares.data = data;
	}


	/**
	 * @return the ejemplar_comodin
	 */
	public static Ejemplar getEjemplar_comodin() {
		return ejemplar_comodin;
	}


	/**
	 * @param ejemplar_comodin the ejemplar_comodin to set
	 */
	public static void setEjemplar_comodin(Ejemplar ejemplar_comodin) {
		ModeloTablaPrestarEjemplares.ejemplar_comodin = ejemplar_comodin;
	}
	
}







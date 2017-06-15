package controlador;



import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import modelo.UsuarioDAO;


@SuppressWarnings("serial")
public class ModeloTablaUsuarios extends AbstractTableModel implements TableModelListener {
	

	private static String[] columnNames = {
           
            "DNI",
            "Nombre",
            "Apellidos",
            "Dirección"};
	
	private static Object[][] data = UsuarioDAO.listaAMatriz(new UsuarioDAO().obtenerListadeUsuarios());
	
	
	
	public ModeloTablaUsuarios () {
		addTableModelListener(this);
	}

	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex < 4) {
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
		ModeloTablaUsuarios.columnNames = columnNames;
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
		ModeloTablaUsuarios.data = data;
	}
	
}


package controlador;


import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import modelo.EjemplarDAO;


@SuppressWarnings("serial")
public class ModeloTablaEjemplares extends AbstractTableModel implements TableModelListener {
	
	private int posicion;
	
	/**
	 * @return the posicion
	 */
	public int getPosicion() {
		return posicion;
	}

	/**
	 * @param posicion the posicion to set
	 */
	public void setPosicion(int posicion) {
		this.posicion = posicion;
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
		ModeloTablaEjemplares.columnNames = columnNames;
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
		ModeloTablaEjemplares.data = data;
	}


	private static String[] columnNames = {"ISBN",
            "Nº Ejemplar",
            "Título",
            "Autor",
            "Editorial",
            "Edición"};
	
	private static Object[][] data = EjemplarDAO.listaAMatriz(new EjemplarDAO().obtenerListaEjemplares());
	
	
	public ModeloTablaEjemplares () {
		addTableModelListener(this);
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
		// TODO Auto-generated method stub
		return columnNames[column];
	}
	
	

	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex < 3) {
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
	
	public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
	

	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub
		int u = JTable.AUTO_RESIZE_ALL_COLUMNS;
		
		System.out.println(u);
		System.out.println(posicion);
	}


}

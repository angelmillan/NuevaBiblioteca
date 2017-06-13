package vista;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import controlador.ModeloTablaLibros;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class PanelParaLibros extends JPanel {
	private JTextField textMensajes;
	private JTextField textAutor;
	private JTextField textEdicion;
	private JTextField textISBN;
	private JTextField textField_4;
	private JTextField textEditorial;
	private JTextField textTitulo;
	private JTable tablaLibros;
	private JButton btnAadirNuevoLibro;
	private JButton btnBorrarLibro;
	private JButton btnModificarLibro;
	//private ModeloTablaLibros tablaLibros;

	/**
	 * Create the panel.
	 */
	public PanelParaLibros() {
		setBounds(new Rectangle(0, 0, 900, 450));
		
		btnAadirNuevoLibro = new JButton("Añadir nuevo Libro");
		btnAadirNuevoLibro.setBounds(new Rectangle(25, 25, 0, 0));
		
		btnBorrarLibro = new JButton("Borrar Libro");
		btnBorrarLibro.setBounds(new Rectangle(25, 25, 0, 0));
		
		btnModificarLibro = new JButton("Modificar Libro");
		btnModificarLibro.setBounds(new Rectangle(25, 25, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(new Rectangle(25, 25, 0, 0));
		
		textMensajes = new JTextField();
		textMensajes.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		textMensajes.setBounds(new Rectangle(25, 25, 0, 0));
		textMensajes.setForeground(Color.RED);
		textMensajes.setEditable(false);
		textMensajes.setColumns(10);
		textMensajes.setBackground(SystemColor.window);
		
		JPanel panel = new JPanel();
		panel.setBounds(new Rectangle(25, 25, 0, 0));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Libro seleccionado", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel label = new JLabel("Autor");
		
		textAutor = new JTextField();
		textAutor.setText("");
		textAutor.setEditable(false);
		textAutor.setColumns(10);
		textAutor.setBackground(SystemColor.window);
		
		JLabel label_1 = new JLabel("Edición");
		
		textEdicion = new JTextField();
		textEdicion.setText("");
		textEdicion.setEditable(false);
		textEdicion.setColumns(10);
		textEdicion.setBackground(SystemColor.window);
		
		JLabel label_2 = new JLabel("Título");
		
		JLabel label_3 = new JLabel("ISBN");
		
		textISBN = new JTextField();
		textISBN.setText("");
		textISBN.setEditable(false);
		textISBN.setColumns(10);
		textISBN.setBackground(SystemColor.window);
		
		JLabel lblEjemplares = new JLabel("Ejemplares\n");
		
		textField_4 = new JTextField();
		textField_4.setText("");
		textField_4.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_4.setForeground(new Color(128, 0, 0));
		textField_4.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBackground(SystemColor.window);
		
		JLabel label_5 = new JLabel("Editorial");
		
		textEditorial = new JTextField();
		textEditorial.setText("");
		textEditorial.setEditable(false);
		textEditorial.setColumns(10);
		textEditorial.setBackground(SystemColor.window);
		
		textTitulo = new JTextField();
		textTitulo.setText("");
		textTitulo.setEditable(false);
		textTitulo.setColumns(10);
		textTitulo.setBackground(SystemColor.window);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 850, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label)
							.addGap(18)
							.addComponent(textAutor, GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(label_1)
							.addGap(18)
							.addComponent(textEdicion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2)
								.addComponent(label_3))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(textISBN, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(lblEjemplares)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addGap(51)
									.addComponent(label_5)
									.addGap(18)
									.addComponent(textEditorial, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE))
								.addComponent(textTitulo, GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE))))
					.addGap(17))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 156, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(textEditorial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textISBN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5)
						.addComponent(lblEjemplares)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(textTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textAutor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(textEdicion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(30, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 850, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 850, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAadirNuevoLibro, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(btnBorrarLibro, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addGap(37)
							.addComponent(btnModificarLibro, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(textMensajes, GroupLayout.PREFERRED_SIZE, 844, GroupLayout.PREFERRED_SIZE)))
					.addGap(20))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(17, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAadirNuevoLibro)
						.addComponent(btnBorrarLibro)
						.addComponent(btnModificarLibro))
					.addGap(12)
					.addComponent(textMensajes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		tablaLibros = new JTable(new ModeloTablaLibros());
		scrollPane.setViewportView(tablaLibros);
		setLayout(groupLayout);

	}

	/**
	 * @return the textMensajes
	 */
	public JTextField getTextMensajes() {
		return textMensajes;
	}

	/**
	 * @param textMensajes the textMensajes to set
	 */
	public void setTextMensajes(JTextField textMensajes) {
		this.textMensajes = textMensajes;
	}



	/**
	 * @return the textAutor
	 */
	public JTextField getTextAutor() {
		return textAutor;
	}

	/**
	 * @param textAutor the textAutor to set
	 */
	public void setTextAutor(JTextField textAutor) {
		this.textAutor = textAutor;
	}

	/**
	 * @return the textEdicion
	 */
	public JTextField getTextEdicion() {
		return textEdicion;
	}

	/**
	 * @param textEdicion the textEdicion to set
	 */
	public void setTextEdicion(JTextField textEdicion) {
		this.textEdicion = textEdicion;
	}

	/**
	 * @return the textISBN
	 */
	public JTextField getTextISBN() {
		return textISBN;
	}

	/**
	 * @param textISBN the textISBN to set
	 */
	public void setTextISBN(JTextField textISBN) {
		this.textISBN = textISBN;
	}

	/**
	 * @return the textEditorial
	 */
	public JTextField getTextEditorial() {
		return textEditorial;
	}

	/**
	 * @param textEditorial the textEditorial to set
	 */
	public void setTextEditorial(JTextField textEditorial) {
		this.textEditorial = textEditorial;
	}

	/**
	 * @return the textTitulo
	 */
	public JTextField getTextTitulo() {
		return textTitulo;
	}

	/**
	 * @param textTitulo the textTitulo to set
	 */
	public void setTextTitulo(JTextField textTitulo) {
		this.textTitulo = textTitulo;
	}

	/**
	 * @return the tableLibros
	 */
	public JTable getTableLibros() {
		return tablaLibros;
	}

	/**
	 * @param tableLibros the tableLibros to set
	 */
	public void setTableLibros(JTable tablaLibros) {
		this.tablaLibros = tablaLibros;
	}
	
	
	
}

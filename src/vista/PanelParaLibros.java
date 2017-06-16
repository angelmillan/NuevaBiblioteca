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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PanelParaLibros extends JPanel {
	private JTextField textMensajes;
	private JTextField textAutor;
	private JTextField textEdicion;
	private JTextField textISBN;
	private JTextField textEditorial;
	private JTextField textTitulo;
	private JTable tablaLibros;
	private JButton btnAadirNuevoLibro;
	private JButton btnBorrarLibro;
	private JButton btnModificarLibro;
	private JButton btnAadirNuevoEjemplar;
	private JButton btnGuardarLibro;
	private JButton btnCancelarLibro;
	private JButton btnMenu;

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
		
		btnGuardarLibro = new JButton("Guardar Libro");
		btnGuardarLibro.setVisible(false);
		
		btnCancelarLibro = new JButton("Cancelar libro");
		btnCancelarLibro.setVisible(false);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
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
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
									.addComponent(textISBN, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(label_5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textEditorial, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE))
								.addComponent(textTitulo, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnCancelarLibro)
								.addComponent(btnGuardarLibro))))
					.addGap(17))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(textISBN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textEditorial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnGuardarLibro)
						.addComponent(label_5))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(textTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancelarLibro))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textAutor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(textEdicion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		btnAadirNuevoEjemplar = new JButton("Añadir nuevo ejemplar de libro");
		btnAadirNuevoEjemplar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnMenu = new JButton("Menú");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(8, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 850, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 850, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addComponent(btnAadirNuevoLibro, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnBorrarLibro, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnModificarLibro, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnAadirNuevoEjemplar)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnMenu))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGap(6)
								.addComponent(textMensajes, GroupLayout.PREFERRED_SIZE, 844, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(11, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAadirNuevoLibro)
						.addComponent(btnBorrarLibro)
						.addComponent(btnModificarLibro)
						.addComponent(btnAadirNuevoEjemplar)
						.addComponent(btnMenu))
					.addGap(12)
					.addComponent(textMensajes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		tablaLibros = new JTable(new ModeloTablaLibros());
		scrollPane.setViewportView(tablaLibros);
		tablaLibros.setAutoCreateRowSorter(true);
		tablaLibros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setLayout(groupLayout);
		

	}

	/**
	 * @return the textMensajes
	 */
	public JTextField getTextMensajes() {
		return textMensajes;
	}

	/**
	 * @return the textAutor
	 */
	public JTextField getTextAutor() {
		return textAutor;
	}

	/**
	 * @return the textEdicion
	 */
	public JTextField getTextEdicion() {
		return textEdicion;
	}

	/**
	 * @return the textISBN
	 */
	public JTextField getTextISBN() {
		return textISBN;
	}



	/**
	 * @return the textEditorial
	 */
	public JTextField getTextEditorial() {
		return textEditorial;
	}

	/**
	 * @return the textTitulo
	 */
	public JTextField getTextTitulo() {
		return textTitulo;
	}

	/**
	 * @return the tablaLibros
	 */
	public JTable getTablaLibros() {
		return tablaLibros;
	}

	/**
	 * @return the btnAadirNuevoLibro
	 */
	public JButton getBtnAadirNuevoLibro() {
		return btnAadirNuevoLibro;
	}

	/**
	 * @return the btnBorrarLibro
	 */
	public JButton getBtnBorrarLibro() {
		return btnBorrarLibro;
	}

	/**
	 * @return the btnModificarLibro
	 */
	public JButton getBtnModificarLibro() {
		return btnModificarLibro;
	}

	/**
	 * @return the btnAadirNuevoEjemplar
	 */
	public JButton getBtnAadirNuevoEjemplar() {
		return btnAadirNuevoEjemplar;
	}

	/**
	 * @return the btnGuardarLibro
	 */
	public JButton getBtnGuardarLibro() {
		return btnGuardarLibro;
	}

	/**
	 * @return the btnCancelarLibro
	 */
	public JButton getBtnCancelarLibro() {
		return btnCancelarLibro;
	}

	/**
	 * @return the btnMenu
	 */
	public JButton getBtnMenu() {
		return btnMenu;
	}
	
}

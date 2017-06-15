package vista;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Rectangle;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import controlador.ModeloTablaUsuarios;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class PanelParaUsuarios extends JPanel {
	private JTextField textDireccion;
	private JTextField textDNI;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textMensaje;
	private JTable tableUsuarios;
	private JButton btnAddNuevoUsuario;
	private JButton btnBorrarUsuario;
	private JButton btnModificarUsuario;

	/**
	 * Create the panel.
	 */
	public PanelParaUsuarios() {
		setBounds(new Rectangle(0, 0, 900, 450));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(new Rectangle(25, 25, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBounds(new Rectangle(25, 25, 0, 0));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Usuario seleccionado", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel lblDireccin = new JLabel("Dirección");
		
		textDireccion = new JTextField();
		textDireccion.setText("");
		textDireccion.setEditable(false);
		textDireccion.setColumns(10);
		textDireccion.setBackground(SystemColor.window);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		
		JLabel lblDni = new JLabel("D.N.I.");
		
		textDNI = new JTextField();
		textDNI.setText("");
		textDNI.setEditable(false);
		textDNI.setColumns(10);
		textDNI.setBackground(SystemColor.window);
		
		JLabel lblNombre = new JLabel("Nombre");
		
		textNombre = new JTextField();
		textNombre.setText("");
		textNombre.setEditable(false);
		textNombre.setColumns(10);
		textNombre.setBackground(SystemColor.window);
		
		textApellidos = new JTextField();
		textApellidos.setText("");
		textApellidos.setEditable(false);
		textApellidos.setColumns(10);
		textApellidos.setBackground(SystemColor.window);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblDireccin)
							.addGap(18)
							.addComponent(textDireccion, GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
							.addGap(212))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblApellidos)
								.addComponent(lblDni))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(textDNI, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(lblNombre)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 541, GroupLayout.PREFERRED_SIZE))
								.addComponent(textApellidos, GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE))))
					.addGap(17))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDni)
						.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombre))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellidos)
						.addComponent(textApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDireccin)
						.addComponent(textDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		btnAddNuevoUsuario = new JButton("Añadir nuevo Usuario");
		btnAddNuevoUsuario.setBounds(new Rectangle(25, 25, 0, 0));
		
		btnBorrarUsuario = new JButton("Borrar Usuario");
		btnBorrarUsuario.setBounds(new Rectangle(25, 25, 0, 0));
		
		btnModificarUsuario = new JButton("Modificar Usuario");
		btnModificarUsuario.setBounds(new Rectangle(25, 25, 0, 0));
		
		textMensaje = new JTextField();
		textMensaje.setForeground(Color.RED);
		textMensaje.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		textMensaje.setEditable(false);
		textMensaje.setColumns(10);
		textMensaje.setBounds(new Rectangle(25, 25, 0, 0));
		textMensaje.setBackground(SystemColor.window);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 850, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 850, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAddNuevoUsuario, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(btnBorrarUsuario, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addGap(37)
							.addComponent(btnModificarUsuario, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(textMensaje, GroupLayout.PREFERRED_SIZE, 844, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(11, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAddNuevoUsuario)
						.addComponent(btnBorrarUsuario)
						.addComponent(btnModificarUsuario))
					.addGap(12)
					.addComponent(textMensaje, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		tableUsuarios = new JTable(new ModeloTablaUsuarios());
		scrollPane.setViewportView(tableUsuarios);
		tableUsuarios.setAutoCreateRowSorter(true);
		tableUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		setLayout(groupLayout);

	}

	/**
	 * @return the textDireccion
	 */
	public JTextField getTextDireccion() {
		return textDireccion;
	}

	/**
	 * @return the textDNI
	 */
	public JTextField getTextDNI() {
		return textDNI;
	}

	/**
	 * @return the textNombre
	 */
	public JTextField getTextNombre() {
		return textNombre;
	}

	/**
	 * @return the textApellidos
	 */
	public JTextField getTextApellidos() {
		return textApellidos;
	}

	/**
	 * @return the textMensaje
	 */
	public JTextField getTextMensaje() {
		return textMensaje;
	}

	/**
	 * @return the tableUsuarios
	 */
	public JTable getTableUsuarios() {
		return tableUsuarios;
	}

	/**
	 * @return the btnAddNuevoUsuario
	 */
	public JButton getBtnAddNuevoUsuario() {
		return btnAddNuevoUsuario;
	}

	/**
	 * @return the btnBorrarUsuario
	 */
	public JButton getBtnBorrarUsuario() {
		return btnBorrarUsuario;
	}

	/**
	 * @return the btnModificarUsuario
	 */
	public JButton getBtnModificarUsuario() {
		return btnModificarUsuario;
	}
	
	
}

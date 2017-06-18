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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JButton btnMenu;
	private JButton btnGuardarUsuario;
	private JButton btnCancelarUsuario;

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
		
		btnGuardarUsuario = new JButton("Guardar Usuario");
		btnGuardarUsuario.setVisible(false);
		btnGuardarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnCancelarUsuario = new JButton("Cancelar Usuario");
		btnCancelarUsuario.setVisible(false);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblDireccin)
							.addGap(18)
							.addComponent(textDireccion, GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
							.addGap(212))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblApellidos)
								.addComponent(lblDni))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(textDNI, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNombre)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE))
								.addComponent(textApellidos, GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnGuardarUsuario)
								.addComponent(btnCancelarUsuario))
							.addGap(231)))
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
						.addComponent(lblNombre)
						.addComponent(btnGuardarUsuario))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellidos)
						.addComponent(textApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancelarUsuario))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDireccin)
						.addComponent(textDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(21, Short.MAX_VALUE))
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
		textMensaje.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		textMensaje.setEditable(false);
		textMensaje.setColumns(10);
		textMensaje.setBounds(new Rectangle(25, 25, 0, 0));
		textMensaje.setBackground(SystemColor.window);
		
		btnMenu = new JButton("Menú");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 850, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 850, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAddNuevoUsuario, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(btnBorrarUsuario, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addGap(37)
							.addComponent(btnModificarUsuario, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnMenu))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(textMensaje, GroupLayout.PREFERRED_SIZE, 844, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(11, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAddNuevoUsuario)
						.addComponent(btnBorrarUsuario)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnModificarUsuario)
							.addComponent(btnMenu)))
					.addGap(12)
					.addComponent(textMensaje, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		tableUsuarios = new JTable(new ModeloTablaUsuarios());
		tableUsuarios.setAutoCreateRowSorter(true);
		tableUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tableUsuarios);
		
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

	/**
	 * @return the btnMenu
	 */
	public JButton getBtnMenu() {
		return btnMenu;
	}

	/**
	 * @return the btnGuardarUsuario
	 */
	public JButton getBtnGuardarUsuario() {
		return btnGuardarUsuario;
	}

	/**
	 * @return the btnCancelarUsuario
	 */
	public JButton getBtnCancelarUsuario() {
		return btnCancelarUsuario;
	}
	
	
}

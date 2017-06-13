package vista;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Rectangle;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTable;

public class PanelParaUsuarios extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;

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
		
		textField = new JTextField();
		textField.setText("");
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(SystemColor.window);
		
		textField_1 = new JTextField();
		textField_1.setText("");
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(SystemColor.window);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		
		JLabel lblDni = new JLabel("D.N.I.");
		
		textField_2 = new JTextField();
		textField_2.setText("");
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBackground(SystemColor.window);
		
		JLabel lblNombre = new JLabel("Nombre");
		
		textField_4 = new JTextField();
		textField_4.setText("");
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBackground(SystemColor.window);
		
		textField_5 = new JTextField();
		textField_5.setText("");
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBackground(SystemColor.window);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 838, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblDireccin)
							.addGap(18)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
							.addGap(82)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblApellidos)
								.addComponent(lblDni))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(lblNombre)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 541, GroupLayout.PREFERRED_SIZE))
								.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE))))
					.addGap(17))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 132, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDni)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombre))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellidos)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDireccin)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JButton btnAddNuevoUsuario = new JButton("Añadir nuevo Usuario");
		btnAddNuevoUsuario.setBounds(new Rectangle(25, 25, 0, 0));
		
		JButton btnBorrarUsuario = new JButton("Borrar Usuario");
		btnBorrarUsuario.setBounds(new Rectangle(25, 25, 0, 0));
		
		JButton btnBuscarUsuario = new JButton("Buscar Usuario");
		btnBuscarUsuario.setBounds(new Rectangle(25, 25, 0, 0));
		
		textField_6 = new JTextField();
		textField_6.setForeground(Color.RED);
		textField_6.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(new Rectangle(25, 25, 0, 0));
		textField_6.setBackground(SystemColor.window);
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
							.addComponent(btnBuscarUsuario, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 844, GroupLayout.PREFERRED_SIZE)))
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
						.addComponent(btnBuscarUsuario))
					.addGap(12)
					.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		setLayout(groupLayout);

	}
}

package vista;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import controlador.ModeloTablaEjemplares;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;

public class PanelParaEjemplares extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField_Mensajes;
	private JTextField textField_Autor_Ejemplar;
	private JTextField textField_Edicion_Ejemplar;
	private JTextField textField_ISBN_Ejemplar;
	private JTextField textField_NUmero_Ejemplar;
	private JTextField textField_Editorial_Ejemplar;
	private JTextField textField_Titulo_Ejemplar;
	private JButton buttonBuscarEjemplar;
	private JButton buttonBorrarEjemplar;
	private JButton buttonAddEjemplar;
	private JTable tabla_Ejemplares;

	/**
	 * Create the panel.
	 */
	public  PanelParaEjemplares() {
		setVisible(true);
		setBounds(new Rectangle(0, 0, 900, 450));
		
		buttonAddEjemplar = new JButton("Añadir nuevo ejemplar");
		buttonAddEjemplar.setBounds(new Rectangle(25, 25, 0, 0));
		
		buttonBorrarEjemplar = new JButton("Borrar Ejemplar");
		buttonBorrarEjemplar.setBounds(new Rectangle(25, 25, 0, 0));
		
		buttonBuscarEjemplar = new JButton("Buscar Ejemplar");
		buttonBuscarEjemplar.setBounds(new Rectangle(25, 25, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(new Rectangle(25, 25, 0, 0));
		
		textField_Mensajes = new JTextField();
		textField_Mensajes.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		textField_Mensajes.setBounds(new Rectangle(25, 25, 0, 0));
		textField_Mensajes.setForeground(Color.RED);
		textField_Mensajes.setEditable(false);
		textField_Mensajes.setColumns(10);
		textField_Mensajes.setBackground(SystemColor.window);
		
		JPanel panel = new JPanel();
		panel.setBounds(new Rectangle(25, 25, 0, 0));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Ejemplar seleccionado", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel label = new JLabel("Autor");
		
		textField_Autor_Ejemplar = new JTextField();
		textField_Autor_Ejemplar.setText("");
		textField_Autor_Ejemplar.setEditable(false);
		textField_Autor_Ejemplar.setColumns(10);
		textField_Autor_Ejemplar.setBackground(SystemColor.window);
		
		JLabel label_1 = new JLabel("Edición");
		
		textField_Edicion_Ejemplar = new JTextField();
		textField_Edicion_Ejemplar.setText("");
		textField_Edicion_Ejemplar.setEditable(false);
		textField_Edicion_Ejemplar.setColumns(10);
		textField_Edicion_Ejemplar.setBackground(SystemColor.window);
		
		JLabel label_2 = new JLabel("Título");
		
		JLabel label_3 = new JLabel("ISBN");
		
		textField_ISBN_Ejemplar = new JTextField();
		textField_ISBN_Ejemplar.setText("");
		textField_ISBN_Ejemplar.setEditable(false);
		textField_ISBN_Ejemplar.setColumns(10);
		textField_ISBN_Ejemplar.setBackground(SystemColor.window);
		
		JLabel label_4 = new JLabel("Ejemplar");
		
		textField_NUmero_Ejemplar = new JTextField();
		textField_NUmero_Ejemplar.setText("");
		textField_NUmero_Ejemplar.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_NUmero_Ejemplar.setForeground(new Color(128, 0, 0));
		textField_NUmero_Ejemplar.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		textField_NUmero_Ejemplar.setEditable(false);
		textField_NUmero_Ejemplar.setColumns(10);
		textField_NUmero_Ejemplar.setBackground(SystemColor.window);
		
		JLabel label_5 = new JLabel("Editorial");
		
		textField_Editorial_Ejemplar = new JTextField();
		textField_Editorial_Ejemplar.setText("");
		textField_Editorial_Ejemplar.setEditable(false);
		textField_Editorial_Ejemplar.setColumns(10);
		textField_Editorial_Ejemplar.setBackground(SystemColor.window);
		
		textField_Titulo_Ejemplar = new JTextField();
		textField_Titulo_Ejemplar.setText("");
		textField_Titulo_Ejemplar.setEditable(false);
		textField_Titulo_Ejemplar.setColumns(10);
		textField_Titulo_Ejemplar.setBackground(SystemColor.window);
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
							.addComponent(textField_Autor_Ejemplar, GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(label_1)
							.addGap(18)
							.addComponent(textField_Edicion_Ejemplar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2)
								.addComponent(label_3))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(textField_ISBN_Ejemplar, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(label_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_NUmero_Ejemplar, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addGap(51)
									.addComponent(label_5)
									.addGap(18)
									.addComponent(textField_Editorial_Ejemplar, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE))
								.addComponent(textField_Titulo_Ejemplar, GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE))))
					.addGap(17))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 156, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(textField_Editorial_Ejemplar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_ISBN_Ejemplar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5)
						.addComponent(label_4)
						.addComponent(textField_NUmero_Ejemplar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(textField_Titulo_Ejemplar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField_Autor_Ejemplar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(textField_Edicion_Ejemplar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(27, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 850, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 850, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(buttonAddEjemplar, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(buttonBorrarEjemplar, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addGap(37)
							.addComponent(buttonBuscarEjemplar, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(textField_Mensajes, GroupLayout.PREFERRED_SIZE, 844, GroupLayout.PREFERRED_SIZE)))
					.addGap(23))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(14)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonAddEjemplar)
						.addComponent(buttonBorrarEjemplar)
						.addComponent(buttonBuscarEjemplar))
					.addGap(12)
					.addComponent(textField_Mensajes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(32, Short.MAX_VALUE))
		);
		
		tabla_Ejemplares = new JTable(new ModeloTablaEjemplares());
		scrollPane.setViewportView(tabla_Ejemplares);
		setLayout(groupLayout);
		tabla_Ejemplares.setModel(new controlador.ModeloTablaEjemplares());
		tabla_Ejemplares.getColumnModel().getColumn(0).setPreferredWidth(24);
		tabla_Ejemplares.getColumnModel().getColumn(1).setPreferredWidth(4);
		tabla_Ejemplares.getColumnModel().getColumn(2).setPreferredWidth(125);
		tabla_Ejemplares.getColumnModel().getColumn(3).setPreferredWidth(40);
		tabla_Ejemplares.getColumnModel().getColumn(4).setPreferredWidth(200);
		tabla_Ejemplares.getColumnModel().getColumn(5).setPreferredWidth(4);
		
		
	}

	/**
	 * @return the textField_Mensajes
	 */
	public JTextField getTextField_Mensajes() {
		return textField_Mensajes;
	}

	/**
	 * @param textField_Mensajes the textField_Mensajes to set
	 */
	public void setTextField_Mensajes(JTextField textField_Mensajes) {
		this.textField_Mensajes = textField_Mensajes;
	}

	/**
	 * @return the textField_Autor_Ejemplar
	 */
	public JTextField getTextField_Autor_Ejemplar() {
		return textField_Autor_Ejemplar;
	}

	/**
	 * @param textField_Autor_Ejemplar the textField_Autor_Ejemplar to set
	 */
	public void setTextField_Autor_Ejemplar(JTextField textField_Autor_Ejemplar) {
		this.textField_Autor_Ejemplar = textField_Autor_Ejemplar;
	}

	/**
	 * @return the textField_Edicion_Ejemplar
	 */
	public JTextField getTextField_Edicion_Ejemplar() {
		return textField_Edicion_Ejemplar;
	}

	/**
	 * @param textField_Edicion_Ejemplar the textField_Edicion_Ejemplar to set
	 */
	public void setTextField_Edicion_Ejemplar(JTextField textField_Edicion_Ejemplar) {
		this.textField_Edicion_Ejemplar = textField_Edicion_Ejemplar;
	}

	/**
	 * @return the textField_ISBN_Ejemplar
	 */
	public JTextField getTextField_ISBN_Ejemplar() {
		return textField_ISBN_Ejemplar;
	}

	/**
	 * @param textField_ISBN_Ejemplar the textField_ISBN_Ejemplar to set
	 */
	public void setTextField_ISBN_Ejemplar(JTextField textField_ISBN_Ejemplar) {
		this.textField_ISBN_Ejemplar = textField_ISBN_Ejemplar;
	}

	/**
	 * @return the textField_NUmero_Ejemplar
	 */
	public JTextField getTextField_NUmero_Ejemplar() {
		return textField_NUmero_Ejemplar;
	}

	/**
	 * @param textField_NUmero_Ejemplar the textField_NUmero_Ejemplar to set
	 */
	public void setTextField_NUmero_Ejemplar(JTextField textField_NUmero_Ejemplar) {
		this.textField_NUmero_Ejemplar = textField_NUmero_Ejemplar;
	}

	/**
	 * @return the textField_Editorial_Ejemplar
	 */
	public JTextField getTextField_Editorial_Ejemplar() {
		return textField_Editorial_Ejemplar;
	}

	/**
	 * @param textField_Editorial_Ejemplar the textField_Editorial_Ejemplar to set
	 */
	public void setTextField_Editorial_Ejemplar(JTextField textField_Editorial_Ejemplar) {
		this.textField_Editorial_Ejemplar = textField_Editorial_Ejemplar;
	}

	/**
	 * @return the textField_Titulo_Ejemplar
	 */
	public JTextField getTextField_Titulo_Ejemplar() {
		return textField_Titulo_Ejemplar;
	}

	/**
	 * @param textField_Titulo_Ejemplar the textField_Titulo_Ejemplar to set
	 */
	public void setTextField_Titulo_Ejemplar(JTextField textField_Titulo_Ejemplar) {
		this.textField_Titulo_Ejemplar = textField_Titulo_Ejemplar;
	}

	/**
	 * @return the buttonNuevoEjemplar
	 */
	public JButton getButtonBuscarEjemplar() {
		return buttonBuscarEjemplar;
	}

	/**
	 * @param buttonNuevoEjemplar the buttonNuevoEjemplar to set
	 */
	public void setButtonBuscarEjemplar(JButton buttonBuscarEjemplar) {
		this.buttonBuscarEjemplar = buttonBuscarEjemplar;
	}

	/**
	 * @return the buttonBorrarEjemplar
	 */
	public JButton getButtonBorrarEjemplar() {
		return buttonBorrarEjemplar;
	}

	/**
	 * @param buttonBorrarEjemplar the buttonBorrarEjemplar to set
	 */
	public void setButtonBorrarEjemplar(JButton buttonBorrarEjemplar) {
		this.buttonBorrarEjemplar = buttonBorrarEjemplar;
	}

	/**
	 * @return the buttonAddEjemplar
	 */
	public JButton getButtonAddEjemplar() {
		return buttonAddEjemplar;
	}

	/**
	 * @param buttonAddEjemplar the buttonAddEjemplar to set
	 */
	public void setButtonAddEjemplar(JButton buttonAddEjemplar) {
		this.buttonAddEjemplar = buttonAddEjemplar;
	}

	/**
	 * @return the tabla_Ejemplares
	 */
	public JTable getTabla_Ejemplares() {
		return tabla_Ejemplares;
	}

	/**
	 * @param tabla_Ejemplares the tabla_Ejemplares to set
	 */
	public void setTabla_Ejemplares(JTable tabla_Ejemplares) {
		this.tabla_Ejemplares = tabla_Ejemplares;
	}
	
	
	
}

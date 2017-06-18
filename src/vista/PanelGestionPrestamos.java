package vista;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import controlador.ModeloTablaPrestados;
import controlador.ModeloTableDevueltos;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class PanelGestionPrestamos extends JPanel {
	private JTable tablePrestados;
	private JTable tableDevueltos;
	private JTextField textFieldMensaje;
	private JButton btnMenu;
	private JButton btnDevolverEjemplar;
	private JButton btnConfirmar;
	private JButton btnCancelar;

	/**
	 * Create the panel.
	 */
	public PanelGestionPrestamos() {
		setBounds(new Rectangle(0, 0, 900, 450));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Ejemplares Prestados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Ejemplares devueltos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		textFieldMensaje = new JTextField();
		textFieldMensaje.setForeground(new Color(0, 0, 0));
		textFieldMensaje.setEditable(false);
		textFieldMensaje.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		textFieldMensaje.setBackground(SystemColor.window);
		textFieldMensaje.setColumns(10);
		
		btnDevolverEjemplar = new JButton("Devolver Préstamo");
		btnDevolverEjemplar.setEnabled(false);
		
		btnMenu = new JButton("Menú");
		
		btnConfirmar = new JButton("Confirmar Devolución");
		btnConfirmar.setVisible(false);
		
		btnCancelar = new JButton("Cancelar Devolución");
		btnCancelar.setVisible(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldMensaje, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 888, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 886, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnDevolverEjemplar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnConfirmar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancelar)
							.addPreferredGap(ComponentPlacement.RELATED, 338, Short.MAX_VALUE)
							.addComponent(btnMenu)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(14)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDevolverEjemplar)
						.addComponent(btnMenu)
						.addComponent(btnConfirmar)
						.addComponent(btnCancelar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldMensaje, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 868, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tableDevueltos = new JTable(new ModeloTableDevueltos());
		tableDevueltos.setAutoCreateRowSorter(true);
		//tableDevueltos.setRowSelectionAllowed(false);
		//tableDevueltos.setCellSelectionEnabled(false);
		tableDevueltos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(tableDevueltos);
		panel_1.setLayout(gl_panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 870, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		tablePrestados = new JTable(new ModeloTablaPrestados());
		tablePrestados.setAutoCreateRowSorter(true);
		tablePrestados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tablePrestados);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

	}

	/**
	 * @return the tablePrestados
	 */
	public JTable getTablePrestados() {
		return tablePrestados;
	}

	/**
	 * @return the tableDevueltos
	 */
	public JTable getTableDevueltos() {
		return tableDevueltos;
	}

	/**
	 * @return the textFieldMensaje
	 */
	public JTextField getTextFieldMensaje() {
		return textFieldMensaje;
	}

	/**
	 * @return the btnMenu
	 */
	public JButton getBtnMenu() {
		return btnMenu;
	}

	/**
	 * @return the btnDevolverEjemplar
	 */
	public JButton getBtnDevolverEjemplar() {
		return btnDevolverEjemplar;
	}

	/**
	 * @return the btnConfirmar
	 */
	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	/**
	 * @return the btnCancelar
	 */
	public JButton getBtnCancelar() {
		return btnCancelar;
	}


	
}

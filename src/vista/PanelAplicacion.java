package vista;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class PanelAplicacion extends JPanel {
	private JButton btnGestionUsuarios;
	private JButton btnGestionLibros;
	private JButton btnGestionEjemplares;
	private JButton btnGestionPrestamos;
	private JButton btnPrestarEjemplares;

	/**
	 * Create the panel.
	 */
	public PanelAplicacion() {
		setBounds(new Rectangle(0, 0, 900, 450));
		
		btnGestionUsuarios = new JButton("Gestión Usuarios");
		btnGestionUsuarios.setForeground(new Color(128, 0, 0));
		btnGestionUsuarios.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		
		btnGestionLibros = new JButton("Gestión Libros");
		btnGestionLibros.setForeground(new Color(128, 0, 0));
		btnGestionLibros.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		
		btnGestionEjemplares = new JButton("Gestión Ejemplares");
		btnGestionEjemplares.setForeground(new Color(128, 0, 0));
		btnGestionEjemplares.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		
		btnGestionPrestamos = new JButton("Gestión Préstamos");
		btnGestionPrestamos.setForeground(new Color(128, 0, 0));
		btnGestionPrestamos.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		
		btnPrestarEjemplares = new JButton("Prestar Ejemplares");
		btnPrestarEjemplares.setForeground(new Color(128, 0, 0));
		btnPrestarEjemplares.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		
		JLabel lblBiblioteca = DefaultComponentFactory.getInstance().createTitle("Proyecto programacion Java - Biblioteca");
		lblBiblioteca.setForeground(new Color(184, 134, 11));
		lblBiblioteca.setFont(new Font("Lucida Grande", Font.BOLD, 40));
		
		JLabel lblIesVisrgenDel = DefaultComponentFactory.getInstance().createTitle("IES Virgen del Carmen - 1º DAM - Ángel Millán Miralles");
		lblIesVisrgenDel.setForeground(new Color(169, 169, 169));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addComponent(lblBiblioteca))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(128)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnGestionUsuarios)
								.addComponent(btnGestionPrestamos))
							.addGap(100)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnGestionEjemplares)
								.addComponent(btnGestionLibros)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(257)
							.addComponent(lblIesVisrgenDel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(316)
							.addComponent(btnPrestarEjemplares)))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addComponent(lblBiblioteca)
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGestionUsuarios)
						.addComponent(btnGestionLibros))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGestionEjemplares)
						.addComponent(btnGestionPrestamos))
					.addPreferredGap(ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
					.addComponent(btnPrestarEjemplares)
					.addGap(40)
					.addComponent(lblIesVisrgenDel)
					.addGap(33))
		);
		setLayout(groupLayout);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnPrestarEjemplares, btnGestionUsuarios, btnGestionPrestamos, btnGestionLibros, btnGestionEjemplares, lblBiblioteca, lblIesVisrgenDel}));

	}

	/**
	 * @return the btnGestionUsuarios
	 */
	public JButton getBtnGestionUsuarios() {
		return btnGestionUsuarios;
	}

	/**
	 * @return the btnGestionLibros
	 */
	public JButton getBtnGestionLibros() {
		return btnGestionLibros;
	}

	/**
	 * @return the btnGestionEjemplares
	 */
	public JButton getBtnGestionEjemplares() {
		return btnGestionEjemplares;
	}

	/**
	 * @return the btnGestionPrestamos
	 */
	public JButton getBtnGestionPrestamos() {
		return btnGestionPrestamos;
	}

	/**
	 * @return the btnPrestarEjemplares
	 */
	public JButton getBtnPrestarEjemplares() {
		return btnPrestarEjemplares;
	}

	
	
}

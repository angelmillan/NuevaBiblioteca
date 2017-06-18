package vista;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

@SuppressWarnings("serial")
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
		btnGestionUsuarios.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnGestionUsuarios.setBackground(SystemColor.window);
		btnGestionUsuarios.setMinimumSize(new Dimension(260, 60));
		btnGestionUsuarios.setPreferredSize(new Dimension(260, 60));
		btnGestionUsuarios.setForeground(new Color(204, 204, 102));
		btnGestionUsuarios.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		btnGestionLibros = new JButton("Gestión Libros");
		btnGestionLibros.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnGestionLibros.setBackground(new Color(255, 255, 204));
		btnGestionLibros.setPreferredSize(new Dimension(260, 60));
		btnGestionLibros.setMinimumSize(new Dimension(260, 60));
		btnGestionLibros.setForeground(new Color(204, 204, 102));
		btnGestionLibros.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		btnGestionEjemplares = new JButton("Gestión Ejemplares");
		btnGestionEjemplares.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnGestionEjemplares.setBackground(SystemColor.window);
		btnGestionEjemplares.setPreferredSize(new Dimension(260, 60));
		btnGestionEjemplares.setMinimumSize(new Dimension(260, 60));
		btnGestionEjemplares.setForeground(new Color(204, 204, 102));
		btnGestionEjemplares.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		btnGestionPrestamos = new JButton("Gestión Préstamos");
		btnGestionPrestamos.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnGestionPrestamos.setBackground(SystemColor.window);
		btnGestionPrestamos.setPreferredSize(new Dimension(260, 60));
		btnGestionPrestamos.setMinimumSize(new Dimension(260, 60));
		btnGestionPrestamos.setForeground(new Color(204, 204, 102));
		btnGestionPrestamos.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		btnPrestarEjemplares = new JButton("Prestar Ejemplares");
		btnPrestarEjemplares.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnPrestarEjemplares.setBackground(SystemColor.window);
		btnPrestarEjemplares.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPrestarEjemplares.setPreferredSize(new Dimension(260, 60));
		btnPrestarEjemplares.setMinimumSize(new Dimension(260, 60));
		btnPrestarEjemplares.setForeground(new Color(204, 204, 102));
		btnPrestarEjemplares.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		JLabel lblBiblioteca = DefaultComponentFactory.getInstance().createTitle("Proyecto programacion Java - Biblioteca");
		lblBiblioteca.setForeground(new Color(204, 204, 102));
		lblBiblioteca.setFont(new Font("Lucida Grande", Font.BOLD, 36));
		
		JLabel lblIesVisrgenDel = DefaultComponentFactory.getInstance().createTitle("IES Virgen del Carmen - 1º DAM - Ángel Millán Miralles");
		lblIesVisrgenDel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblIesVisrgenDel.setForeground(new Color(169, 169, 169));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(57)
							.addComponent(lblBiblioteca))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(171)
							.addComponent(lblIesVisrgenDel)))
					.addGap(494))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnGestionEjemplares, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnGestionUsuarios, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnGestionLibros, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnGestionPrestamos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPrestarEjemplares, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(448, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addComponent(lblBiblioteca)
					.addGap(62)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnGestionPrestamos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnGestionUsuarios, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnGestionLibros, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnGestionEjemplares, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnPrestarEjemplares, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
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

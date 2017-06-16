package vista;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JButton;

public class PanelParaPrestar extends JPanel {
	private JTextField textApellidosUsuarios;
	private JTextField textNombreUsuario;
	private JTextField TextDniUsuario;
	private JTextField textAutorLibro;
	private JTextField textTituloLibro;
	private JTextField textIsbnLibro;
	private JTextField textNumeroEjemplar;
	private JTextField textTituloEjemplar;
	private JTextField textIsbnEjemplar;
	private JTable tableUsuarioPrestar;
	private JTable tableLibrosPrestar;
	private JTable tableEjemplaresPrestar;
	private JTextField textMensaje;
	private JButton btnPrestar;
	private JButton btnMenu;

	/**
	 * Create the panel.
	 */
	public PanelParaPrestar() {
		setBounds(new Rectangle(0, 0, 900, 450));
		
		JPanel panelUsers = new JPanel();
		panelUsers.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Usuarios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Usuarios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panelLibros = new JPanel();
		panelLibros.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Libros disponibles", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JPanel panelEjemplares = new JPanel();
		panelEjemplares.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Ejemplares disponibles", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		textMensaje = new JTextField();
		textMensaje.setEditable(false);
		textMensaje.setBackground(SystemColor.window);
		textMensaje.setColumns(10);
		
		btnPrestar = new JButton("Prestar");
		
		btnMenu = new JButton("Menú");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textMensaje, GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelUsers, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panelLibros, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panelEjemplares, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnPrestar)
							.addPreferredGap(ComponentPlacement.RELATED, 684, Short.MAX_VALUE)
							.addComponent(btnMenu)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelUsers, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelLibros, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelEjemplares, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPrestar)
						.addComponent(btnMenu))
					.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
					.addComponent(textMensaje, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel lblNmeroDeEjemplar = new JLabel("Número de ejemplar");
		
		textNumeroEjemplar = new JTextField();
		textNumeroEjemplar.setEditable(false);
		textNumeroEjemplar.setBackground(SystemColor.window);
		textNumeroEjemplar.setColumns(10);
		
		JLabel lblTitulo = new JLabel("Titulo");
		
		textTituloEjemplar = new JTextField();
		textTituloEjemplar.setEditable(false);
		textTituloEjemplar.setBackground(SystemColor.window);
		textTituloEjemplar.setColumns(10);
		
		JLabel lblIsbn_1 = new JLabel("ISBN");
		
		textIsbnEjemplar = new JTextField();
		textIsbnEjemplar.setEditable(false);
		textIsbnEjemplar.setBackground(SystemColor.window);
		textIsbnEjemplar.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GroupLayout gl_panelEjemplares = new GroupLayout(panelEjemplares);
		gl_panelEjemplares.setHorizontalGroup(
			gl_panelEjemplares.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEjemplares.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelEjemplares.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelEjemplares.createSequentialGroup()
							.addComponent(lblNmeroDeEjemplar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textNumeroEjemplar, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
						.addGroup(gl_panelEjemplares.createSequentialGroup()
							.addComponent(lblTitulo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textTituloEjemplar, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
						.addGroup(gl_panelEjemplares.createSequentialGroup()
							.addComponent(lblIsbn_1)
							.addGap(18)
							.addComponent(textIsbnEjemplar, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
						.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panelEjemplares.setVerticalGroup(
			gl_panelEjemplares.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelEjemplares.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
					.addGroup(gl_panelEjemplares.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIsbn_1)
						.addComponent(textIsbnEjemplar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelEjemplares.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTitulo)
						.addComponent(textTituloEjemplar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelEjemplares.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNmeroDeEjemplar)
						.addComponent(textNumeroEjemplar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		tableEjemplaresPrestar = new JTable();
		scrollPane_2.setViewportView(tableEjemplaresPrestar);
		panelEjemplares.setLayout(gl_panelEjemplares);
		
		JLabel lblAutor = new JLabel("Autor");
		
		textAutorLibro = new JTextField();
		textAutorLibro.setEditable(false);
		textAutorLibro.setBackground(SystemColor.window);
		textAutorLibro.setColumns(10);
		
		JLabel lblTtulo = new JLabel("Título");
		
		textTituloLibro = new JTextField();
		textTituloLibro.setEditable(false);
		textTituloLibro.setBackground(SystemColor.window);
		textTituloLibro.setColumns(10);
		
		JLabel lblIsbn = new JLabel("ISBN");
		
		textIsbnLibro = new JTextField();
		textIsbnLibro.setEditable(false);
		textIsbnLibro.setBackground(SystemColor.window);
		textIsbnLibro.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panelLibros = new GroupLayout(panelLibros);
		gl_panelLibros.setHorizontalGroup(
			gl_panelLibros.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLibros.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelLibros.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelLibros.createSequentialGroup()
							.addComponent(lblAutor)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textAutorLibro, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
						.addGroup(gl_panelLibros.createSequentialGroup()
							.addGroup(gl_panelLibros.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTtulo)
								.addComponent(lblIsbn))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelLibros.createParallelGroup(Alignment.LEADING)
								.addComponent(textIsbnLibro, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
								.addComponent(textTituloLibro, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)))
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panelLibros.setVerticalGroup(
			gl_panelLibros.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelLibros.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addGroup(gl_panelLibros.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIsbn)
						.addComponent(textIsbnLibro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelLibros.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTtulo)
						.addComponent(textTituloLibro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelLibros.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAutor)
						.addComponent(textAutorLibro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		tableLibrosPrestar = new JTable();
		scrollPane_1.setViewportView(tableLibrosPrestar);
		panelLibros.setLayout(gl_panelLibros);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		
		textApellidosUsuarios = new JTextField();
		textApellidosUsuarios.setBackground(SystemColor.window);
		textApellidosUsuarios.setEditable(false);
		textApellidosUsuarios.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		
		textNombreUsuario = new JTextField();
		textNombreUsuario.setBackground(SystemColor.window);
		textNombreUsuario.setEditable(false);
		textNombreUsuario.setColumns(10);
		
		JLabel lblDni = new JLabel("D.N.I.");
		
		TextDniUsuario = new JTextField();
		TextDniUsuario.setBackground(SystemColor.window);
		TextDniUsuario.setEditable(false);
		TextDniUsuario.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panelUsers = new GroupLayout(panelUsers);
		gl_panelUsers.setHorizontalGroup(
			gl_panelUsers.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelUsers.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelUsers.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelUsers.createSequentialGroup()
							.addGroup(gl_panelUsers.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombre)
								.addComponent(lblDni)
								.addComponent(lblApellidos))
							.addGap(18)
							.addGroup(gl_panelUsers.createParallelGroup(Alignment.LEADING)
								.addComponent(textApellidosUsuarios, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
								.addComponent(TextDniUsuario, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
								.addComponent(textNombreUsuario, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panelUsers.setVerticalGroup(
			gl_panelUsers.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelUsers.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
					.addGroup(gl_panelUsers.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDni)
						.addComponent(TextDniUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelUsers.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textNombreUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelUsers.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellidos)
						.addComponent(textApellidosUsuarios, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		tableUsuarioPrestar = new JTable();
		scrollPane.setViewportView(tableUsuarioPrestar);
		panelUsers.setLayout(gl_panelUsers);
		setLayout(groupLayout);

	}

	/**
	 * @return the textApellidosUsuarios
	 */
	public JTextField getTextApellidosUsuarios() {
		return textApellidosUsuarios;
	}

	/**
	 * @return the textNombreUsuario
	 */
	public JTextField getTextNombreUsuario() {
		return textNombreUsuario;
	}

	/**
	 * @return the textDniUsuario
	 */
	public JTextField getTextDniUsuario() {
		return TextDniUsuario;
	}

	/**
	 * @return the textAutorLibro
	 */
	public JTextField getTextAutorLibro() {
		return textAutorLibro;
	}

	/**
	 * @return the textTituloLibro
	 */
	public JTextField getTextTituloLibro() {
		return textTituloLibro;
	}

	/**
	 * @return the textIsbnLibro
	 */
	public JTextField getTextIsbnLibro() {
		return textIsbnLibro;
	}

	/**
	 * @return the textNumeroEjemplar
	 */
	public JTextField getTextNumeroEjemplar() {
		return textNumeroEjemplar;
	}

	/**
	 * @return the textTituloEjemplar
	 */
	public JTextField getTextTituloEjemplar() {
		return textTituloEjemplar;
	}

	/**
	 * @return the textIsbnEjemplar
	 */
	public JTextField getTextIsbnEjemplar() {
		return textIsbnEjemplar;
	}

	/**
	 * @return the tableUsuarioPrestar
	 */
	public JTable getTableUsuarioPrestar() {
		return tableUsuarioPrestar;
	}

	/**
	 * @return the tableLibrosPrestar
	 */
	public JTable getTableLibrosPrestar() {
		return tableLibrosPrestar;
	}

	/**
	 * @return the tableEjemplaresPrestar
	 */
	public JTable getTableEjemplaresPrestar() {
		return tableEjemplaresPrestar;
	}

	/**
	 * @return the textMensaje
	 */
	public JTextField getTextMensaje() {
		return textMensaje;
	}

	/**
	 * @return the btnPrestar
	 */
	public JButton getBtnPrestar() {
		return btnPrestar;
	}

	/**
	 * @return the btnMenu
	 */
	public JButton getBtnMenu() {
		return btnMenu;
	}
		
}

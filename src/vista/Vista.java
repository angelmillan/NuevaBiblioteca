package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import controlador.Controlador;
import controlador.ModeloTablaEjemplares;
import modelo.EjemplarDAO;

import javax.swing.border.EtchedBorder;
import java.awt.Rectangle;


@SuppressWarnings("serial")
public class Vista extends JFrame {

	private JPanel panelUsuarios;
	private JPanel panelLibros;
	private JPanel panelEjemplares;
	private JPanel panelPrestamos;
	private JPanel contentPane;
	private JMenuItem mntmAcercaDeBiblioteca;
	private JMenuItem mntmSalir;
	private JMenu mnAplicacion;
	private JMenu mnUsuarios;
	private JMenuItem mntmCrearusuario;
	private JMenuItem mntmBuscarUsuario;
	private JMenuItem mntmActualizarUsuario;
	private JMenuItem mntmBorrarUsuario;
	private JMenu mnLibros;
	private JMenuItem mntmcCrearLibro;
	private JMenuItem mntmrBuscarLibro;
	private JMenuItem mntmuActualizarLibro;
	private JMenuItem mntmdBorrarLibro;
	private JMenu mnEjemplares;
	private JMenuItem mntmcCrearEjemplar;
	private JMenuItem mntmrBuscarEjemplar;
	private JMenuItem mntmuEjemplar;
	private JMenuItem mntmdBorrarEjemplar;
	private JMenu mnPrestamos;
	private JMenuItem mntmcNuevoPrestamo;
	private JMenuItem mntmrBuscarPrestamo;
	private JMenuItem mntmuModificarPrestamo;
	private JMenuItem mntmdDevolverPrstamo;
	private JPanel panelInternoEjemplares;
	private JScrollPane scrollPane;
	private JTextField txtEditorial;
	/**
	 * @return the mntmSalir
	 */
	public JMenuItem getMntmSalir() {
		return mntmSalir;
	}

	/**
	 * @param mntmSalir the mntmSalir to set
	 */
	public void setMntmSalir(JMenuItem mntmSalir) {
		this.mntmSalir = mntmSalir;
	}

	private JTextField txtEdicion;
	private JTextField txtAutor;
	private JTextField txtIsbnejemplar;
	private JTextField txtTitulo;
	private JTextField txtNumeroejemplar;
	private JMenuBar menuBar;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					frame.setVisible(true);
					new Controlador (frame, new EjemplarDAO());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * 
	 * 
	 */
	
	public void crearPaneles() {
		panelUsuarios = new JPanel();
		panelUsuarios.setVisible(false);
		//contentPane.add(panelUsuarios, BorderLayout.CENTER);
		panelUsuarios.setLayout(new BorderLayout(0, 0));
		
		panelLibros = new JPanel();
		panelLibros.setVisible(false);
		//contentPane.add(panelLibros);
		panelLibros.setLayout(new BorderLayout(0, 0));
		
		panelEjemplares = new JPanel();
		panelEjemplares.setVisible(true);
		contentPane.add(panelEjemplares);	
		
		panelPrestamos = new JPanel();
		//contentPane.add(panelPrestamos, BorderLayout.CENTER);
		panelPrestamos.setLayout(new BorderLayout(0, 0));
		
		
		
	}
	public Vista() {
		setBounds(new Rectangle(0, 0, 700, 500));
		setResizable(false);
		setMaximumSize(new Dimension(0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnAplicacion = new JMenu("Aplicacion");
		menuBar.add(mnAplicacion);
		
		mntmAcercaDeBiblioteca = new JMenuItem("Acerca de Biblioteca");
		mnAplicacion.add(mntmAcercaDeBiblioteca);
		
		mntmSalir = new JMenuItem("Salir");
		mnAplicacion.add(mntmSalir);
		
		mnUsuarios = new JMenu("Usuarios");
		menuBar.add(mnUsuarios);
		
		mntmCrearusuario = new JMenuItem("(C) Crear Usuario");
		mnUsuarios.add(mntmCrearusuario);
		
		mntmBuscarUsuario = new JMenuItem("(R) Buscar Usuario");
		mnUsuarios.add(mntmBuscarUsuario);
		
		mntmActualizarUsuario = new JMenuItem("(U) Actualizar Usuario");
		mnUsuarios.add(mntmActualizarUsuario);
		
		mntmBorrarUsuario = new JMenuItem("(D) Borrar Usuario");
		mnUsuarios.add(mntmBorrarUsuario);
		
		mnLibros = new JMenu("Libros");
		menuBar.add(mnLibros);
		
		mntmcCrearLibro = new JMenuItem("(C) Crear Libro");
		mnLibros.add(mntmcCrearLibro);
		
		mntmrBuscarLibro = new JMenuItem("(R) Buscar Libro");
		mnLibros.add(mntmrBuscarLibro);
		
		mntmuActualizarLibro = new JMenuItem("(U) Actualizar Libro");
		mnLibros.add(mntmuActualizarLibro);
		
		mntmdBorrarLibro = new JMenuItem("(D) Borrar Libro");
		mnLibros.add(mntmdBorrarLibro);
		
		mnEjemplares = new JMenu("Ejemplares");
		menuBar.add(mnEjemplares);
		
		mntmcCrearEjemplar = new JMenuItem("(C) Crear Ejemplar");
		mnEjemplares.add(mntmcCrearEjemplar);
		
		mntmrBuscarEjemplar = new JMenuItem("(R) Buscar Ejemplar");
		mnEjemplares.add(mntmrBuscarEjemplar);
		
		mntmuEjemplar = new JMenuItem("(U) Ejemplar");
		mnEjemplares.add(mntmuEjemplar);
		
		mntmdBorrarEjemplar = new JMenuItem("(D) Borrar Ejemplar");
		mnEjemplares.add(mntmdBorrarEjemplar);
		
		mnPrestamos = new JMenu("Prestamos");
		menuBar.add(mnPrestamos);
		
		mntmcNuevoPrestamo = new JMenuItem("(C) Nuevo Préstamo");
		mnPrestamos.add(mntmcNuevoPrestamo);
		
		mntmrBuscarPrestamo = new JMenuItem("(R) Buscar Préstamo");
		mnPrestamos.add(mntmrBuscarPrestamo);
		
		mntmuModificarPrestamo = new JMenuItem("(U) Modificar Préstamo");
		mnPrestamos.add(mntmuModificarPrestamo);
		
		mntmdDevolverPrstamo = new JMenuItem("(D) Devolver Préstamo");
		mnPrestamos.add(mntmdDevolverPrstamo);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 700, 500));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		crearPaneles();
		
		panelInternoEjemplares = new JPanel();
		panelInternoEjemplares.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Gestion de Ejemplares", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		scrollPane = new JScrollPane();
		GroupLayout gl_panelEjemplares = new GroupLayout(panelEjemplares);
		gl_panelEjemplares.setHorizontalGroup(
			gl_panelEjemplares.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelEjemplares.createSequentialGroup()
					.addContainerGap(36, Short.MAX_VALUE)
					.addGroup(gl_panelEjemplares.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panelInternoEjemplares, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE))
					.addGap(28))
		);
		gl_panelEjemplares.setVerticalGroup(
			gl_panelEjemplares.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelEjemplares.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(panelInternoEjemplares, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		
		table = new JTable(new ModeloTablaEjemplares());
		scrollPane.setViewportView(table);
		int posicion = table.getSelectedRow();
		
		JLabel lblEjemplar = new JLabel("Ejemplar");
		
		txtNumeroejemplar = new JTextField();
		txtNumeroejemplar.setText("numero_ejemplar");
		txtNumeroejemplar.setColumns(10);
		
		JLabel lblIsbn = new JLabel("ISBN");
		
		txtIsbnejemplar = new JTextField();
		txtIsbnejemplar.setText("isbn_ejemplar");
		txtIsbnejemplar.setColumns(10);
		
		JLabel lblTtulo = new JLabel("Título");
		
		txtTitulo = new JTextField();
		txtTitulo.setText("titulo");
		txtTitulo.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor");
		
		txtAutor = new JTextField();
		txtAutor.setText("autor");
		txtAutor.setColumns(10);
		
		JLabel lblEditorial = new JLabel("Editorial");
		
		txtEditorial = new JTextField();
		txtEditorial.setText("editorial");
		txtEditorial.setColumns(10);
		
		JLabel lblEdicin = new JLabel("Edición");
		
		txtEdicion = new JTextField();
		txtEdicion.setText("edicion");
		txtEdicion.setColumns(10);
		GroupLayout gl_panelInternoEjemplares = new GroupLayout(panelInternoEjemplares);
		gl_panelInternoEjemplares.setHorizontalGroup(
			gl_panelInternoEjemplares.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInternoEjemplares.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_panelInternoEjemplares.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEjemplar)
						.addComponent(lblIsbn)
						.addComponent(lblTtulo)
						.addComponent(lblAutor)
						.addComponent(lblEditorial)
						.addComponent(lblEdicin))
					.addGap(18)
					.addGroup(gl_panelInternoEjemplares.createParallelGroup(Alignment.LEADING)
						.addComponent(txtNumeroejemplar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelInternoEjemplares.createSequentialGroup()
							.addGroup(gl_panelInternoEjemplares.createParallelGroup(Alignment.LEADING)
								.addComponent(txtEdicion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtAutor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtIsbnejemplar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTitulo, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtEditorial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(243, Short.MAX_VALUE))))
		);
		gl_panelInternoEjemplares.setVerticalGroup(
			gl_panelInternoEjemplares.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInternoEjemplares.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panelInternoEjemplares.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEjemplar)
						.addComponent(txtNumeroejemplar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInternoEjemplares.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIsbn)
						.addComponent(txtIsbnejemplar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInternoEjemplares.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTtulo)
						.addComponent(txtTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInternoEjemplares.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAutor)
						.addComponent(txtAutor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInternoEjemplares.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEditorial)
						.addComponent(txtEditorial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panelInternoEjemplares.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEdicin)
						.addComponent(txtEdicion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panelInternoEjemplares.setLayout(gl_panelInternoEjemplares);
		panelEjemplares.setLayout(gl_panelEjemplares);
		
		
	}

	/**
	 * @return the txtEditorial
	 */
	public JTextField getTxtEditorial() {
		return txtEditorial;
	}

	/**
	 * @param txtEditorial the txtEditorial to set
	 */
	public void setTxtEditorial(JTextField txtEditorial) {
		this.txtEditorial = txtEditorial;
	}

	/**
	 * @return the txtEdicion
	 */
	public JTextField getTxtEdicion() {
		return txtEdicion;
	}

	/**
	 * @param txtEdicion the txtEdicion to set
	 */
	public void setTxtEdicion(JTextField txtEdicion) {
		this.txtEdicion = txtEdicion;
	}

	/**
	 * @return the txtAutor
	 */
	public JTextField getTxtAutor() {
		return txtAutor;
	}

	/**
	 * @param txtAutor the txtAutor to set
	 */
	public void setTxtAutor(JTextField txtAutor) {
		this.txtAutor = txtAutor;
	}

	/**
	 * @return the txtIsbnejemplar
	 */
	public JTextField getTxtIsbnejemplar() {
		return txtIsbnejemplar;
	}

	/**
	 * @param txtIsbnejemplar the txtIsbnejemplar to set
	 */
	public void setTxtIsbnejemplar(JTextField txtIsbnejemplar) {
		this.txtIsbnejemplar = txtIsbnejemplar;
	}

	/**
	 * @return the txtTitulo
	 */
	public JTextField getTxtTitulo() {
		return txtTitulo;
	}

	/**
	 * @param txtTitulo the txtTitulo to set
	 */
	public void setTxtTitulo(JTextField txtTitulo) {
		this.txtTitulo = txtTitulo;
	}

	/**
	 * @return the txtNumeroejemplar
	 */
	public JTextField getTxtNumeroejemplar() {
		return txtNumeroejemplar;
	}

	/**
	 * @param txtNumeroejemplar the txtNumeroejemplar to set
	 */
	public void setTxtNumeroejemplar(JTextField txtNumeroejemplar) {
		this.txtNumeroejemplar = txtNumeroejemplar;
	}

	/**
	 * @return the table
	 */
	public JTable getTable() {
		return table;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(JTable table) {
		this.table = table;
	}
	
	
}

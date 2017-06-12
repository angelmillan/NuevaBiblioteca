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
import javax.swing.table.TableColumnModel;

import controlador.Controlador;
import controlador.ModeloTablaEjemplares;
import modelo.EjemplarDAO;

import javax.swing.border.EtchedBorder;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;


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
	private JMenu mnLibros;
	private JMenu mnEjemplares;
	private JMenu mnPrestamos;
	private JPanel panelInternoEjemplares;
	private JScrollPane scrollPane;
	private JTextField txtEditorial;
	

	private JTextField txtEdicion;
	private JTextField txtAutor;
	private JTextField txtIsbnejemplar;
	private JTextField txtTitulo;
	private JTextField txtNumeroejemplar;
	private JMenuBar menuBar;
	private JTable table;
	private JTextField textFieldInformacionAlUsuario;
	private JMenuItem mntmGestionarUsuarios;
	private JMenuItem mntmGestionarLibros;
	private JMenuItem mntmGestionarEjemplares;
	private JMenuItem mntmGestionarPrstamos;
	private JButton btnAadirEjemplar;
	private JButton btnBorrarEjemplar;
	private JButton btnBuscarEjemplar;
	private TableColumnModel columnModel;

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
		//contentPane.add(panelUsuarios);
		
		
		panelLibros = new JPanel();
		panelLibros.setVisible(false);
		//contentPane.add(panelLibros);
		
		
		panelEjemplares = new JPanel();
		panelEjemplares.setVisible(true);
		contentPane.add(panelEjemplares);
		
		panelPrestamos = new JPanel();
		panelPrestamos.setVisible(false);
		//contentPane.add(panelPrestamos);
		
		
		
	}
	public Vista() {
		setBounds(new Rectangle(0, 0, 900, 500));
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
		
		mntmGestionarUsuarios = new JMenuItem("Gestionar Usuarios");
		mnUsuarios.add(mntmGestionarUsuarios);
		
		mnLibros = new JMenu("Libros");
		menuBar.add(mnLibros);
		
		mntmGestionarLibros = new JMenuItem("Gestionar Libros");
		mnLibros.add(mntmGestionarLibros);
		
		mnEjemplares = new JMenu("Ejemplares");
		menuBar.add(mnEjemplares);
		
		mntmGestionarEjemplares = new JMenuItem("Gestionar Ejemplares");
		mnEjemplares.add(mntmGestionarEjemplares);
		
		mnPrestamos = new JMenu("Prestamos");
		menuBar.add(mnPrestamos);
		
		mntmGestionarPrstamos = new JMenuItem("Gestionar Préstamos");
		mnPrestamos.add(mntmGestionarPrstamos);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 700, 500));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		crearPaneles();
		
		panelInternoEjemplares = new JPanel();
		panelInternoEjemplares.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Ejemplar seleccionado", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		scrollPane = new JScrollPane();
		
		btnAadirEjemplar = new JButton("Añadir nuevo ejemplar");
		
		btnBorrarEjemplar = new JButton("Borrar Ejemplar");
		
		btnBuscarEjemplar = new JButton("Buscar Ejemplar");
		
		textFieldInformacionAlUsuario = new JTextField();
		textFieldInformacionAlUsuario.setBackground(SystemColor.window);
		textFieldInformacionAlUsuario.setForeground(Color.RED);
		textFieldInformacionAlUsuario.setEditable(false);
		textFieldInformacionAlUsuario.setColumns(10);
		
		
		GroupLayout gl_panelEjemplares = new GroupLayout(panelEjemplares);
		gl_panelEjemplares.setHorizontalGroup(
			gl_panelEjemplares.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEjemplares.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panelEjemplares.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1637, Short.MAX_VALUE)
						.addGroup(gl_panelEjemplares.createSequentialGroup()
							.addGap(6)
							.addComponent(textFieldInformacionAlUsuario, GroupLayout.PREFERRED_SIZE, 844, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelEjemplares.createSequentialGroup()
							.addGroup(gl_panelEjemplares.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelEjemplares.createSequentialGroup()
									.addComponent(btnAadirEjemplar)
									.addGap(35)
									.addComponent(btnBorrarEjemplar)
									.addGap(37)
									.addComponent(btnBuscarEjemplar))
								.addComponent(panelInternoEjemplares, GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE))
							.addGap(868)))
					.addContainerGap())
		);
		gl_panelEjemplares.setVerticalGroup(
			gl_panelEjemplares.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEjemplares.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(panelInternoEjemplares, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panelEjemplares.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAadirEjemplar)
						.addComponent(btnBorrarEjemplar)
						.addComponent(btnBuscarEjemplar))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textFieldInformacionAlUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		table = new JTable(new ModeloTablaEjemplares());
		scrollPane.setViewportView(table);
		columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(10);
		columnModel.getColumn(1).setPreferredWidth(4);
		columnModel.getColumn(2).setPreferredWidth(50);
		columnModel.getColumn(3).setPreferredWidth(50);
		columnModel.getColumn(4).setPreferredWidth(50);
		columnModel.getColumn(5).setPreferredWidth(4);
		
		
		
		JLabel lblEjemplar = new JLabel("Ejemplar");
		
		txtNumeroejemplar = new JTextField();
		txtNumeroejemplar.setBackground(SystemColor.window);
		txtNumeroejemplar.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		txtNumeroejemplar.setForeground(new Color(128, 0, 0));
		txtNumeroejemplar.setText("");
		txtNumeroejemplar.setColumns(10);
		
		JLabel lblIsbn = new JLabel("ISBN");
		
		txtIsbnejemplar = new JTextField();
		txtIsbnejemplar.setBackground(SystemColor.window);
		txtIsbnejemplar.setEditable(false);
		txtIsbnejemplar.setText("");
		txtIsbnejemplar.setColumns(10);
		
		JLabel lblTtulo = new JLabel("Título");
		
		txtTitulo = new JTextField();
		txtTitulo.setBackground(SystemColor.window);
		txtTitulo.setEditable(false);
		txtTitulo.setText("");
		txtTitulo.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor");
		
		txtAutor = new JTextField();
		txtAutor.setBackground(SystemColor.window);
		txtAutor.setEditable(false);
		txtAutor.setText("");
		txtAutor.setColumns(10);
		
		JLabel lblEditorial = new JLabel("Editorial");
		
		txtEditorial = new JTextField();
		txtEditorial.setEditable(false);
		txtEditorial.setBackground(SystemColor.window);
		txtEditorial.setText("");
		txtEditorial.setColumns(10);
		
		JLabel lblEdicin = new JLabel("Edición");
		
		txtEdicion = new JTextField();
		txtEdicion.setBackground(SystemColor.window);
		txtEdicion.setEditable(false);
		txtEdicion.setText("");
		txtEdicion.setColumns(10);
		
		
		GroupLayout gl_panelInternoEjemplares = new GroupLayout(panelInternoEjemplares);
		
		gl_panelInternoEjemplares.setHorizontalGroup(
			gl_panelInternoEjemplares.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInternoEjemplares.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_panelInternoEjemplares.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelInternoEjemplares.createSequentialGroup()
							.addComponent(lblAutor)
							.addGap(18)
							.addComponent(txtAutor, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(lblEdicin)
							.addGap(18)
							.addComponent(txtEdicion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelInternoEjemplares.createSequentialGroup()
							.addGroup(gl_panelInternoEjemplares.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTtulo)
								.addComponent(lblIsbn))
							.addGap(18)
							.addGroup(gl_panelInternoEjemplares.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelInternoEjemplares.createSequentialGroup()
									.addComponent(txtIsbnejemplar, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblEjemplar)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtNumeroejemplar, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblEditorial)
									.addGap(18)
									.addComponent(txtEditorial, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtTitulo, GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE))))
					.addGap(17))
		);
		
		gl_panelInternoEjemplares.setVerticalGroup(
			gl_panelInternoEjemplares.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInternoEjemplares.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panelInternoEjemplares.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIsbn)
						.addComponent(txtEditorial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtIsbnejemplar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEditorial)
						.addComponent(lblEjemplar)
						.addComponent(txtNumeroejemplar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInternoEjemplares.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTtulo)
						.addComponent(txtTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInternoEjemplares.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAutor)
						.addComponent(txtAutor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEdicin)
						.addComponent(txtEdicion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(18, Short.MAX_VALUE))
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

	/**
	 * @return the panelUsuarios
	 */
	public JPanel getPanelUsuarios() {
		return panelUsuarios;
	}

	/**
	 * @param panelUsuarios the panelUsuarios to set
	 */
	public void setPanelUsuarios(JPanel panelUsuarios) {
		this.panelUsuarios = panelUsuarios;
	}

	/**
	 * @return the panelLibros
	 */
	public JPanel getPanelLibros() {
		return panelLibros;
	}

	/**
	 * @param panelLibros the panelLibros to set
	 */
	public void setPanelLibros(JPanel panelLibros) {
		this.panelLibros = panelLibros;
	}

	/**
	 * @return the panelEjemplares
	 */
	public JPanel getPanelEjemplares() {
		return panelEjemplares;
	}

	/**
	 * @param panelEjemplares the panelEjemplares to set
	 */
	public void setPanelEjemplares(JPanel panelEjemplares) {
		this.panelEjemplares = panelEjemplares;
	}

	/**
	 * @return the panelPrestamos
	 */
	public JPanel getPanelPrestamos() {
		return panelPrestamos;
	}

	/**
	 * @param panelPrestamos the panelPrestamos to set
	 */
	public void setPanelPrestamos(JPanel panelPrestamos) {
		this.panelPrestamos = panelPrestamos;
	}

	/**
	 * @return the panelInternoEjemplares
	 */
	public JPanel getPanelInternoEjemplares() {
		return panelInternoEjemplares;
	}

	/**
	 * @param panelInternoEjemplares the panelInternoEjemplares to set
	 */
	public void setPanelInternoEjemplares(JPanel panelInternoEjemplares) {
		this.panelInternoEjemplares = panelInternoEjemplares;
	}

	/**
	 * @return the mntmAcercaDeBiblioteca
	 */
	public JMenuItem getMntmAcercaDeBiblioteca() {
		return mntmAcercaDeBiblioteca;
	}

	/**
	 * @param mntmAcercaDeBiblioteca the mntmAcercaDeBiblioteca to set
	 */
	public void setMntmAcercaDeBiblioteca(JMenuItem mntmAcercaDeBiblioteca) {
		this.mntmAcercaDeBiblioteca = mntmAcercaDeBiblioteca;
	}

	/**
	 * @return the mnAplicacion
	 */
	public JMenu getMnAplicacion() {
		return mnAplicacion;
	}

	/**
	 * @param mnAplicacion the mnAplicacion to set
	 */
	public void setMnAplicacion(JMenu mnAplicacion) {
		this.mnAplicacion = mnAplicacion;
	}

	/**
	 * @return the mnUsuarios
	 */
	public JMenu getMnUsuarios() {
		return mnUsuarios;
	}

	/**
	 * @param mnUsuarios the mnUsuarios to set
	 */
	public void setMnUsuarios(JMenu mnUsuarios) {
		this.mnUsuarios = mnUsuarios;
	}

	/**
	 * @return the mnLibros
	 */
	public JMenu getMnLibros() {
		return mnLibros;
	}

	/**
	 * @param mnLibros the mnLibros to set
	 */
	public void setMnLibros(JMenu mnLibros) {
		this.mnLibros = mnLibros;
	}

	/**
	 * @return the mnEjemplares
	 */
	public JMenu getMnEjemplares() {
		return mnEjemplares;
	}

	/**
	 * @param mnEjemplares the mnEjemplares to set
	 */
	public void setMnEjemplares(JMenu mnEjemplares) {
		this.mnEjemplares = mnEjemplares;
	}

	/**
	 * @return the mnPrestamos
	 */
	public JMenu getMnPrestamos() {
		return mnPrestamos;
	}

	/**
	 * @param mnPrestamos the mnPrestamos to set
	 */
	public void setMnPrestamos(JMenu mnPrestamos) {
		this.mnPrestamos = mnPrestamos;
	}


	/**
	 * @return the textFieldInformacionAlUsuario
	 */
	public JTextField getTextFieldInformacionAlUsuario() {
		return textFieldInformacionAlUsuario;
	}

	/**
	 * @param textFieldInformacionAlUsuario the textFieldInformacionAlUsuario to set
	 */
	public void setTextFieldInformacionAlUsuario(JTextField textFieldInformacionAlUsuario) {
		this.textFieldInformacionAlUsuario = textFieldInformacionAlUsuario;
	}

	/**
	 * @return the mntmGestionarUsuarios
	 */
	public JMenuItem getMntmGestionarUsuarios() {
		return mntmGestionarUsuarios;
	}

	/**
	 * @param mntmGestionarUsuarios the mntmGestionarUsuarios to set
	 */
	public void setMntmGestionarUsuarios(JMenuItem mntmGestionarUsuarios) {
		this.mntmGestionarUsuarios = mntmGestionarUsuarios;
	}

	/**
	 * @return the mntmGestionarLibros
	 */
	public JMenuItem getMntmGestionarLibros() {
		return mntmGestionarLibros;
	}

	/**
	 * @param mntmGestionarLibros the mntmGestionarLibros to set
	 */
	public void setMntmGestionarLibros(JMenuItem mntmGestionarLibros) {
		this.mntmGestionarLibros = mntmGestionarLibros;
	}

	/**
	 * @return the mntmGestionarEjemplares
	 */
	public JMenuItem getMntmGestionarEjemplares() {
		return mntmGestionarEjemplares;
	}

	/**
	 * @param mntmGestionarEjemplares the mntmGestionarEjemplares to set
	 */
	public void setMntmGestionarEjemplares(JMenuItem mntmGestionarEjemplares) {
		this.mntmGestionarEjemplares = mntmGestionarEjemplares;
	}

	/**
	 * @return the mntmGestionarPrstamos
	 */
	public JMenuItem getMntmGestionarPrstamos() {
		return mntmGestionarPrstamos;
	}

	/**
	 * @param mntmGestionarPrstamos the mntmGestionarPrstamos to set
	 */
	public void setMntmGestionarPrstamos(JMenuItem mntmGestionarPrstamos) {
		this.mntmGestionarPrstamos = mntmGestionarPrstamos;
	}

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

	/**
	 * @return the btnAadirEjemplar
	 */
	public JButton getBtnAadirEjemplar() {
		return btnAadirEjemplar;
	}

	/**
	 * @param btnAadirEjemplar the btnAadirEjemplar to set
	 */
	public void setBtnAadirEjemplar(JButton btnAadirEjemplar) {
		this.btnAadirEjemplar = btnAadirEjemplar;
	}

	/**
	 * @return the btnBorrarEjemplar
	 */
	public JButton getBtnBorrarEjemplar() {
		return btnBorrarEjemplar;
	}

	/**
	 * @param btnBorrarEjemplar the btnBorrarEjemplar to set
	 */
	public void setBtnBorrarEjemplar(JButton btnBorrarEjemplar) {
		this.btnBorrarEjemplar = btnBorrarEjemplar;
	}

	/**
	 * @return the btnBuscarEjemplar
	 */
	public JButton getBtnBuscarEjemplar() {
		return btnBuscarEjemplar;
	}

	/**
	 * @param btnBuscarEjemplar the btnBuscarEjemplar to set
	 */
	public void setBtnBuscarEjemplar(JButton btnBuscarEjemplar) {
		this.btnBuscarEjemplar = btnBuscarEjemplar;
	}

	/**
	 * @return the columnModel
	 */
	public TableColumnModel getColumnModel() {
		return columnModel;
	}

	/**
	 * @param columnModel the columnModel to set
	 */
	public void setColumnModel(TableColumnModel columnModel) {
		this.columnModel = columnModel;
	}

	
	
	
	
	
}

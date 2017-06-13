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


import controlador.Controlador;
import modelo.EjemplarDAO;


import java.awt.Rectangle;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;



@SuppressWarnings("serial")
public class Vista extends JFrame {
	//private JPanel panelEjemplares;
	private JPanel contentPane;
	private JMenuItem mntmAcercaDeBiblioteca;
	private JMenuItem mntmSalir;
	private JMenu mnAplicacion;
	private JMenu mnUsuarios;
	private JMenu mnLibros;
	private JMenu mnEjemplares;
	private JMenu mnPrestamos;
	//private JPanel panelLibros;
	private JMenuBar menuBar;
	private JMenuItem mntmGestionarUsuarios;
	private JMenuItem mntmGestionarLibros;
	private JMenuItem mntmGestionarEjemplares;
	private JMenuItem mntmGestionarPrstamos;
	private PanelParaEjemplares panelEjemplares;
	private PanelParaLibros panelLibros;
	private PanelParaUsuarios panelUsuarios;
	


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
					
				} 	catch (Exception e) {
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

		
		
		panelEjemplares = new PanelParaEjemplares();
		panelEjemplares.setVisible(true);
		contentPane.add(panelEjemplares);
		
		
		panelLibros = new PanelParaLibros();
		panelLibros.setVisible(false);
		contentPane.add(panelLibros);
		
		panelUsuarios = new PanelParaUsuarios();
		panelUsuarios.setVisible(false);
		contentPane.add(panelUsuarios);
		
		
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 890, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 446, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
		
		crearPaneles();
		
				
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
	 * @return the panelEjemplares
	 */
	public PanelParaEjemplares getPanelEjemplares() {
		return panelEjemplares;
	}

	/**
	 * @param panelEjemplares the panelEjemplares to set
	 */
	public void setPanelEjemplares(PanelParaEjemplares panelEjemplares) {
		this.panelEjemplares = panelEjemplares;
	}

	/**
	 * @return the panelLibros
	 */
	public PanelParaLibros getPanelLibros() {
		return panelLibros;
	}

	/**
	 * @param panelLibros the panelLibros to set
	 */
	public void setPanelLibros(PanelParaLibros panelLibros) {
		this.panelLibros = panelLibros;
	}

	/**
	 * @return the panelUsuarios
	 */
	public PanelParaUsuarios getPanelUsuarios() {
		return panelUsuarios;
	}

	/**
	 * @param panelUsuarios the panelUsuarios to set
	 */
	public void setPanelUsuarios(PanelParaUsuarios panelUsuarios) {
		this.panelUsuarios = panelUsuarios;
	}

		
	
	
	
	
	
	
	
}

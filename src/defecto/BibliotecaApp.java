package defecto;

import java.awt.EventQueue;

import controlador.Controlador;
import modelo.EjemplarDAO;
import modelo.LibroDAO;
import modelo.PrestamoDAO;
import modelo.UsuarioDAO;
import vista.Vista;

public class BibliotecaApp {

	public BibliotecaApp() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {	
					Vista frame = new Vista();
					//frame.setVisible(true);
					new Controlador (frame, new EjemplarDAO(), new LibroDAO(), new UsuarioDAO(), new PrestamoDAO());
					
				} 	catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Main {

	private CrearListaReproduccion crl;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		crl = new CrearListaReproduccion();
		crl.setVisible(false);
		
		frame.getContentPane().add(crl);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("UyTube - Main");
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenu mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);
		
		JMenuItem mntmAltaUsuario = new JMenuItem("Alta Usuario");
		mnUsuario.add(mntmAltaUsuario);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Modificar Usuario");
		mnUsuario.add(mntmNewMenuItem);
		
		JMenuItem mntmConsultarUsuario = new JMenuItem("Consultar Usuario");
		mnUsuario.add(mntmConsultarUsuario);
		
		JMenuItem mntmListarUsuario = new JMenuItem("Listar Usuario");
		mnUsuario.add(mntmListarUsuario);
		
		JMenu mnVideo = new JMenu("Video");
		menuBar.add(mnVideo);
		
		JMenuItem mntmAltaVideo = new JMenuItem("Alta Video");
		mnVideo.add(mntmAltaVideo);
		
		JMenuItem mntmModificarVideo = new JMenuItem("Modificar Video");
		mnVideo.add(mntmModificarVideo);
		
		JMenuItem mntmConsultaVideo = new JMenuItem("Consulta Video");
		mnVideo.add(mntmConsultaVideo);
		
		JMenu mnCategora = new JMenu("Categoria");
		menuBar.add(mnCategora);
		
		JMenuItem mntmAltaCategora = new JMenuItem("Alta Categoria");
		mnCategora.add(mntmAltaCategora);
		
		JMenuItem mntmConsultaCategora = new JMenuItem("Consulta Categoria");
		mnCategora.add(mntmConsultaCategora);
		
		JMenuItem mntmListarCategoria = new JMenuItem("Listar Categoria");
		mnCategora.add(mntmListarCategoria);
		
		JMenu mnLista = new JMenu("Lista");
		menuBar.add(mnLista);
		
		JMenuItem mntmAltaLista = new JMenuItem("Alta Lista");
		mntmAltaLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crl.setVisible(true);
			}
		});
		mnLista.add(mntmAltaLista);
		
		JMenuItem mntmModificarLista = new JMenuItem("Modificar Lista");
		mnLista.add(mntmModificarLista);
		
		JMenuItem mntmAgregarVideoA = new JMenuItem("Agregar Video a Lista");
		mnLista.add(mntmAgregarVideoA);
		
		JMenuItem mntmQuitarVideoDe = new JMenuItem("Quitar Video de Lista");
		mnLista.add(mntmQuitarVideoDe);
		
		JMenuItem mntmConsultaLista = new JMenuItem("Consulta Lista");
		mnLista.add(mntmConsultaLista);
	}

}
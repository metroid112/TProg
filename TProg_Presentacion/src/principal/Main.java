package principal;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import internalFrames.AltaCategoria;
import internalFrames.ConsultaCategoria;
import internalFrames.Dummy;
import internalFrames.ListarCategorias;

import java.awt.BorderLayout;
import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Main {

	private JFrame frame;
	private AltaCategoria altCat;
	private ListarCategorias lisCat;
	private ConsultaCategoria conCat;
	private Dummy dum;

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
		
		altCat = new AltaCategoria();
		altCat.setVisible(false);
		
		lisCat = new ListarCategorias();
		lisCat.setVisible(false);
		
		conCat = new ConsultaCategoria();
		conCat.setVisible(false);
		
		dum = new Dummy();
		dum.setVisible(false);
		
		frame.getContentPane().add(lisCat);
		frame.getContentPane().add(altCat);
		frame.getContentPane().add(conCat);
		frame.getContentPane().add(dum, BorderLayout.CENTER );
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		

		
		frame = new JFrame();
		frame.setBounds(300, 200, 800, 600);
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
		mntmAltaCategora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!ventanasAbiertas(altCat.isVisible(),lisCat.isVisible(),conCat.isVisible()))
						altCat.setVisible(true);
				}		
			
		});
		mnCategora.add(mntmAltaCategora);
		
		JMenuItem mntmConsultaCategora = new JMenuItem("Consulta Categoria");
		mntmConsultaCategora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!ventanasAbiertas(altCat.isVisible(),lisCat.isVisible(),conCat.isVisible()))
					conCat.setVisible(true);
			}
		});
		mnCategora.add(mntmConsultaCategora);
		
		JMenuItem mntmListarCategoria = new JMenuItem("Listar Categoria");
		mntmListarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!ventanasAbiertas(altCat.isVisible(),lisCat.isVisible(),conCat.isVisible()))
					lisCat.setVisible(true);
				}
				
			
		});
		mnCategora.add(mntmListarCategoria);
		
		JMenu mnLista = new JMenu("Lista");
		menuBar.add(mnLista);
		
		JMenuItem mntmAltaLista = new JMenuItem("Alta Lista");
		mnLista.add(mntmAltaLista);
		
		JMenuItem mntmModificarLista = new JMenuItem("Modificar Lista");
		mnLista.add(mntmModificarLista);
		
		JMenuItem mntmAgregarVideoA = new JMenuItem("Agregar Video a Lista");
		mnLista.add(mntmAgregarVideoA);
		
		JMenuItem mntmQuitarVideoDe = new JMenuItem("Quitar Video de Lista");
		mnLista.add(mntmQuitarVideoDe);
		
		JMenuItem mntmConsultaLista = new JMenuItem("Consulta Lista");
		mnLista.add(mntmConsultaLista);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		

	}

	private Boolean ventanasAbiertas(Boolean b1,Boolean b2,Boolean b3){
		return b1 || b2 || b3;
	}

}
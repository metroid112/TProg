package principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import internalFrames.*;
import java.awt.BorderLayout;
import javax.swing.JInternalFrame;

public class Main {
	private CrearListaReproduccion creLisRep;
	private JFrame frame;
	private AltaCategoria altCat;
	private ListarCategorias lisCat;
	private ConsultaCategoria conCat;
	private Dummy dum;
	private AgregarVideo agrVid;
	private ModificarListaReproduccion modLisRep;
	private QuitarVideo quiVid;
	private ConsultaLista conLis;

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
		
		creLisRep = new CrearListaReproduccion();
		creLisRep.setVisible(false);
		
		agrVid = new AgregarVideo();
		agrVid.setVisible(false);
		
		modLisRep = new ModificarListaReproduccion();
		modLisRep.setVisible(false);
		
		quiVid = new QuitarVideo();
		quiVid.setVisible(false);
		
		conLis = new ConsultaLista();
		conLis.setVisible(false);
		
		frame.getContentPane().add(conLis);
		frame.getContentPane().add(creLisRep);
		frame.getContentPane().add(agrVid);
		frame.getContentPane().add(modLisRep);
		frame.getContentPane().add(quiVid);
		frame.getContentPane().add(lisCat);
		frame.getContentPane().add(altCat);
		frame.getContentPane().add(conCat);
		frame.getContentPane().add(dum, BorderLayout.CENTER);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setResizable(false);
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
				if (!ventanasAbiertas(altCat.isVisible(), lisCat.isVisible(), conCat.isVisible(), creLisRep.isVisible(), agrVid.isVisible(), modLisRep.isVisible(), 
						quiVid.isVisible(), conLis.isVisible()))
					altCat.setVisible(true);
			}

		});
		mnCategora.add(mntmAltaCategora);

		JMenuItem mntmConsultaCategora = new JMenuItem("Consulta Categoria");
		mntmConsultaCategora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!ventanasAbiertas(altCat.isVisible(), lisCat.isVisible(), conCat.isVisible(), creLisRep.isVisible(), agrVid.isVisible(), modLisRep.isVisible(), 
						quiVid.isVisible(), conLis.isVisible()))
					conCat.setVisible(true);
			}
		});
		mnCategora.add(mntmConsultaCategora);

		JMenuItem mntmListarCategoria = new JMenuItem("Listar Categoria");
		mntmListarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!ventanasAbiertas(altCat.isVisible(), lisCat.isVisible(), conCat.isVisible(), creLisRep.isVisible(), agrVid.isVisible(), modLisRep.isVisible(), 
						quiVid.isVisible(), conLis.isVisible()))
					lisCat.setVisible(true);
			}

		});
		mnCategora.add(mntmListarCategoria);

		JMenu mnLista = new JMenu("Lista");
		menuBar.add(mnLista);

		JMenuItem mntmAltaLista = new JMenuItem("Alta Lista");
		mntmAltaLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!ventanasAbiertas(altCat.isVisible(), lisCat.isVisible(), conCat.isVisible(), creLisRep.isVisible(), agrVid.isVisible(), modLisRep.isVisible(), 
						quiVid.isVisible(), conLis.isVisible()))
					creLisRep.setVisible(true);
			}
		});
		mnLista.add(mntmAltaLista);

		JMenuItem mntmModificarLista = new JMenuItem("Modificar Lista");
		mntmModificarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!ventanasAbiertas(altCat.isVisible(), lisCat.isVisible(), conCat.isVisible(), creLisRep.isVisible(), agrVid.isVisible(), modLisRep.isVisible(), 
						quiVid.isVisible(), conLis.isVisible()))
					modLisRep.setVisible(true);
			}
		});
		mnLista.add(mntmModificarLista);

		JMenuItem mntmAgregarVideoA = new JMenuItem("Agregar Video a Lista");
		mntmAgregarVideoA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!ventanasAbiertas(altCat.isVisible(), lisCat.isVisible(), conCat.isVisible(), creLisRep.isVisible(), agrVid.isVisible(), modLisRep.isVisible(), 
						quiVid.isVisible(), conLis.isVisible()))
					agrVid.setVisible(true);
			}
		});
		mnLista.add(mntmAgregarVideoA);

		JMenuItem mntmQuitarVideoDe = new JMenuItem("Quitar Video de Lista");
		mntmQuitarVideoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!ventanasAbiertas(altCat.isVisible(), lisCat.isVisible(), conCat.isVisible(), creLisRep.isVisible(), agrVid.isVisible(), modLisRep.isVisible(), 
						quiVid.isVisible(), conLis.isVisible()))
					quiVid.setVisible(true);
			}
		});
		mnLista.add(mntmQuitarVideoDe);

		JMenuItem mntmConsultaLista = new JMenuItem("Consulta Lista");
		mntmConsultaLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!ventanasAbiertas(altCat.isVisible(), lisCat.isVisible(), conCat.isVisible(), creLisRep.isVisible(), agrVid.isVisible(), modLisRep.isVisible(), 
						quiVid.isVisible(), conLis.isVisible()))
					conLis.setVisible(true);
			}
		});
		mnLista.add(mntmConsultaLista);

		frame.getContentPane().setLayout(new BorderLayout(0, 0));

	}

	private Boolean ventanasAbiertas(Boolean b1, Boolean b2, Boolean b3, Boolean b4, Boolean b5, Boolean b6, Boolean b7, Boolean b8) {
		return b1 || b2 || b3 || b4 || b5 || b6 || b7 || b8;
	}

}
package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import interfaces.*;
import internalFrames.AgregarVideo;
import internalFrames.AltaCategoria;
import internalFrames.AltaUsuario;
import internalFrames.ConsultaCategoria;
import internalFrames.ConsultaLista;
import internalFrames.CrearListaReproduccion;
import internalFrames.ListarCategorias;
import internalFrames.ModificarListaReproduccion;
import internalFrames.QuitarVideo;

public class Main {

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
	
	private JFrame frame;
	
	private HashSet<JInternalFrame> frames = new HashSet<JInternalFrame>();
	
	private AgregarVideo agrVid;
	private AltaCategoria altCat;
	private AltaUsuario altUsu;
	private ConsultaCategoria conCat;
	private ConsultaLista conLis;
	private CrearListaReproduccion creLisRep;
	private ListarCategorias lisCat;
	private ModificarListaReproduccion modLisRep;
	private QuitarVideo quiVid;
	
	private Fabrica fabrica = Fabrica.getFabrica();
	private ICategorias categorias = fabrica.getICategorias();
	private IListas listas = fabrica.getIListas();
	private IUsuariosCanales usuariosCanales = fabrica.getIUsuariosCanales();
	private IVideos videos = fabrica.getIVideos();

	public Main() {

		initialize();

		altCat = new AltaCategoria();
		lisCat = new ListarCategorias();
		conCat = new ConsultaCategoria();
		creLisRep = new CrearListaReproduccion();
		agrVid = new AgregarVideo();
		modLisRep = new ModificarListaReproduccion();
		quiVid = new QuitarVideo();
		conLis = new ConsultaLista();
		altUsu = new AltaUsuario();

		frame.getContentPane().add(conLis);
		frame.getContentPane().add(creLisRep);
		frame.getContentPane().add(agrVid);
		frame.getContentPane().add(modLisRep);
		frame.getContentPane().add(quiVid);
		frame.getContentPane().add(lisCat);
		frame.getContentPane().add(altCat);
		frame.getContentPane().add(conCat);
		frame.getContentPane().add(altUsu);
		
		frames.add(conLis);
		frames.add(creLisRep);
		frames.add(agrVid);
		frames.add(modLisRep);
		frames.add(quiVid);
		frames.add(lisCat);
		frames.add(altCat);
		frames.add(conCat);
		frames.add(altUsu);
		
		for (JInternalFrame frame: frames) {
			frame.setVisible(false);
		}
	}

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

		JMenu mnVideo = new JMenu("Video");
		menuBar.add(mnVideo);
		
		JMenu mnCategora = new JMenu("Categoria");
		menuBar.add(mnCategora);
		
		JMenu mnLista = new JMenu("Lista");
		menuBar.add(mnLista);

		JMenuItem mntmNewMenuItem = new JMenuItem("Modificar Usuario");
		mnUsuario.add(mntmNewMenuItem);

		JMenuItem mntmConsultarUsuario = new JMenuItem("Consultar Usuario");
		mnUsuario.add(mntmConsultarUsuario);

		JMenuItem mntmListarUsuario = new JMenuItem("Listar Usuario");
		mnUsuario.add(mntmListarUsuario);

		JMenuItem mntmAltaVideo = new JMenuItem("Alta Video");
		mnVideo.add(mntmAltaVideo);

		JMenuItem mntmModificarVideo = new JMenuItem("Modificar Video");
		mnVideo.add(mntmModificarVideo);

		JMenuItem mntmConsultaVideo = new JMenuItem("Consulta Video");
		mnVideo.add(mntmConsultaVideo);
		
		JMenuItem mntmAltaUsuario = new JMenuItem("Alta Usuario");
		mntmAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!ventanasAbiertas())
					altUsu.setVisible(true);
			}
		});
		mnUsuario.add(mntmAltaUsuario);

		JMenuItem mntmAltaCategora = new JMenuItem("Alta Categoria");
		mntmAltaCategora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!ventanasAbiertas())
					altCat.setVisible(true);
			}

		});
		mnCategora.add(mntmAltaCategora);

		JMenuItem mntmConsultaCategora = new JMenuItem("Consulta Categoria");
		mntmConsultaCategora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!ventanasAbiertas())
					conCat.setVisible(true);
			}
		});
		mnCategora.add(mntmConsultaCategora);

		JMenuItem mntmListarCategoria = new JMenuItem("Listar Categoria");
		mntmListarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!ventanasAbiertas()) {
					lisCat.cargarDatos();
					lisCat.setVisible(true);
				}
			}

		});
		mnCategora.add(mntmListarCategoria);

		JMenuItem mntmAltaLista = new JMenuItem("Alta Lista");
		mntmAltaLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!ventanasAbiertas())
					creLisRep.setVisible(true);
			}
		});
		mnLista.add(mntmAltaLista);

		JMenuItem mntmModificarLista = new JMenuItem("Modificar Lista");
		mntmModificarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!ventanasAbiertas())
					modLisRep.setVisible(true);
			}
		});
		mnLista.add(mntmModificarLista);

		JMenuItem mntmAgregarVideoA = new JMenuItem("Agregar Video a Lista");
		mntmAgregarVideoA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!ventanasAbiertas())
					agrVid.setVisible(true);
			}
		});
		mnLista.add(mntmAgregarVideoA);

		JMenuItem mntmQuitarVideoDe = new JMenuItem("Quitar Video de Lista");
		mntmQuitarVideoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!ventanasAbiertas())
					quiVid.setVisible(true);
			}
		});
		mnLista.add(mntmQuitarVideoDe);

		JMenuItem mntmConsultaLista = new JMenuItem("Consulta Lista");
		mntmConsultaLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!ventanasAbiertas())
					conLis.setVisible(true);
			}
		});
		mnLista.add(mntmConsultaLista);

		frame.getContentPane().setLayout(new BorderLayout(0, 0));
	}

	public boolean ventanasAbiertas() {
		for (JInternalFrame frame : frames) {
			if (frame.isVisible()) {
				return true;
			}
		}
		return false;
	}

}
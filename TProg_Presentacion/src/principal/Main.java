package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Date;
import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JScrollPane;

<<<<<<< HEAD
import interfaces.Fabrica;
import interfaces.ICategorias;
import interfaces.IVideos;
import internalFrames.AgregarVideo;
import internalFrames.AltaCategoria;
import internalFrames.AltaUsuario;
import internalFrames.AltaVideo;
import internalFrames.ConsultaCategoria;
import internalFrames.ConsultaLista;
import internalFrames.ConsultaUsuario;
import internalFrames.CrearListaReproduccion;
import internalFrames.Dummy;
import internalFrames.ListarCategorias;
import internalFrames.ListarUsuarios;
import internalFrames.ModificarListaReproduccion;
import internalFrames.QuitarVideo;

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
	private AltaUsuario altUsu;
	private ICategorias ctrlCat;
	private ListarUsuarios lisUsu;
	private ConsultaUsuario consultaUsuario;


	/**
	 * Launch the application.
	 */
=======
import interfaces.*;
import internalFrames.*;

public class Main {

>>>>>>> master
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
	
	private AgregarVideo frmAgregarVideo;
	private AltaCategoria frmAltaCategoria;
	private AltaUsuario frmAltaUsuario;
	private ListarUsuarios frmListarUsuarios;
	private ConsultaCategoria frmConsultaCategoria;
	private ConsultaLista frmConsultaLista;
	private CrearListaReproduccion frmCrearListaReproduccion;
	private ListarCategorias frmListarCategorias;
	private ModificarListaReproduccion frmModificarListaReproduccion;
	private QuitarVideo frmQuitarVideo;
	
	private JTextArea logCarga;
	
	private Fabrica fabrica = Fabrica.getFabrica();
	private ICategorias categorias = fabrica.getICategorias();
	private IListas listas = fabrica.getIListas();
	private IUsuariosCanales usuariosCanales = fabrica.getIUsuariosCanales();
	private IVideos videos = fabrica.getIVideos();

	public Main() {

		initialize();

		frmAltaCategoria = new AltaCategoria();
		frmListarCategorias = new ListarCategorias();
		frmConsultaCategoria = new ConsultaCategoria();
		frmCrearListaReproduccion = new CrearListaReproduccion();
		frmAgregarVideo = new AgregarVideo();
		frmModificarListaReproduccion = new ModificarListaReproduccion();
		frmQuitarVideo = new QuitarVideo();
		frmConsultaLista = new ConsultaLista();
		frmAltaUsuario = new AltaUsuario();
		frmListarUsuarios = new ListarUsuarios();

		frame.getContentPane().add(frmConsultaLista);
		frame.getContentPane().add(frmCrearListaReproduccion);
		frame.getContentPane().add(frmAgregarVideo);
		frame.getContentPane().add(frmModificarListaReproduccion);
		frame.getContentPane().add(frmQuitarVideo);
		frame.getContentPane().add(frmListarCategorias);
		frame.getContentPane().add(frmAltaCategoria);
		frame.getContentPane().add(frmConsultaCategoria);
		frame.getContentPane().add(frmAltaUsuario);
		frame.getContentPane().add(frmListarUsuarios);
		
		frames.add(frmConsultaLista);
		frames.add(frmCrearListaReproduccion);
		frames.add(frmAgregarVideo);
		frames.add(frmModificarListaReproduccion);
		frames.add(frmQuitarVideo);
		frames.add(frmListarCategorias);
		frames.add(frmAltaCategoria);
		frames.add(frmConsultaCategoria);
		frames.add(frmAltaUsuario);
		frames.add(frmListarUsuarios);
		
<<<<<<< HEAD
		agrVid = new AgregarVideo();
		agrVid.setVisible(false);
		
		modLisRep = new ModificarListaReproduccion();
		modLisRep.setVisible(false);
		
		quiVid = new QuitarVideo();
		quiVid.setVisible(false);
		
		conLis = new ConsultaLista();
		
		altUsu = new AltaUsuario();
		altUsu.setVisible(false);
		
		consultaUsuario = new ConsultaUsuario();
		consultaUsuario.setVisible(false);

		lisUsu = new ListarUsuarios();
		lisUsu.setVisible(false);
		

		IVideos IVid = fabrica.getIVideos();
		AltaVideo altVid = new AltaVideo(IVid);
		altVid.cargarDatos();
		altVid.setVisible(true);
		
		frame.getContentPane().add(altVid);
		frame.getContentPane().add(conLis);
		frame.getContentPane().add(creLisRep);
		frame.getContentPane().add(agrVid);
		frame.getContentPane().add(modLisRep);
		frame.getContentPane().add(quiVid);
		frame.getContentPane().add(lisCat);
		frame.getContentPane().add(altCat);
		frame.getContentPane().add(conCat);
		frame.getContentPane().add(altUsu);
		frame.getContentPane().add(lisUsu);
		frame.getContentPane().add(consultaUsuario);
		frame.getContentPane().add(dum, BorderLayout.CENTER);

=======
		for (JInternalFrame frame: frames) {
			frame.setVisible(false);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		logCarga = new JTextArea();
		logCarga.setBackground(UIManager.getColor("Button.background"));
		logCarga.setEditable(false);
		logCarga.setVisible(true);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(logCarga);
>>>>>>> master
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
		
		JMenu mnCategoria = new JMenu("Categoria");
		menuBar.add(mnCategoria);
		
		JMenu mnLista = new JMenu("Lista");
		menuBar.add(mnLista);

		JMenuItem mntmCargaDatos = new JMenuItem("Cargar Datos");
		mnMenu.add(mntmCargaDatos);
		
		JMenuItem mntmAltaUsuario = new JMenuItem("Alta Usuario");
		mnUsuario.add(mntmAltaUsuario);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Modificar Usuario");
		mnUsuario.add(mntmNewMenuItem);

		JMenuItem mntmConsultarUsuario = new JMenuItem("Consultar Usuario");
		mntmConsultarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ale) {
				if (!ventanasAbiertas(altCat.isVisible(), lisCat.isVisible(), conCat.isVisible(), creLisRep.isVisible(), altUsu.isVisible(), agrVid.isVisible(), modLisRep.isVisible(), 
						quiVid.isVisible(), conLis.isVisible()))
					consultaUsuario.cargarDatos();
					consultaUsuario.setVisible(true);
			}	
		});
		mnUsuario.add(mntmConsultarUsuario);

		JMenuItem mntmListarUsuario = new JMenuItem("Listar Usuario");
		mnUsuario.add(mntmListarUsuario);

		JMenuItem mntmAltaVideo = new JMenuItem("Alta Video");
		mnVideo.add(mntmAltaVideo);

		JMenuItem mntmModificarVideo = new JMenuItem("Modificar Video");
		mnVideo.add(mntmModificarVideo);

		JMenuItem mntmConsultaVideo = new JMenuItem("Consulta Video");
		mnVideo.add(mntmConsultaVideo);

		JMenuItem mntmAltaCategora = new JMenuItem("Alta Categoria");
		mnCategoria.add(mntmAltaCategora);

		JMenuItem mntmConsultaCategoria = new JMenuItem("Consulta Categoria");
		mnCategoria.add(mntmConsultaCategoria);

		JMenuItem mntmListarCategoria = new JMenuItem("Listar Categoria");
		mnCategoria.add(mntmListarCategoria);

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
		
		/************************ ALTA USUARIO ************************/
		mntmAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!ventanasAbiertas())
					frmAltaUsuario.setVisible(true);
			}
		});
		
		/************************ LISTAR USUARIO ************************/
		mntmListarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ale) {
				if (!ventanasAbiertas())
					frmListarUsuarios.cargarDatos();
					frmListarUsuarios.setVisible(true);
			}
		});
		
		/************************ CONSULTA LISTA ************************/
		mntmConsultaLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!ventanasAbiertas())
					frmConsultaLista.setVisible(true);
			}
		});
		
		/************************ QUITAR VIDEO DE LISTA ************************/
		mntmQuitarVideoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!ventanasAbiertas())
					frmQuitarVideo.setVisible(true);
			}
		});

		/************************ AGREGAR VIDEO A LISTA ************************/
		mntmAgregarVideoA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!ventanasAbiertas())
					frmAgregarVideo.setVisible(true);
			}
		});
		
		/************************ MODIFICAR LISTA ************************/
		mntmModificarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!ventanasAbiertas())
					frmModificarListaReproduccion.setVisible(true);
			}
		});
		
		/************************ ALTA LISTA ************************/
		mntmAltaLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!ventanasAbiertas())
					frmCrearListaReproduccion.setVisible(true);
			}
		});
		
		/************************ LISTAR CATEGORIA ************************/
		mntmListarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!ventanasAbiertas()) {
					frmListarCategorias.cargarDatos();
					frmListarCategorias.setVisible(true);
				}
			}
		});
		
		/************************ CONSULTA CATEGORIA ************************/
		mntmConsultaCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!ventanasAbiertas())
					frmConsultaCategoria.setVisible(true);
			}
		});
		
		/************************ ALTA CATEGORIA ************************/
		mntmAltaCategora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!ventanasAbiertas())
					frmAltaCategoria.setVisible(true);
			}

		});
		
		/************************ CARGA DATOS ************************/
		mntmCargaDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!ventanasAbiertas()) {
					cargarDatos();
				}
			}
		});
		
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
	}

	public boolean ventanasAbiertas() {
		for (JInternalFrame frame : frames) {
			if (frame.isVisible()) {
				return true;
			}
		}
		logCarga.setText(null);
		return false;
	}
	
	public void cargarDatos() {
		logCarga.setText("COMIENZA LA CARGA DE DATOS\n");
		this.usuariosCanales.altaUsuario("bobo", "bobeta", "bobon", "bobo@bobetas.com", new Date(), "bobones", false);
	}
}
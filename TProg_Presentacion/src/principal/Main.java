package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import interfaces.*;
import internalFrames.*;

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
	
	private Fabrica fabrica = Fabrica.getFabrica();
	private ICategorias categorias = fabrica.getICategorias();
	private IListas listas = fabrica.getIListas();
	private IUsuariosCanales usuariosCanales = fabrica.getIUsuariosCanales();
	private IVideos videos = fabrica.getIVideos();	

	private AgregarVideo frmAgregarVideo = new AgregarVideo();
	private AltaCategoria frmAltaCategoria = new AltaCategoria();
	private AltaUsuario frmAltaUsuario = new AltaUsuario();
	private ListarUsuarios frmListarUsuarios = new ListarUsuarios();
	private ConsultaCategoria frmConsultaCategoria = new ConsultaCategoria();
	private ConsultaLista frmConsultaLista = new ConsultaLista();
	private CrearListaReproduccion frmCrearListaReproduccion = new CrearListaReproduccion();
	private ListarCategorias frmListarCategorias = new ListarCategorias();
	private ModificarListaReproduccion frmModificarListaReproduccion = new ModificarListaReproduccion();
	private QuitarVideo frmQuitarVideo = new QuitarVideo();
	private VerInformacionUsuario frmVerInfoUsuario = new VerInformacionUsuario();
	private ConsultaUsuario frmConsultaUsuario = new ConsultaUsuario(frmVerInfoUsuario);
	private ConsultaVideo frmConsultaVideo = new ConsultaVideo(videos);
	private AltaVideo frmAltaVideo = new AltaVideo(videos);
	
	private JTextArea logCarga;
	

	public Main() {

		initialize();

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
		frame.getContentPane().add(frmConsultaUsuario);
		frame.getContentPane().add(frmVerInfoUsuario);
		frame.getContentPane().add(frmConsultaVideo);
		frame.getContentPane().add(frmAltaVideo);
		
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
		frames.add(frmConsultaUsuario);
		frames.add(frmVerInfoUsuario);
		frames.add(frmConsultaVideo);
		frames.add(frmAltaVideo);
		//relaciones
		frmVerInfoUsuario.SetPadre(frmConsultaUsuario);
		
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
		
		/************************** CONSULTA USUARIO ******************/
		mntmConsultarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ale) {
				if (!ventanasAbiertas())
					frmConsultaUsuario.cargarDatos();
					frmConsultaUsuario.setVisible(true);
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
					frmConsultaLista.cargarDatos();
					frmConsultaLista.setVisible(true);
			}
		});
		
		/************************ QUITAR VIDEO DE LISTA ************************/
		mntmQuitarVideoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!ventanasAbiertas())
					frmQuitarVideo.cargarDatos();
					frmQuitarVideo.setVisible(true);
			}
		});

		/************************ AGREGAR VIDEO A LISTA ************************/
		mntmAgregarVideoA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!ventanasAbiertas())
					frmAgregarVideo.cargarDatos();
					frmAgregarVideo.setVisible(true);

			}
		});
		
		/************************ MODIFICAR LISTA ************************/
		mntmModificarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!ventanasAbiertas())
					frmModificarListaReproduccion.cargarDatos();
					frmModificarListaReproduccion.setVisible(true);
			}
		});
		
		/************************ ALTA LISTA ************************/
		mntmAltaLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!ventanasAbiertas())
					frmCrearListaReproduccion.cargarDatos();
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
				if (!ventanasAbiertas()){
					frmConsultaCategoria.cargarDatos();
					frmConsultaCategoria.setVisible(true);
				}
					
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
					//cargarDatos();
				}
			}
		});
		
		/*********************** CONSULTA VIDEO **********************/
		mntmConsultaVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!ventanasAbiertas())
					frmConsultaVideo.cargarDatos();
					frmConsultaVideo.setVisible(true);
			}

		});
		
		/*********************** ALTA VIDEO *************************/
		mntmAltaVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!ventanasAbiertas())
					frmAltaVideo.cargarDatos();
					frmAltaVideo.setVisible(true);
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
	
	public void cargarDatos() throws ParseException {
		logCarga.setText("COMIENZA LA CARGA DE DATOS\n");
		//public void altaUsuario(String nickname, String nombre, String apellido, String correo, Date fechaNacimiento, String nombreCanal, boolean visible);
		DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		this.usuariosCanales.altaUsuario("hrubino", "Horacio", "Rubino", "horacio.rubino@guambia.com.uy", format.parse("25/02/1962"), "Canal Horacio", false);
	}
}
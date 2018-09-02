package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
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
	private ModificarVideo frmModificarVideo = new ModificarVideo(videos);
	
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
		frame.getContentPane().add(frmModificarVideo);
		
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
		frames.add(frmModificarVideo);
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
					try {
						logCarga.setText("COMIENZA LA CARGA DE DATOS\n");
						cargarDatos();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
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
		
		/******************* MODIFICAR VIDEO *********************/
		mntmModificarVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!ventanasAbiertas())
					frmModificarVideo.cargarDatos();
					frmModificarVideo.setVisible(true);
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
	
	public void cargarDatos() throws ParseException, IOException {
		DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		String divisor = "\\";
		
		this.usuariosCanales.altaUsuario("hrubino", "Horacio", "Rubino", "horacio.rubino@guambia.com.uy", format.parse("25/02/1962"), "img" + divisor + "horacio.JPG", "Canal Horacio", "El canal Horacio es para publicar contenido divertido", true);
		this.usuariosCanales.altaUsuario("mbusca", "Martín", "Buscaglia", "Martin.bus@agadu.org.uy", format.parse("14/06/1972"), "img" + divisor + "martin.JPG", "El bocha", "Mi canal para colgar cosas", true);
		this.usuariosCanales.altaUsuario("hectorg", "Héctor", "Guido", "hector.gui@elgalpon.org.uy", format.parse("07/01/1954"), "img" + divisor + "null.JPG", "hectorg", "Canal HG", true);
		this.usuariosCanales.altaUsuario("tabarec", "Tabaré", "Cardozo", "tabare.car@agadu.org.uy", format.parse("24/07/1971"), "img" + divisor + "tabare.JPG", "Tabaré", "Mi música e ainda mais", true);
		this.usuariosCanales.altaUsuario("cachilas", "Waldemar \"Cachila\"", "Silva", "Cachila.sil@c1080.org.uy", format.parse("01/01/1947"), "img" + divisor + "cachila.JPG", "El Cachila", "Para juntar cosas", false);
		this.usuariosCanales.altaUsuario("juliob", "Julio", "Bocca", "juliobocca@sodre.com.uy", format.parse("16/03/1967"), "img" + divisor + "null.JPG", "juliob", "Canal de JB", true);
		this.usuariosCanales.altaUsuario("diegop", "Diego", "Parodi", "diego@efectocine.com", format.parse("01/01/1975"), "img" + divisor + "null.JPG", "diegop", "Canal de DP", true);
		this.usuariosCanales.altaUsuario("kairoh", "Kairo", "Herrera", "kairoher@pilsenrock.com.uy", format.parse("25/04/1840"), "img" + divisor + "kairo.JPG", "Kairo música", "Videos de grandes canciones de hoy y siempre", true);
		this.usuariosCanales.altaUsuario("robinh", "Robin", "Henderson", "Robin.h@tinglesa.com.uy", format.parse("03/08/1940"), "img" + divisor + "null.JPG", "robinh", "Henderson", true);
		this.usuariosCanales.altaUsuario("marcelot", "Marcelo", "Tinelli", "marcelot@ideasdelsur.com.ar", format.parse("01/04/1960"), "img" + divisor + "null.JPG", "Tinelli total", "Todo lo que querías y más !", true);
		this.usuariosCanales.altaUsuario("novick", "Edgardo", "Novick", "edgardo@novick.com.uy", format.parse("17/07/1952"), "img" + divisor + "null.JPG", "Con la gente", "Preparando las elecciones", true);
		this.usuariosCanales.altaUsuario("sergiop", "Sergio", "Puglia", "puglia@alpanpan.com.uy", format.parse("28/01/1950"), "img" + divisor + "null.JPG", "Puglia invita", "Programas del ciclo y videos de cocina masterchef", true);
		this.usuariosCanales.altaUsuario("chino", "Alvaro", "Recoba", "chino@trico.org.uy", format.parse("17/03/1976"), "img" + divisor + "recoba.JPG", "Chino Recoba", "Canal de goles con Nacional ", false);
		this.usuariosCanales.altaUsuario("tonyp", "Antonio", "Pacheco", "eltony@manya.org.uy", format.parse("14/02/1955"), "img" + divisor + "pacheco.JPG", "Tony Pacheco", "Todos los goles con Peñarol", false);
		this.usuariosCanales.altaUsuario("nicoJ", "Nicolás", "Jodal", "jodal@artech.com.uy", format.parse("09/08/1960"), "img" + divisor + "null.JPG", "Desde Genexus", "Canal información C y T", true);
		
		this.usuariosCanales.seguir("hrubino", "hectorg");
		this.usuariosCanales.seguir("hrubino", "hectorg");
		this.usuariosCanales.seguir("mbusca", "tabarec");
		this.usuariosCanales.seguir("mbusca", "cachilas");
		this.usuariosCanales.seguir("mbusca", "kairoh");
		this.usuariosCanales.seguir("hectorg", "mbusca");
		this.usuariosCanales.seguir("hectorg", "juliob");
		this.usuariosCanales.seguir("tabarec", "hrubino");
		this.usuariosCanales.seguir("tabarec", "cachilas");
		this.usuariosCanales.seguir("cachilas", "hrubino");
		this.usuariosCanales.seguir("juliob", "mbusca");
		this.usuariosCanales.seguir("juliob", "diegop");
		this.usuariosCanales.seguir("diegop", "hectorg");
		this.usuariosCanales.seguir("kairoh", "sergiop");
		this.usuariosCanales.seguir("robinh", "hectorg");
		this.usuariosCanales.seguir("robinh", "juliob");
		this.usuariosCanales.seguir("robinh", "diegop");
		this.usuariosCanales.seguir("marcelot", "cachilas");
		this.usuariosCanales.seguir("marcelot", "juliob");
		this.usuariosCanales.seguir("marcelot", "kairoh");
		this.usuariosCanales.seguir("novick", "hrubino");
		this.usuariosCanales.seguir("novick", "cachilas");
		this.usuariosCanales.seguir("novick", "juliob");
		this.usuariosCanales.seguir("sergiop", "mbusca");
		this.usuariosCanales.seguir("sergiop", "juliob");
		this.usuariosCanales.seguir("sergiop", "kairoh");
		this.usuariosCanales.seguir("chino", "tonyp");
		this.usuariosCanales.seguir("tonyp", "chino");
		this.usuariosCanales.seguir("nicoJ", "diegop");
		
		try {
			this.categorias.altaCategoria("Música");
			this.categorias.altaCategoria("Deporte");
			this.categorias.altaCategoria("Carnaval");
			this.categorias.altaCategoria("Noticias");
			this.categorias.altaCategoria("Entretenimiento");
			this.categorias.altaCategoria("Comida");
			this.categorias.altaCategoria("Videojuegos");
			this.categorias.altaCategoria("Ciencia y Tecnología");
			this.categorias.altaCategoria("ONG y activismo");
			this.categorias.altaCategoria("Gente y blogs");
			this.categorias.altaCategoria("Mascotas y animales");
			this.categorias.altaCategoria("Viajes y eventos");
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.videos.altaVideo("tabarec", "Locura celeste", "XXXXX", Duration.parse("PT1H2M2S"), "https://youtu.be/PAfbzKcePx0", "Música", format.parse("99/99/9999"), false);
		this.videos.altaVideo("tabarec", "Locura celeste", "XXXXX", Duration.parse("PT2S"), "https://youtu.be/PAfbzKcePx0", "Música", format.parse("99/99/9999"), false);
		this.videos.altaVideo("tabarec", "Locura celeste", "XXXXX", Duration.parse("PT2S"), "https://youtu.be/PAfbzKcePx0", "Música", format.parse("99/99/9999"), false);
		this.videos.altaVideo("tabarec", "Locura celeste", "XXXXX", Duration.parse("PT2S"), "https://youtu.be/PAfbzKcePx0", "Música", format.parse("99/99/9999"), false);
		this.videos.altaVideo("tabarec", "Locura celeste", "XXXXX", Duration.parse("PT2S"), "https://youtu.be/PAfbzKcePx0", "Música", format.parse("99/99/9999"), false);
		this.videos.altaVideo("tabarec", "Locura celeste", "XXXXX", Duration.parse("PT2S"), "https://youtu.be/PAfbzKcePx0", "Música", format.parse("99/99/9999"), false);
		this.videos.altaVideo("tabarec", "Locura celeste", "XXXXX", Duration.parse("PT2S"), "https://youtu.be/PAfbzKcePx0", "Música", format.parse("99/99/9999"), false);
		this.videos.altaVideo("tabarec", "Locura celeste", "XXXXX", Duration.parse("PT2S"), "https://youtu.be/PAfbzKcePx0", "Música", format.parse("99/99/9999"), false);
		this.videos.altaVideo("tabarec", "Locura celeste", "XXXXX", Duration.parse("PT2S"), "https://youtu.be/PAfbzKcePx0", "Música", format.parse("99/99/9999"), false);
		this.videos.altaVideo("tabarec", "Locura celeste", "XXXXX", Duration.parse("PT2S"), "https://youtu.be/PAfbzKcePx0", "Música", format.parse("99/99/9999"), false);
		this.videos.altaVideo("tabarec", "Locura celeste", "XXXXX", Duration.parse("PT2S"), "https://youtu.be/PAfbzKcePx0", "Música", format.parse("99/99/9999"), false);
		this.videos.altaVideo("tabarec", "Locura celeste", "XXXXX", Duration.parse("PT2S"), "https://youtu.be/PAfbzKcePx0", "Música", format.parse("99/99/9999"), false);
		this.videos.altaVideo("tabarec", "Locura celeste", "XXXXX", Duration.parse("PT2S"), "https://youtu.be/PAfbzKcePx0", "Música", format.parse("99/99/9999"), false);
		this.videos.altaVideo("tabarec", "Locura celeste", "XXXXX", Duration.parse("PT2S"), "https://youtu.be/PAfbzKcePx0", "Música", format.parse("99/99/9999"), false);
		this.videos.altaVideo("tabarec", "Locura celeste", "XXXXX", Duration.parse("PT2S"), "https://youtu.be/PAfbzKcePx0", "Música", format.parse("99/99/9999"), false);
		this.videos.altaVideo("tabarec", "Locura celeste", "XXXXX", Duration.parse("PT2S"), "https://youtu.be/PAfbzKcePx0", "Música", format.parse("99/99/9999"), false);
		
		//this.listas.altaListaDefecto(nombre)
		
		//this.listas.altaListaParticular(nombre, categoria, visibilidad)
		
		//this.listas.agregarVideo(nombreLista, nombreVideo)
		
		//this.usuariosCanales.agregarVideo(nick, nombreVideo)
		
		//this.videos.comentar(nombreVideo, autor, comentarioPadre, comentario, fecha)
		
		//this.videos.calificar(nombreVideo, autor, meGusta)
	}
}
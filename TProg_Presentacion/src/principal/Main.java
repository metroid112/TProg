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
import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import interfaces.Fabrica;
import interfaces.ICategorias;
import interfaces.IListas;
import interfaces.IUsuariosCanales;
import interfaces.IVideos;
import internalFrames.AgregarVideo;
import internalFrames.AltaCategoria;
import internalFrames.AltaUsuario;
import internalFrames.AltaVideo;
import internalFrames.ConsultaCategoria;
import internalFrames.ConsultaLista;
import internalFrames.ConsultaUsuario;
import internalFrames.ConsultaVideo;
import internalFrames.CrearListaReproduccion;
import internalFrames.ListarCategorias;
import internalFrames.ListarUsuarios;
import internalFrames.ModificarListaReproduccion;
import internalFrames.ModificarVideo;
import internalFrames.QuitarVideo;
import internalFrames.VerInformacionUsuario;

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

  private ICategorias categorias = Fabrica.getICategorias();
  private IListas listas = Fabrica.getIListas();
  private IUsuariosCanales usuariosCanales = Fabrica.getIUsuariosCanales();
  private IVideos videos = Fabrica.getIVideos();

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
    frmVerInfoUsuario.SetPadre(frmConsultaUsuario);

    for (JInternalFrame frame : frames) {
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
        if (!ventanasAbiertas()) {
          frmAltaUsuario.cargarDatos();
          frmAltaUsuario.setVisible(true);
        }
      }
    });

    /************************** CONSULTA USUARIO ******************/
    mntmConsultarUsuario.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ale) {
        if (!ventanasAbiertas()) {
          frmConsultaUsuario.cargarDatos();
          frmConsultaUsuario.setVisible(true);
        }
      }
    });

    /************************ LISTAR USUARIO ************************/
    mntmListarUsuario.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ale) {
        if (!ventanasAbiertas()) {
          frmListarUsuarios.cargarDatos();
          frmListarUsuarios.setVisible(true);
        }
      }
    });

    /************************ CONSULTA LISTA ************************/
    mntmConsultaLista.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (!ventanasAbiertas()) {
          frmConsultaLista.cargarDatos();
          frmConsultaLista.setVisible(true);
        }
      }
    });

    /************************ QUITAR VIDEO DE LISTA ************************/
    mntmQuitarVideoDe.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (!ventanasAbiertas()) {
          frmQuitarVideo.cargarDatos();
          frmQuitarVideo.setVisible(true);
        }
      }
    });

    /************************ AGREGAR VIDEO A LISTA ************************/
    mntmAgregarVideoA.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (!ventanasAbiertas()) {
          frmAgregarVideo.cargarDatos();
          frmAgregarVideo.setVisible(true);
        }

      }
    });

    /************************ MODIFICAR LISTA ************************/
    mntmModificarLista.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        if (!ventanasAbiertas()) {
          frmModificarListaReproduccion.cargarDatos();
          frmModificarListaReproduccion.setVisible(true);
        }
      }
    });

    /************************ ALTA LISTA ************************/
    mntmAltaLista.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        if (!ventanasAbiertas()) {
          frmCrearListaReproduccion.cargarDatos();
          frmCrearListaReproduccion.setVisible(true);
        }

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
        if (!ventanasAbiertas()) {
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
            logCarga.setText("DATOS CARGADOS");
            mntmCargaDatos.setEnabled(false);
          } catch (Exception e1) {
            e1.printStackTrace();
          }
        }
      }
    });

    /*********************** CONSULTA VIDEO **********************/
    mntmConsultaVideo.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (!ventanasAbiertas()) {
          frmConsultaVideo.cargarDatos();
          frmConsultaVideo.setVisible(true);
        }
      }

    });

    /*********************** ALTA VIDEO *************************/
    mntmAltaVideo.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (!ventanasAbiertas()) {
          frmAltaVideo.cargarDatos();
          frmAltaVideo.setVisible(true);
        }
      }

    });

    /******************* MODIFICAR VIDEO *********************/
    mntmModificarVideo.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (!ventanasAbiertas()) {
          frmModificarVideo.cargarDatos();
          frmModificarVideo.setVisible(true);
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

  public void cargarDatos() throws ParseException, IOException {
    DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
    String divisor = "//";

    this.usuariosCanales.altaUsuario("hrubino", "Horacio", "Rubino",
        "horacio.rubino@guambia.com.uy", format.parse("25/02/1962"),
        "img" + divisor + "horacio.jpg", "Canal Horacio",
        "El canal Horacio es para publicar contenido divertido", "Sin categoria", true);
    this.usuariosCanales.altaUsuario("mbusca", "Martin", "Buscaglia", "Martin.bus@agadu.org.uy",
        format.parse("14/06/1972"), "img" + divisor + "martin.jpg", "El bocha",
        "Mi canal para colgar cosas", "Sin categoria", true);
    this.usuariosCanales.altaUsuario("hectorg", "H�ctor", "Guido", "hector.gui@elgalpon.org.uy",
        format.parse("07/01/1954"), "img" + divisor + "null.jpg", "hectorg", "Canal HG",
        "Sin categoria", true);
    this.usuariosCanales.altaUsuario("tabarec", "Tabare", "Cardozo", "tabare.car@agadu.org.uy",
        format.parse("24/07/1971"), "img" + divisor + "tabare.jpg", "Tabar�",
        "Mi musica e ainda mais", "Sin categoria", true);
    this.usuariosCanales.altaUsuario("cachilas", "Waldemar \"Cachila\"", "Silva",
        "Cachila.sil@c1080.org.uy", format.parse("01/01/1947"), "img" + divisor + "cachila.jpg",
        "El Cachila", "Para juntar cosas", "Sin categoria", false);
    this.usuariosCanales.altaUsuario("juliob", "Julio", "Bocca", "juliobocca@sodre.com.uy",
        format.parse("16/03/1967"), "img" + divisor + "null.jpg", "juliob", "Canal de JB",
        "Sin categoria", true);
    this.usuariosCanales.altaUsuario("diegop", "Diego", "Parodi", "diego@efectocine.com",
        format.parse("01/01/1975"), "img" + divisor + "null.jpg", "diegop", "Canal de DP",
        "Sin categoria", true);
    this.usuariosCanales.altaUsuario("kairoh", "Kairo", "Herrera", "kairoher@pilsenrock.com.uy",
        format.parse("25/04/1840"), "img" + divisor + "kairo.jpg", "Kairo musica",
        "Videos de grandes canciones de hoy y siempre", "Sin categoria", true);
    this.usuariosCanales.altaUsuario("robinh", "Robin", "Henderson", "Robin.h@tinglesa.com.uy",
        format.parse("03/08/1940"), "img" + divisor + "null.jpg", "robinh", "Henderson",
        "Sin categoria", true);
    this.usuariosCanales.altaUsuario("marcelot", "Marcelo", "Tinelli",
        "marcelot@ideasdelsur.com.ar", format.parse("01/04/1960"), "img" + divisor + "null.jpg",
        "Tinelli total", "Todo lo que querias y m�s !", "Sin categoria", true);
    this.usuariosCanales.altaUsuario("novick", "Edgardo", "Novick", "edgardo@novick.com.uy",
        format.parse("17/07/1952"), "img" + divisor + "null.jpg", "Con la gente",
        "Preparando las elecciones", "Sin categoria", true);
    this.usuariosCanales.altaUsuario("sergiop", "Sergio", "Puglia", "puglia@alpanpan.com.uy",
        format.parse("28/01/1950"), "img" + divisor + "null.jpg", "Puglia invita",
        "Programas del ciclo y videos de cocina masterchef", "Sin categoria", true);
    this.usuariosCanales.altaUsuario("chino", "Alvaro", "Recoba", "chino@trico.org.uy",
        format.parse("17/03/1976"), "img" + divisor + "recoba.jpg", "Chino Recoba",
        "Canal de goles con Nacional ", "Sin categoria", false);
    this.usuariosCanales.altaUsuario("tonyp", "Antonio", "Pacheco", "eltony@manya.org.uy",
        format.parse("14/02/1955"), "img" + divisor + "pacheco.jpg", "Tony Pacheco",
        "Todos los goles con Pe�arol", "Sin categoria", false);
    this.usuariosCanales.altaUsuario("nicoJ", "Nicolas", "Jodal", "jodal@artech.com.uy",
        format.parse("09/08/1960"), "img" + divisor + "null.jpg", "Desde Genexus",
        "Canal informacion C y T", "Sin categoria", true);

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
      this.categorias.altaCategoria("Musica");
      this.categorias.altaCategoria("Deporte");
      this.categorias.altaCategoria("Carnaval");
      this.categorias.altaCategoria("Noticias");
      this.categorias.altaCategoria("Entretenimiento");
      this.categorias.altaCategoria("Comida");
      this.categorias.altaCategoria("Videojuegos");
      this.categorias.altaCategoria("Ciencia y Tecnologia");
      this.categorias.altaCategoria("ONG y activismo");
      this.categorias.altaCategoria("Gente y blogs");
      this.categorias.altaCategoria("Mascotas y animales");
      this.categorias.altaCategoria("Viajes y eventos");
    } catch (Exception e) {
      e.printStackTrace();
    }

    this.videos.altaVideo("hectorg", "100 a�os de FING",
        "Del Ciclo m�s Universidad realizado por la UdelaR, compartimos con ustedes un audiovisual realizado en 2016 por los 100 a�os de la denominaci�n Facultad de Ingenier�a.\nExtra�do del canal Teleuniversitaria UdelaR",
        Duration.parse("PT6M26S"), "https://youtu.be/peGS4TBxSaI", "Noticias",
        format.parse("03/08/2017"), true);
    this.videos.altaVideo("hectorg", "50 a�os del InCo",
        "50 a�os del Instituto de Computaci�n. Facultad de Ingenier�a. UDELAR. 22 de noviembre 2017.\nLa mesa de apertura estuvo integrada por Simon, el rector de la Universidad de la Rep�blica (Udelar), Roberto Markarian; la ministra de Industria, Energ�a y Miner�a, Carolina Cosse; el presidente de la C�mara Uruguaya de Tecnolog�as de la Informaci�n (CUTI), Leonardo Loureiro, y el director del Inco, Diego Vallespir.",
        Duration.parse("PT27M22S"), "https://youtu.be/GzOJSk4urlM", "Noticias",
        format.parse("24/11/2017"), true);
    this.videos.altaVideo("hectorg", "Ingenieria de Muestra 2017",
        "La muestra m�s grande de la ingenier�a nacional se realiz� el jueves 19, viernes 20 y s�bado 21 de octubre de 2017. Ingenier�a deMuestra fue organizada por la Facultad de Ingenier�a de la Universidad de la Rep�blica y su Fundaci�n Julio Ricaldoni.",
        Duration.parse("PT1M"), "https://youtu.be/RnaYRA1k5j4", "Noticias",
        format.parse("25/10/2017"), true);
    this.videos.altaVideo("tabarec", "Locura celeste",
        "Tema Oficial de la cobertura celeste de Monte Carlo Televisi�n Canal 4 para el Mundial de Futbol FIFA Rusia 2018.",
        Duration.parse("PT3M4S"), "https://youtu.be/PAfbzKcePx0", "Musica",
        format.parse("05/06/2018"), false);
    this.videos.altaVideo("tabarec", "Ni�o payaso", "", Duration.parse("PT4M18S"),
        "https://youtu.be/K-uEIUnyZPg", "Musica", format.parse("20/10/2016"), false);
    this.videos.altaVideo("tabarec", "Pacheco goles mas recordados", "", Duration.parse("PT5M48S"),
        "https://youtu.be/wlEd6-HsIxI", "Deporte", format.parse("05/07/2013"), false);
    this.videos.altaVideo("cachilas", "Locura celeste",
        "Tema Oficial de la cobertura celeste de Monte Carlo Televisi�n Canal 4 para el Mundial de Futbol FIFA Rusia 2018.",
        Duration.parse("PT3M4S"), "https://youtu.be/PAfbzKcePx0", "Musica",
        format.parse("05/06/2018"), false);
    this.videos.altaVideo("cachilas", "Ni�o payaso", "", Duration.parse("PT4M18S"),
        "https://youtu.be/K-uEIUnyZPg", "Musica", format.parse("20/10/2016"), false);
    this.videos.altaVideo("cachilas", "Etapa A contramano Liguilla", "", Duration.parse("PT57M15S"),
        "https://youtu.be/Es6GRMHXeCQ", "Carnaval", format.parse("17/12/2015"), false);
    this.videos.altaVideo("cachilas", "Etapa Don Timoteo Liguilla", "", Duration.parse("PT51M38S"),
        "https://youtu.be/I_spHBU9ZsI", "Carnaval", format.parse("18/12/2015"), false);
    this.videos.altaVideo("cachilas", "Recoba 20 mejores goles", "My Favorites\n\n\"El Chino\"",
        Duration.parse("PT13M36S"), "https://youtu.be/Gy3fZhWdLEQ", "Deporte",
        format.parse("14/11/2011"), false);
    this.videos.altaVideo("juliob", "Sweet child'o mine",
        "#AppetiteForDestruction: The Debut Album, Remastered and Expanded. Available now as Box Set, Super Deluxe, Double LP, and Double CD here: https://lnk.to/AppetiteForDestruction... \n\nApple Music: https://lnk.to/AppetiteForDestruction... \niTunes: https://lnk.to/AppetiteForDestruction... \nSpotify: https://lnk.to/AppetiteForDestruction... \nAmazon: https://lnk.to/AppetiteForDestruction... \nGoogle Play: https://lnk.to/AppetiteForDestruction... \n\nSite: https://www.gunsnroses.com/ \nFacebook: https://www.facebook.com/gunsnroses\nTwitter: https://twitter.com/gunsnroses \nInstagram: https://www.instagram.com/gunsnroses \n\nMusic video by Guns N' Roses performing Sweet Child O' Mine. YouTube view counts pre-VEVO: 2,418,311. (C) 1987 Guns N' Roses under exclusive license to Geffen Records\n\n#GunsNRoses #SweetChildOMine #vevo #rockandroll #vevoofficial",
        Duration.parse("PT5M2S"), "https://youtu.be/1w7OgIMMRc4", "Musica",
        format.parse("24/12/2009"), true);
    this.videos.altaVideo("juliob", "Thriller",
        "Listen to more Michael Jackson: https://MichaelJackson.lnk.to/Stream!to\n\nMichael Jackson's 14-minute short film \"Thriller\" revolutionized the music video genre forever. Hailed as the greatest music video of all time by MTV, VH1, Rolling Stone and others, \"Thriller,\" directed by John Landis, is also the only music video selected to be included in the Library of Congress' prestigious National Film Registry.\n\nBuy/Listen to Thriller 25: \nAmazon - http://smarturl.it/mj_thriller25_amzn...  \niTunes - http://smarturl.it/MJ_T25DE_OS?IQid=y...  \nOfficial Store - http://smarturl.it/MJ_T25DE_OS?IQid=y...  \nSpotify - http://smarturl.it/mj_thriller25_sptf...  \n\nWritten by Rod Temperton\nProduced by Quincy Jones for Quincy Jones Productions\nFrom the album Thriller, released November 30, 1982\nReleased as a single January 23, 1984\n\nTHE SHORT FILM\nDirector: John Landis\nPrimary Production Location: Los Angeles, California\n\nMichael Jackson's short film for \"Thriller\" was the third of three short films produced for recordings from Thriller, which continues its reign as the biggest selling album of all time with worldwide sales in excess of 105 million as of June 1, 2016 and in December 2015 became the first ever album to be awarded triple diamond status (i.e.: sales in excess of 30 million) by the RIAA for US sales alone. The \"Thriller\" single reached No. 1 in four countries in 1984, topping the U.S. Billboard Hot Dance Club Play chart as well as charts in Spain, France and Belgium. The song peaked at No. 4 on the Billboard Hot 100, making Thriller the first album to feature seven Top 10 singles. The Recording Industry Association of America certified \"Thriller\" Gold and Platinum on December 4, 1989. \n\nThe groundbreaking short films for the Thriller album, starting with \"Billie Jean,\" following up with \"Beat It\" and culminating with the epic, nearly 14-minute \"Thriller,\" truly expanded the possibilities of \"music video\" as art form. \"I wanted something that would glue you to the set, something you'd want to watch over and over,\" Michael wrote in his 1988 memoir Moonwalk. \"I wanted to be a pioneer in this relatively new medium and make the best short music movies we could make.\"\n\nIn the short film\'s extended prologue, Michael\'s moonlit date with his girlfriend (played by model Ola Ray) is interrupted by his sudden transformation into a howling werewolf. While the \"real\" Michael and Ola, observing the scene in a movie theater, walk home from the their date, Michael teases her by singing the verses of \"Thriller.\"\n\nFollow the Official Michael Jackson Accounts: \nFacebook - http://smarturl.it/mj_facebook?IQid=y...  \nTwitter - http://smarturl.it/mj_twitter?IQid=yt...  \nSpotify - http://smarturl.it/mj_spotify?IQid=yt...  \nNewsletter - http://smarturl.it/mj_newsletter?IQid...  \nYouTube - http://smarturl.it/mj_youtube?IQid=yt...  \nWebsite - http://smarturl.it/mj_website?IQid=yt...",
        Duration.parse("PT13M42S"), "https://youtu.be/PAfbzKcePx0", "Musica",
        format.parse("02/10/2009"), false);
    this.videos.altaVideo("juliob", "Show de goles", "TORNEO CLAUSURA 2018\nFECHA 1.....",
        Duration.parse("PT4M23S"), "https://youtu.be/g46w4_kD_lA", "Deporte",
        format.parse("23/07/2018"), true);
    this.videos.altaVideo("juliob", "Inauguracion Estadio Pe�arol",
        "Recordemos la ceremonia de inauguraci�n del Estadio de Pe�arol.\nLlamado \"Estadio Campe�n del Siglo\".",
        Duration.parse("PT3H27M26S"), "https://youtu.be/U6XPJ8Vz72A", "Deporte",
        format.parse("04/04/2016"), true);
    this.videos.altaVideo("kairoh", "Sweet child'o mine",
        "#AppetiteForDestruction: The Debut Album, Remastered and Expanded. Available now as Box Set, Super Deluxe, Double LP, and Double CD here: https://lnk.to/AppetiteForDestruction... \n\nApple Music: https://lnk.to/AppetiteForDestruction... \niTunes: https://lnk.to/AppetiteForDestruction... \nSpotify: https://lnk.to/AppetiteForDestruction... \nAmazon: https://lnk.to/AppetiteForDestruction... \nGoogle Play: https://lnk.to/AppetiteForDestruction... \n\nSite: https://www.gunsnroses.com/ \nFacebook: https://www.facebook.com/gunsnroses\nTwitter: https://twitter.com/gunsnroses \nInstagram: https://www.instagram.com/gunsnroses \n\nMusic video by Guns N' Roses performing Sweet Child O' Mine. YouTube view counts pre-VEVO: 2,418,311. (C) 1987 Guns N' Roses under exclusive license to Geffen Records\n\n#GunsNRoses #SweetChildOMine #vevo #rockandroll #vevoofficial",
        Duration.parse("PT5M2S"), "https://youtu.be/1w7OgIMMRc4", "Musica",
        format.parse("24/12/2009"), true);
    this.videos.altaVideo("kairoh", "Dancing in the Dark",
        "Bruce Springsteen's official music video for \'Dancing In The Dark\'. Click to listen to Bruce Springsteen on Spotify: http://smarturl.it/BSpringSpot?IQid=B...",
        Duration.parse("PT3M58S"), "https://youtu.be/129kuDCQtHs", "Musica",
        format.parse("03/10/2009"), true);
    this.videos.altaVideo("kairoh", "Thriller",
        "Listen to more Michael Jackson: https://MichaelJackson.lnk.to/Stream!to\n\nMichael Jackson's 14-minute short film \"Thriller\" revolutionized the music video genre forever. Hailed as the greatest music video of all time by MTV, VH1, Rolling Stone and others, \"Thriller,\" directed by John Landis, is also the only music video selected to be included in the Library of Congress' prestigious National Film Registry.\n\nBuy/Listen to Thriller 25: \nAmazon - http://smarturl.it/mj_thriller25_amzn...  \niTunes - http://smarturl.it/MJ_T25DE_OS?IQid=y...  \nOfficial Store - http://smarturl.it/MJ_T25DE_OS?IQid=y...  \nSpotify - http://smarturl.it/mj_thriller25_sptf...  \n\nWritten by Rod Temperton\nProduced by Quincy Jones for Quincy Jones Productions\nFrom the album Thriller, released November 30, 1982\nReleased as a single January 23, 1984\n\nTHE SHORT FILM\nDirector: John Landis\nPrimary Production Location: Los Angeles, California\n\nMichael Jackson's short film for \"Thriller\" was the third of three short films produced for recordings from Thriller, which continues its reign as the biggest selling album of all time with worldwide sales in excess of 105 million as of June 1, 2016 and in December 2015 became the first ever album to be awarded triple diamond status (i.e.: sales in excess of 30 million) by the RIAA for US sales alone. The \"Thriller\" single reached No. 1 in four countries in 1984, topping the U.S. Billboard Hot Dance Club Play chart as well as charts in Spain, France and Belgium. The song peaked at No. 4 on the Billboard Hot 100, making Thriller the first album to feature seven Top 10 singles. The Recording Industry Association of America certified \"Thriller\" Gold and Platinum on December 4, 1989. \n\nThe groundbreaking short films for the Thriller album, starting with \"Billie Jean,\" following up with \"Beat It\" and culminating with the epic, nearly 14-minute \"Thriller,\" truly expanded the possibilities of \"music video\" as art form. \"I wanted something that would glue you to the set, something you'd want to watch over and over,\" Michael wrote in his 1988 memoir Moonwalk. \"I wanted to be a pioneer in this relatively new medium and make the best short music movies we could make.\"\n\nIn the short film\'s extended prologue, Michael\'s moonlit date with his girlfriend (played by model Ola Ray) is interrupted by his sudden transformation into a howling werewolf. While the \"real\" Michael and Ola, observing the scene in a movie theater, walk home from the their date, Michael teases her by singing the verses of \"Thriller.\"\n\nFollow the Official Michael Jackson Accounts: \nFacebook - http://smarturl.it/mj_facebook?IQid=y...  \nTwitter - http://smarturl.it/mj_twitter?IQid=yt...  \nSpotify - http://smarturl.it/mj_spotify?IQid=yt...  \nNewsletter - http://smarturl.it/mj_newsletter?IQid...  \nYouTube - http://smarturl.it/mj_youtube?IQid=yt...  \nWebsite - http://smarturl.it/mj_website?IQid=yt...",
        Duration.parse("PT13M42S"), "https://youtu.be/sOnqjkJTMaA", "Musica",
        format.parse("02/10/2009"), true);
    this.videos.altaVideo("chino", "Recoba 20 mejores goles", "My Favorites\n\n\"El Chino\"",
        Duration.parse("PT13M36S"), "https://youtu.be/Gy3fZhWdLEQ", "Deporte",
        format.parse("14/11/2011"), false);
    this.videos.altaVideo("tonyp", "Pacheco goles mas recordados", "", Duration.parse("PT5M48S"),
        "https://youtu.be/wlEd6-HsIxI", "Deporte", format.parse("05/07/2013"), false);
    this.videos.altaVideo("nicoJ", "Entrevista a director CUTI",
        "Segunda parte de la entrevista realizada por la periodista Paula Echevarr�a al director de CUTI",
        Duration.parse("PT5M39S"), "https://youtu.be/Eq5uBEzI6qs", "Ciencia y Tecnologia",
        format.parse("03/04/2017"), true);
    this.videos.altaVideo("nicoJ", "Ventana al futuro Uruguay y deficit de ingenieros",
        "VEA ESTE CONTENIDO EN EnPerspectiva.net: http://www.enperspectiva.net/en-persp...\n\nEn Uruguay hay un ingeniero por cada tres abogados y cada seis m�dicos. Los datos se desprenden del Panorama de la Educaci�n 2014 del anuario del Ministerio de Educaci�n y Cultura. Ese a�o egresaron de la Universidad de la Rep�blica 348 ingenieros, una cifra que supone un leve aumento con respecto a los anteriores.\n\nSin embargo, seg�n sostienen desde la Facultad de Ingenier�a, ese n�mero sigue siendo insuficiente y el d�ficit de profesionales puede significar una traba para el desarrollo del pa�s. De ese desaf�o hablaremos en esta nueva entrega de Ventana al Futuro; para eso nos acompa�a la decana de esa casa de estudios y presidente de la Fundaci�n Julio Ricaldoni, Mar�a Sim�n.",
        Duration.parse("PT192M1S"), "https://youtu.be/zBR2pnASlQE", "Ciencia y Tecnologia",
        format.parse("20/07/2016"), true);

    try {
      this.listas.altaListaDefecto("Escuchar mas tarde");
      this.listas.altaListaDefecto("Deporte total");
      this.listas.altaListaDefecto("Novedades generales");
    } catch (Exception e) {
      e.printStackTrace();
    }

    try {
      this.listas.altaListaParticular("Nostalgia", "kairoh", true);
      this.listas.altaListaParticular("De fiesta", "tabarec", false);
      this.listas.altaListaParticular("Novedades FING", "hectorg", true);
      this.listas.altaListaParticular("De todo un poco", "cachilas", false);
      this.listas.altaListaParticular("Noticias y CYT", "nicoJ", true);
      this.listas.altaListaParticular("Solo deportes", "juliob", true);
    } catch (Exception e) {
      e.printStackTrace();
    }

    this.listas.agregarVideoLista("juliob", "Sweet child'o mine", "kairoh", "Nostalgia", false);
    this.listas.agregarVideoLista("kairoh", "Sweet child'o mine", "kairoh", "Nostalgia", false);
    this.listas.agregarVideoLista("kairoh", "Dancing in the Dark", "kairoh", "Nostalgia", false);
    this.listas.agregarVideoLista("kairoh", "Thriller", "kairoh", "Nostalgia", false);
    this.listas.agregarVideoLista("juliob", "Thriller", "kairoh", "Nostalgia", false);
    this.listas.agregarVideoLista("tabarec", "Locura celeste", "tabarec", "De fiesta", false);
    this.listas.agregarVideoLista("cachilas", "Locura celeste", "tabarec", "De fiesta", false);
    this.listas.agregarVideoLista("tabarec", "Ni�o payaso", "tabarec", "De fiesta", false);
    this.listas.agregarVideoLista("cachilas", "Ni�o payaso", "tabarec", "De fiesta", false);
    this.listas.agregarVideoLista("cachilas", "Etapa Don Timoteo Liguilla", "tabarec", "De fiesta",
        false);
    this.listas.agregarVideoLista("hectorg", "100 a�os de FING", "hectorg", "Novedades FING",
        false);
    this.listas.agregarVideoLista("hectorg", "50 a�os del InCo", "hectorg", "Novedades FING",
        false);
    this.listas.agregarVideoLista("hectorg", "Ingenieria de Muestra 2017", "hectorg",
        "Novedades FING", false);
    this.listas.agregarVideoLista("tabarec", "Locura celeste", "cachilas", "De todo un poco",
        false);
    this.listas.agregarVideoLista("cachilas", "Locura celeste", "cachilas", "De todo un poco",
        false);
    this.listas.agregarVideoLista("tabarec", "Ni�o payaso", "cachilas", "De todo un poco", false);
    this.listas.agregarVideoLista("cachilas", "Ni�o payaso", "cachilas", "De todo un poco",
        false);
    this.listas.agregarVideoLista("cachilas", "Etapa A contramano Liguilla", "cachilas",
        "De todo un poco", false);
    this.listas.agregarVideoLista("cachilas", "Etapa Don Timoteo Liguilla", "cachilas",
        "De todo un poco", false);
    this.listas.agregarVideoLista("juliob", "Inauguracion Estadio Pe�arol", "cachilas",
        "De todo un poco", false);
    this.listas.agregarVideoLista("hectorg", "Ingenieria de Muestra 2017", "nicoJ",
        "Noticias y CYT", false);
    this.listas.agregarVideoLista("nicoJ", "Ventana al futuro Uruguay y deficit de ingenieros",
        "nicoJ", "Noticias y CYT", false);
    this.listas.agregarVideoLista("juliob", "Show de goles", "juliob", "Solo deportes", false);
    this.listas.agregarVideoLista("juliob", "Inauguracion Estadio Pe�arol", "juliob",
        "Solo deportes", false);

    DateFormat formatComentario = new SimpleDateFormat("dd/mm/yyyy HH:mm");
    this.usuariosCanales.comentarVideo("Fue un gran evento",
        formatComentario.parse("05/12/2017 14:35"), "nicoJ", "50 a�os del InCo", "hectorg");
    this.usuariosCanales.responderComentario(
        "Para el proximo aniversario ofrezco vamo' con los Momo", format.parse("08/12/2017 01:47"),
        "hrubino", "50 a�os del InCo", "hectorg", 0);
    this.usuariosCanales.responderComentario("Yo ofrezco a la banda tb",
        format.parse("10/12/2017 17:09"), "tabarec", "50 a�os del InCo", "hectorg", 1);
    this.usuariosCanales.comentarVideo("Felicitaciones FING!!!",
        formatComentario.parse("07/09/2017 04:56"), "nicoJ", "100 a�os de FING", "hectorg");
    this.usuariosCanales.comentarVideo("Un gusto cubrir eventos como este.",
        formatComentario.parse("23/10/2017 12:58"), "kairoh", "Ingenieria de Muestra 2017",
        "hectorg");
    this.usuariosCanales.comentarVideo("Pe�arol pe�arol!!!",
        formatComentario.parse("14/11/2016 05:34"), "kairoh", "Inauguracion Estadio Pe�arol",
        "juliob");
    this.usuariosCanales.comentarVideo("Rock and Rolllll",
        formatComentario.parse("30/10/2017 02:17"), "marcelot", "Sweet child'o mine", "kairoh");
    this.usuariosCanales.comentarVideo("Rock and Rolllll",
        formatComentario.parse("30/10/2017 02:17"), "marcelot", "Sweet child'o mine", "juliob");
    this.usuariosCanales.comentarVideo("Anoche exploto!!!",
        formatComentario.parse("25/08/2018 18:00"), "marcelot", "Dancing in the Dark", "kairoh");
    this.usuariosCanales.comentarVideo("Me encanta este tema",
        formatComentario.parse("11/09/2017 03:45"), "marcelot", "Locura celeste", "tabarec");
    this.usuariosCanales.comentarVideo("Me encanta este tema",
        formatComentario.parse("11/09/2017 03:45"), "marcelot", "Locura celeste", "cachilas");
    this.usuariosCanales.responderComentario("Gracias Marce ;)",
        formatComentario.parse("15/09/2018 12:29"), "tabarec", "Locura celeste", "tabarec", 9);
    this.usuariosCanales.responderComentario("Gracias Marce ;)",
        formatComentario.parse("15/09/2018 12:29"), "tabarec", "Locura celeste", "cachilas", 10);
    try {
      this.usuariosCanales.valorarVideo("sergiop", false, "50 a�os del InCo", "hectorg");
      this.usuariosCanales.valorarVideo("sergiop", true, "Ingenieria de Muestra 2017", "hectorg");
      this.usuariosCanales.valorarVideo("sergiop", true, "Show de goles", "juliob");
      this.usuariosCanales.valorarVideo("nicoJ", false, "Locura celeste", "tabarec");
      this.usuariosCanales.valorarVideo("nicoJ", false, "Locura celeste", "cachilas");
      this.usuariosCanales.valorarVideo("nicoJ", true, "50 a�os del InCo", "hectorg");
      this.usuariosCanales.valorarVideo("kairoh", true, "50 a�os del InCo", "hectorg");
      this.usuariosCanales.valorarVideo("kairoh", true, "Inauguracion Estadio Pe�arol", "juliob");
      this.usuariosCanales.valorarVideo("marcelot", true, "Locura celeste", "tabarec");
      this.usuariosCanales.valorarVideo("marcelot", true, "Dancing in the Dark", "kairoh");
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
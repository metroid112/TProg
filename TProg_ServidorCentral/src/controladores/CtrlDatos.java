package controladores;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import clases.Canal;
import clases.ListaParticular;
import clases.Usuario;
import clases.Video;
import datatypes.DtBusqueda;
import datatypes.DtCanal;
import datatypes.DtLista;
import datatypes.DtUsuario;
import datatypes.DtVideo;
import interfaces.Fabrica;
import interfaces.ICategorias;
import interfaces.IDatos;
import interfaces.IListas;
import interfaces.IUsuariosCanales;
import interfaces.IVideos;
import manejadores.ManejadorUsuarios;
import manejadores.ManejadorVideos;

public class CtrlDatos implements IDatos {

  private static boolean cargaDatos = false;

  @Override
  public void cargaDatos() throws Exception {
    if (!cargaDatos) {
      CtrlDatos.cargaDatos = true;
      DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
      String divisor = "/";
      IUsuariosCanales ctrlUsuarios = Fabrica.getIUsuariosCanales();
      IVideos ctrlVideos = Fabrica.getIVideos();
      IListas ctrlListas = Fabrica.getIListas();
      ICategorias ctrlCategorias = Fabrica.getICategorias();

      class UsuarioBean {
        public int id;
        public String nick;
        public String nombre;
        public String apellido;
        public String pass;
        public String mail;
        public String nacimiento;
        public String nombreCanal;
        public String descripcionCanal;
        public boolean visibilidadCanal;
      }
      ;

      UsuarioBean HR = new UsuarioBean();
      UsuarioBean MB = new UsuarioBean();
      UsuarioBean HG = new UsuarioBean();
      UsuarioBean TC = new UsuarioBean();
      UsuarioBean CS = new UsuarioBean();
      UsuarioBean JB = new UsuarioBean();
      UsuarioBean DP = new UsuarioBean();
      UsuarioBean KH = new UsuarioBean();
      UsuarioBean RH = new UsuarioBean();
      UsuarioBean MT = new UsuarioBean();
      UsuarioBean EN = new UsuarioBean();
      UsuarioBean SP = new UsuarioBean();
      UsuarioBean AR = new UsuarioBean();
      UsuarioBean AP = new UsuarioBean();
      UsuarioBean NJ = new UsuarioBean();
      int id = 0;

      HR.id = 0;
      HR.nick = "hrubino";
      HR.nombre = "Horacio";
      HR.apellido = "Rubino";
      HR.pass = "Rufus123";
      HR.mail = "horacio.rubino@guambia.com.uy";
      HR.nacimiento = "25/02/1962";
      HR.nombreCanal = "Canal Horacio";
      HR.descripcionCanal = "El canal Horacio es para publicar contenido divertido";
      HR.visibilidadCanal = true;

      MB.id = id++;
      MB.nick = "mbusca";
      MB.nombre = "Martín";
      MB.apellido = "Buscaglia";
      MB.pass = "Cookie234";
      MB.mail = "Martin.bus@agadu.org.uy";
      MB.nacimiento = "14/06/1972";
      MB.nombreCanal = "El bocha";
      MB.descripcionCanal = "Mi canal para colgar cosas";
      MB.visibilidadCanal = true;

      HG.id = id++;
      HG.nick = "hectorg";
      HG.nombre = "Héctor";
      HG.apellido = "Guido";
      HG.pass = "Poncho345";
      HG.mail = "hector.gui@elgapon.org.uy";
      HG.nacimiento = "07/01/1954";
      HG.nombreCanal = "hectorg";
      HG.descripcionCanal = "Canal HG";
      HG.visibilidadCanal = true;

      TC.id = id++;
      TC.nick = "tabarec";
      TC.nombre = "Tabaré";
      TC.apellido = "Cardozo";
      TC.pass = "Ketchup1";
      TC.mail = "tabare.car@agadu.org.uy";
      TC.nacimiento = "24/07/1971";
      TC.nombreCanal = "Tabaré";
      TC.descripcionCanal = "Mi música e ainda mais";
      TC.visibilidadCanal = true;

      CS.id = id++;
      CS.nick = "cachilas";
      CS.nombre = "Waldemar \"Cachila\"";
      CS.apellido = "Silva";
      CS.pass = "Sancho456";
      CS.mail = "Cachila.sil@c1080.org.uy";
      CS.nacimiento = "01/01/1947";
      CS.nombreCanal = "El Cachila";
      CS.descripcionCanal = "Para juntar cosas";
      CS.visibilidadCanal = false;

      JB.id = id++;
      JB.nick = "juliob";
      JB.nombre = "Julio";
      JB.apellido = "Bocca";
      JB.pass = "Salome56";
      JB.mail = "juliobocca@sodre.com.uy";
      JB.nacimiento = "16/03/1967";
      JB.nombreCanal = "juliob";
      JB.descripcionCanal = "Canal de JB";
      JB.visibilidadCanal = true;

      DP.id = id++;
      DP.nick = "diegop";
      DP.nombre = "Diego";
      DP.apellido = "Parodi";
      DP.pass = "Ruffo678";
      DP.mail = "diego@efectocine.com";
      DP.nacimiento = "01/01/1975";
      DP.nombreCanal = "diegop";
      DP.descripcionCanal = "Canal de DP";
      DP.visibilidadCanal = true;

      KH.id = id++;
      KH.nick = "kairoh";
      KH.nombre = "Kairo";
      KH.apellido = "Herrera";
      KH.pass = "Corbata15";
      KH.mail = "kairoher@pilsenrock.com.uy";
      KH.nacimiento = "25/04/1840";
      KH.nombreCanal = "Kairo música";
      KH.descripcionCanal = "Videos de grandes canciones de hoy y siempre";
      KH.visibilidadCanal = true;

      RH.id = id++;
      RH.nick = "robinh";
      RH.nombre = "Robin";
      RH.apellido = "Henderson";
      RH.pass = "Aquiles67";
      RH.mail = "Robin.h@tinglesa.com.uy";
      RH.nacimiento = "03/08/1940";
      RH.nombreCanal = "robinh";
      RH.descripcionCanal = "Henderson";
      RH.visibilidadCanal = true;

      MT.id = id++;
      MT.nick = "marcelot";
      MT.nombre = "Marcelo";
      MT.apellido = "Tinelli";
      MT.pass = "Mancha890";
      MT.mail = "marcelot@ideasdelsur.com.ar";
      MT.nacimiento = "01/04/1960";
      MT.nombreCanal = "Tinelli total";
      MT.descripcionCanal = "Todo lo que querías y más!";
      MT.visibilidadCanal = true;

      EN.id = id++;
      EN.nick = "novick";
      EN.nombre = "Edgardo";
      EN.apellido = "Novick";
      EN.pass = "Xenon987";
      EN.mail = "edgardo@novick.com.uy";
      EN.nacimiento = "17/07/1952";
      EN.nombreCanal = "Con la gente";
      EN.descripcionCanal = "Preparando las elecciones";
      EN.visibilidadCanal = true;

      SP.id = id++;
      SP.nick = "sergiop";
      SP.nombre = "Sergio";
      SP.apellido = "Puglia";
      SP.pass = "Sultan876";
      SP.mail = "puglia@alpanpan.com.uy";
      SP.nacimiento = "28/01/1950";
      SP.nombreCanal = "Puglia invita";
      SP.descripcionCanal = "Programas del ciclo y videos de cocina masterchef";
      SP.visibilidadCanal = true;

      AR.id = id++;
      AR.nick = "chino";
      AR.nombre = "Alvaro";
      AR.apellido = "Recoba";
      AR.pass = "Laika765";
      AR.mail = "chino@trico.org.uy";
      AR.nacimiento = "17/03/1976";
      AR.nombreCanal = "Chino Recoba";
      AR.descripcionCanal = "Canal de goles con Nacional";
      AR.visibilidadCanal = false;

      AP.id = id++;
      AP.nick = "tonyp";
      AP.nombre = "Antonio";
      AP.apellido = "Pacheco";
      AP.pass = "Kitty543";
      AP.mail = "eltony@manya.org.uy";
      AP.nacimiento = "14/02/1955";
      AP.nombreCanal = "Tony Pacheco";
      AP.descripcionCanal = "Todos los goles con Peñarol";
      AP.visibilidadCanal = false;

      NJ.id = id++;
      NJ.nick = "nicoJ";
      NJ.nombre = "Nicolás";
      NJ.apellido = "Jodal";
      NJ.pass = "Albino80";
      NJ.mail = "jodal@artech.com.uy";
      NJ.nacimiento = "09/08/1960";
      NJ.nombreCanal = "Desde Genexus";
      NJ.descripcionCanal = "Canal información C y T";
      NJ.visibilidadCanal = true;

      ctrlUsuarios.altaUsuario(HR.nick, HR.nombre, HR.apellido, HR.mail,
          format.parse(HR.nacimiento), "img" + divisor + "usuarios" + divisor + "horacio.JPG",
          HR.nombreCanal, HR.descripcionCanal, "Sin categoria", HR.visibilidadCanal, HR.pass);
      ctrlUsuarios.altaUsuario(MB.nick, MB.nombre, MB.apellido, MB.mail,
          format.parse(MB.nacimiento), "img" + divisor + "usuarios" + divisor + "martin.JPG",
          MB.nombreCanal, MB.descripcionCanal, "Sin categoria", true, MB.pass);
      ctrlUsuarios.altaUsuario("hectorg", "Héctor", "Guido",
          "hector.gui@elgalpon.org.uy",
          format.parse("07/01/1954"), "img" + divisor + "usuarios" + divisor + "null.JPG",
          "hectorg",
          "Canal HG",
          "Sin categoria", true, HG.pass);
      ctrlUsuarios.altaUsuario("tabarec", "Tabare", "Cardozo",
          "tabare.car@agadu.org.uy",
          format.parse("24/07/1971"), "img" + divisor + "usuarios" + divisor + "tabare.JPG",
          "Tabar�",
          "Mi musica e ainda mais", "Sin categoria", true, TC.pass);
      ctrlUsuarios.altaUsuario("cachilas", "Waldemar \"Cachila\"", "Silva",
          "Cachila.sil@c1080.org.uy", format.parse("01/01/1947"),
          "img" + divisor + "usuarios" + divisor + "cachila.JPG",
          "El Cachila", "Para juntar cosas", "Sin categoria", false, CS.pass);
      ctrlUsuarios.altaUsuario("juliob", "Julio", "Bocca",
          "juliobocca@sodre.com.uy",
          format.parse("16/03/1967"), "img" + divisor + "usuarios" + divisor + "null.JPG", "juliob",
          "Canal de JB",
          "Sin categoria", true, JB.pass);
      ctrlUsuarios.altaUsuario("diegop", "Diego", "Parodi", "diego@efectocine.com",
          format.parse("01/01/1975"), "img" + divisor + "usuarios" + divisor + "null.JPG", "diegop",
          "Canal de DP",
          "Sin categoria", true, DP.pass);
      ctrlUsuarios.altaUsuario("kairoh", "Kairo", "Herrera",
          "kairoher@pilsenrock.com.uy",
          format.parse("25/04/1840"), "img" + divisor + "usuarios" + divisor + "kairo.JPG",
          "Kairo musica",
          "Videos de grandes canciones de hoy y siempre", "Sin categoria", true, KH.pass);
      ctrlUsuarios.altaUsuario("robinh", "Robin", "Henderson",
          "Robin.h@tinglesa.com.uy",
          format.parse("03/08/1940"), "img" + divisor + "usuarios" + divisor + "null.JPG", "robinh",
          "Henderson",
          "Sin categoria", true, RH.pass);
      ctrlUsuarios.altaUsuario("marcelot", "Marcelo", "Tinelli",
          "marcelot@ideasdelsur.com.ar", format.parse("01/04/1960"),
          "img" + divisor + "usuarios" + divisor + "null.JPG",
          "Tinelli total", "Todo lo que querias y más !", "Sin categoria", true, MT.pass);
      ctrlUsuarios.altaUsuario("novick", "Edgardo", "Novick",
          "edgardo@novick.com.uy",
          format.parse("17/07/1952"), "img" + divisor + "usuarios" + divisor + "null.JPG",
          "Con la gente",
          "Preparando las elecciones", "Sin categoria", true, EN.pass);
      ctrlUsuarios.altaUsuario("sergiop", "Sergio", "Puglia",
          "puglia@alpanpan.com.uy",
          format.parse("28/01/1950"), "img" + divisor + "usuarios" + divisor + "null.JPG",
          "Puglia invita",
          "Programas del ciclo y videos de cocina masterchef", "Sin categoria", true, SP.pass);
      ctrlUsuarios.altaUsuario("chino", "Alvaro", "Recoba", "chino@trico.org.uy",
          format.parse("17/03/1976"), "img" + divisor + "usuarios" + divisor + "recoba.JPG",
          "Chino Recoba",
          "Canal de goles con Nacional ", "Sin categoria", false, AR.pass);
      ctrlUsuarios.altaUsuario("tonyp", "Antonio", "Pacheco",
          "eltony@manya.org.uy",
          format.parse("14/02/1955"), "img" + divisor + "usuarios" + divisor + "pacheco.JPG",
          "Tony Pacheco",
          "Todos los goles con Peñarol", "Sin categoria", false, AP.pass);
      ctrlUsuarios.altaUsuario("nicoJ", "Nicolas", "Jodal", "jodal@artech.com.uy",
          format.parse("09/08/1960"), "img" + divisor + "usuarios" + divisor + "null.JPG",
          "Desde Genexus", "Canal informacion C y T", "Sin categoria", true, NJ.pass);

      ctrlUsuarios.seguir(HR.id, HG.id);
      ctrlUsuarios.seguir(HR.id, DP.id);
      ctrlUsuarios.seguir(MB.id, TC.id);
      ctrlUsuarios.seguir(MB.id, CS.id);
      ctrlUsuarios.seguir(MB.id, KH.id);
      ctrlUsuarios.seguir(HG.id, MB.id);
      ctrlUsuarios.seguir(HG.id, JB.id);
      ctrlUsuarios.seguir(TC.id, HR.id);
      ctrlUsuarios.seguir(TC.id, CS.id);
      ctrlUsuarios.seguir(CS.id, HR.id);
      ctrlUsuarios.seguir(JB.id, MB.id);
      ctrlUsuarios.seguir(JB.id, DP.id);
      ctrlUsuarios.seguir(DP.id, HG.id);
      ctrlUsuarios.seguir(KH.id, SP.id);
      ctrlUsuarios.seguir(RH.id, HG.id);
      ctrlUsuarios.seguir(RH.id, JB.id);
      ctrlUsuarios.seguir(RH.id, DP.id);
      ctrlUsuarios.seguir(MT.id, CS.id);
      ctrlUsuarios.seguir(MT.id, JB.id);
      ctrlUsuarios.seguir(MT.id, KH.id);
      ctrlUsuarios.seguir(EN.id, HR.id);
      ctrlUsuarios.seguir(EN.id, TC.id);
      ctrlUsuarios.seguir(EN.id, CS.id);
      ctrlUsuarios.seguir(SP.id, MB.id);
      ctrlUsuarios.seguir(SP.id, JB.id);
      ctrlUsuarios.seguir(SP.id, DP.id);
      ctrlUsuarios.seguir(AR.id, AP.id);
      ctrlUsuarios.seguir(AP.id, AR.id);
      ctrlUsuarios.seguir(NJ.id, DP.id);

      class CategoriaBean {
        public String nombre;
      }

      CategoriaBean MUS = new CategoriaBean();
      CategoriaBean DEP = new CategoriaBean();
      CategoriaBean CAR = new CategoriaBean();
      CategoriaBean NOT = new CategoriaBean();
      CategoriaBean ENT = new CategoriaBean();
      CategoriaBean COM = new CategoriaBean();
      CategoriaBean JUE = new CategoriaBean();
      CategoriaBean CYT = new CategoriaBean();
      CategoriaBean ONG = new CategoriaBean();
      CategoriaBean GEN = new CategoriaBean();
      CategoriaBean MAS = new CategoriaBean();
      CategoriaBean VIA = new CategoriaBean();

      MUS.nombre = "Música";
      DEP.nombre = "Deporte";
      CAR.nombre = "Carnaval";
      NOT.nombre = "Noticias";
      ENT.nombre = "Entretenimiento";
      COM.nombre = "Comida";
      JUE.nombre = "Videojuegos";
      CYT.nombre = "Ciencia y Tecnología";
      ONG.nombre = "ONG y activismo";
      GEN.nombre = "Gente y blogs";
      MAS.nombre = "Mascotas y animales";
      VIA.nombre = "Viajes y eventos";

      ctrlCategorias.altaCategoria(MUS.nombre);
      ctrlCategorias.altaCategoria(DEP.nombre);
      ctrlCategorias.altaCategoria(CAR.nombre);
      ctrlCategorias.altaCategoria(NOT.nombre);
      ctrlCategorias.altaCategoria(ENT.nombre);
      ctrlCategorias.altaCategoria(COM.nombre);
      ctrlCategorias.altaCategoria(JUE.nombre);
      ctrlCategorias.altaCategoria(CYT.nombre);
      ctrlCategorias.altaCategoria(ONG.nombre);
      ctrlCategorias.altaCategoria(GEN.nombre);
      ctrlCategorias.altaCategoria(MAS.nombre);
      ctrlCategorias.altaCategoria(VIA.nombre);

      class VideoBean {
        public String nombre;
        public String owner;
      }

      VideoBean V1a = new VideoBean();
      VideoBean V1b = new VideoBean();
      VideoBean V2a = new VideoBean();
      VideoBean V2b = new VideoBean();
      VideoBean V3a = new VideoBean();
      VideoBean V3b = new VideoBean();
      VideoBean V4 = new VideoBean();
      VideoBean V5a = new VideoBean();
      VideoBean V5b = new VideoBean();
      VideoBean V6 = new VideoBean();
      VideoBean V7 = new VideoBean();
      VideoBean V8 = new VideoBean();
      VideoBean V9 = new VideoBean();
      VideoBean V10 = new VideoBean();
      VideoBean V11 = new VideoBean();
      VideoBean V12a = new VideoBean();
      VideoBean V12b = new VideoBean();
      VideoBean V13 = new VideoBean();
      VideoBean V14a = new VideoBean();
      VideoBean V14b = new VideoBean();
      VideoBean V15 = new VideoBean();
      VideoBean V16 = new VideoBean();

      V1a.nombre = "Locura celeste";
      V1a.owner = TC.nick;

      V1b.nombre = "Locura celeste";
      V1b.owner = CS.nick;

      V2a.nombre = "Niño payaso";
      V2a.owner = TC.nick;

      V2b.nombre = "Niño payaso";
      V2b.owner = CS.nick;

      V3a.nombre = "Sweet child'o mine";
      V3a.owner = JB.nick;

      V3b.nombre = "Sweet child'o mine";
      V3b.owner = KH.nick;

      V4.nombre = "Dancing in the Dark";
      V4.owner = KH.nick;

      V5a.nombre = "Thriller";
      V5a.owner = JB.nick;

      V5b.nombre = "Thriller";
      V5b.owner = KH.nick;

      V6.nombre = "100 años de FING";
      V6.owner = HG.nick;

      V7.nombre = "50 años del InCo";
      V7.owner = HG.nick;

      V8.nombre = "Ingeniería de Muestra 2017";
      V8.owner = HG.nick;

      V9.nombre = "Etapa A contramano Liguilla";
      V9.owner = CS.nick;

      V10.nombre = "Etapa Don Timoteo Liguilla";
      V10.owner = CS.nick;

      V11.nombre = "Show de goles";
      V11.owner = JB.nick;

      V12a.nombre = "Pacheco goles más recordados";
      V12a.owner = TC.nick;

      V12b.nombre = "Pacheco goles más recordados";
      V12b.owner = AP.nick;

      V13.nombre = "Inauguración Estadio Peñarol";
      V13.owner = JB.nick;

      V14a.nombre = "Recoba 20 mejores goles";
      V14a.owner = CS.nick;

      V14b.nombre = "Recoba 20 mejores goles";
      V14b.owner = AR.nick;

      V15.nombre = "Entrevista a director CUTI";
      V15.owner = NJ.nick;

      V16.nombre = "Ventana al futuro Uruguay y déficit de ingenieros";
      V16.owner = NJ.nick;

      Fabrica.getIVideos().altaVideo(HG.id, V6.nombre,
          "Del Ciclo más Universidad realizado por la UdelaR, compartimos con ustedes "
              + "un audiovisual realizado en 2016 por los 100 años de la denominación "
              + "Facultad de Ingeniería.\nExtraído del canal Teleuniversitaria UdelaR",
          Duration.parse("PT6M26S"), "https://youtu.be/peGS4TBxSaI", NOT.nombre,
          format.parse("03/08/2017"), true);
      Fabrica.getIVideos().altaVideo(HG.id, V7.nombre,
          "50 años del Instituto de Computación. Facultad de Ingeniería. UDELAR. "
              + "22 de noviembre 2017.\nLa mesa de apertura estuvo integrada por Simon, "
              + "el rector de la Universidad de la República (Udelar), Roberto Markarian; "
              + "la ministra de Industria, Energía y Minería, Carolina Cosse; el "
              + "presidente de la Cámara Uruguaya de Tecnologías de la Información "
              + "(CUTI), Leonardo Loureiro, y el director del Inco, Diego Vallespir.",
          Duration.parse("PT27M22S"), "https://youtu.be/GzOJSk4urlM", NOT.nombre,
          format.parse("24/11/2017"), true);
      Fabrica.getIVideos().altaVideo(HG.id, V8.nombre,
          "La muestra más grande de la Ingeniería nacional se realiza el jueves 19, "
              + "viernes 20 y sábado 21 de octubre de 2017. Ingeniería deMuestra fue organizada "
              + "por la Facultad de Ingeniería de la Universidad de la "
              + "República y su Fundación Julio Ricaldoni.",
          Duration.parse("PT1M"), "https://youtu.be/RnaYRA1k5j4", NOT.nombre,
          format.parse("25/10/2017"), true);
      Fabrica.getIVideos().altaVideo(TC.id, V1a.nombre,
          "Tema Oficial de la cobertura celeste de Monte Carlo Televisión Canal 4 para "
              + "el Mundial de Futbol FIFA Rusia 2018.",
          Duration.parse("PT3M4S"), "https://youtu.be/PAfbzKcePx0", MUS.nombre,
          format.parse("05/06/2018"), false);
      Fabrica.getIVideos().altaVideo(TC.id, V2a.nombre, "", Duration.parse("PT4M18S"),
          "https://youtu.be/K-uEIUnyZPg", MUS.nombre, format.parse("20/10/2016"), false);
      Fabrica.getIVideos().altaVideo(TC.id, V12a.nombre, "",
          Duration.parse("PT5M48S"),
          "https://youtu.be/wlEd6-HsIxI", DEP.nombre, format.parse("05/07/2013"), false);
      Fabrica.getIVideos().altaVideo(CS.id, V1a.nombre,
          "Tema Oficial de la cobertura celeste de Monte Carlo Televisión Canal 4 para el "
              + "Mundial de Futbol FIFA Rusia 2018.",
          Duration.parse("PT3M4S"), "https://youtu.be/PAfbzKcePx0", MUS.nombre,
          format.parse("05/06/2018"), false);
      Fabrica.getIVideos().altaVideo(CS.id, "Niño payaso", "", Duration.parse("PT4M18S"),
          "https://youtu.be/K-uEIUnyZPg", "Música", format.parse("20/10/2016"), false);
      Fabrica.getIVideos().altaVideo(CS.id, "Etapa A contramano Liguilla", "",
          Duration.parse("PT57M15S"),
          "https://youtu.be/Es6GRMHXeCQ", "Carnaval", format.parse("17/12/2015"), false);
      Fabrica.getIVideos().altaVideo(CS.id, "Etapa Don Timoteo Liguilla", "",
          Duration.parse("PT51M38S"),
          "https://youtu.be/I_spHBU9ZsI", "Carnaval", format.parse("18/12/2015"), false);
      Fabrica.getIVideos().altaVideo(CS.id, "Recoba 20 mejores goles",
          "My Favorites\n\n\"El Chino\"",
          Duration.parse("PT13M36S"), "https://youtu.be/Gy3fZhWdLEQ", "Deporte",
          format.parse("14/11/2011"), false);
      Fabrica.getIVideos().altaVideo(JB.id, "Sweet child'o mine",
          "#AppetiteForDestruction: The Debut Album, Remastered and Expanded. Available now as Box Set, Super Deluxe, Double LP, and Double CD here: https://lnk.to/AppetiteForDestruction... \n\nApple Music: https://lnk.to/AppetiteForDestruction... \niTunes: https://lnk.to/AppetiteForDestruction... \nSpotify: https://lnk.to/AppetiteForDestruction... \nAmazon: https://lnk.to/AppetiteForDestruction... \nGoogle Play: https://lnk.to/AppetiteForDestruction... \n\nSite: https://www.gunsnroses.com/ \nFacebook: https://www.facebook.com/gunsnroses\nTwitter: https://twitter.com/gunsnroses \nInstagram: https://www.instagram.com/gunsnroses \n\nMusic video by Guns N' Roses performing Sweet Child O' Mine. YouTube view counts pre-VEVO: 2,418,311. (C) 1987 Guns N' Roses under exclusive license to Geffen Records\n\n#GunsNRoses #SweetChildOMine #vevo #rockandroll #vevoofficial",
          Duration.parse("PT5M2S"), "https://youtu.be/1w7OgIMMRc4", "Música",
          format.parse("24/12/2009"), true);
      Fabrica.getIVideos().altaVideo(JB.id, "Thriller",
          "Listen to more Michael Jackson: https://MichaelJackson.lnk.to/Stream!to\n\nMichael Jackson's 14-minute short film \"Thriller\" revolutionized the music video genre forever. Hailed as the greatest music video of all time by MTV, VH1, Rolling Stone and others, \"Thriller,\" directed by John Landis, is also the only music video selected to be included in the Library of Congress' prestigious National Film Registry.\n\nBuy/Listen to Thriller 25: \nAmazon - http://smarturl.it/mj_thriller25_amzn...  \niTunes - http://smarturl.it/MJ_T25DE_OS?IQid=y...  \nOfficial Store - http://smarturl.it/MJ_T25DE_OS?IQid=y...  \nSpotify - http://smarturl.it/mj_thriller25_sptf...  \n\nWritten by Rod Temperton\nProduced by Quincy Jones for Quincy Jones Productions\nFrom the album Thriller, released November 30, 1982\nReleased as a single January 23, 1984\n\nTHE SHORT FILM\nDirector: John Landis\nPrimary Production Location: Los Angeles, California\n\nMichael Jackson's short film for \"Thriller\" was the third of three short films produced for recordings from Thriller, which continues its reign as the biggest selling album of all time with worldwide sales in excess of 105 million as of June 1, 2016 and in December 2015 became the first ever album to be awarded triple diamond status (i.e.: sales in excess of 30 million) by the RIAA for US sales alone. The \"Thriller\" single reached No. 1 in four countries in 1984, topping the U.S. Billboard Hot Dance Club Play chart as well as charts in Spain, France and Belgium. The song peaked at No. 4 on the Billboard Hot 100, making Thriller the first album to feature seven Top 10 singles. The Recording Industry Association of America certified \"Thriller\" Gold and Platinum on December 4, 1989. \n\nThe groundbreaking short films for the Thriller album, starting with \"Billie Jean,\" following up with \"Beat It\" and culminating with the epic, nearly 14-minute \"Thriller,\" truly expanded the possibilities of \"music video\" as art form. \"I wanted something that would glue you to the set, something you'd want to watch over and over,\" Michael wrote in his 1988 memoir Moonwalk. \"I wanted to be a pioneer in this relatively new medium and make the best short music movies we could make.\"\n\nIn the short film\'s extended prologue, Michael\'s moonlit date with his girlfriend (played by model Ola Ray) is interrupted by his sudden transformation into a howling werewolf. While the \"real\" Michael and Ola, observing the scene in a movie theater, walk home from the their date, Michael teases her by singing the verses of \"Thriller.\"\n\nFollow the Official Michael Jackson Accounts: \nFacebook - http://smarturl.it/mj_facebook?IQid=y...  \nTwitter - http://smarturl.it/mj_twitter?IQid=yt...  \nSpotify - http://smarturl.it/mj_spotify?IQid=yt...  \nNewsletter - http://smarturl.it/mj_newsletter?IQid...  \nYouTube - http://smarturl.it/mj_youtube?IQid=yt...  \nWebsite - http://smarturl.it/mj_website?IQid=yt...",
          Duration.parse("PT13M42S"), "https://youtu.be/PAfbzKcePx0", "Música",
          format.parse("02/10/2009"), false);
      Fabrica.getIVideos().altaVideo(JB.id, "Show de goles",
          "TORNEO CLAUSURA 2018\nFECHA 1.....",
          Duration.parse("PT4M23S"), "https://youtu.be/g46w4_kD_lA", "Deporte",
          format.parse("23/07/2018"), true);
      Fabrica.getIVideos().altaVideo(JB.id, "Inauguracion Estadio Peñarol",
          "Recordemos la ceremonia de inauguración del Estadio de Peñarol.\nLlamado \""
              + "Estadio Campeón del Siglo\".",
          Duration.parse("PT3H27M26S"), "https://youtu.be/U6XPJ8Vz72A", "Deporte",
          format.parse("04/04/2016"), true);
      Fabrica.getIVideos().altaVideo(KH.id, "Sweet child'o mine",
          "#AppetiteForDestruction: The Debut Album, Remastered and Expanded. Available now as Box Set, Super Deluxe, Double LP, and Double CD here: https://lnk.to/AppetiteForDestruction... \n\nApple Music: https://lnk.to/AppetiteForDestruction... \niTunes: https://lnk.to/AppetiteForDestruction... \nSpotify: https://lnk.to/AppetiteForDestruction... \nAmazon: https://lnk.to/AppetiteForDestruction... \nGoogle Play: https://lnk.to/AppetiteForDestruction... \n\nSite: https://www.gunsnroses.com/ \nFacebook: https://www.facebook.com/gunsnroses\nTwitter: https://twitter.com/gunsnroses \nInstagram: https://www.instagram.com/gunsnroses \n\nMusic video by Guns N' Roses performing Sweet Child O' Mine. YouTube view counts pre-VEVO: 2,418,311. (C) 1987 Guns N' Roses under exclusive license to Geffen Records\n\n#GunsNRoses #SweetChildOMine #vevo #rockandroll #vevoofficial",
          Duration.parse("PT5M2S"), "https://youtu.be/1w7OgIMMRc4", "Música",
          format.parse("24/12/2009"), true);
      Fabrica.getIVideos().altaVideo(KH.id, "Dancing in the Dark",
          "Bruce Springsteen's official music video for \'Dancing In The Dark\'. Click to listen to Bruce Springsteen on Spotify: http://smarturl.it/BSpringSpot?IQid=B...",
          Duration.parse("PT3M58S"), "https://youtu.be/129kuDCQtHs", "Música",
          format.parse("03/10/2009"), true);
      Fabrica.getIVideos().altaVideo(KH.id, "Thriller",
          "Listen to more Michael Jackson: https://MichaelJackson.lnk.to/Stream!to\n\nMichael Jackson's 14-minute short film \"Thriller\" revolutionized the music video genre forever. Hailed as the greatest music video of all time by MTV, VH1, Rolling Stone and others, \"Thriller,\" directed by John Landis, is also the only music video selected to be included in the Library of Congress' prestigious National Film Registry.\n\nBuy/Listen to Thriller 25: \nAmazon - http://smarturl.it/mj_thriller25_amzn...  \niTunes - http://smarturl.it/MJ_T25DE_OS?IQid=y...  \nOfficial Store - http://smarturl.it/MJ_T25DE_OS?IQid=y...  \nSpotify - http://smarturl.it/mj_thriller25_sptf...  \n\nWritten by Rod Temperton\nProduced by Quincy Jones for Quincy Jones Productions\nFrom the album Thriller, released November 30, 1982\nReleased as a single January 23, 1984\n\nTHE SHORT FILM\nDirector: John Landis\nPrimary Production Location: Los Angeles, California\n\nMichael Jackson's short film for \"Thriller\" was the third of three short films produced for recordings from Thriller, which continues its reign as the biggest selling album of all time with worldwide sales in excess of 105 million as of June 1, 2016 and in December 2015 became the first ever album to be awarded triple diamond status (i.e.: sales in excess of 30 million) by the RIAA for US sales alone. The \"Thriller\" single reached No. 1 in four countries in 1984, topping the U.S. Billboard Hot Dance Club Play chart as well as charts in Spain, France and Belgium. The song peaked at No. 4 on the Billboard Hot 100, making Thriller the first album to feature seven Top 10 singles. The Recording Industry Association of America certified \"Thriller\" Gold and Platinum on December 4, 1989. \n\nThe groundbreaking short films for the Thriller album, starting with \"Billie Jean,\" following up with \"Beat It\" and culminating with the epic, nearly 14-minute \"Thriller,\" truly expanded the possibilities of \"music video\" as art form. \"I wanted something that would glue you to the set, something you'd want to watch over and over,\" Michael wrote in his 1988 memoir Moonwalk. \"I wanted to be a pioneer in this relatively new medium and make the best short music movies we could make.\"\n\nIn the short film\'s extended prologue, Michael\'s moonlit date with his girlfriend (played by model Ola Ray) is interrupted by his sudden transformation into a howling werewolf. While the \"real\" Michael and Ola, observing the scene in a movie theater, walk home from the their date, Michael teases her by singing the verses of \"Thriller.\"\n\nFollow the Official Michael Jackson Accounts: \nFacebook - http://smarturl.it/mj_facebook?IQid=y...  \nTwitter - http://smarturl.it/mj_twitter?IQid=yt...  \nSpotify - http://smarturl.it/mj_spotify?IQid=yt...  \nNewsletter - http://smarturl.it/mj_newsletter?IQid...  \nYouTube - http://smarturl.it/mj_youtube?IQid=yt...  \nWebsite - http://smarturl.it/mj_website?IQid=yt...",
          Duration.parse("PT13M42S"), "https://youtu.be/sOnqjkJTMaA", "Música",
          format.parse("02/10/2009"), true);
      Fabrica.getIVideos().altaVideo(AR.id, "Recoba 20 mejores goles",
          "My Favorites\n\n\"El Chino\"",
          Duration.parse("PT13M36S"), "https://youtu.be/Gy3fZhWdLEQ", "Deporte",
          format.parse("14/11/2011"), false);
      Fabrica.getIVideos().altaVideo(AP.id, "Pacheco goles mas recordados", "",
          Duration.parse("PT5M48S"),
          "https://youtu.be/wlEd6-HsIxI", "Deporte", format.parse("05/07/2013"), false);
      Fabrica.getIVideos().altaVideo(NJ.id, "Entrevista a director CUTI",
          "Segunda parte de la entrevista realizada por la periodista "
              + "Paula Echevarr�a al director de CUTI",
          Duration.parse("PT5M39S"), "https://youtu.be/Eq5uBEzI6qs", "Ciencia y Tecnología",
          format.parse("03/04/2017"), true);
      Fabrica.getIVideos().altaVideo(NJ.id, "Ventana al futuro Uruguay y deficit de ingenieros",
          "VEA ESTE CONTENIDO EN EnPerspectiva.net: http://www.enperspectiva.net/en-persp...\n\nEn Uruguay hay un ingeniero por cada tres abogados y cada seis medicos. Los datos se desprenden del Panorama de la Educación 2014 del anuario del Ministerio de Educación y Cultura. Ese año egresaron de la Universidad de la República 348 ingenieros, una cifra que supone un leve aumento con respecto a los anteriores.\n\nSin embargo, según sostienen desde la Facultad de Ingeniería, ese n�mero sigue siendo insuficiente y el d�ficit de profesionales puede significar una traba para el desarrollo del pa�s. De ese desaf�o hablaremos en esta nueva entrega de Ventana al Futuro; para eso nos acompa�a la decana de esa casa de estudios y presidente de la Fundación Julio Ricaldoni, María Simón.",
          Duration.parse("PT192M1S"), "https://youtu.be/zBR2pnASlQE", "Ciencia y Tecnología",
          format.parse("20/07/2016"), true);

      class ListaDefectoBean {
        public String nombre;
      }

      ListaDefectoBean LD1 = new ListaDefectoBean();
      ListaDefectoBean LD2 = new ListaDefectoBean();
      ListaDefectoBean LD3 = new ListaDefectoBean();

      LD1.nombre = "Escuchar más tarde";
      LD2.nombre = "Deporte total";
      LD3.nombre = "Novedades generales";

      Fabrica.getIListas().altaListaDefecto(LD1.nombre);
      Fabrica.getIListas().altaListaDefecto(LD2.nombre);
      Fabrica.getIListas().altaListaDefecto(LD3.nombre);

      class ListaParticularBean {
        public String nombre;
        public int owner;
      }

      ListaParticularBean LP1 = new ListaParticularBean();
      ListaParticularBean LP2 = new ListaParticularBean();
      ListaParticularBean LP3 = new ListaParticularBean();
      ListaParticularBean LP4 = new ListaParticularBean();
      ListaParticularBean LP5 = new ListaParticularBean();
      ListaParticularBean LP6 = new ListaParticularBean();

      LP1.nombre = "Nostalgia";
      LP1.owner = KH.id;

      LP2.nombre = "De fiesta";
      LP2.owner = TC.id;

      LP3.nombre = "Novedades FING";
      LP3.owner = HG.id;

      LP4.nombre = "De todo un poco";
      LP4.owner = CS.id;

      LP5.nombre = "Noticias y CYT";
      LP5.owner = NJ.id;

      LP6.nombre = "Solo deportes";
      LP6.owner = JB.id;

      Fabrica.getIListas().altaListaParticular(LP1.nombre, LP1.owner, true);
      Fabrica.getIListas().altaListaParticular(LP2.nombre, LP2.owner, false);
      Fabrica.getIListas().altaListaParticular(LP3.nombre, LP3.owner, true);
      Fabrica.getIListas().altaListaParticular(LP4.nombre, LP4.owner, false);
      Fabrica.getIListas().altaListaParticular(LP5.nombre, LP5.owner, true);
      Fabrica.getIListas().altaListaParticular(LP6.nombre, LP6.owner, true);
      //int idVideo, int idUsuario, int idLista, boolean defecto
      
      Fabrica.getIListas().agregarVideoLista("Sweet child'o mine",JB.id, "kairoh",
          "Nostalgia",
          false);
      Fabrica.getIListas().agregarVideoLista("Sweet child'o mine",KH.id, "kairoh",
          "Nostalgia",
          false);
      Fabrica.getIListas().agregarVideoLista("Dancing in the Dark",KH.id, "kairoh",
          "Nostalgia",
          false);
      Fabrica.getIListas().agregarVideoLista("Thriller",KH.id, "kairoh", "Nostalgia", false);
      Fabrica.getIListas().agregarVideoLista("Thriller",JB.id, "kairoh", "Nostalgia", false);
      Fabrica.getIListas().agregarVideoLista("Locura celeste",TC.id, "tabarec", "De fiesta",
          false);
      Fabrica.getIListas().agregarVideoLista("Locura celeste",CS.id, "tabarec", "De fiesta",
          false);
      Fabrica.getIListas().agregarVideoLista("Niño payaso",TC.id, "tabarec", "De fiesta",
          false);
      Fabrica.getIListas().agregarVideoLista( "Niño payaso",CS.id, "tabarec", "De fiesta",
          false);
      Fabrica.getIListas().agregarVideoLista( "Etapa Don Timoteo Liguilla",CS.id, "tabarec",
          "De fiesta",
          false);
      Fabrica.getIListas().agregarVideoLista( "100 años de FING",HG.id, "hectorg",
          "Novedades FING",
          false);
      Fabrica.getIListas().agregarVideoLista( V7.nombre,HG.id, "hectorg",
          "Novedades FING",
          false);
      Fabrica.getIListas().agregarVideoLista( V8.nombre,HG.id ,"hectorg",
          "Novedades FING", false);
      Fabrica.getIListas().agregarVideoLista( "Locura celeste",TC.id, "cachilas",
          "De todo un poco",
          false);
      Fabrica.getIListas().agregarVideoLista( "Locura celeste",CS.id, "cachilas",
          "De todo un poco",
          false);
      Fabrica.getIListas().agregarVideoLista( "Niño payaso",TC.id ,"cachilas",
          "De todo un poco", false);
      Fabrica.getIListas().agregarVideoLista( "Niño payaso",CS.id, "cachilas",
          "De todo un poco",
          false);
      Fabrica.getIListas().agregarVideoLista( "Etapa A contramano Liguilla",CS.id,
          "cachilas",
          "De todo un poco", false);
      Fabrica.getIListas().agregarVideoLista("Etapa Don Timoteo Liguilla",CS.id, "cachilas",
          "De todo un poco", false);
      Fabrica.getIListas().agregarVideoLista( "Inauguracion Estadio Peñarol",JB.id,
          "cachilas",
          "De todo un poco", false);
      Fabrica.getIListas().agregarVideoLista( V8.nombre,HG.id ,"nicoJ",
          "Noticias y CYT", false);
      Fabrica.getIListas().agregarVideoLista( "Ventana al futuro Uruguay y deficit de ingenieros", NJ.id,
          "nicoJ", "Noticias y CYT", false);
      Fabrica.getIListas().agregarVideoLista( "Show de goles", JB.id ,"juliob", "Solo deportes",
          false);
      Fabrica.getIListas().agregarVideoLista( "Inauguracion Estadio Peñarol", JB.id,"juliob",
          "Solo deportes", false);

      DateFormat formatComentario = new SimpleDateFormat("dd/mm/yyyy HH:mm");
      Fabrica.getIUsuariosCanales().comentarVideo("Fue un gran evento",
          formatComentario.parse("05/12/2017 14:35"), "nicoJ", V7.nombre, "hectorg");
      Fabrica.getIUsuariosCanales().responderComentario(
          "Para el proximo aniversario ofrezco vamo' con los Momo",
          format.parse("08/12/2017 01:47"),
          "hrubino", V7.nombre, "hectorg", 0);
      Fabrica.getIUsuariosCanales().responderComentario("Yo ofrezco a la banda tb",
          format.parse("10/12/2017 17:09"), "tabarec", V7.nombre, "hectorg", 1);
      Fabrica.getIUsuariosCanales().comentarVideo("Felicitaciones FING!!!",
          formatComentario.parse("07/09/2017 04:56"), "nicoJ", "100 años de FING", "hectorg");
      Fabrica.getIUsuariosCanales().comentarVideo("Un gusto cubrir eventos como este.",
          formatComentario.parse("23/10/2017 12:58"), "kairoh", V8.nombre,
          "hectorg");
      Fabrica.getIUsuariosCanales().comentarVideo("Peñarol Peñarol!!!",
          formatComentario.parse("14/11/2016 05:34"), "kairoh", "Inauguracion Estadio Peñarol",
          "juliob");
      Fabrica.getIUsuariosCanales().comentarVideo("Rock and Rolllll",
          formatComentario.parse("30/10/2017 02:17"), "marcelot", "Sweet child'o mine", "kairoh");
      Fabrica.getIUsuariosCanales().comentarVideo("Rock and Rolllll",
          formatComentario.parse("30/10/2017 02:17"), "marcelot", "Sweet child'o mine", "juliob");
      Fabrica.getIUsuariosCanales().comentarVideo("Anoche exploto!!!",
          formatComentario.parse("25/08/2018 18:00"), "marcelot", "Dancing in the Dark", "kairoh");
      Fabrica.getIUsuariosCanales().comentarVideo("Me encanta este tema",
          formatComentario.parse("11/09/2017 03:45"), "marcelot", "Locura celeste", "tabarec");
      Fabrica.getIUsuariosCanales().comentarVideo("Me encanta este tema",
          formatComentario.parse("11/09/2017 03:45"), "marcelot", "Locura celeste", "cachilas");
      Fabrica.getIUsuariosCanales().responderComentario("Gracias Marce ;)",
          formatComentario.parse("15/09/2018 12:29"), "tabarec", "Locura celeste", "tabarec", 9);
      Fabrica.getIUsuariosCanales().responderComentario("Gracias Marce ;)",
          formatComentario.parse("15/09/2018 12:29"), "tabarec", "Locura celeste", "cachilas", 10);

      Fabrica.getIUsuariosCanales().valorarVideo("sergiop", false, V7.nombre,
          "hectorg");
      Fabrica.getIUsuariosCanales().valorarVideo("sergiop", true, V8.nombre,
          "hectorg");
      Fabrica.getIUsuariosCanales().valorarVideo("sergiop", true, "Show de goles", "juliob");
      Fabrica.getIUsuariosCanales().valorarVideo("nicoJ", false, "Locura celeste", "tabarec");
      Fabrica.getIUsuariosCanales().valorarVideo("nicoJ", false, "Locura celeste", "cachilas");
      Fabrica.getIUsuariosCanales().valorarVideo("nicoJ", true, V7.nombre, "hectorg");
      Fabrica.getIUsuariosCanales().valorarVideo("kairoh", true, V7.nombre, "hectorg");
      Fabrica.getIUsuariosCanales().valorarVideo("kairoh", true, "Inauguracion Estadio Peñarol",
          "juliob");
      Fabrica.getIUsuariosCanales().valorarVideo("marcelot", true, "Locura celeste", "tabarec");
      Fabrica.getIUsuariosCanales().valorarVideo("marcelot", true, "Dancing in the Dark",
          "kairoh");
    }
  }

  @Override
  public DtBusqueda busquedaGeneral(String txtBusqueda, int orden) {
    DtBusqueda busquedaVideos = busquedaVideo(txtBusqueda, orden);
    DtBusqueda busquedaListas = busquedaLista(txtBusqueda, orden);
    DtBusqueda busquedaUsuarios = busquedaCanales(txtBusqueda, orden);
    DtBusqueda resultados =
        new DtBusqueda(busquedaVideos.getVideos(), busquedaListas.getListas(), busquedaUsuarios.getUsuarios());
    return resultados;
  }

  @Override
  public DtBusqueda busquedaVideo(String txtBusqueda, int orden) {
    List<DtVideo> videos = new LinkedList<DtVideo>();
    List<DtLista> listas = new LinkedList<DtLista>();
    List<DtUsuario> usuarios = new LinkedList<DtUsuario>();
    for (Video vid : ManejadorVideos.getManejadorVideos().getVideos().values()) {
      if (vid.isVisible()) {
        if (vid.getNombre().toLowerCase().contains(txtBusqueda.toLowerCase())
            || vid.getDescripcion().toLowerCase().contains(txtBusqueda.toLowerCase())) {
          videos.add(vid.getDt());
        }
      }
    }
    DtBusqueda resultados = new DtBusqueda(videos, listas, usuarios);
    switch (orden) {
      case 1: resultados.getVideos().sort(Comparator.comparing(DtVideo::getFecha).reversed());
        break;
      case 2: resultados.getVideos().sort(Comparator.comparing(DtVideo::getNombre));
        break;
    }
    
    return resultados;
  }

  @Override
  public DtBusqueda busquedaLista(String txtBusqueda, int orden) {
    List<DtVideo> videos = new LinkedList<DtVideo>();
    List<DtLista> listas = new LinkedList<DtLista>();
    List<DtUsuario> usuarios = new LinkedList<DtUsuario>();
    for (ListaParticular lista : Fabrica.getIListas().getListasPublicas().values()) {
      if (lista.getNombre().toLowerCase().contains(txtBusqueda.toLowerCase())) {
        listas.add(lista.getDtLista());
      }
    }
    DtBusqueda resultados = new DtBusqueda(videos, listas, usuarios);
    switch (orden) {
      case 1: resultados.getListas().sort(Comparator.comparing(DtLista::getUltimaActividad).reversed());
        break;
      case 2: resultados.getListas().sort(Comparator.comparing(DtLista::getNombre));
        break;
    }
    
    return resultados;
  }

  @Override
  public DtBusqueda busquedaCanales(String txtBusqueda, int orden) {
    List<DtVideo> videos = new LinkedList<DtVideo>();
    List<DtLista> listas = new LinkedList<DtLista>();
    List<DtUsuario> usuarios = new LinkedList<DtUsuario>();
    for (Usuario usuario : ManejadorUsuarios.getManejadorUsuarios().getUsuarios().values()) {
      Canal canal = usuario.getCanal();
      if (canal.isVisible()) {
        if (canal.getNombre().toLowerCase().contains(txtBusqueda.toLowerCase())
            || canal.getDescripcion().toLowerCase().contains(txtBusqueda.toLowerCase())) {
          DtCanal dtCanal = new DtCanal(canal.getNombre(), canal.getDescripcion(),
              canal.isVisible(), canal.getUltimaActividad());
          DtUsuario dtUsuario = new DtUsuario(usuario.getId(), usuario.getNick(), dtCanal);
          dtUsuario.setImgPath(usuario.getPath());
          usuarios.add(dtUsuario);
        }
      }
    }
    DtBusqueda resultados = new DtBusqueda(videos, listas, usuarios);
    switch (orden) {
      case 1: resultados.getUsuarios().sort(Comparator.comparing(DtUsuario::getUltimaActividad).reversed());
        break;
      case 2: resultados.getUsuarios().sort(Comparator.comparing(DtUsuario::getCanal));
        break;
    }
    return resultados;
  }

}

package controladores;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

import clases.Canal;
import clases.ListaParticular;
import clases.Usuario;
import clases.Video;
import datatypes.DtBusqueda;
import datatypes.DtLista;
import datatypes.DtUsuario;
import datatypes.DtVideo;
import excepciones.DuplicateClassException;
import excepciones.NotFoundException;
import interfaces.Fabrica;
import interfaces.IDatos;
import manejadores.ManejadorUsuarios;
import manejadores.ManejadorVideos;

public class CtrlDatos implements IDatos {

  private static boolean cargaDatos = false;

  @Override
  public void cargaDatos() throws ParseException, IOException {
    if (!cargaDatos) {
      CtrlDatos.cargaDatos = true;
      DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
      String divisor = "/";

      class UsuarioBean {
        public String nick;
        public String nombre;
        public String apellido;
        public String pass;
        public String mail;
        public String nacimiento;
        public String nombreCanal;
        public String descripcionCanal;
        public boolean visibilidadCanal;
      };

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
      
      HR.nick = "hrubino";
      HR.nombre = "Horacio";
      HR.apellido = "Rubino";
      HR.pass = "Rufus123";
      HR.mail = "horacio.rubino@guambia.com.uy";
      HR.nacimiento = "25/02/1962";
      HR.nombreCanal = "Canal Horacio";
      HR.descripcionCanal = "El canal Horacio es para publicar contenido divertido";
      HR.visibilidadCanal = true;
      
      MB.nick = "mbusca";
      MB.nombre = "Martín";
      MB.apellido = "Buscaglia";
      MB.pass = "Cookie234";
      MB.mail = "Martin.bus@agadu.org.uy";
      MB.nacimiento = "14/06/1972";
      
      HG.nick = "hectorg";
      HG.nombre = "Héctor";
      HG.apellido = "Guido";
      HG.pass = "Poncho345";
      HG.mail = "hector.gui@elgapon.org.uy";
      HG.nacimiento = "07/01/1954";
      
      TC.nick = "tabarec";
      TC.nombre = "Tabaré";
      TC.apellido = "Cardozo";
      TC.pass = "Ketchup1";
      TC.mail = "tabare.car@agadu.org.uy";
      TC.nacimiento = "24/07/1971";

      CS.nick = "cachilas";
      CS.nombre = "Waldemar \"Cachila\"";
      CS.apellido = "Silva";
      CS.pass = "Sancho456";
      CS.mail = "Cachila.sil@c1080.org.uy";
      CS.nacimiento = "01/01/1947";
      
      JB.nick = "juliob";
      JB.nombre = "Julio";
      JB.apellido = "Bocca";
      JB.pass = "Salome56";
      JB.mail = "juliobocca@sodre.com.uy";
      JB.nacimiento = "16/03/1967";
      
      DP.nick = "diegop";
      DP.nombre = "Diego";
      DP.apellido = "Parodi";
      DP.pass = "Ruffo678";
      DP.mail = "diego@efectocine.com";
      DP.nacimiento = "01/01/1975";
      
      KH.nick = "kairoh";
      KH.nombre = "Kairo";
      KH.apellido = "Herrera";
      KH.pass = "Corbata15";
      KH.mail = "kairoher@pilsenrock.com.uy";
      KH.nacimiento = "25/04/1840";
      
      RH.nick = "robinh";
      RH.nombre = "Robin";
      RH.apellido = "Henderson";
      RH.pass = "Aquiles67";
      RH.mail = "Robin.h@tinglesa.com.uy";
      RH.nacimiento = "03/08/1940";
      
      MT.nick = "marcelot";
      MT.nombre = "Marcelo";
      MT.apellido = "Tinelli";
      MT.pass = "Mancha890";
      MT.mail = "marcelot@ideasdelsur.com.ar";
      MT.nacimiento = "01/04/1960";
      
      EN.nick = "novick";
      EN.nombre = "Edgardo";
      EN.apellido = "Novick";
      EN.pass = "Xenon987";
      EN.mail = "edgardo@novick.com.uy";
      EN.nacimiento = "17/07/1952";
      
      SP.nick = "sergiop";
      SP.nombre = "Sergio";
      SP.apellido = "Puglia";
      SP.pass = "Sultan876";
      SP.mail = "puglia@alpanpan.com.uy";
      SP.nacimiento = "28/01/1950";
      
      AR.nick = "chino";
      AR.nombre = "Alvaro";
      AR.apellido = "Recoba";
      AR.pass = "Laika765";
      AR.mail = "chino@trico.org.uy";
      AR.nacimiento = "17/03/1976";
      
      AP.nick = "tonyp";
      AP.nombre = "Antonio";
      AP.apellido = "Pacheco";
      AP.pass = "Kitty543";
      AP.mail = "eltony@manya.org.uy";
      AP.nacimiento = "14/02/1955";
      
      NJ.nick = "nicoJ";
      NJ.nombre = "Nicolás";
      NJ.apellido = "Jodal";
      NJ.pass = "Albino80";
      NJ.mail = "jodal@artech.com.uy";
      NJ.nacimiento = "09/08/1960";      

      Fabrica.getIUsuariosCanales().altaUsuario("hrubino", "Horacio", "Rubino",
          "horacio.rubino@guambia.com.uy", format.parse("25/02/1962"),
          "img" + divisor + "usuarios" + divisor + "horacio.JPG", "Canal Horacio",
          "El canal Horacio es para publicar contenido divertido", "Sin categoria", true,
          "pass");
      Fabrica.getIUsuariosCanales().altaUsuario("mbusca", "Martin", "Buscaglia",
          "Martin.bus@agadu.org.uy",
          format.parse("14/06/1972"), "img" + divisor + "usuarios" + divisor + "martin.JPG",
          "El bocha",
          "Mi canal para colgar cosas", "Sin categoria", true, "pass");
      Fabrica.getIUsuariosCanales().altaUsuario("hectorg", "H�ctor", "Guido",
          "hector.gui@elgalpon.org.uy",
          format.parse("07/01/1954"), "img" + divisor + "usuarios" + divisor + "null.JPG",
          "hectorg",
          "Canal HG",
          "Sin categoria", true, "pass");
      Fabrica.getIUsuariosCanales().altaUsuario("tabarec", "Tabare", "Cardozo",
          "tabare.car@agadu.org.uy",
          format.parse("24/07/1971"), "img" + divisor + "usuarios" + divisor + "tabare.JPG",
          "Tabar�",
          "Mi musica e ainda mais", "Sin categoria", true, "pass");
      Fabrica.getIUsuariosCanales().altaUsuario("cachilas", "Waldemar \"Cachila\"", "Silva",
          "Cachila.sil@c1080.org.uy", format.parse("01/01/1947"),
          "img" + divisor + "usuarios" + divisor + "cachila.JPG",
          "El Cachila", "Para juntar cosas", "Sin categoria", false, "pass");
      Fabrica.getIUsuariosCanales().altaUsuario("juliob", "Julio", "Bocca",
          "juliobocca@sodre.com.uy",
          format.parse("16/03/1967"), "img" + divisor + "usuarios" + divisor + "null.JPG", "juliob",
          "Canal de JB",
          "Sin categoria", true, "pass");
      Fabrica.getIUsuariosCanales().altaUsuario("diegop", "Diego", "Parodi", "diego@efectocine.com",
          format.parse("01/01/1975"), "img" + divisor + "usuarios" + divisor + "null.JPG", "diegop",
          "Canal de DP",
          "Sin categoria", true, "pass");
      Fabrica.getIUsuariosCanales().altaUsuario("kairoh", "Kairo", "Herrera",
          "kairoher@pilsenrock.com.uy",
          format.parse("25/04/1840"), "img" + divisor + "usuarios" + divisor + "kairo.JPG",
          "Kairo musica",
          "Videos de grandes canciones de hoy y siempre", "Sin categoria", true, "pass");
      Fabrica.getIUsuariosCanales().altaUsuario("robinh", "Robin", "Henderson",
          "Robin.h@tinglesa.com.uy",
          format.parse("03/08/1940"), "img" + divisor + "usuarios" + divisor + "null.JPG", "robinh",
          "Henderson",
          "Sin categoria", true, "pass");
      Fabrica.getIUsuariosCanales().altaUsuario("marcelot", "Marcelo", "Tinelli",
          "marcelot@ideasdelsur.com.ar", format.parse("01/04/1960"),
          "img" + divisor + "usuarios" + divisor + "null.JPG",
          "Tinelli total", "Todo lo que querias y más !", "Sin categoria", true, "pass");
      Fabrica.getIUsuariosCanales().altaUsuario("novick", "Edgardo", "Novick",
          "edgardo@novick.com.uy",
          format.parse("17/07/1952"), "img" + divisor + "usuarios" + divisor + "null.JPG",
          "Con la gente",
          "Preparando las elecciones", "Sin categoria", true, "pass");
      Fabrica.getIUsuariosCanales().altaUsuario("sergiop", "Sergio", "Puglia",
          "puglia@alpanpan.com.uy",
          format.parse("28/01/1950"), "img" + divisor + "usuarios" + divisor + "null.JPG",
          "Puglia invita",
          "Programas del ciclo y videos de cocina masterchef", "Sin categoria", true, "pass");
      Fabrica.getIUsuariosCanales().altaUsuario("chino", "Alvaro", "Recoba", "chino@trico.org.uy",
          format.parse("17/03/1976"), "img" + divisor + "usuarios" + divisor + "recoba.JPG",
          "Chino Recoba",
          "Canal de goles con Nacional ", "Sin categoria", false, "pass");
      Fabrica.getIUsuariosCanales().altaUsuario("tonyp", "Antonio", "Pacheco",
          "eltony@manya.org.uy",
          format.parse("14/02/1955"), "img" + divisor + "usuarios" + divisor + "pacheco.JPG",
          "Tony Pacheco",
          "Todos los goles con Peñarol", "Sin categoria", false, "pass");
      Fabrica.getIUsuariosCanales().altaUsuario("nicoJ", "Nicolas", "Jodal", "jodal@artech.com.uy",
          format.parse("09/08/1960"), "img" + divisor + "usuarios" + divisor + "null.JPG",
          "Desde Genexus",
          "Canal informacion C y T", "Sin categoria", true, "pass");

      Fabrica.getIUsuariosCanales().seguir("hrubino", "hectorg");
      Fabrica.getIUsuariosCanales().seguir("hrubino", "hectorg");
      Fabrica.getIUsuariosCanales().seguir("mbusca", "tabarec");
      Fabrica.getIUsuariosCanales().seguir("mbusca", "cachilas");
      Fabrica.getIUsuariosCanales().seguir("mbusca", "kairoh");
      Fabrica.getIUsuariosCanales().seguir("hectorg", "mbusca");
      Fabrica.getIUsuariosCanales().seguir("hectorg", "juliob");
      Fabrica.getIUsuariosCanales().seguir("tabarec", "hrubino");
      Fabrica.getIUsuariosCanales().seguir("tabarec", "cachilas");
      Fabrica.getIUsuariosCanales().seguir("cachilas", "hrubino");
      Fabrica.getIUsuariosCanales().seguir("juliob", "mbusca");
      Fabrica.getIUsuariosCanales().seguir("juliob", "diegop");
      Fabrica.getIUsuariosCanales().seguir("diegop", "hectorg");
      Fabrica.getIUsuariosCanales().seguir("kairoh", "sergiop");
      Fabrica.getIUsuariosCanales().seguir("robinh", "hectorg");
      Fabrica.getIUsuariosCanales().seguir("robinh", "juliob");
      Fabrica.getIUsuariosCanales().seguir("robinh", "diegop");
      Fabrica.getIUsuariosCanales().seguir("marcelot", "cachilas");
      Fabrica.getIUsuariosCanales().seguir("marcelot", "juliob");
      Fabrica.getIUsuariosCanales().seguir("marcelot", "kairoh");
      Fabrica.getIUsuariosCanales().seguir("novick", "hrubino");
      Fabrica.getIUsuariosCanales().seguir("novick", "cachilas");
      Fabrica.getIUsuariosCanales().seguir("novick", "juliob");
      Fabrica.getIUsuariosCanales().seguir("sergiop", "mbusca");
      Fabrica.getIUsuariosCanales().seguir("sergiop", "juliob");
      Fabrica.getIUsuariosCanales().seguir("sergiop", "kairoh");
      Fabrica.getIUsuariosCanales().seguir("chino", "tonyp");
      Fabrica.getIUsuariosCanales().seguir("tonyp", "chino");
      Fabrica.getIUsuariosCanales().seguir("nicoJ", "diegop");

      try {
        Fabrica.getICategorias().altaCategoria("Musica");
        Fabrica.getICategorias().altaCategoria("Deporte");
        Fabrica.getICategorias().altaCategoria("Carnaval");
        Fabrica.getICategorias().altaCategoria("Noticias");
        Fabrica.getICategorias().altaCategoria("Entretenimiento");
        Fabrica.getICategorias().altaCategoria("Comida");
        Fabrica.getICategorias().altaCategoria("Videojuegos");
        Fabrica.getICategorias().altaCategoria("Ciencia y Tecnologia");
        Fabrica.getICategorias().altaCategoria("ONG y activismo");
        Fabrica.getICategorias().altaCategoria("Gente y blogs");
        Fabrica.getICategorias().altaCategoria("Mascotas y animales");
        Fabrica.getICategorias().altaCategoria("Viajes y eventos");
      } catch (Exception e) {
        e.printStackTrace();
      }

      try {
        Fabrica.getIVideos().altaVideo("hectorg", "100 años de FING",
            "Del Ciclo más Universidad realizado por la UdelaR, compartimos con ustedes "
                + "un audiovisual realizado en 2016 por los 100 años de la denominación "
                + "Facultad de Ingeniería.\nExtraído del canal Teleuniversitaria UdelaR",
            Duration.parse("PT6M26S"), "https://youtu.be/peGS4TBxSaI", "Noticias",
            format.parse("03/08/2017"), true);
        Fabrica.getIVideos().altaVideo("hectorg", "50 años del InCo",
            "50 años del Instituto de Computación. Facultad de Ingeniería. UDELAR. "
                + "22 de noviembre 2017.\nLa mesa de apertura estuvo integrada por Simon, "
                + "el rector de la Universidad de la República (Udelar), Roberto Markarian; "
                + "la ministra de Industria, Energía y Minería, Carolina Cosse; el "
                + "presidente de la Cámara Uruguaya de Tecnologías de la Información "
                + "(CUTI), Leonardo Loureiro, y el director del Inco, Diego Vallespir.",
            Duration.parse("PT27M22S"), "https://youtu.be/GzOJSk4urlM", "Noticias",
            format.parse("24/11/2017"), true);
        Fabrica.getIVideos().altaVideo("hectorg", "Ingenieria de Muestra 2017",
            "La muestra más grande de la Ingeniería nacional se realiza el jueves 19, "
                + "viernes 20 y sábado 21 de octubre de 2017. Ingeniería deMuestra fue organizada "
                + "por la Facultad de Ingeniería de la Universidad de la "
                + "República y su Fundación Julio Ricaldoni.",
            Duration.parse("PT1M"), "https://youtu.be/RnaYRA1k5j4", "Noticias",
            format.parse("25/10/2017"), true);
        Fabrica.getIVideos().altaVideo("tabarec", "Locura celeste",
            "Tema Oficial de la cobertura celeste de Monte Carlo Televisión Canal 4 para "
                + "el Mundial de Futbol FIFA Rusia 2018.",
            Duration.parse("PT3M4S"), "https://youtu.be/PAfbzKcePx0", "Musica",
            format.parse("05/06/2018"), false);
        Fabrica.getIVideos().altaVideo("tabarec", "Niño payaso", "", Duration.parse("PT4M18S"),
            "https://youtu.be/K-uEIUnyZPg", "Musica", format.parse("20/10/2016"), false);
        Fabrica.getIVideos().altaVideo("tabarec", "Pacheco goles mas recordados", "",
            Duration.parse("PT5M48S"),
            "https://youtu.be/wlEd6-HsIxI", "Deporte", format.parse("05/07/2013"), false);
        Fabrica.getIVideos().altaVideo("cachilas", "Locura celeste",
            "Tema Oficial de la cobertura celeste de Monte Carlo Televisión Canal 4 para el "
                + "Mundial de Futbol FIFA Rusia 2018.",
            Duration.parse("PT3M4S"), "https://youtu.be/PAfbzKcePx0", "Musica",
            format.parse("05/06/2018"), false);
        Fabrica.getIVideos().altaVideo("cachilas", "Niño payaso", "", Duration.parse("PT4M18S"),
            "https://youtu.be/K-uEIUnyZPg", "Musica", format.parse("20/10/2016"), false);
        Fabrica.getIVideos().altaVideo("cachilas", "Etapa A contramano Liguilla", "",
            Duration.parse("PT57M15S"),
            "https://youtu.be/Es6GRMHXeCQ", "Carnaval", format.parse("17/12/2015"), false);
        Fabrica.getIVideos().altaVideo("cachilas", "Etapa Don Timoteo Liguilla", "",
            Duration.parse("PT51M38S"),
            "https://youtu.be/I_spHBU9ZsI", "Carnaval", format.parse("18/12/2015"), false);
        Fabrica.getIVideos().altaVideo("cachilas", "Recoba 20 mejores goles",
            "My Favorites\n\n\"El Chino\"",
            Duration.parse("PT13M36S"), "https://youtu.be/Gy3fZhWdLEQ", "Deporte",
            format.parse("14/11/2011"), false);
        Fabrica.getIVideos().altaVideo("juliob", "Sweet child'o mine",
            "#AppetiteForDestruction: The Debut Album, Remastered and Expanded. Available now as Box Set, Super Deluxe, Double LP, and Double CD here: https://lnk.to/AppetiteForDestruction... \n\nApple Music: https://lnk.to/AppetiteForDestruction... \niTunes: https://lnk.to/AppetiteForDestruction... \nSpotify: https://lnk.to/AppetiteForDestruction... \nAmazon: https://lnk.to/AppetiteForDestruction... \nGoogle Play: https://lnk.to/AppetiteForDestruction... \n\nSite: https://www.gunsnroses.com/ \nFacebook: https://www.facebook.com/gunsnroses\nTwitter: https://twitter.com/gunsnroses \nInstagram: https://www.instagram.com/gunsnroses \n\nMusic video by Guns N' Roses performing Sweet Child O' Mine. YouTube view counts pre-VEVO: 2,418,311. (C) 1987 Guns N' Roses under exclusive license to Geffen Records\n\n#GunsNRoses #SweetChildOMine #vevo #rockandroll #vevoofficial",
            Duration.parse("PT5M2S"), "https://youtu.be/1w7OgIMMRc4", "Musica",
            format.parse("24/12/2009"), true);
        Fabrica.getIVideos().altaVideo("juliob", "Thriller",
            "Listen to more Michael Jackson: https://MichaelJackson.lnk.to/Stream!to\n\nMichael Jackson's 14-minute short film \"Thriller\" revolutionized the music video genre forever. Hailed as the greatest music video of all time by MTV, VH1, Rolling Stone and others, \"Thriller,\" directed by John Landis, is also the only music video selected to be included in the Library of Congress' prestigious National Film Registry.\n\nBuy/Listen to Thriller 25: \nAmazon - http://smarturl.it/mj_thriller25_amzn...  \niTunes - http://smarturl.it/MJ_T25DE_OS?IQid=y...  \nOfficial Store - http://smarturl.it/MJ_T25DE_OS?IQid=y...  \nSpotify - http://smarturl.it/mj_thriller25_sptf...  \n\nWritten by Rod Temperton\nProduced by Quincy Jones for Quincy Jones Productions\nFrom the album Thriller, released November 30, 1982\nReleased as a single January 23, 1984\n\nTHE SHORT FILM\nDirector: John Landis\nPrimary Production Location: Los Angeles, California\n\nMichael Jackson's short film for \"Thriller\" was the third of three short films produced for recordings from Thriller, which continues its reign as the biggest selling album of all time with worldwide sales in excess of 105 million as of June 1, 2016 and in December 2015 became the first ever album to be awarded triple diamond status (i.e.: sales in excess of 30 million) by the RIAA for US sales alone. The \"Thriller\" single reached No. 1 in four countries in 1984, topping the U.S. Billboard Hot Dance Club Play chart as well as charts in Spain, France and Belgium. The song peaked at No. 4 on the Billboard Hot 100, making Thriller the first album to feature seven Top 10 singles. The Recording Industry Association of America certified \"Thriller\" Gold and Platinum on December 4, 1989. \n\nThe groundbreaking short films for the Thriller album, starting with \"Billie Jean,\" following up with \"Beat It\" and culminating with the epic, nearly 14-minute \"Thriller,\" truly expanded the possibilities of \"music video\" as art form. \"I wanted something that would glue you to the set, something you'd want to watch over and over,\" Michael wrote in his 1988 memoir Moonwalk. \"I wanted to be a pioneer in this relatively new medium and make the best short music movies we could make.\"\n\nIn the short film\'s extended prologue, Michael\'s moonlit date with his girlfriend (played by model Ola Ray) is interrupted by his sudden transformation into a howling werewolf. While the \"real\" Michael and Ola, observing the scene in a movie theater, walk home from the their date, Michael teases her by singing the verses of \"Thriller.\"\n\nFollow the Official Michael Jackson Accounts: \nFacebook - http://smarturl.it/mj_facebook?IQid=y...  \nTwitter - http://smarturl.it/mj_twitter?IQid=yt...  \nSpotify - http://smarturl.it/mj_spotify?IQid=yt...  \nNewsletter - http://smarturl.it/mj_newsletter?IQid...  \nYouTube - http://smarturl.it/mj_youtube?IQid=yt...  \nWebsite - http://smarturl.it/mj_website?IQid=yt...",
            Duration.parse("PT13M42S"), "https://youtu.be/PAfbzKcePx0", "Musica",
            format.parse("02/10/2009"), false);
        Fabrica.getIVideos().altaVideo("juliob", "Show de goles",
            "TORNEO CLAUSURA 2018\nFECHA 1.....",
            Duration.parse("PT4M23S"), "https://youtu.be/g46w4_kD_lA", "Deporte",
            format.parse("23/07/2018"), true);
        Fabrica.getIVideos().altaVideo("juliob", "Inauguracion Estadio Peñarol",
            "Recordemos la ceremonia de inauguración del Estadio de Peñarol.\nLlamado \""
                + "Estadio Campeón del Siglo\".",
            Duration.parse("PT3H27M26S"), "https://youtu.be/U6XPJ8Vz72A", "Deporte",
            format.parse("04/04/2016"), true);
        Fabrica.getIVideos().altaVideo("kairoh", "Sweet child'o mine",
            "#AppetiteForDestruction: The Debut Album, Remastered and Expanded. Available now as Box Set, Super Deluxe, Double LP, and Double CD here: https://lnk.to/AppetiteForDestruction... \n\nApple Music: https://lnk.to/AppetiteForDestruction... \niTunes: https://lnk.to/AppetiteForDestruction... \nSpotify: https://lnk.to/AppetiteForDestruction... \nAmazon: https://lnk.to/AppetiteForDestruction... \nGoogle Play: https://lnk.to/AppetiteForDestruction... \n\nSite: https://www.gunsnroses.com/ \nFacebook: https://www.facebook.com/gunsnroses\nTwitter: https://twitter.com/gunsnroses \nInstagram: https://www.instagram.com/gunsnroses \n\nMusic video by Guns N' Roses performing Sweet Child O' Mine. YouTube view counts pre-VEVO: 2,418,311. (C) 1987 Guns N' Roses under exclusive license to Geffen Records\n\n#GunsNRoses #SweetChildOMine #vevo #rockandroll #vevoofficial",
            Duration.parse("PT5M2S"), "https://youtu.be/1w7OgIMMRc4", "Musica",
            format.parse("24/12/2009"), true);
        Fabrica.getIVideos().altaVideo("kairoh", "Dancing in the Dark",
            "Bruce Springsteen's official music video for \'Dancing In The Dark\'. Click to listen to Bruce Springsteen on Spotify: http://smarturl.it/BSpringSpot?IQid=B...",
            Duration.parse("PT3M58S"), "https://youtu.be/129kuDCQtHs", "Musica",
            format.parse("03/10/2009"), true);
        Fabrica.getIVideos().altaVideo("kairoh", "Thriller",
            "Listen to more Michael Jackson: https://MichaelJackson.lnk.to/Stream!to\n\nMichael Jackson's 14-minute short film \"Thriller\" revolutionized the music video genre forever. Hailed as the greatest music video of all time by MTV, VH1, Rolling Stone and others, \"Thriller,\" directed by John Landis, is also the only music video selected to be included in the Library of Congress' prestigious National Film Registry.\n\nBuy/Listen to Thriller 25: \nAmazon - http://smarturl.it/mj_thriller25_amzn...  \niTunes - http://smarturl.it/MJ_T25DE_OS?IQid=y...  \nOfficial Store - http://smarturl.it/MJ_T25DE_OS?IQid=y...  \nSpotify - http://smarturl.it/mj_thriller25_sptf...  \n\nWritten by Rod Temperton\nProduced by Quincy Jones for Quincy Jones Productions\nFrom the album Thriller, released November 30, 1982\nReleased as a single January 23, 1984\n\nTHE SHORT FILM\nDirector: John Landis\nPrimary Production Location: Los Angeles, California\n\nMichael Jackson's short film for \"Thriller\" was the third of three short films produced for recordings from Thriller, which continues its reign as the biggest selling album of all time with worldwide sales in excess of 105 million as of June 1, 2016 and in December 2015 became the first ever album to be awarded triple diamond status (i.e.: sales in excess of 30 million) by the RIAA for US sales alone. The \"Thriller\" single reached No. 1 in four countries in 1984, topping the U.S. Billboard Hot Dance Club Play chart as well as charts in Spain, France and Belgium. The song peaked at No. 4 on the Billboard Hot 100, making Thriller the first album to feature seven Top 10 singles. The Recording Industry Association of America certified \"Thriller\" Gold and Platinum on December 4, 1989. \n\nThe groundbreaking short films for the Thriller album, starting with \"Billie Jean,\" following up with \"Beat It\" and culminating with the epic, nearly 14-minute \"Thriller,\" truly expanded the possibilities of \"music video\" as art form. \"I wanted something that would glue you to the set, something you'd want to watch over and over,\" Michael wrote in his 1988 memoir Moonwalk. \"I wanted to be a pioneer in this relatively new medium and make the best short music movies we could make.\"\n\nIn the short film\'s extended prologue, Michael\'s moonlit date with his girlfriend (played by model Ola Ray) is interrupted by his sudden transformation into a howling werewolf. While the \"real\" Michael and Ola, observing the scene in a movie theater, walk home from the their date, Michael teases her by singing the verses of \"Thriller.\"\n\nFollow the Official Michael Jackson Accounts: \nFacebook - http://smarturl.it/mj_facebook?IQid=y...  \nTwitter - http://smarturl.it/mj_twitter?IQid=yt...  \nSpotify - http://smarturl.it/mj_spotify?IQid=yt...  \nNewsletter - http://smarturl.it/mj_newsletter?IQid...  \nYouTube - http://smarturl.it/mj_youtube?IQid=yt...  \nWebsite - http://smarturl.it/mj_website?IQid=yt...",
            Duration.parse("PT13M42S"), "https://youtu.be/sOnqjkJTMaA", "Musica",
            format.parse("02/10/2009"), true);
        Fabrica.getIVideos().altaVideo("chino", "Recoba 20 mejores goles",
            "My Favorites\n\n\"El Chino\"",
            Duration.parse("PT13M36S"), "https://youtu.be/Gy3fZhWdLEQ", "Deporte",
            format.parse("14/11/2011"), false);
        Fabrica.getIVideos().altaVideo("tonyp", "Pacheco goles mas recordados", "",
            Duration.parse("PT5M48S"),
            "https://youtu.be/wlEd6-HsIxI", "Deporte", format.parse("05/07/2013"), false);
        Fabrica.getIVideos().altaVideo("nicoJ", "Entrevista a director CUTI",
            "Segunda parte de la entrevista realizada por la periodista "
                + "Paula Echevarr�a al director de CUTI",
            Duration.parse("PT5M39S"), "https://youtu.be/Eq5uBEzI6qs", "Ciencia y Tecnologia",
            format.parse("03/04/2017"), true);
        Fabrica.getIVideos().altaVideo("nicoJ", "Ventana al futuro Uruguay y deficit de ingenieros",
            "VEA ESTE CONTENIDO EN EnPerspectiva.net: http://www.enperspectiva.net/en-persp...\n\nEn Uruguay hay un ingeniero por cada tres abogados y cada seis medicos. Los datos se desprenden del Panorama de la Educación 2014 del anuario del Ministerio de Educación y Cultura. Ese año egresaron de la Universidad de la República 348 ingenieros, una cifra que supone un leve aumento con respecto a los anteriores.\n\nSin embargo, según sostienen desde la Facultad de Ingeniería, ese n�mero sigue siendo insuficiente y el d�ficit de profesionales puede significar una traba para el desarrollo del pa�s. De ese desaf�o hablaremos en esta nueva entrega de Ventana al Futuro; para eso nos acompa�a la decana de esa casa de estudios y presidente de la Fundación Julio Ricaldoni, María Simón.",
            Duration.parse("PT192M1S"), "https://youtu.be/zBR2pnASlQE", "Ciencia y Tecnologia",
            format.parse("20/07/2016"), true);
      } catch (DuplicateClassException exception) {
        exception.printStackTrace();
      } catch (NotFoundException exception) {
        exception.printStackTrace();
      }

      try {
        Fabrica.getIListas().altaListaDefecto("Escuchar más tarde");
        Fabrica.getIListas().altaListaDefecto("Deporte total");
        Fabrica.getIListas().altaListaDefecto("Novedades generales");
      } catch (Exception e) {
        e.printStackTrace();
      }

      try {
        Fabrica.getIListas().altaListaParticular("Nostalgia", "kairoh", true);
        Fabrica.getIListas().altaListaParticular("De fiesta", "tabarec", false);
        Fabrica.getIListas().altaListaParticular("Novedades FING", "hectorg", true);
        Fabrica.getIListas().altaListaParticular("De todo un poco", "cachilas", false);
        Fabrica.getIListas().altaListaParticular("Noticias y CYT", "nicoJ", true);
        Fabrica.getIListas().altaListaParticular("Solo deportes", "juliob", true);
      } catch (Exception e) {
        e.printStackTrace();
      }

      try {
        Fabrica.getIListas().agregarVideoLista("juliob", "Sweet child'o mine", "kairoh",
            "Nostalgia",
            false);
        Fabrica.getIListas().agregarVideoLista("kairoh", "Sweet child'o mine", "kairoh",
            "Nostalgia",
            false);
        Fabrica.getIListas().agregarVideoLista("kairoh", "Dancing in the Dark", "kairoh",
            "Nostalgia",
            false);
        Fabrica.getIListas().agregarVideoLista("kairoh", "Thriller", "kairoh", "Nostalgia", false);
        Fabrica.getIListas().agregarVideoLista("juliob", "Thriller", "kairoh", "Nostalgia", false);
        Fabrica.getIListas().agregarVideoLista("tabarec", "Locura celeste", "tabarec", "De fiesta",
            false);
        Fabrica.getIListas().agregarVideoLista("cachilas", "Locura celeste", "tabarec", "De fiesta",
            false);
        Fabrica.getIListas().agregarVideoLista("tabarec", "Niño payaso", "tabarec", "De fiesta",
            false);
        Fabrica.getIListas().agregarVideoLista("cachilas", "Niño payaso", "tabarec", "De fiesta",
            false);
        Fabrica.getIListas().agregarVideoLista("cachilas", "Etapa Don Timoteo Liguilla", "tabarec",
            "De fiesta",
            false);
        Fabrica.getIListas().agregarVideoLista("hectorg", "100 años de FING", "hectorg",
            "Novedades FING",
            false);
        Fabrica.getIListas().agregarVideoLista("hectorg", "50 años del InCo", "hectorg",
            "Novedades FING",
            false);
        Fabrica.getIListas().agregarVideoLista("hectorg", "Ingenieria de Muestra 2017", "hectorg",
            "Novedades FING", false);
        Fabrica.getIListas().agregarVideoLista("tabarec", "Locura celeste", "cachilas",
            "De todo un poco",
            false);
        Fabrica.getIListas().agregarVideoLista("cachilas", "Locura celeste", "cachilas",
            "De todo un poco",
            false);
        Fabrica.getIListas().agregarVideoLista("tabarec", "Niño payaso", "cachilas",
            "De todo un poco", false);
        Fabrica.getIListas().agregarVideoLista("cachilas", "Niño payaso", "cachilas",
            "De todo un poco",
            false);
        Fabrica.getIListas().agregarVideoLista("cachilas", "Etapa A contramano Liguilla",
            "cachilas",
            "De todo un poco", false);
        Fabrica.getIListas().agregarVideoLista("cachilas", "Etapa Don Timoteo Liguilla", "cachilas",
            "De todo un poco", false);
        Fabrica.getIListas().agregarVideoLista("juliob", "Inauguracion Estadio Peñarol",
            "cachilas",
            "De todo un poco", false);
        Fabrica.getIListas().agregarVideoLista("hectorg", "Ingenieria de Muestra 2017", "nicoJ",
            "Noticias y CYT", false);
        Fabrica.getIListas().agregarVideoLista("nicoJ",
            "Ventana al futuro Uruguay y deficit de ingenieros",
            "nicoJ", "Noticias y CYT", false);
        Fabrica.getIListas().agregarVideoLista("juliob", "Show de goles", "juliob", "Solo deportes",
            false);
        Fabrica.getIListas().agregarVideoLista("juliob", "Inauguracion Estadio Peñarol", "juliob",
            "Solo deportes", false);
      } catch (Exception e1 ) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }

      DateFormat formatComentario = new SimpleDateFormat("dd/mm/yyyy HH:mm");
      Fabrica.getIUsuariosCanales().comentarVideo("Fue un gran evento",
          formatComentario.parse("05/12/2017 14:35"), "nicoJ", "50 años del InCo", "hectorg");
      Fabrica.getIUsuariosCanales().responderComentario(
          "Para el proximo aniversario ofrezco vamo' con los Momo",
          format.parse("08/12/2017 01:47"),
          "hrubino", "50 años del InCo", "hectorg", 0);
      Fabrica.getIUsuariosCanales().responderComentario("Yo ofrezco a la banda tb",
          format.parse("10/12/2017 17:09"), "tabarec", "50 años del InCo", "hectorg", 1);
      Fabrica.getIUsuariosCanales().comentarVideo("Felicitaciones FING!!!",
          formatComentario.parse("07/09/2017 04:56"), "nicoJ", "100 años de FING", "hectorg");
      Fabrica.getIUsuariosCanales().comentarVideo("Un gusto cubrir eventos como este.",
          formatComentario.parse("23/10/2017 12:58"), "kairoh", "Ingenieria de Muestra 2017",
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
      try {
        Fabrica.getIUsuariosCanales().valorarVideo("sergiop", false, "50 años del InCo",
            "hectorg");
        Fabrica.getIUsuariosCanales().valorarVideo("sergiop", true, "Ingenieria de Muestra 2017",
            "hectorg");
        Fabrica.getIUsuariosCanales().valorarVideo("sergiop", true, "Show de goles", "juliob");
        Fabrica.getIUsuariosCanales().valorarVideo("nicoJ", false, "Locura celeste", "tabarec");
        Fabrica.getIUsuariosCanales().valorarVideo("nicoJ", false, "Locura celeste", "cachilas");
        Fabrica.getIUsuariosCanales().valorarVideo("nicoJ", true, "50 años del InCo", "hectorg");
        Fabrica.getIUsuariosCanales().valorarVideo("kairoh", true, "50 años del InCo", "hectorg");
        Fabrica.getIUsuariosCanales().valorarVideo("kairoh", true, "Inauguracion Estadio Peñarol",
            "juliob");
        Fabrica.getIUsuariosCanales().valorarVideo("marcelot", true, "Locura celeste", "tabarec");
        Fabrica.getIUsuariosCanales().valorarVideo("marcelot", true, "Dancing in the Dark",
            "kairoh");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public DtBusqueda busquedaGeneral(String txtBusqueda) {
    DtBusqueda busquedaVideos = busquedaVideo(txtBusqueda);
    DtBusqueda busquedaListas = busquedaLista(txtBusqueda);
    DtBusqueda busquedaUsuarios = busquedaCanales(txtBusqueda);
    DtBusqueda resultados =
        new DtBusqueda(busquedaVideos.videos, busquedaListas.listas, busquedaUsuarios.usuarios);
    return resultados;
  }

  @Override
  public DtBusqueda busquedaVideo(String txtBusqueda) {
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
    return resultados;
  }

  @Override
  public DtBusqueda busquedaLista(String txtBusqueda) {
    List<DtVideo> videos = new LinkedList<DtVideo>();
    List<DtLista> listas = new LinkedList<DtLista>();
    List<DtUsuario> usuarios = new LinkedList<DtUsuario>();
    for (ListaParticular lista : Fabrica.getIListas().getListasPublicas().values()) {
      if (lista.getNombre().toLowerCase().contains(txtBusqueda.toLowerCase())) {
        listas.add(lista.getDtLista());
      }
    }
    DtBusqueda resultados = new DtBusqueda(videos, listas, usuarios);
    return resultados;
  }

  @Override
  public DtBusqueda busquedaCanales(String txtBusqueda) {
    List<DtVideo> videos = new LinkedList<DtVideo>();
    List<DtLista> listas = new LinkedList<DtLista>();
    List<DtUsuario> usuarios = new LinkedList<DtUsuario>();
    for (Usuario usuario : ManejadorUsuarios.getManejadorUsuarios().getMap().values()) {
      Canal canal = usuario.getCanal();
      if (canal.isVisible()) {
        if (canal.getNombre().toLowerCase().contains(txtBusqueda.toLowerCase())
            || canal.getDescripcion().toLowerCase().contains(txtBusqueda.toLowerCase())) {
          DtUsuario dtUsuario = new DtUsuario(usuario.getNick(), usuario.getCanal().getNombre(),
              usuario.getPath(), canal.getUltimaActividad());
          usuarios.add(dtUsuario);
        }
      }
    }
    DtBusqueda resultados = new DtBusqueda(videos, listas, usuarios);
    return resultados;
  }

}

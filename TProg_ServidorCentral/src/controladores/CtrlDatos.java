package controladores;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Collection;
import java.util.Comparator;
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
import manejadores.ManejadorListasParticulares;
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

      Fabrica.getIUsuariosCanales().altaUsuario("hrubino", "Horacio", "Rubino",
          "horacio.rubino@guambia.com.uy", format.parse("25/02/1962"),
          "img" + divisor + "usuarios" + divisor + "horacio.JPG", "Canal Horacio",
          "El canal Horacio es para publicar contenido divertido", "Sin categoria", true, "pass");
      Fabrica.getIUsuariosCanales().altaUsuario("mbusca", "Martin", "Buscaglia",
          "Martin.bus@agadu.org.uy",
          format.parse("14/06/1972"), "img" + divisor + "usuarios" + divisor + "martin.jpg",
          "El bocha",
          "Mi canal para colgar cosas", "Sin categoria", true, "pass");
      Fabrica.getIUsuariosCanales().altaUsuario("hectorg", "H�ctor", "Guido",
          "hector.gui@elgalpon.org.uy",
          format.parse("07/01/1954"), "img" + divisor + "usuarios" + divisor + "null.jpg",
          "hectorg",
          "Canal HG",
          "Sin categoria", true, "pass");
      Fabrica.getIUsuariosCanales().altaUsuario("tabarec", "Tabare", "Cardozo",
          "tabare.car@agadu.org.uy",
          format.parse("24/07/1971"), "img" + divisor + "usuarios" + divisor + "tabare.jpg",
          "Tabar�",
          "Mi musica e ainda mais", "Sin categoria", true, "pass");
      Fabrica.getIUsuariosCanales().altaUsuario("cachilas", "Waldemar \"Cachila\"", "Silva",
          "Cachila.sil@c1080.org.uy", format.parse("01/01/1947"),
          "img" + divisor + "usuarios" + divisor + "cachila.jpg",
          "El Cachila", "Para juntar cosas", "Sin categoria", false, "pass");
      Fabrica.getIUsuariosCanales().altaUsuario("juliob", "Julio", "Bocca",
          "juliobocca@sodre.com.uy",
          format.parse("16/03/1967"), "img" + divisor + "usuarios" + divisor + "null.jpg", "juliob",
          "Canal de JB",
          "Sin categoria", true, "pass");
      Fabrica.getIUsuariosCanales().altaUsuario("diegop", "Diego", "Parodi", "diego@efectocine.com",
          format.parse("01/01/1975"), "img" + divisor + "usuarios" + divisor + "null.jpg", "diegop",
          "Canal de DP",
          "Sin categoria", true, "pass");
      Fabrica.getIUsuariosCanales().altaUsuario("kairoh", "Kairo", "Herrera",
          "kairoher@pilsenrock.com.uy",
          format.parse("25/04/1840"), "img" + divisor + "usuarios" + divisor + "kairo.jpg",
          "Kairo musica",
          "Videos de grandes canciones de hoy y siempre", "Sin categoria", true, "pass");
      Fabrica.getIUsuariosCanales().altaUsuario("robinh", "Robin", "Henderson",
          "Robin.h@tinglesa.com.uy",
          format.parse("03/08/1940"), "img" + divisor + "usuarios" + divisor + "null.jpg", "robinh",
          "Henderson",
          "Sin categoria", true, "pass");
      Fabrica.getIUsuariosCanales().altaUsuario("marcelot", "Marcelo", "Tinelli",
          "marcelot@ideasdelsur.com.ar", format.parse("01/04/1960"),
          "img" + divisor + "usuarios" + divisor + "null.jpg",
          "Tinelli total", "Todo lo que querias y m�s !", "Sin categoria", true, "pass");
      Fabrica.getIUsuariosCanales().altaUsuario("novick", "Edgardo", "Novick",
          "edgardo@novick.com.uy",
          format.parse("17/07/1952"), "img" + divisor + "usuarios" + divisor + "null.jpg",
          "Con la gente",
          "Preparando las elecciones", "Sin categoria", true, "pass");
      Fabrica.getIUsuariosCanales().altaUsuario("sergiop", "Sergio", "Puglia",
          "puglia@alpanpan.com.uy",
          format.parse("28/01/1950"), "img" + divisor + "usuarios" + divisor + "null.jpg",
          "Puglia invita",
          "Programas del ciclo y videos de cocina masterchef", "Sin categoria", true, "pass");
      Fabrica.getIUsuariosCanales().altaUsuario("chino", "Alvaro", "Recoba", "chino@trico.org.uy",
          format.parse("17/03/1976"), "img" + divisor + "usuarios" + divisor + "recoba.jpg",
          "Chino Recoba",
          "Canal de goles con Nacional ", "Sin categoria", false, "pass");
      Fabrica.getIUsuariosCanales().altaUsuario("tonyp", "Antonio", "Pacheco",
          "eltony@manya.org.uy",
          format.parse("14/02/1955"), "img" + divisor + "usuarios" + divisor + "pacheco.jpg",
          "Tony Pacheco",
          "Todos los goles con Pe�arol", "Sin categoria", false, "pass");
      Fabrica.getIUsuariosCanales().altaUsuario("nicoJ", "Nicolas", "Jodal", "jodal@artech.com.uy",
          format.parse("09/08/1960"), "img" + divisor + "usuarios" + divisor + "null.jpg",
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
        Fabrica.getIVideos().altaVideo("hectorg", "100 a�os de FING",
            "Del Ciclo m�s Universidad realizado por la UdelaR, compartimos con ustedes "
                + "un audiovisual realizado en 2016 por los 100 a�os de la denominaci�n "
                + "Facultad de Ingenier�a.\nExtra�do del canal Teleuniversitaria UdelaR",
            Duration.parse("PT6M26S"), "https://youtu.be/peGS4TBxSaI", "Noticias",
            format.parse("03/08/2017"), true);
        Fabrica.getIVideos().altaVideo("hectorg", "50 a�os del InCo",
            "50 a�os del Instituto de Computaci�n. Facultad de Ingenier�a. UDELAR. "
                + "22 de noviembre 2017.\nLa mesa de apertura estuvo integrada por Simon, "
                + "el rector de la Universidad de la Rep�blica (Udelar), Roberto Markarian; "
                + "la ministra de Industria, Energ�a y Miner�a, Carolina Cosse; el "
                + "presidente de la C�mara Uruguaya de Tecnolog�as de la Informaci�n "
                + "(CUTI), Leonardo Loureiro, y el director del Inco, Diego Vallespir.",
            Duration.parse("PT27M22S"), "https://youtu.be/GzOJSk4urlM", "Noticias",
            format.parse("24/11/2017"), true);
        Fabrica.getIVideos().altaVideo("hectorg", "Ingenieria de Muestra 2017",
            "La muestra m�s grande de la ingenier�a nacional se realiz� el jueves 19, "
                + "viernes 20 y s�bado 21 de octubre de 2017. Ingenier�a deMuestra fue organizada "
                + "por la Facultad de Ingenier�a de la Universidad de la "
                + "Rep�blica y su Fundaci�n Julio Ricaldoni.",
            Duration.parse("PT1M"), "https://youtu.be/RnaYRA1k5j4", "Noticias",
            format.parse("25/10/2017"), true);
        Fabrica.getIVideos().altaVideo("tabarec", "Locura celeste",
            "Tema Oficial de la cobertura celeste de Monte Carlo Televisi�n Canal 4 para "
                + "el Mundial de Futbol FIFA Rusia 2018.",
            Duration.parse("PT3M4S"), "https://youtu.be/PAfbzKcePx0", "Musica",
            format.parse("05/06/2018"), false);
        Fabrica.getIVideos().altaVideo("tabarec", "Ni�o payaso", "", Duration.parse("PT4M18S"),
            "https://youtu.be/K-uEIUnyZPg", "Musica", format.parse("20/10/2016"), false);
        Fabrica.getIVideos().altaVideo("tabarec", "Pacheco goles mas recordados", "",
            Duration.parse("PT5M48S"),
            "https://youtu.be/wlEd6-HsIxI", "Deporte", format.parse("05/07/2013"), false);
        Fabrica.getIVideos().altaVideo("cachilas", "Locura celeste",
            "Tema Oficial de la cobertura celeste de Monte Carlo Televisi�n Canal 4 para el "
                + "Mundial de Futbol FIFA Rusia 2018.",
            Duration.parse("PT3M4S"), "https://youtu.be/PAfbzKcePx0", "Musica",
            format.parse("05/06/2018"), false);
        Fabrica.getIVideos().altaVideo("cachilas", "Ni�o payaso", "", Duration.parse("PT4M18S"),
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
        Fabrica.getIVideos().altaVideo("juliob", "Inauguracion Estadio Pe�arol",
            "Recordemos la ceremonia de inauguraci�n del Estadio de Pe�arol.\nLlamado \""
                + "Estadio Campe�n del Siglo\".",
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
            "VEA ESTE CONTENIDO EN EnPerspectiva.net: http://www.enperspectiva.net/en-persp...\n\nEn Uruguay hay un ingeniero por cada tres abogados y cada seis m�dicos. Los datos se desprenden del Panorama de la Educaci�n 2014 del anuario del Ministerio de Educaci�n y Cultura. Ese a�o egresaron de la Universidad de la Rep�blica 348 ingenieros, una cifra que supone un leve aumento con respecto a los anteriores.\n\nSin embargo, seg�n sostienen desde la Facultad de Ingenier�a, ese n�mero sigue siendo insuficiente y el d�ficit de profesionales puede significar una traba para el desarrollo del pa�s. De ese desaf�o hablaremos en esta nueva entrega de Ventana al Futuro; para eso nos acompa�a la decana de esa casa de estudios y presidente de la Fundaci�n Julio Ricaldoni, Mar�a Sim�n.",
            Duration.parse("PT192M1S"), "https://youtu.be/zBR2pnASlQE", "Ciencia y Tecnologia",
            format.parse("20/07/2016"), true);
      } catch (DuplicateClassException exception) {
        exception.printStackTrace();
      } catch (NotFoundException exception) {
        exception.printStackTrace();
      }

      try {
        Fabrica.getIListas().altaListaDefecto("Escuchar mas tarde");
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
        Fabrica.getIListas().agregarVideoLista("juliob", "Sweet child'o mine", "kairoh", "Nostalgia",
            false);
        Fabrica.getIListas().agregarVideoLista("kairoh", "Sweet child'o mine", "kairoh", "Nostalgia",
            false);
        Fabrica.getIListas().agregarVideoLista("kairoh", "Dancing in the Dark", "kairoh", "Nostalgia",
            false);
        Fabrica.getIListas().agregarVideoLista("kairoh", "Thriller", "kairoh", "Nostalgia", false);
        Fabrica.getIListas().agregarVideoLista("juliob", "Thriller", "kairoh", "Nostalgia", false);
        Fabrica.getIListas().agregarVideoLista("tabarec", "Locura celeste", "tabarec", "De fiesta",
            false);
        Fabrica.getIListas().agregarVideoLista("cachilas", "Locura celeste", "tabarec", "De fiesta",
            false);
        Fabrica.getIListas().agregarVideoLista("tabarec", "Ni�o payaso", "tabarec", "De fiesta",
            false);
        Fabrica.getIListas().agregarVideoLista("cachilas", "Ni�o payaso", "tabarec", "De fiesta",
            false);
        Fabrica.getIListas().agregarVideoLista("cachilas", "Etapa Don Timoteo Liguilla", "tabarec",
            "De fiesta",
            false);
        Fabrica.getIListas().agregarVideoLista("hectorg", "100 a�os de FING", "hectorg",
            "Novedades FING",
            false);
        Fabrica.getIListas().agregarVideoLista("hectorg", "50 a�os del InCo", "hectorg",
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
        Fabrica.getIListas().agregarVideoLista("tabarec", "Ni�o payaso", "cachilas",
            "De todo un poco", false);
        Fabrica.getIListas().agregarVideoLista("cachilas", "Ni�o payaso", "cachilas",
            "De todo un poco",
            false);
        Fabrica.getIListas().agregarVideoLista("cachilas", "Etapa A contramano Liguilla", "cachilas",
            "De todo un poco", false);
        Fabrica.getIListas().agregarVideoLista("cachilas", "Etapa Don Timoteo Liguilla", "cachilas",
            "De todo un poco", false);
        Fabrica.getIListas().agregarVideoLista("juliob", "Inauguracion Estadio Pe�arol", "cachilas",
            "De todo un poco", false);
        Fabrica.getIListas().agregarVideoLista("hectorg", "Ingenieria de Muestra 2017", "nicoJ",
            "Noticias y CYT", false);
        Fabrica.getIListas().agregarVideoLista("nicoJ",
            "Ventana al futuro Uruguay y deficit de ingenieros",
            "nicoJ", "Noticias y CYT", false);
        Fabrica.getIListas().agregarVideoLista("juliob", "Show de goles", "juliob", "Solo deportes",
            false);
        Fabrica.getIListas().agregarVideoLista("juliob", "Inauguracion Estadio Pe�arol", "juliob",
            "Solo deportes", false);
      } catch (DuplicateClassException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }

      DateFormat formatComentario = new SimpleDateFormat("dd/mm/yyyy HH:mm");
      Fabrica.getIUsuariosCanales().comentarVideo("Fue un gran evento",
          formatComentario.parse("05/12/2017 14:35"), "nicoJ", "50 a�os del InCo", "hectorg");
      Fabrica.getIUsuariosCanales().responderComentario(
          "Para el proximo aniversario ofrezco vamo' con los Momo",
          format.parse("08/12/2017 01:47"),
          "hrubino", "50 a�os del InCo", "hectorg", 0);
      Fabrica.getIUsuariosCanales().responderComentario("Yo ofrezco a la banda tb",
          format.parse("10/12/2017 17:09"), "tabarec", "50 a�os del InCo", "hectorg", 1);
      Fabrica.getIUsuariosCanales().comentarVideo("Felicitaciones FING!!!",
          formatComentario.parse("07/09/2017 04:56"), "nicoJ", "100 a�os de FING", "hectorg");
      Fabrica.getIUsuariosCanales().comentarVideo("Un gusto cubrir eventos como este.",
          formatComentario.parse("23/10/2017 12:58"), "kairoh", "Ingenieria de Muestra 2017",
          "hectorg");
      Fabrica.getIUsuariosCanales().comentarVideo("Pe�arol pe�arol!!!",
          formatComentario.parse("14/11/2016 05:34"), "kairoh", "Inauguracion Estadio Pe�arol",
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
        Fabrica.getIUsuariosCanales().valorarVideo("sergiop", false, "50 a�os del InCo",
            "hectorg");
        Fabrica.getIUsuariosCanales().valorarVideo("sergiop", true, "Ingenieria de Muestra 2017",
            "hectorg");
        Fabrica.getIUsuariosCanales().valorarVideo("sergiop", true, "Show de goles", "juliob");
        Fabrica.getIUsuariosCanales().valorarVideo("nicoJ", false, "Locura celeste", "tabarec");
        Fabrica.getIUsuariosCanales().valorarVideo("nicoJ", false, "Locura celeste", "cachilas");
        Fabrica.getIUsuariosCanales().valorarVideo("nicoJ", true, "50 a�os del InCo", "hectorg");
        Fabrica.getIUsuariosCanales().valorarVideo("kairoh", true, "50 a�os del InCo", "hectorg");
        Fabrica.getIUsuariosCanales().valorarVideo("kairoh", true, "Inauguracion Estadio Pe�arol",
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
    List<DtVideo> videos = new LinkedList<DtVideo>();
    List<DtLista> listas = new LinkedList<DtLista>();
    List<DtUsuario> usuarios = new LinkedList<DtUsuario>();
    for (Video vid : ManejadorVideos.getManejadorVideos().getVideos().values()) {
      if (vid.isVisible()) {
        if (vid.getNombre().toLowerCase().contains(txtBusqueda.toLowerCase()) || vid.getDescripcion().toLowerCase().contains(txtBusqueda.toLowerCase())) {
          videos.add(vid.getDt());
        }
      }
    }
    for (ListaParticular lista : Fabrica.getIListas().getListasPublicas().values()) {
      if (lista.getNombre().toLowerCase().contains(txtBusqueda.toLowerCase())) {
        listas.add(lista.getDtLista());
      }
    }
    for (Usuario usuario : ManejadorUsuarios.getManejadorUsuarios().getMap().values()) {
      Canal canal = usuario.getCanal();
      if (canal.isVisible()) {
        if (canal.getNombre().toLowerCase().contains(txtBusqueda.toLowerCase()) || canal.getDescripcion().toLowerCase().contains(txtBusqueda.toLowerCase())) {
          DtUsuario dtUsuario = new DtUsuario(usuario.getNick(),usuario.getCanal().getNombre(), usuario.getPath(), canal.getUltimaActividad());
          usuarios.add(dtUsuario);
        }
      }
    }
    videos.sort(Comparator.comparing(DtVideo::getNombre));
    DtBusqueda resultados  = new DtBusqueda(videos, listas, usuarios);
    return resultados;
  }
  
  @Override
  public DtBusqueda busquedaVideo(String txtBusqueda) {
    List<DtVideo> videos = new LinkedList<DtVideo>();
    List<DtLista> listas = new LinkedList<DtLista>();
    List<DtUsuario> usuarios = new LinkedList<DtUsuario>();
    for (Video vid : ManejadorVideos.getManejadorVideos().getVideos().values()) {
      if (vid.isVisible()) {
        if (vid.getNombre().toLowerCase().contains(txtBusqueda.toLowerCase()) || vid.getDescripcion().toLowerCase().contains(txtBusqueda.toLowerCase())) {
          videos.add(vid.getDt());
        }
      }
    }
    DtBusqueda resultados  = new DtBusqueda(videos, listas, usuarios);
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
    DtBusqueda resultados  = new DtBusqueda(videos, listas, usuarios);
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
        if (canal.getNombre().toLowerCase().contains(txtBusqueda.toLowerCase()) || canal.getDescripcion().toLowerCase().contains(txtBusqueda.toLowerCase())) {
          DtUsuario dtUsuario = new DtUsuario(usuario.getNick(),usuario.getCanal().getNombre(), usuario.getPath(), canal.getUltimaActividad());
          usuarios.add(dtUsuario);
        }
      }
    }
    DtBusqueda resultados = new DtBusqueda(videos, listas, usuarios);
    return resultados;
  }

}

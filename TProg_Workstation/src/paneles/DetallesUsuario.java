package paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import datatypes.DtLista;
import datatypes.DtUsuario;
import datatypes.DtVideo;
import interfaces.Fabrica;
import interfaces.IListas;
import interfaces.IUsuariosCanales;

@SuppressWarnings("serial")
public class DetallesUsuario extends JPanel {
  
  private IUsuariosCanales ctrlUsu = Fabrica.getIUsuariosCanales();
  private IListas ctrlLis = null;
  private List<DtLista> listas;
  private List<DtVideo> videosUsuario;
  private String noImagen = "img//sinImagen.jpg";
  private DefaultListModel<String> modelListas = new DefaultListModel<>();
  private JList<String> listasDeReproduccion = new JList<>(modelListas);
  private DefaultListModel<String> modelSeguidores = new DefaultListModel<>();
  private DefaultListModel<String> modelSeguidos = new DefaultListModel<>();
  private JList<String> listaSeguidores = new JList<>(modelSeguidores);
  private JList<String> listaSeguidos = new JList<>(modelSeguidos);
  private DefaultListModel<String> modelVideos = new DefaultListModel<>();
  private JList<String> videos = new JList<>(modelVideos);
  private boolean editar = false;
  private JTextField textField;

  public void setEditar(boolean b) {
    this.editar = b;
  }

  public DetallesUsuario(int idUsuario) {
    try{
    DtUsuario dtUsuario = ctrlUsu.getDt(idUsuario);

    String nombre = dtUsuario.getNombre();
    String apellido = dtUsuario.getApellido();
    String correo = dtUsuario.getCorreo();
    String canal = dtUsuario.getCanal().getNombreCanal();
    String descripcionCanal = dtUsuario.getCanal().getDescripcionCanal();
    BufferedImage imagenF = dtUsuario.getImagen();
    Date fechaNacimiento = dtUsuario.getFechaNacimiento();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String fechaParaMostrar = sdf.format(fechaNacimiento);

    boolean privado = dtUsuario.getCanal().isVisible();

    JPanel imagen = new JPanel();
    imagen.setBackground(SystemColor.menu);
    imagen.setSize(100, 100);
    Image tmp = null;
    if (imagenF != null) {
      tmp = imagenF.getScaledInstance(-1, 100, Image.SCALE_SMOOTH);
    } else {
      try {
        Image img = ImageIO.read(new File(noImagen));
        tmp = img.getScaledInstance(-1, 100, Image.SCALE_SMOOTH);
        ;
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    JLabel icon = new JLabel(new ImageIcon(tmp));
    imagen.add(icon);

    String tipoCanal;
    if (privado) {
      tipoCanal = "Canal privado";
    } else {
      tipoCanal = "Canal público";
    }
    JScrollPane scrollPane = new JScrollPane();

    JScrollPane scrollPane1 = new JScrollPane();

    JLabel lblVideos = new JLabel("Videos");

    JLabel lblListasDeReproduccion = new JLabel("Listas");

    String nickname = "Datos del usuario " + dtUsuario.getNick();

    JLabel lblDatosDelUsuario = new JLabel(nickname);
    lblDatosDelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
    lblDatosDelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));

    JLabel lblNombre = new JLabel("Nombre:");
    lblNombre.setHorizontalAlignment(SwingConstants.TRAILING);

    JLabel lblApellido = new JLabel("Apellido:");
    lblApellido.setHorizontalAlignment(SwingConstants.TRAILING);

    JLabel lblCorreo = new JLabel("Correo:");
    lblCorreo.setHorizontalAlignment(SwingConstants.TRAILING);

    JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
    lblFechaDeNacimiento.setHorizontalAlignment(SwingConstants.TRAILING);

    JLabel lblNombreCanal = new JLabel("Nombre canal:");
    lblNombreCanal.setHorizontalAlignment(SwingConstants.TRAILING);

    JLabel lblDescripcionCanal = new JLabel("Descripcion canal:");
    lblDescripcionCanal.setHorizontalAlignment(SwingConstants.TRAILING);

    JTextField lblNewLabel = new JTextField(nombre);
    lblNewLabel.setEditable(editar);

    JTextField lblapellido = new JTextField(apellido);
    lblapellido.setEditable(editar);

    JTextField lblcorreo = new JTextField(correo);
    lblcorreo.setEditable(editar);

    JTextField lblfecha = new JTextField(fechaParaMostrar);
    lblfecha.setEditable(editar);

    JTextField lblcanal = new JTextField(canal);
    lblcanal.setEditable(editar);
    JScrollPane scrollPaneSeguidores = new JScrollPane();

    JScrollPane scrollPaneSeguidos = new JScrollPane();

    JLabel lblUsuariosSeguidos = new JLabel("Seguidos");

    JLabel lblSeguidores = new JLabel("Seguidores");

    textField = new JTextField(tipoCanal);
    textField.setEditable(false);

    JLabel lblPrivacidadCanal = new JLabel("Visibilidad:");
    lblPrivacidadCanal.setHorizontalAlignment(SwingConstants.TRAILING);

    JScrollPane scrollPane2 = new JScrollPane();
    GroupLayout groupLayout = new GroupLayout(this);
    groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
            .createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup().addContainerGap()
                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                    .addGroup(groupLayout.createSequentialGroup()
                        .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                            .addComponent(lblCorreo, GroupLayout.PREFERRED_SIZE, 89,
                                GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFechaDeNacimiento, GroupLayout.PREFERRED_SIZE, 131,
                                GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblApellido, GroupLayout.PREFERRED_SIZE, 89,
                                GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 89,
                                GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                            .addComponent(lblfecha, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(lblcorreo, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(lblapellido, GroupLayout.DEFAULT_SIZE, 189,
                                Short.MAX_VALUE)
                            .addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 189,
                                Short.MAX_VALUE)
                            .addComponent(imagen, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)))
                    .addGroup(groupLayout.createSequentialGroup()
                        .addComponent(lblNombreCanal, GroupLayout.PREFERRED_SIZE, 131,
                            GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(lblcanal, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                    .addGroup(groupLayout.createSequentialGroup()
                        .addComponent(lblDescripcionCanal, GroupLayout.PREFERRED_SIZE, 131,
                            GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                    .addGroup(groupLayout.createSequentialGroup()
                        .addComponent(lblPrivacidadCanal, GroupLayout.PREFERRED_SIZE, 131,
                            GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(textField, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                    .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
                        .addComponent(scrollPaneSeguidos, Alignment.LEADING,
                            GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                        .addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 103,
                            Short.MAX_VALUE))
                    .addComponent(lblVideos).addComponent(lblUsuariosSeguidos))
                .addGap(18)
                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                    .addComponent(lblSeguidores, GroupLayout.PREFERRED_SIZE, 105,
                        GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblListasDeReproduccion, GroupLayout.PREFERRED_SIZE, 95,
                        GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollPaneSeguidores, GroupLayout.PREFERRED_SIZE, 101,
                        GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 101,
                        GroupLayout.PREFERRED_SIZE))
                .addGap(71))
            .addGroup(groupLayout.createSequentialGroup().addGap(151).addComponent(
                lblDatosDelUsuario, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)))
            .addContainerGap()));
    groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup().addContainerGap()
            .addComponent(lblDatosDelUsuario, GroupLayout.PREFERRED_SIZE, 28,
                GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(groupLayout
                .createParallelGroup(Alignment.TRAILING,
                    false)
                .addGroup(
                    groupLayout.createSequentialGroup()
                        .addComponent(
                            imagen, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                            .addComponent(lblNombre).addComponent(lblNewLabel,
                                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                            .addComponent(lblApellido).addComponent(lblapellido,
                                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                            .addComponent(lblCorreo)
                            .addComponent(lblcorreo, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUsuariosSeguidos).addComponent(lblSeguidores))
                        .addPreferredGap(ComponentPlacement.RELATED))
                .addGroup(groupLayout.createSequentialGroup()
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblVideos).addComponent(lblListasDeReproduccion))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 113,
                            GroupLayout.PREFERRED_SIZE)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 113,
                            GroupLayout.PREFERRED_SIZE))
                    .addGap(38)))
            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblFechaDeNacimiento).addComponent(lblfecha,
                            GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                            GroupLayout.PREFERRED_SIZE))
                    .addGap(16)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(textField, GroupLayout.PREFERRED_SIZE,
                            GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPrivacidadCanal))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(groupLayout
                        .createParallelGroup(Alignment.BASELINE).addComponent(lblNombreCanal)
                        .addComponent(lblcanal, GroupLayout.PREFERRED_SIZE,
                            GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 62,
                            GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDescripcionCanal)))
                .addComponent(scrollPaneSeguidores, GroupLayout.PREFERRED_SIZE, 113,
                    GroupLayout.PREFERRED_SIZE)
                .addComponent(scrollPaneSeguidos, GroupLayout.PREFERRED_SIZE, 113,
                    GroupLayout.PREFERRED_SIZE))
            .addGap(103)));

    JTextPane textPane = new JTextPane();
    textPane.setText(descripcionCanal);
    textPane.setEditable(false);
    textPane.setBackground(Color.WHITE);
    scrollPane2.setViewportView(textPane);
    listaSeguidores.setEnabled(false);

    scrollPaneSeguidores.setViewportView(listaSeguidores);
    listaSeguidos.setEnabled(false);

    scrollPaneSeguidos.setViewportView(listaSeguidos);
    scrollPane1.setViewportView(listasDeReproduccion);

    scrollPane.setViewportView(videos);
    setLayout(groupLayout);

    cargarDatosListas(dtUsuario.getIdUsuario());
    cargarDatosVideos(dtUsuario.getIdUsuario());
    cargarDatosSeguidores(dtUsuario.getIdUsuario());
    cargarDatosSeguidos(dtUsuario.getIdUsuario());
    setVisible(true);
    }
    catch(Exception e){}
  }

  public void cargarDatosSeguidores(int idUsuario) {
    modelSeguidores.removeAllElements();
    ctrlUsu = Fabrica.getIUsuariosCanales();

    String[] Seguidores = ctrlUsu.listarSeguidores(idUsuario);
    int largo = Seguidores.length;
    for (int i = 0; i < largo; i++) {
      modelSeguidores.addElement(Seguidores[i]);
    }
    ctrlUsu = null;
  }

  public void cargarDatosSeguidos(int idUsuario) {
    modelSeguidos.removeAllElements();
    ctrlUsu = Fabrica.getIUsuariosCanales();

    String[] seguidos = ctrlUsu.listarSeguidos(idUsuario);
    int largo = seguidos.length;
    for (int i = 0; i < largo; i++) {
      modelSeguidos.addElement(seguidos[i]);
    }
    ctrlUsu = null;
  }

  public void cargarDatosListas(int idUsuario) {
    try{
      modelListas.removeAllElements();
      listas.clear();
      ctrlLis = Fabrica.getIListas();
  
      listas = ctrlLis.getDtListasParticularesUsuario(idUsuario);
  
      if (!listas.isEmpty()) {
        for (DtLista lista : listas) {
          modelListas.addElement(lista.getNombre());
        }
      }
      listas.clear();
      listas = ctrlLis.getDtListasDefectoUsuario(idUsuario);
      
      if (!listas.isEmpty()) {
        for (DtLista lista : listas) {
          modelListas.addElement(lista.getNombre());
        }
      }
      ctrlLis = null;
    }
    catch(Exception e){}
  }

  public int getListaSeleccionada() {
    for(DtLista lista : listas){
      if(listasDeReproduccion.getSelectedValue().equals(lista.getNombre())){
        listasDeReproduccion.setSelectedIndex(-1);
        return lista.getId();
      }
    }   
    return -1;
  }

  public boolean isListaSelected() {
    return !listasDeReproduccion.isSelectionEmpty();
  }

  public int getVideoSeleccionado() {
    for(DtVideo video : videosUsuario){
      
      if(videos.getSelectedValue().equals(video.getNombre())){
        videos.setSelectedIndex(-1);
        return video.getId();
      }  
    }
    return -1;
  }

  public boolean isVideoSeleccionado() {
    return !videos.isSelectionEmpty();
  }

  public void cargarDatosVideos(int idUsuario) {
    try{
    modelVideos.removeAllElements();
    ctrlUsu = Fabrica.getIUsuariosCanales();

    videosUsuario = ctrlUsu.listarVideosCanal(idUsuario);
    for (DtVideo video : videosUsuario) {
      modelVideos.addElement(video.getNombre());
    }
    ctrlUsu = null;
    }
    catch(Exception e){}
  }

}

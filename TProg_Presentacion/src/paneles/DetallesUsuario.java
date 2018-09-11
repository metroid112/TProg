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

import dataTypes.DtUsuario;
import interfaces.Fabrica;
import interfaces.IListas;
import interfaces.IUsuariosCanales;

@SuppressWarnings("serial")
public class DetallesUsuario extends JPanel {
  private Fabrica fab = Fabrica.getFabrica();
  private IUsuariosCanales ctrlUsu = fab.getIUsuariosCanales();
  private IListas ctrlLis = null;
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

  public void SetEditar(boolean b) {
    this.editar = b;
  }

  /**
   * Create the panel.
   */
  public DetallesUsuario(String usuario) {
    DtUsuario dtUsuario = ctrlUsu.getDt(usuario);

    String nombre = dtUsuario.nombre;
    String apellido = dtUsuario.apellido;
    String correo = dtUsuario.correo;
    String canal = dtUsuario.canal;
    String descripcionCanal = dtUsuario.descripcionCanal;
    BufferedImage imagenF = dtUsuario.imagen;
    Date fechaNacimiento = dtUsuario.fechaNacimiento;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String fechaParaMostrar = sdf.format(fechaNacimiento);

    boolean privado = dtUsuario.privado;

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

    JScrollPane scrollPane_1 = new JScrollPane();

    JLabel lblVideos = new JLabel("Videos");

    JLabel lblListasDeReproduccion = new JLabel("Listas");

    String nickname = "Datos del usuario " + usuario;

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
    JScrollPane scrollPane_Seguidores = new JScrollPane();

    JScrollPane scrollPane_Seguidos = new JScrollPane();

    JLabel lblUsuariosSeguidos = new JLabel("Seguidos");

    JLabel lblSeguidores = new JLabel("Seguidores");

    textField = new JTextField(tipoCanal);
    textField.setEditable(false);

    JLabel lblPrivacidadCanal = new JLabel("Visibilidad:");
    lblPrivacidadCanal.setHorizontalAlignment(SwingConstants.TRAILING);

    JScrollPane scrollPane_2 = new JScrollPane();
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
                        .addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                    .addGroup(groupLayout.createSequentialGroup()
                        .addComponent(lblPrivacidadCanal, GroupLayout.PREFERRED_SIZE, 131,
                            GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(textField, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                    .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
                        .addComponent(scrollPane_Seguidos, Alignment.LEADING,
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
                    .addComponent(scrollPane_Seguidores, GroupLayout.PREFERRED_SIZE, 101,
                        GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 101,
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
                        .addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 113,
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
                        .addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 62,
                            GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDescripcionCanal)))
                .addComponent(scrollPane_Seguidores, GroupLayout.PREFERRED_SIZE, 113,
                    GroupLayout.PREFERRED_SIZE)
                .addComponent(scrollPane_Seguidos, GroupLayout.PREFERRED_SIZE, 113,
                    GroupLayout.PREFERRED_SIZE))
            .addGap(103)));

    JTextPane textPane = new JTextPane();
    textPane.setText(descripcionCanal);
    textPane.setEditable(false);
    textPane.setBackground(Color.WHITE);
    scrollPane_2.setViewportView(textPane);
    listaSeguidores.setEnabled(false);

    scrollPane_Seguidores.setViewportView(listaSeguidores);
    listaSeguidos.setEnabled(false);

    scrollPane_Seguidos.setViewportView(listaSeguidos);
    scrollPane_1.setViewportView(listasDeReproduccion);

    scrollPane.setViewportView(videos);
    setLayout(groupLayout);

    cargarDatosListas(usuario);
    cargarDatosVideos(usuario);
    cargarDatosSeguidores(usuario);
    cargarDatosSeguidos(usuario);
    setVisible(true);
  }

  public void cargarDatosSeguidores(String usuario) {
    modelSeguidores.removeAllElements();
    ctrlUsu = Fabrica.getIUsuariosCanales();

    String[] Seguidores = ctrlUsu.listarSeguidores(usuario);
    int largo = Seguidores.length;
    for (int i = 0; i < largo; i++) {
      modelSeguidores.addElement(Seguidores[i]);
    }
    ctrlUsu = null;
  }

  public void cargarDatosSeguidos(String usuario) {
    modelSeguidos.removeAllElements();
    ctrlUsu = Fabrica.getIUsuariosCanales();

    String[] Seguidos = ctrlUsu.listarSeguidos(usuario);
    int largo = Seguidos.length;
    for (int i = 0; i < largo; i++) {
      modelSeguidos.addElement(Seguidos[i]);
    }
    ctrlUsu = null;
  }

  public void cargarDatosListas(String usuario) {

    modelListas.removeAllElements();

    fab = Fabrica.getFabrica();
    ctrlLis = fab.getIListas();

    String[] listas = ctrlLis.listarListasParticularUsuario(usuario);

    int largol = listas.length;
    // fab = Fabrica.getFabrica();
    // ctrlUsu = fab.getIUsuariosCanales();
    if (largol > 0) {
      for (int i = 0; i < largol; i++) {
        modelListas.addElement(listas[i]);
      }
    }

    listas = ctrlLis.listarListasDefectoUsuario(usuario);
    largol = listas.length;
    if (largol > 0) {
      for (int i = 0; i < largol; i++) {
        modelListas.addElement(listas[i]);
      }
    }
    ctrlLis = null;
  }

  public String getListaSeleccionada() {
    String res = listasDeReproduccion.getSelectedValue();
    listasDeReproduccion.setSelectedIndex(-1);
    return res;
  }

  public boolean isListaSelected() {
    return !listasDeReproduccion.isSelectionEmpty();
  }

  public String getVideoSeleccionado() {
    String res = videos.getSelectedValue();
    videos.setSelectedIndex(-1);
    return res;
  }

  public boolean isVideoSeleccionado() {
    return !videos.isSelectionEmpty();
  }

  public void cargarDatosVideos(String usuario) {
    modelVideos.removeAllElements();
    ctrlUsu = Fabrica.getIUsuariosCanales();

    String[] videosS = ctrlUsu.listarVideos(usuario);
    int largo = videosS.length;
    for (int i = 0; i < largo; i++) {
      modelVideos.addElement(videosS[i]);
    }
    ctrlUsu = null;
  }

}

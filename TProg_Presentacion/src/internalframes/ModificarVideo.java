package internalframes;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;

import org.jdesktop.swingx.JXDatePicker;

import datatypes.DtVideo;
import excepciones.InvalidDataException;
import interfaces.IVideos;
import paneles.SeleccionVideo;

@SuppressWarnings("serial")
public class ModificarVideo extends JInternalFrame {
  private SeleccionVideo seleccionVideo;
  private IVideos contVid;
  private JTextField tfNombre;
  private JTextField tfUrl;
  private ButtonGroup grupo = new ButtonGroup();
  private JComboBox<String> cBoxCategoria;
  private JSpinner spinnerHoras;
  private JSpinner spinnerMin;
  private JSpinner spinnerSeg;
  private JTextArea textDescripcion;
  private JXDatePicker datePicker;
  private JRadioButton rdbtnPublico;
  private JRadioButton rdbtnPrivado;

  /**
   * Create the frame.
   */
  public ModificarVideo(IVideos contVid) {
    this.contVid = contVid;
    setTitle("Modificar Video");
    setBounds(100, 100, 500, 480);
    getContentPane().setLayout(new CardLayout(0, 0));

    JPanel panelSeleccion = new JPanel();
    getContentPane().add(panelSeleccion, "name_75253987057171");

    seleccionVideo = new SeleccionVideo(this.contVid);

    JButton btnCancelar = new JButton("Cancelar");
    btnCancelar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        setVisible(false);
      }
    });

    JButton btnModificar = new JButton("Modificar");
    btnModificar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        cargarInfo(); // Cambio al siguiente panel
      }
    });
    GroupLayout gl_panelSeleccion = new GroupLayout(panelSeleccion);
    gl_panelSeleccion.setHorizontalGroup(gl_panelSeleccion.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panelSeleccion.createSequentialGroup().addGap(13).addComponent(seleccionVideo,
            GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        .addGroup(Alignment.TRAILING,
            gl_panelSeleccion.createSequentialGroup().addContainerGap(285, Short.MAX_VALUE)
                .addComponent(btnModificar).addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(btnCancelar).addContainerGap()));
    gl_panelSeleccion.setVerticalGroup(gl_panelSeleccion.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panelSeleccion.createSequentialGroup().addGap(5)
            .addComponent(seleccionVideo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                GroupLayout.PREFERRED_SIZE)
            .addGap(18)
            .addGroup(gl_panelSeleccion.createParallelGroup(Alignment.BASELINE)
                .addComponent(btnCancelar).addComponent(btnModificar))
            .addContainerGap(34, Short.MAX_VALUE)));
    panelSeleccion.setLayout(gl_panelSeleccion);

    JPanel panelMod = new JPanel();
    getContentPane().add(panelMod, "name_77608104205516");

    JButton btnVolver = new JButton("Volver");
    btnVolver.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        cambioPanel();
      }
    });

    JLabel lblNombre = new JLabel("Nombre:");

    JLabel lblDescripcion = new JLabel("Descripcion:");

    JLabel lblDuracion = new JLabel("Duracion:");

    JLabel lblVisibilidad = new JLabel("Visibilidad:");

    JLabel lblFecha = new JLabel("Fecha:");

    JLabel lblCategoria = new JLabel("Categoria:");

    JLabel lblUrl = new JLabel("URL:");

    JScrollPane scrollPane = new JScrollPane();

    tfNombre = new JTextField();
    tfNombre.setColumns(10);

    tfUrl = new JTextField();
    tfUrl.setColumns(10);

    cBoxCategoria = new JComboBox<String>();

    datePicker = new JXDatePicker();

    rdbtnPublico = new JRadioButton("Publico", true);

    rdbtnPrivado = new JRadioButton("Privado");
    grupo.add(rdbtnPrivado);
    grupo.add(rdbtnPublico);

    spinnerHoras = new JSpinner();
    spinnerHoras
        .setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));

    JLabel lblHoras = new JLabel("horas");

    spinnerMin = new JSpinner();
    spinnerMin
        .setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));

    JLabel lblMin = new JLabel("min.");

    spinnerSeg = new JSpinner();
    spinnerSeg
        .setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));

    JLabel lblSeg = new JLabel("seg.");

    JButton btnModificarDatos = new JButton("Modificar datos");
    btnModificarDatos.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        modificarVideo();
      }
    });

    GroupLayout gl_panelMod = new GroupLayout(panelMod);
    gl_panelMod
        .setHorizontalGroup(
            gl_panelMod
                .createParallelGroup(
                    Alignment.LEADING)
                .addGroup(gl_panelMod.createSequentialGroup()
                    .addGroup(gl_panelMod.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_panelMod
                            .createSequentialGroup().addGap(37)
                            .addGroup(gl_panelMod.createParallelGroup(Alignment.LEADING)
                                .addComponent(lblDescripcion).addComponent(lblNombre)
                                .addComponent(
                                    lblDuracion)
                                .addComponent(lblUrl).addComponent(lblCategoria)
                                .addComponent(lblFecha).addComponent(lblVisibilidad))
                            .addGap(18)
                            .addGroup(gl_panelMod.createParallelGroup(Alignment.LEADING)
                                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 347,
                                    Short.MAX_VALUE)
                                .addGroup(
                                    gl_panelMod.createSequentialGroup().addComponent(rdbtnPublico)
                                        .addGap(18).addComponent(rdbtnPrivado))
                                .addComponent(datePicker, GroupLayout.PREFERRED_SIZE,
                                    GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(cBoxCategoria, 0, 347, Short.MAX_VALUE)
                                .addComponent(tfNombre, GroupLayout.DEFAULT_SIZE, 347,
                                    Short.MAX_VALUE)
                                .addGroup(gl_panelMod.createSequentialGroup()
                                    .addComponent(spinnerHoras, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(ComponentPlacement.RELATED)
                                    .addComponent(lblHoras).addGap(18)
                                    .addComponent(spinnerMin, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(ComponentPlacement.RELATED)
                                    .addComponent(lblMin).addGap(18)
                                    .addComponent(spinnerSeg, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(ComponentPlacement.RELATED)
                                    .addComponent(lblSeg))
                                .addComponent(tfUrl, GroupLayout.DEFAULT_SIZE, 347,
                                    Short.MAX_VALUE)))
                        .addGroup(gl_panelMod.createSequentialGroup()
                            .addContainerGap(272, Short.MAX_VALUE).addComponent(btnModificarDatos)
                            .addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnVolver)))
                    .addContainerGap()));
    gl_panelMod.setVerticalGroup(gl_panelMod.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panelMod.createSequentialGroup().addGap(38)
            .addGroup(gl_panelMod.createParallelGroup(Alignment.BASELINE).addComponent(lblNombre)
                .addComponent(tfNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE))
            .addGap(18)
            .addGroup(gl_panelMod.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblDescripcion).addComponent(scrollPane, GroupLayout.PREFERRED_SIZE,
                    GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE)
            .addGroup(gl_panelMod.createParallelGroup(Alignment.BASELINE).addComponent(lblDuracion)
                .addComponent(spinnerHoras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE)
                .addComponent(lblHoras)
                .addComponent(spinnerMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE)
                .addComponent(lblMin)
                .addComponent(spinnerSeg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE)
                .addComponent(lblSeg))
            .addGap(18)
            .addGroup(gl_panelMod.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblVisibilidad).addComponent(rdbtnPublico).addComponent(rdbtnPrivado))
            .addGap(18)
            .addGroup(gl_panelMod.createParallelGroup(Alignment.BASELINE).addComponent(lblFecha)
                .addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE))
            .addGap(18)
            .addGroup(gl_panelMod.createParallelGroup(Alignment.BASELINE).addComponent(lblCategoria)
                .addComponent(cBoxCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE))
            .addGap(18)
            .addGroup(gl_panelMod.createParallelGroup(Alignment.BASELINE).addComponent(lblUrl)
                .addComponent(tfUrl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE))
            .addGap(34).addGroup(gl_panelMod.createParallelGroup(Alignment.BASELINE)
                .addComponent(btnVolver).addComponent(btnModificarDatos))
            .addGap(47)));

    textDescripcion = new JTextArea();
    textDescripcion.setWrapStyleWord(true);
    textDescripcion.setLineWrap(true);
    textDescripcion.setRows(5);
    scrollPane.setViewportView(textDescripcion);
    panelMod.setLayout(gl_panelMod);

  }

  public void cargarDatos() {
    seleccionVideo.cargarDatos();
  }

  private void cambioPanel() {
    CardLayout layout = (CardLayout) getContentPane().getLayout(); // Consigo el layout
    layout.next(getContentPane()); // Cambia al siguiente panel

  }

  private void cargarInfo() {
    if (seleccionVideo.getUsuario() != null && seleccionVideo.getVideo() != null) {
      DtVideo infoVid = contVid.getDtVideo(seleccionVideo.getVideo(), seleccionVideo.getUsuario()); // Pido
                                                                                                    // info
      // del video
      // para
      // desplegar
      tfNombre.setText(infoVid.nombre);
      textDescripcion.setText(infoVid.descripcion);
      tfUrl.setText(infoVid.URL);
      if (infoVid.visible) {
        rdbtnPublico.doClick();
      } else {
        rdbtnPrivado.doClick();
      }
      int horas, min, seg;
      Duration duracion = infoVid.duracion;
      horas = (int) duracion.toHours();
      duracion = duracion.minusHours(horas);
      min = (int) duracion.toMinutes();
      duracion = duracion.minusMinutes(min);
      seg = (int) duracion.getSeconds();
      spinnerHoras.setValue(horas);
      spinnerMin.setValue(min);
      spinnerSeg.setValue(seg);
      datePicker.setDate(infoVid.fecha);
      DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(
          contVid.listarCategorias());
      if (!infoVid.categoria.equals("Sin Categoria")) {
        int size = model.getSize();
        int i = 0;
        boolean encontrado = false;
        while (i <= size && !encontrado) {
          if (model.getElementAt(i).equals(infoVid.categoria)) {
            model.setSelectedItem(model.getElementAt(i));
            encontrado = true;
          }
          i++;
        }
        if (!encontrado) {
          System.out.println("ERROR: categoria no encontrada en ModificarVideo. La categoria era: "
              + infoVid.categoria); // TODO
          // excepccion
        }
      } else {
        model.addElement(infoVid.categoria); // En caso de decir "Sin Categoria"
        model.setSelectedItem(infoVid.categoria);
      }
      cBoxCategoria.setModel(model);

      cambioPanel();
    } else {
      JOptionPane.showMessageDialog(this, "Campos vacios", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  public boolean datosCorrectos(String nombre, String url, Duration duracion) {
    return (!(nombre.equals("")) && !(url.equals("")) && !(duracion.isZero()));
  }

  private void modificarVideo() {
    // try {

    String nick, nombreOld, nombre, descripcion, url, categoria;
    Duration duracion;
    Boolean visible;
    nick = seleccionVideo.getUsuario();
    nombreOld = seleccionVideo.getVideo();
    nombre = tfNombre.getText();
    descripcion = textDescripcion.getText();
    url = tfUrl.getText();
    categoria = (String) cBoxCategoria.getSelectedItem();
    if (categoria.equals("Sin Categoria")) { // Chequeo si eligio alguna categoria
      categoria = null;
    }
    duracion = Duration.ofHours((int) spinnerHoras.getValue());
    duracion = duracion.plusMinutes((int) spinnerMin.getValue());
    duracion = duracion.plusSeconds((int) spinnerSeg.getValue());
    Date fecha = datePicker.getDate();
    if (rdbtnPrivado.isSelected()) {
      visible = false;
    } else {
      visible = true;
    }
    if (datosCorrectos(nombre, url, duracion)) {
      try {
        contVid.modificarVideo(nick, nombreOld, nombre, descripcion, url, categoria, duracion,
            visible, fecha);
        JOptionPane.showMessageDialog(this, "Datos modificados con exito");
        setVisible(false);
        cambioPanel();
      } catch (InvalidDataException exception) {
        JOptionPane.showMessageDialog(this, exception.getMessage(), "Error",
            JOptionPane.ERROR_MESSAGE);
      }
    } else {
      JOptionPane.showMessageDialog(this, "Datos vacios", "Error", JOptionPane.ERROR_MESSAGE);
    }

    /*
     * } catch (Exception e) { JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
     * JOptionPane.ERROR_MESSAGE); }
     */
  }

}

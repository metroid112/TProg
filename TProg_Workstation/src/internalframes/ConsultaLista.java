package internalframes;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import datatypes.DtLista;
import datatypes.DtVideo;
import interfaces.Fabrica;
import interfaces.IListas;
import interfaces.IUsuariosCanales;
import interfaces.IVideos;
import paneles.InfoVideo;

@SuppressWarnings("serial")
public class ConsultaLista extends JInternalFrame {

  private IUsuariosCanales ctrUsu;
  private IListas ctrLis;
  private ButtonGroup grupoLista = new ButtonGroup();
  private DefaultComboBoxModel<String> modelUsuario = new DefaultComboBoxModel<String>();
  private JComboBox<String> comboBoxUsuario;
  private JLabel lVisible;
  private InfoVideo infoVid;
  private JList<String> listaCategorias;
  private List<DtLista> listas;

  private DefaultListModel<String> listListas = new DefaultListModel<>();

  private JList<String> list;
  private JList<String> listaVideos;

  public ConsultaLista() {

    setTitle("Conultar lista");
    setBounds(0, 0, 580, 500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panelSeleccion = new JPanel();
    Fabrica.getFabrica();
    infoVid = new InfoVideo(Fabrica.getIVideos());
    JPanel panelInfo = new JPanel();
    Fabrica.getFabrica();
    ctrLis = Fabrica.getIListas();
    getContentPane().setLayout(new CardLayout());
    getContentPane().add(panelSeleccion);
    getContentPane().add(panelInfo);

    JButton btnVolver = new JButton("Volver");
    btnVolver.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        cambioPanel();
      }
    });
    GroupLayout glPanelInfo = new GroupLayout(panelInfo);
    glPanelInfo.setHorizontalGroup(glPanelInfo.createParallelGroup(Alignment.LEADING)
        .addGroup(glPanelInfo.createSequentialGroup().addGap(18)
            .addGroup(glPanelInfo.createParallelGroup(Alignment.TRAILING).addComponent(btnVolver)
                .addComponent(infoVid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE))
            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    glPanelInfo.setVerticalGroup(glPanelInfo.createParallelGroup(Alignment.LEADING)
        .addGroup(glPanelInfo.createSequentialGroup().addContainerGap()
            .addComponent(infoVid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnVolver)
            .addContainerGap(27, Short.MAX_VALUE)));
    panelInfo.setLayout(glPanelInfo);
    JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario");

    comboBoxUsuario = new JComboBox<String>(modelUsuario);

    JButton btnCerrar = new JButton("Cerrar");

    JScrollPane scrollPaneListas = new JScrollPane();

    JRadioButton rdbtnListasPorDefecto = new JRadioButton("Listas por defecto", true);
    rdbtnListasPorDefecto.setEnabled(false);

    JRadioButton rdbtnListasParticulares = new JRadioButton("Listas particulares");
    rdbtnListasParticulares.setEnabled(false);
    grupoLista.add(rdbtnListasPorDefecto);
    grupoLista.add(rdbtnListasParticulares);

    JLabel lblVisibilidad = new JLabel("Visibilidad:");
    lblVisibilidad.setEnabled(false);

    lVisible = new JLabel("");

    JScrollPane scrollPaneVideos = new JScrollPane();

    JButton btnConsultarVideo = new JButton("Consultar Video");
    btnConsultarVideo.setEnabled(false);
    btnConsultarVideo.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        cargarVideo();
        cambioPanel();
      }
    });

    JScrollPane scrollPaneCategorias = new JScrollPane();

    GroupLayout groupLayout = new GroupLayout(panelSeleccion);
    groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout
            .createParallelGroup(Alignment.LEADING)
            .addGroup(
                groupLayout.createSequentialGroup().addComponent(lblNombreDeUsuario).addGap(120))
            .addGroup(groupLayout.createSequentialGroup().addGap(17)
                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                    .addComponent(comboBoxUsuario, 0, 156, Short.MAX_VALUE)
                    .addComponent(rdbtnListasPorDefecto).addComponent(rdbtnListasParticulares)
                    .addComponent(scrollPaneListas, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                .addGap(68)))
            .addPreferredGap(ComponentPlacement.RELATED)
            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
                .createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                    .addGroup(groupLayout.createSequentialGroup().addComponent(btnConsultarVideo)
                        .addGap(18).addComponent(btnCerrar))
                    .addComponent(scrollPaneVideos, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                    .addComponent(scrollPaneCategorias, GroupLayout.DEFAULT_SIZE, 271,
                        Short.MAX_VALUE))
                .addGap(42)).addGroup(
                    groupLayout.createSequentialGroup().addComponent(lblVisibilidad)
                        .addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lVisible,
                            GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                        .addGap(155)))));
    groupLayout
        .setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
            .addGroup(groupLayout.createSequentialGroup().addGap(25)
                .addGroup(groupLayout
                    .createParallelGroup(Alignment.BASELINE).addComponent(lblNombreDeUsuario)
                    .addComponent(lblVisibilidad).addComponent(lVisible))
                .addGap(17)
                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                    .addGroup(groupLayout.createSequentialGroup()
                        .addComponent(comboBoxUsuario, GroupLayout.PREFERRED_SIZE,
                            GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addComponent(rdbtnListasPorDefecto)
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addComponent(rdbtnListasParticulares).addGap(11).addComponent(
                            scrollPaneListas, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
                    .addGroup(Alignment.TRAILING,
                        groupLayout.createSequentialGroup()
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(scrollPaneCategorias, GroupLayout.DEFAULT_SIZE, 102,
                                Short.MAX_VALUE)
                            .addGap(18)
                            .addComponent(scrollPaneVideos, GroupLayout.PREFERRED_SIZE, 212,
                                GroupLayout.PREFERRED_SIZE)
                            .addGap(22)
                            .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                .addComponent(btnCerrar).addComponent(btnConsultarVideo))))
                .addGap(37)));

    JLabel lblCategorias = new JLabel("Categorias:");
    lblCategorias.setEnabled(false);
    scrollPaneCategorias.setColumnHeaderView(lblCategorias);

    listaCategorias = new JList<String>();
    scrollPaneCategorias.setViewportView(listaCategorias);

    listaVideos = new JList<String>();
    listaVideos.addListSelectionListener(new ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent arg0) {
        if (!listaVideos.isSelectionEmpty()) {
          btnConsultarVideo.setEnabled(true);
        } else {
          btnConsultarVideo.setEnabled(false);
        }
      }
    });
    scrollPaneVideos.setViewportView(listaVideos);

    JLabel lblVideos = new JLabel("Videos:");
    lblVideos.setEnabled(false);
    scrollPaneVideos.setColumnHeaderView(lblVideos);

    list = new JList<String>(listListas);

    list.addListSelectionListener(new ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent arg0) {
        if (!list.isSelectionEmpty()) {
          lVisible.setEnabled(true);
          lblVideos.setEnabled(true);
          lblVisibilidad.setEnabled(true);
          lblCategorias.setEnabled(true);
          cargaDatosLista();
        } else {
          listaCategorias.setModel(new DefaultListModel<String>());
          listaVideos.setModel(new DefaultListModel<String>());
          lVisible.setEnabled(false);
          lblVideos.setEnabled(false);
          lblVisibilidad.setEnabled(false);
          lblCategorias.setEnabled(false);
        }
      }
    });
    list.setEnabled(false);
    scrollPaneListas.setViewportView(list);

    JLabel lblListas = new JLabel("Listas:");
    scrollPaneListas.setColumnHeaderView(lblListas);
    panelSeleccion.setLayout(groupLayout);

    btnCerrar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {

        setVisible(false);
        modelUsuario.removeAllElements();
        listListas.removeAllElements();
        list.setEnabled(false);
        listas.clear();
        rdbtnListasPorDefecto.setSelected(true);
        rdbtnListasParticulares.setSelected(false);
        rdbtnListasPorDefecto.setEnabled(false);
        rdbtnListasParticulares.setEnabled(false);

      }
    });

    rdbtnListasPorDefecto.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        listas.clear();
        listas = ctrLis.getDtListasDefectoUsuario(comboBoxUsuario.getSelectedItem().toString());
        cargarDefectoListas();
      }
    });

    rdbtnListasParticulares.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        listas.clear();
        listas = ctrLis.getDtListasParticularesUsuario(comboBoxUsuario.getSelectedItem().toString());
        cargarParticularListas();
      }
    });

    comboBoxUsuario.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (comboBoxUsuario.getSelectedItem() != "") {

          list.setEnabled(true);
          rdbtnListasParticulares.setEnabled(true);
          rdbtnListasPorDefecto.setEnabled(true);

          if (rdbtnListasPorDefecto.isSelected()) {
            cargarDefectoListas();
          }
          if (rdbtnListasParticulares.isSelected()) {
            cargarParticularListas();
          }

        } else {
          list.setEnabled(false);
          rdbtnListasPorDefecto.setSelected(true);
          rdbtnListasParticulares.setSelected(false);
          rdbtnListasPorDefecto.setEnabled(false);
          rdbtnListasParticulares.setEnabled(false);
          list.setEnabled(false);
        }
      }
    });

  }

  public void cargarDatos() {

    Fabrica.getFabrica();
    ctrUsu = Fabrica.getIUsuariosCanales();
    List<String> usuarios = ctrUsu.listarNombresUsuarios();
    modelUsuario.addElement("");
    for (String usuario : usuarios) {
      modelUsuario.addElement(usuario);
    }
    ctrUsu = null;

  }

  public void cargarDefectoListas() {

    listListas.removeAllElements();

    if (modelUsuario.getSelectedItem() != null) {

      String s = (String) modelUsuario.getSelectedItem();
      List<String> listas = ctrLis.listarListasDefectoUsuario(s);


      for (String lista : listas) {
        listListas.addElement(lista);
      }
    }

    // ctrLis = null;
  }

  public void cargarParticularListas() {
    listListas.removeAllElements();
    Fabrica.getFabrica();
    ctrLis = Fabrica.getIListas();

    if (modelUsuario.getSelectedItem() != null) {

      String s = modelUsuario.getSelectedItem().toString();

      List<String> listas = ctrLis.listarListasParticularUsuario(s);


      for (String lista : listas) {
        listListas.addElement(lista);
      }
    }

    // ctrLis = null;
  }

  boolean checkUsuario() {

    if (modelUsuario.getSelectedItem() == "") {
      JOptionPane.showMessageDialog(null, "No has seleccionado ning�n usuario", "Error",
          JOptionPane.ERROR_MESSAGE);
      return false;
    }
    return true;
  }

  private void cargaDatosLista() {
    String lista = list.getSelectedValue();
    String usuario = (String) comboBoxUsuario.getSelectedItem();
    try {
      DtLista dtLista = ctrLis.getDt(obtenerListaId(lista));
      if (dtLista.isVisible()) {
        lVisible.setText("Publico");
      } else {
        lVisible.setText("Privado");
      }
      DefaultListModel<String> modeloVideos = new DefaultListModel<String>();
      for (String vid : dtLista.getVideos()) {
        modeloVideos.addElement(vid);
      }
      listaVideos.setModel(modeloVideos);
      DefaultListModel<String> modeloCategorias = new DefaultListModel<String>();
      for (String cat : dtLista.getCategorias()) {
        modeloCategorias.addElement(cat);
      }
      listaCategorias.setModel(modeloCategorias);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

  }

  private void cambioPanel() {
    CardLayout layout = (CardLayout) getContentPane().getLayout();
    layout.next(getContentPane());
  }

  private void cargarVideo() {
    Fabrica.getFabrica();
    IVideos ctrVid = Fabrica.getIVideos();
    String duenoVid = null;
    try {

      duenoVid = listaVideos.getSelectedValue().substring(0,
          listaVideos.getSelectedValue().indexOf('-'));
    } catch (Exception e) {
      JOptionPane.showMessageDialog(this, "error cargarVid" + e.getMessage(), "Error",
          JOptionPane.ERROR_MESSAGE);
    }
    DtVideo dtVid = ctrVid.getDtVideo(listaVideos.getSelectedValue().substring(listaVideos.getSelectedValue().indexOf('-') + 1),
        duenoVid);
    infoVid.cargarDatos(dtVid);

  }
  
  public int obtenerListaId(String nombre){
    for(DtLista lista : listas){
      if(lista.getNombre().equals(nombre)){
        return lista.getId();
      }
    }
    return -1;
  }
}

package internalframes;

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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import interfaces.Fabrica;
import interfaces.IListas;
import interfaces.IUsuariosCanales;
import interfaces.IVideos;

@SuppressWarnings("serial")
public class AgregarVideo extends JInternalFrame {

  private IUsuariosCanales ctrUsu;
  private IVideos ctrVid;
  private IListas ctrLis;
  private ButtonGroup grupoLista = new ButtonGroup();
  private DefaultComboBoxModel<String> modelUsuario = new DefaultComboBoxModel<String>();
  private DefaultComboBoxModel<String> modelVideos = new DefaultComboBoxModel<String>();
  private DefaultComboBoxModel<String> modelUsuObj = new DefaultComboBoxModel<String>();
  private DefaultListModel<String> listListas = new DefaultListModel<>();

  public AgregarVideo() {

    setTitle("Agregar video a lista de reproduccion");
    setBounds(0, 0, 640, 480);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JLabel lblNombreDeUsuario = new JLabel("Usuario poseedor del video");

    JLabel lblVideos = new JLabel("Videos");

    JLabel lblUsuario = new JLabel("Usuario poseedor de la lista");

    JComboBox<String> comboBoxUsuario = new JComboBox<String>(modelUsuario);

    JComboBox<String> comboBoxVideos = new JComboBox<String>(modelVideos);

    comboBoxVideos.setEnabled(false);

    JComboBox<String> comboBoxUsuObj = new JComboBox<String>(modelUsuObj);

    comboBoxUsuObj.setEnabled(false);

    JButton btnCancelar = new JButton("Cancelar");

    JButton btnAceptar = new JButton("Aceptar");
    btnAceptar.setEnabled(false);

    JRadioButton rdbtnListasPordefecto = new JRadioButton("Listas por defecto", true);

    rdbtnListasPordefecto.setEnabled(false);

    JRadioButton rdbtnListasParticulares = new JRadioButton("Listas particulares");

    rdbtnListasParticulares.setEnabled(false);
    grupoLista.add(rdbtnListasPordefecto);
    grupoLista.add(rdbtnListasParticulares);

    JScrollPane scrollPane = new JScrollPane();

    JLabel lblListasDelUsuario = new JLabel("Listas del usuario");

    GroupLayout groupLayout = new GroupLayout(getContentPane());
    groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup().addContainerGap(450, Short.MAX_VALUE)
            .addComponent(btnAceptar).addGap(18).addComponent(btnCancelar).addContainerGap())
        .addGroup(groupLayout.createSequentialGroup().addGap(21)
            .addGroup(groupLayout
                .createParallelGroup(Alignment.LEADING).addComponent(lblNombreDeUsuario)
                .addComponent(lblVideos).addComponent(lblUsuario).addComponent(lblListasDelUsuario))
            .addGap(28)
            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 135,
                    GroupLayout.PREFERRED_SIZE)
                .addComponent(rdbtnListasParticulares).addComponent(rdbtnListasPordefecto)
                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                    .addComponent(comboBoxUsuario, 0, 129, Short.MAX_VALUE)
                    .addComponent(comboBoxVideos, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboBoxUsuObj, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addContainerGap(350, Short.MAX_VALUE)));
    groupLayout
        .setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup().addGap(24)
                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lblNombreDeUsuario)
                    .addComponent(comboBoxUsuario, GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18)
                .addGroup(
                    groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblVideos)
                        .addComponent(comboBoxVideos, GroupLayout.PREFERRED_SIZE,
                            GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18)
                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lblUsuario).addComponent(comboBoxUsuObj,
                        GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE))
                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
                    .createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(rdbtnListasPordefecto).addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(rdbtnListasParticulares).addGap(18)
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 202,
                        GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnCancelar).addComponent(btnAceptar)))
                    .addGroup(groupLayout.createSequentialGroup().addGap(152)
                        .addComponent(lblListasDelUsuario)))
                .addContainerGap()));

    JList<String> list = new JList<String>(listListas);

    list.setEnabled(false);
    scrollPane.setViewportView(list);
    getContentPane().setLayout(groupLayout);

    btnCancelar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        modelUsuario.removeAllElements();
        modelVideos.removeAllElements();
        modelUsuObj.removeAllElements();
        btnAceptar.setEnabled(false);
        rdbtnListasPordefecto.setEnabled(false);
        rdbtnListasPordefecto.setSelected(true);
        rdbtnListasParticulares.setEnabled(false);
        rdbtnListasParticulares.setSelected(false);
        setVisible(false);
      }
    });

    btnAceptar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try{
        boolean checkUsuario = true;

        if (comboBoxUsuario.getSelectedItem() == "") {
          JOptionPane.showMessageDialog(null, "No has seleccionado ningú n usuario", "Error",
              JOptionPane.ERROR_MESSAGE);
          checkUsuario = false;
        }

        if (checkUsuario) {
          ctrLis = Fabrica.getIListas();
          ctrLis.agregarVideoLista(modelUsuario.getSelectedItem().toString(),
              modelVideos.getSelectedItem().toString(), modelUsuObj.getSelectedItem().toString(),
              list.getSelectedValue().toString(), rdbtnListasPordefecto.isSelected());

          modelUsuario.removeAllElements();
          modelVideos.removeAllElements();
          modelUsuObj.removeAllElements();
          btnAceptar.setEnabled(false);
          rdbtnListasPordefecto.setEnabled(false);
          rdbtnListasPordefecto.setSelected(true);
          rdbtnListasParticulares.setEnabled(false);
          rdbtnListasParticulares.setSelected(false);
          setVisible(false);
        }
        }
        catch(Exception error){}

      }
    });

    comboBoxUsuario.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (comboBoxUsuario.getSelectedItem() != "") {

          modelVideos.removeAllElements();
          modelUsuObj.removeAllElements();
          cargarVideosUsuarios();
          comboBoxVideos.setEnabled(true);

        } else {
          comboBoxVideos.setEnabled(false);
          comboBoxUsuObj.setEnabled(false);
          rdbtnListasPordefecto.setEnabled(false);
          rdbtnListasParticulares.setEnabled(false);
          list.setEnabled(false);

        }
      }
    });

    comboBoxVideos.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (comboBoxVideos.getSelectedItem() != "") {

          modelUsuObj.removeAllElements();
          comboBoxUsuObj.setEnabled(true);
          cargarUsuarioObj();

        } else {

          comboBoxUsuObj.setEnabled(false);
          rdbtnListasPordefecto.setEnabled(false);
          rdbtnListasParticulares.setEnabled(false);
          list.setEnabled(false);
        }
      }
    });

    comboBoxUsuObj.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (comboBoxUsuObj.getSelectedItem() != "") {
          list.setEnabled(true);
          rdbtnListasPordefecto.setEnabled(true);
          rdbtnListasParticulares.setEnabled(true);

          if (rdbtnListasPordefecto.isSelected()) {

            cargarDefectoListas();
          }
          if (rdbtnListasParticulares.isSelected()) {

            cargarParticularListas();
          }
        } else {
          list.setEnabled(false);
          rdbtnListasPordefecto.setEnabled(false);
          rdbtnListasParticulares.setEnabled(false);
        }
      }
    });

    rdbtnListasPordefecto.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        cargarDefectoListas();
        btnAceptar.setEnabled(false);
      }
    });

    rdbtnListasParticulares.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        cargarParticularListas();
        btnAceptar.setEnabled(false);
      }
    });

    list.addListSelectionListener(new ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent arg0) {
        btnAceptar.setEnabled(true);
      }
    });

  }

  public void cargarVideosUsuarios() {

    ctrVid = Fabrica.getIVideos();

    if (modelUsuario.getSelectedItem() != null) {

      String s = modelUsuario.getSelectedItem().toString();

      String[] videos = ctrVid.listarVideos(s);

      int largov = videos.length;

      modelVideos.addElement("");
      for (int i = 0; i < largov; i++) {
        modelVideos.addElement(videos[i]);
      }
    }
    ctrVid = null;

  }

  public void cargarUsuarioObj() {

    ctrUsu = Fabrica.getIUsuariosCanales();
    List<String> usuarios = ctrUsu.listarNombresUsuarios();

    modelUsuObj.addElement("");
    for (String usuario : usuarios) {
      modelUsuObj.addElement(usuario);
    }
    ctrUsu = null;
  }

  public void cargarDatos() {

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
    ctrLis = Fabrica.getIListas();

    if (modelUsuObj.getSelectedItem() != null) {

      String s = modelUsuObj.getSelectedItem().toString();

      List<String> listas = ctrLis.listarListasDefectoUsuario(s);

      for (String lista : listas) {
        listListas.addElement(lista);
      }
    }

    ctrLis = null;
  }

  public void cargarParticularListas() {
    listListas.removeAllElements();
    ctrLis = Fabrica.getIListas();

    if (modelUsuObj.getSelectedItem() != null) {

      String s = modelUsuObj.getSelectedItem().toString();

      List<String> listas = ctrLis.listarListasParticularUsuario(s);

      for (String lista : listas) {
        listListas.addElement(lista);
      }
    }

    ctrLis = null;
  }
}

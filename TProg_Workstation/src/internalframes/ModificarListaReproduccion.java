package internalframes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import datatypes.DtLista;
import datatypes.DtUsuario;
import interfaces.Fabrica;
import interfaces.IListas;
import interfaces.IUsuariosCanales;

@SuppressWarnings("serial")
public class ModificarListaReproduccion extends JInternalFrame {

  private IUsuariosCanales ctrUsu;
  private IListas ctrLis;
  private List<DtUsuario> usuarios;
  private List<DtLista> listas;
  private ButtonGroup grupoVisibilidad = new ButtonGroup();
  private DefaultComboBoxModel<String> modelUsuario = new DefaultComboBoxModel<String>();
  private DefaultComboBoxModel<String> modelLisRep = new DefaultComboBoxModel<String>();
  private DefaultComboBoxModel<String> modelCategoria = new DefaultComboBoxModel<String>();

  public ModificarListaReproduccion() {

    setBounds(0, 0, 640, 480);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Modificar lista de reproduccion");

    JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario");

    JLabel lblListaDeReproduccin = new JLabel("Lista de reproduccion");

    JRadioButton rdbtnPrivada = new JRadioButton("Privada", true);
    rdbtnPrivada.setEnabled(false);

    JRadioButton rdbtnPublica = new JRadioButton("Publica");
    rdbtnPublica.setEnabled(false);
    grupoVisibilidad.add(rdbtnPublica);
    grupoVisibilidad.add(rdbtnPrivada);

    JComboBox<String> comboBoxUsuario = new JComboBox<String>(modelUsuario);

    JComboBox<String> comboBoxLisRep = new JComboBox<String>(modelLisRep);
    comboBoxLisRep.setEnabled(false);

    JButton btnCancelar = new JButton("Cancelar");

    JButton btnGuardar = new JButton("Guardar");
    btnGuardar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
      }
    });

    GroupLayout groupLayout = new GroupLayout(getContentPane());
    groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        .addGroup(groupLayout.createSequentialGroup().addGap(24)
            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup().addComponent(rdbtnPrivada).addGap(18)
                    .addComponent(rdbtnPublica))
                .addGroup(groupLayout.createSequentialGroup()
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblNombreDeUsuario).addComponent(lblListaDeReproduccin))
                    .addGap(28)
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(comboBoxLisRep, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboBoxUsuario, 0, 146, Short.MAX_VALUE))))
            .addContainerGap(324, Short.MAX_VALUE))
        .addGroup(groupLayout.createSequentialGroup().addContainerGap(458, Short.MAX_VALUE)
            .addComponent(btnGuardar).addPreferredGap(ComponentPlacement.UNRELATED)
            .addComponent(btnCancelar).addContainerGap()));
    groupLayout
        .setVerticalGroup(
            groupLayout
                .createParallelGroup(
                    Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup().addGap(23)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblNombreDeUsuario).addComponent(comboBoxUsuario,
                            GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                            GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblListaDeReproduccin).addComponent(comboBoxLisRep,
                            GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                            GroupLayout.PREFERRED_SIZE))
                    .addGap(50)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(rdbtnPrivada).addComponent(rdbtnPublica))
                    .addPreferredGap(ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnCancelar).addComponent(btnGuardar))
                    .addContainerGap()));
    getContentPane().setLayout(groupLayout);

    btnCancelar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        setVisible(false);
        clean();
        rdbtnPrivada.setSelected(true);
        rdbtnPublica.setSelected(false);
        rdbtnPrivada.setEnabled(false);
        rdbtnPublica.setEnabled(false);
        comboBoxLisRep.setEnabled(false);

      }
    });

    comboBoxUsuario.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (comboBoxUsuario.getSelectedItem() != "") {

          modelLisRep.removeAllElements();
          cargarListas();
          comboBoxLisRep.setEnabled(true);
          rdbtnPrivada.setEnabled(true);
          rdbtnPublica.setEnabled(true);
        } else {

          comboBoxLisRep.setEnabled(false);
          rdbtnPrivada.setEnabled(false);
          rdbtnPublica.setEnabled(false);
        }
      }
    });

    btnGuardar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String usuario = modelUsuario.getSelectedItem().toString();
        ctrLis = Fabrica.getIListas();
        try{
          if (checkUsuario() && checkLista()) {
            if (isCanalPublico(usuario)) {
              ctrLis.guardarCambios(modelLisRep.getSelectedItem().toString(), obtenerUsuarioId(usuario),
                  rdbtnPublica.isSelected());
              setVisible(false);
              clean();
              rdbtnPrivada.setSelected(true);
              rdbtnPublica.setSelected(false);
              rdbtnPrivada.setEnabled(false);
              rdbtnPublica.setEnabled(false);
              comboBoxLisRep.setEnabled(false);
            }
          }
      }
      catch(Exception error){}
      }
    });
  }

  public void cargarDatos() {

    ctrUsu = Fabrica.getIUsuariosCanales();
    usuarios = ctrUsu.listarDtUsuarios();

    modelUsuario.addElement("");
    for(DtUsuario usuario : usuarios) {
      modelUsuario.addElement(usuario.getNick());
    }
    ctrUsu = null;
  }

  public void cargarListas() {

    modelLisRep.removeAllElements();
    ctrLis = Fabrica.getIListas();

    if (modelUsuario.getSelectedItem() != null) {
      try{
        listas = ctrLis.getDtListasParticularesUsuario(obtenerUsuarioId(modelUsuario.getSelectedItem().toString()));

      for (DtLista lista: listas) {
        modelLisRep.addElement(lista.getNombre());
      }
      ctrLis = null;
    }
    catch(Exception e){}
    
    }
  }

  public void clean() {
    modelUsuario.removeAllElements();
    modelLisRep.removeAllElements();
    modelCategoria.removeAllElements();
    listas.clear();
    usuarios.clear();
  }

  boolean checkUsuario() {

    if (modelUsuario.getSelectedItem() == "") {
      JOptionPane.showMessageDialog(null, "No has seleccionado ningún usuario", "Error",
          JOptionPane.ERROR_MESSAGE);
      return false;
    }
    return true;
  }

  boolean checkLista() {

    if (modelLisRep.getSelectedItem() == "") {
      JOptionPane.showMessageDialog(null, "No has seleccionado ninguna lista", "Error",
          JOptionPane.ERROR_MESSAGE);
      return false;
    }
    return true;
  }

  boolean isCanalPublico(String usuario) {

    ctrUsu = Fabrica.getIUsuariosCanales();
    try{
      if (!ctrUsu.isCanalPublico(obtenerUsuarioId(usuario))) {
        JOptionPane.showMessageDialog(null,
            "No se puede modificar la visibilidad del video poque el canal es privado", "Error",
            JOptionPane.ERROR_MESSAGE);
        return false;
      }
      }
    catch(Exception e){}
    return true;
  }
  
  public int obtenerUsuarioId(String nombre){

    for(DtUsuario usuario : usuarios){
      if(usuario.getNick().equals(nombre)){
        return usuario.getIdUsuario();
      }
    }
    return 0;
  }

}

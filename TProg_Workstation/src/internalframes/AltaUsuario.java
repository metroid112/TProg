package internalframes;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import interfaces.Fabrica;
import interfaces.IUsuariosCanales;

@SuppressWarnings("serial")
public class AltaUsuario extends JInternalFrame {
  // protected static final String BufferedImage = null;
  private BufferedImage imagenFile = null;
  private JTextField textField;
  private JTextField textField_1;
  private JTextField textField_2;
  private File abre = null;
  private JTextField textField_3;
  private JLabel lblCorreo;
  private JLabel lblFechaDeNacimiento;
  private JTextField textField_4;
  private JRadioButton rdbtnNewRadioButton;
  private JTextPane textPane;
  private JRadioButton rdbtnSi;
  private JRadioButton rdbtnNo;
  private JComboBox<String> comboBoxCategoria;

  /**
   * Create the frame.
   */
  private IUsuariosCanales ctrlUsu;
  private JTextField dia;
  private JTextField mes;
  private JTextField ano;

  public AltaUsuario() {
    setNormalBounds(new Rectangle(20, 0, 300, 400));
    setTitle("Alta Usuario");
    setBounds(0, 0, 455, 533);

    JButton btnNewButton = new JButton("Cancelar");
    btnNewButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        dispose();
        clean();
      }
    });

    JButton btnAceptar = new JButton("Aceptar");

    JLabel lblIngreseLosDatos = new JLabel("Ingrese los datos del usuario");
    lblIngreseLosDatos.setHorizontalAlignment(SwingConstants.CENTER);

    textField = new JTextField();
    textField.setColumns(10);

    textField_1 = new JTextField();
    textField_1.setColumns(10);

    textField_2 = new JTextField();
    textField_2.setColumns(10);

    textField_3 = new JTextField();
    textField_3.setColumns(10);

    JLabel lblNickname = new JLabel("Nickname:");
    lblNickname.setHorizontalAlignment(SwingConstants.TRAILING);

    JLabel lblNombre = new JLabel("Nombre:");
    lblNombre.setHorizontalAlignment(SwingConstants.TRAILING);

    JLabel lblApellido = new JLabel("Apellido:");
    lblApellido.setHorizontalAlignment(SwingConstants.TRAILING);

    lblCorreo = new JLabel("Correo:");
    lblCorreo.setHorizontalAlignment(SwingConstants.TRAILING);

    lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
    lblFechaDeNacimiento.setHorizontalAlignment(SwingConstants.TRAILING);

    JLabel lblPrivacidad = new JLabel("Privacidad:");
    lblPrivacidad.setHorizontalAlignment(SwingConstants.TRAILING);

    // logica radio buttons

    rdbtnNewRadioButton = new JRadioButton("Privado");
    rdbtnNewRadioButton.setSelected(true);

    JRadioButton rdbtnPblico = new JRadioButton("Publico");
    rdbtnPblico.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        rdbtnNewRadioButton.setSelected(false);
        rdbtnPblico.setSelected(true);
      }
    });

    rdbtnNewRadioButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        rdbtnNewRadioButton.setSelected(true);
        rdbtnPblico.setSelected(false);
      }
    });

    JLabel lblCambiarCanalPor = new JLabel("Cambiar canal por defecto:");
    lblCambiarCanalPor.setHorizontalAlignment(SwingConstants.TRAILING);

    rdbtnSi = new JRadioButton("Si");

    rdbtnNo = new JRadioButton("No");
    rdbtnNo.setSelected(true);

    JLabel lblNombreCanal = new JLabel("Nombre canal:");
    lblNombreCanal.setHorizontalAlignment(SwingConstants.TRAILING);

    textField_4 = new JTextField();
    textField_4.setEnabled(false);
    textField_4.setColumns(10);

    JLabel lblDescripcin = new JLabel("Descripcion:");
    lblDescripcin.setHorizontalAlignment(SwingConstants.TRAILING);

    textPane = new JTextPane();
    textPane.setEnabled(false);

    // logica editar textos por defecto

    rdbtnNo.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        rdbtnNo.setSelected(true);
        rdbtnSi.setSelected(false);
        textField_4.setEnabled(false);
        textPane.setEnabled(false);
        comboBoxCategoria.setEnabled(false);
        comboBoxCategoria.setSelectedItem("Sin categoria");
      }
    });

    rdbtnSi.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        rdbtnNo.setSelected(false);
        rdbtnSi.setSelected(true);
        textField_4.setEnabled(true);
        textPane.setEnabled(true);
        comboBoxCategoria.setEnabled(true);
      }
    });

    btnAceptar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        cmdAltaUsuarioActionPerformed(e);
      }
    });

    dia = new JTextField();
    dia.setColumns(10);

    mes = new JTextField();
    mes.setColumns(10);

    ano = new JTextField();
    ano.setColumns(10);

    JLabel label = new JLabel("/");

    JLabel label_1 = new JLabel("/");

    JLabel lblImagen = new JLabel("Imagen:");
    lblImagen.setHorizontalAlignment(SwingConstants.TRAILING);

    JButton btnSeleccionar = new JButton("Seleccionar archivo");
    btnSeleccionar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        JFileChooser file = new JFileChooser();
        file.showOpenDialog(getFocusOwner());
        /** abrimos el archivo seleccionado */
        abre = file.getSelectedFile();
        if (abre != null) {
          try {
            imagenFile = ImageIO.read(abre);
          } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
      }
    });

    this.comboBoxCategoria = new JComboBox<String>();

    JLabel lblCategoria = new JLabel("Categoria:");

    // fin lógica botones

    GroupLayout groupLayout = new GroupLayout(getContentPane());
    groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
            .createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup().addGap(28)
                .addComponent(lblIngreseLosDatos, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE))
            .addGroup(groupLayout.createSequentialGroup().addContainerGap()
                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                    .addGroup(groupLayout.createSequentialGroup()
                        .addComponent(lblNombreCanal, GroupLayout.PREFERRED_SIZE, 165,
                            GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                    .addGroup(groupLayout.createSequentialGroup()
                        .addComponent(lblCorreo, GroupLayout.PREFERRED_SIZE, 165,
                            GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                    .addGroup(groupLayout.createSequentialGroup()
                        .addComponent(lblApellido, GroupLayout.PREFERRED_SIZE, 165,
                            GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                    .addGroup(groupLayout.createSequentialGroup()
                        .addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 165,
                            GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                    .addGroup(groupLayout.createSequentialGroup()
                        .addComponent(lblNickname, GroupLayout.PREFERRED_SIZE, 165,
                            GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(textField, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                    .addGroup(groupLayout.createSequentialGroup()
                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                            .addComponent(lblCambiarCanalPor, GroupLayout.PREFERRED_SIZE, 165,
                                GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrivacidad, GroupLayout.PREFERRED_SIZE, 165,
                                GroupLayout.PREFERRED_SIZE))
                        .addGap(12)
                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                            .addComponent(rdbtnSi, GroupLayout.PREFERRED_SIZE, 71,
                                GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdbtnNewRadioButton))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(groupLayout
                            .createParallelGroup(Alignment.LEADING)
                            .addComponent(rdbtnNo, GroupLayout.PREFERRED_SIZE, 71,
                                GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdbtnPblico)))
                    .addGroup(
                        groupLayout.createSequentialGroup()
                            .addComponent(lblFechaDeNacimiento, GroupLayout.PREFERRED_SIZE, 165,
                                GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(dia, GroupLayout.PREFERRED_SIZE, 42,
                                GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(ComponentPlacement.RELATED).addComponent(label)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(mes, GroupLayout.PREFERRED_SIZE, 43,
                                GroupLayout.PREFERRED_SIZE)
                            .addGap(7)
                            .addComponent(label_1, GroupLayout.PREFERRED_SIZE, 5,
                                GroupLayout.PREFERRED_SIZE)
                            .addGap(6)
                            .addComponent(ano, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                    .addGroup(groupLayout.createSequentialGroup()
                        .addComponent(lblDescripcin, GroupLayout.PREFERRED_SIZE, 165,
                            GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(textPane, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)))))
            .addGap(48))
        .addGroup(
            groupLayout.createSequentialGroup().addContainerGap()
                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                    .addGroup(groupLayout.createSequentialGroup().addComponent(btnAceptar)
                        .addPreferredGap(ComponentPlacement.RELATED).addComponent(btnNewButton))
                    .addComponent(lblCategoria).addComponent(lblImagen, GroupLayout.PREFERRED_SIZE,
                        165, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(
                    groupLayout.createParallelGroup(Alignment.LEADING).addComponent(btnSeleccionar)
                        .addComponent(comboBoxCategoria, 0, 209, Short.MAX_VALUE))
                .addContainerGap()));
    groupLayout
        .setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
            .addGroup(groupLayout.createSequentialGroup().addContainerGap()
                .addComponent(lblIngreseLosDatos).addGap(26)
                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lblNickname).addComponent(textField, GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lblNombre).addComponent(textField_1, GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lblApellido).addComponent(textField_2, GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lblCorreo).addComponent(textField_3, GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lblFechaDeNacimiento)
                    .addComponent(dia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addComponent(mes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addComponent(ano, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addComponent(label).addComponent(label_1))
                .addGap(13)
                .addGroup(
                    groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(rdbtnPblico)
                        .addComponent(lblPrivacidad).addComponent(rdbtnNewRadioButton))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(rdbtnNo)
                    .addComponent(rdbtnSi).addComponent(lblCambiarCanalPor))
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addGroup(
                    groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNombreCanal)
                        .addComponent(textField_4, GroupLayout.PREFERRED_SIZE,
                            GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addGroup(
                    groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup().addComponent(lblDescripcin)
                            .addGap(71)
                            .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblImagen).addComponent(btnSeleccionar)))
                        .addComponent(textPane, GroupLayout.PREFERRED_SIZE, 64,
                            GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addGroup(
                    groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup().addComponent(lblCategoria)
                            .addGap(27)
                            .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                .addComponent(btnNewButton).addComponent(btnAceptar)))
                        .addComponent(comboBoxCategoria, GroupLayout.PREFERRED_SIZE,
                            GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(117)));
    getContentPane().setLayout(groupLayout);

  }

  protected void cmdAltaUsuarioActionPerformed(ActionEvent e) {
    ctrlUsu = Fabrica.getIUsuariosCanales();
    if (ctrlUsu.existeUsuario(textField.getText())) {
      JOptionPane.showMessageDialog(this, "El usuario ya existe.");
    } else if (!ctrlUsu.isEmailUnique(textField_3.getText())) {
      JOptionPane.showMessageDialog(this, "El correo electronico ya esta en uso.");
    } else if (!textField_3.getText().contains("@") || !textField_3.getText().contains(".")) {
      JOptionPane.showMessageDialog(this, "Correo electronico invalido");
    } else if (textField.getText().equals("") || textField_1.getText().equals("")
        || textField_2.getText().equals("")) {
      JOptionPane.showMessageDialog(this,
          "Los campos Nickname, Nombre y Apellido son obligatorios.");
    } else if (!textField_3.getText().contains("@") || !textField_3.getText().contains(".")) {
      JOptionPane.showMessageDialog(this, "Correo electronico invalido");
    } else {
      try {

        String nick = textField.getText();
        String nombre = textField_1.getText();
        String apellido = textField_2.getText();
        String correo = textField_3.getText();
        String categoria = (String) this.comboBoxCategoria.getSelectedItem();
        Date nacimiento = null; // formar la fecha desde las partes.
        BufferedImage imagen = imagenFile;
        boolean privado = rdbtnNewRadioButton.isSelected();
        boolean personalizado = rdbtnSi.isSelected();
        String descripcion = "Sin descripcion";
        String nombreCanal = textField.getText();
        if (personalizado) {
          descripcion = textPane.getText();
          nombreCanal = textField_4.getText();
        }
        try {
          String mes2 = (mes.getText().length() == 1) ? "0" + mes.getText() : mes.getText();
          String dia2 = (dia.getText().length() == 1) ? "0" + dia.getText() : dia.getText();
          String fechaString = dia2 + "/" + mes2 + "/" + ano.getText();
          SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
          nacimiento = sdf.parse(fechaString);
          if (!fechaString.equals(sdf.format(nacimiento))) {
            throw new Exception();
          }
        } catch (Exception ex) {
          throw new Exception("Formato de fecha incorrecto", ex);
        }
        ctrlUsu.altaUsuario(nick, nombre, apellido, correo, nacimiento, imagen, nombreCanal,
            descripcion, categoria, privado);

        JOptionPane.showMessageDialog(this, "Se ha creado el usuario con exito!");
        clean();
        setVisible(false);
      } catch (Exception m) {
        JOptionPane.showMessageDialog(this, m.getMessage());
      }

    }
  }

  // Limpia la ventana.
  protected void clean() {
    textField.setText("");
    textField_1.setText("");
    textField_2.setText("");
    textField_3.setText("");
    textField_4.setText("");
    textPane.setText("");
    dia.setText("");
    mes.setText("");
    ano.setText("");
    imagenFile = null;
  }

  public void cargarDatos() {
    DefaultComboBoxModel<String> modelCombo = new DefaultComboBoxModel<String>(
        Fabrica.getIVideos().listarCategorias());

    modelCombo.addElement("Sin categoria");
    modelCombo.setSelectedItem("Sin categoria");
    this.comboBoxCategoria.setModel(modelCombo);
  }
}
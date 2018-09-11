package internalframes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import paneles.SelectorUsuarios;

@SuppressWarnings("serial")
public class ModificarUsuario extends JInternalFrame {

  /**
   * Launch the application.
   */

  /**
   * Create the frame.
   */
  SelectorUsuarios panel = new SelectorUsuarios();
  private JTextField txtA;
  private JTextField txtB;
  private JTextField txtApe;
  private JTextField txtCor;
  private JTextField txtNomcan;

  public ModificarUsuario() {
    setBounds(100, 100, 648, 450);

    JSplitPane splitPane = new JSplitPane();

    JButton btnCerrar = new JButton("Cerrar");
    JButton btnNewButton = new JButton("Cerrar");
    btnNewButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        // model.removeAllElements();
      }
    });

    JButton btnSeleccionar = new JButton("Seleccionar");
    btnSeleccionar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String usuarioSeleccionado = panel.getSelectedItem();
        if (usuarioSeleccionado != null) {
          // TODO something
        } else {
          JOptionPane.showMessageDialog(getFocusOwner(), "Seleccione un usuario", "Error",
              getDefaultCloseOperation());
        }
      }

    });
    GroupLayout groupLayout = new GroupLayout(getContentPane());
    groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        .addGroup(groupLayout.createSequentialGroup().addContainerGap(245, Short.MAX_VALUE)
            .addComponent(btnSeleccionar).addGap(207).addComponent(btnCerrar).addContainerGap())
        .addComponent(splitPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 632,
            Short.MAX_VALUE));
    groupLayout
        .setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING,
                    groupLayout.createSequentialGroup()
                        .addComponent(splitPane, GroupLayout.PREFERRED_SIZE, 360,
                            GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                            .addComponent(btnCerrar).addComponent(btnSeleccionar))
                        .addContainerGap()));

    splitPane.setLeftComponent(panel);

    JPanel panel_1 = new JPanel();
    splitPane.setRightComponent(panel_1);

    JLabel lblNewLabel = new JLabel("Detalles usuario:");

    JLabel lblNickname = new JLabel("Nickname:");
    lblNickname.setHorizontalAlignment(SwingConstants.TRAILING);

    JLabel lblNombre = new JLabel("Nombre:");
    lblNombre.setHorizontalAlignment(SwingConstants.TRAILING);

    JLabel lblApellido = new JLabel("Apellido:");
    lblApellido.setHorizontalAlignment(SwingConstants.TRAILING);

    JLabel lblCorreo = new JLabel("Correo:");
    lblCorreo.setHorizontalAlignment(SwingConstants.TRAILING);

    JLabel lblFechaDeNacimineto = new JLabel("Fecha de nacimiento:");
    lblFechaDeNacimineto.setHorizontalAlignment(SwingConstants.TRAILING);

    JLabel lblNombreCanal = new JLabel("Nombre canal:");
    lblNombreCanal.setHorizontalAlignment(SwingConstants.TRAILING);

    JLabel lblDescripcinCanal = new JLabel("Descripci\u00F3n canal:");
    lblDescripcinCanal.setHorizontalAlignment(SwingConstants.TRAILING);

    txtA = new JTextField();
    txtA.setText("nic");
    txtA.setColumns(10);

    txtB = new JTextField();
    txtB.setText("nom");
    txtB.setColumns(10);

    txtApe = new JTextField();
    txtApe.setText("ape");
    txtApe.setColumns(10);

    txtCor = new JTextField();
    txtCor.setText("cor");
    txtCor.setColumns(10);

    txtNomcan = new JTextField();
    txtNomcan.setText("nomcan");
    txtNomcan.setColumns(10);

    JTextPane txtpnDesccan = new JTextPane();
    txtpnDesccan.setText("descCan");
    GroupLayout gl_panel_1 = new GroupLayout(panel_1);
    gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panel_1.createSequentialGroup().addGap(30).addGroup(gl_panel_1
            .createParallelGroup(Alignment.TRAILING)
            .addComponent(lblDescripcinCanal, GroupLayout.PREFERRED_SIZE, 123,
                GroupLayout.PREFERRED_SIZE)
            .addComponent(lblNombreCanal, GroupLayout.PREFERRED_SIZE, 123,
                GroupLayout.PREFERRED_SIZE)
            .addComponent(lblCorreo, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblApellido, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblNickname, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblNewLabel).addComponent(lblFechaDeNacimineto))
            .addPreferredGap(ComponentPlacement.RELATED).addGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                    .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                            .addComponent(txtCor, GroupLayout.PREFERRED_SIZE, 160,
                                GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                            .addGroup(gl_panel_1.createSequentialGroup()
                                .addComponent(txtApe, GroupLayout.PREFERRED_SIZE, 160,
                                    GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_panel_1.createSequentialGroup()
                                    .addComponent(txtA, GroupLayout.DEFAULT_SIZE, 160,
                                        Short.MAX_VALUE)
                                    .addGap(120))
                                .addGroup(gl_panel_1.createSequentialGroup()
                                    .addComponent(txtB, GroupLayout.PREFERRED_SIZE, 160,
                                        GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap()))))
                    .addGroup(gl_panel_1.createSequentialGroup()
                        .addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
                            .addComponent(txtpnDesccan, Alignment.LEADING).addComponent(txtNomcan,
                                Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                        .addContainerGap()))));
    gl_panel_1
        .setVerticalGroup(
            gl_panel_1.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
                    .addComponent(lblNewLabel).addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblNickname).addComponent(txtA, GroupLayout.PREFERRED_SIZE,
                            GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblNombre).addComponent(txtB, GroupLayout.PREFERRED_SIZE,
                            GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblApellido).addComponent(txtApe, GroupLayout.PREFERRED_SIZE,
                            GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblCorreo).addComponent(txtCor, GroupLayout.PREFERRED_SIZE,
                            GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.RELATED).addComponent(lblFechaDeNacimineto)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(gl_panel_1
                        .createParallelGroup(Alignment.BASELINE).addComponent(lblNombreCanal)
                        .addComponent(txtNomcan, GroupLayout.PREFERRED_SIZE,
                            GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblDescripcinCanal).addComponent(txtpnDesccan,
                            GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(106, Short.MAX_VALUE)));
    panel_1.setLayout(gl_panel_1);
    getContentPane().setLayout(groupLayout);

  }

  public void cargarDatos() {
    panel.cargarDatos();
  }
}

package internalframes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import paneles.SelectorUsuarios;

@SuppressWarnings("serial")
public class ConsultaUsuario extends JInternalFrame {
  SelectorUsuarios panel = new SelectorUsuarios();

  public ConsultaUsuario(VerInformacionUsuario ventanaInfo) {

    setTitle("Consultar Usuario");
    setBounds(100, 10, 466, 490);

    JButton btnNewButton = new JButton("Cerrar");
    btnNewButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        setVisible(false);
      }
    });

    JButton btnSeleccionar = new JButton("Seleccionar");
    btnSeleccionar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent clic) {
        int usuarioSeleccionado = panel.getSelectedItem();

        if (usuarioSeleccionado != -1) {

          ventanaInfo.cargarInformacionUsuario(usuarioSeleccionado);
          ventanaInfo.setVisible(true);
          setVisible(false);
        } else {
          JOptionPane.showMessageDialog(getFocusOwner(), "Seleccione un usuario", "Error",
              getDefaultCloseOperation());
        }
      }
    });

    GroupLayout groupLayout = new GroupLayout(getContentPane());
    groupLayout
        .setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup().addContainerGap(254, Short.MAX_VALUE)
                .addComponent(btnSeleccionar).addPreferredGap(ComponentPlacement.UNRELATED)
                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 75,
                    GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 450,
                Short.MAX_VALUE));
    groupLayout
        .setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addComponent(
                        panel, GroupLayout.PREFERRED_SIZE, 398, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnNewButton).addComponent(btnSeleccionar))
                    .addContainerGap()));
    getContentPane().setLayout(groupLayout);

  }

  public void cargarDatos() {
    panel.cargarDatos();
  }

}

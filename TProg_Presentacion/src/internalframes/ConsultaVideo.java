package internalframes;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import interfaces.IVideos;
import paneles.InfoVideo;
import paneles.SeleccionVideo;

@SuppressWarnings("serial")
public class ConsultaVideo extends JInternalFrame {

  private IVideos contVideos;
  private SeleccionVideo seleccionVideo;
  private InfoVideo infoVideo;

  /**
   * Create the frame.
   */
  public ConsultaVideo(IVideos contVideos) {

    this.contVideos = contVideos;

    setTitle("Consulta de Video");
    setBounds(100, 100, 580, 475);
    getContentPane().setLayout(new CardLayout(0, 0));

    JPanel panelSeleccion = new JPanel();
    getContentPane().add(panelSeleccion, "name_1194544403547543");

    seleccionVideo = new SeleccionVideo(this.contVideos);

    JButton btnVerInfo = new JButton("Ver Info");
    btnVerInfo.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        verInfo();
      }
    });

    JButton btnCancelar = new JButton("Cancelar");
    GroupLayout gl_panelSeleccion = new GroupLayout(panelSeleccion);
    gl_panelSeleccion.setHorizontalGroup(gl_panelSeleccion.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panelSeleccion.createSequentialGroup().addGap(57)
            .addGroup(gl_panelSeleccion.createParallelGroup(Alignment.TRAILING)
                .addGroup(gl_panelSeleccion.createSequentialGroup().addComponent(btnVerInfo)
                    .addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnCancelar))
                .addComponent(seleccionVideo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE))
            .addContainerGap(57, Short.MAX_VALUE)));
    gl_panelSeleccion.setVerticalGroup(gl_panelSeleccion.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panelSeleccion.createSequentialGroup().addGap(5)
            .addComponent(
                seleccionVideo, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(ComponentPlacement.RELATED)
            .addGroup(gl_panelSeleccion.createParallelGroup(Alignment.BASELINE)
                .addComponent(btnCancelar).addComponent(btnVerInfo))
            .addContainerGap(54, Short.MAX_VALUE)));
    panelSeleccion.setLayout(gl_panelSeleccion);

    JPanel panelInfo = new JPanel();
    getContentPane().add(panelInfo, "name_1194937185363056");

    JButton btnVolver = new JButton("Volver");
    btnVolver.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        // contVideos.getDtVideo(seleccionVideo.getVideo(),
        // seleccionVideo.getUsuario());
        cambioPanel(); // Vuelvo al panel de seleccion

      }
    });

    infoVideo = new InfoVideo(contVideos);
    GroupLayout gl_panelInfo = new GroupLayout(panelInfo);
    gl_panelInfo.setHorizontalGroup(gl_panelInfo.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panelInfo.createSequentialGroup().addGroup(gl_panelInfo
            .createParallelGroup(Alignment.LEADING)
            .addGroup(gl_panelInfo.createSequentialGroup().addGap(400).addComponent(btnVolver))
            .addGroup(gl_panelInfo.createSequentialGroup().addGap(29).addComponent(infoVideo,
                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(28, Short.MAX_VALUE)));
    gl_panelInfo.setVerticalGroup(gl_panelInfo.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panelInfo.createSequentialGroup().addContainerGap()
            .addComponent(infoVideo, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(ComponentPlacement.RELATED).addComponent(btnVolver)
            .addContainerGap(21, Short.MAX_VALUE)));
    panelInfo.setLayout(gl_panelInfo);
    btnCancelar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        setVisible(false);
      }
    });

  }

  public void cargarDatos() {
    seleccionVideo.cargarDatos();
  }

  private void verInfo() {
    if (seleccionVideo.getVideo() != null && seleccionVideo.getUsuario() != null) {
      infoVideo.cargarDatos(
          contVideos.getDtVideo(seleccionVideo.getVideo(), seleccionVideo.getUsuario())); // Paso
      // la
      // info
      // al
      // panel
      // de
      // info
      cambioPanel(); // Voy al panel de informacion
    } else {
      JOptionPane.showMessageDialog(this, "Debe rellenar los campos", "Error",
          JOptionPane.ERROR_MESSAGE);
    }
  }

  private void cambioPanel() {
    CardLayout layout = (CardLayout) getContentPane().getLayout(); // Consigo el layout
    layout.next(getContentPane()); // Cambia al siguiente panel

  }
}

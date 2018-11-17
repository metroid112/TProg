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
      @Override
      public void actionPerformed(ActionEvent e) {
        verInfo();
      }
    });

    JButton btnCancelar = new JButton("Cancelar");
    GroupLayout glpanelSeleccion = new GroupLayout(panelSeleccion);
    glpanelSeleccion.setHorizontalGroup(glpanelSeleccion.createParallelGroup(Alignment.LEADING)
        .addGroup(glpanelSeleccion.createSequentialGroup().addGap(57)
            .addGroup(glpanelSeleccion.createParallelGroup(Alignment.TRAILING)
                .addGroup(glpanelSeleccion.createSequentialGroup().addComponent(btnVerInfo)
                    .addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnCancelar))
                .addComponent(seleccionVideo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE))
            .addContainerGap(57, Short.MAX_VALUE)));
    glpanelSeleccion.setVerticalGroup(glpanelSeleccion.createParallelGroup(Alignment.LEADING)
        .addGroup(glpanelSeleccion.createSequentialGroup().addGap(5)
            .addComponent(
                seleccionVideo, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(ComponentPlacement.RELATED)
            .addGroup(glpanelSeleccion.createParallelGroup(Alignment.BASELINE)
                .addComponent(btnCancelar).addComponent(btnVerInfo))
            .addContainerGap(54, Short.MAX_VALUE)));
    panelSeleccion.setLayout(glpanelSeleccion);

    JPanel panelInfo = new JPanel();
    getContentPane().add(panelInfo, "name_1194937185363056");

    JButton btnVolver = new JButton("Volver");
    btnVolver.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        // contVideos.getDtVideo(seleccionVideo.getVideo(),
        // seleccionVideo.getUsuario());
        cambioPanel(); // Vuelvo al panel de seleccion

      }
    });

    infoVideo = new InfoVideo(contVideos);
    GroupLayout glpanelInfo = new GroupLayout(panelInfo);
    glpanelInfo.setHorizontalGroup(glpanelInfo.createParallelGroup(Alignment.LEADING)
        .addGroup(glpanelInfo.createSequentialGroup().addGroup(glpanelInfo
            .createParallelGroup(Alignment.LEADING)
            .addGroup(glpanelInfo.createSequentialGroup().addGap(400).addComponent(btnVolver))
            .addGroup(glpanelInfo.createSequentialGroup().addGap(29).addComponent(infoVideo,
                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(28, Short.MAX_VALUE)));
    glpanelInfo.setVerticalGroup(glpanelInfo.createParallelGroup(Alignment.LEADING)
        .addGroup(glpanelInfo.createSequentialGroup().addContainerGap()
            .addComponent(infoVideo, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(ComponentPlacement.RELATED).addComponent(btnVolver)
            .addContainerGap(21, Short.MAX_VALUE)));
    panelInfo.setLayout(glpanelInfo);
    btnCancelar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        setVisible(false);
      }
    });

  }

  public void cargarDatos() {
    seleccionVideo.cargarDatos();
  }

  private void verInfo() {
    try{
      if (seleccionVideo.getVideo() != -1 && seleccionVideo.getUsuario() != null) {
        infoVideo.cargarDatos(
            contVideos.getDtVideo(seleccionVideo.getVideo()));
        cambioPanel();
      } else {
        JOptionPane.showMessageDialog(this, "Debe rellenar los campos", "Error",
            JOptionPane.ERROR_MESSAGE);
      }
    }
    catch(Exception e){}
  }

  private void cambioPanel() {
    CardLayout layout = (CardLayout) getContentPane().getLayout();
    layout.next(getContentPane());

  }
}

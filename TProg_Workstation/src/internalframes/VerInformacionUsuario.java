package internalframes;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import datatypes.DtLista;
import interfaces.Fabrica;
import interfaces.IListas;
import interfaces.IVideos;
import paneles.DetallesUsuario;
import paneles.InfoVideo;

@SuppressWarnings("serial")
public class VerInformacionUsuario extends JInternalFrame {
  private DetallesUsuario paneluser = null;
  private JPanel panel_2;
  private IListas ctrlLis = Fabrica.getIListas();
  private JPanel PanelInfoVideo;
  private String UsrSel = null;
  private ConsultaUsuario padre = null;
  public void setPadre(ConsultaUsuario padre) {
    this.padre = padre;
  }

  // imports para el video
  private InfoVideo PanelConsultaVideo;
  private JLabel lblNewLabel_1 = new JLabel("vNombreLista");
  private JLabel lblVtipolista = new JLabel("vTipoLista");
  private JLabel lblNewLabel_2 = new JLabel("vPrivacidad");
  private JList<String> videosLista;
  private IVideos contVideos = Fabrica.getIVideos();

  // fin

  public VerInformacionUsuario() {
    setBounds(0, 10, 787, 480);

    getContentPane().setLayout(new CardLayout(0, 0));
    JPanel panelInfoUsuario = new JPanel();
    getContentPane().add(panelInfoUsuario, "name_1341908072638329");

    JButton btnNewButton = new JButton("Cerrar");
    btnNewButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        setVisible(false);
        getContentPane().remove(paneluser);
        panel_2.remove(paneluser);
        paneluser = null;
        // padre.SetVisible(true);
        // getContentPane().removeAll();
      }
    });

    panel_2 = new JPanel();

    JButton btnNewButton1 = new JButton("Ver info video");
    btnNewButton1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        if (paneluser.isVideoSeleccionado()) {
          String vidSel = paneluser.getVideoSeleccionado();
          verInfo(vidSel, UsrSel);
        } else {
          JOptionPane.showMessageDialog(getFocusOwner(), "Seleccione un video");
        }
      }
    });

    JButton verInfoListas = new JButton("Ver info lista");
    verInfoListas.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        // cargar informacion de lista,
        if (paneluser.isListaSelected()) {
          String lisSel = paneluser.getListaSeleccionada();
          if (lisSel != null) {
            cargaDatosLista(lisSel, UsrSel);
          } else {
            JOptionPane.showInputDialog(this);
          }
          cambioPanel();
          cambioPanel();
        } else {
          JOptionPane.showMessageDialog(getFocusOwner(), "Seleccione una lista");
        }

      }
    });
    GroupLayout glpanelInfoUsuario = new GroupLayout(panelInfoUsuario);
    glpanelInfoUsuario.setHorizontalGroup(glpanelInfoUsuario
        .createParallelGroup(Alignment.TRAILING)
        .addComponent(panel_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 771,
            GroupLayout.PREFERRED_SIZE)
        .addGroup(glpanelInfoUsuario.createSequentialGroup().addContainerGap(443, Short.MAX_VALUE)
            .addComponent(verInfoListas, GroupLayout.PREFERRED_SIZE, 111,
                GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(ComponentPlacement.RELATED).addComponent(btnNewButton1)
            .addPreferredGap(ComponentPlacement.RELATED)
            .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
            .addContainerGap()));
    glpanelInfoUsuario.setVerticalGroup(glpanelInfoUsuario.createParallelGroup(Alignment.TRAILING)
        .addGroup(glpanelInfoUsuario.createSequentialGroup()
            .addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)
            .addGap(28)
            .addGroup(glpanelInfoUsuario.createParallelGroup(Alignment.BASELINE)
                .addComponent(btnNewButton).addComponent(btnNewButton1)
                .addComponent(verInfoListas))
            .addContainerGap()));
    panelInfoUsuario.setLayout(glpanelInfoUsuario);

    PanelInfoVideo = new JPanel();
    getContentPane().add(PanelInfoVideo, "name_1341929743838464");

    PanelConsultaVideo = new InfoVideo(contVideos);

    JButton btnVolver = new JButton("Volver");
    btnVolver.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        cambioPanel();
        cambioPanel();// se repite porque hay 3 paneles.
      }
    });
    GroupLayout glPanelInfoVideo = new GroupLayout(PanelInfoVideo);
    glPanelInfoVideo.setHorizontalGroup(glPanelInfoVideo.createParallelGroup(Alignment.TRAILING)
        .addComponent(PanelConsultaVideo, GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
        .addGroup(glPanelInfoVideo.createSequentialGroup().addContainerGap(672, Short.MAX_VALUE)
            .addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
            .addContainerGap()));
    glPanelInfoVideo.setVerticalGroup(glPanelInfoVideo.createParallelGroup(Alignment.LEADING)
        .addGroup(glPanelInfoVideo.createSequentialGroup()
            .addComponent(PanelConsultaVideo, GroupLayout.PREFERRED_SIZE, 374,
                GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
            .addComponent(btnVolver).addContainerGap()));
    PanelInfoVideo.setLayout(glPanelInfoVideo);

    JPanel panelInfoListas = new JPanel();
    getContentPane().add(panelInfoListas, "name_1462766790498547");

    JButton button = new JButton("Volver");
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        cambioPanel();
      }
    });

    JScrollPane VideosDeLista = new JScrollPane();

    JLabel lblNewLabel = new JLabel("Videos");

    JButton VerInfoVideoDesdeCOnsultaLista = new JButton("Ver info video");
    // TODO darle proposito

    JLabel lblDetallesLista = new JLabel("Detalles lista:");
    lblDetallesLista.setFont(new Font("Tahoma", Font.PLAIN, 15));
    GroupLayout glpanelInfoListas = new GroupLayout(panelInfoListas);
    glpanelInfoListas.setHorizontalGroup(glpanelInfoListas.createParallelGroup(Alignment.TRAILING)
        .addGroup(glpanelInfoListas.createSequentialGroup().addContainerGap(549, Short.MAX_VALUE)
            .addComponent(VerInfoVideoDesdeCOnsultaLista, GroupLayout.PREFERRED_SIZE, 111,
                GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(ComponentPlacement.UNRELATED)
            .addComponent(button, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
        .addGroup(glpanelInfoListas.createSequentialGroup().addGap(119)
            .addComponent(lblDetallesLista, GroupLayout.PREFERRED_SIZE, 148,
                GroupLayout.PREFERRED_SIZE)
            .addContainerGap(504, Short.MAX_VALUE))
        .addGroup(glpanelInfoListas.createSequentialGroup().addGap(80)
            .addGroup(glpanelInfoListas.createParallelGroup(Alignment.LEADING)
                .addComponent(lblVtipolista, GroupLayout.PREFERRED_SIZE, 77,
                    GroupLayout.PREFERRED_SIZE)
                .addComponent(lblNewLabel_2).addComponent(lblNewLabel_1))
            .addPreferredGap(ComponentPlacement.RELATED, 258, Short.MAX_VALUE)
            .addGroup(glpanelInfoListas.createParallelGroup(Alignment.LEADING)
                .addComponent(lblNewLabel).addComponent(VideosDeLista, GroupLayout.PREFERRED_SIZE,
                    227, GroupLayout.PREFERRED_SIZE))
            .addGap(129)));
    glpanelInfoListas
        .setVerticalGroup(glpanelInfoListas.createParallelGroup(Alignment.TRAILING)
            .addGroup(glpanelInfoListas.createSequentialGroup().addGap(30)
                .addComponent(lblDetallesLista).addGap(18).addComponent(lblNewLabel)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(glpanelInfoListas.createParallelGroup(Alignment.BASELINE)
                    .addComponent(VideosDeLista, GroupLayout.PREFERRED_SIZE, 228,
                        GroupLayout.PREFERRED_SIZE)
                    .addGroup(glpanelInfoListas.createSequentialGroup().addComponent(lblNewLabel_1)
                        .addGap(8).addComponent(lblNewLabel_2)
                        .addPreferredGap(ComponentPlacement.RELATED).addComponent(lblVtipolista)))
                .addPreferredGap(ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                .addGroup(glpanelInfoListas.createParallelGroup(Alignment.BASELINE)
                    .addComponent(button).addComponent(VerInfoVideoDesdeCOnsultaLista))
                .addContainerGap()));

    videosLista = new JList<String>();
    VideosDeLista.setViewportView(videosLista);
    panelInfoListas.setLayout(glpanelInfoListas);
    // cambioPanel();
  }

  public void cargarInformacionUsuario(String usuario) {
    UsrSel = usuario;
    paneluser = new DetallesUsuario(usuario);
    panel_2.add(paneluser, BorderLayout.CENTER);
  }

  public void verInfo(String vidSel, String userSel) {
    PanelConsultaVideo.cargarDatos(contVideos.getDtVideo(vidSel, userSel));
    PanelInfoVideo.add(PanelConsultaVideo, BorderLayout.CENTER);
    cambioPanel(); // Voy al panel de informacion
  }

  public void cambioPanel() {
    CardLayout layout = (CardLayout) getContentPane().getLayout(); 
    layout.next(getContentPane());
  }
/

  private void cargaDatosLista(String lista, String usuario) {

    DtLista dtLista;
    try {

      dtLista = ctrlLis.getDt(lista, usuario);
      if (dtLista.isVisible()) {
        lblNewLabel_2.setText("Publico");
      } else {
        lblNewLabel_2.setText("Privado");
      }
      DefaultListModel<String> modeloVideos = new DefaultListModel<String>();
      for (String vid : dtLista.getVideos()) {
        modeloVideos.addElement(vid);
      }
      videosLista.setModel(modeloVideos);
      lblNewLabel_1.setText(dtLista.getNombre());
      lblVtipolista.setText(dtLista.getTipo());

    } catch (Exception e) {

      e.printStackTrace();
    }

  }
}

package paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import datatypes.DtUsuario;
import datatypes.DtVideo;
import interfaces.IUsuariosCanales;
import interfaces.IVideos;

@SuppressWarnings("serial")
public class SeleccionVideo extends JPanel implements ActionListener {

  private JComboBox<String> cBoxUsuarios;
  private List<DtVideo> videos;
  private List<DtUsuario> usuarios;
  private IVideos contVideos;
  private IUsuariosCanales contUsuarios;
  private JList<String> listaVideos;

  public SeleccionVideo(IVideos contVideos, IUsuariosCanales contUsuarios) {

    this.contVideos = contVideos;
    this.contUsuarios = contUsuarios;
    
    JLabel lblUsuario = new JLabel("Usuario:");

    cBoxUsuarios = new JComboBox<String>();
    cBoxUsuarios.addActionListener(this); // Agrego el listener para leer el usuario seleccionado

    JScrollPane scrollPane = new JScrollPane();
    GroupLayout groupLayout = new GroupLayout(this);
    groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup().addGap(62)
            .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                .addComponent(scrollPane, Alignment.LEADING).addGroup(Alignment.LEADING,
                    groupLayout.createSequentialGroup().addComponent(lblUsuario).addGap(18)
                        .addComponent(cBoxUsuarios, GroupLayout.PREFERRED_SIZE, 269,
                            GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(61, Short.MAX_VALUE)));
    groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup().addGap(55)
            .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                .addComponent(cBoxUsuarios, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE)
                .addComponent(lblUsuario))
            .addGap(18)
            .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
            .addContainerGap(77, Short.MAX_VALUE)));

    listaVideos = new JList<String>();
    listaVideos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    scrollPane.setViewportView(listaVideos);

    JLabel lblVideos = new JLabel("Videos:");
    scrollPane.setColumnHeaderView(lblVideos);
    setLayout(groupLayout);

  }

  public int getVideo() {
    for(DtVideo video : videos){
      if(video.getNombre().equals(listaVideos.getSelectedValue()))
        return video.getId();
    }
    return 0;
  }

  public void cargarDatos() {
    usuarios = contUsuarios.listarDtUsuarios();
    String[] usuariosArray = (String[]) usuarios.toArray();
    DefaultComboBoxModel<String> modelU = new DefaultComboBoxModel<String>(usuariosArray);
    cBoxUsuarios.setModel(modelU);
    cBoxUsuarios.setSelectedIndex(-1);
    updateLista((String) cBoxUsuarios.getSelectedItem());
  }

  public void updateLista(String nickname) {
    try{
      DefaultListModel<String> model = new DefaultListModel<String>();
      videos = contVideos.listarVideos(obtenerUsuarioId(cBoxUsuarios.getSelectedItem().toString()));
      if (videos != null) {
        for (DtVideo vid : videos) {
          model.addElement(vid.getNombre());
        }
      }
      listaVideos.setModel(model);
      }
    catch(Exception e){}
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    updateLista((String) cBoxUsuarios.getSelectedItem());
  }

  public String getUsuario() {
    if (cBoxUsuarios.getSelectedIndex() > -1) {
      return (String) cBoxUsuarios.getSelectedItem();
    } else {
      return null;
    }
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

package internalframes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import datatypes.DtCategoria;
import datatypes.DtLista;
import datatypes.DtVideo;
import interfaces.Fabrica;
import interfaces.ICategorias;

@SuppressWarnings("serial")
public class ConsultaCategoria extends JInternalFrame {

  private ICategorias ctrlCat;
  private List<DtCategoria> categorias;
  private DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
  private DefaultListModel<String> videos = new DefaultListModel<>();
  private DefaultListModel<String> listas = new DefaultListModel<>();

  public ConsultaCategoria() {
    setTitle("Consulta de Categorias");
    setBounds(0, 0, 640, 480);

    JButton btnNewButton = new JButton("Cerrar");
    btnNewButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        model.removeAllElements();
        categorias.clear();
      }
    });

    JScrollPane scrollPane = new JScrollPane();

    JScrollPane scrollPane1 = new JScrollPane();

    JLabel lblVideos = new JLabel("Videos:");

    JLabel lblListasDeReproduccion = new JLabel("Listas de reproduccion:");

    JComboBox<String> comboBox = new JComboBox<>(model);

    comboBox.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        String selected = comboBox.getSelectedItem().toString();
        cmdConsultaCategoriaActionPerformed(selected);
      }
    });

    JLabel lblSeleccioneUnaCategoria = new JLabel("Seleccione una categoria:");
    GroupLayout groupLayout = new GroupLayout(getContentPane());
    groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        .addGroup(groupLayout.createSequentialGroup()
            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
                .createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                    .addComponent(lblSeleccioneUnaCategoria, GroupLayout.DEFAULT_SIZE,
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboBox, 0, 174, Short.MAX_VALUE))
                .addGap(49)
                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                    .addComponent(lblListasDeReproduccion).addComponent(lblVideos)
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)))
                .addGap(107)).addGroup(Alignment.TRAILING,
                    groupLayout.createSequentialGroup().addComponent(btnNewButton).addGap(216)))));
    groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup().addGap(29)
            .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblVideos)
                .addComponent(lblSeleccioneUnaCategoria))
            .addGap(26)
            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 110,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(18).addComponent(lblListasDeReproduccion)
                    .addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 110,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(70).addComponent(btnNewButton))
                .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE))
            .addContainerGap()));

    JList<String> list = new JList<>(videos);
    list.setEnabled(false);
    scrollPane.setViewportView(list);

    JList<String> list1 = new JList<>(listas);
    list1.setEnabled(false);
    scrollPane1.setViewportView(list1);
    getContentPane().setLayout(groupLayout);

  }

  public void cargarDatos() {

    ctrlCat = Fabrica.getICategorias();

    categorias = ctrlCat.listarCategorias();

    for (DtCategoria categoria : categorias) {
      model.addElement(categoria.getNombre());
    }
    ctrlCat = null;
  }

  protected void cmdConsultaCategoriaActionPerformed(String categoriaNombre) {
    try{
      videos.removeAllElements();
      listas.removeAllElements();
      if (categoriaNombre != null) {
        
        if (!categoriaNombre.equals("")) {
          
          DtCategoria categoria = null;
          for(DtCategoria dtCat : categorias){
            if(dtCat.getNombre().equals(categoriaNombre))
              categoria = dtCat;
          }
          
          ctrlCat = Fabrica.getICategorias();
  
          List<DtVideo> videosCategoria = categoria.getVideos();
          
          for (DtVideo video : videosCategoria) {
            videos.addElement(video.getNombre());
          }
  
          List<DtLista> listasCategoria = categoria.getListas();
          
          for (DtLista lista : listasCategoria) {
            listas.addElement(lista.getNombre());
          }
        }
      }
    }
    catch(Exception e){}
  }

}
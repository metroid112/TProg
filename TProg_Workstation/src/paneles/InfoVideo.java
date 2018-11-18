package paneles;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import datatypes.DtCalificacion;
import datatypes.DtComentario;
import datatypes.DtVideo;
import interfaces.IVideos;

@SuppressWarnings("serial")
public class InfoVideo extends JPanel {
  private JLabel lblVnombre;
  private JLabel lblVduracion;
  private JLabel lblVfecha;
  private JLabel lblVvisibilidad;
  private JLabel lblVcategoria;
  private JLabel lblVurl;
  private JTextArea textVdescripcion;
  private JTree tree;
  private JScrollPane scrollPane2;
  private JList<String> listaValoraciones;


  public InfoVideo(IVideos contVideo) {

    JLabel lblNombre = new JLabel("Nombre:");

    JLabel lblDuracion = new JLabel("Duracion:");

    JLabel lblVisibilidad = new JLabel("Visibilidad:");

    JLabel lblFecha = new JLabel("Fecha:");

    JLabel lblCategoria = new JLabel("Categoria:");

    JLabel lblUrl = new JLabel("URL:");

    JScrollPane scrollPane = new JScrollPane();

    lblVnombre = new JLabel("vNombre");

    textVdescripcion = new JTextArea("vDescripcion");
    textVdescripcion.setRows(6);
    textVdescripcion.setWrapStyleWord(true);
    textVdescripcion.setLineWrap(true);
    textVdescripcion.setEditable(false);

    scrollPane2 = new JScrollPane(textVdescripcion);

    lblVduracion = new JLabel("vDuracion");

    lblVfecha = new JLabel("vFecha");

    lblVvisibilidad = new JLabel("vVisibilidad");

    lblVcategoria = new JLabel("vCategoria");

    lblVurl = new JLabel("vURL");

    JScrollPane scrollPane1 = new JScrollPane();

    GroupLayout groupLayout = new GroupLayout(this);
    groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup().addGap(17).addGroup(groupLayout
            .createParallelGroup(Alignment.LEADING)
            .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
            .addGroup(groupLayout.createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblNombre)
                    .addComponent(lblDuracion).addComponent(lblVisibilidad).addComponent(lblFecha)
                    .addComponent(lblCategoria).addComponent(lblUrl))
                .addGap(26)
                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblVurl)
                    .addComponent(lblVcategoria).addComponent(lblVfecha)
                    .addComponent(lblVvisibilidad).addComponent(lblVduracion)
                    .addComponent(lblVnombre))))
            .addGap(18)
            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 239,
                    GroupLayout.PREFERRED_SIZE))
            .addContainerGap()));
    groupLayout
        .setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup().addGap(39)
                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 155,
                        GroupLayout.PREFERRED_SIZE)
                    .addGroup(groupLayout.createSequentialGroup()
                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                            .addComponent(lblNombre).addComponent(lblVnombre))
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                            .addComponent(lblDuracion).addComponent(lblVduracion))
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                            .addComponent(lblVisibilidad).addComponent(lblVvisibilidad))
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                            .addComponent(lblFecha).addComponent(lblVfecha))
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                            .addComponent(lblCategoria).addComponent(lblVcategoria))
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                            .addComponent(lblUrl).addComponent(lblVurl))))
                .addGap(28)
                .addGroup(groupLayout
                    .createParallelGroup(Alignment.LEADING, false).addComponent(scrollPane2)
                    .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                .addGap(29)));

    JLabel lblValoraciones = new JLabel("Valoraciones");
    scrollPane1.setColumnHeaderView(lblValoraciones);

    listaValoraciones = new JList<String>();
    scrollPane1.setViewportView(listaValoraciones);

    JLabel lblDecripcion = new JLabel("Descripcion");
    scrollPane2.setColumnHeaderView(lblDecripcion);

    tree = new JTree();

    scrollPane.setViewportView(tree);

    JLabel lblComentarios = new JLabel("Comentarios");
    scrollPane.setColumnHeaderView(lblComentarios);
    setLayout(groupLayout);

  }

  public void cargarDatos(DtVideo dtVid) {
    lblVnombre.setText(dtVid.nombre);
    textVdescripcion.setText(dtVid.descripcion);
    lblVurl.setText(dtVid.getUrlVideo());
    if (dtVid.visible) {
      lblVvisibilidad.setText("Publico");
    } else {
      lblVvisibilidad.setText("Privado");
    }
    lblVcategoria.setText(dtVid.categoria);
    Duration duracion = dtVid.duracion;
    int horas = (int) duracion.toHours();
    duracion = duracion.minusHours(horas);
    int min = (int) duracion.toMinutes();
    duracion = duracion.minusMinutes(min);
    int seg = (int) duracion.getSeconds();
    lblVduracion.setText(String.format("%d:%02d:%02d", horas, min, seg));
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    lblVfecha.setText(dateFormat.format(dtVid.fecha));

    DefaultListModel<String> modeloLista = new DefaultListModel<String>();
    if (!dtVid.calificaciones.isEmpty()) {
      for (DtCalificacion cal : dtVid.calificaciones) {
        modeloLista.addElement(cal.usuario + " - " + cal.getLikeParsed());
      }
    } else {
      modeloLista.addElement("Sin calificaciones");
    }
    listaValoraciones.setModel(modeloLista);

    DefaultMutableTreeNode raiz = loadComentarios(dtVid.comentarios, dtVid.nombre);
    DefaultTreeModel model = new DefaultTreeModel(raiz);
    tree.setModel(model);

  }

  public DefaultMutableTreeNode loadComentarios(List<DtComentario> coments,
      String nombreVideo) {
    DefaultMutableTreeNode nodo;
    DefaultMutableTreeNode raiz;
    raiz = new DefaultMutableTreeNode(nombreVideo);
    for (DtComentario com : coments) {
      nodo = getNode(com);
      raiz.add(nodo);
    }
    return raiz;
  }

  public DefaultMutableTreeNode getNode(DtComentario comentario) {
    DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(comentario.getString());
    for (DtComentario hijo : comentario.hijos) {
      DefaultMutableTreeNode nodoHijo = getNode(hijo); // Recursion
      nodo.add(nodoHijo);
    }
    return nodo;

  }
}

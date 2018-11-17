package internalframes;

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
import javax.swing.JScrollPane;

import datatypes.DtCategoria;
import interfaces.Fabrica;
import interfaces.ICategorias;

@SuppressWarnings("serial")
public class ListarCategorias extends JInternalFrame {

  private ICategorias ctrlCat;
  private DefaultListModel<String> model = new DefaultListModel<>();

  public ListarCategorias() {

    setTitle("Lista de Categorias");
    setBounds(0, 0, 640, 480);

    JScrollPane scrollPane = new JScrollPane();

    // DefaultListModel<String> model = new DefaultListModel<>();
    JList<String> list = new JList<>(model);
    list.setEnabled(false);
    scrollPane.setViewportView(list);
    list.setVisibleRowCount(4);

    JButton btnCerrar = new JButton("Cerrar");
    btnCerrar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        setVisible(false);
        model.removeAllElements();
      }
    });

    JLabel lblCategoriasRegistradas = new JLabel("Categorias registradas:");

    GroupLayout groupLayout = new GroupLayout(getContentPane());
    groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup().addGap(275).addComponent(btnCerrar)
            .addContainerGap(286, Short.MAX_VALUE))
        .addGroup(groupLayout.createSequentialGroup().addGap(119)
            .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE).addGap(117))
        .addGroup(Alignment.TRAILING,
            groupLayout.createSequentialGroup().addContainerGap(239, Short.MAX_VALUE)
                .addComponent(lblCategoriasRegistradas, GroupLayout.PREFERRED_SIZE, 154,
                    GroupLayout.PREFERRED_SIZE)
                .addGap(231)));
    groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup().addGap(61)
            .addComponent(lblCategoriasRegistradas).addGap(18)
            .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
            .addGap(18).addComponent(btnCerrar).addContainerGap(72, Short.MAX_VALUE)));

    getContentPane().setLayout(groupLayout);
  }

  public void cargarDatos() {

    ctrlCat = Fabrica.getICategorias();

    List<DtCategoria> cats = ctrlCat.listarCategorias();

    for (DtCategoria categoria : cats) {
      model.addElement(categoria.getNombre());
    }
    ctrlCat = null;
  }
}

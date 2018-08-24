package internalFrames;
import java.awt.EventQueue;
import javax.swing.DefaultListModel;
import javax.swing.UIManager;
import java.util.*;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import interfaces.Fabrica;
import interfaces.ICategorias;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class ListarCategorias extends JInternalFrame {

	private ICategorias ctrlCat;
	private Fabrica fab;
	private DefaultListModel<String> model = new DefaultListModel<>();
	private JList<String> list;
	public ListarCategorias() {
		
		setTitle("Lista de Categorias");
		setBounds(0, 0, 640, 480);
		
		JScrollPane scrollPane = new JScrollPane();
		
		

		
		//DefaultListModel<String> model = new DefaultListModel<>();
		JList<String> list = new JList<>(model);
		list.setEnabled(false);
		scrollPane.setViewportView(list);
		list.setVisibleRowCount(4);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				model.removeAllElements();
			}
		});
		
		JLabel lblCategoriasRegistradas = new JLabel("Categorias registradas:");
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(119)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblCategoriasRegistradas, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
						.addComponent(btnCerrar, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
					.addGap(117))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(61)
					.addComponent(lblCategoriasRegistradas)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCerrar)
					.addContainerGap(72, Short.MAX_VALUE))
		);

		getContentPane().setLayout(groupLayout);
	}
	
	public void cargarDatos(){
		
		fab = Fabrica.getFabrica();
		ctrlCat = fab.getICategorias();
		
	    String[] cats = ctrlCat.listarCategorias();
		int largo = cats.length;
		for (int i = 0; i < largo; i++ ){
		  model.addElement(cats[i]);
		}
		ctrlCat = null;
	}
}

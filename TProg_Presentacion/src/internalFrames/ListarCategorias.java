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
	private DefaultListModel<String> model;
	private JList<String> list;
	public ListarCategorias() {
		
		setTitle("Lista de Categorias");
		setBounds(0, 0, 640, 480);
		
		JScrollPane scrollPane = new JScrollPane();
		
		

		
		DefaultListModel<String> model = new DefaultListModel<>();
		JList<String> list = new JList<>(model);
		list.setEnabled(false);
		scrollPane.setViewportView(list);
		list.setVisibleRowCount(4);
//		list.setModel(new AbstractListModel() {
//			String[] values = new String[] {"PRUEBA 1", "PRUEBA 2", "PRUEBA 3", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"};
//			public int getSize() {
//				return values.length;
//			}
//			public Object getElementAt(int index) {
//				return values[index];
//			}
//		});
		
		
		JButton btnClickAquiPara = new JButton("Click aqui para listar las categorias");
		btnClickAquiPara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cmdListarCategoriaActionPerformed(arg0);
				btnClickAquiPara.setEnabled(false);
			}
		});
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				btnClickAquiPara.setEnabled(true);
				model.removeAllElements();
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(119)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCerrar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
						.addComponent(btnClickAquiPara, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
					.addGap(117))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addComponent(btnClickAquiPara)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCerrar)
					.addContainerGap(72, Short.MAX_VALUE))
		);

		getContentPane().setLayout(groupLayout);
	}
	
	protected void cmdListarCategoriaActionPerformed(ActionEvent arg0){
		
		fab = Fabrica.getFabrica();
		ctrlCat = fab.getICategorias();
		Set<String> cts = ctrlCat.listarCategorias();
		int largo = cts.size();
		String[] cats = cts.toArray (new String[cts.size()]);
		for (int i = 0; i < largo; i++ ){
		  model.addElement(cats[i]);
		}
	}
}

package internalFrames;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class ListarCategorias extends JInternalFrame {

	public ListarCategorias() {
		setTitle("Lista de Categorias");
		setBounds(0, 0, 640, 480);
		
		JLabel lblCategoriasRegistradas = new JLabel("Categorias registradas:");
		lblCategoriasRegistradas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(119)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
						.addComponent(btnCerrar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
						.addComponent(lblCategoriasRegistradas, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
					.addGap(117))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addComponent(lblCategoriasRegistradas)
					.addGap(27)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
					.addComponent(btnCerrar)
					.addGap(31))
		);
		
		JList<Object> list = new JList<Object>();
		list.setEnabled(false);
		scrollPane.setViewportView(list);
		list.setVisibleRowCount(4);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"PRUEBA 1", "PRUEBA 2", "PRUEBA 3", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		getContentPane().setLayout(groupLayout);

	}
}

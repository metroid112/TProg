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
		
		JList<Object> list = new JList<Object>();
		list.setModel(new AbstractListModel<Object>() {
			String[] values = new String[] {"PRUEBA 1", "PRUEBA 2", "PRUEBA 3"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(119)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(list, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
						.addComponent(btnCerrar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
						.addComponent(lblCategoriasRegistradas, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
					.addGap(117))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addComponent(lblCategoriasRegistradas)
					.addGap(32)
					.addComponent(list)
					.addGap(250)
					.addComponent(btnCerrar)
					.addContainerGap(79, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}

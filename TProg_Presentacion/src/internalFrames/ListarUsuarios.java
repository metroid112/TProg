package internalFrames;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JList;
import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

import interfaces.Fabrica;
import interfaces.IUsuarios;

import javax.swing.JScrollPane;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class ListarUsuarios extends JInternalFrame {
	private IUsuarios ctrlUsu;
	private Fabrica fab;
	/**
	 * Launch the application.
	 */

	SelectorUsuarios selector = new SelectorUsuarios();
	/**
	 * Create the frame.
	 */

	public ListarUsuarios() {
		setTitle("Listar Usuarios");
		setBounds(100, 100, 451, 490);
		//JList<String> list =  new JList<>(model);
		//SelectorUsuarios selector = new SelectorUsuarios();
		
		JButton btnNewButton = new JButton("Cerrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				//model.removeAllElements();
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(selector, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(353, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(selector, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
	
	public void cargarDatos(){
		selector.cargarDatos();
	}
	/*	fab = Fabrica.getFabrica();
		ctrlUsu = fab.getIUsuariosCanales();
		
	    String[] usua = ctrlUsu.listarUsuarios();
		int largo = usua.length;
		for (int i = 0; i < largo; i++ ){
		  model.addElement(usua[i]);
		}
		ctrlUsu = null;
	}*/
}

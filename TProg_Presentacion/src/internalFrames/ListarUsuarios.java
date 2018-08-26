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
import interfaces.IUsuariosCanales;

import javax.swing.JScrollPane;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class ListarUsuarios extends JInternalFrame {
	private IUsuariosCanales ctrlUsu;
	private Fabrica fab;
	/**
	 * Launch the application.
	 */
	private DefaultListModel<String> model = new DefaultListModel<>();

	/**
	 * Create the frame.
	 */

	public ListarUsuarios() {
		setTitle("Listar Usuarios");
		setBounds(100, 100, 430, 445);
		JList<String> list =  new JList<>(model);
		
		JLabel lblUsuariosExistentes = new JLabel("Usuarios existentes");
		lblUsuariosExistentes.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		cargarDatos();
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				model.removeAllElements();
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(140)
							.addComponent(lblUsuariosExistentes, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(87)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(89, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(305, Short.MAX_VALUE)
					.addComponent(btnCerrar)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(17)
					.addComponent(lblUsuariosExistentes, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
					.addComponent(btnCerrar)
					.addContainerGap())
		);
		
		scrollPane.setViewportView(list);
		getContentPane().setLayout(groupLayout);

	}
	public void cargarDatos(){
		
		fab = Fabrica.getFabrica();
		ctrlUsu = fab.getIUsuariosCanales();
		
	    String[] usua = ctrlUsu.listarUsuarios();
		int largo = usua.length;
		for (int i = 0; i < largo; i++ ){
		  model.addElement(usua[i]);
		}
		ctrlUsu = null;
	}
}

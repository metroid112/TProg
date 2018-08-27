package internalFrames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import controladores.CtrlVideos;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaVideo extends JInternalFrame implements ActionListener {
	private JComboBox<String> cBoxUsuarios;
	private JList<String> list;
	private CtrlVideos contVideos;

	/**
	 * Create the frame.
	 */
	public ConsultaVideo(CtrlVideos contVideos) {
		
		this.contVideos = contVideos;
		
		setTitle("Consulta de Video");
		setBounds(100, 100, 450, 300);
		
		cBoxUsuarios = new JComboBox<String>();
		cBoxUsuarios.addActionListener(this);		// Agrego el listener para leer el usuario seleccionado
		
		JLabel lblUsuario = new JLabel("Usuario:");
		
		JButton btnVerInfo = new JButton("Ver Info");
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnVerInfo)
							.addGap(18)
							.addComponent(btnCancelar))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(56)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblUsuario)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cBoxUsuarios, 0, 276, Short.MAX_VALUE)))))
					.addGap(54))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsuario)
						.addComponent(cBoxUsuarios, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnVerInfo))
					.addGap(36))
		);
		
		list = new JList<String>();
		scrollPane.setViewportView(list);
		
		JLabel lblVideos = new JLabel("Videos");
		scrollPane.setColumnHeaderView(lblVideos);
		getContentPane().setLayout(groupLayout);

	}
	
	public void cargarDatos() {
		String[] usuarios = contVideos.listarUsuarios();
		DefaultComboBoxModel<String> modelU = new DefaultComboBoxModel<String>(usuarios);
		cBoxUsuarios.setModel(modelU);
	}
	
	public void updateLista(String nickname) {
		DefaultListModel<String> model = new DefaultListModel<String>();
		String[] videos = contVideos.listarVideos(nickname);
		for (String vid : videos) {
			model.addElement(vid);
		}
		list.setModel(model);
	}

	public void actionPerformed(ActionEvent e) {		// El metodo salta cuando hay un elemento seleccionado en el combo box
		updateLista((String)cBoxUsuarios.getSelectedItem());		// Llamo updateLista y le paso el nickname seleccionado
		
	}
		
}

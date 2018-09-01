package paneles;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

import interfaces.IVideos;

import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class SeleccionVideo extends JPanel implements ActionListener {
	private JComboBox<String> cBoxUsuarios;
	private IVideos contVideos;
	private JList<String> listaVideos;
	
	/**
	 * Create the panel.
	 */
	public SeleccionVideo(IVideos contVideos) {
		
		this.contVideos = contVideos;
		
		JLabel lblUsuario = new JLabel("Usuario:");
		
		cBoxUsuarios = new JComboBox<String>();
		cBoxUsuarios.addActionListener(this);		// Agrego el listener para leer el usuario seleccionado
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(62)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblUsuario)
							.addGap(18)
							.addComponent(cBoxUsuarios, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cBoxUsuarios, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsuario))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(77, Short.MAX_VALUE))
		);
		
		listaVideos = new JList<String>();
		listaVideos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listaVideos);
		
		JLabel lblVideos = new JLabel("Videos:");
		scrollPane.setColumnHeaderView(lblVideos);
		setLayout(groupLayout);

	}
	
	public String getVideo() {
		return listaVideos.getSelectedValue();
	}
	
	public void cargarDatos() {
		String[] usuarios = contVideos.listarUsuarios();
		DefaultComboBoxModel<String> modelU = new DefaultComboBoxModel<String>(usuarios);
		cBoxUsuarios.setModel(modelU);
		updateLista((String) cBoxUsuarios.getSelectedItem());
	}
	
	public void updateLista(String nickname) {
		DefaultListModel<String> model = new DefaultListModel<String>();
		String[] videos = contVideos.listarVideos(nickname);
		if (videos != null) {
			for (String vid : videos) {
				model.addElement(vid);
			}
		}
		listaVideos.setModel(model);
	}

	public void actionPerformed(ActionEvent e) {		// El metodo salta cuando hay un elemento seleccionado en el combo box
		updateLista((String)cBoxUsuarios.getSelectedItem());		// Llamo updateLista y le paso el nickname seleccionado
		
	}

	public String getUsuario() {
		return (String) cBoxUsuarios.getSelectedItem();
	}

}

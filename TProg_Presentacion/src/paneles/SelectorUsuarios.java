package paneles;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;

import interfaces.Fabrica;
import interfaces.IUsuariosCanales;


@SuppressWarnings("serial")
public class SelectorUsuarios extends JPanel {
	private IUsuariosCanales ctrlUsu;
	/**
	 * Launch the application.
	 */
	private DefaultListModel<String> model = new DefaultListModel<>();
	private JList<String> list =  new JList<>(model);

	/**
	 * Create the panel.
	 */
	public SelectorUsuarios() {
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblUsuariosExistentes = new JLabel("Usuarios existentes:");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUsuariosExistentes)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
					.addGap(36))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(7)
					.addComponent(lblUsuariosExistentes)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
					.addGap(21))
		);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.setViewportView(list);
		cargarDatos();
		setLayout(groupLayout);
		

	}
	public void cargarDatos(){
		model.removeAllElements();
		ctrlUsu = Fabrica.getIUsuariosCanales();
	
		String[] usua = ctrlUsu.listarUsuarios();
		int largo = usua.length;
		for (int i = 0; i < largo; i++ ){
			model.addElement(usua[i]);
		}
			ctrlUsu = null;
		}
	public String getSelectedItem() {
		return list.getSelectedValue();
		//return model.
	}
}

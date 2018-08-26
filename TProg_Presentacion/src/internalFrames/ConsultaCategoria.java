package internalFrames;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import interfaces.Fabrica;
import interfaces.ICategorias;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;

public class ConsultaCategoria extends JInternalFrame {

	private ICategorias ctrlCat;
	private Fabrica fab;
	private DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
	
	public ConsultaCategoria() {
		setTitle("Consulta de Categorias");
		setBounds(0, 0, 640, 480);
		
		JButton btnNewButton = new JButton("Cerrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				model.removeAllElements();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblVideos = new JLabel("Videos:");
		
		JLabel lblListasDeReproduccion = new JLabel("Listas de reproduccion:");
		
		JComboBox comboBox = new JComboBox<>(model);
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"","Deportes", "Gatos"}));

		
		
		JLabel lblSeleccioneUnaCategoria = new JLabel("Seleccione una categoria:");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblSeleccioneUnaCategoria, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(comboBox, 0, 174, Short.MAX_VALUE))
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblListasDeReproduccion)
						.addComponent(lblVideos)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(107))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVideos)
						.addComponent(lblSeleccioneUnaCategoria))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblListasDeReproduccion)
							.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addGap(48)
							.addComponent(btnNewButton)
							.addGap(33))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		scrollPane_1.setViewportView(textArea_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		getContentPane().setLayout(groupLayout);

	}
	
	public void cargarDatos(){
		
		fab = Fabrica.getFabrica();
		ctrlCat = fab.getICategorias();
		
	    String[] cats = ctrlCat.listarCategorias();
		int largo = cats.length;
		model.addElement("");
		for (int i = 0; i < largo; i++ ){
		  model.addElement(cats[i]);
		}
		ctrlCat = null;
	}
}

package internalFrames;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;

import interfaces.*;

import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;

@SuppressWarnings("serial")
public class ConsultaLista extends JInternalFrame{

	private IUsuariosCanales ctrUsu;
	private IListas ctrLis;
	
	private Fabrica fab;
	private DefaultComboBoxModel<String> modelUsuario = new DefaultComboBoxModel<String>();
	private DefaultComboBoxModel<String> modelListas = new DefaultComboBoxModel<String>();
	private DefaultListModel<String> listListas = new DefaultListModel<>();

	public ConsultaLista() {
		
		setTitle("Conultar lista");
		setBounds(0, 0, 640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario");
		
		JComboBox comboBoxUsuario = new JComboBox(modelUsuario);
		
		JLabel lblLista = new JLabel("Lista");
		
		JComboBox comboBoxListas = new JComboBox(modelListas);
		comboBoxListas.setEnabled(false);
		
		JButton btnCerrar = new JButton("Cerrar");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnConsultar = new JButton("Consultar");
		
		JScrollPane scrollPane_1 = new JScrollPane();

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLista)
								.addComponent(comboBoxListas, 0, 146, Short.MAX_VALUE)
								.addComponent(comboBoxUsuario, 0, 146, Short.MAX_VALUE)
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnConsultar)
							.addGap(18)
							.addComponent(btnCerrar)
							.addGap(100))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNombreDeUsuario)
							.addContainerGap(524, Short.MAX_VALUE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNombreDeUsuario)
							.addGap(13)
							.addComponent(comboBoxUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBoxListas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblLista)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCerrar)
						.addComponent(btnConsultar))
					.addGap(5))
		);
		
		JList list = new JList(listListas);
		scrollPane_1.setViewportView(list);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		getContentPane().setLayout(groupLayout);
		
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				modelListas.removeAllElements();
				modelUsuario.removeAllElements();
				listListas.removeAllElements();
				textArea.setText(null);
				
			}
		});
		
		comboBoxUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxUsuario.getSelectedItem() != ""){
					
					listListas.removeAllElements();

					comboBoxListas.setEnabled(true);
					/*if(comboBoxListas.getSelectedItem().toString() == "Por defecto"){
						cargarDefectoListas();
					}
					if(comboBoxListas.getSelectedItem().toString() == "Particular"){
						cargarParticularListas();
					}*/
				}
				else{ 

					comboBoxListas.setEnabled(false);
				}
			}
		});
		

		
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(null);
				if(checkUsuario() && checkLista()){
					
				}
			}
		});

	}
	
	public void cargarDatos(){
		
		fab = Fabrica.getFabrica();
		ctrUsu = fab.getIUsuariosCanales();
		
	    String[] usuarios = ctrUsu.listarUsuarios();
		int largou = usuarios.length;
		
		modelUsuario.addElement("");
		for (int i = 0; i < largou; i++ ){
		  modelUsuario.addElement(usuarios[i]);
		}
		ctrUsu = null;
		
		modelListas.addElement("Por defecto");
		modelListas.addElement("Particular");
	}
	
	
	public void cargarDefectoListas(){
		fab = Fabrica.getFabrica();
		ctrLis = fab.getIListas();
		
		if(modelUsuario.getSelectedItem() != null){
			
			String s = modelUsuario.getSelectedItem().toString();
			
		    String[] listas = ctrLis.listarListasDefectoUsuario(s);
		    
			int largol = listas.length;
			
			for (int i = 0; i < largol; i++ ){
			  listListas.addElement(listas[i]);
			}
		}
			
		ctrLis = null;
	}
	
	public void cargarParticularListas(){
		fab = Fabrica.getFabrica();
		ctrLis = fab.getIListas();
		
		if(modelUsuario.getSelectedItem() != null){
			
			String s = modelUsuario.getSelectedItem().toString();
			
		    String[] listas = ctrLis.listarListasParticularUsuario(s);
		    
			int largol = listas.length;
			
			modelListas.addElement("");
			for (int i = 0; i < largol; i++ ){
			  listListas.addElement(listas[i]);
			}
		}
			
		ctrLis = null;
	}
	
	boolean checkUsuario(){

		if(modelUsuario.getSelectedItem() == ""){
			JOptionPane.showMessageDialog(null, "No has seleccionado ningún usuario", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	boolean checkLista(){ //HAY QUE CAMBIAR DE IMPLEMT

		if(modelListas.getSelectedItem() == ""){
			JOptionPane.showMessageDialog(null, "No has seleccionado ninguna lista", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
}

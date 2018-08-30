package internalFrames;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.DefaultComboBoxModel;
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
		
		JList list = new JList();

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
								.addComponent(list, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
								.addComponent(comboBoxListas, 0, 129, Short.MAX_VALUE)
								.addComponent(comboBoxUsuario, 0, 146, Short.MAX_VALUE))
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
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnCerrar)
								.addComponent(btnConsultar))
							.addGap(5))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNombreDeUsuario)
							.addGap(13)
							.addComponent(comboBoxUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBoxListas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblLista)
							.addGap(18)
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		getContentPane().setLayout(groupLayout);
		
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				modelListas.removeAllElements();
				modelUsuario.removeAllElements();
				//text area vaciar
				
			}
		});
		
		comboBoxUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxUsuario.getSelectedItem() != ""){
					
					modelListas.removeAllElements();
					cargarListas();
					comboBoxListas.setEnabled(true);					
				}
				else{ 
					comboBoxListas.setEnabled(false);
				}
			}
		});
		

		
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(null);;
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
	}
	
	public void cargarListas(){
		fab = Fabrica.getFabrica();
		ctrLis = fab.getIListas();
		 
		if(modelUsuario.getSelectedItem() != null){
			
			String s = modelUsuario.getSelectedItem().toString();
			
		    String[] listas = ctrLis.listarListasUsuario(s);
		    
			int largol = listas.length;
			
			modelListas.addElement("");
			for (int i = 0; i < largol; i++ ){
			  modelListas.addElement(listas[i]);
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
	
	boolean checkLista(){

		if(modelListas.getSelectedItem() == ""){
			JOptionPane.showMessageDialog(null, "No has seleccionado ninguna lista", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
}

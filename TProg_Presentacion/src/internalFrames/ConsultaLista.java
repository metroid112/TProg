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

@SuppressWarnings("serial")
public class ConsultaLista extends JInternalFrame{

<<<<<<< HEAD
	private IUsuarios ctrUsu;
=======
	private IUsuariosCanales ctrUsu;
	private IListas ctrLis;
>>>>>>> master
	
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
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNombreDeUsuario)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBoxUsuario, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(lblLista)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(comboBoxListas, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnCerrar)
							.addGap(234))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLista)
						.addComponent(comboBoxUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombreDeUsuario)
						.addComponent(comboBoxListas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCerrar)
					.addGap(5))
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
	

}

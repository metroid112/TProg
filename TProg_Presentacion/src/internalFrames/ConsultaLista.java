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
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class ConsultaLista extends JInternalFrame{

	private IUsuariosCanales ctrUsu;
	private IListas ctrLis;
	
	private Fabrica fab;
	private DefaultComboBoxModel<String> modelUsuario = new DefaultComboBoxModel<String>();

	private DefaultListModel<String> listListas = new DefaultListModel<>();

	public ConsultaLista() {
		
		setTitle("Conultar lista");
		setBounds(0, 0, 640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario");
		
		JComboBox comboBoxUsuario = new JComboBox(modelUsuario);
		
		JButton btnCerrar = new JButton("Cerrar");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnConsultar = new JButton("Consultar");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JRadioButton rdbtnListasPorDefecto = new JRadioButton("Listas por defecto");
		rdbtnListasPorDefecto.setEnabled(false);
		rdbtnListasPorDefecto.setSelected(true);
		
		JRadioButton rdbtnListasParticulares = new JRadioButton("Listas particulares");
		rdbtnListasParticulares.setEnabled(false);

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBoxUsuario, 0, 146, Short.MAX_VALUE)
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnListasPorDefecto)
								.addComponent(rdbtnListasParticulares))
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
							.addComponent(rdbtnListasPorDefecto)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnListasParticulares)
							.addGap(11)
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCerrar)
						.addComponent(btnConsultar))
					.addGap(5))
		);
		
		JList list = new JList(listListas);
		list.setEnabled(false);
		scrollPane_1.setViewportView(list);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		getContentPane().setLayout(groupLayout);
		
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				modelUsuario.removeAllElements();
				listListas.removeAllElements();
				list.setEnabled(false);
				rdbtnListasPorDefecto.setSelected(true);
				rdbtnListasParticulares.setSelected(false);
				rdbtnListasPorDefecto.setEnabled(false);
				rdbtnListasParticulares.setEnabled(false);
				textArea.setText(null);
				
			}
		});
		
		rdbtnListasPorDefecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnListasParticulares.setSelected(false);
				listListas.removeAllElements();
				cargarDefectoListas();
			}
		});
		
		rdbtnListasParticulares.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnListasPorDefecto.setSelected(false);
				listListas.removeAllElements();
				cargarParticularListas();
			}
		});
		
		comboBoxUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxUsuario.getSelectedItem() != ""){
					
					listListas.removeAllElements();
					list.setEnabled(true);
					rdbtnListasParticulares.setEnabled(true);
					rdbtnListasPorDefecto.setEnabled(true);


					if(rdbtnListasPorDefecto.isSelected()){
						listListas.removeAllElements();
						cargarDefectoListas();
					}
					if(rdbtnListasParticulares.isSelected()){
						listListas.removeAllElements();
						cargarParticularListas();
					}
					
				}
				else{ 
					list.setEnabled(false);
					rdbtnListasPorDefecto.setSelected(true);
					rdbtnListasParticulares.setSelected(false);
					rdbtnListasPorDefecto.setEnabled(false);
					rdbtnListasParticulares.setEnabled(false);
					list.setEnabled(false);
				}
			}
		});
		

		
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(null);
				if(checkUsuario()){
					
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
	

}

package internalFrames;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import interfaces.*;

@SuppressWarnings("serial")
public class ModificarListaReproduccion extends JInternalFrame {

	private IUsuariosCanales ctrUsu;
	private IListas ctrLis;
	
	private Fabrica fab;
	private DefaultComboBoxModel<String> modelUsuario = new DefaultComboBoxModel<String>();
	private DefaultComboBoxModel<String> modelLisRep = new DefaultComboBoxModel<String>();
	private DefaultComboBoxModel<String> modelCategoria = new DefaultComboBoxModel<String>();
	
	public ModificarListaReproduccion() {

		setBounds(0, 0, 640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Modificar lista de reproducci\u00F3n");
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario");
		
		JLabel lblListaDeReproduccin = new JLabel("Lista de reproducci\u00F3n");
		
		JRadioButton rdbtnPrivada = new JRadioButton("Privada");
		rdbtnPrivada.setSelected(true);
		rdbtnPrivada.setEnabled(false);
		
		JRadioButton rdbtnPublica = new JRadioButton("P\u00FAblica");
		rdbtnPublica.setEnabled(false);
		
		JComboBox comboBoxUsuario = new JComboBox(modelUsuario);
		
		JComboBox comboBoxLisRep = new JComboBox(modelLisRep);
		comboBoxLisRep.setEnabled(false);
		
		JButton btnCancelar = new JButton("Cancelar");
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(rdbtnPrivada)
							.addGap(18)
							.addComponent(rdbtnPublica))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombreDeUsuario)
								.addComponent(lblListaDeReproduccin))
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(comboBoxLisRep, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(comboBoxUsuario, 0, 146, Short.MAX_VALUE))))
					.addContainerGap(324, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(458, Short.MAX_VALUE)
					.addComponent(btnGuardar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCancelar)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreDeUsuario)
						.addComponent(comboBoxUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblListaDeReproduccin)
						.addComponent(comboBoxLisRep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnPrivada)
						.addComponent(rdbtnPublica))
					.addPreferredGap(ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnGuardar))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		
		rdbtnPrivada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnPublica.setSelected(false);
				
			}
		});
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelUsuario.removeAllElements();
				modelLisRep.removeAllElements();
				modelCategoria.removeAllElements();
				setVisible(false);
			}
		});
		
		rdbtnPublica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnPrivada.setSelected(false);
				
			}
		});
		
		comboBoxUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxUsuario.getSelectedItem() != ""){
					
					modelLisRep.removeAllElements();
					cargarListas();
					comboBoxLisRep.setEnabled(true);
					rdbtnPrivada.setEnabled(true);
					rdbtnPublica.setEnabled(true);
				}
				else{
					
					comboBoxLisRep.setEnabled(false);
					rdbtnPrivada.setEnabled(false);
					rdbtnPublica.setEnabled(false);
				}
			}
		});
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(checkUsuario() && checkLista()){
					ctrLis.guardarCambios(modelLisRep.getSelectedItem().toString(),modelUsuario.getSelectedItem().toString(),rdbtnPublica.isSelected());
					setVisible(false);
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
			
		    String[] listas = ctrLis.listarListasParticularUsuario(s);
		    
			int largol = listas.length;
			
			modelLisRep.addElement("");
			for (int i = 0; i < largol; i++ ){
			  modelLisRep.addElement(listas[i]);
			}
		}
		ctrUsu = null;
	}
	
	public void clean(){
		
	}

	boolean checkUsuario(){

		if(modelUsuario.getSelectedItem() == ""){
			JOptionPane.showMessageDialog(null, "No has seleccionado ningún usuario", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	boolean checkLista(){

		if(modelLisRep.getSelectedItem() == ""){
			JOptionPane.showMessageDialog(null, "No has seleccionado ninguna lista", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

}

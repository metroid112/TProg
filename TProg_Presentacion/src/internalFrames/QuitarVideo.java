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
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import interfaces.*;

import javax.swing.JComboBox;
import javax.swing.JList;

@SuppressWarnings("serial")
public class QuitarVideo extends JInternalFrame{

	private IUsuariosCanales ctrUsu;
	
	private Fabrica fab;
	private DefaultComboBoxModel<String> modelUsuario = new DefaultComboBoxModel<String>();
	private DefaultComboBoxModel<String> modelLisUsu = new DefaultComboBoxModel<String>();
	private DefaultComboBoxModel<String> modelVideos = new DefaultComboBoxModel<String>();
	
	
	public QuitarVideo() {
		
		setTitle("Quitar video");
		setBounds(0, 0, 640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario");
		
		JLabel lblListasDelUsuario = new JLabel("Listas del usuario");
		
		JLabel lblVideos = new JLabel("Videos");
		
		JButton btnCancelar = new JButton("Cancelar");
		
		JButton btnAceptar = new JButton("Aceptar");
		
		JComboBox comboBoxUsuario = new JComboBox(modelUsuario);
		
		JComboBox comboBoxTipoListas = new JComboBox(modelLisUsu);
		comboBoxTipoListas.setEnabled(false);
		
		JComboBox comboBoxVideos = new JComboBox(modelVideos);
		comboBoxVideos.setEnabled(false);
		
		JList listListas = new JList();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(450, Short.MAX_VALUE)
							.addComponent(btnAceptar)
							.addGap(18)
							.addComponent(btnCancelar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombreDeUsuario)
								.addComponent(lblListasDelUsuario)
								.addComponent(lblVideos))
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(comboBoxUsuario, 0, 120, Short.MAX_VALUE)
								.addComponent(comboBoxTipoListas, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(listListas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(comboBoxVideos, Alignment.TRAILING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 358, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreDeUsuario)
						.addComponent(comboBoxUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblListasDelUsuario)
						.addComponent(comboBoxTipoListas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(listListas, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(comboBoxVideos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblVideos))
					.addPreferredGap(ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnAceptar))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelUsuario.removeAllElements();
				modelLisUsu.removeAllElements();
				modelVideos.removeAllElements();
				setVisible(false);
			}
		});
		
		comboBoxUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxUsuario.getSelectedItem() != ""){
					
					comboBoxTipoListas.setEnabled(true);
					modelLisUsu.addElement("Por defecto");
					modelLisUsu.addElement("Particular");
				}
				else comboBoxTipoListas.setEnabled(false);
			}
		});
		
		comboBoxTipoListas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxUsuario.getSelectedItem() != ""){
					
					comboBoxVideos.setEnabled(true);
				}
				else comboBoxVideos.setEnabled(false);
			}
		});
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean checkUsuario = true;
				

				if(comboBoxUsuario.getSelectedItem() == ""){
						JOptionPane.showMessageDialog(null, "No has seleccionado ningún usuario", "Error", JOptionPane.ERROR_MESSAGE);
						checkUsuario = false;
				}
				if(checkUsuario){

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

}

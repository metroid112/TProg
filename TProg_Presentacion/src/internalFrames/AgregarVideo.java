package internalFrames;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import interfaces.Fabrica;

import javax.swing.JComboBox;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class AgregarVideo extends JInternalFrame{
	
	private Fabrica fab;
	private DefaultComboBoxModel<String> modelUsuario = new DefaultComboBoxModel<String>();
	private DefaultComboBoxModel<String> modelVideos = new DefaultComboBoxModel<String>();
	private DefaultComboBoxModel<String> modelUsuObj = new DefaultComboBoxModel<String>();
	private DefaultComboBoxModel<String> modelListas = new DefaultComboBoxModel<String>();	

	public AgregarVideo() {
		
		setTitle("Agregar video a lista de reproducci\u00F3n");
		setBounds(0, 0, 640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario");
		
		JLabel lblVideos = new JLabel("Videos");
		
		JLabel lblUsuario = new JLabel("Usuario");
		
		JLabel lblListas = new JLabel("Listas");
		
		JComboBox comboBoxUsuario = new JComboBox(modelUsuario);
		
		JComboBox comboBoxVideos = new JComboBox(modelVideos);
		comboBoxVideos.setEnabled(false);
		
		JComboBox comboBoxUsuObj = new JComboBox(modelUsuObj);
		comboBoxUsuObj.setEnabled(false);
		
		JComboBox comboBoxListas = new JComboBox(modelListas);
		comboBoxListas.setEnabled(false);
		
		JButton btnCancelar = new JButton("Cancelar");
		
		JButton btnAceptar = new JButton("Aceptar");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNombreDeUsuario)
						.addComponent(lblVideos)
						.addComponent(lblUsuario)
						.addComponent(lblListas))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(comboBoxUsuario, 0, 129, Short.MAX_VALUE)
						.addComponent(comboBoxVideos, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(comboBoxUsuObj, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(comboBoxListas, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(166, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(242, Short.MAX_VALUE)
					.addComponent(btnAceptar)
					.addGap(18)
					.addComponent(btnCancelar)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreDeUsuario)
						.addComponent(comboBoxUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVideos)
						.addComponent(comboBoxVideos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsuario)
						.addComponent(comboBoxUsuObj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblListas)
						.addComponent(comboBoxListas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnAceptar))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelUsuario.removeAllElements();
				modelVideos.removeAllElements();
				modelUsuObj.removeAllElements();
				modelListas.removeAllElements();
				setVisible(false);
			}
		});
	}
	
	public void cargarDatos(){
		/*
		fab = Fabrica.getFabrica();
		ctrCat = fab.getICategorias();
		
	    String[] usuarios = ctrUsu.listarUsuarios();
		largo = usuarios.length;
		modelUsuario.addElement("");
		for (int i = 0; i < largo; i++ ){
		  modelUsuario.addElement(usuarios[i]);
		}
		ctrUsu = null;
		*/
	}

}

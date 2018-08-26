package internalFrames;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import interfaces.Fabrica;

@SuppressWarnings("serial")
public class ModificarListaReproduccion extends JInternalFrame {

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
		
		JLabel lblCategora = new JLabel("Categor\u00EDa");
		
		JRadioButton rdbtnPrivada = new JRadioButton("Privada");
		rdbtnPrivada.setSelected(true);
		rdbtnPrivada.setEnabled(false);
		
		JRadioButton rdbtnPublica = new JRadioButton("P\u00FAblica");
		rdbtnPublica.setEnabled(false);
		
		JComboBox comboBoxUsuario = new JComboBox(modelUsuario);
		
		JComboBox comboBoxLisRep = new JComboBox(modelLisRep);
		comboBoxLisRep.setEnabled(false);
		
		JComboBox comboBoxCategoria = new JComboBox(modelCategoria);
		comboBoxCategoria.setEnabled(false);
		
		JButton btnCancelar = new JButton("Cancelar");
		
		JButton btnGuardar = new JButton("Guardar");
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
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
								.addComponent(lblListaDeReproduccin)
								.addComponent(lblCategora))
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(comboBoxCategoria, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(comboBoxLisRep, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(comboBoxUsuario, 0, 146, Short.MAX_VALUE))))
					.addContainerGap(134, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(250, Short.MAX_VALUE)
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
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCategora)
						.addComponent(comboBoxCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnPrivada)
						.addComponent(rdbtnPublica))
					.addPreferredGap(ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
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
	}
	public void cargarDatos(){
		/*
		fab = Fabrica.getFabrica();
		ctrCat = fab.getIUsuariosCanales();
		
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

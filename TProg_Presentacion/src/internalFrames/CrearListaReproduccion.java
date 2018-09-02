package internalFrames;

import java.lang.Exception; //AL CERRAR Y ABRIR VENTANA NO SE REINICIAN LOS PARAMETROS

import interfaces.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class CrearListaReproduccion extends JInternalFrame {

	
	private JTextField textFieldNombre;
	private IUsuariosCanales ctrUsu;
	private IListas ctrLista;
	private ButtonGroup grupoTipo = new ButtonGroup();
	private ButtonGroup grupoVisibilidad = new ButtonGroup();
	private Fabrica fab;
	private DefaultComboBoxModel<String> modelUsuario = new DefaultComboBoxModel<String>();
	private DefaultComboBoxModel<String> modelCategoria = new DefaultComboBoxModel<String>();

	public CrearListaReproduccion() {
		
		setTitle("Crear lista de reproducci\u00F3n");
		setBounds(0, 0, 640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JLabel lblTipoDeLista = new JLabel("Tipo de lista");
		
		JRadioButton rdbtnPorDefecto = new JRadioButton("Por defecto",true);
	
		JRadioButton rdbtnParticular = new JRadioButton("Particular");
		grupoTipo.add(rdbtnPorDefecto);
		grupoTipo.add(rdbtnParticular);
	
		JLabel lblNombre = new JLabel("Nombre");
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario");
		lblNombreDeUsuario.setEnabled(false);
		
		
		JComboBox comboBoxUsuario = new JComboBox(modelUsuario);
		comboBoxUsuario.setEnabled(false);
		
		JRadioButton rdbtnPrivada = new JRadioButton("Privada",true);
		
		JRadioButton rdbtnPublica = new JRadioButton("Publica");
		rdbtnPrivada.setEnabled(false);
		rdbtnPublica.setEnabled(false);
		grupoVisibilidad.add(rdbtnPrivada);
		grupoVisibilidad.add(rdbtnPublica);
		
		JButton btnCancelar = new JButton("Cancelar");
		
		JButton btnCrear = new JButton("Crear");

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(431, Short.MAX_VALUE)
							.addComponent(btnCrear))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombreDeUsuario)
								.addComponent(lblNombre)
								.addComponent(lblTipoDeLista))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(rdbtnPorDefecto)
									.addGap(18)
									.addComponent(rdbtnParticular))
								.addComponent(textFieldNombre, 194, 194, 194)
								.addComponent(comboBoxUsuario, 0, 360, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(rdbtnPrivada)
									.addPreferredGap(ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
									.addComponent(rdbtnPublica)))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCancelar)
					.addGap(49))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipoDeLista)
						.addComponent(rdbtnPorDefecto)
						.addComponent(rdbtnParticular))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreDeUsuario)
						.addComponent(comboBoxUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnPublica)
						.addComponent(rdbtnPrivada))
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCrear)
						.addComponent(btnCancelar))
					.addContainerGap(203, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		rdbtnParticular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				lblNombreDeUsuario.setEnabled(true);
				comboBoxUsuario.setEnabled(true);				
				rdbtnPrivada.setEnabled(true);
				rdbtnPublica.setEnabled(true);
			}
		});
		
		rdbtnPorDefecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				lblNombreDeUsuario.setEnabled(false);
				comboBoxUsuario.setEnabled(false);
				rdbtnPrivada.setEnabled(false);
				rdbtnPublica.setEnabled(false);
			}
		});

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				clean();
				rdbtnPrivada.setEnabled(false);
				rdbtnPrivada.setSelected(true);
				rdbtnPublica.setEnabled(false);
				rdbtnPublica.setSelected(false);
				comboBoxUsuario.setEnabled(false);
				lblNombreDeUsuario.setEnabled(false);
				rdbtnPorDefecto.setSelected(true);
				rdbtnParticular.setSelected(false);
				
			}
		});
		
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				fab = fab.getFabrica();
				ctrLista = fab.getIListas();
				boolean checkUsuario = true;
				
				if(rdbtnParticular.isSelected()){
					if(comboBoxUsuario.getSelectedItem() == ""){
						JOptionPane.showMessageDialog(null, "No has seleccionado ningún usuario", "Error", JOptionPane.ERROR_MESSAGE);
						checkUsuario = false;
					}
				}					
				if(checkNombre() && checkUsuario){
					
					try{
						if(rdbtnPorDefecto.isSelected()){
							ctrLista.altaListaDefecto(textFieldNombre.getText());
						}						
						if(rdbtnParticular.isSelected()){
							boolean publica = rdbtnPublica.isSelected();
							if(isCanalPublico(modelUsuario.getSelectedItem().toString())){
								publica = false;
							}
							ctrLista.altaListaParticular(textFieldNombre.getText(), modelUsuario.getSelectedItem().toString(), publica); //Visibilidad publica = true
							
						}
		                JOptionPane.showMessageDialog(null, "La lista fue creada con exito", "Registrar Usuario", JOptionPane.INFORMATION_MESSAGE);
		                clean();
						rdbtnPrivada.setEnabled(false);
						rdbtnPrivada.setSelected(true);
						rdbtnPublica.setEnabled(false);
						rdbtnPublica.setSelected(false);
						comboBoxUsuario.setEnabled(false);
						lblNombreDeUsuario.setEnabled(false);
						rdbtnPorDefecto.setSelected(true);
						rdbtnParticular.setSelected(false);
		                setVisible(false);
					}
					catch(Exception x){
						JOptionPane.showMessageDialog(null, "Este usuario ya posee una lista con ese nombre", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
	}
	
	private boolean checkNombre(){
		
		if(textFieldNombre.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "El nombre de lista no puede ser vacío", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return true;
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

	public void  clean(){
		
		modelUsuario.removeAllElements();
		textFieldNombre.setText(null);
		
	}
	
	boolean isCanalPublico(String usuario){
		fab = Fabrica.getFabrica();
		ctrUsu = fab.getIUsuariosCanales();
		
		if(!ctrUsu.isCanalPublico(usuario)){
			JOptionPane.showMessageDialog(null, "La lista se creara como privada", "El canal es privado", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

}

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
	private ICategorias ctrCat;
	private Fabrica fab;
	
	private DefaultComboBoxModel<String> modelUsuario = new DefaultComboBoxModel<String>();
	private DefaultComboBoxModel<String> modelCategoria = new DefaultComboBoxModel<String>();

	public CrearListaReproduccion() {
		
		setTitle("Crear lista de reproducci\u00F3n");
		setBounds(0, 0, 640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JLabel lblTipoDeLista = new JLabel("Tipo de lista");
		
		JRadioButton rdbtnPorDefecto = new JRadioButton("Por defecto");
		rdbtnPorDefecto.setSelected(true);
	
		JRadioButton rdbtnParticular = new JRadioButton("Particular");
		
	
		JLabel lblNombre = new JLabel("Nombre");
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario");
		lblNombreDeUsuario.setEnabled(false);
		
		
		JComboBox comboBoxUsuario = new JComboBox(modelUsuario);
		comboBoxUsuario.setEnabled(false);
		
		JRadioButton rdbtnPrivada = new JRadioButton("Privada");
		rdbtnPrivada.setEnabled(false);
		rdbtnPrivada.setSelected(true);
		
		JRadioButton rdbtnPublica = new JRadioButton("Publica");
		rdbtnPublica.setEnabled(false);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setEnabled(false);
		
		JComboBox comboBoxCategoria = new JComboBox(modelCategoria);
		comboBoxCategoria.setEnabled(false);
		
		JButton btnCancelar = new JButton("Cancelar");
		
		JButton btnCrear = new JButton("Crear");

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(265, Short.MAX_VALUE)
							.addComponent(btnCrear))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombreDeUsuario)
								.addComponent(lblNombre)
								.addComponent(lblCategora)
								.addComponent(lblTipoDeLista))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(comboBoxCategoria, 0, 194, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(rdbtnPorDefecto)
									.addGap(18)
									.addComponent(rdbtnParticular))
								.addComponent(textFieldNombre, 194, 194, 194)
								.addComponent(comboBoxUsuario, 0, 194, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(rdbtnPrivada)
									.addPreferredGap(ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
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
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCategora)
						.addComponent(comboBoxCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCrear)
						.addComponent(btnCancelar))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		rdbtnParticular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnPorDefecto.setSelected(false);
				
				lblNombreDeUsuario.setEnabled(true);
				lblCategora.setEnabled(true);
				comboBoxUsuario.setEnabled(true);
				comboBoxCategoria.setEnabled(true);
				rdbtnPrivada.setEnabled(true);
				rdbtnPublica.setEnabled(true);
			}
		});
		
		rdbtnPorDefecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnParticular.setSelected(false);
				
				lblNombreDeUsuario.setEnabled(false);
				lblCategora.setEnabled(false);
				comboBoxUsuario.setEnabled(false);
				comboBoxCategoria.setEnabled(false);
				rdbtnPrivada.setEnabled(false);
				rdbtnPublica.setEnabled(false);
			}
		});
		
		rdbtnPrivada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnPublica.setSelected(false);
				
			}
		});
		
		rdbtnPublica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnPrivada.setSelected(false);
				
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				modelCategoria.removeAllElements();
				modelUsuario.removeAllElements();
				
			}
		});
		
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				fab = fab.getFabrica();
				ctrLista = fab.getIListas();
				if(checkNombre()){
					
					try{
						if(rdbtnPorDefecto.isSelected())
							ctrLista.ingresarListaDefecto(textFieldNombre.getText());
						
						if(rdbtnParticular.isSelected()){
							ctrLista.ingresarListaParticular(textFieldNombre.getText(), comboBoxUsuario.getName(), rdbtnPublica.isSelected()); //Visibilidad publica = true
						}
		                JOptionPane.showMessageDialog(null, "La lista fue creada con exito", "Registrar Usuario", JOptionPane.INFORMATION_MESSAGE);
					}
					catch(Exception x){
						JOptionPane.showMessageDialog(null, "Ya existe una lista con ese nombre.", "Error", JOptionPane.ERROR_MESSAGE);
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
		ctrCat = fab.getICategorias();
		
	    String[] cats = ctrCat.listarCategorias();
		int largo = cats.length;
		modelCategoria.addElement("");
		for (int i = 0; i < largo; i++ ){
		  modelCategoria.addElement(cats[i]);
		}
		ctrCat = null;
		/*
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

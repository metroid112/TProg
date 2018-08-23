package internalFrames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class AltaUsuario extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblCorreo;
	private JLabel lblFechaDeNacimiento;
	private JTextField textField_4;

	/**
	 * Launch the application.

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaUsuario frame = new AltaUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AltaUsuario() {
		setNormalBounds(new Rectangle(20, 0, 300, 400));
		setTitle("Alta Usuario");
		setBounds(0, 0, 463, 531);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		JButton btnAceptar = new JButton("Aceptar");
		
		JLabel lblIngreseLosDatos = new JLabel("Ingrese los datos del usuario");
		lblIngreseLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblNickname = new JLabel("Nickname:");
		lblNickname.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblCorreo = new JLabel("Correo:");
		lblCorreo.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JComboBox comboBox = new JComboBox();
		
		JComboBox comboBox_1 = new JComboBox();
		
		JComboBox comboBox_2 = new JComboBox();
		
		JLabel lblPrivacidad = new JLabel("Privacidad:");
		lblPrivacidad.setHorizontalAlignment(SwingConstants.TRAILING);
		
		//logica radio buttons
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Privado");
		rdbtnNewRadioButton.setSelected(true);
		
		JRadioButton rdbtnPblico = new JRadioButton("P\u00FAblico");
		rdbtnPblico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnNewRadioButton.setSelected(false);
				rdbtnPblico.setSelected(true);
			}
		});
		

		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnNewRadioButton.setSelected(true);
				rdbtnPblico.setSelected(false);
			}
		});
		
		JLabel lblCambiarCanalPor = new JLabel("Cambiar canal por defecto:");
		lblCambiarCanalPor.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JRadioButton rdbtnSi = new JRadioButton("Si");
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setSelected(true);
		
		JLabel lblNombreCanal = new JLabel("Nombre canal:");
		lblNombreCanal.setHorizontalAlignment(SwingConstants.TRAILING);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JTextPane textPane = new JTextPane();
		textPane.setEnabled(false);
		
		//logica editar textos por defecto
		
		rdbtnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnNo.setSelected(true);
				rdbtnSi.setSelected(false);
				textField_4.setEnabled(false);
				textPane.setEnabled(false);
			}
		});
		
		rdbtnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnNo.setSelected(false);
				rdbtnSi.setSelected(true);
				textField_4.setEnabled(true);
				textPane.setEnabled(true);
			}
		});
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmdAltaUsuarioActionPerformed(e);
			}
		});
		
		//fin lógica botones
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addComponent(lblIngreseLosDatos, GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnAceptar)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnNewButton))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblDescripcin, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNombreCanal, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblFechaDeNacimiento, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
									.addGap(30))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblCorreo, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblApellido, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNickname, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblCambiarCanalPor, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPrivacidad, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
									.addGap(12)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(rdbtnSi, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
										.addComponent(rdbtnNewRadioButton))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(rdbtnNo, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
										.addComponent(rdbtnPblico))
									.addPreferredGap(ComponentPlacement.RELATED)))))
					.addGap(102))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblIngreseLosDatos)
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNickname)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellido)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCorreo)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFechaDeNacimiento))
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnPblico)
						.addComponent(lblPrivacidad)
						.addComponent(rdbtnNewRadioButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnNo)
						.addComponent(rdbtnSi)
						.addComponent(lblCambiarCanalPor))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreCanal)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDescripcin)
							.addGap(138)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton)
								.addComponent(btnAceptar)))
						.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
					.addGap(78))
		);
		getContentPane().setLayout(groupLayout);

	}
	
	protected void cmdAltaUsuarioActionPerformed(ActionEvent e){
		if (!textField_3.getText().contains("@") || !textField_3.getText().contains(".com")){
			JOptionPane.showMessageDialog(this, "Correo electrónico inválido");
		}
		else if (textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("")){
			JOptionPane.showMessageDialog(this, "Los campos Nickname, Nombre y Apellido son obligatorios.");
		}
//		else if ((comboBox.getSelectedIndex() == -1) || (comboBox_1.getSelectedIndex() == -1) || (comboBox_2.getSelectedIndex() == -1)){
//			JOptionPane.showMessageDialog(this, "Fecha inválida.");
//		}
		else{
			//ctrlCategoria.AltaCategoria(textField.getText(),null,null,null);		
			JOptionPane.showMessageDialog(this, "¡Se ha creado el usuario con éxito!");
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
//			textPane.			
			
			setVisible(false);
		}
	}
}

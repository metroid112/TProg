import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class AgregarVideo extends JInternalFrame{


	public AgregarVideo() {
		
		setTitle("Agregar video a lista de reproducci\u00F3n");
		setBounds(0, 0, 640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario");
		
		JLabel lblVideos = new JLabel("Videos");
		
		JLabel lblUsuario = new JLabel("Usuario");
		
		JLabel lblListas = new JLabel("Listas");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEnabled(false);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEnabled(false);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setEnabled(false);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setEnabled(false);
		
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
						.addComponent(comboBox, 0, 129, Short.MAX_VALUE)
						.addComponent(comboBox_1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(comboBox_2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(comboBox_3, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVideos)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsuario)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblListas)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnAceptar))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
	}

}

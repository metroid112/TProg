import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class QuitarVideo extends JInternalFrame{

	public QuitarVideo() {
		
		setTitle("Quitar video");
		setBounds(0, 0, 640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario");
		
		JLabel lblListasDelUsuario = new JLabel("Listas del usuario");
		
		JLabel lblVideos = new JLabel("Videos");
		
		JButton btnCancelar = new JButton("Cancelar");
		
		JButton btnAceptar = new JButton("Aceptar");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEnabled(false);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEnabled(false);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setEnabled(false);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNombreDeUsuario)
						.addComponent(lblListasDelUsuario)
						.addComponent(lblVideos))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(comboBox, 0, 120, Short.MAX_VALUE)
						.addComponent(comboBox_1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(comboBox_2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(178, Short.MAX_VALUE))
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
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreDeUsuario)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblListasDelUsuario)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVideos)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
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

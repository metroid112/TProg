import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class ConsultaLista extends JInternalFrame{

	

	public ConsultaLista() {
		
		setTitle("Conultar lista");
		setBounds(0, 0, 640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEnabled(false);
		
		JLabel lblLista = new JLabel("Lista");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEnabled(false);
		
		JButton btnAceptar = new JButton("Aceptar");
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNombreDeUsuario)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblLista)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(330)
							.addComponent(btnAceptar)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLista)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombreDeUsuario)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAceptar))
		);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		getContentPane().setLayout(groupLayout);
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
	}

}

package internalFrames;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AltaCategoria extends JInternalFrame{
	private JTextField textField;
	
	public AltaCategoria() {
		
		setBounds(0, 0, 640, 480);
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ingrese el nombre de la categoria:");
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmdAltaCategcoriaActionPerformed(e);
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//puedoAbrirVentana = true;
				setVisible(false);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(163)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(btnAceptar)
									.addPreferredGap(ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
									.addComponent(btnCancelar))
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
							.addGap(151))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 255, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAceptar)
						.addComponent(btnCancelar))
					.addGap(82))
		);
		getContentPane().setLayout(groupLayout);
	}
	
	protected void cmdAltaCategcoriaActionPerformed(ActionEvent e){
		if (textField.getText().equals("")){
			JOptionPane.showMessageDialog(this, "La categoria no puede ser vacia.");
		}
		else{
			//ctrlCategoria.AltaCategoria(textField.getText(),null,null,null);		
			JOptionPane.showMessageDialog(this, "¡Se ha creado la categoria con exito!");
			textField.setText("");
			setVisible(false);
		}
	}
}

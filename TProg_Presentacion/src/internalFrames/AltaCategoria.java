package internalFrames;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import interfaces.Fabrica;
import interfaces.ICategorias;

@SuppressWarnings("serial")
public class AltaCategoria extends JInternalFrame{
	private JTextField textField;
	private ICategorias ctrlCat;
	public AltaCategoria() {
		setTitle("Alta de Categoria");
		
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
				textField.setText("");
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
		if (textField.getText().isEmpty())
			JOptionPane.showMessageDialog(this, "La categoria no puede ser vac�a");
		else
		{
			try
			{
				ctrlCat = Fabrica.getICategorias();
				String texto = textField.getText();
                ctrlCat.altaCategoria(texto);		
                // Muestro éxito de la operación
                JOptionPane.showMessageDialog(this, "La categoria se ha creado con exito");
                textField.setText("");
                setVisible(false);   
			   
            } catch (Exception m) {
                JOptionPane.showMessageDialog(this, m.getMessage());
            }
		}
	}
	

		
}

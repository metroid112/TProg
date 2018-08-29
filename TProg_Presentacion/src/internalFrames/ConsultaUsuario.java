package internalFrames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class ConsultaUsuario extends JInternalFrame {
	SelectorUsuarios panel = new SelectorUsuarios();
	//private JInternalFrame infoUsuario;
	
	public ConsultaUsuario(VerInformacionUsuario ventanaInfo) {
		/*groupLayout_1.setHorizontalGroup(
			groupLayout_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 450, Short.MAX_VALUE)
		);
		groupLayout_1.setVerticalGroup(
			groupLayout_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 409, Short.MAX_VALUE)
		);*/
		setTitle("Consultar Usuario");
		setBounds(100, 100, 466, 490);
		
		JButton btnNewButton = new JButton("Cerrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent clic) {
				String usuarioSeleccionado = panel.getSelectedItem();
				//JOptionPane.showMessageDialog(getFocusOwner(), "click", "Um suceso", getDefaultCloseOperation());
				if (usuarioSeleccionado != null) {
					//VerInformacionUsuario verInformacion = new VerInformacionUsuario(usuarioSeleccionado);
					ventanaInfo.CargarInformacionUsuario(usuarioSeleccionado);
					ventanaInfo.setVisible(true);
					JOptionPane.showMessageDialog(getFocusOwner(), "Entro", "Um suceso", getDefaultCloseOperation());
				}
				else {
					JOptionPane.showMessageDialog(getFocusOwner(), "Seleccione un usuario", "Error", getDefaultCloseOperation());
		    	}
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(254, Short.MAX_VALUE)
					.addComponent(btnSeleccionar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 398, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnSeleccionar))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);

	}
	public void cargarDatos(){
		panel.cargarDatos();
	}
}

package internalFrames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class VerInformacionUsuario extends JInternalFrame {

	public void SetVisible(boolean b) {
		setEnabled(b);
	}
	private ConsultaUsuario padre = null;
	public void SetPadre(ConsultaUsuario padre) {
		this.padre=padre;
	}
	public VerInformacionUsuario() {
		setBounds(0, 10, 787, 459);
		getContentPane().setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Cerrar");		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				padre.SetVisible(true);
				//getContentPane().removeAll();
			}
		});
		panel.add(btnNewButton);
	}
	
	public void CargarInformacionUsuario(String usuario) {
		DetallesUsuario panel = new DetallesUsuario(usuario);
		getContentPane().add(panel, BorderLayout.CENTER);
	}

}

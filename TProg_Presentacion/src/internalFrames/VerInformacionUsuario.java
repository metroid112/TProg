package internalFrames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class VerInformacionUsuario extends JInternalFrame {

	public VerInformacionUsuario() {
		setBounds(100, 100, 787, 459);
		getContentPane().setLayout(new BorderLayout(0, 0));
	}
	
	public void CargarInformacionUsuario(String usuario) {
		DetallesUsuario panel = new DetallesUsuario(usuario);
		getContentPane().add(panel, BorderLayout.CENTER);
	}

}

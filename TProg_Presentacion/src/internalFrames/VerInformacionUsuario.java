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

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public VerInformacionUsuario(String usuario) {
		setBounds(100, 100, 787, 459);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		DetallesUsuario panel = new DetallesUsuario(usuario);
		panel.setVisible(true);
		getContentPane().add(panel, BorderLayout.CENTER);
		JOptionPane.showMessageDialog(getFocusOwner(), "Everinfo", "Um suceso", getDefaultCloseOperation());
		setVisible(true);
	}

}

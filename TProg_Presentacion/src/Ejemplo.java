import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Ejemplo {

	private JFrame frmAltaUsuario;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo window = new Ejemplo();
					window.frmAltaUsuario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ejemplo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAltaUsuario = new JFrame();
		frmAltaUsuario.setTitle("example");
		frmAltaUsuario.setBounds(100, 100, 450, 300);
		frmAltaUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAltaUsuario.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("167px:grow"),
				ColumnSpec.decode("97px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("25px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		frmAltaUsuario.getContentPane().add(textField, "1, 4, 2, 1, fill, default");
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("  Aceptar  ");
		frmAltaUsuario.getContentPane().add(btnNewButton, "2, 16, center, top");
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		frmAltaUsuario.getContentPane().add(btnNewButton_1, "6, 16, center, default");
	}

}

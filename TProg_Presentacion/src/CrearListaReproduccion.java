import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class CrearListaReproduccion extends JInternalFrame {

	private JFrame frmCrearListaDe;

	
	private JTextField textFieldNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearListaReproduccion window = new CrearListaReproduccion();
					window.frmCrearListaDe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CrearListaReproduccion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmCrearListaDe = new JFrame();
		frmCrearListaDe.setTitle("Crear lista de reproducci\u00F3n");
		frmCrearListaDe.setBounds(100, 100, 474, 311);
		frmCrearListaDe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblTipoDeLista = new JLabel("Tipo de lista");
		
		JRadioButton rdbtnPorDefecto = new JRadioButton("Por defecto");
		rdbtnPorDefecto.setSelected(true);
	
		JRadioButton rdbtnParticular = new JRadioButton("Particular");
		
	
		JLabel lblNombre = new JLabel("Nombre");
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario");
		lblNombreDeUsuario.setEnabled(false);
		
		 
		JComboBox comboBoxUsuario = new JComboBox();
		comboBoxUsuario.setEnabled(false);
		
		JRadioButton rdbtnPrivada = new JRadioButton("Privada");
		rdbtnPrivada.setEnabled(false);
		rdbtnPrivada.setSelected(true);
		
		JRadioButton rdbtnPublica = new JRadioButton("Publica");
		rdbtnPublica.setEnabled(false);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setEnabled(false);
		
		JComboBox comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setEnabled(false);
		
		JButton btnCancelar = new JButton("Cancelar");
		
		JButton btnCrear = new JButton("Crear");

		GroupLayout groupLayout = new GroupLayout(frmCrearListaDe.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(265, Short.MAX_VALUE)
							.addComponent(btnCrear))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombreDeUsuario)
								.addComponent(lblNombre)
								.addComponent(lblCategora)
								.addComponent(lblTipoDeLista))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(comboBoxCategoria, 0, 194, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(rdbtnPorDefecto)
									.addGap(18)
									.addComponent(rdbtnParticular))
								.addComponent(textFieldNombre, 194, 194, 194)
								.addComponent(comboBoxUsuario, 0, 194, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(rdbtnPrivada)
									.addPreferredGap(ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
									.addComponent(rdbtnPublica)))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCancelar)
					.addGap(49))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipoDeLista)
						.addComponent(rdbtnPorDefecto)
						.addComponent(rdbtnParticular))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreDeUsuario)
						.addComponent(comboBoxUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnPublica)
						.addComponent(rdbtnPrivada))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCategora)
						.addComponent(comboBoxCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCrear)
						.addComponent(btnCancelar))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		frmCrearListaDe.getContentPane().setLayout(groupLayout);
		
		rdbtnParticular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnPorDefecto.setSelected(false);
				
				lblNombreDeUsuario.setEnabled(true);
				lblCategora.setEnabled(true);
				comboBoxUsuario.setEnabled(true);
				comboBoxCategoria.setEnabled(true);
				rdbtnPrivada.setEnabled(true);
				rdbtnPublica.setEnabled(true);
			}
		});
		
		rdbtnPorDefecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnParticular.setSelected(false);
				
				lblNombreDeUsuario.setEnabled(false);
				lblCategora.setEnabled(false);
				comboBoxUsuario.setEnabled(false);
				comboBoxCategoria.setEnabled(false);
				rdbtnPrivada.setEnabled(false);
				rdbtnPublica.setEnabled(false);
			}
		});
		
		rdbtnPrivada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnPublica.setSelected(false);
				
			}
		});
		
		rdbtnPublica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnPrivada.setSelected(false);
				
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmCrearListaDe.setVisible(false);
			}
		});
		
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if(textFieldNombre.getText() == null)
				//mostrar JDialog
				//if(existeUsuario(textFieldNombre.getText())
					
			}
		});
	}
}

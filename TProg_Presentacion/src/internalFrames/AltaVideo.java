package internalFrames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JButton;

public class AltaVideo extends JInternalFrame {
	private JTextField TextoNombre;
	private JTextField tFieldURL;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaVideo frame = new AltaVideo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AltaVideo() {
		setTitle("Alta de Video");
		setBounds(100, 100, 450, 330);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 30, 1, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 1;
		gbc_lblUsuario.gridy = 1;
		getContentPane().add(lblUsuario, gbc_lblUsuario);
		
		JComboBox cBoxUsuarios = new JComboBox();
		GridBagConstraints gbc_cBoxUsuarios = new GridBagConstraints();
		gbc_cBoxUsuarios.gridwidth = 7;
		gbc_cBoxUsuarios.insets = new Insets(0, 0, 5, 0);
		gbc_cBoxUsuarios.fill = GridBagConstraints.HORIZONTAL;
		gbc_cBoxUsuarios.gridx = 3;
		gbc_cBoxUsuarios.gridy = 1;
		getContentPane().add(cBoxUsuarios, gbc_cBoxUsuarios);
		
		JLabel lblNombreDelVideo = new JLabel("Nombre del Video:");
		GridBagConstraints gbc_lblNombreDelVideo = new GridBagConstraints();
		gbc_lblNombreDelVideo.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreDelVideo.gridx = 1;
		gbc_lblNombreDelVideo.gridy = 2;
		getContentPane().add(lblNombreDelVideo, gbc_lblNombreDelVideo);
		
		TextoNombre = new JTextField();
		GridBagConstraints gbc_TextoNombre = new GridBagConstraints();
		gbc_TextoNombre.gridwidth = 7;
		gbc_TextoNombre.insets = new Insets(0, 0, 5, 0);
		gbc_TextoNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_TextoNombre.gridx = 3;
		gbc_TextoNombre.gridy = 2;
		getContentPane().add(TextoNombre, gbc_TextoNombre);
		TextoNombre.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 1;
		gbc_lblDescripcion.gridy = 3;
		getContentPane().add(lblDescripcion, gbc_lblDescripcion);
		
		JTextArea tAreaDescripcion = new JTextArea();
		GridBagConstraints gbc_tAreaDescripcion = new GridBagConstraints();
		gbc_tAreaDescripcion.gridwidth = 7;
		gbc_tAreaDescripcion.gridheight = 2;
		gbc_tAreaDescripcion.insets = new Insets(0, 0, 5, 0);
		gbc_tAreaDescripcion.fill = GridBagConstraints.BOTH;
		gbc_tAreaDescripcion.gridx = 3;
		gbc_tAreaDescripcion.gridy = 3;
		getContentPane().add(tAreaDescripcion, gbc_tAreaDescripcion);
		
		JLabel lblDuracion = new JLabel("Duracion:");
		GridBagConstraints gbc_lblDuracion = new GridBagConstraints();
		gbc_lblDuracion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDuracion.gridx = 1;
		gbc_lblDuracion.gridy = 5;
		getContentPane().add(lblDuracion, gbc_lblDuracion);
		
		JSpinner spinnerMinutos = new JSpinner();
		GridBagConstraints gbc_spinnerMinutos = new GridBagConstraints();
		gbc_spinnerMinutos.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerMinutos.gridx = 3;
		gbc_spinnerMinutos.gridy = 5;
		getContentPane().add(spinnerMinutos, gbc_spinnerMinutos);
		
		JLabel lblMin = new JLabel("min.");
		GridBagConstraints gbc_lblMin = new GridBagConstraints();
		gbc_lblMin.insets = new Insets(0, 0, 5, 5);
		gbc_lblMin.gridx = 4;
		gbc_lblMin.gridy = 5;
		getContentPane().add(lblMin, gbc_lblMin);
		
		JSpinner spinnerSegundos = new JSpinner();
		GridBagConstraints gbc_spinnerSegundos = new GridBagConstraints();
		gbc_spinnerSegundos.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerSegundos.gridx = 5;
		gbc_spinnerSegundos.gridy = 5;
		getContentPane().add(spinnerSegundos, gbc_spinnerSegundos);
		
		JLabel lblSeg = new JLabel("seg.");
		GridBagConstraints gbc_lblSeg = new GridBagConstraints();
		gbc_lblSeg.insets = new Insets(0, 0, 5, 5);
		gbc_lblSeg.gridx = 6;
		gbc_lblSeg.gridy = 5;
		getContentPane().add(lblSeg, gbc_lblSeg);
		
		JLabel lblUrl = new JLabel("URL:");
		GridBagConstraints gbc_lblUrl = new GridBagConstraints();
		gbc_lblUrl.insets = new Insets(0, 0, 5, 5);
		gbc_lblUrl.gridx = 1;
		gbc_lblUrl.gridy = 6;
		getContentPane().add(lblUrl, gbc_lblUrl);
		
		tFieldURL = new JTextField();
		GridBagConstraints gbc_tFieldURL = new GridBagConstraints();
		gbc_tFieldURL.gridwidth = 7;
		gbc_tFieldURL.insets = new Insets(0, 0, 5, 0);
		gbc_tFieldURL.fill = GridBagConstraints.HORIZONTAL;
		gbc_tFieldURL.gridx = 3;
		gbc_tFieldURL.gridy = 6;
		getContentPane().add(tFieldURL, gbc_tFieldURL);
		tFieldURL.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategoria.gridx = 1;
		gbc_lblCategoria.gridy = 7;
		getContentPane().add(lblCategoria, gbc_lblCategoria);
		
		JComboBox cBoxCategoria = new JComboBox();
		GridBagConstraints gbc_cBoxCategoria = new GridBagConstraints();
		gbc_cBoxCategoria.gridwidth = 7;
		gbc_cBoxCategoria.insets = new Insets(0, 0, 5, 0);
		gbc_cBoxCategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_cBoxCategoria.gridx = 3;
		gbc_cBoxCategoria.gridy = 7;
		getContentPane().add(cBoxCategoria, gbc_cBoxCategoria);
		
		JButton btnConfirmar = new JButton("Confirmar");
		GridBagConstraints gbc_btnConfirmar = new GridBagConstraints();
		gbc_btnConfirmar.insets = new Insets(0, 0, 5, 5);
		gbc_btnConfirmar.gridx = 7;
		gbc_btnConfirmar.gridy = 9;
		getContentPane().add(btnConfirmar, gbc_btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 8;
		gbc_btnCancelar.gridy = 9;
		getContentPane().add(btnCancelar, gbc_btnCancelar);

	}

}

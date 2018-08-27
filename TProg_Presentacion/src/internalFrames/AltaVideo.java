package internalFrames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import interfaces.IVideos;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTable;

public class AltaVideo extends JInternalFrame {
	private JTextField TextoNombre;
	private JTextField tFieldURL;
	JComboBox<String> cBoxUsuarios;
	JTextArea tAreaDescripcion;
	JSpinner spinnerHoras;
	JSpinner spinnerMinutos;
	JSpinner spinnerSegundos;
	JComboBox<String> cBoxCategoria;
	
	private IVideos contVideos;
	/**
	 * Create the frame.
	 */
	public AltaVideo(IVideos interfaz) {
		contVideos = interfaz;		// Se inicia con la interfaz como parametro
		
		setTitle("Alta de Video");
		setBounds(100, 100, 500, 330);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{23, 78, 30, 1, 0, 0, 0, 0, 0, 0, 36, 1, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 1;
		gbc_lblUsuario.gridy = 1;
		getContentPane().add(lblUsuario, gbc_lblUsuario);
		
		cBoxUsuarios = new JComboBox<String>();
		GridBagConstraints gbc_cBoxUsuarios = new GridBagConstraints();
		gbc_cBoxUsuarios.gridwidth = 7;
		gbc_cBoxUsuarios.insets = new Insets(0, 0, 5, 5);
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
		gbc_TextoNombre.insets = new Insets(0, 0, 5, 5);
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
		
		tAreaDescripcion = new JTextArea();
		GridBagConstraints gbc_tAreaDescripcion = new GridBagConstraints();
		gbc_tAreaDescripcion.gridwidth = 7;
		gbc_tAreaDescripcion.gridheight = 2;
		gbc_tAreaDescripcion.insets = new Insets(0, 0, 5, 5);
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
		
		spinnerHoras = new JSpinner();
		spinnerHoras.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		GridBagConstraints gbc_spinnerHoras = new GridBagConstraints();
		gbc_spinnerHoras.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerHoras.gridx = 3;
		gbc_spinnerHoras.gridy = 5;
		getContentPane().add(spinnerHoras, gbc_spinnerHoras);
		
		JLabel lblHoras = new JLabel("horas");
		GridBagConstraints gbc_lblHoras = new GridBagConstraints();
		gbc_lblHoras.insets = new Insets(0, 0, 5, 5);
		gbc_lblHoras.gridx = 4;
		gbc_lblHoras.gridy = 5;
		getContentPane().add(lblHoras, gbc_lblHoras);
		
		spinnerMinutos = new JSpinner();
		spinnerMinutos.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		GridBagConstraints gbc_spinnerMinutos = new GridBagConstraints();
		gbc_spinnerMinutos.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerMinutos.gridx = 5;
		gbc_spinnerMinutos.gridy = 5;
		getContentPane().add(spinnerMinutos, gbc_spinnerMinutos);
		
		JLabel lblMin = new JLabel("min.");
		GridBagConstraints gbc_lblMin = new GridBagConstraints();
		gbc_lblMin.insets = new Insets(0, 0, 5, 5);
		gbc_lblMin.gridx = 6;
		gbc_lblMin.gridy = 5;
		getContentPane().add(lblMin, gbc_lblMin);
		
		spinnerSegundos = new JSpinner();
		spinnerSegundos.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		GridBagConstraints gbc_spinnerSegundos = new GridBagConstraints();
		gbc_spinnerSegundos.anchor = GridBagConstraints.WEST;
		gbc_spinnerSegundos.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerSegundos.gridx = 7;
		gbc_spinnerSegundos.gridy = 5;
		getContentPane().add(spinnerSegundos, gbc_spinnerSegundos);
		
		JLabel lblSeg = new JLabel("seg.");
		GridBagConstraints gbc_lblSeg = new GridBagConstraints();
		gbc_lblSeg.anchor = GridBagConstraints.WEST;
		gbc_lblSeg.insets = new Insets(0, 0, 5, 5);
		gbc_lblSeg.gridx = 8;
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
		gbc_tFieldURL.insets = new Insets(0, 0, 5, 5);
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
		
		cBoxCategoria = new JComboBox<String>();
		GridBagConstraints gbc_cBoxCategoria = new GridBagConstraints();
		gbc_cBoxCategoria.gridwidth = 7;
		gbc_cBoxCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_cBoxCategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_cBoxCategoria.gridx = 3;
		gbc_cBoxCategoria.gridy = 7;
		getContentPane().add(cBoxCategoria, gbc_cBoxCategoria);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aceptar();
			}
		});
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.gridwidth = 2;
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 7;
		gbc_btnAceptar.gridy = 9;
		getContentPane().add(btnAceptar, gbc_btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 9;
		gbc_btnCancelar.gridy = 9;
		getContentPane().add(btnCancelar, gbc_btnCancelar);

	}

	public void cargarDatos(){
		/**
		 * Aca se le piden la lista de usuarios y la lista de categorias al controlador
		 */
		String[] usuarios = contVideos.listarUsuarios();
		String [] categorias = contVideos.listarCategorias();
		DefaultComboBoxModel<String> modelU = new DefaultComboBoxModel<>(usuarios);
		DefaultComboBoxModel<String> modelC = new DefaultComboBoxModel<>(categorias);
		cBoxUsuarios.setModel(modelU);
		cBoxCategoria.setModel(modelC);
		
	}
	
	public void aceptar() {
		String nick, nombre, descripcion, url, categoria;
		Duration duracion;
		/**
		 * recolecto la info del frame
		 */
		nick = (String) cBoxUsuarios.getSelectedItem();
		nombre = TextoNombre.getText();
		descripcion = tAreaDescripcion.getText();
		url = tFieldURL.getText();
		categoria = (String) cBoxCategoria.getSelectedItem();
		duracion = Duration.ofHours((int) spinnerHoras.getValue());
		duracion = duracion.plusMinutes((int) spinnerMinutos.getValue());
		duracion = duracion.plusSeconds((int) spinnerSegundos.getValue());
		// TODO fecha del video
		if (datosCorrectos(nick, nombre, url, duracion)) {
			try {
			contVideos.altaVideo(nick, nombre, descripcion, duracion, url, categoria);
			JOptionPane.showMessageDialog(this, "Video creado con exito!");
			setVisible(false);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Alta video", JOptionPane.ERROR_MESSAGE);	// Muesta el error al dar de alta
			}
		} else {
			JOptionPane.showMessageDialog(this, "No deben haber campos vacios.", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public boolean datosCorrectos(String nick, String nombre, String url, Duration duracion) {
		return (nick != null && !(nombre.equals("")) && !(url.equals("")) && !(duracion.isZero()));
	}
	
}

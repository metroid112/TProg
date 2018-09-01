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
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTable;
import org.jdesktop.swingx.JXDatePicker;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


public class AltaVideo extends JInternalFrame {
	private JTextField TextoNombre;
	private JTextField tFieldURL;
	JComboBox<String> cBoxUsuarios;
	JTextArea tAreaDescripcion;
	JSpinner spinnerHoras;
	JSpinner spinnerMinutos;
	JSpinner spinnerSegundos;
	JComboBox<String> cBoxCategoria;
	JXDatePicker datePicker;
	
	private IVideos contVideos;
	/**
	 * Create the frame.
	 */
	public AltaVideo(IVideos interfaz) {
		contVideos = interfaz;		// Se inicia con la interfaz como parametro
		
		setTitle("Alta de Video");
		setBounds(100, 100, 500, 330);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		
		cBoxUsuarios = new JComboBox<String>();
		
		JLabel lblNombreDelVideo = new JLabel("Nombre del Video:");
		
		TextoNombre = new JTextField();
		TextoNombre.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		
		tAreaDescripcion = new JTextArea();
		
		JLabel lblDuracion = new JLabel("Duracion:");
		
		spinnerHoras = new JSpinner();
		spinnerHoras.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		JLabel lblHoras = new JLabel("horas");
		
		spinnerMinutos = new JSpinner();
		spinnerMinutos.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		JLabel lblMin = new JLabel("min.");
		
		spinnerSegundos = new JSpinner();
		spinnerSegundos.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		JLabel lblSeg = new JLabel("seg.");
		
		JLabel lblUrl = new JLabel("URL:");
		
		tFieldURL = new JTextField();
		tFieldURL.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		
		cBoxCategoria = new JComboBox<String>();
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aceptar();
			}
		});
		
		datePicker = new JXDatePicker();
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				clearDatos();
			}
		});
		
		JLabel lblFecha = new JLabel("Fecha:");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblUsuario)
							.addGap(70)
							.addComponent(cBoxUsuarios, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblDuracion)
							.addGap(87)
							.addComponent(spinnerHoras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblHoras)
							.addGap(10)
							.addComponent(spinnerMinutos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblMin)
							.addGap(10)
							.addComponent(spinnerSegundos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblSeg))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(295)
							.addComponent(btnAceptar)
							.addGap(5)
							.addComponent(btnCancelar))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblDescripcion)
									.addGap(52)
									.addComponent(tAreaDescripcion, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNombreDelVideo, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(TextoNombre, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblCategoria, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
								.addComponent(lblFecha, Alignment.LEADING)
								.addComponent(lblUrl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(49)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(cBoxCategoria, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
								.addComponent(tFieldURL, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE))))
					.addGap(38))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cBoxUsuarios, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsuario))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(TextoNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombreDelVideo))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(tAreaDescripcion, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDescripcion))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(spinnerHoras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinnerMinutos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinnerSegundos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHoras)
								.addComponent(lblMin)
								.addComponent(lblSeg))
							.addGap(5))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDuracion)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tFieldURL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUrl))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cBoxCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCategoria))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFecha))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAceptar)
						.addComponent(btnCancelar)))
		);
		getContentPane().setLayout(groupLayout);

	}

	public void cargarDatos(){
		/**
		 * Aca se le piden la lista de usuarios y la lista de categorias al controlador
		 */
		String[] usuarios = contVideos.listarUsuarios();
		String [] categorias = contVideos.listarCategorias();
		DefaultComboBoxModel<String> modelU = new DefaultComboBoxModel<>(usuarios);
		DefaultComboBoxModel<String> modelC = new DefaultComboBoxModel<>(categorias);
		modelC.addElement("Sin Categoria");
		modelC.setSelectedItem("Sin Categoria");
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
		if (categoria.equals("Sin Categoria")) {		// Chequeo si eligio alguna categoria
			categoria = null;
		}
		duracion = Duration.ofHours((int) spinnerHoras.getValue());
		duracion = duracion.plusMinutes((int) spinnerMinutos.getValue());
		duracion = duracion.plusSeconds((int) spinnerSegundos.getValue());
		Date fecha = datePicker.getDate();
		if (datosCorrectos(nick, nombre, url, duracion)) {
			try {
			contVideos.altaVideo(nick, nombre, descripcion, duracion, url, categoria, fecha); 
			JOptionPane.showMessageDialog(this, "Video creado con exito!");
			setVisible(false);
			clearDatos();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Alta video", JOptionPane.ERROR_MESSAGE);	// Muesta el error al dar de alta
			}
		} else {
			JOptionPane.showMessageDialog(this, "No deben haber campos vacios.", "Error!", JOptionPane.ERROR_MESSAGE); 	// TODO arreglo de error
		}
		
	}
	
	public boolean datosCorrectos(String nick, String nombre, String url, Duration duracion) {
		return (nick != null && !(nombre.equals("")) && !(url.equals("")) && !(duracion.isZero()));
	}
	
	private void clearDatos() {
		TextoNombre.setText(null);
		tFieldURL.setText(null);
		tAreaDescripcion.setText(null);
		datePicker.setDate(new Date());
		cBoxCategoria.setSelectedItem(null);
		spinnerHoras.setValue(0);
		spinnerMinutos.setValue(0);
		spinnerSegundos.setValue(0);
	}
}

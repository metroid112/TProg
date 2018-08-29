package internalFrames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.CardLayout;
import paneles.SeleccionVideo;
import interfaces.IVideos;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import org.jdesktop.swingx.JXDatePicker;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class ModificarVideo extends JInternalFrame {
	private SeleccionVideo seleccionVideo;
	private IVideos contVid;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Create the frame.
	 */
	public ModificarVideo(IVideos contVid) {
		this.contVid = contVid;
		setTitle("Modificar Video");
		setBounds(100, 100, 500, 450);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panelSeleccion = new JPanel();
		getContentPane().add(panelSeleccion, "name_75253987057171");
		
		seleccionVideo = new SeleccionVideo(this.contVid);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambioPanel(); 		// Cambio al siguiente panel
			}
		});
		GroupLayout gl_panelSeleccion = new GroupLayout(panelSeleccion);
		gl_panelSeleccion.setHorizontalGroup(
			gl_panelSeleccion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSeleccion.createSequentialGroup()
					.addGap(13)
					.addComponent(seleccionVideo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(Alignment.TRAILING, gl_panelSeleccion.createSequentialGroup()
					.addContainerGap(285, Short.MAX_VALUE)
					.addComponent(btnModificar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCancelar)
					.addContainerGap())
		);
		gl_panelSeleccion.setVerticalGroup(
			gl_panelSeleccion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSeleccion.createSequentialGroup()
					.addGap(5)
					.addComponent(seleccionVideo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panelSeleccion.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnModificar))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		panelSeleccion.setLayout(gl_panelSeleccion);
		
		JPanel panelMod = new JPanel();
		getContentPane().add(panelMod, "name_77608104205516");
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambioPanel();
				//TODO clear datos
			}
		});
		
		JLabel lblNombre = new JLabel("Nombre:");
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		
		JLabel lblDuracion = new JLabel("Duracion:");
		
		JLabel lblVisibilidad = new JLabel("Visibilidad:");
		
		JLabel lblFecha = new JLabel("Fecha:");
		
		JLabel lblCategoria = new JLabel("Categoria:");
		
		JLabel lblUrl = new JLabel("URL:");
		
		JScrollPane scrollPane = new JScrollPane();
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		
		JXDatePicker datePicker = new JXDatePicker();
		
		JRadioButton rdbtnPublico = new JRadioButton("Publico");
		
		JRadioButton rdbtnPrivado = new JRadioButton("Privado");
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		JLabel lblHoras = new JLabel("horas");
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		JLabel lblMin = new JLabel("min.");
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		JLabel lblSeg = new JLabel("seg.");
		GroupLayout gl_panelMod = new GroupLayout(panelMod);
		gl_panelMod.setHorizontalGroup(
			gl_panelMod.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMod.createSequentialGroup()
					.addContainerGap(227, Short.MAX_VALUE)
					.addComponent(btnVolver)
					.addGap(188))
				.addGroup(gl_panelMod.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_panelMod.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDescripcion)
						.addComponent(lblNombre)
						.addComponent(lblDuracion)
						.addComponent(lblUrl)
						.addComponent(lblCategoria)
						.addComponent(lblFecha)
						.addComponent(lblVisibilidad))
					.addGap(18)
					.addGroup(gl_panelMod.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMod.createSequentialGroup()
							.addComponent(rdbtnPublico)
							.addGap(18)
							.addComponent(rdbtnPrivado))
						.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, 0, 347, Short.MAX_VALUE)
						.addComponent(textField_1, 347, 347, 347)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
						.addGroup(gl_panelMod.createSequentialGroup()
							.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblHoras)
							.addGap(18)
							.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblMin)
							.addGap(18)
							.addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblSeg)))
					.addContainerGap())
		);
		gl_panelMod.setVerticalGroup(
			gl_panelMod.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMod.createSequentialGroup()
					.addGap(38)
					.addGroup(gl_panelMod.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelMod.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescripcion)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panelMod.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDuracion)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHoras)
						.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMin)
						.addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSeg))
					.addGap(18)
					.addGroup(gl_panelMod.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVisibilidad)
						.addComponent(rdbtnPublico)
						.addComponent(rdbtnPrivado))
					.addGap(18)
					.addGroup(gl_panelMod.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFecha)
						.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelMod.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCategoria)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelMod.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUrl)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addComponent(btnVolver)
					.addGap(53))
		);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		panelMod.setLayout(gl_panelMod);

	}
	
	public void cargarDatos() {
		seleccionVideo.cargarDatos();
	}
	
	private void cambioPanel() {
		CardLayout layout= (CardLayout) getContentPane().getLayout();	// Consigo el layout
		layout.next(getContentPane());		// Cambia al siguiente panel
		
	}
}

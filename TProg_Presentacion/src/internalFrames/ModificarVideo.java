package internalFrames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.CardLayout;
import paneles.SeleccionVideo;
import interfaces.IVideos;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import org.jdesktop.swingx.JXDatePicker;

import dataTypes.DtVideo;

import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class ModificarVideo extends JInternalFrame {
	private SeleccionVideo seleccionVideo;
	private IVideos contVid;
	private JTextField tfNombre;
	private JTextField tfURL;
	private ButtonGroup grupo = new ButtonGroup();
	private JComboBox<String> cBoxCategoria;
	private JSpinner spinnerHoras, spinnerMin, spinnerSeg;
	private JTextArea textDescripcion;
	private JXDatePicker datePicker;
	private JRadioButton rdbtnPublico, rdbtnPrivado;
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
				modVideo(); 		// Cambio al siguiente panel
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
		
		tfNombre = new JTextField();
		tfNombre.setColumns(10);
		
		tfURL = new JTextField();
		tfURL.setColumns(10);
		
		cBoxCategoria = new JComboBox();
		
		datePicker = new JXDatePicker();
		
		rdbtnPublico = new JRadioButton("Publico", true);
		
		rdbtnPrivado = new JRadioButton("Privado");
		grupo.add(rdbtnPrivado);
		grupo.add(rdbtnPublico);
		
		spinnerHoras = new JSpinner();
		spinnerHoras.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		JLabel lblHoras = new JLabel("horas");
		
		spinnerMin = new JSpinner();
		spinnerMin.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		JLabel lblMin = new JLabel("min.");
		
		spinnerSeg = new JSpinner();
		spinnerSeg.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		JLabel lblSeg = new JLabel("seg.");
		GroupLayout gl_panelMod = new GroupLayout(panelMod);
		gl_panelMod.setHorizontalGroup(
			gl_panelMod.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMod.createSequentialGroup()
					.addContainerGap(233, Short.MAX_VALUE)
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
						.addComponent(cBoxCategoria, 0, 361, Short.MAX_VALUE)
						.addComponent(tfNombre, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
						.addGroup(gl_panelMod.createSequentialGroup()
							.addComponent(spinnerHoras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblHoras)
							.addGap(18)
							.addComponent(spinnerMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblMin)
							.addGap(18)
							.addComponent(spinnerSeg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblSeg))
						.addComponent(tfURL, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelMod.setVerticalGroup(
			gl_panelMod.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMod.createSequentialGroup()
					.addGap(38)
					.addGroup(gl_panelMod.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(tfNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelMod.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescripcion)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addGroup(gl_panelMod.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDuracion)
						.addComponent(spinnerHoras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHoras)
						.addComponent(spinnerMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMin)
						.addComponent(spinnerSeg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
						.addComponent(cBoxCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelMod.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUrl)
						.addComponent(tfURL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addComponent(btnVolver)
					.addGap(53))
		);
		
		textDescripcion = new JTextArea();
		scrollPane.setViewportView(textDescripcion);
		panelMod.setLayout(gl_panelMod);

	}
	
	public void cargarDatos() {
		seleccionVideo.cargarDatos();
	}
	
	private void cambioPanel() {
		CardLayout layout= (CardLayout) getContentPane().getLayout();	// Consigo el layout
		layout.next(getContentPane());		// Cambia al siguiente panel
		
	}
	
	private void modVideo() {
		if (seleccionVideo.getUsuario() != null) {
			DtVideo infoVid = contVid.getDtVideo(seleccionVideo.getVideo(), seleccionVideo.getUsuario());		// Pido info del video para desplegar
			tfNombre.setText(infoVid.getNombre());
			textDescripcion.setText(infoVid.getDescripcion());
			tfURL.setText(infoVid.getURL());
			if (infoVid.isVisible()) {
				rdbtnPublico.doClick();
			} else {
				rdbtnPrivado.doClick();
			}
			int horas,min,seg;
			Duration duracion = infoVid.getDuracion();
			horas = (int) duracion.toHours();
			duracion.minusHours(horas);
			min = (int) duracion.toMinutes();
			duracion.minusMinutes(min);
			seg = (int) duracion.getSeconds();
			spinnerHoras.setValue(horas);
			spinnerMin.setValue(min);
			spinnerSeg.setValue(seg);
			datePicker.setDate(infoVid.getFecha());
			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(contVid.listarCategorias());
			if (!infoVid.getCategoria().equals("Sin Categoria")) {
				int size = model.getSize();
				int i = 0;
				boolean encontrado = false;
				while (i <= size && !encontrado) {
					if (model.getElementAt(i).equals(infoVid.getCategoria())) {
						model.setSelectedItem(model.getElementAt(i));
						encontrado = true;
					}	
					i++;
				}
				if (!encontrado) {
					System.out.println("ERROR: categoria no encontrada en ModificarVideo. La categoria era: " + infoVid.getCategoria()); 	// TODO excepccion
				}
			} else {
				model.addElement(infoVid.getCategoria());	// En caso de decir "Sin Categoria"
				model.setSelectedItem(infoVid.getCategoria());
			}
			cBoxCategoria.setModel(model);
			
			cambioPanel();
		} else {
			JOptionPane.showMessageDialog(this, "Usuario vacio", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}

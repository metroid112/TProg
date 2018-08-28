package internalFrames;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import java.text.SimpleDateFormat;
import java.util.Date;

import interfaces.Fabrica;
import interfaces.IUsuariosCanales;


public class DetallesUsuario extends JPanel {
	private IUsuariosCanales ctrlUsu;
	private Fabrica fab;
	
	private DefaultListModel<String> modelListas = new DefaultListModel<>();
	private JList<String> listasDeReproduccion =  new JList<>(modelListas);
	private DefaultListModel<String> modelVideos = new DefaultListModel<>();
	private JList<String> videos =  new JList<>(modelListas);
	
	/**
	 * Create the panel.
	 */
	public DetallesUsuario(String usuario) {
		
		fab = Fabrica.getFabrica();
		ctrlUsu = fab.getIUsuariosCanales(); 
		String nombre = ctrlUsu.getNombre(usuario);
		String apellido = ctrlUsu.getApellido(usuario);
		String correo = ctrlUsu.getCorreo(usuario);
		String canal = ctrlUsu.getNombreCanal(usuario);
		String descripcionCanal = ctrlUsu.getDescripcionCanal(usuario);
		
		Date fechaNacimiento = ctrlUsu.getNacimiento(usuario);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String fechaParaMostrar = sdf.format(fechaNacimiento);
		
		boolean privado = ctrlUsu.getPrivado(usuario);
		String tipoCanal;
		if(privado) {
			tipoCanal = "Canal privado";
		}
		else {
			tipoCanal = "Canal público";
		}
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblVideos = new JLabel("Videos");
		
		JLabel lblListasDeReproduccion = new JLabel("Listas de reproduccion:");
		
		
		String nickname = "Datos del usuario " + usuario;
		
		JLabel lblDatosDelUsuario = new JLabel(nickname);
		lblDatosDelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblCanalPrivado = new JLabel(tipoCanal);
		lblCanalPrivado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCanalPrivado.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNombreCanal = new JLabel("Nombre canal:");
		lblNombreCanal.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblDescripcionCanal = new JLabel("Descripcion canal:");
		lblDescripcionCanal.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblNewLabel = new JLabel(nombre);
		
		JLabel lblapellido = new JLabel(apellido);
		
		JLabel lblcorreo = new JLabel(correo);
		
		JLabel lblfecha = new JLabel(fechaParaMostrar);
		
		JLabel lblcanal = new JLabel(canal);
		
		JTextPane txtpnddescripcioncanal = new JTextPane();
		txtpnddescripcioncanal.setBackground(SystemColor.menu);
		txtpnddescripcioncanal.setText(descripcionCanal);
		
		JPanel imagen = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblCorreo, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblFechaDeNacimiento, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblApellido, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblfecha, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblcorreo, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblapellido, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(59)
									.addComponent(lblCanalPrivado, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNombreCanal, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblcanal, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblDescripcionCanal, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtpnddescripcioncanal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(90)
							.addComponent(imagen, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblVideos)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblListasDeReproduccion, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
					.addGap(43))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(151)
					.addComponent(lblDatosDelUsuario, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(151, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDatosDelUsuario, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(lblVideos)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblListasDeReproduccion)
							.addGap(2)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addGap(40))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(7)
							.addComponent(imagen, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombre)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblApellido)
								.addComponent(lblapellido))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCorreo)
								.addComponent(lblcorreo))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFechaDeNacimiento)
								.addComponent(lblfecha))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCanalPrivado, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombreCanal)
								.addComponent(lblcanal))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtpnddescripcioncanal, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDescripcionCanal))
							.addContainerGap())))
		);
		
		//JList listasDeReproduccion = new JList();
		scrollPane_1.setViewportView(listasDeReproduccion);
		
		//JList videos = new JList();
		scrollPane.setViewportView(videos);
		setLayout(groupLayout);
		
		cargarDatosListas(usuario);
		cargarDatosVideos(usuario);
	}
	public void cargarDatosListas(String usuario){
		modelListas.removeAllElements();
		fab = Fabrica.getFabrica();
		ctrlUsu = fab.getIUsuariosCanales();
	
		String[] listas = ctrlUsu.listarListasDeReproduccion(usuario);
		int largo = listas.length;
		for (int i = 0; i < largo; i++ ){
			modelListas.addElement(listas[i]);
		}
			ctrlUsu = null;
		}
	public String getListaSeleccionada() {
		return listasDeReproduccion.getSelectedValue();
		//return model.
	}
	
	public void cargarDatosVideos(String usuario){
		modelVideos.removeAllElements();
		fab = Fabrica.getFabrica();
		ctrlUsu = fab.getIUsuariosCanales();
	
		String[] videosS = ctrlUsu.listarVideos(usuario);
		int largo = videosS.length;
		for (int i = 0; i < largo; i++ ){
			modelVideos.addElement(videosS[i]);
		}
			ctrlUsu = null;
		}
	
	public String getVideoSeleccionado() {
		return videos.getSelectedValue();
		//return model.
	}
}

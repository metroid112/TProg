package internalFrames;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import interfaces.Fabrica;
import interfaces.IVideos;
import paneles.DetallesUsuario;
import paneles.InfoVideo;

@SuppressWarnings("serial")
public class VerInformacionUsuario extends JInternalFrame {
	private DetallesUsuario paneluser = null;
	private JPanel panel_2;
	private JPanel PanelInfoVideo;
	private String UsrSel = null;
	public void SetVisible(boolean b) {
		setEnabled(b);
	}
	private ConsultaUsuario padre = null;
	public void SetPadre(ConsultaUsuario padre) {
		this.padre=padre;
	}
	//imports para el video
	private InfoVideo PanelConsultaVideo;
	private IVideos contVideos = Fabrica.getIVideos();
	//fin 
	
	public VerInformacionUsuario() {
		setBounds(0, 10, 787, 480);
		
		getContentPane().setLayout(new CardLayout(0, 0));
		JPanel panelInfoUsuario = new JPanel();
		getContentPane().add(panelInfoUsuario, "name_1341908072638329");
		
		JButton btnNewButton = new JButton("Cerrar");		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				getContentPane().remove(paneluser);
				panel_2.remove(paneluser);
				paneluser = null;
				//padre.SetVisible(true);
				//getContentPane().removeAll();
			}
		});
		
		panel_2 = new JPanel();
		
		JButton btnNewButton_1 = new JButton("Ver info video");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if	(paneluser.isVideoSeleccionado()) {
					String VidSel = paneluser.getVideoSeleccionado();
					verInfo(VidSel, UsrSel);
				}
			}
		});
		GroupLayout gl_panelInfoUsuario = new GroupLayout(panelInfoUsuario);
		gl_panelInfoUsuario.setHorizontalGroup(
			gl_panelInfoUsuario.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 771, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_panelInfoUsuario.createSequentialGroup()
					.addContainerGap(575, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panelInfoUsuario.setVerticalGroup(
			gl_panelInfoUsuario.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelInfoUsuario.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(gl_panelInfoUsuario.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap())
		);
		panelInfoUsuario.setLayout(gl_panelInfoUsuario);
		
		PanelInfoVideo = new JPanel();
		getContentPane().add(PanelInfoVideo, "name_1341929743838464");
		
		PanelConsultaVideo = new InfoVideo(contVideos);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cambioPanel();
			}
		});
		GroupLayout gl_PanelInfoVideo = new GroupLayout(PanelInfoVideo);
		gl_PanelInfoVideo.setHorizontalGroup(
			gl_PanelInfoVideo.createParallelGroup(Alignment.TRAILING)
				.addComponent(PanelConsultaVideo, GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
				.addGroup(gl_PanelInfoVideo.createSequentialGroup()
					.addContainerGap(672, Short.MAX_VALUE)
					.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_PanelInfoVideo.setVerticalGroup(
			gl_PanelInfoVideo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PanelInfoVideo.createSequentialGroup()
					.addComponent(PanelConsultaVideo, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addComponent(btnVolver)
					.addContainerGap())
		);
		PanelInfoVideo.setLayout(gl_PanelInfoVideo);
		
		JPanel panelInfoListas = new JPanel();
		getContentPane().add(panelInfoListas, "name_1462766790498547");
		//cambioPanel();
	}
	
	public void CargarInformacionUsuario(String usuario) {
		UsrSel = usuario;
		paneluser = new DetallesUsuario(usuario);
		panel_2.add(paneluser, BorderLayout.CENTER);
	}
	
	public void verInfo(String VidSel2, String UsrSel) {
		PanelConsultaVideo.cargarDatos(contVideos.getDtVideo(VidSel2, UsrSel));	// Paso la info al panel de info
		PanelInfoVideo.add(PanelConsultaVideo, BorderLayout.CENTER);
		cambioPanel();		// Voy al panel de informacion
	}

	public void cambioPanel() {
		CardLayout layout= (CardLayout) getContentPane().getLayout();	// Consigo el layout
		layout.next(getContentPane());		// Cambia al siguiente panel
	}
}

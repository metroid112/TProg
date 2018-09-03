package internalFrames;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import dataTypes.DtLista;
import interfaces.Fabrica;
import interfaces.IListas;
import interfaces.IUsuariosCanales;
import interfaces.IVideos;
import paneles.DetallesUsuario;
import paneles.InfoVideo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;


@SuppressWarnings("serial")
public class VerInformacionUsuario extends JInternalFrame {
	private DetallesUsuario paneluser = null;
	private JPanel panel_2;
	private IListas ctrlLis = Fabrica.getIListas();
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
	private Fabrica fab = Fabrica.getFabrica();
	private JLabel lblNewLabel_1 = new JLabel("vNombreLista");
	private JLabel lblVtipolista = new JLabel("vTipoLista");	
	private JLabel lblNewLabel_2 = new JLabel("vPrivacidad");
	private JList<String> videosLista;
	private IVideos contVideos = fab.getIVideos();

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
				else {
					JOptionPane.showMessageDialog(getFocusOwner(), "Seleccione un video");
				}
			}
		});
		
		JButton verInfoListas = new JButton("Ver info lista");
		verInfoListas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//cargar informacion de lista,
				if	(paneluser.isListaSelected()) {
					String LisSel = paneluser.getListaSeleccionada();
					if (LisSel != null) {
						cargaDatosLista(LisSel, UsrSel);
					}
					else {
						JOptionPane.showInputDialog(this);
					}
					cambioPanel();
					cambioPanel();
				}
				else {
					JOptionPane.showMessageDialog(getFocusOwner(), "Seleccione una lista");
				}
				
			}
		});
		GroupLayout gl_panelInfoUsuario = new GroupLayout(panelInfoUsuario);
		gl_panelInfoUsuario.setHorizontalGroup(
			gl_panelInfoUsuario.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 771, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_panelInfoUsuario.createSequentialGroup()
					.addContainerGap(443, Short.MAX_VALUE)
					.addComponent(verInfoListas, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
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
						.addComponent(btnNewButton_1)
						.addComponent(verInfoListas))
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
				cambioPanel();//se repite porque hay 3 paneles.
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
		
		JButton button = new JButton("Volver");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cambioPanel();
			}
		});
		
		JScrollPane VideosDeLista = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("Videos");
		
		JButton VerInfoVideoDesdeCOnsultaLista = new JButton("Ver info video");
		
		JLabel lblDetallesLista = new JLabel("Detalles lista:");
		lblDetallesLista.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_panelInfoListas = new GroupLayout(panelInfoListas);
		gl_panelInfoListas.setHorizontalGroup(
			gl_panelInfoListas.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelInfoListas.createSequentialGroup()
					.addContainerGap(549, Short.MAX_VALUE)
					.addComponent(VerInfoVideoDesdeCOnsultaLista, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_panelInfoListas.createSequentialGroup()
					.addGap(119)
					.addComponent(lblDetallesLista, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(504, Short.MAX_VALUE))
				.addGroup(gl_panelInfoListas.createSequentialGroup()
					.addGap(80)
					.addGroup(gl_panelInfoListas.createParallelGroup(Alignment.LEADING)
						.addComponent(lblVtipolista, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED, 258, Short.MAX_VALUE)
					.addGroup(gl_panelInfoListas.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(VideosDeLista, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE))
					.addGap(129))
		);
		gl_panelInfoListas.setVerticalGroup(
			gl_panelInfoListas.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelInfoListas.createSequentialGroup()
					.addGap(30)
					.addComponent(lblDetallesLista)
					.addGap(18)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInfoListas.createParallelGroup(Alignment.BASELINE)
						.addComponent(VideosDeLista, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelInfoListas.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(8)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblVtipolista)))
					.addPreferredGap(ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
					.addGroup(gl_panelInfoListas.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(VerInfoVideoDesdeCOnsultaLista))
					.addContainerGap())
		);
		
		videosLista = new JList<String>();
		VideosDeLista.setViewportView(videosLista);
		panelInfoListas.setLayout(gl_panelInfoListas);
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
	
	/*		JLabel lblNewLabel_1 = new JLabel("vNombreLista");
		
		JLabel lblVtipolista = new JLabel("vTipoLista");
		
		JLabel lblNewLabel_2 = new JLabel("vPrivacidad");
		*/
	
	private void cargaDatosLista(String lista, String usuario) {
			
			DtLista dtLista;
			try {
				//JOptionPane.showMessageDialog(this, lista + " " + usuario);
				dtLista = ctrlLis.getDt(lista, usuario);
			if (dtLista.isVisible()) {
				lblNewLabel_2.setText("Publico");
			} else {
				lblNewLabel_2.setText("Privado");
			}
			DefaultListModel<String> modeloVideos = new DefaultListModel<String>();
			for (String vid : dtLista.getVideos()) {
				modeloVideos.addElement(vid);
			}
			videosLista.setModel(modeloVideos);
			lblNewLabel_1.setText(dtLista.getNombre());
			lblVtipolista.setText(dtLista.getTipo());
			
			
			//DefaultListModel<String> modeloCategorias = new DefaultListModel<String>();
			//for (String cat : dtLista.getCategorias()) {
			//	modeloCategorias.addElement(cat);
			//}
			//listaCategorias.setModel(modeloCategorias);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}

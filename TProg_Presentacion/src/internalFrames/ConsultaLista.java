package internalFrames;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.TableColumn;

import interfaces.*;
import paneles.InfoVideo;

import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

@SuppressWarnings("serial")
public class ConsultaLista extends JInternalFrame{

	private IUsuariosCanales ctrUsu;
	private IListas ctrLis;
	private ButtonGroup grupoLista = new ButtonGroup();
	private Fabrica fab;
	private DefaultComboBoxModel<String> modelUsuario = new DefaultComboBoxModel<String>();

	private DefaultListModel<String> listListas = new DefaultListModel<>();
	
	private JList<String> list, listaVideos;

	public ConsultaLista() {
		
		setTitle("Conultar lista");
		setBounds(0, 0, 540, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panelSeleccion = new JPanel();
		InfoVideo panelInfo = new InfoVideo(Fabrica.getFabrica().getIVideos());
		ctrLis = Fabrica.getFabrica().getIListas();
		getContentPane().setLayout(new CardLayout());
		getContentPane().add(panelSeleccion);
		getContentPane().add(panelInfo);
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario");
		
		JComboBox comboBoxUsuario = new JComboBox(modelUsuario);
		
		JButton btnCerrar = new JButton("Cerrar");
		
		JScrollPane scrollPaneListas = new JScrollPane();
		
		JRadioButton rdbtnListasPorDefecto = new JRadioButton("Listas por defecto",true);
		rdbtnListasPorDefecto.setEnabled(false);
		
		JRadioButton rdbtnListasParticulares = new JRadioButton("Listas particulares");
		rdbtnListasParticulares.setEnabled(false);
		grupoLista.add(rdbtnListasPorDefecto);
		grupoLista.add(rdbtnListasParticulares);
		
		JLabel lblVisibilidad = new JLabel("Visibilidad:");
		lblVisibilidad.setEnabled(false);
		
		JLabel lblLvisibilidad = new JLabel("");
		
		JScrollPane scrollPaneVideos = new JScrollPane();
		
		JButton btnConsultarVideo = new JButton("Consultar Video");
		btnConsultarVideo.setEnabled(false);
		btnConsultarVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		GroupLayout groupLayout = new GroupLayout(panelSeleccion);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNombreDeUsuario)
							.addGap(120))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBoxUsuario, 0, 144, Short.MAX_VALUE)
								.addComponent(rdbtnListasPorDefecto)
								.addComponent(rdbtnListasParticulares)
								.addComponent(scrollPaneListas, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
							.addGap(68)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblVisibilidad)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblLvisibilidad))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(scrollPaneVideos, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnConsultarVideo)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnCerrar))))
					.addGap(84))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreDeUsuario)
						.addComponent(lblVisibilidad)
						.addComponent(lblLvisibilidad))
					.addGap(13)
					.addComponent(comboBoxUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(rdbtnListasPorDefecto)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnListasParticulares)
							.addGap(11)
							.addComponent(scrollPaneListas, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(scrollPaneVideos, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnCerrar)
								.addComponent(btnConsultarVideo))))
					.addGap(37))
		);
		
		listaVideos = new JList<String>();
		scrollPaneVideos.setViewportView(listaVideos);
		
		JLabel lblVideos = new JLabel("Videos:");
		lblVideos.setEnabled(false);
		scrollPaneVideos.setColumnHeaderView(lblVideos);
		
		list = new JList<String>(listListas);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				lblLvisibilidad.setEnabled(true);
				lblVideos.setEnabled(true);
				cargaDatosLista();
			}
		});
		list.setEnabled(false);
		scrollPaneListas.setViewportView(list);
		panelSeleccion.setLayout(groupLayout);
		
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				modelUsuario.removeAllElements();
				listListas.removeAllElements();
				list.setEnabled(false);
				rdbtnListasPorDefecto.setSelected(true);
				rdbtnListasParticulares.setSelected(false);
				rdbtnListasPorDefecto.setEnabled(false);
				rdbtnListasParticulares.setEnabled(false);
				
			}
		});
		
		rdbtnListasPorDefecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				cargarDefectoListas();
			}
		});
		
		rdbtnListasParticulares.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				cargarParticularListas();
			}
		});
		
		comboBoxUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxUsuario.getSelectedItem() != ""){
					
					
					list.setEnabled(true);
					rdbtnListasParticulares.setEnabled(true);
					rdbtnListasPorDefecto.setEnabled(true);

					if(rdbtnListasPorDefecto.isSelected()){						
						cargarDefectoListas();
					}
					if(rdbtnListasParticulares.isSelected()){						
						cargarParticularListas();
					}
					
				}
				else{ 
					list.setEnabled(false);
					rdbtnListasPorDefecto.setSelected(true);
					rdbtnListasParticulares.setSelected(false);
					rdbtnListasPorDefecto.setEnabled(false);
					rdbtnListasParticulares.setEnabled(false);
					list.setEnabled(false);
				}
			}
		});

	}
	
	public void cargarDatos(){
		
		fab = Fabrica.getFabrica();
		ctrUsu = fab.getIUsuariosCanales();
		
	    String[] usuarios = ctrUsu.listarUsuarios();
		int largou = usuarios.length;
		
		modelUsuario.addElement("");
		for (int i = 0; i < largou; i++ ){
		  modelUsuario.addElement(usuarios[i]);
		}
		ctrUsu = null;
		
	}
	
	
	public void cargarDefectoListas(){
		
		listListas.removeAllElements();
		
		if(modelUsuario.getSelectedItem() != null){
			
			String s = modelUsuario.getSelectedItem().toString();
			
		    String[] listas = ctrLis.listarListasDefectoUsuario(s);
		    
			int largol = listas.length;
			
			for (int i = 0; i < largol; i++ ){
			  listListas.addElement(listas[i]);
			}
		}
			
		ctrLis = null;
	}
	
	public void cargarParticularListas(){
		listListas.removeAllElements();
		fab = Fabrica.getFabrica();
		ctrLis = fab.getIListas();
		
		if(modelUsuario.getSelectedItem() != null){
			
			String s = modelUsuario.getSelectedItem().toString();
			
		    String[] listas = ctrLis.listarListasParticularUsuario(s);
		    
			int largol = listas.length;
			
			
			for (int i = 0; i < largol; i++ ){
			  listListas.addElement(listas[i]);
			}
		}
			
		ctrLis = null;
	}
	
	boolean checkUsuario(){

		if(modelUsuario.getSelectedItem() == ""){
			JOptionPane.showMessageDialog(null, "No has seleccionado ningún usuario", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	private void cargaDatosLista() {
		String lista = list.getSelectedValue();
		DtLista dtLista = ctrLis.getDt(lista);
		//TODO terminar carga de datos y desplegar videos
		
	}
}

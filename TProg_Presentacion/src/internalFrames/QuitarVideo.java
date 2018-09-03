package internalFrames;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import interfaces.Fabrica;
import interfaces.IListas;
import interfaces.IUsuariosCanales;

@SuppressWarnings("serial")
public class QuitarVideo extends JInternalFrame{

	private IUsuariosCanales ctrUsu;
	private IListas ctrLis;
	private ButtonGroup grupoLista = new ButtonGroup();
	private DefaultComboBoxModel<String> modelUsuario = new DefaultComboBoxModel<String>();
	private DefaultComboBoxModel<String> modelVideos = new DefaultComboBoxModel<String>();
	private DefaultListModel<String> listListas = new DefaultListModel<>();
	
	
	public QuitarVideo() {
		
		setTitle("Quitar video");
		setBounds(0, 0, 640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario");
		
		JLabel lblVideos = new JLabel("Videos");
		
		JButton btnCancelar = new JButton("Cancelar");
		
		JButton btnAceptar = new JButton("Aceptar");
		
		JComboBox<String> comboBoxUsuario = new JComboBox<String>(modelUsuario);
		
		JComboBox<String> comboBoxVideos = new JComboBox<String>(modelVideos);
		comboBoxVideos.setEnabled(false);
		
		JRadioButton rdbtnListasPorDefecto = new JRadioButton("Listas por defecto",true);

		rdbtnListasPorDefecto.setEnabled(false);
		
		JRadioButton rdbtnListasParticulares = new JRadioButton("Listas particulares");
		rdbtnListasParticulares.setEnabled(false);
		grupoLista.add(rdbtnListasPorDefecto);
		grupoLista.add(rdbtnListasParticulares);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblListasDelUsuario = new JLabel("Listas del usuario");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnListasPorDefecto)
						.addComponent(lblVideos)
						.addComponent(lblNombreDeUsuario)
						.addComponent(lblListasDelUsuario))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBoxUsuario, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(rdbtnListasParticulares)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(comboBoxVideos, 0, 120, Short.MAX_VALUE)
								.addComponent(scrollPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(355, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(281, Short.MAX_VALUE)
					.addComponent(btnAceptar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCancelar)
					.addGap(191))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNombreDeUsuario)
						.addComponent(comboBoxUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(rdbtnListasPorDefecto)
							.addGap(17))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(rdbtnListasParticulares)
							.addGap(18)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(89)
							.addComponent(lblListasDelUsuario)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxVideos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblVideos))
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAceptar)
						.addComponent(btnCancelar))
					.addContainerGap(66, Short.MAX_VALUE))
		);
		
		JList<String> list = new JList<String>(listListas);
		
		list.addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent arg0) {
				if(!list.isSelectionEmpty()){
					comboBoxVideos.setEnabled(true);
					modelVideos.removeAllElements();
						cargarVideosListas(modelUsuario.getSelectedItem().toString(),list.getSelectedValue().toString(),rdbtnListasPorDefecto.isSelected());	
					}
				else{
					comboBoxVideos.setEnabled(false);
				}
			}
		});
		
		scrollPane.setViewportView(list);
		getContentPane().setLayout(groupLayout);
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelUsuario.removeAllElements();				
				modelVideos.removeAllElements();
				list.setEnabled(false);
				setVisible(false);
			}
		});
		
		
		comboBoxUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxUsuario.getSelectedItem() != ""){
					
					rdbtnListasPorDefecto.setEnabled(true);
					rdbtnListasParticulares.setEnabled(true);
					list.setEnabled(true);
					
					if(rdbtnListasPorDefecto.isSelected()){
						
						cargarDefectoListas();
					}
					if(rdbtnListasParticulares.isSelected()){
						
						cargarParticularListas();
					}
				}
				else{
					modelVideos.removeAllElements();
					rdbtnListasPorDefecto.setEnabled(false);
					rdbtnListasParticulares.setEnabled(false);
					list.setEnabled(false);
				}
			}
		});
		
		rdbtnListasPorDefecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelVideos.removeAllElements();
				cargarDefectoListas();
			}
		});
		
		rdbtnListasParticulares.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelVideos.removeAllElements();
				cargarParticularListas();
			}
		});
		
		btnAceptar.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				boolean checkUsuario = true;
				boolean checkVideo = true;

				if(comboBoxUsuario.getSelectedItem() == ""){
						JOptionPane.showMessageDialog(null, "No has seleccionado ningún usuario", "Error", JOptionPane.ERROR_MESSAGE);
						checkUsuario = false;
				}
				if(comboBoxVideos.getSelectedItem() == ""){
					JOptionPane.showMessageDialog(null, "No has seleccionado ningún video", "Error", JOptionPane.ERROR_MESSAGE);
					checkUsuario = false;
				}
				if(checkUsuario && checkVideo){
					ctrLis = Fabrica.getIListas();
					String stringConcatenado = modelVideos.getSelectedItem().toString();
					String ownerVideo = stringConcatenado.substring(0, stringConcatenado.indexOf('-'));
					String nombreVideo = stringConcatenado.substring(stringConcatenado.indexOf('-') + 1);
					ctrLis.quitarVideoLista(modelUsuario.getSelectedItem().toString(), nombreVideo, ownerVideo, list.getSelectedValue().toString(),
							rdbtnListasPorDefecto.isSelected());
					modelUsuario.removeAllElements();				
					modelVideos.removeAllElements();
					list.setEnabled(false);
					setVisible(false);
				}
			}
		});
	}
	
	public void cargarDefectoListas(){
		listListas.removeAllElements();
		
		ctrLis = Fabrica.getIListas();
		
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
		
		ctrLis = Fabrica.getIListas();
		
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
	
	public void cargarVideosListas(String usuario,String lista,boolean defecto){
		
		
		
		ctrUsu = Fabrica.getIUsuariosCanales();
		
	    String[] videos = ctrUsu.listarVideosDuenosLista(usuario, lista, defecto);
		int largov = videos.length;
		modelVideos.addElement("");
		for (int i = 0; i < largov; i++ ){
		  modelVideos.addElement(videos[i]);
		}
		ctrUsu = null;
		
	}
	
	public void cargarDatos(){
		
		ctrUsu = Fabrica.getIUsuariosCanales();
	    String[] usuarios = ctrUsu.listarUsuarios();
		int largou = usuarios.length;
		modelUsuario.addElement("");
		for (int i = 0; i < largou; i++ ){
		  modelUsuario.addElement(usuarios[i]);
		}
		ctrUsu = null;
	}
}

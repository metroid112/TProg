package internalFrames;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import interfaces.*;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class AgregarVideo extends JInternalFrame{
	
	private IUsuariosCanales ctrUsu;
	private IVideos ctrVid;
	private IListas ctrLis;
	
	private Fabrica fab;
	private DefaultComboBoxModel<String> modelUsuario = new DefaultComboBoxModel<String>();
	private DefaultComboBoxModel<String> modelVideos = new DefaultComboBoxModel<String>();
	private DefaultComboBoxModel<String> modelUsuObj = new DefaultComboBoxModel<String>();
	private DefaultComboBoxModel<String> modelListas = new DefaultComboBoxModel<String>();
	private DefaultListModel<String> listListas = new DefaultListModel<>();

	public AgregarVideo() {
		
		setTitle("Agregar video a lista de reproducci\u00F3n");
		setBounds(0, 0, 640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario");
		
		JLabel lblVideos = new JLabel("Videos");
		
		JLabel lblUsuario = new JLabel("Usuario");
		
		JComboBox comboBoxUsuario = new JComboBox(modelUsuario);
		
		JComboBox comboBoxVideos = new JComboBox(modelVideos);

		comboBoxVideos.setEnabled(false);
		
		JComboBox comboBoxUsuObj = new JComboBox(modelUsuObj);

		comboBoxUsuObj.setEnabled(false);
		
		JButton btnCancelar = new JButton("Cancelar");
		
		JButton btnAceptar = new JButton("Aceptar");
		
		JRadioButton rdbtnListasPordefecto = new JRadioButton("Listas por defecto");

		rdbtnListasPordefecto.setEnabled(false);
		rdbtnListasPordefecto.setSelected(true);
		
		JRadioButton rdbtnListasParticulares = new JRadioButton("Listas particulares");

		rdbtnListasParticulares.setEnabled(false);
		
		JScrollPane scrollPane = new JScrollPane();

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(450, Short.MAX_VALUE)
					.addComponent(btnAceptar)
					.addGap(18)
					.addComponent(btnCancelar)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNombreDeUsuario)
						.addComponent(lblVideos)
						.addComponent(lblUsuario))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnListasParticulares)
						.addComponent(rdbtnListasPordefecto)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(comboBoxUsuario, 0, 129, Short.MAX_VALUE)
							.addComponent(comboBoxVideos, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(comboBoxUsuObj, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap(350, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreDeUsuario)
						.addComponent(comboBoxUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVideos)
						.addComponent(comboBoxVideos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsuario)
						.addComponent(comboBoxUsuObj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnListasPordefecto)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnListasParticulares)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnAceptar))
					.addContainerGap())
		);
		
		JList list = new JList(listListas);
		list.setEnabled(false);
		scrollPane.setViewportView(list);
		getContentPane().setLayout(groupLayout);
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelUsuario.removeAllElements();
				modelVideos.removeAllElements();
				modelUsuObj.removeAllElements();
				modelListas.removeAllElements();
				rdbtnListasPordefecto.setEnabled(false);
				rdbtnListasPordefecto.setSelected(true);
				rdbtnListasParticulares.setEnabled(false);
				rdbtnListasParticulares.setSelected(false);
				setVisible(false);
			}
		});
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean checkUsuario = true;
				

				if(comboBoxUsuario.getSelectedItem() == ""){
						JOptionPane.showMessageDialog(null, "No has seleccionado ningún usuario", "Error", JOptionPane.ERROR_MESSAGE);
						checkUsuario = false;
				}
				if(checkUsuario){
					
					//agregarVideo(String video, String usuario, String lista);
					
					modelUsuario.removeAllElements();
					modelVideos.removeAllElements();
					modelUsuObj.removeAllElements();
					modelListas.removeAllElements();
					rdbtnListasPordefecto.setEnabled(false);
					rdbtnListasPordefecto.setSelected(true);
					rdbtnListasParticulares.setEnabled(false);
					rdbtnListasParticulares.setSelected(false);
					setVisible(false);
				}
				
			}
		});
		
		comboBoxUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxUsuario.getSelectedItem() != ""){
					
					modelVideos.removeAllElements();
					modelUsuObj.removeAllElements();
					cargarVideosUsuarios();
					comboBoxVideos.setEnabled(true);
					
				}
				else{ 
					comboBoxVideos.setEnabled(false);
					comboBoxUsuObj.setEnabled(false);
					rdbtnListasPordefecto.setEnabled(false);
					rdbtnListasParticulares.setEnabled(false);
					list.setEnabled(false);

				}
			}
		});
		
		comboBoxVideos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxVideos.getSelectedItem() != ""){
					
					modelUsuObj.removeAllElements();
					comboBoxUsuObj.setEnabled(true);
					cargarUsuarioObj();
					
				}
				else{
					
					comboBoxUsuObj.setEnabled(false);
					rdbtnListasPordefecto.setEnabled(false);
					rdbtnListasParticulares.setEnabled(false);
					list.setEnabled(false);
				}
			}
		});
		
		comboBoxUsuObj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxUsuObj.getSelectedItem() != ""){
					list.setEnabled(true);
					rdbtnListasPordefecto.setEnabled(true);
					rdbtnListasParticulares.setEnabled(true);
					
					if(rdbtnListasPordefecto.isSelected()){
						listListas.removeAllElements();
						cargarDefectoListas();
					}
					if(rdbtnListasParticulares.isSelected()){
						listListas.removeAllElements();
						cargarParticularListas();
					}
				}
				else{
					list.setEnabled(false);
					rdbtnListasPordefecto.setEnabled(false);
					rdbtnListasParticulares.setEnabled(false);
				}
			}
		});
		
		rdbtnListasPordefecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnListasParticulares.setSelected(false);
				listListas.removeAllElements();
				cargarDefectoListas();
			}
		});
		
		rdbtnListasParticulares.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnListasPordefecto.setSelected(false);
				listListas.removeAllElements();
				cargarParticularListas();
			}
		});
		
	}
	
	
	
	public void cargarVideosUsuarios(){
		
		fab = Fabrica.getFabrica();
		ctrVid = fab.getIVideos();
		 
		if(modelUsuario.getSelectedItem() != null){
			
			String s = modelUsuario.getSelectedItem().toString();
			
		    String[] videos = ctrVid.listarVideos(s);
		    
			int largov = videos.length;
			
			modelVideos.addElement("");
			for (int i = 0; i < largov; i++ ){
			  modelVideos.addElement(videos[i]);
			}
		}
		ctrVid = null;
		
	}
	
	public void cargarUsuarioObj(){
		
		fab = Fabrica.getFabrica();
		ctrUsu = fab.getIUsuariosCanales();
	    String[] usuarios = ctrUsu.listarUsuarios();
		int largou = usuarios.length;
		modelUsuObj.addElement("");
		for (int i = 0; i < largou; i++ ){
		  modelUsuObj.addElement(usuarios[i]);
		}
		ctrUsu = null;
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
		fab = Fabrica.getFabrica();
		ctrLis = fab.getIListas();
		
		if(modelUsuObj.getSelectedItem() != null){
			
			String s = modelUsuObj.getSelectedItem().toString();
			
		    String[] listas = ctrLis.listarListasDefectoUsuario(s);
		    
			int largol = listas.length;
			
			for (int i = 0; i < largol; i++ ){
			  listListas.addElement(listas[i]);
			}
		}
			
		ctrLis = null;
	}
	
	public void cargarParticularListas(){
		fab = Fabrica.getFabrica();
		ctrLis = fab.getIListas();
		
		if(modelUsuObj.getSelectedItem() != null){
			
			String s = modelUsuObj.getSelectedItem().toString();
			
		    String[] listas = ctrLis.listarListasParticularUsuario(s);
		    
			int largol = listas.length;
			
			
			for (int i = 0; i < largol; i++ ){
			  listListas.addElement(listas[i]);
			}
		}
			
		ctrLis = null;
	}
}

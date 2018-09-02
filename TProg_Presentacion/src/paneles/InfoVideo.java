package paneles;

import javax.swing.JPanel;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.LinkedHashMap;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

import dataTypes.DtCalificacion;
import dataTypes.DtComentario;

import dataTypes.DtVideo;
import interfaces.IVideos;

import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JList;

public class InfoVideo extends JPanel {
	private IVideos contVideo;
	private JLabel lblVnombre, lblVduracion, lblVfecha, lblVvisibilidad, lblVcategoria, lblVurl;
	private JTextArea textVdescripcion;
	private JTree tree;
	private JScrollPane scrollPane2;
	private JList<String> listaValoraciones;


	/**
	 * Create the panel.
	 */
	public InfoVideo(IVideos contVideo) {
		
		this.contVideo = contVideo;
		
		JLabel lblNombre = new JLabel("Nombre:");
		
		JLabel lblDuracion = new JLabel("Duracion:");
		
		JLabel lblVisibilidad = new JLabel("Visibilidad:");
		
		JLabel lblFecha = new JLabel("Fecha:");
		
		JLabel lblCategoria = new JLabel("Categoria:");
		
		JLabel lblUrl = new JLabel("URL:");
		
		JScrollPane scrollPane = new JScrollPane();
		
		lblVnombre = new JLabel("vNombre");
		
		textVdescripcion = new JTextArea("vDescripcion");
		textVdescripcion.setWrapStyleWord(true);
		textVdescripcion.setLineWrap(true);
		textVdescripcion.setEditable(false);
		
		scrollPane2 = new JScrollPane(textVdescripcion);
		
		lblVduracion = new JLabel("vDuracion");
		
		lblVfecha = new JLabel("vFecha");
		
		lblVvisibilidad = new JLabel("vVisibilidad");
		
		lblVcategoria = new JLabel("vCategoria");
		
		lblVurl = new JLabel("vURL");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(17)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombre)
								.addComponent(lblDuracion)
								.addComponent(lblVisibilidad)
								.addComponent(lblFecha)
								.addComponent(lblCategoria)
								.addComponent(lblUrl))
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblVurl)
								.addComponent(lblVcategoria)
								.addComponent(lblVfecha)
								.addComponent(lblVvisibilidad)
								.addComponent(lblVduracion)
								.addComponent(lblVnombre))))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
						.addComponent(scrollPane_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombre)
								.addComponent(lblVnombre))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDuracion)
								.addComponent(lblVduracion))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblVisibilidad)
								.addComponent(lblVvisibilidad))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFecha)
								.addComponent(lblVfecha))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCategoria)
								.addComponent(lblVcategoria))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUrl)
								.addComponent(lblVurl))))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane2)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
					.addGap(29))
		);
		
		JLabel lblValoraciones = new JLabel("Valoraciones");
		scrollPane_1.setColumnHeaderView(lblValoraciones);
		
		listaValoraciones = new JList<String>();
		scrollPane_1.setViewportView(listaValoraciones);
		
		JLabel lblDecripcion = new JLabel("Descripcion");
		scrollPane2.setColumnHeaderView(lblDecripcion);
		

		tree = new JTree();

		scrollPane.setViewportView(tree);
		
		JLabel lblComentarios = new JLabel("Comentarios");
		scrollPane.setColumnHeaderView(lblComentarios);
		setLayout(groupLayout);

	}
	
	public void cargarDatos(DtVideo dtVid) {
		lblVnombre.setText(dtVid.nombre);
		textVdescripcion.setText(dtVid.descripcion);
		lblVurl.setText(dtVid.URL);
		if (dtVid.visible) {
			lblVvisibilidad.setText("Publico");
		} else {
			lblVvisibilidad.setText("Privado");
		}
		lblVcategoria.setText(dtVid.categoria);
		Duration duracion = dtVid.duracion;
		int horas = (int) duracion.toHours();
		duracion = duracion.minusHours((long) horas);
		int min = (int) duracion.toMinutes();
		duracion = duracion.minusMinutes((long) min);
		int seg = (int) duracion.getSeconds();
		lblVduracion.setText(String.format("%d:%02d:%02d", horas, min, seg)); 	// Formato?
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		lblVfecha.setText(dateFormat.format(dtVid.fecha));
		
		DefaultListModel<String> modeloLista = new DefaultListModel<String>();
		if (!dtVid.calificaciones.isEmpty()) {
			for (DtCalificacion cal : dtVid.calificaciones) {
				modeloLista.addElement(cal.getUsuario() + " - " + cal.getLikeParsed());
			}
		} else {
			modeloLista.addElement("Sin calificaciones");
		}
		listaValoraciones.setModel(modeloLista);
		
		DefaultMutableTreeNode raiz = loadComentarios(dtVid.comentarios, dtVid.nombre);
		DefaultTreeModel model = new DefaultTreeModel(raiz);
		tree.setModel(model);
		
	}
	
	public DefaultMutableTreeNode loadComentarios(LinkedHashMap<Integer, DtComentario> coments, String nombreVideo) {
		DefaultMutableTreeNode nodo, raiz;
		raiz = new DefaultMutableTreeNode(nombreVideo);
		for (DtComentario com : coments.values()) {
			nodo = getNode(com);
			raiz.add(nodo);
		}
		return raiz;
	}
	
	public DefaultMutableTreeNode getNode(DtComentario comentario) {
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(comentario.getString());
		for (DtComentario hijo : comentario.hijos.values()) {
			DefaultMutableTreeNode nodoHijo = getNode(hijo);		// Recursion
			nodo.add(nodoHijo);
		}
		return nodo;

	}
}

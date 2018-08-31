package paneles;

import javax.swing.JPanel;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.LinkedHashMap;


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

import dataTypes.DtComentario;

import dataTypes.DtVideo;
import interfaces.IVideos;

import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JRadioButton;

public class InfoVideo extends JPanel {
	private IVideos contVideo;
	private JLabel lblVnombre, lblVdescripcion, lblVduracion, lblVfecha, lblVvisibilidad, lblVcategoria, lblVurl;

	private JTree tree;


	/**
	 * Create the panel.
	 */
	public InfoVideo(IVideos contVideo) {
		
		this.contVideo = contVideo;
		
		JLabel lblNombre = new JLabel("Nombre:");
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		
		JLabel lblDuracion = new JLabel("Duracion:");
		
		JLabel lblVisibilidad = new JLabel("Visibilidad:");
		
		JLabel lblFecha = new JLabel("Fecha:");
		
		JLabel lblCategoria = new JLabel("Categoria:");
		
		JLabel lblUrl = new JLabel("URL:");
		
		JScrollPane scrollPane = new JScrollPane();
		
		lblVnombre = new JLabel("vNombre");
		
		lblVdescripcion = new JLabel("vDescripcion");
		
		lblVduracion = new JLabel("vDuracion");
		
		lblVfecha = new JLabel("vFecha");
		
		lblVvisibilidad = new JLabel("vVisibilidad");
		
		lblVcategoria = new JLabel("vCategoria");
		
		lblVurl = new JLabel("vURL");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDescripcion)
								.addComponent(lblNombre)
								.addComponent(lblDuracion)
								.addComponent(lblVisibilidad)
								.addComponent(lblFecha)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblCategoria))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblUrl)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblVurl)
								.addComponent(lblVcategoria)
								.addComponent(lblVfecha)
								.addComponent(lblVvisibilidad)
								.addComponent(lblVduracion)
								.addComponent(lblVnombre)
								.addComponent(lblVdescripcion)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(35)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(lblVnombre))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescripcion)
						.addComponent(lblVdescripcion))
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
						.addComponent(lblVurl))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		

		tree = new JTree();

		scrollPane.setColumnHeaderView(tree);
		setLayout(groupLayout);

	}
	
	public void cargarDatos(DtVideo dtVid) {
		lblVnombre.setText(dtVid.getNombre());
		lblVdescripcion.setText(dtVid.getDescripcion());
		lblVurl.setText(dtVid.getURL());
		if (dtVid.isVisible()) {
			lblVvisibilidad.setText("Publico");
		} else {
			lblVvisibilidad.setText("Privado");
		}
		lblVcategoria.setText(dtVid.getCategoria());
		Duration duracion = dtVid.getDuracion();
		int horas = (int) duracion.toHours();
		duracion = duracion.minusHours((long) horas);
		int min = (int) duracion.toMinutes();
		duracion = duracion.minusMinutes((long) min);
		int seg = (int) duracion.getSeconds();
		lblVduracion.setText(String.format("%d:%02d:%02d", horas, min, seg)); 	// Formato?
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		lblVfecha.setText(dateFormat.format(dtVid.getFecha()));

		
		DefaultMutableTreeNode raiz = loadComentarios(dtVid.getComents(), dtVid.getNombre());
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
		for (DtComentario hijo : comentario.getHijos().values()) {
			DefaultMutableTreeNode nodoHijo = getNode(hijo);		// Recursion
			nodo.add(nodoHijo);
		}
		return nodo;

	}
}

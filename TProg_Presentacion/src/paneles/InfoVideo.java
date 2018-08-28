package paneles;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class InfoVideo extends JPanel {

	/**
	 * Create the panel.
	 */
	public InfoVideo() {
		
		JLabel lblNombre = new JLabel("Nombre:");
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		
		JLabel lblDuracion = new JLabel("Duracion:");
		
		JLabel lblVisibilidad = new JLabel("Visibilidad:");
		
		JLabel lblFecha = new JLabel("Fecha:");
		
		JLabel lblCategoria = new JLabel("Categoria:");
		
		JLabel lblUrl = new JLabel("URL:");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUrl)
						.addComponent(lblCategoria)
						.addComponent(lblFecha)
						.addComponent(lblVisibilidad)
						.addComponent(lblDuracion)
						.addComponent(lblDescripcion)
						.addComponent(lblNombre))
					.addContainerGap(360, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addComponent(lblNombre)
					.addGap(18)
					.addComponent(lblDescripcion)
					.addGap(18)
					.addComponent(lblDuracion)
					.addGap(18)
					.addComponent(lblVisibilidad)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblFecha)
					.addGap(18)
					.addComponent(lblCategoria)
					.addGap(18)
					.addComponent(lblUrl)
					.addContainerGap(62, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}

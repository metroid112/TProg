
public class ListaParticular extends Lista {
	private boolean visible;
	
	public ListaParticular() {}

	public ListaParticular(String nombre, Canal canal, Video[] videos, Categoria[] categorias, boolean visible) {
		super(nombre, canal, videos, categorias);
		this.visible = visible;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}	
}

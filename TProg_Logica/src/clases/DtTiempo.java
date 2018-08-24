package clases;

// Pato: Se sustituye por Date?
public class DtTiempo {

	private int anio;
	private int mes;
	private int dia;
	private int hora;
	private int minuto;
	private int segundo;

	public DtTiempo(int anio, int mes, int dia, int hora, int minuto, int segundo) {
		this.anio = anio;
		this.mes = mes;
		this.dia = dia;
		this.hora = hora;
		this.minuto = minuto;
		this.segundo = segundo;
	}

	public int getAnio() {
		return anio;
	}

	public int getMes() {
		return mes;
	}

	public int getDia() {
		return dia;
	}

	public int getHora() {
		return hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public int getSegundo() {
		return segundo;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	public void setSegundo(int segundo) {
		this.segundo = segundo;
	}
}

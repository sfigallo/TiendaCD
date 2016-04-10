package Capa_de_Entidades;

public class Descuento {
	private int codDescuento;
	private float montoASuperar;
	private float porcentaje;
	public int getCodDescuento() {
		return codDescuento;
	}
	public void setCodDescuento(int codDescuento) {
		this.codDescuento = codDescuento;
	}
	public float getMontoASuperar() {
		return montoASuperar;
	}
	public void setMontoASuperar(float montoASuperar) {
		this.montoASuperar = montoASuperar;
	}
	public float getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}
}

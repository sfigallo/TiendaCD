package Capa_de_Entidades;

import java.util.ArrayList;

public class Venta {
	private int nroVenta;
	private String estado;
	private float monto;
	private Usuario usuario;
	private ArrayList<Disco> discos;
	
	public int getNroVenta() {
		return nroVenta;
	}
	public void setNroVenta(int nroVenta) {
		this.nroVenta = nroVenta;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public ArrayList<Disco> getDiscos() {
		return discos;
	}
	public void setDiscos(ArrayList<Disco> discos) {
		this.discos = discos;
	}
	

}

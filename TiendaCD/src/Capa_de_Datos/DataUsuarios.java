package Capa_de_Datos;

import java.sql.*;
import java.util.ArrayList;

import Capa_de_Entidades.Descuento;
import Capa_de_Entidades.Disco;
import Capa_de_Entidades.TipoUsuario;
import Capa_de_Entidades.Usuario;
import Capa_de_Entidades.Venta;

public class DataUsuarios {
   
	//NO TIENE STORED PROCEDURE
	public static ArrayList<Usuario> getUsuarios(){
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "select * from usuario;";
		Connection con = FactoriaConexion.getInstancia().getConexion();
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			ResultSet rs = comando.executeQuery();
			while(rs.next()){
				Usuario u = new Usuario();
				u.setUsuario(rs.getString(1));
				u.setContraseña(rs.getString(2));
				u.setNombre(rs.getString(3));
				u.setApellido(rs.getString(4));
				u.setDni(rs.getInt(5));
				u.getTipo().setCodTipoUsuario(rs.getInt(6));
				usuarios.add(u);
			}
			for (Usuario usuario : usuarios) {
				TipoUsuario tu = getTipoUsuario(usuario.getTipo().getCodTipoUsuario());
				usuario.setTipo(tu);
				usuario.setDiscosAValorar(getDiscosAValorar(usuario.getUsuario()));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoriaConexion.getInstancia().releaseConexion();
		return usuarios;
	}

	public static Usuario getUsuario(String usuario){
		Usuario u = null;
		String sql = "call getUsuarioxUsuario(?);";
		Connection con = FactoriaConexion.getInstancia().getConexion();
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, usuario);
			ResultSet rs = comando.executeQuery();
			if(rs.next()){
				u = new Usuario();
				u.setUsuario(rs.getString(1));
				u.setContraseña(rs.getString(2));
				u.setNombre(rs.getString(3));
				u.setApellido(rs.getString(4));
				u.setDni(rs.getInt(5));
				u.getTipo().setCodTipoUsuario(rs.getInt(6));
				TipoUsuario tu = getTipoUsuario(u.getTipo().getCodTipoUsuario());
				u.setTipo(tu);
				u.setDiscosAValorar(getDiscosAValorar(u.getUsuario()));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoriaConexion.getInstancia().releaseConexion();
		return u;
	}
	
	//NO TIENE STORED PROCEDURE
	public static void addUsuario(Usuario u){
		Connection con = FactoriaConexion.getInstancia().getConexion();
		String sql = "INSERT INTO `tiendacd`.`usuario` (`usuario`, `contrasenia`, `nombre`, `apellido`, `dni`, "
				+ "`codTipoUsuario`) VALUES (?, ?, ?, ?, ?, '1');";
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, u.getUsuario());
			comando.setString(2, u.getContraseña());
			comando.setString(3, u.getNombre());
			comando.setString(4, u.getApellido());
			comando.setInt(5, u.getDni());
			comando.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoriaConexion.getInstancia().releaseConexion();
	}

	public static void removeUsuario(String usuario){
		Connection con = FactoriaConexion.getInstancia().getConexion();
		String sql = "call tiendacd.removeUsuario(?);";
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, usuario);
			comando.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoriaConexion.getInstancia().releaseConexion();
	}

	public static TipoUsuario getTipoUsuario(int codigo) {
		TipoUsuario tu = null;
		Connection con = FactoriaConexion.getInstancia().getConexion();
		String sql = "call getTipoUsuarioxCodTipoUsuario(?);";
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setInt(1, codigo);
			ResultSet rs = comando.executeQuery();
			if(rs.next()){
				tu = new TipoUsuario();
				tu.setCodTipoUsuario(codigo);
				tu.setNombre(rs.getString(2));
				tu.setDescPermisos(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoriaConexion.getInstancia().releaseConexion();
		return tu;
	}
	private static ArrayList<Disco> getDiscosAValorar(String usuario){
		ArrayList<Disco> discos = new ArrayList<Disco>();
		String sql = "call getDiscosAValorar(?)";
		Connection con = FactoriaConexion.getInstancia().getConexion();
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, usuario);
			ResultSet rs = comando.executeQuery();
			while(rs.next()){
				Disco d = new Disco();
				d.setCodDisco(rs.getInt("codDisco"));
				discos.add(d);
			}
			for (Disco disco : discos) {
				disco = DataDiscos.getDisco(disco.getCodDisco());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoriaConexion.getInstancia().releaseConexion();
		return discos;
	}
	public static ArrayList<Venta> getVentas (Usuario usuario){
		ArrayList<Venta> ventas = new ArrayList<Venta>();
		Connection con = FactoriaConexion.getInstancia().getConexion();
		String sql = "call getVentasxUsuario(?);";
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, usuario.getUsuario());
			ResultSet rs = comando.executeQuery(); //nroVenta monto usuario codDescuento
			while(rs.next()){
				Venta v = new Venta();
				v.setNroVenta(rs.getInt("nroVenta"));
				v.setMonto(rs.getFloat("monto"));
				v.getUsuario().setUsuario(rs.getString("usuario"));
				v.getDescuento().setCodDescuento(rs.getInt("codDescuento"));
				ventas.add(v);
			}
			for (Venta venta : ventas) {
				venta.setDiscos(DataDiscos.getDiscosxVenta(venta.getNroVenta()));
				venta.setUsuario(DataUsuarios.getUsuario(venta.getUsuario().getUsuario()));
				venta.setDescuento(DataUsuarios.getDescuento(venta.getDescuento().getCodDescuento()));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoriaConexion.getInstancia().getConexion();
		return ventas;
	}

	//NO TIENE STORED PROCEDURE
	public static Descuento getDescuento(int codDescuento) {
		Descuento desc = null;
		String sql = "select * from descuento where codDescuento = ?;";
		Connection con = FactoriaConexion.getInstancia().getConexion();
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setInt(1, codDescuento);
			ResultSet rs = comando.executeQuery();
			if(rs.next()){
				desc = new Descuento();
				desc.setCodDescuento(codDescuento);
				desc.setMontoASuperar(rs.getFloat("montoASuperar"));
				desc.setPorcentaje(rs.getFloat("porcentaje"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return desc;
	}
	
}

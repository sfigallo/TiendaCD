package Capa_de_Datos;

import java.sql.*;
import java.util.ArrayList;
import Capa_de_Entidades.TipoUsuario;
import Capa_de_Entidades.Usuario;

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
				u.setFechaNac(rs.getDate(5));
				u.setDni(rs.getInt(6));
				TipoUsuario tu = getTipoUsuario(rs.getInt(7));
				u.setTipo(tu);
				usuarios.add(u);
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
				u.setFechaNac(rs.getDate(5));
				u.setDni(rs.getInt(6));
				TipoUsuario tu = getTipoUsuario(rs.getInt(7));
				u.setTipo(tu);
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
		String sql = "insert into usuario values (?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, u.getUsuario());
			comando.setString(2, u.getContraseña());
			comando.setString(3, u.getNombre());
			comando.setString(4, u.getApellido());
			comando.setDate(5, (java.sql.Date)u.getFechaNac());
			comando.setInt(6, u.getDni());
			comando.setInt(7, u.getTipo().getCodTipoUsuario());
			comando.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoriaConexion.getInstancia().releaseConexion();
	}

	public static void removeUsuario(String usuario){
		Connection con = FactoriaConexion.getInstancia().getConexion();
		String sql = "call removeUsuario(?);";
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, usuario);
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
	
	
}

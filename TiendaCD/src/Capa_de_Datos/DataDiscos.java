package Capa_de_Datos;

import java.sql.*;
import java.util.ArrayList;

import Capa_de_Entidades.Autor;
import Capa_de_Entidades.Disco;
import Capa_de_Entidades.GeneroMusical;

public class DataDiscos {
	
	public static ArrayList<Disco> getDiscosxAutor(String autor){
		ArrayList<Disco> discos = new ArrayList<Disco>();;
		String sql = "call getDiscosxNombreAutor(?);";
		Connection con = FactoriaConexion.getInstancia().getConexion();
		try {
			PreparedStatement comando= con.prepareStatement(sql);
			comando.setString(1, autor);
			ResultSet rs = comando.executeQuery();
			while(rs.next()){
				Disco d = new Disco();
				d.setCodDisco(rs.getInt("codDisco"));
				d.setTitulo(rs.getString("titulo"));
				d.setAñoLanzamiento(rs.getInt("anioLanzamiento"));
				d.setCantCopiasDisp(rs.getInt("cantCopiasDisp"));
				d.setPrecio(rs.getFloat("precio"));
				GeneroMusical gm = getGenero(rs.getInt("codGenero"));
				d.setGenero(gm);  //codGenero
				Autor au = getAutor(rs.getInt("codAutor"));
				d.setAutor(au);
				discos.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		FactoriaConexion.getInstancia().releaseConexion();
		return discos;
	}
	
	private static Autor getAutor(int codigo) {
		Autor au = null;
		String sql = "call getAutor(?);";
		Connection con = FactoriaConexion.getInstancia().getConexion();
			PreparedStatement comando;
			try {
				comando = con.prepareStatement(sql);
				comando.setInt(1, codigo);
				ResultSet rs = comando.executeQuery();
				if (rs.next()) {
					au = new Autor();
					au.setCodAutor(codigo);
					au.setNombreAutor(rs.getString("nombreAutor"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FactoriaConexion.getInstancia().releaseConexion();
			return au;
	}

	private static GeneroMusical getGenero(int codigo) {
		GeneroMusical gm = null;
		String sql = "call getGenero(?);";
		Connection con = FactoriaConexion.getInstancia().getConexion();
			PreparedStatement comando;
			try {
				comando = con.prepareStatement(sql);
				comando.setInt(1, codigo);
				ResultSet rs = comando.executeQuery();
				if (rs.next()) {
					gm = new GeneroMusical();
					gm.setCodGenero(codigo);
					gm.setDescGenero(rs.getString("descGenero"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FactoriaConexion.getInstancia().releaseConexion();
			return gm;
	}

	public static ArrayList<Disco> getDiscosxGenero(String genero){
		ArrayList<Disco> discos = null;
		
		return discos;
	}

	public static ArrayList<Disco> getDiscosxNombre(String cadena) {
		ArrayList<Disco> discos = null;
		
		return discos;
	}
	

}

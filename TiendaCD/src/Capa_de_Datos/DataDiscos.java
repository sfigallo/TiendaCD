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
	
	public static ArrayList<Disco> getDiscosxGenero(String genero){
		ArrayList<Disco> discos = new ArrayList<Disco>();
		String sql = "call getDiscosxDescGenero(?);";
		Connection con = FactoriaConexion.getInstancia().getConexion();
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, genero);
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

	public static ArrayList<Disco> getDiscosxTitulo(String cadena) {
		ArrayList<Disco> discos = new ArrayList<Disco>();
		String sql = "call getDiscosxTitulo(?);";
		Connection con = FactoriaConexion.getInstancia().getConexion();
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, cadena);
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

	public static ArrayList<Disco> getDiscosxAutor(int codigo){
		ArrayList<Disco> discos = new ArrayList<Disco>();
		String sql = "call getDiscosxCodAutor(?);";
		Connection con = FactoriaConexion.getInstancia().getConexion();
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setInt(1, codigo);
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
	
	public static ArrayList<Disco> getDiscosxGenero(int codigo){
		ArrayList<Disco> discos = new ArrayList<Disco>();
		String sql = "call getDiscosxCodGenero(?);";
		Connection con = FactoriaConexion.getInstancia().getConexion();
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setInt(1, codigo);
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
	
	//NO TIENE STORED PROCEDURE
	public static ArrayList<Autor> getAutores(){
		ArrayList<Autor> autores = new ArrayList<Autor>();
		String sql = "select * from autor;";
		Connection con = FactoriaConexion.getInstancia().getConexion();
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			ResultSet rs = comando.executeQuery();
			while(rs.next()){
				Autor au = new Autor();
				au.setCodAutor(rs.getInt("codAutor"));
				au.setNombreAutor(rs.getString("nombreAutor"));
				autores.add(au);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoriaConexion.getInstancia().releaseConexion();
		return autores;
	}
	
 	public static Autor getAutor(int codigo) {
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
 	
 	//NO TIENE STORED PROCEDURE
 	public static ArrayList<GeneroMusical> getGeneros(){
		ArrayList<GeneroMusical> generos = new ArrayList<GeneroMusical>();
		String sql = "select * from genero_musical;";
		Connection con = FactoriaConexion.getInstancia().getConexion();
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			ResultSet rs = comando.executeQuery();
			while(rs.next()){
				GeneroMusical gm = new GeneroMusical();
				gm.setCodGenero(rs.getInt("codGenero"));
				gm.setDescGenero(rs.getString("descGenero"));
				generos.add(gm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoriaConexion.getInstancia().releaseConexion();
		return generos;
 	}
 	
	public static GeneroMusical getGenero(int codigo) {
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

	//NO TIENE STORED PROCEDURE
	public static ArrayList<Disco> getDiscos(){
		ArrayList<Disco> discos = new ArrayList<Disco>();;
		String sql = "select * from disco;";
		Connection con = FactoriaConexion.getInstancia().getConexion();
		try {
			PreparedStatement comando= con.prepareStatement(sql);
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
	
	public static Disco getDisco(int codigo){
		Disco d = null;
		String sql = "call getDisco(?);";
		Connection con = FactoriaConexion.getInstancia().getConexion();
			PreparedStatement comando;
			try {
				comando = con.prepareStatement(sql);
				comando.setInt(1, codigo);
				ResultSet rs = comando.executeQuery();
				if (rs.next()) {
					d = new Disco();
					d.setCodDisco(codigo);
					d.setTitulo(rs.getString("titulo"));
					d.setAñoLanzamiento(rs.getInt("anioLanzamiento"));
					d.setCantCopiasDisp(rs.getInt("cantCopiasDisp"));
					d.setPrecio(rs.getFloat("precio"));
					GeneroMusical gm = getGenero(rs.getInt("codGenero"));
					d.setGenero(gm);  //codGenero
					Autor au = getAutor(rs.getInt("codAutor"));
					d.setAutor(au);		
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FactoriaConexion.getInstancia().releaseConexion();
			return d;
	}
	
	//NO TIENE STORED PROCEDURE
	public static void addDisco (Disco disco){
		Connection con = FactoriaConexion.getInstancia().getConexion();
		String sql = "insert into disco (titulo, anioLanzamiento,"
				+ " cantCopiasDisp, precio, codGenero, codAutor) values (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			//el codDisco es auto-incremental
			comando.setString(1, disco.getTitulo());						//titulo
			comando.setInt(2, disco.getAñoLanzamiento());					//anioLanzamiento
			comando.setInt(3, disco.getCantCopiasDisp());					//cantCopiasDisp
			comando.setFloat(4, disco.getPrecio());							//precio
			comando.setInt(5, disco.getGenero().getCodGenero());			//codGenero
			comando.setInt(6, disco.getAutor().getCodAutor());				//codAutor
			comando.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoriaConexion.getInstancia().releaseConexion();
	}

	//NO TIENE STORED PROCEDURE
	public static void updateDisco (Disco disco){
		Connection con = FactoriaConexion.getInstancia().getConexion();
		String sql = "update disco set titulo = ?, anioLanzamiento = ?, "
				+ "cantCopiasDisp = ?, precio = ?, codGenero = ?, codAutor = ?"
				+ "where codDisco = ?;";
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, disco.getTitulo());
			comando.setInt(2, disco.getAñoLanzamiento());
			comando.setInt(3, disco.getCantCopiasDisp());
			comando.setFloat(4, disco.getPrecio());
			comando.setInt(5, disco.getGenero().getCodGenero());
			comando.setInt(6, disco.getAutor().getCodAutor());
			comando.setInt(7, disco.getCodDisco());
			comando.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoriaConexion.getInstancia().releaseConexion();
	}

	public static void removeDisco (int codDisco){
		Connection con = FactoriaConexion.getInstancia().getConexion();
		String sql = "call removeDisco(?);";
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setInt(1, codDisco);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoriaConexion.getInstancia().releaseConexion();
	}
}

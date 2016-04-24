package Capa_de_Datos;

import java.sql.*;
import java.util.ArrayList;

import Capa_de_Entidades.Autor;
import Capa_de_Entidades.Descuento;
import Capa_de_Entidades.Disco;
import Capa_de_Entidades.GeneroMusical;
import Capa_de_Entidades.Usuario;
import Capa_de_Entidades.Venta;

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
				d.getGenero().setCodGenero(rs.getInt("codGenero"));
				d.getAutor().setCodAutor(rs.getInt("codAutor"));
				discos.add(d);
			}
			for (Disco disco : discos) {
				disco.getGenero().setDescGenero(getGenero(disco.getGenero().getCodGenero()).getDescGenero());
				disco.getAutor().setNombreAutor(getAutor(disco.getAutor().getCodAutor()).getNombreAutor());
				disco.setValoracion(calcularValoracion(disco.getCodDisco()));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		FactoriaConexion.getInstancia().releaseConexion();;
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
				d.getGenero().setCodGenero(rs.getInt("codGenero"));
				d.getAutor().setCodAutor(rs.getInt("codAutor"));
				discos.add(d);
			}
			for (Disco disco : discos) {
				disco.getGenero().setDescGenero(getGenero(disco.getGenero().getCodGenero()).getDescGenero());
				disco.getAutor().setNombreAutor(getAutor(disco.getAutor().getCodAutor()).getNombreAutor());
				disco.setValoracion(calcularValoracion(disco.getCodDisco()));
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
				d.getGenero().setCodGenero(rs.getInt("codGenero"));
				d.getAutor().setCodAutor(rs.getInt("codAutor"));
				discos.add(d);
			}
			for (Disco disco : discos) {
				disco.getGenero().setDescGenero(getGenero(disco.getGenero().getCodGenero()).getDescGenero());
				disco.getAutor().setNombreAutor(getAutor(disco.getAutor().getCodAutor()).getNombreAutor());
				disco.setValoracion(calcularValoracion(disco.getCodDisco()));
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
				d.getGenero().setCodGenero(rs.getInt("codGenero"));
				d.getAutor().setCodAutor(rs.getInt("codAutor"));
				discos.add(d);
			}
			for (Disco disco : discos) {
				disco.getGenero().setDescGenero(getGenero(disco.getGenero().getCodGenero()).getDescGenero());
				disco.getAutor().setNombreAutor(getAutor(disco.getAutor().getCodAutor()).getNombreAutor());
				disco.setValoracion(calcularValoracion(disco.getCodDisco()));
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
				d.getGenero().setCodGenero(rs.getInt("codGenero"));
				d.getAutor().setCodAutor(rs.getInt("codAutor"));
				discos.add(d);
			}
			for (Disco disco : discos) {
				disco.getGenero().setDescGenero(getGenero(disco.getGenero().getCodGenero()).getDescGenero());
				disco.getAutor().setNombreAutor(getAutor(disco.getAutor().getCodAutor()).getNombreAutor());
				disco.setValoracion(calcularValoracion(disco.getCodDisco()));
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
 	
 	public static Autor getAutor(String cadena){
 		Autor au = null;
		String sql = "call getAutorxNombreAutor(?);";
		Connection con = FactoriaConexion.getInstancia().getConexion();
			PreparedStatement comando;
			try {
				comando = con.prepareStatement(sql);
				comando.setString(1, cadena);
				ResultSet rs = comando.executeQuery();
				if (rs.next()) {
					au = new Autor();
					au.setCodAutor(rs.getInt("codAutor"));
					au.setNombreAutor(rs.getString("nombreAutor"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FactoriaConexion.getInstancia().releaseConexion();
			return au;
	}
 	
 	public static ArrayList<Autor> getAutoresxNombre (String nombre){
 		ArrayList<Autor> autores = new ArrayList<Autor>();
 		String sql = "call getAutoresxNombreAutor(?);";
 		Connection con = FactoriaConexion.getInstancia().getConexion();
 		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, nombre);
			ResultSet rs = comando.executeQuery();
			while (rs.next()){
				Autor au = new Autor();
				au.setCodAutor(rs.getInt("codAutor"));
				au.setNombreAutor(rs.getString("nombreAutor"));
				autores.add(au);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
 		FactoriaConexion.getInstancia().releaseConexion();
 		return autores;
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


	public static ArrayList<Disco> getDiscos(){
		ArrayList<Disco> discos = new ArrayList<Disco>();;
		String sql = "call getDiscos();";
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
				d.getGenero().setCodGenero(rs.getInt("codGenero"));
				d.getAutor().setCodAutor(rs.getInt("codAutor"));
				discos.add(d);
			}
			for (Disco disco : discos) {
				disco.getGenero().setDescGenero(getGenero(disco.getGenero().getCodGenero()).getDescGenero());
				disco.getAutor().setNombreAutor(getAutor(disco.getAutor().getCodAutor()).getNombreAutor());
				disco.setValoracion(calcularValoracion(disco.getCodDisco()));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		FactoriaConexion.getInstancia().releaseConexion();;
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
					d.getGenero().setCodGenero(rs.getInt("codGenero"));
					d.getAutor().setCodAutor(rs.getInt("codAutor"));
					d.getGenero().setDescGenero(getGenero(d.getGenero().getCodGenero()).getDescGenero());
					d.getAutor().setNombreAutor(getAutor(d.getAutor().getCodAutor()).getNombreAutor());
					d.setValoracion(calcularValoracion(d.getCodDisco()));
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
		String sql = "UPDATE `tiendacd`.`disco` SET `titulo`=?, `anioLanzamiento`=?, "
				+ "`cantCopiasDisp`=?, `precio`=?, `codGenero`=?, `codAutor`=?"
				+ " WHERE `codDisco`=?;";
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
			comando.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoriaConexion.getInstancia().releaseConexion();
	}

	public static ArrayList<GeneroMusical> getGenerosxDescripcion(String cadena) {
		ArrayList<GeneroMusical> generos = new ArrayList<GeneroMusical>();
		Connection con = FactoriaConexion.getInstancia().getConexion();
		String sql = "call getGenerosxDescripcion(?);";
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, cadena);
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

	//NO TIENE STORED PROCEDURE
	public static void addGenero(GeneroMusical genero) {
		Connection con = FactoriaConexion.getInstancia().getConexion();
		String sql = "insert into genero_musical values (?,?);";
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setInt(1, genero.getCodGenero());
			comando.setString(2, genero.getDescGenero());
			comando.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoriaConexion.getInstancia().releaseConexion();		
	}

	//NO TIENE STORED PROCEDURE
	public static void updateGenero(GeneroMusical genero) {
		Connection con = FactoriaConexion.getInstancia().getConexion();
		String sql = "update genero_musical set descGenero = ? where codGenero = ?;";
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setInt(2, genero.getCodGenero());
			comando.setString(1, genero.getDescGenero());
			comando.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoriaConexion.getInstancia().releaseConexion();			
	}

	//NO TIENE STORED PROCEDURE
	public static void addAutor(Autor autor) {
		Connection con = FactoriaConexion.getInstancia().getConexion();
		String sql = "insert into autor values (?,?);";
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setInt(1, autor.getCodAutor());
			comando.setString(2, autor.getNombreAutor());
			comando.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoriaConexion.getInstancia().releaseConexion();	
		
	}

	//NO TIENE STORED PROCEDURE
	public static void updateAutor(Autor autor) {
		Connection con = FactoriaConexion.getInstancia().getConexion();
		String sql = "update autor set nombreAutor = ? where codAutor = ?;";
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setInt(2, autor.getCodAutor());
			comando.setString(1, autor.getNombreAutor());
			comando.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoriaConexion.getInstancia().releaseConexion();
	}

	//SOLO TRAE EL GENERO SI LA DESCRIPCIÓN ES IGUAL! SI NO NO!
	public static GeneroMusical getGeneroxDescripcion(String descripcion) {
		GeneroMusical genero=null;
		Connection con = FactoriaConexion.getInstancia().getConexion();
		String sql = "call getGeneroxDescripcion(?);";
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, descripcion);
			ResultSet rs = comando.executeQuery();
			if(rs.next()){
				genero = new GeneroMusical();
				genero.setCodGenero(rs.getInt("codGenero"));
				genero.setDescGenero(rs.getString("descGenero"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoriaConexion.getInstancia().releaseConexion();
		return genero;
	}

	public static void valorarDisco(Usuario usuario, Disco disco, int valor) {
		Connection con = FactoriaConexion.getInstancia().getConexion();
		String sql = "call valorar (?, ?, ?);"; //disco usuario valoracion
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setInt(1, disco.getCodDisco());
			comando.setString(2, usuario.getUsuario());
			comando.setInt(3, valor);
			comando.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoriaConexion.getInstancia().releaseConexion();		
	}

	public static void addVenta(float monto, Usuario usuario, int codDesc, ArrayList<Disco> discos) {
		int nroVenta;
		Connection con = FactoriaConexion.getInstancia().getConexion(); //monto usuario codDescuento
		String sql = "insert into venta (monto, usuario, codDescuento) values (?, ?, ?);";
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setFloat(1, monto);
			comando.setString(2, usuario.getUsuario());
			comando.setInt(3, codDesc);
			comando.executeUpdate();
			ResultSet rs = comando.getGeneratedKeys();
			rs.next();
			nroVenta = rs.getInt(1);
			
			//Ahora voy a agregar los discos de la venta a la BD
			for (Disco d : discos) {
				String sql2 = "INSERT INTO `tiendacd`.`discos_por_venta` (`codDisco`, `nroVenta`) VALUES (?, ?);"; //codDisco nroVenta	
				PreparedStatement comando2 = con.prepareStatement(sql2);
				comando2.setInt(1, d.getCodDisco());
				comando2.setInt(2, nroVenta);
				comando2.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoriaConexion.getInstancia().releaseConexion();
	}
	
	private static float calcularValoracion(int codDisco){
		float val = 0;
		Connection con = FactoriaConexion.getInstancia().getConexion();
		String sql = "call tiendacd.calcularValoración(?);";
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setInt(1, codDisco);
			ResultSet rs = comando.executeQuery();
			if(rs.next())
				val = rs.getFloat("prom");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoriaConexion.getInstancia().releaseConexion();
		return val;
	}

	public static ArrayList<Descuento> getDescuentos() {
		ArrayList<Descuento> descuentos = new ArrayList<Descuento>();
		Connection con = FactoriaConexion.getInstancia().getConexion();
		String sql = "call getDescuentos();";
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			ResultSet rs = comando.executeQuery();
			while(rs.next()){
				Descuento d = new Descuento();
				d.setCodDescuento(rs.getInt("codDescuento"));
				d.setMontoASuperar(rs.getFloat("montoASuperar"));
				d.setPorcentaje(rs.getFloat("porcentaje"));
				descuentos.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoriaConexion.getInstancia().releaseConexion();
		return descuentos;
	}
	
	public static ArrayList<Disco> getDiscosxVenta (int nroVenta){
		ArrayList<Disco> discos = new ArrayList<Disco>();
		String sql = "call getDiscosxVenta(?);";
		Connection con = FactoriaConexion.getInstancia().getConexion();
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setInt(1, nroVenta);
			ResultSet rs = comando.executeQuery();
			while(rs.next()){
				Disco d = new Disco();
				d.setCodDisco(rs.getInt("codDisco"));
				d.setTitulo(rs.getString("titulo"));
				d.setAñoLanzamiento(rs.getInt("anioLanzamiento"));
				d.setCantCopiasDisp(rs.getInt("cantCopiasDisp"));
				d.setPrecio(rs.getFloat("precio"));
				d.getGenero().setCodGenero(rs.getInt("codGenero"));
				d.getAutor().setCodAutor(rs.getInt("codAutor"));
				discos.add(d);
			}
			for (Disco disco : discos) {
				disco.getGenero().setDescGenero(getGenero(disco.getGenero().getCodGenero()).getDescGenero());
				disco.getAutor().setNombreAutor(getAutor(disco.getAutor().getCodAutor()).getNombreAutor());
				disco.setValoracion(calcularValoracion(disco.getCodDisco()));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoriaConexion.getInstancia().releaseConexion();
		return discos;
	}

	public static Descuento getDescuento(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void addDescuento(Descuento descuento) {
		// TODO Auto-generated method stub
	}

	public static void updateDescuento(Descuento descuento) {
		// TODO Auto-generated method stub
	}
	
}


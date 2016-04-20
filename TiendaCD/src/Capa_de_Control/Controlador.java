package Capa_de_Control;

import java.util.ArrayList;

import Capa_de_Datos.DataDiscos;
import Capa_de_Datos.DataUsuarios;
import Capa_de_Entidades.Autor;
import Capa_de_Entidades.Disco;
import Capa_de_Entidades.GeneroMusical;
import Capa_de_Entidades.Usuario;

public class Controlador {
	
	public ArrayList<Disco> buscarDiscos(String cadena){
		ArrayList<Disco> discos = new ArrayList<Disco>();
		ArrayList<Disco> porAutor = DataDiscos.getDiscosxAutor(cadena);
		ArrayList<Disco> porTitulo = DataDiscos.getDiscosxTitulo(cadena);
		ArrayList<Disco> porGenero = DataDiscos.getDiscosxGenero(cadena);
		for (Disco disco : porAutor) discos.add(disco);
		for (Disco disco : porTitulo) discos.add(disco);
		for (Disco disco : porGenero) discos.add(disco);
		return discos;		
	}
	public ArrayList<Disco> getDiscos(){
		return DataDiscos.getDiscos();
	}
	
	public ArrayList<Autor> buscarAutores(String cadena){
		ArrayList<Autor> autores = DataDiscos.getAutoresxNombre(cadena);
		return autores;
	}

	public ArrayList<Autor> getAutores(){
		return DataDiscos.getAutores();
	}

	public ArrayList<Usuario> getUsuarios(){
		return DataUsuarios.getUsuarios();
	}

	public ArrayList<GeneroMusical> getGeneros(){
		return DataDiscos.getGeneros();
	}
	
	public ArrayList<GeneroMusical> buscarGeneros(String cadena){
		ArrayList<GeneroMusical> generos = DataDiscos.getGenerosxDescricion(cadena);
		return generos;
	}
	
	public Usuario buscarUsuario(String usuario){
		return DataUsuarios.getUsuario(usuario);
	}
	
	public void nuevoUsuario(Usuario usuario){
		DataUsuarios.addUsuario(usuario);
	}
}

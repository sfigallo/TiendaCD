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
	
	public Disco buscarDisco(int codigo){
		return DataDiscos.getDisco(codigo);
	}
	
	public void nuevoDisco(Disco disco){
		DataDiscos.addDisco(disco);
	}
	
	public void modificarDisco(Disco disco){
		DataDiscos.updateDisco(disco);
	}
	
	public void eliminarDisco(int codigo){
		DataDiscos.removeDisco(codigo);
	}
	
	public ArrayList<Autor> buscarAutores(String cadena){
		ArrayList<Autor> autores = DataDiscos.getAutoresxNombre(cadena);
		return autores;
	}
	
	public Autor buscarAutor(int codigo){
		return DataDiscos.getAutor(codigo);
	}

	public Autor buscarAutorxNombre(String nombre){
		return DataDiscos.getAutor(nombre);
	}
	
	public ArrayList<Autor> getAutores(){
		return DataDiscos.getAutores();
	}

	public void nuevoAutor(Autor autor){
		DataDiscos.addAutor(autor);
	}
	
	public void modificarAutor(Autor autor){
		DataDiscos.updateAutor(autor);
	}
	
	public ArrayList<Usuario> getUsuarios(){
		return DataUsuarios.getUsuarios();
	}

	public Usuario buscarUsuario(String usuario){
		return DataUsuarios.getUsuario(usuario);
	}
	
	public void nuevoUsuario(Usuario usuario){
		DataUsuarios.addUsuario(usuario);
	}
	
	public ArrayList<GeneroMusical> getGeneros(){
		return DataDiscos.getGeneros();
	}
	
	public ArrayList<GeneroMusical> buscarGeneros(String cadena){
		ArrayList<GeneroMusical> generos = DataDiscos.getGenerosxDescripcion(cadena);
		return generos;
	}
	
	public GeneroMusical buscarGenero(int codigo){
		return DataDiscos.getGenero(codigo);
	}
	
	public GeneroMusical buscarGeneroxDescripcion(String descripcion){
		return DataDiscos.getGeneroxDescripcion(descripcion);
	}
	
	public void nuevoGenero(GeneroMusical genero){
		DataDiscos.addGenero(genero);
	}
	public void modificarGenero(GeneroMusical genero) {
		DataDiscos.updateGenero(genero);
	}

}

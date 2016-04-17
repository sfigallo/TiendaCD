package Capa_de_Control;

import java.util.ArrayList;

import Capa_de_Datos.DataDiscos;
import Capa_de_Entidades.Disco;

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
	

}

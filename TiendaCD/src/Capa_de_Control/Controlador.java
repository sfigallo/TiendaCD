package Capa_de_Control;

import java.util.ArrayList;

import Capa_de_Datos.DataDiscos;
import Capa_de_Entidades.Disco;

public class Controlador {
	
	public ArrayList<Disco> buscarDiscos(String cadena, int clase){
		switch(clase){
			case '1':
				return DataDiscos.getDiscosxNombre(cadena);
			case '2':
				return DataDiscos.getDiscosxAutor(cadena);
			case '3':
				return DataDiscos.getDiscosxGenero(cadena);
		}
		return null;
		
	}
	

}

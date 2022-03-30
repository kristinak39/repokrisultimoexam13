package entidades;

import java.util.Comparator;


//Ej 1 apartado B Krist
public class ComparadorAlfabetico implements Comparator<DatosPersona>{

	@Override
	public int compare(DatosPersona o1, DatosPersona o2) {
		// TODO Auto-generated method stub
		return o1.getNombre().compareTo(o2.getNombre());
	}

}
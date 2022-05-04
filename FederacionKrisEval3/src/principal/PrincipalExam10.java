package principal;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import entidades.Patrocinador;

public class PrincipalExam10 {

	//ejercicio 6
	static void exportarPatrocinadores(LinkedList<Patrocinador> lista) {
		
		try {
			// Un OutputStream subyacente sobre el que
			// escribir los bytes
						FileOutputStream f = new FileOutputStream("patrocinadores.dat");
			// El objeto serializador
						ObjectOutputStream ost = new ObjectOutputStream(f);
						Collections.sort(lista);
						for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
							Patrocinador patrocinador = (Patrocinador) iterator.next();
							ost.writeObject(patrocinador);
						}
						
						ost.flush(); // vaciar el buffer
						ost.close();
						System.out.println("Escritura correcta");
					} catch (IOException e) {
						System.err.println(e);
					}
		
		
	}
	

}

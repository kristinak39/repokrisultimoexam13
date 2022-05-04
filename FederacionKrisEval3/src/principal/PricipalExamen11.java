package principal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import entidades.Tiempo;

public class PricipalExamen11 {
	
	static Tiempo [] listaTiempos;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		listaTiempos = new Tiempo[10];
		
		//EVALUACION 1
		crearTiempos();
		mostrarMenoresUnaHora();
		mostrarMenorYMayorTiempo();
		
		//EVALUACION 2
		importarTiempos("tiempos.dat");
		
	}

	

	private static void crearTiempos() {
		for (int i = 0; i < listaTiempos.length; i++) {
			listaTiempos[i] = Tiempo.nuevoTiempo();			
		}
	}
	
	private static void mostrarMenoresUnaHora() {
		// TODO Auto-generated method stub
		String opcion = null;
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < listaTiempos.length; i++) {
			if(listaTiempos[i].getHoras() < 1) {
				System.out.println(listaTiempos[i]);
				System.out.println("Tiempo menor que 1 hora, desea modificar el valor del tiempo?");
				opcion = sc.next();
				
				if(opcion.equals("Si")) listaTiempos[i] = Tiempo.nuevoTiempo();
			} 
			
			
		}
	}
	
	private static void mostrarMenorYMayorTiempo() {
		// TODO Auto-generated method stub
		ArrayList<Tiempo> ArrayListaTiempo = (ArrayList<Tiempo>) Arrays.asList(listaTiempos);
		Collections.sort(ArrayListaTiempo);
		
		System.out.println("El tiempo menor es "+ ArrayListaTiempo.get(0));
		System.out.println("El tiempo mayor es "+ ArrayListaTiempo.get(ArrayListaTiempo.size()-1));
	}
	

	private static void importarTiempos(String ruta) {
		// TODO Auto-generated method stub
		FileInputStream fis;
		ObjectInputStream ois;
		Tiempo tiempo = null;
		ArrayList<Tiempo> listadoTiempos = new ArrayList<Tiempo>();
		
		try {
			
			fis = new FileInputStream(ruta);
			ois = new ObjectInputStream(fis);
			
			while((tiempo = (Tiempo)ois.readObject()) != null) {
				listadoTiempos.add(tiempo);
			}
			
			Collections.sort(listadoTiempos);
			
			for (Iterator iterator = listadoTiempos.iterator(); iterator.hasNext();) {
				Tiempo t = (Tiempo) iterator.next();
				if(t.getHoras() > 1) {
					iterator.remove();
				}
				else {
					if(tiempo.getCentesimasSegundo() > 50) {
						tiempo.setSegundos(tiempo.getSegundos() + 1);
						tiempo.setCentesimasSegundo(0);
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}


}

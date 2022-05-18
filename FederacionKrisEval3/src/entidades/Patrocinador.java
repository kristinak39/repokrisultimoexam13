package entidades;

import java.time.LocalTime;
import java.util.Scanner;

import validaciones.Validaciones;

public class Patrocinador implements Comparable<Patrocinador>{
	
	private long id;
	private String nombre;
	private String web;
	private double dotacion;
	private Responsable responsable;
	
	
	public Patrocinador() {
		
	}
	
	
	
	public Patrocinador(long id, String nombre, String web, double dotacion) {
		this.id = id;
		this.nombre = nombre;
		this.web = web;
		this.dotacion = dotacion;
	}


	public Patrocinador(long id, String nombre, String web, double dotacion, Responsable responsable) {
		this.id = id;
		this.nombre = nombre;
		this.web = web;
		this.dotacion = dotacion;
		this.responsable = responsable;
	}


//apartado C ej 3 examen 10
	public String mostrarBasico() {
		String ret = null;
		
		return "Id: "+getId()+ " Nombre: " + getNombre() + " Web: "+ getWeb();
		
	}
	
	private String mostrarCompleto() {
		String ret = null;
		
		return mostrarBasico() + " Dotacion: "+ getDotacion()+" euros "+ getResponsable().toString();
		
	}
	
	
	
	
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getWeb() {
		return web;
	}



	public void setWeb(String web) {
		this.web = web;
	}



	public double getDotacion() {
		return dotacion;
	}



	public void setDotacion(double dotacion) {
		this.dotacion = dotacion;
	}



	public Responsable getResponsable() {
		return responsable;
	}



	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}



	public static Patrocinador nuevoPatrocinador() {
		Patrocinador ret = null;
		long id = -1;
		String nombre = "";
		String web = "";
		double dotacion = 0;
		Responsable res = null;
		Scanner in;
		boolean valido = false;
		do {
			System.out.println("Introduzca el id del nuevo Patrocinador:");
			in = new Scanner(System.in);
			id = in.nextInt();
			if (id > 0)
				valido = true;
			else
				System.out.println("Valor incorrecto para el identificador.");
		} while (!valido);

		valido = false;
		do {
			in = new Scanner(System.in);
			System.out.println("Introduzca el nombre del nuevo Patrocinador");
			nombre = in.nextLine();
			valido = Validaciones.validarNombre(nombre);
			if (!valido)
				System.out.println("ERROR: El valor introducido para el nombre no es valido.");
		} while (!valido);

		valido = false;
		do {
			in = new Scanner(System.in);
			System.out.println("Introduzca la direccion web del nuevo Patrocinador:");
			web = in.next();
			//valido = Validaciones.validarAltura(web);
			if (!valido)
				System.out.println("ERROR: El valor introducido para la direccion web no es valido.");
		} while (!valido);
		
		
		valido = false;
		do {
			in = new Scanner(System.in);
			System.out.println("Introduzca la dotacion  del nuevo Patrocinador:");
			dotacion = in.nextDouble();
			valido = dotacion > 0;
			if (!valido)
				System.out.println("ERROR: El valor introducido para la dotacion no es valido.");
		} while (!valido);

		System.out.println("Introduzca ahora los datos personales:");
		in = new Scanner(System.in);
		res = Responsable.nuevoResponsable();

		ret = new Patrocinador(id, nombre,web, dotacion, res);
		return ret;
	}



	//ejecricio 5 examne 10
	@Override
	public int compareTo(Patrocinador o) {
		// TODO Auto-generated method stub
		int resultado = this.getDotacion() > o.getDotacion() ?1:-1;
		if(this.getDotacion()-o.getDotacion() == 0) {
			resultado = this.getResponsable().getHorarioFin().compareTo(o.getResponsable().getHorarioIni());
			if(resultado == 0) {
				resultado = (int) (this.getId() - o.getId());
			}
		}
		return resultado;
	}
	

	
	
}

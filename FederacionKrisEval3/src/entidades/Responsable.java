package entidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Scanner;

import utils.Utilidades;
import validaciones.Validaciones;

public class Responsable extends DatosPersona{
	private long id;
	private String telefonoProf;
	private LocalTime horarioIni;
	private LocalTime horarioFin;
	private DatosPersona dp;
	

	public Responsable(long id, String nombre, String telefono, LocalDate fechaNac, long id2, String telefonoProf,
			LocalTime horarioIni, LocalTime horarioFin) {
		super(id, nombre, telefono, fechaNac);
		id = id2;
		this.telefonoProf = telefonoProf;
		this.horarioIni = horarioIni;
		this.horarioFin = horarioFin;
	}	
	

	public Responsable(long id, String nombre, String telefono, LocalDate fechaNac, Documentacion nifnie, long id2,
			String telefonoProf, LocalTime horarioIni, LocalTime horarioFin) {
		super(id, nombre, telefono, fechaNac, nifnie);
		id = id2;
		this.telefonoProf = telefonoProf;
		this.horarioIni = horarioIni;
		this.horarioFin = horarioFin;
	}




	public Responsable(long id, String nombre, String telefono, LocalDate fechaNac, long id2, String telefonoProf,
			LocalTime horarioIni, LocalTime horarioFin, DatosPersona dp) {
		super(id, nombre, telefono, fechaNac);
		id = id2;
		this.telefonoProf = telefonoProf;
		this.horarioIni = horarioIni;
		this.horarioFin = horarioFin;
		this.dp = dp;
	}


	


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTelefonoProf() {
		return telefonoProf;
	}

	public void setTelefonoProf(String telefonoProf) {
		this.telefonoProf = telefonoProf;
	}

	public LocalTime getHorarioIni() {
		return horarioIni;
	}

	
	
	public DatosPersona getDp() {
		return dp;
	}


	public void setDp(DatosPersona dp) {
		this.dp = dp;
	}


	public void setHorarioIni(LocalTime horarioIni) {
		this.horarioIni = horarioIni;
	}

	public LocalTime getHorarioFin() {
		return horarioFin;
	}

	public void setHorarioFin(LocalTime horarioFin) {
		this.horarioFin = horarioFin;
	}
	
	
	
	public void importarRepresentantes() {
		
		
	}


	public static Responsable nuevoResponsable() {
		// TODO Auto-generated method stub
		Responsable res = null;
		long id = -1;
		String telefono = "";
		LocalTime horaIni = null;
		LocalTime horaFin = null;
		DatosPersona dp = null;
		
		Scanner in;
		boolean valido = false;
		do {
			System.out.println("Introduzca el id del nuevo Responsable:");
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
			System.out.println("Introduzca el telefono del nuevo Responsable");
			telefono = in.nextLine();
			valido = Validaciones.validarTelefono(telefono);
			if (!valido)
				System.out.println("ERROR: El valor introducido para el telefono no es valido.");
		} while (!valido);		
		
		valido = false;
		do {
			in = new Scanner(System.in);
			System.out.println("Introduzca el horario de inicio  del nuevo Responsable:");		
			
			horaIni = Utilidades.leerHora();
			horaFin = Utilidades.leerHora();
			
			valido = true;
			if (!valido)
				System.out.println("ERROR: El valor introducido para las horas no es valido.");
		} while (!valido);

		System.out.println("Introduzca ahora los datos personales:");
		in = new Scanner(System.in);
		dp = DatosPersona.nuevaPersona();
		res = new Responsable(id, telefono, telefono, null, id, telefono, horaIni, horaFin, dp);
		return res;
	
	}


	@Override
	public String toString() {
		return getId() + "." + getNombre() + "(" + getNifnie() + ")" + "horario de: " +
				getHorarioIni().format(DateTimeFormatter.ofPattern("HH:MM:SS")) + " a " + getHorarioFin().format(DateTimeFormatter.ofPattern("HH:MM:SS")) + " tfno: " + getTelefonoProf();
	}
	
	
	//ejercicio 4 examen 10
	public String data() {
		return "" + getId() + "|" + getDp().getId() + "|" + getTelefonoProf() + "|"
				+getHorarioIni().format(DateTimeFormatter.ofPattern("HH:MM")) + "|" +getHorarioFin().format(DateTimeFormatter.ofPattern("HH:MM"));
	}
	
	//Ej 7
	public static void importarResponsables() {
		String path = "responsables.txt";
		File fichero = new File(path);
		FileReader lector = null;
	    BufferedReader buffer = null;
	    String linea = null;
		try {
			try {
				lector = new FileReader(fichero);
				buffer = new BufferedReader(lector);
				while(buffer.readLine() != null) {
					linea = buffer.readLine();
					
					
				}
			} finally {
				if (buffer != null) {
					buffer.close();
				}
				if (lector != null) {
					lector.close();
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Se ha producido una FileNotFoundException" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Se ha producido una IOException" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception" + e.getMessage());
		}
	}


	public Responsable getPersona() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setPersona(DatosPersona buscarPersonaPorId) {
		// TODO Auto-generated method stub
		
	}
	
	
}

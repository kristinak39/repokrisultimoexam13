package entidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;



import utils.ConexBD;
import utils.Datos;
import utils.Utilidades;

public class DatosPersona implements Comparable<DatosPersona> {
	private long id;
	private String nombre;
	private String telefono;
	private LocalDate fechaNac;

	private Documentacion nifnie;

	public DatosPersona(long id, String nombre, String telefono, LocalDate fechaNac) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.fechaNac = fechaNac;
	}

	public DatosPersona(long id, String nombre, String telefono, LocalDate fechaNac, Documentacion nifnie) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.fechaNac = fechaNac;
		this.nifnie = nifnie;
	}

	// Ej 1 apartado A
	public String data() {
		return this.getId() + "|" + this.getNombre() + "|" + this.getTelefono() + "|" + this.getFechaNac() + "|"
				+ this.getNifnie().mostrar();
	}

	// Ej 1 apartado C
	public static void exportarPersonasOrdenadasAlfabeticamente() {
		ArrayList<DatosPersona> listaPersonas = new ArrayList<DatosPersona>(Arrays.asList(Datos.PERSONAS));
		listaPersonas.sort(new ComparadorAlfabetico());

		String path = "atletas_alfabetico.txt";
		File fichero = new File(path);
		FileWriter escritor = null;
		PrintWriter buffer = null;
		try {
			try {
				escritor = new FileWriter(fichero, false);
				buffer = new PrintWriter(escritor);
				for (DatosPersona persona : listaPersonas) {
					buffer.println(persona.data());
				}
			} finally {
				if (buffer != null) {
					buffer.close();
				}
				if (escritor != null) {
					escritor.close();
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

	// Ej 2 apartado A
	@Override
	public int compareTo(DatosPersona o) {
		// TODO Auto-generated method stub
		int comparacion = this.getFechaNac().compareTo(o.getFechaNac());
		if (comparacion == 0) {
			return this.getNifnie().mostrar().compareTo(o.getNifnie().mostrar());
		}
		return comparacion;
	}

	// Ej 2 apartado B
	public static void insertarPersonas() {
		ArrayList<DatosPersona> listaPersonas = new ArrayList<DatosPersona>(Arrays.asList(Datos.PERSONAS));
		Collections.sort(listaPersonas);

		// ESTABLECIENDO CONEXION CON BASE DE DATOS
		Connection conex = null;
		Statement consulta = null;
		ResultSet resultado = null;

		try {
			for (Iterator iterator = listaPersonas.iterator(); iterator.hasNext();) {
				DatosPersona datosPersona = (DatosPersona) iterator.next();

				if (conex == null) {
					conex = ConexBD.getCon(); // creamos la conexion
					consulta = conex.createStatement();// creamos una consulta a partir de la conexion
					String consultaStr = "INSERT INTO persona (id,nombre,telefono,nifnie) VALUES ('"
							+ datosPersona.getId() + "','" + datosPersona.getNombre() + "','"
							+ datosPersona.getTelefono() + "','" + datosPersona.getNifnie() + "')";
					consulta.executeQuery(consultaStr);// ejecutamos
				}
			}

		} catch (SQLException e) {
			System.out.println("Se ha producido una Excepcion:" + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				System.out.println("Cerrando recursos...");
				if (resultado != null)
					resultado.close();
				if (consulta != null)
					consulta.close();
				if (conex != null)
					conex.close();
			} catch (SQLException e) {
				System.out.println("Se ha producido una Excepcion:" + e.getMessage());
				e.printStackTrace();
			}
		}
		System.out.println("FIN");
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Documentacion getNifnie() {
		return nifnie;
	}

	public void setNifnie(Documentacion nifnie) {
		this.nifnie = nifnie;
	}

	@Override
	public String toString() {
		return nombre + " NIF/NIE: " + nifnie.mostrar() + " Tfn:" + telefono + " ("
				+ fechaNac.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ")";
	}

	public static DatosPersona nuevaPersona() {
		DatosPersona ret = null;
		Scanner in;
		long id = -1;
		String nombre = "";
		String tfn = "";
		boolean valido = false;
		do {
			System.out.println("Introduzca el id de la nueva persona:");
			in = new Scanner(System.in);
			id = in.nextInt();
			if (id > 0)
				valido = true;
		} while (!valido);
		valido = false;
		do {
			System.out.println("Introduzca el nombre de la nueva persona:");
			in = new Scanner(System.in);
			nombre = in.nextLine();
			if (nombre.length() > 3)
				valido = true;
		} while (!valido);
		do {
			System.out.println("Introduzca el telefono de la nueva persona:");
			in = new Scanner(System.in);
			tfn = in.nextLine();
			if (tfn.length() > 3)
				valido = true;
		} while (!valido);
		System.out.println("Introduzca la fecha de nacimiento de la nueva persona");
		LocalDate fecha = Utilidades.leerFecha();
		System.out.println("Â¿Va a introducir un NIF? (pulse 'S' par SÃ� o 'N' para NIE)");
		boolean esnif = Utilidades.leerBoolean();
		Documentacion doc;
		if (esnif)
			doc = NIF.nuevoNIF();

		else
			doc = NIE.nuevoNIE();

		ret = new DatosPersona(id, nombre, tfn, fecha, doc);
		return ret;
	}

}


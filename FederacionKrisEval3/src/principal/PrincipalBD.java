package principal;

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
import java.util.ArrayList;

import com.mysql.cj.result.LocalDateTimeValueFactory;

import entidades.DatosPersona;
import entidades.Documentacion;
import entidades.NIE;
import utils.ConexBD;


//Ej 3 Kristina
public class PrincipalBD {

	public static void main(String[] args) {
		System.out.println("INICIO");
		Connection conex = null;
		Statement consulta = null;
		ResultSet resultado = null;
		ArrayList<DatosPersona> listaPersonas = new ArrayList<DatosPersona>();
		try {
	//		conex = ConexBD.establecerConexion();
			String consultaStr = "SELECT * FROM personas order by nombre "; 
			if(conex==null)
				conex = ConexBD.getCon(); //creamos la conexion
			consulta = conex.createStatement();//creamos una consulta a partir de la conexion
			resultado = consulta.executeQuery(consultaStr);//ejecutamos la consulta y almacenamos el resultado
			while (resultado.next()) {//si esxiste un siguiente resultado
				int id = resultado.getInt(1);
				String nombre = resultado.getString("nombre");
				String telefono = resultado.getString("telefono");
				String nifnie = resultado.getString("nifnie");
				DatosPersona persona = new DatosPersona(id, nombre, telefono, null);
				persona.setNifnie(new NIE(nifnie));
				listaPersonas.add(persona);
				
			}
		} catch (SQLException e) {
			System.out.println("Se ha producido una Excepcion:"+ e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				System.out.println("Cerrando recursos...");
				if(resultado!=null)
					resultado.close();
				if(consulta!=null)
					consulta.close();
				if(conex!= null)
					conex.close();
			} catch (SQLException e) {
				System.out.println("Se ha producido una Excepcion:"+ e.getMessage());
				e.printStackTrace();
			}
		}
		System.out.println("FIN");
		//exportando a fichero
		String path = "atletas_alfabetico_2.txt";
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

}
package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConexBD {	

	static Connection conexion = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;	

	public static Connection getCon() {
		try {
			if (conexion == null) {
				Properties properties = new Properties();
				MysqlDataSource m = new MysqlDataSource();
				FileInputStream fis;
				fis = new FileInputStream("src/utils/db.properties");
				// cargamos la información del fichero properties
				properties.load(fis);
				// asignamos al origen de datos las propiedades leidas del fichero properties
				m.setUrl(properties.getProperty("url"));
				m.setPassword(properties.getProperty("password"));
				m.setUser(properties.getProperty("usuario")); // obtememos la conexion
				fis.close();
				conexion = m.getConnection();
			}
			return conexion;
		} catch (FileNotFoundException e) {
			System.out.println("Error al acceder al fichero properties " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error al leer las propiedades del fichero properties" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception: " + e.getMessage());
			e.printStackTrace();
		}
		return conexion;
	}

	public static void cerrarConexion() {
		if (conexion != null) {
			try {
				conexion.close();
			} catch (SQLException ex) {
				System.out.println("Se ha producido una SQLException:" + ex.getMessage());
			}
		}
	}

}

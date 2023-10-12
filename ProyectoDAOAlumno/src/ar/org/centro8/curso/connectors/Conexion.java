

package ar.org.centro8.curso.connectors;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    public static Connection obtenerConexion() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        String conexion = null;
        String usuario = null;
        String clave = null;
        
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            conexion = "jdbc:mysql://127.0.0.1:3306/colegio";
            usuario = "root";
            clave = "";
            
            Class.forName(driver).newInstance();
            
            
            
        } catch (ClassNotFoundException e) {
            System.out.println("error");
        } catch (InstantiationException e) {
            System.out.println("error");
        } catch (IllegalAccessException e) {
            System.out.println("error");
        }
        return DriverManager.getConnection(conexion, usuario, clave);
    }
}

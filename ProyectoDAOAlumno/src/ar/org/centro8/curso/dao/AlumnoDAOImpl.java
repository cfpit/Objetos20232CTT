package ar.org.centro8.curso.dao;

import ar.org.centro8.curso.connectors.Conexion;
import ar.org.centro8.curso.interfaces.AlumnoDAO;
import ar.org.centro8.curso.entities.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlumnoDAOImpl implements AlumnoDAO {

    @Override
    public List<Alumno> consultarTodos() {
        Connection unaConexion = null;
        List<Alumno> lista = new ArrayList<>();
        try {
            unaConexion = Conexion.obtenerConexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        String unaConsulta = "select * from alumnos";

        Statement unaSentencia = null;
        try {
            unaSentencia = unaConexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResultSet unResultado = null;
        try {
            unResultado = unaSentencia.executeQuery(unaConsulta);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            while (unResultado.next()) {
                System.out.println("Nombre: " + unResultado.getString("nombre"));
                System.out.println("Edad: " + unResultado.getInt("edad"));
                System.out.println("--------------------------------");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            unaConexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

    }

    @Override
    public void consultarUno(String nombre) {
        Connection unaConexion = null;
        try {
            unaConexion = Conexion.obtenerConexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        String unaConsulta = "select * from alumnos where nombre = '" + nombre + "'";

        Statement unaSentencia = null;
        try {
            unaSentencia = unaConexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResultSet unResultado = null;
        try {
            unResultado = unaSentencia.executeQuery(unaConsulta);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            if (unResultado.next()) {
                System.out.println("Nombre: " + unResultado.getString("nombre"));
                System.out.println("Edad: " + unResultado.getInt("edad"));
                System.out.println("--------------------------------");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            unaConexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void insertar(Alumno a) {
        Connection unaConexion = null;
        try {
            unaConexion = Conexion.obtenerConexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        String unaInsercion = "insert into alumnos(nombre,edad) values(?, ?)";

        PreparedStatement unaSentencia = null;
        try {
            unaSentencia = unaConexion.prepareStatement(unaInsercion);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            unaSentencia.setString(1, a.getNombre());
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            unaSentencia.setInt(2, a.getEdad());
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            unaSentencia.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Insercion correcta");

        try {
            unaConexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void actualizar(String nombreAnterior, String nombreNuevo) {
        Connection unaConexion = null;
        try {
            unaConexion = Conexion.obtenerConexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        String unaActualizacion = "update alumnos set nombre = ? where nombre = ?";

        PreparedStatement unaSentencia = null;
        try {
            unaSentencia = unaConexion.prepareStatement(unaActualizacion);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            unaSentencia.setString(1, nombreNuevo);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            unaSentencia.setString(2, nombreAnterior);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            unaSentencia.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Actualizacion correcta");

        try {
            unaConexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void eliminar(String nombre) {
        Connection unaConexion = null;
        try {
            unaConexion = Conexion.obtenerConexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        String unaEliminacion = "delete from alumnos where nombre = ?";

        PreparedStatement unaSentencia = null;
        try {
            unaSentencia = unaConexion.prepareStatement(unaEliminacion);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            unaSentencia.setString(1, nombre);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            unaSentencia.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Eliminacion correcta");

        try {
            unaConexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    @Override
    public ArrayList<Alumno> cargarLista() {
        ArrayList<Alumno> lista = new ArrayList<Alumno>();

        Connection unaConexion = null;
        try {
            unaConexion = Conexion.obtenerConexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        String unaConsulta = "select * from alumnos";

        Statement unaSentencia = null;
        try {
            unaSentencia = unaConexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResultSet unResultado = null;
        try {
            unResultado = unaSentencia.executeQuery(unaConsulta);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            while (unResultado.next()) {
                String nombre = unResultado.getString("nombre");
                int edad = unResultado.getInt("edad");
                
                Alumno a = new Alumno(nombre, edad);
                lista.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            unaConexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        return lista;
    }

    
    
    
    /*    
Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex); es 
una instrucción típica en Java utilizada para registrar un mensaje de error en un 
archivo de registro o en la consola utilizando el sistema de registro incorporado 
de Java, conocido como el framework de registro Java Logging API (también conocido 
como java.util.logging).


Logger.getLogger(AlumnoDAOImpl.class.getName()): Esta parte obtiene una instancia 
del objeto Logger asociado a la clase AlumnoDAOImpl. El Logger es responsable de 
gestionar y registrar mensajes de registro.

.log(Level.SEVERE, null, ex): Aquí se llama al método log del objeto Logger para 
registrar un mensaje. Level.SEVERE indica que se está registrando un mensaje de 
nivel "severo" o de error. Este nivel se utiliza para mensajes de error críticos.

null: El segundo argumento es el identificador del recurso asociado con el mensaje 
de registro. En este caso, se pasa null para indicar que no hay recurso específico 
relacionado con el mensaje.

ex: El tercer argumento es el objeto Throwable (por lo general, una excepción) que 
se registra junto con el mensaje. Esto permite registrar información detallada sobre 
una excepción que ocurrió.

En resumen, esta línea de código se utiliza para registrar un mensaje de error 
(nivel "SEVERE") junto con detalles de una excepción (ex) en el registro de la 
aplicación, que puede ser útil para el diagnóstico y la depuración de problemas. 
El registro es una práctica común en el desarrollo de aplicaciones para ayudar a 
los desarrolladores a rastrear y solucionar problemas.

     */
}

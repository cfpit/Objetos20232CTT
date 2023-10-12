

package ar.org.centro8.curso.test;

import ar.org.centro8.curso.dao.AlumnoDAOImpl;
import ar.org.centro8.curso.entities.Alumno;
import java.sql.SQLException;
import java.util.Scanner;


public class Test {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
            AlumnoDAOImpl a = new AlumnoDAOImpl();

            a.consultarTodos();
            
            
//            a.consultarUno("Pedro");


            
//            System.out.println("Insercion");
//            Scanner lector = new Scanner(System.in);
//            
//            System.out.println("ingrese el nombre: ");
//            String nombre = lector.next();
//            
//            System.out.println("ingrese la edad: ");
//            int edad = lector.nextInt();
//            
//            Alumno unAlumno = new Alumno(nombre, edad);
//            a.insertar(unAlumno);
//            a.consultarTodos();
//            System.out.println("Insercion correcta");
            
            
            
            
            
            
//            System.out.println("Eliminacion");
//            Scanner lector = new Scanner(System.in);
//            
//            System.out.println("ingrese el nombre a elimnar: ");
//            String nombre = lector.next();
//            
//            a.eliminar(nombre);
//            a.consultarTodos();
//            System.out.println("Eliminacion correcta");
            
            
            
            
            
            
        
    }
}

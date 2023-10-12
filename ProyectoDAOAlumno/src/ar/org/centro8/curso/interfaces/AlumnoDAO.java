package ar.org.centro8.curso.interfaces;

import ar.org.centro8.curso.entities.Alumno;
import java.util.ArrayList;
import java.util.List;

public interface AlumnoDAO {
    List<Alumno> consultarTodos();
    void consultarUno(String nombre);
    void insertar(Alumno alumno);
    void eliminar(String nombre);
    void actualizar(String nombreAnterior, String nombreNuevo);
    ArrayList<Alumno> cargarLista();
}

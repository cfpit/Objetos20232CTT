

package ar.org.centro8.curso.entities;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Alumno {
    private String nombre;
    private int edad;

    public Alumno() {}

    public Alumno(String nombre, int edad) {
        this.setNombre(nombre);
        this.setEdad(edad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return nombre + " - " + edad + " años";
    }
}

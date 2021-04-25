
package Modelo;

import java.util.Date;

public class Perro {
    private int id;
    private String nombre;
    private String raza;
    private String fechaNacimiento;

    /**
     * Constructor sin parametros
     */
    public Perro() {
    }
    
    
    /**
     * Constructor con los siguientes parametros:
     * @param id
     * @param nombre
     * @param raza
     * @param fechaNacimiento 
     */
    public Perro(int id, String nombre, String raza, String fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.fechaNacimiento = fechaNacimiento;
    }

    // -- METODOS PARA ACCEDER A LOS ATRIBUTOS --
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return id+" "+nombre+" "+raza+" "+fechaNacimiento;
    }
}

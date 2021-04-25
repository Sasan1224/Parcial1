
package Modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PerrosOrdenados {
    private ArrayList<Perro> perros;

    /**
     * Contructor sin parammetros
     */
    public PerrosOrdenados() {
        perros = new ArrayList<>();
    }
    
    public void agregarPerro(Perro p){
        perros.add(p);
    }
    
    /**
     * Metodo para ordenar la listar por el id
     * @return lista
     */
    private void ordenarId() {
        //Ordenar por ID
        for (int i = 0; i < perros.size(); i++) {
            for (int j = 0; j < perros.size()-i-1; j++) {
                if (perros.get(j).getId() > perros.get(j+1).getId()) {
                    Perro p = perros.get(j+1);
                    perros.set(j+1, perros.get(j));
                    perros.set(j, p);
                }
            }
        }
    }
    
    /**
     * Meotodo para ordenar la lista por nombre
     * @return lista
     */
    private void ordenarNombre() {
        for (int i = 0; i < perros.size(); i++) {
            for (int j = 0; j < perros.size()-i-1; j++) {
                if (perros.get(j).getNombre().compareTo(perros.get(j+1).getNombre()) > 0) {
                    Perro p = perros.get(j+1);
                    perros.set(j+1, perros.get(j));
                    perros.set(j, p);
                }
            }
        }
    }
    
    /**
     * Metodo para ordenar la lista por Raza
     * @return lista
     */
    private void ordenarRaza() {
        for (int i = 0; i < perros.size(); i++) {
            for (int j = 0; j < perros.size()-i-1; j++) {
                if (perros.get(j).getRaza().compareTo(perros.get(j+1).getRaza()) > 0) {
                    Perro p = perros.get(j+1);
                    perros.set(j+1, perros.get(j));
                    perros.set(j, p);
                }
            }
        }
    }
    
    private void ordenarFecha() {
        for (int i = 0; i < perros.size(); i++) {
            for (int j = 0; j < perros.size()-i-1; j++) {
                if (ParseFecha(perros.get(j).getFechaNacimiento()).after(ParseFecha(perros.get(j+1).getFechaNacimiento()))) {
                    Perro p = perros.get(j+1);
                    perros.set(j+1, perros.get(j));
                    perros.set(j, p);
                }
            }
        }
    }
    
    /**
     * Permite convertir un String en fecha (Date).
     * @param fecha Cadena de fecha dd/MM/yyyy
     * @return Objeto Date
     */
    private Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }
    
    /**
     * Metodo para generar diferentes archivos ordenado por cada atributo
     */
    public void generarArchivos() throws IOException{
        //Crear Archivos
        FileWriter f1 = new FileWriter(new File("PerrosAdoptados(id).txt"));
        FileWriter f2 = new FileWriter(new File("PerrosAdoptados(nombre).txt"));
        FileWriter f3 = new FileWriter(new File("PerrosAdoptados(Raza).txt"));
        FileWriter f4 = new FileWriter(new File("PerrosAdoptados(fecha).txt"));
        
        //Ordenar por ID
        ordenarId();
        //Escribir archivo
        for (int i = 0; i < perros.size(); i++) {
            f1.write(perros.get(i).toString()+"\n");
        }
        f1.close();
        
        //Ordenar por nombre
        ordenarNombre();
        //Escribir archivo
        for (int i = 0; i < perros.size(); i++) {
            f2.write(perros.get(i).toString()+"\n");
        }
        f2.close();
        
        //Ordenar por Raza
        ordenarRaza();
        //Escribir archivo
        for (int i = 0; i < perros.size(); i++) {
            f3.write(perros.get(i).toString()+"\n");
        }
        f3.close();
        
        //Ordenar por Fecha de nacimiento
        ordenarFecha();
        //Escribir archivo
        for (int i = 0; i < perros.size(); i++) {
            f4.write(perros.get(i).toString()+"\n");
        }
        f4.close();
    }
     
    public ArrayList<Perro> mostrar(){
        ordenarId();
        return perros;
    }
}


package Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class ModeloPerro {
    ArrayList<Perro> perros;

    /**
     * 
     * Contructor son parametros
     */
    public ModeloPerro() {
        perros = new ArrayList<>();
        try {
            cargarLista();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    /**
     * Metodo para cargar los datos de los archivos en la lista
     * @throws FileNotFoundException 
     */
    private void cargarLista() throws FileNotFoundException{
        Scanner leer = new Scanner(new File("txt1.txt"));
        Perro p;
        while (leer.hasNext()) {
            String linea = leer.nextLine();
            String[] atributos = linea.split(" ");
            p = new Perro();
            p.setId(Integer.parseInt(atributos[0]));
            p.setNombre(atributos[1]);
            perros.add(p);
        }
        leer.close();
        
        leer = new Scanner(new File("txt2.txt"));
        while (leer.hasNext()) {
            String linea = leer.nextLine();
            String[] atributos = linea.split(" ");
            for (int i = 0; i < perros.size(); i++) {
                if (perros.get(i).getId() == Integer.parseInt(atributos[0])) {
                    perros.get(i).setRaza(atributos[1]);
                    perros.get(i).setFechaNacimiento(atributos[2]);
                }
                
            }
        }
        leer.close();        
    }
    
    /**
     * Metodo para ordenar la listar por el id
     * @return lista
     */
    public ArrayList<Perro> mostarPorId() {
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
        return perros;
    }
    
    /**
     * Meotodo para ordenar la lista por nombre
     * @return lista
     */
    public ArrayList<Perro> mostarPorNombre() {
    	System.out.println("entro al metodo");
        for (int i = 0; i < perros.size(); i++) {
            for (int j = 0; j < perros.size()-i-1; j++) {
                if (perros.get(j).getNombre().compareTo(perros.get(j+1).getNombre()) > 0) {
                    Perro p = perros.get(j+1);
                    perros.set(j+1, perros.get(j));
                    perros.set(j, p);
                }
            }
        }
        return perros;
    }
    
    /**
     * Metodo para ordenar la lista por Raza
     * @return lista
     */
    public ArrayList<Perro> mostarPorRaza() {
        for (int i = 0; i < perros.size(); i++) {
            for (int j = 0; j < perros.size()-i-1; j++) {
                if (perros.get(j).getRaza().compareTo(perros.get(j+1).getRaza()) > 0) {
                    Perro p = perros.get(j+1);
                    perros.set(j+1, perros.get(j));
                    perros.set(j, p);
                }
            }
        }
        return perros;
    }
    
    public ArrayList<Perro> mostarPorFecha() {
        for (int i = 0; i < perros.size(); i++) {
            for (int j = 0; j < perros.size()-i-1; j++) {
                if (ParseFecha(perros.get(j).getFechaNacimiento()).after(ParseFecha(perros.get(j+1).getFechaNacimiento()))) {
                    Perro p = perros.get(j+1);
                    perros.set(j+1, perros.get(j));
                    perros.set(j, p);
                }
            }
        }
        return perros;
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
   
}

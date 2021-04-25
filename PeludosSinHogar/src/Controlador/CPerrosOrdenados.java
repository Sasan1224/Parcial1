
package Controlador;

import Modelo.Perro;
import Modelo.PerrosOrdenados;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class CPerrosOrdenados {
    private PerrosOrdenados perrosOrdenados;

    /**
     * Constructor sin parametros
     */
    public CPerrosOrdenados() {
        perrosOrdenados = new PerrosOrdenados();
    }
    
    /**
     * Metodo para agregar un perro
     * @param id
     * @param nom
     * @param raza
     * @param fecha 
     */
    public void agregarPerro(String id, String nom, String raza, String fecha){
        perrosOrdenados.agregarPerro(new Perro(Integer.parseInt(id), nom, raza, fecha));
    }  
    
    /**
     * Metodo del controlador para iniciar el JTable de los perros adoptados
     * @return el modelo
     */
    public DefaultTableModel MostrarDatos(){
        String titulos[] = {"Id","Nombre","Raza","Fecha Nacimiento"};
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(null, titulos);
        String  datos[] = new String [4];   
        ArrayList<Perro> lista = perrosOrdenados.mostrar();
        for (int i = 0; i < lista.size(); i++) {
            datos[0] = lista.get(i).getId()+"";
            datos[1] = lista.get(i).getNombre();
            datos[2] = lista.get(i).getRaza();
            datos[3] =lista.get(i).getFechaNacimiento();
            modelo.addRow(datos);
        }    
        return modelo;
    } 
    
    public void generarArchivos(){
        try {
            perrosOrdenados.generarArchivos();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}


package Controlador;

import Modelo.ModeloPerro;
import Modelo.Perro;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class CPerro {
    private ModeloPerro mperro;

    public CPerro() {
        mperro = new ModeloPerro();
    }
    
    /**
     * Metodo del controlador para iniciar el JTable de los perros
     * @return el modelo
     */
    public DefaultTableModel MostrarDatos(String atributo){
        String titulos[] = {"Id","Nombre","Raza","Fecha Nacimiento"};
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(null, titulos);
        String  datos[] = new String [4];   
        ArrayList<Perro> lista = null;
        if (atributo.equals("Id")) {
            lista = mperro.mostarPorId();
            System.out.println("ID_");
        }
        else if(atributo.equals("Nombre")){
            lista = mperro.mostarPorNombre();
            System.out.println("NJ_");
        }
        else if(atributo.equals("Raza")){
            lista = mperro.mostarPorRaza();
            System.out.println("R_");
        }
        else if(atributo.equals("Fecha nacimiento")){
            lista = mperro.mostarPorFecha();
            System.out.println("F_");
        }
         
        for (int i = 0; i < lista.size(); i++) {
            datos[0] = lista.get(i).getId()+"";
            datos[1] = lista.get(i).getNombre();
            datos[2] = lista.get(i).getRaza();
            datos[3] =lista.get(i).getFechaNacimiento();
            modelo.addRow(datos);
        }    
        return modelo;
    } 
}

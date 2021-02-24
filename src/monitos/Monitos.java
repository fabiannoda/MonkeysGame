/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitos;
import Vista.Ventana;
import Modelo.Model;
import Controlador.Controller;
import Modelo.ModeloGenetico;


/**
 *
 * @author Angel Fabián Nodarse Díaz
 * @serial 1032507704
 * @author Juan Camilo Díaz
 * @serial 1023028211
 * @author Mateo Hoya Acevedo
 * @serial 1001326526
 */
public class Monitos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Ventana v=new Ventana();
        Model m=new Model(v);
        ModeloGenetico mg=new ModeloGenetico(v);
        Controller c=new Controller(v, m, mg);
        c.m=m;
        mg.AlgoritmoGenetico();
//        System.out.println(v.pelotero1.getLocation().x);

        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.Ventana;
import java.util.ArrayList;


/**
 *
 * @author USER
 */
public final class Model {
    public Ventana v;
    public boolean flag=true;
    public static ArrayList<Edificio> edificios=new ArrayList<>();
    public Edificio edif;

    public Model(Ventana v){
        this.v = v;
 
    }
    
    public void Construir(){
        int ed=0;
        for (int i = 300; i <1000; i+=100) {
            int tipo=(int) ((Math.random()*4)+1);
            switch(tipo){
                case 1:edif=new Edificio(v, i, 120, 25,ed);
                edificios.add(edif);
                break;
                case 2:edif=new Edificio(v, i, 420, 10,ed);
                edificios.add(edif);
                break;
                case 3:edif=new Edificio(v, i, 260, 18,ed);
                edificios.add(edif);
                break;
                case 4: edif=new Edificio(v, i, 20, 30,ed);
                edificios.add(edif);
              
            }
            ed++;
            
        }
         
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Controller;
import Vista.Ventana;
import static Modelo.Model.edificios;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class GetGanador extends Thread {

    Ventana v;
    
    ModeloGenetico mg;

    public GetGanador(Ventana v, ModeloGenetico mg) {
        this.v = v;
        
        this.mg=mg;
    }

    public void run() {
        while ( mg.flag) {
            if (mg.turno == 1) {
                int x = v.pelota.getLocation().x + v.pelota.getWidth();
                int y = v.pelota.getLocation().y + v.pelota.getHeight();
                int x1 = v.pelotero1.getLocation().x;
                int y1 = v.pelotero1.getLocation().y;
                int x2 = x1 + v.pelotero1.getWidth();
                int y2 = y1 + v.pelotero1.getHeight();
                System.out.println(x+" "+y);
                if (x >= x1 && y >= y1 && x <= x2 && y <= y2) {

//                    c.ganador = false;
                    v.remove(v.pelotero1);
                    v.repaint();
//                    JOptionPane.showMessageDialog(null, "Felicidades " + c.nombre1 + " has ganado!");
                    this.mg.flag = false;
                    System.exit(0);
                    

                }
            }
//            } else {
//                int x = v.pelota.getLocation().x + v.pelota.getWidth();
//                int y = v.pelota.getLocation().y + v.pelota.getHeight();
//                int x1 = v.pelotero2.getLocation().x;
//                int y1 = v.pelotero2.getLocation().y;
//                int x2 = x1 + v.pelotero2.getWidth();
//                int y2 = y1 + v.pelotero2.getHeight();
//                System.out.println(x+" "+y);
//                if (x >= x1 && y >= y1 && x <= x2 && y <= y2) {
//
//                    c.ganador = false;
//                    v.remove(v.pelotero2);
//                    v.repaint();
//                    JOptionPane.showMessageDialog(null, "Felicidades " + c.nombre2 + " has ganado!");
//                    this.m.flag = false;
//                    System.exit(0);
//                    
//
//                }
//            }

        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Controller;
import Vista.Ventana;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class Mover extends Thread {

    Ventana v;
    ModeloGenetico mg;
    

    public Mover(Ventana v, ModeloGenetico mg) {
        this.v = v;
        this.mg=mg;
    }

    
    
    public void run(Gen b) {
        double t = 0;
        int x0 = 50, x = 0, y = 0, y0 = v.pelota.getLocation().y;
        double a = Math.toRadians(b.getAngulo()), pf = 0.0;
        int v = b.getVelocidad();
        this.v.pelota.setIcon(this.v.escalade);
        this.v.pelotero2.setIcon(this.v.escalagifpelo2);
        
        

        while (mg.flag) {
            
            x = (int) (x0 + (Math.cos(a) * v * t));
            x = x + x0;
            pf = (v * Math.sin(a) * t - 0.5 * 9.8 * t * t);

            y = (int) (y0 - pf);

            this.v.pelota.setLocation(x, y);
            
            if (y >= 900) {
                mg.flag = false;
//                this.v.pelota.setLocation(100, (900-this.v.basesita.getHeight()));
//                this.v.pelota.setIcon(null);
                this.v.pelotero2.setIcon(this.v.escalajudequi);
                
//                if (c.ganador == true) {
//                    JOptionPane.showMessageDialog(null, "Hora de lanzar de " + c.nombre2);
//                }
                break;
            }

            t += 0.1;
            try {
                Thread.sleep(10);
                

            } catch (InterruptedException ex) {
                Logger.getLogger(Mover.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

    }

}

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
public class MoverPaTra extends Thread{
    Ventana v;
    Model m;
    Controller c;

    public MoverPaTra(Ventana v,Model m, Controller c) {
        this.v = v;
        this.m=m;
        this.c=c;
    }

    @Override
    public void run() {
        double t=0;
        int x0=550,x=0,y=1000,y0=v.pelota.getLocation().y;
        double a=Math.toRadians(c.angulo),pf=0.0;
        int v=c.velocidad;
        this.v.pelota.setIcon(this.v.escalaiz);
        this.v.pelotero1.setIcon(this.v.escalagifpelo1);
      
        while (m.flag) {
            x=(int)(x0-(Math.cos(a)*v*t));
            x=x+x0;
            pf=(v*Math.sin(a)*t-0.5*9.8*t*t);

            y=(int)(y0-pf);
            
            this.v.pelota.setLocation(x, y);
            if (y>=900) {
                m.flag=false;
                this.v.pelota.setLocation(100, (900-this.v.bsesita.getHeight()));
                this.v.pelota.setIcon(null);
                this.v.pelotero1.setIcon(this.v.escalajuizqui);
                if (c.ganador==true) {
                    JOptionPane.showMessageDialog(null, "Hora de lanzar de "+c.nombre1);
                }
                break;
            }
            

            t+=0.1;
            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                Logger.getLogger(Mover.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    }
    


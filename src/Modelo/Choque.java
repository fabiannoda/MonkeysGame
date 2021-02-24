/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Controller;
import static Modelo.Model.edificios;
import Vista.Ventana;

import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class Choque extends Thread {

    private Ventana v;
    Model m;
    Controller c;

    public Choque(Ventana v, Model m, Controller c) {
        this.v = v;
        this.m = m;
        this.c = c;
    }

    @Override
    public void run() {
        while (m.flag) {
            int x = v.pelota.getLocation().x + v.pelota.getWidth();
            int y = v.pelota.getLocation().y + v.pelota.getHeight();
            int pos = x / 100;
            pos = pos - 3;
            System.out.println(pos);
            if (pos >= 0 && pos <= 6) {
                for (int i = 0; i < edificios.get(pos).getBotones().size(); i++) {
                    int x1 = edificios.get(pos).getBotones().get(i).getLocation().x;
                    int y1 = edificios.get(pos).getBotones().get(i).getLocation().y;
                    int x2 = x1 + edificios.get(pos).getBotones().get(i).getWidth();
                    int y2 = y1 + edificios.get(pos).getBotones().get(i).getHeight();

                    if (x >= x1 && y >= y1) {
                        if (x <= x2 && y <= y2) {
                            m.flag = false;
                            JOptionPane.showMessageDialog(null, "Hora de lanzar de " + c.nombre2);
                            EraseFila(pos, i);
                            this.v.pelota.setLocation(1150, 900 - this.v.basesita.getHeight());
                            this.v.pelota.setIcon(null);
                            this.v.pelotero2.setIcon(this.v.escalajudequi);
                            break;
                        }

                    }

                }
            }

        }
    }

    private void EraseFila(int pos, int i) {
        int fila = edificios.get(pos).getBotones().get(i).getLocation().y;

        for (int j = 0; j < edificios.get(pos).getBotones().size(); j++) {
            if (edificios.get(pos).getBotones().get(j).getLocation().y == fila) {
                for (int k = 0; k < 3; k++) {
                    v.remove(edificios.get(pos).getBotones().get(j));
                    edificios.get(pos).getBotones().remove(j);
                    v.repaint();

                }

            }
        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Ventana;
import Modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class Controller implements ActionListener {

    public Ventana v;
    public Model m;
    public ModeloGenetico mg;
    public boolean ganador = true;
    public int turno = 0;
    public String nombre1, nombre2;
    public int velocidad, angulo;

    public Controller(Ventana v, Model m, ModeloGenetico mg) {
        this.v = v;
        this.m = m;
        this.mg=mg;
        v.setVisible(true);
        
//        m.Construir();
//        nombre1 = JOptionPane.showInputDialog(null, "Ingrese el nombre del jugador", "Ingreso de nombres", 0);
//        v.nombre1.setText(nombre1);
//        nombre2 = JOptionPane.showInputDialog(null, "Ingrese el nombre del jugador", "Ingreso de nombres", 0);
//        v.nombre2.setText(nombre2);
//
//        JOptionPane.showMessageDialog(null, "Hora de lanzar para " + nombre1);
        this.v.txtvelocidad1.addActionListener(this);
        this.v.txtangulo1.addActionListener(this);
        this.v.txtangulo2.addActionListener(this);
        this.v.txtvelocidad2.addActionListener(this);
        this.v.lanzar1.addActionListener(this);
        this.v.lanzar2.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == v.txtvelocidad1) {
            v.txtangulo1.setEnabled(true);
            v.txtvelocidad1.transferFocus();
        }
        if (e.getSource() == v.txtangulo1) {
            v.lanzar1.setEnabled(true);
        }
        if (e.getSource() == v.lanzar1) {
            m.flag = true;
            turno = 1;
//            Mover movi = new Mover(v, m, this);
            Choque coli = new Choque(v, m, this);
//            GetGanador get = new GetGanador(v, m, this);

            try {
                angulo = Integer.parseInt(v.txtangulo1.getText());
                velocidad = Integer.parseInt(v.txtvelocidad1.getText());
//                movi.start();
                coli.start();
//                get.start();

            } catch (NumberFormatException i) {
                JOptionPane.showMessageDialog(null, "Ingrese unicamente valores numéricos");
                JOptionPane.showMessageDialog(null, "Por bobo pierde turno");
            }

            v.txtangulo1.setEnabled(false);
            v.txtvelocidad1.setEnabled(false);
            v.lanzar1.setEnabled(false);
            v.txtangulo2.setEnabled(true);
            v.txtangulo2.transferFocus();
        }
        if (e.getSource() == v.txtangulo2) {
            v.txtvelocidad2.setEnabled(true);
            v.txtangulo2.transferFocus();
        }
        if (e.getSource() == v.txtvelocidad2) {
            v.lanzar2.setEnabled(true);
        }
        if (e.getSource() == v.lanzar2) {
            m.flag = true;
            turno = 2;
            MoverPaTra mo = new MoverPaTra(v, m, this);
            ChoquePaTra cho = new ChoquePaTra(v, m, this);
//            GetGanador ga = new GetGanador(v, m, this);
            try {
                angulo = Integer.parseInt(v.txtangulo2.getText());
                velocidad = Integer.parseInt(v.txtvelocidad2.getText());
                mo.start();
                cho.start();
//                ga.start();
            } catch (NumberFormatException h) {
                JOptionPane.showMessageDialog(null, "Ingrese unicamente valores numéricos");
                JOptionPane.showMessageDialog(null, "Por bobo pierde turno");
            }

            v.txtvelocidad1.setEnabled(true);
            v.txtangulo2.setEnabled(false);
            v.txtvelocidad2.setEnabled(false);
            v.lanzar2.setEnabled(false);
            v.txtvelocidad1.transferFocus();

        }
    }

}

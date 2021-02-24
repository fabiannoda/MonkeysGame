/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Controller;
import Vista.Ventana;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class ModeloGenetico {

    public Ventana v;

    public boolean flag = true;
    private boolean flagsito = true;
    public int turno = 1;
    public ArrayList<Gen> cromosomas = new ArrayList<>();

    public ModeloGenetico(Ventana v) {
        this.v = v;

    }

    public void AlgoritmoGenetico() {
        Mover m = new Mover(v, this);
        GetGanador get=new GetGanador(v, this);
        for (int i = 0; i < 100; i++) {
            int velocidad = (int) (Math.random() * 200);
            int angulo = (int) (Math.random() * 90);
            Gen g = new Gen(velocidad, angulo, GetFitness(angulo, velocidad));
            cromosomas.add(g);
        }
        for (int i = 0; i < cromosomas.size(); i++) {
            System.out.println(cromosomas.get(i).getFitness());
        }
        int gene = 1;
        while (flagsito) {
            for (int i = 0; i < cromosomas.size(); i++) {
                if (cromosomas.get(i).getFitness() >= 1) {
                    NewGeneration(cromosomas);
                    gene++;
                    v.generacion.setText(String.valueOf(gene));
                } else {
                    flagsito = false;
                    m.run(cromosomas.get(i));
                    get.start();
                    System.out.println(cromosomas.get(i).getFitness());
                    JOptionPane.showMessageDialog(null, "La solucion mas aproximada fue:Angulo "+cromosomas.get(i).getAngulo()+"° Velocidad: "+cromosomas.get(i).getVelocidad()+". En la generación # "+gene);
                    System.exit(0);
                }
            }

        }

    }

    private int GetFitness(int angulo, int velocidad) {
        int fitness = 0;
        double y=0;
        int Ybase = v.pelotero1.getLocation().y;
        if (v.pelotero2.getLocation().y>Ybase) {
           y =((Ybase) + (((Math.tan(Math.toRadians(angulo))) * (v.pelotero1.getLocation().x - v.pelotero2.getLocation().x)) - (9.8 / ((2 * velocidad * velocidad) * (Math.cos(Math.toRadians(angulo)) * Math.cos(Math.toRadians(angulo))))) * ((v.pelotero1.getLocation().x - v.pelotero2.getLocation().x) * (v.pelotero1.getLocation().x - v.pelotero2.getLocation().x)))); 
        }else{
            y =((Ybase) + (((Math.tan(Math.toRadians(angulo))) * (v.pelotero1.getLocation().x - v.pelotero2.getLocation().x)) - (9.8 / ((2 * velocidad * velocidad) * (Math.cos(Math.toRadians(angulo)) * Math.cos(Math.toRadians(angulo))))) * ((v.pelotero1.getLocation().x - v.pelotero2.getLocation().x) * (v.pelotero1.getLocation().x - v.pelotero2.getLocation().x))));
        }
        if (v.pelotero2.getLocation().y < Ybase) {
            fitness =(int) (Math.abs(y-Ybase));
        
        }else{
            fitness=(int)(Math.abs(Ybase-y));
        }
        
//        System.out.println(fitness+" "+angulo+" "+velocidad);
        return fitness;
    }

    private void NewGeneration(ArrayList<Gen> a) {
//        Collections.sort(a, (Gen g1, Gen g2) -> new Integer(g1.getFitness()).compareTo(g2.getFitness()));
        int i = 0;
        Gen nuevo = new Gen(a.get(i).getVelocidad(), a.get(i + 1).getAngulo(), GetFitness(a.get(i + 1).getAngulo(), a.get(i).getVelocidad()));
        Gen novo = new Gen(a.get(i + 2).getVelocidad(), a.get(i + 3).getAngulo(), GetFitness(a.get(i + 3).getAngulo(), a.get(i + 2).getVelocidad()));
        a.remove(i);
        a.remove(i + 2);
        a.add(nuevo);
        a.add(novo);
        System.out.println(nuevo.fitness);

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author USER
 */
public class Gen {
    int velocidad;
    int angulo;
    int fitness;

    public Gen(int velocidad, int angulo, int fitness) {
        this.velocidad = velocidad;
        this.angulo = angulo;
        this.fitness = fitness;
    }
    
    
    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getAngulo() {
        return angulo;
    }

    public void setAngulo(int angulo) {
        this.angulo = angulo;
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }
    
}

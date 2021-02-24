/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Vista.Ventana;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author USER
 */
public class Edificio {
    private static Ventana v;
    int x,y;
    public int Identifier;
    
   private  ArrayList<JButton> botones;

    public Edificio(Ventana v, int x, int y,int columnas, int Identifier) {
        this.v = v;
        this.x = x;
        this.y = y;
        int filas=5;
        this.Identifier=Identifier;
        botones=new ArrayList<>();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                JButton boton=new JButton(v.escala);
                boton.setBounds(x, y, 20, 20);
                botones.add(boton);
                
                y+=20;
                
                
                
            }
            x+=20;
            y=this.y;
            
        }
        PaintEdificio(botones);
        

    }
    
    
    public static void PaintEdificio(ArrayList<JButton> buttons){
    
        for (int i = 0; i < buttons.size(); i++) {
            
            Edificio.v.p.add(buttons.get(i));
            v.p.repaint();
            
            
        }
        v.p.add(v.fondo);
    }

    /**
     * @return the botones
     */
    public ArrayList<JButton> getBotones() {
        return botones;
    }
    

   
}

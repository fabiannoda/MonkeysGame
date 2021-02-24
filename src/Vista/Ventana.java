/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


/**
 *
 * @author USER
 */
public class Ventana extends JFrame{
    
    public JLabel lblvelocidad1=new JLabel("Velocidad");
    public JTextField txtvelocidad1=new JTextField();
    public JLabel lblangulo1=new JLabel("Ángulo");
    public JTextField txtangulo1=new JTextField();
    public JLabel lblvelocidad2=new JLabel("Velocidad");
    public JTextField txtvelocidad2=new JTextField();
    public JLabel lblangulo2=new JLabel("Ángulo");
    public JTextField txtangulo2=new JTextField();
    public JButton lanzar1=new JButton("Lanzar!");
    public JButton lanzar2=new JButton("Lanzar!");
    
    public JLabel nombre1=new JLabel();
    public JLabel nombre2=new JLabel();
    
    public JLabel generacion=new JLabel();
    
    public ImageIcon judequi=new ImageIcon("src/Vista/jugadequi.png");
    public ImageIcon escalajudequi=new ImageIcon(judequi.getImage().getScaledInstance(200, 100, java.awt.Image.SCALE_DEFAULT));
    public ImageIcon juizqui=new ImageIcon("src/Vista/jugaizqui.png");
    public ImageIcon escalajuizqui=new ImageIcon(juizqui.getImage().getScaledInstance(200, 100, java.awt.Image.SCALE_DEFAULT));
    public JLabel pelotero1=new JLabel(escalajuizqui);
    public JLabel pelotero2=new JLabel(escalajudequi);
    
    public ImageIcon gifpelo2=new ImageIcon("src/Vista/jugade.gif");
    public ImageIcon escalagifpelo2=new ImageIcon(gifpelo2.getImage().getScaledInstance(300, 200, java.awt.Image.SCALE_DEFAULT));
    public ImageIcon gifpoelo1=new ImageIcon("src/Vista/jugaiz.gif");
    public ImageIcon escalagifpelo1=new ImageIcon(gifpoelo1.getImage().getScaledInstance(300, 200, java.awt.Image.SCALE_DEFAULT));
    
    
    
    public JLabel pelota=new JLabel();
    public ImageIcon de=new ImageIcon("src/Vista/pelotaiz.gif");
    public ImageIcon escalade=new ImageIcon(de.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_DEFAULT));
    public ImageIcon iz=new ImageIcon("src/Vista/pelotade.gif");
    public ImageIcon escalaiz=new ImageIcon(iz.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_DEFAULT));
    
            
    
   

    public ImageIcon imag = new ImageIcon("src/Vista/Caja.png");
    public ImageIcon fon=new ImageIcon("src/Vista/Selva.jpg");
    public ImageIcon base=new ImageIcon("src/Vista/base.png");
    public ImageIcon base2=new ImageIcon("src/Vista/base.png");
    int ancho=20;
    int a=1360,b=700;
    public int h=(int)((Math.random()*500)+350),anc=200;
    public int h2=(int)((Math.random()*500)+350);
    public ImageIcon escala2=new ImageIcon(fon.getImage().getScaledInstance(a, b, java.awt.Image.SCALE_DEFAULT));
    public ImageIcon escala=new ImageIcon(imag.getImage().getScaledInstance(ancho, ancho, java.awt.Image.SCALE_DEFAULT));
    public ImageIcon escalabase=new ImageIcon(base.getImage().getScaledInstance(anc, h2, java.awt.Image.SCALE_DEFAULT));
    public ImageIcon escalabase2=new ImageIcon(base2.getImage().getScaledInstance(anc, h, java.awt.Image.SCALE_DEFAULT));
    public JLabel basesita=new JLabel(escalabase2);
    public JLabel fondo=new JLabel(escala2);
    public JLabel bsesita=new JLabel(escalabase);
    public JPanel p=new JPanel();

    

    public Ventana() {
        this.setTitle("Monitos");
        this.setLayout(null);
        this.setSize(2000, 1000);
        p.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(p);
        p.setLayout(null);
        
        //Fondo y botones
        fondo.setBounds(0, 0, a, b);
        fondo.setLayout(null);
        bsesita.setBounds(50,1000-h, anc, h);
        basesita.setBounds(1100, 1000-h2, anc, h2);

        
        pelota.setBounds(100, (850-bsesita.getHeight()), 40, 40);
        
        //nombres
        nombre1.setBounds(125, 1000-bsesita.getHeight(), 100, 25);
        nombre2.setBounds(1175, 1000-basesita.getHeight(), 100, 25);
        
        //carteles de datos para lanzar
        lblvelocidad1.setBounds(300, 620, 100, 25);
        lblvelocidad1.setForeground(Color.BLACK);
        txtvelocidad1.setBounds(305, 640, 50, 25);
        lblangulo1.setBounds(400, 620, 100, 25);
        lblangulo1.setForeground(Color.BLACK);
        txtangulo1.setBounds(400, 640, 50, 25);
        lanzar1.setBounds(470, 640, 80, 25);
        lanzar1.setForeground(Color.GREEN);
        lblvelocidad2.setBounds(950, 620, 100, 25);
        lblvelocidad2.setForeground(Color.black);
        txtvelocidad2.setBounds(950, 640, 50, 25);
        lblangulo2.setBounds(850, 620, 100, 25);
        lblangulo2.setForeground(Color.BLACK);
        txtangulo2.setBounds(850, 640, 50, 25);
        lanzar2.setBounds(740, 640, 90, 25);
        lanzar2.setForeground(Color.GREEN);
        
        pelotero1.setBounds(1100, 850-bsesita.getHeight(), 200, 100);
        pelotero2.setBounds(30, 850-bsesita.getHeight(), 300,200);
        
        generacion.setBounds(500, 200, 500, 25);
        generacion.setForeground(Color.red);
        
        p.add(nombre1);
        p.add(nombre2);
        
        p.add(basesita);

        p.add(bsesita);

        p.add(generacion);
        
        p.add(pelotero2);
        p.add(pelotero1);
        
        p.add(pelota);
        
        p.add(lblvelocidad1);
        p.add(txtvelocidad1);
        p.add(lblangulo1);
        p.add(txtangulo1);
        p.add(lanzar1);
        p.add(lblvelocidad2);
        p.add(txtvelocidad2);
        p.add(lblangulo2);
        p.add(txtangulo2);
        p.add(lanzar2);
        
        this.basesita.setVisible(false);
        this.bsesita.setVisible(false);
        
        p.add(fondo);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.txtangulo1.setEnabled(false);
        this.txtvelocidad2.setEnabled(false);
        this.txtangulo2.setEnabled(false);
        this.lanzar1.setEnabled(false);
        this.lanzar2.setEnabled(false);
        this.txtvelocidad1.setEnabled(false);
    }
    
}

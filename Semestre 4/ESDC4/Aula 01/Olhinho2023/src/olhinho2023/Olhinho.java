/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package olhinho2023;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Prof. Dr. David Buzatto
 */
public class Olhinho {
    
    private int x;
    private int y;
    
    private int raio;
    private int raioPupila;
    
    private int diametro;
    private int diametroPupila;
    
    private double angulo;
    
    public void desenhar( Graphics2D g2d ) {
        
        g2d = (Graphics2D) g2d.create();
        
        g2d.rotate( angulo, x, y );
        
        g2d.setColor( Color.WHITE );
        g2d.fillOval( x - raio, y - raio, diametro, diametro );
        
        g2d.setColor( Color.BLACK );
        g2d.drawOval( x - raio, y - raio, diametro, diametro );
        
        g2d.fillOval( x + raioPupila, y - raioPupila, diametroPupila, diametroPupila );
        
        g2d.dispose();
        
    }

    public void atualizarAngulo( int xMouse, int yMouse ) {
        angulo = Math.atan2( yMouse - y, xMouse - x );
    }
    public double getAngulo() {
        return angulo;
    }

    public void setAngulo( double angulo ) {
        this.angulo = angulo;
    }

    public int getRaio() {
        return raio;
    }

    public void setRaio( int raio ) {
        this.raio = raio;
        this.raioPupila = raio / 4;
        this.diametro = raio * 2;
        this.diametroPupila = this.raioPupila * 2;
    }

    public int getX() {
        return x;
    }

    public void setX( int x ) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY( int y ) {
        this.y = y;
    }
    
}

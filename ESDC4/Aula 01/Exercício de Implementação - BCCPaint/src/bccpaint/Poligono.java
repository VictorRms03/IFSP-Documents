/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bccpaint;

import java.awt.Graphics2D;
import java.awt.geom.Path2D;

/**
 *
 * @author victo
 */
public class Poligono extends Forma {
    
    private int numLados;  
    
    public Poligono(int numLados) {
        this.numLados = numLados;
    }
    
    @Override
    public void desenhar( Graphics2D g2d ) {
        
        g2d = (Graphics2D) g2d.create();
        
        //Não existe poligono com menos de 3 lados
        if(numLados<3) { numLados=3; }
        
        double hypot = Math.hypot(xFim-xIni, yFim-yIni);
        double angle = Math.atan2(yFim-yIni, xFim-xIni);
        double angleIncrement = 2*Math.PI/numLados;
                
        Path2D.Double poligono = new Path2D.Double();
        poligono.moveTo( xFim, yFim );
        
        for(int i=1; i<numLados; i++){
            
            double xAtual = Math.cos(angle+i*angleIncrement) * hypot + xIni;
            double yAtual = Math.sin(angle+i*angleIncrement) * hypot + yIni;
            
            poligono.lineTo( xAtual, yAtual);  
            
        }
                
        poligono.closePath();

        g2d.setColor( corPreenchimento );
        g2d.fill( poligono );

        g2d.setColor( corContorno );
        g2d.draw( poligono );


        g2d.dispose();
        
    }

    public void setNumLados(int numLados) {
        this.numLados = numLados;
    }
}
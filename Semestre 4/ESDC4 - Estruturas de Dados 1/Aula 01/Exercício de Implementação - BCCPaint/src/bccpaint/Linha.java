/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bccpaint;

import java.awt.Graphics2D;

/**
 *
 * @author bv110309
 */
public class Linha extends Forma {

    @Override
    public void desenhar( Graphics2D g2d ) {
        
        g2d = (Graphics2D) g2d.create();
        
        g2d.setColor( corContorno );
        g2d.drawLine( xIni, yIni, xFim, yFim );
        
        g2d.dispose();
        
    }
    
}

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
public class Retangulo extends Forma {
    
    @Override
    public void desenhar( Graphics2D g2d ) {
        
        g2d = (Graphics2D) g2d.create();
        
        int xIniD = xIni < xFim ? xIni : xFim;
        int yIniD = yIni < yFim ? yIni : yFim;
        int xFimD = xIni > xFim ? xIni : xFim;
        int yFimD = yIni > yFim ? yIni : yFim;
        
        g2d.setColor( corPreenchimento );
        g2d.fillRect( xIniD, yIniD, xFimD-xIniD, yFimD-yIniD );
        
        g2d.setColor( corContorno );
        g2d.drawRect( xIniD, yIniD, xFimD-xIniD, yFimD-yIniD );
        
        g2d.dispose();
        
    }
    
}

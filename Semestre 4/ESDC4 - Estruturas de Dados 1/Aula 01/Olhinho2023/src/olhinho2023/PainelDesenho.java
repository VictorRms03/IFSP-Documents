/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package olhinho2023;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Prof. Dr. David Buzatto
 */
public class PainelDesenho extends JPanel {

    private List<Olhinho> olhinhos;
    
    public PainelDesenho() {
        
        olhinhos = new ArrayList<>();
        
        addMouseListener( new MouseAdapter(){
            
            @Override
            public void mousePressed( MouseEvent e ) {
                
                Olhinho novoOlhinho = new Olhinho();
                novoOlhinho.setX( e.getX() );
                novoOlhinho.setY( e.getY() );
                novoOlhinho.setRaio( 30 + (int) ( Math.random() * 50 ) );
                
                olhinhos.add( novoOlhinho );
                
                repaint();
                
            }
            
        });
        
        addMouseMotionListener( new MouseAdapter() {
            
            @Override
            public void mouseMoved( MouseEvent e ) {
                for ( Olhinho o : olhinhos ) {
                    o.atualizarAngulo( e.getX(), e.getY() );
                }
                repaint();
            }
            
        });
        
    }
    
    @Override
    protected void paintComponent( Graphics g ) {
        
        super.paintComponent( g );
        
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint( 
                RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON );
        
        for ( Olhinho o : olhinhos ) {
            o.desenhar( g2d );
        }
        
        g2d.dispose();
        
    }
    
}

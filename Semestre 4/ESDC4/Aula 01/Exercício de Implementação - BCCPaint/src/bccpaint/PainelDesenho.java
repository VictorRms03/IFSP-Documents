/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bccpaint;

import java.awt.Color;
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
 * @author bv110309
 */
public class PainelDesenho extends JPanel {
    
    private Color corContorno;
    private Color corPreenchimento;
    
    private Forma formaTemporaria;
    private List<Forma> formas;
    
    private FormaAtual formaAtual;
    
    private int numLados;
    
    public PainelDesenho() {
        
        formaAtual = FormaAtual.LINHA;
        
        corContorno = Color.BLACK;
        corPreenchimento = Color.WHITE;
        
        
        formas = new ArrayList<>();
        
        addMouseListener( new MouseAdapter(){
            
            @Override
            public void mousePressed(MouseEvent e) {
                
                switch ( formaAtual ) {
                    case LINHA:
                        formaTemporaria = new Linha();
                        break;
                    case RETANGULO:
                        formaTemporaria = new Retangulo();
                        break;
                    case ELIPSE:
                        formaTemporaria = new Elipse();
                        break;
                    case POLIGONO:
                        formaTemporaria = new Poligono(numLados);
                        break;
                }
                
                formaTemporaria.setXIni( e.getX() );
                formaTemporaria.setYIni( e.getY() );
                formaTemporaria.setCorContorno( corContorno );
                formaTemporaria.setCorPreenchimento( corPreenchimento );
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                formaTemporaria.setXFim( e.getX() );
                formaTemporaria.setYFim( e.getY() );
                formas.add( formaTemporaria );
                formaTemporaria = null;
                repaint();
            }
            
        });
        
        addMouseMotionListener( new MouseAdapter(){
            
            @Override
            public void mouseDragged(MouseEvent e) {
                formaTemporaria.setXFim( e.getX() );
                formaTemporaria.setYFim( e.getY() );
                repaint();
            }
            
        });
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint( 
                RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON );
        
        g2d.setColor( Color.WHITE );
        g2d.fillRect( 0, 0, getWidth(), getHeight() );
        
        for ( Forma f : formas ) {
            f.desenhar( g2d );
        }
        
        if ( formaTemporaria != null ) {
            formaTemporaria.desenhar( g2d );
        }
        
    }

    public void setCorContorno(Color corContorno) {
        this.corContorno = corContorno;
    }

    public void setCorPreenchimento(Color corPreenchimento) {
        this.corPreenchimento = corPreenchimento;
    }

    public void setFormaAtual(FormaAtual formaAtual) {
        this.formaAtual = formaAtual;
    }

    public void setNumLados(int numLados) {
        this.numLados = numLados;
    }
    
}

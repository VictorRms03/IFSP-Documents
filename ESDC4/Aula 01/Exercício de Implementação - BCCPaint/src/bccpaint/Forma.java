/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bccpaint;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author bv110309
 */
public abstract class Forma {
    
    protected int xIni;
    protected int yIni;
    protected int xFim;
    protected int yFim;
    
    protected Color corContorno = Color.BLACK;
    protected Color corPreenchimento = Color.WHITE;
    
    public abstract void desenhar( Graphics2D g2d );

    public int getXIni() {
        return xIni;
    }

    public void setXIni(int xIni) {
        this.xIni = xIni;
    }

    public int getYIni() {
        return yIni;
    }

    public void setYIni(int yIni) {
        this.yIni = yIni;
    }

    public int getXFim() {
        return xFim;
    }

    public void setXFim(int xFim) {
        this.xFim = xFim;
    }

    public int getYFim() {
        return yFim;
    }

    public void setYFim(int yFim) {
        this.yFim = yFim;
    }

    public Color getCorContorno() {
        return corContorno;
    }

    public void setCorContorno(Color corContorno) {
        this.corContorno = corContorno;
    }

    public Color getCorPreenchimento() {
        return corPreenchimento;
    }

    public void setCorPreenchimento(Color corPreenchimento) {
        this.corPreenchimento = corPreenchimento;
    }
    
}

package lista1;

import java.util.Scanner;

public class Bee1011 {
    
    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        
        double r;
        double vol;
        
        r = teclado.nextDouble();
        
        vol = 1.333333333333333333333333333333 * 3.14159 * r*r*r;
        
        System.out.printf("VOLUME = %.3f\n", vol);
        
    }
}

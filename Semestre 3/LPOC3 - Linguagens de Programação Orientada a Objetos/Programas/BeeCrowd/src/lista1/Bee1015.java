package lista1;

import java.util.Scanner;


public class Bee1015 {
    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        
        double x1 = teclado.nextDouble();
        double y1 = teclado.nextDouble();
        double x2 = teclado.nextDouble();
        double y2 = teclado.nextDouble();
        
        double distance = Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
        
        System.out.printf( "%.4f\n", distance);
                
    }
}

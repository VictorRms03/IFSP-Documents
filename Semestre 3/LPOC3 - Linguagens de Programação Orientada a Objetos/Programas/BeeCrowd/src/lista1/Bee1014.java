package lista1;

import java.util.Scanner;


public class Bee1014 {
    
    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        
        int x = teclado.nextInt();
        double y = teclado.nextDouble();
        
        System.out.printf( "%.3f km/l\n", x/y);
    }
}

package lista1;

import java.util.Scanner;


public class Bee1036 {
    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        
        double a = teclado.nextDouble();
        double b = teclado.nextDouble();
        double c = teclado.nextDouble();
        
        double delta = b*b - (4*a*c);
        
        if (a != 0 && delta >= 0){
            
            double x1 = (-b + Math.sqrt(delta))/(2*a);
            double x2 = (-b - Math.sqrt(delta))/(2*a);

            System.out.printf( "R1 = %.5f\n", x1);
            System.out.printf( "R2 = %.5f\n", x2);
        
        } else {
            System.out.println( "Impossivel calcular");
        }
    }
}

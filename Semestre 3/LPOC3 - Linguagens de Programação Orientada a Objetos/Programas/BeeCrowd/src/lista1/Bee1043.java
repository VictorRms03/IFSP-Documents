package lista1;

import java.util.Scanner;


public class Bee1043 {
    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        
        double a = teclado.nextDouble();
        double b = teclado.nextDouble();
        double c = teclado.nextDouble();
        
        
        if (a<b+c && b<a+c && c<a+b){
            System.out.printf("Perimetro = %.1f\n", a + b + c);
        } else {
            System.out.printf("Area = %.1f\n", c * (a + b) / 2);
        }
    }
}

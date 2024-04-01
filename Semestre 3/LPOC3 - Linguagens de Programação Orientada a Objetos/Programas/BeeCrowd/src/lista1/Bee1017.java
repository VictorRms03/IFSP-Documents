package lista1;

import java.util.Scanner;


public class Bee1017 {
 
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        
        double time = teclado.nextInt();
        double speed = teclado.nextInt();
        double consume = (time*speed)/12;
        
        System.out.printf( "%.3f\n", consume);
        
        
    }
}

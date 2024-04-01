package lista1;

import java.util.Scanner;


public class Bee1044 {
    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        
        int a = teclado.nextInt();
        int b = teclado.nextInt();
        
        if (a%b == 0 || b%a == 0){
            System.out.println( "Sao Multiplos");
        } else {
            System.out.println( "Nao sao Multiplos");
        }
    }
}

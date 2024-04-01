package lista1;

import java.util.Scanner;


public class Bee1013 {
    
    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        
        int a = teclado.nextInt();
        int b = teclado.nextInt();
        int c = teclado.nextInt();
        
        if (a>b && a>c){
            System.out.println(a +" eh o maior");
        } else if (b>c){
            System.out.println(b +" eh o maior");
        } else {
            System.out.println(c +" eh o maior");
        }
    }
}

package lista1;

import java.util.Scanner;


public class Bee1019 {
    public static void main(String[] args){
        
        Scanner teclado =  new Scanner(System.in);
        
        int n = teclado.nextInt();
        int sec = 0;
        int min = 0;
        int hor = 0;
        
        while (n>=3600){
            n = n - 3600;
            hor++;
        }
        
        while (n>=60){
            n = n - 60;
            min++;
        }
        
        while (n>0){
            n--;
            sec++;
        }
        
        System.out.printf( "%d:%d:%d\n", hor, min, sec);
       
        
    }
}

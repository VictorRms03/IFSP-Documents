package lista1;

import java.util.Scanner;


public class Bee1020 {
    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        
        int age = teclado.nextInt();
        int ano = 0;
        int mes = 0;
        int dia = 0;
        
        while (age >= 365){
            age = age - 365;
            ano++;
        }
        
        while (age >= 30){
            age = age - 30;
            mes++;            
        }
        
        while (age > 0){
            age--;
            dia++;
        }
        
        System.out.printf( "%d ano(s)\n", ano);
        System.out.printf( "%d mes(es)\n", mes);
        System.out.printf( "%d dia(s)\n", dia);
        
        
    }
}

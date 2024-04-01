package lista1;

import java.util.Scanner;


public class Bee1018 {

    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        
        int x = teclado.nextInt();
        int nota100 = 0;
        int nota50 = 0;
        int nota20 = 0;
        int nota10 = 0;
        int nota5 = 0;
        int nota2 = 0;
        int nota1 = 0;
        
        System.out.println(x);
                
                
        while (x>=100){
            nota100 = nota100 + 1;
            x = x - 100;
        }
        
        while (x>=50){
            nota50 = nota50 + 1;
            x = x - 50;
        }
        
        while (x>=20){
            nota20 = nota20 + 1;
            x = x - 20;
        }
        
        while (x>=10){
            nota10 = nota10 + 1;
            x = x - 10;
        }
        
        while (x>=5){
            nota5 = nota5 + 1;
            x = x - 5;
        }
        
        while (x>=2){
            nota2 = nota2 + 1;
            x = x - 2;
        }
        
        while (x>=1){
            nota1 = nota1 + 1;
            x = x - 1;
        }
        
        System.out.println(nota100 + " nota(s) de R$ 100,00");
        System.out.println(nota50 + " nota(s) de R$ 50,00");
        System.out.println(nota20 + " nota(s) de R$ 20,00");
        System.out.println(nota10 + " nota(s) de R$ 10,00");
        System.out.println(nota5 + " nota(s) de R$ 5,00");
        System.out.println(nota2 + " nota(s) de R$ 2,00");
        System.out.println(nota1 + " nota(s) de R$ 1,00");
        
    }
}

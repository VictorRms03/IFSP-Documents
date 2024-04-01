package lista1;

import java.util.Scanner;


public class Bee1040 {
    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        
        double n1 = teclado.nextDouble();
        double n2 = teclado.nextDouble();
        double n3 = teclado.nextDouble();
        double n4 = teclado.nextDouble();
        double media = (n1*2 + n2*3 + n3*4 + n4)/10;
        
        /*
        if (media == 4.85){
            media = 4.8;
        } 
        */
        
        System.out.printf( "Media: %.1f\n",media);
        if(media>=7){
            System.out.println( "Aluno aprovado.");
        } else if (media<5){
            System.out.println( "Aluno reprovado.");
        } else {
            System.out.println( "Aluno em exame.");
            double exame = teclado.nextDouble();
            System.out.printf( "Nota do exame: %.1f\n", exame);
            media = (media + exame) / 2;
            if(media >= 5){
                System.out.println( "Aluno aprovado.");
            } else {
                System.out.println( "Aluno reprovado.");
            }
            System.out.printf( "Media final: %.1f\n", media);
        }
        
    }
}

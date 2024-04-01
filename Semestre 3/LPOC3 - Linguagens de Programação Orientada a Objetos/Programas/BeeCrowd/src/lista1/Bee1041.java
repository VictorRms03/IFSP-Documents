package lista1;

import java.util.Scanner;

public class Bee1041 {
   public static void main(String[] args){
       
       Scanner teclado = new Scanner(System.in);
       
       double x = teclado.nextDouble();
       double y = teclado.nextDouble();
       
       if (x==0){
          if (y==0){
              System.out.println( "Origem");
          } else {
              System.out.println( "Eixo Y");
          }
       } else if (x>0){
           if (y>0){
               System.out.println( "Q1");
           } else if (y<0){
               System.out.println( "Q4");
           }
       } else {
           if (y>0){
               System.out.println( "Q2");
           } else if (y<0){
               System.out.println( "Q3");
           }
       }
       
       if (y==0 && x!=0){
           System.out.println( "Eixo X");
       }
   }
}

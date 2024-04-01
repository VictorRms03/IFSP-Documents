package ambientacao;

import java.util.Scanner;

public class Bee1064 {
    
    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        int positivos = 0;
        double soma = 0;
        
        for(int i=0; i<6; i++){
            double num = teclado.nextDouble();
            if(num > 0){
                positivos++;
                soma = soma + num;
            }
        }
        double media = soma/positivos;
        System.out.println(positivos + " valores positivos");
        System.out.printf("%.1f\n", media);
    }
}

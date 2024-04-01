package ambientacao;

import java.util.Scanner;

public class Bee1067 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        
        int num;
        
        num = teclado.nextInt();
        
        for(int i=1; i<=num; i++){
            if(i%2 != 0){
                System.out.println(i);
            }
        }
    }
}

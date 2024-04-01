package lista1;

import java.util.Scanner;


public class Bee1047 {
    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        
        int hini = teclado.nextInt();
        int mini = teclado.nextInt();
        int hfin = teclado.nextInt();
        int mfin = teclado.nextInt();
        int totalini = hini*60 + mini;
        int totalfin = hfin*60 + mfin;
        int duracaototal;
        int duracaoh = 0;
        int duracaom = 0;
        
        if (totalini < totalfin){
            duracaototal = totalfin - totalini;            
        } else {
            duracaototal = 1440 - (totalini - totalfin);
        }
        
        while(duracaototal>=60){
            duracaototal = duracaototal-60;
            duracaoh++;
        }
        
        while(duracaototal>0){
            duracaototal--;
            duracaom++;
        }
        
        System.out.printf( "O JOGO DUROU %d HORA(S) E %d MINUTO(S)\n", duracaoh, duracaom);
    
    }
}
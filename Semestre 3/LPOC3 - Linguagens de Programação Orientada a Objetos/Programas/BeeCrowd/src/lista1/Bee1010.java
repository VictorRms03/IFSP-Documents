package lista1;
import java.util.Scanner;


public class Bee1010 {
    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        
        double aPagar = 0;
        
        for(int i=0; i<2; i++){
            int cod = 0;
            int qtd;
            double preco;
            
            cod = teclado.nextInt();
            qtd = teclado.nextInt();
            preco = teclado.nextDouble();
            
            aPagar = aPagar + (qtd*preco);
            
        }
        System.out.printf("VALOR A PAGAR: R$ %.2f\n", aPagar);
    }
}

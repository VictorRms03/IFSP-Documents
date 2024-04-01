package app;

import java.util.Scanner;

public class Lanche {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        
        System.out.print("Digite o código: ");
        int codigo = teclado.nextInt();
        System.out.print("Digite a quantidade: ");
        int quantidade = teclado.nextInt();
        double total = 0.0;

        switch (codigo) {
            case 1 -> total = quantidade * 4.0;
            case 2 -> total = quantidade * 4.50;
            case 3 -> total = quantidade * 5.0;
            case 4 -> total = quantidade * 2.0;
            case 5 -> total = quantidade * 1.50;
            default -> System.out.println("Opção inválida!");
        }
        System.out.printf("TOTAL R$ %.2f\n", total);
    }
}

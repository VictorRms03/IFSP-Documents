package app;

import java.util.Scanner;

/**
 * Classe de exemplo de utilização do <strong>Java</strong>
 * @author sp070142
 * @version 1.0
 */
public class OlaMundo {
    
    public static void main(String [] args){
        // "configurando" a leitura do teclado
        Scanner teclado = new Scanner(System.in);
        System.out.print("Qual o seu nome? ");
        String nome = teclado.nextLine();
        System.out.println("Olá, " + nome +
                "! Seja bem-vindo(a).");
        System.out.print("Que ano você nasceu? ");
        int ano = teclado.nextInt();
        System.out.println("Você tem "+ (2023 - ano)
                + " anos.");
    }
}

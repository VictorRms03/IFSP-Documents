package loja;

import java.util.Random;

/**
 *
 * @author Victor Ramos
 * @author Samuel Ferla Iamarino
 * @author Vinicius Ramos Deramio
 */
public class Loja {

    public static void main(String[] args) {
        
        Almoxarifado almoxarifado = new Almoxarifado();
        Random random = new Random();
        
        int numPedidos1 = random.nextInt(3) + 1;
        int numPedidos2 = random.nextInt(3) + 1;

        /* Criação dos vendedores (Threads) */
        Vendedor vendedor1 = new Vendedor( 1, numPedidos1, almoxarifado );
        Vendedor vendedor2 = new Vendedor( 2, numPedidos2, almoxarifado );
        
        // Início das threads
        vendedor1.start();
        vendedor2.start();
        
    }
    
}

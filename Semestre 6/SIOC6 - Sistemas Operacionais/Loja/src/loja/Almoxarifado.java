package loja;

import java.util.Random;

/**
 *
 * @author victo
 */
public class Almoxarifado {
    
    // Sincroniza o acesso ao local de separação
    public synchronized void separarRoupas( int idVendedor ) throws InterruptedException {
        
        Random random = new Random();
        
        int tempoSeparacao = 1000 + random.nextInt(9000); // Tempo de separação entre 1 a 10 segundos
        System.out.println( "Almoxarifado comecou a separar para o Vendedor " + idVendedor + " => " + tempoSeparacao/1000 );
        Thread.sleep(tempoSeparacao); // Simula o tempo de separação de roupas
        System.out.println( "Almoxarifado separou para o Vendedor " + idVendedor );
        
        
        Thread.sleep(5000); // Simula o tempo de espera do vendedor para pegar a roupa (5 segundos)
        System.out.println( "Vendedor " + idVendedor + " coletou o item no almoxarifado => 5");
    }
}

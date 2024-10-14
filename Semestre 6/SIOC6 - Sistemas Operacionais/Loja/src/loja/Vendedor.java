package loja;

import java.util.Random;

/**
 *
 * @author victo
 */
public class Vendedor extends Thread {
    
    private int idVendedor;
    private int numPedidos;
    private Almoxarifado almoxarifado;
    
    private Random random = new Random();
    private static final Object lock = new Object();

    public Vendedor( int idVendedor, int numPedidos, Almoxarifado almoxarifado ) {
        this.idVendedor = idVendedor;
        this.numPedidos = numPedidos;
        this.almoxarifado = almoxarifado;
    }
    
    @Override
    public void run() {
        
        for ( int i=1; i<= this.numPedidos; i++ ) {
            
            try {
                
                int tempoSolicitacao = 5000 + this.random.nextInt(15000); // Tempo de solicitação entre 5 e 20 segundos
                Thread.sleep(tempoSolicitacao);
                
                synchronized (lock) {
                    System.out.println( "Vendedor " + this.idVendedor + " solicitou item => " + tempoSolicitacao/1000);
                    this.almoxarifado.separarRoupas( this.idVendedor );
                }
                
            } catch ( InterruptedException e ) {
                System.out.println( "Vendedor " + this.idVendedor + " foi interrompido.");
            }
            
        }
        
    }
    
}

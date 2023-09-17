package victorramos.agenciaturistica;

import java.util.Scanner;

public class AppApenasPrograma {
    public static void main(String args[]){
        
        /* Instanciação de Objetos */
        Scanner teclado = new Scanner(System.in);
        Caminho caminhoCompleto = new Caminho();
        
        System.out.println( "--- Agencia Turistica ---");
        
        while(true){
            /* Variaveis Utilizadas para cada Trecho*/
            int tipoTransporte;
            String origem;
            String destino;
            double distancia;
            int duracaoHoras;
            int duracaoMinutos;
            
            System.out.println( "\nInsira as informações do trecho " + (caminhoCompleto.getNumeroTrechos()+1));
            System.out.println(" - Qual o método de transporte?: ");
            System.out.println("  (1) - A pé ");
            System.out.println("  (2) - Avião ");
            System.out.println("  (3) - Barco ");
            System.out.println("  (4) - Carro ");
            System.out.println("  (5) - Onibus ");
            System.out.println("  (6) - Trem ");
            tipoTransporte = teclado.nextInt();
            teclado.nextLine(); //Consome o '/n' que estava 'Skipando' o proximo teclado.nextLine();
            
            System.out.printf(" - Origem: ");
            origem = teclado.nextLine();
            
            System.out.printf(" - Destino: ");
            destino = teclado.nextLine();
            
            System.out.printf(" - Distância (km): ");
            distancia = teclado.nextDouble();
            
            System.out.println(" - Duração: ");
            System.out.printf("  - Horas: ");
            duracaoHoras = teclado.nextInt();
            
            System.out.printf("  - Minutos: ");
            duracaoMinutos = teclado.nextInt();
            
            switch (tipoTransporte) {
                case 1:
                    TrechoAPe t1 = new TrechoAPe();
                    
                    t1.setOrigem(origem);
                    t1.setDestino(destino);
                    t1.setDistancia(distancia);
                    t1.setDuracao(duracaoHoras, duracaoMinutos);
                    
                    caminhoCompleto.addTrecho(t1);
                    break;
                case 2:
                    TrechoAviao t2 = new TrechoAviao();
                    
                    t2.setOrigem(origem);
                    t2.setDestino(destino);
                    t2.setDistancia(distancia);
                    t2.setDuracao(duracaoHoras, duracaoMinutos);
                    System.out.println( " - Qual o tipo da Passagem?");
                    System.out.println("  (1) - Econômico ");
                    System.out.println("  (2) - Padrão ");
                    System.out.println("  (3) - Premium ");
                    t2.setTipoPassagem(teclado.nextInt());
                    
                    caminhoCompleto.addTrecho(t2);
                    break;
                case 3:
                    TrechoBarco t3 = new TrechoBarco();
                    
                    t3.setOrigem(origem);
                    t3.setDestino(destino);
                    t3.setDistancia(distancia);
                    t3.setDuracao(duracaoHoras, duracaoMinutos);
                    System.out.println( " - Qual o tipo da Passagem?");
                    System.out.println("  (1) - Econômico ");
                    System.out.println("  (2) - Padrão ");
                    System.out.println("  (3) - Premium ");
                    t3.setTipoPassagem(teclado.nextInt());
                    
                    caminhoCompleto.addTrecho(t3);
                    break;
                case 4:
                    TrechoCarro t4 = new TrechoCarro();
                    
                    t4.setOrigem(origem);
                    t4.setDestino(destino);
                    t4.setDistancia(distancia);
                    t4.setDuracao(duracaoHoras, duracaoMinutos);
                    System.out.println( " - Qual a Autonomia do carro? (km/l)");
                    t4.setAutonomiaCarro(teclado.nextDouble());
                    
                    caminhoCompleto.addTrecho(t4);
                    break;
                case 5:
                    TrechoOnibus t5 = new TrechoOnibus();
                    
                    t5.setOrigem(origem);
                    t5.setDestino(destino);
                    t5.setDistancia(distancia);
                    t5.setDuracao(duracaoHoras, duracaoMinutos);
                    System.out.println( " - Qual o tipo da Passagem?");
                    System.out.println("  (1) - Padrão ");
                    System.out.println("  (2) - Leito ");
                    t5.setTipoPassagem(teclado.nextInt());
                    
                    caminhoCompleto.addTrecho(t5);
                    break;
                case 6:
                    TrechoTrem t6 = new TrechoTrem();
                    
                    t6.setOrigem(origem);
                    t6.setDestino(destino);
                    t6.setDistancia(distancia);
                    t6.setDuracao(duracaoHoras, duracaoMinutos);
                    System.out.println( " - Qual o tipo do Trem?");
                    System.out.println("  (1) - Normal ");
                    System.out.println("  (2) - Trem-Bala ");
                    t6.setTipoTrem(teclado.nextInt());
                    
                    caminhoCompleto.addTrecho(t6);
                    break;
                default:
                    break;
            }
            
            System.out.println("Deseja adicionar mais um Trecho?");
            System.out.println(" (0) - NÃO // (1) - SIM");
            if( teclado.nextInt() == 0){
                break;
            }   
        }
        
        System.out.println( " --- RESUMO DOS TRECHOS --- ");
        caminhoCompleto.gerarIlustracaoTrechos();
        
        System.out.println( "");
        System.out.println( "");
        
        System.out.println( " --- RESUMO GERAL --- ");
        caminhoCompleto.gerarIlustracao();
    }
}

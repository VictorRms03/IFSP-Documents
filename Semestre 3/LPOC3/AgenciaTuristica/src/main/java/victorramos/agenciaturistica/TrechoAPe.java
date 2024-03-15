package victorramos.agenciaturistica;

public class TrechoAPe extends Trecho{
    
    /* Variaveis da Classe */
    protected double numeroPassos;
    
    /* Gets e Sets da Classe*/    
    @Override
    public double getCusto(){
        return 0;
    }
    
    public double getNumeroPassos(){
        return (distancia * 1250); //Dado em Passos/Km
    }
    
    /* Interfaces */
    @Override
    public void gerarIlustracao() {
        System.out.println(" - Tipo do Trecho: A Pé");
        System.out.println(" - Origem: " + this.getOrigem());
        System.out.println(" - Destino: " + this.getDestino());
        System.out.printf(" - Distância: %.2f km\n", this.getDistancia());
        System.out.printf(" - Duração: %d horas %d minutos\n", this.getDuracaoHoras(), this.getDuracaoMinutos());
        System.out.println(" - Numero de Passos: " + this.getNumeroPassos());
    }
}

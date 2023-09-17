package victorramos.agenciaturistica;

public class TrechoCarro extends Trecho{
    
    /* Variaveis da Classe */
    double autonomiaCarro = 0;
    
    /* Gets e Sets da Classe*/
    public void setAutonomiaCarro(double autonomiaCarro){
        this.autonomiaCarro = autonomiaCarro;
    }

    @Override
    public double getCusto(){
        return distancia/autonomiaCarro * 5.6;
    }
    
    public double getGasolinaGasta(){
        return distancia/autonomiaCarro;
    }
    
    public double getAutonomiaCarro(){
        return autonomiaCarro;
    }
    
    /* Interfaces */
    @Override
    public void gerarIlustracao() {
        System.out.println(" - Tipo do Trecho: Carro");
        System.out.println(" - Origem: " + this.getOrigem());
        System.out.println(" - Destino: " + this.getDestino());
        System.out.printf(" - Distância: %.2f km\n", this.getDistancia());
        System.out.printf(" - Duração: %d horas %d minutos\n", this.getDuracaoHoras(), this.getDuracaoMinutos());
        System.out.printf(" - Autonomia do Carro: %.2f km/l\n", this.getAutonomiaCarro());
        System.out.printf(" - Gasolina Gasta: %.2f l\n", this.getGasolinaGasta());
        System.out.printf(" - Custo do Trecho: R$ %.2f\n", this.getCusto());
    }
}

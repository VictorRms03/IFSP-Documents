package victorramos.agenciaturistica;

public class TrechoOnibus extends Trecho{
    
    /* Variaveis da Classe */
    protected String tipoPassagem;
    
    /* Gets e Sets da Classe*/
    public void setTipoPassagem(int codTipoPassagem){
        switch (codTipoPassagem){
            case 1:
                tipoPassagem = "Padrão";
                break;
            case 2:
                tipoPassagem = "Leito";
                break;
        }
    }
    
    public String getTipoPassagem(){
        return tipoPassagem;
    }
    
    @Override
    public double getCusto(){
        if(distancia<50){
            switch(tipoPassagem){
                case "Padrão":
                    return distancia*0.5;
                case "Leito":
                    return distancia*0.75;
            }
        } else if (distancia<100){
            switch(tipoPassagem){
                case "Padrão":
                    return distancia*0.75;
                case "Leito":
                    return distancia*1;
            }
        } else {
            switch(tipoPassagem){
                case "Padrão":
                    return distancia*1.5;
                case "Leito":
                    return distancia*2;
            }
        }
        return distancia*1.75;
    }
    
    /* Interfaces */
    @Override
    public void gerarIlustracao() {
        System.out.println(" - Tipo do Trecho: Ônibus");
        System.out.println(" - Origem: " + this.getOrigem());
        System.out.println(" - Destino: " + this.getDestino());
        System.out.printf(" - Distância: %.2f km\n", this.getDistancia());
        System.out.printf(" - Duração: %d horas %d minutos\n", this.getDuracaoHoras(), this.getDuracaoMinutos());
        System.out.println(" - Tipo de Ônibus: " + this.getTipoPassagem());
        System.out.printf(" - Custo do Trecho: R$ %.2f\n", this.getCusto());
    }
}

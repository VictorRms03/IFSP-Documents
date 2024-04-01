package victorramos.agenciaturistica;

public class TrechoBarco extends Trecho{
    
    /* Variaveis da Classe */
    protected String tipoPassagem = "Padrão";
    
    /* Gets e Sets da Classe */
    public void setTipoPassagem(int codTipoPassagem){
        switch (codTipoPassagem) {
            case 1:
                tipoPassagem = "Econômico";
                break;
            case 2:
                tipoPassagem = "Padrão";
                break;
            case 3:
                tipoPassagem = "Premium";
                break;
            default:
                tipoPassagem = "Não Identificado";
                break;
        }
    }
    
    @Override
    public double getCusto(){
        switch (tipoPassagem) {
            case "Economico":
                return distancia*3 + duracao *150;
            case "Padrão":
                return distancia*4 + duracao*300;
            case "Premium":
                return distancia*6 + duracao*600;
            default:
                return 3000;
        }
    }
    
    public String getTipoPassagem(){
        return tipoPassagem;
    }
    
    /* Interfaces */
    @Override
    public void gerarIlustracao() {
        System.out.println(" - Tipo do Trecho: Barco");
        System.out.println(" - Origem: " + this.getOrigem());
        System.out.println(" - Destino: " + this.getDestino());
        System.out.printf(" - Distância: %.2f km\n", this.getDistancia());
        System.out.printf(" - Duração: %d horas %d minutos\n", this.getDuracaoHoras(), this.getDuracaoMinutos());
        System.out.println(" - Tipo de Passagem: " + this.getTipoPassagem());
        System.out.printf(" - Custo do Trecho: R$ %.2f\n", this.getCusto());
    }
}

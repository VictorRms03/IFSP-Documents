package victorramos.agenciaturistica;

public class TrechoTrem extends Trecho{
    
    /* Variaveis da Classe */
    protected String tipoTrem;
    
    /* Gets e Sets da Classe*/
    public void setTipoTrem(int codTipoTrem){
        switch (codTipoTrem){
            case 1:
                tipoTrem = "Normal";
                break;
            case 2:
                tipoTrem = "Trem-Bala";
                break;
        } 
    }
    
    public String getTipoTrem(){
        return tipoTrem;
    }
    
    @Override
    public double getCusto(){
        if(tipoTrem.equals("Normal")){
            return 0.60 * distancia;
        } else if (tipoTrem.equals("Trem-Bala")){
            return 2 * distancia;
        }
        return distancia;
    }
    
    /* Interfaces */
    @Override
    public void gerarIlustracao() {
        System.out.println(" - Tipo do Trecho: Trem");
        System.out.println(" - Origem: " + this.getOrigem());
        System.out.println(" - Destino: " + this.getDestino());
        System.out.printf(" - Distância: %.2f km\n", this.getDistancia());
        System.out.printf(" - Duração: %d horas %d minutos\n", this.getDuracaoHoras(), this.getDuracaoMinutos());
        System.out.println(" - Tipo do Trem: " + this.getTipoTrem());
        System.out.printf(" - Custo do Trecho: R$ %.2f\n", this.getCusto());
    }
}

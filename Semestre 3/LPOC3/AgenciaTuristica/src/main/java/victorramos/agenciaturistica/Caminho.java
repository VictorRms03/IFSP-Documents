package victorramos.agenciaturistica;

import java.util.ArrayList;

public class Caminho extends Trecho{

    public Caminho() {
        this.listaTrechos = new ArrayList<>();
    }
    
    ArrayList<Trecho> listaTrechos;
    
    /* Métodos da Classe */
    void addTrecho(Trecho t){
        listaTrechos.add(t);
    }
    
    public void gerarIlustracaoTrechos(){
        int i=1;
        for(Trecho t : listaTrechos){
            System.out.println(" \n--- Trecho " + i + " ---");
            System.out.println("");
            t.gerarIlustracao();
            i++;
        }
    }
    
    /* Gets e Sets da Classe*/
    @Override
    public String getOrigem(){
        Trecho t = listaTrechos.get(0);
        return t.getOrigem();
    }
    
    @Override
    public String getDestino(){
        Trecho t = listaTrechos.get((listaTrechos.size() - 1));
        return t.getDestino();
    }
    
    @Override
    public double getDistancia(){
        double distanciaTotal = 0;
        for(Trecho t : listaTrechos){
            distanciaTotal += t.getDistancia();
        }
        return distanciaTotal;
    }
    
    @Override
    public double getDuracao(){
        double duracaoTotal = 0;
        for(Trecho t : listaTrechos){
            duracaoTotal += t.getDuracao();
        }
        return duracaoTotal;
    }
    
    @Override
    public int getDuracaoHoras(){
        return (int) (this.getDuracao()/60);
    }
    
    @Override
    public int getDuracaoMinutos(){
        return (int) (this.getDuracao()%60);
    }
    
    @Override
    public double getCusto(){
        double custoTotal = 0;
        for(Trecho t : listaTrechos){
            custoTotal += t.getCusto();
        }
        return custoTotal;
    }
    
    public int getNumeroTrechos(){
        return listaTrechos.size();
    }
    
    /* Interfaces */
    @Override
    public void gerarIlustracao(){
        System.out.println(" - Origem: " + this.getOrigem());
        System.out.println(" - Destino: " + this.getDestino());
        System.out.printf(" - Distância: %.2f km\n", this.getDistancia());
        System.out.printf(" - Duração: %d horas %d minutos\n", this.getDuracaoHoras(), this.getDuracaoMinutos());
        System.out.println(" - Nº de Trechos Diferentes: " + this.getNumeroTrechos());
        System.out.printf(" - Custo da Viagem: R$ %.2f\n", this.getCusto());
    }
}

package app;

public class Aviao {
    private String tempoViagem;
    private String ilustracaoCaminho;
    private double precoViagem;
    
    public void setTempoViagem(String n){
        tempoViagem = n;
    }
    
    public void setIlustracaoCaminho(String n){
        ilustracaoCaminho = n;
    }
    
    public void setPrecoViagem(double n){
        precoViagem = n;
    }
    
    public String getTempoViagem(){
        return tempoViagem;
    }
    
    public String getIlustracaoCaminho(){
        return ilustracaoCaminho;
    }
    
    public double getPrecoViagem(){
        return precoViagem;
    }
}

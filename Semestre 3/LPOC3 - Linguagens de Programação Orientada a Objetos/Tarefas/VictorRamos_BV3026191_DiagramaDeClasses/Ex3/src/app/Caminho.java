package app;

public class Caminho {
    private String localPartida;
    private String localChegada;
    Trecho trecho1 =  new Trecho();
    Trecho trecho2 =  new Trecho();
    Trecho trecho3 =  new Trecho();
    
    public void setLocalPartida(String n){
        localPartida = n;
    }
    
    public void setLocalChegada(String n){
        localChegada = n;
    }
    
    public String getLocalPartida(){
        return localPartida;
    }
    
    public String getLocalChegada(){
        return localChegada;
    }
}

package app;

public class Trecho {
    private String localInicio;
    private String localFim;
    
    public void setLocalInicio(String n){
        localInicio = n;
    }
    
    public void setLocalFim(String n){
        localFim = n;
    }
    
    public String getLocalInicio(){
        return localInicio;
    }
    
    public String getLocalFim(){
        return localFim;
    }
    
    public void setTipoTransporte(int n){
        if(n == 1){
            aPe aPe = new aPe();
        } else if(n == 2){
            Carro carro = new Carro();
        } else if(n == 3){
            Onibus onibus = new Onibus();
        } else if(n == 4){
            Aviao aviao = new Aviao();
        } else if(n == 5){
            Barco barco =  new Barco();
        } else if(n == 6){
            Trem trem = new Trem();
        }
    }
    
}

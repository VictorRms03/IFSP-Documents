package encapsulamento;

public class Carro {
    private String marca;
    private String modelo;
    private int anoFabricacao;
    
    public void setMarca(String n){
        marca = n;
    }
    
    public void setModelo(String n){
        modelo = n;
    }
    
    public void setAnoFabricacao(int n){
        if (n>=0){
            anoFabricacao = n;
        } else {
            anoFabricacao = 0;
        }
        
    }
    
    public String getMarca(){
        return marca;
    }
    
    public String getModelo(){
        return modelo;
    }
    
    public int getAnoFabricacao(){
        return anoFabricacao;
    }
    
    public int getIdadeCarro(){
        int n = 2023 - anoFabricacao;
        return n;
    }
}

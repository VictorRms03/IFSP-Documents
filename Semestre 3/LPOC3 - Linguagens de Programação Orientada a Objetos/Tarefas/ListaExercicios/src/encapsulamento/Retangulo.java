package encapsulamento;

public class Retangulo {
    private double comprimento;
    private double largura;
    
    public double getComprimento(){
        return comprimento;
    }
    
    public double getLargura(){
        return largura;
    }
    
    public void setComprimento(double n){
        comprimento = n;
    }
    
    public void setLargura(double n){
        largura = n;
    }
    
    public double getAreaRetangulo(){
        return largura*comprimento;
    }
}

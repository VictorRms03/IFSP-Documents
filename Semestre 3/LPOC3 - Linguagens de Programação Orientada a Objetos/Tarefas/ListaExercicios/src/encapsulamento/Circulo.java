package encapsulamento;

public class Circulo {
    private double raio;
    private final double pi = 3.14159;
    
    public void setRaio(double n){
        raio = n;
    }
    
    public double getRaio(){
        return raio;
    }
    
    public double getPerimetro(){
        return 2*pi*raio;
    }
}

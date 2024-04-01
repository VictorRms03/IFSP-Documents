package encapsulamento;

public class Animal {
    private String especie;
    private int idade;
    private double peso;
    
    public String getEspecie(){
        return especie;
    }
    
    public int getIdade(){
        return idade;
    }
    
    public double getPeso(){
        return peso;
    }
    
    public void setEspecie(String n){
        especie = n;
    }
    
    public void setIdade(int n){
        idade = n;
    }
    
    public void setPeso(double n){
        peso = n;
    }
    
    public String getAcimaAbaixoPeso(){
        if(peso > ((idade*12)/10)){
            return "acima";
        } else {
            return "abaixo";
        }
    }
}

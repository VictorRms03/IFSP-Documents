package encapsulamento;

public class Funcionario {
    private String nome;
    private double salario;
    private String cargo;
    
    public void setNome(String n){
        nome = n;
    }
    
    public void setSalario(double n){
        salario = n;
    }
    
    public void setCargo(String n){
        cargo = n;
    }
    
    public String getNome(){
        return nome;
    }
    
    public double getSalario(){
        return salario;
    }
    
    public String getCargo(){
        return cargo;
    }
    
    public void aumentarSalario(int n){
        salario = salario + ((salario/100)*20);
    }
    
}

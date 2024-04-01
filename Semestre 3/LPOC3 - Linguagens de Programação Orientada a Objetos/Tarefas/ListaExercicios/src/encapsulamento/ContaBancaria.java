package encapsulamento;

public class ContaBancaria {
    private String numeroConta;
    private double saldo = 0;
    private String titularConta;
    
    public void setNumeroConta(String n){
        numeroConta = n;
    }
    
    public void setTitularConta(String n){
        titularConta = n;
    }
    
    public String getNumeroConta(){
        return numeroConta;
    }
    
    public String getTitularConta(){
        return titularConta;
    }
    
    public double getSaldo(){
        return saldo;
    }
    
    public void depositar(double n){
        if(n > 0){
            saldo = saldo + n;
        }
    }
    
    public void sacar(double n){
        if(n > 0){
            saldo = saldo - n;
        }
    }
}

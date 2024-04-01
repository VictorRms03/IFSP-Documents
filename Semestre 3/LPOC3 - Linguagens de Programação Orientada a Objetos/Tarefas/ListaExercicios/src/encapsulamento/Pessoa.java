package encapsulamento;

public class Pessoa {
    private String nome;
    private int idade;
    private String telefone;
    
    public String getNome(){
        return nome;
    }
    
    public int getIdade(){
        return idade;
    }
    
    public String getTelefone(){
        return telefone;
    }
    
    public void setNome(String n){
        nome = n;
    }
    
    public void setIdade(int n){
        idade = n;
    }
    
    public void setTelefone(String n){
        telefone = n;
    }
}

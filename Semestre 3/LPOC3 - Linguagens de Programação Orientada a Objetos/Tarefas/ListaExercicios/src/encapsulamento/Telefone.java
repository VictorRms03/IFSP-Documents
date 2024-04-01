package encapsulamento;

public class Telefone {
    private String codigoArea;
    private String numeroLinha;
    private String tipoTelefone;
    
    public void setCodigoArea(String n){
        codigoArea = n;
    }
    
    public void setNumeroLinha(String n){
        numeroLinha = n;
    }
    
    public void setTipoTelefone(String n){
        tipoTelefone = n;
    }
    
    public String getCodigoArea(){
        return codigoArea;
    }
    
    public String getNumeroLinha(){
        return numeroLinha;
    }
    
    public String getTipoTelefone(){
        return tipoTelefone;
    }
    
    public boolean getEhValido(){
        if(numeroLinha.length() == 8 || numeroLinha.length() == 9){
            return true;
        } else {
            return false;
        }
    }
    
}

package app;

public class Carro {
    private String modelo;
    
    Roda roda1 = new Roda();
    Roda roda2 = new Roda();
    Roda roda3 = new Roda();
    Roda roda4 = new Roda();
    
    Portas porta1 = new Portas();
    Portas porta2 = new Portas();
    Portas porta3 = new Portas();
    
    Bancos bancos = new Bancos();
    
    Volante volante = new Volante();
    
    Cambio cambio = new Cambio();
    
    public void setModelo(String n){
        modelo = n;
    }
    
}

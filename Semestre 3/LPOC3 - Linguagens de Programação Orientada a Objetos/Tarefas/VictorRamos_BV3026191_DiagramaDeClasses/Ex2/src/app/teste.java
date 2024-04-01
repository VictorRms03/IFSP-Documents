package app;

public class teste {
    public static void main(){
        Carro carro = new Carro();
        
        carro.roda1.setDiametro("1");
        carro.roda1.setPressao("1");
        
        carro.roda2.setDiametro("2");
        carro.roda2.setPressao("2");
        
        carro.roda3.setDiametro("3");
        carro.roda3.setPressao("3");
        
        carro.roda4.setDiametro("4");
        carro.roda4.setPressao("4");
        
        carro.porta1.setDimensao("5");
        carro.porta1.setPosicao("Frente-Esquerda");
        
        carro.porta2.setDimensao("6");
        carro.porta2.setPosicao("Frente-Direita");
        
        carro.porta3.setDimensao("7");
        carro.porta3.setPosicao("Atrás-Esquerda");
        
        carro.bancos.setDimensao("8");
        carro.bancos.setCorDoAssento("Preto");
        
        carro.cambio.setModelo("Manual");
        
        carro.volante.setTipo("Mecânica");
        
        carro.setModelo("Standard");
        
        
    }
}

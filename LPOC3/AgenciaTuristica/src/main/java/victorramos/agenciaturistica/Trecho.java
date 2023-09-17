package victorramos.agenciaturistica;

abstract class Trecho implements Ilustravel{
    
    /* Variaveis da Classe */
    protected String origem;
    protected String destino;
    protected double distancia = 0; //Dada em Km
    protected int duracaoHoras = 0; //Dado em Horas
    protected int duracaoMinutos = 0; //Dado em Minutos
    protected double duracao = 0; //Dado em Minutos
    protected double custo = 0; //Dado em R$
    
    /* Gets e Sets da Classe*/
    public void setOrigem(String origem){
        this.origem = origem;
    }
    
    public void setDestino(String destino){
        this.destino = destino;
    }
    
    public void setDistancia(double distancia){
        this.distancia = distancia;
    }
    
    public void setDuracao(int horas, int minutos){
        this.duracaoHoras = horas;
        this.duracaoMinutos = minutos;
        this.duracao = this.duracaoHoras*60 + this.duracaoMinutos;
    }

    public String getOrigem(){
        return this.origem;
    }
    
    public String getDestino(){
        return this.destino;
    }
    
    public double getDistancia(){
        return this.distancia;
    }
    
    public double getDuracao(){
        return this.duracao;
    }
    
    public int getDuracaoHoras(){
        return this.duracaoHoras;
    }
    
    public int getDuracaoMinutos(){
        return this.duracaoMinutos;
    }
    
    public double getVelocidadeMedia(){
        return (this.distancia/this.duracao);
    }
    
    public abstract double getCusto();
    
    /* Interfaces */
    @Override
    public void gerarIlustracao(){}
}

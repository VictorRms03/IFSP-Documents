package encapsulamento;

public class Livro {
    private String titulo;
    private String autor;
    private int numeroPaginas;
    
    public void setTitulo(String n){
        titulo = n;
    }
    
    public void setAutor(String n){
        autor = n;
    }
    
    public void setNumeroPaginas(int n){
        numeroPaginas = n;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public String getAutor(){
        return autor;
    }
    
    public int getNumeroPaginas(){
        return numeroPaginas;
    }
    
    public String livroGrandePequeno(){
        if(numeroPaginas <100){
            return "pequeno";
        } else {
            return "grande";
        }
    }
}
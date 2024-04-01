package app;

public class Teste2 {
    public static void main(String [] args){
        Aluno aluno1 = new Aluno();               
        aluno1.nome = "Márcio";
        aluno1.nota1 = 7;
        aluno1.realizarProva();
        
        Aluno aluno2 = new Aluno();
        aluno2.nome = "Blask";
        aluno2.nota1 = 10;
        aluno2.realizarProva();
        
        System.out.println(aluno1.nome + ": " +
                aluno1.suaNotaFinalEh());
        
        System.out.println(aluno2.nome + ": " +
                aluno2.suaNotaFinalEh());
        
    }
}


package app;

import java.util.Random;

public class Teste {
    
    public static double realizarProva(){
        return new Random().nextDouble(10);
    }
    
    public static void main(String [] args){
        
        // notas dos alunos
        double [] notas = new double[100];
        String [] nomes = new String[100];
        
        notas[0] = 7;
        nomes[3] = "Márcio";
        
        

        String nome1 = "Marcio";
        double nota1 = 7;
        
        // aluno 2
        String nome2 = "Blask";
        double nota2 = 10;
        
        // alunos 1 e 2 realizam prov
        double prova1_aluno1 = realizarProva();
        double prova1_aluno2 = realizarProva();
        
        // calcular notas finas dos alunos
        double nota_final1 = nota1 + prova1_aluno1;
        double nota_final2 = nota2 + prova1_aluno2;
        
        System.out.println(nome1 + ": " + nota_final1);
        System.out.println(nome2 + ": " +nota_final2);
        
        
        
    }
}

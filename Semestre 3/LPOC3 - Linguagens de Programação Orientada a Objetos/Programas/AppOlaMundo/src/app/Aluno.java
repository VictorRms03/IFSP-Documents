package app;

import java.util.Random;

public class Aluno {
    // propriedades (caracteristicas ou atributos)
    String nome;
    double nota1;
    double prova1;
    
    //tipo nome-metodo(parametros){
        // corpo do metodo
    //}
    
//    String ministrar(){
//        return "qualquer coisa";
//    }
//    
//    void assistir(Professor p){
//        System.out.println(p.ministrar());
//    }
    
    // métodos (comportamentos ou ações)
    void realizarProva(){
        prova1 = new Random().nextDouble(10);
    }

    double suaNotaFinalEh(){
        return nota1 + prova1;
    }
}

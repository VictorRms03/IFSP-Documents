/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esdc4aula02;

import aesd.ds.implementations.linear.FixedCapacityStack;
import aesd.ds.interfaces.Stack;

/**
 * Resolução do Exercício i2.1
 * 
 * @author Prof. Dr. David Buzatto
 */
public class Exercicioi2p1 {
    
    /**
     * Verifica se uma expressão composta por pares de símbolos arbitrários está
     * balanceada.
     * 
     * @param expression A expressão a ser verificada.
     * @param pairs Um conjunto de caracteres em que cada dois representam um
     * par de caracteres usados na verificação.
     * @return Se a expressão está balanceada.
     * @throws IllegalArgumentException Caso os pares forem fornecidos de forma
     * errada, ou seja, se houver uma quantidade ímpar de elementos, faltando 
     * assim a dupla de fechamento de um par.
     */
    public static boolean isBalanced( String expression, char... pairs ) 
            throws IllegalArgumentException {
        
        /* Exceção caso o tamanho do "pairs" não seja par */
        if(pairs.length%2!=0) {
            throw new IllegalArgumentException("Invalid number os elements on 'pairs'");
        }
        
        Stack<Character> stack = new FixedCapacityStack<>(pairs.length/2);
        
        for(Character c : expression.toCharArray()){
            
            for(int i=0; i<pairs.length; i++){
                
                if(c.equals(pairs[i])){
                    
                    if(i%2==0){ //Caso seja abertura
                        
                        stack.push(c);
                        
                    } else { //Caso seja fechamento
                        
                        if(stack.peek().equals(pairs[i-1])){
                            stack.pop();
                        } else {
                            return false;
                        }
                    }
                    
                    break;
                }
            }
        }
        
        return stack.isEmpty();
        
    }
    
}

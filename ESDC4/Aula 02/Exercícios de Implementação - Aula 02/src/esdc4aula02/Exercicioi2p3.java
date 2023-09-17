/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esdc4aula02;


import aesd.ds.implementations.linear.ResizingArrayStack;
import aesd.ds.interfaces.Stack;

/**
 * Resolução do Exercício i2.3
 * 
 * @author Prof. Dr. David Buzatto
 */
public class Exercicioi2p3 {
    
    /**
     * Avalia uma expressão aritmética fornecida em qualquer forma (pré-fixada,
     * infixa ou pós-fixada), gerando o resultado. As operações de adição,
     * subtração, multiplicação e divisão devem ser suportadas.
     * 
     * @param expression Expressão a ser avaliada.
     * @return O valor obtido após o cômputo da expressão.
     * @throws IllegalArgumentException Caso a expressão fornecida seja inválida,
     * do ponto de vista estrutural, como ter um valor não numérico onde um
     * é esperado, bem como o uso de caracteres ou operações não suportadas.
     */
    public static double evaluate( String expression ) throws IllegalArgumentException {
        
        if(Exercicioi2p2.isOperator(expression.charAt(0))){ //Se a expressão for 'Pré-Fixada', torna-lá Pós-Fixada
            expression = Exercicioi2p2.prefixToPostfix(expression);
        } else if (!Exercicioi2p2.isOperand(expression.charAt(0)) && !Exercicioi2p2.isOperand(expression.charAt(1))){ //Se a expressão for 'Infixa, torna-lá Pós-Fixada
            expression = Exercicioi2p2.infixToPostfix(expression);
        }

        /* Calcular o Resultado para a expressão Pós-Fixada */
        Stack<Double> stack = new ResizingArrayStack();
        
        for(String str : expression.split("\\s+")){
            
            if(Exercicioi2p2.isOperand(str)){
                
                stack.push(Double.valueOf(str));
                
            } else if (Exercicioi2p2.isOperator(str)){
                
                double operand1 = stack.pop();
                double operand2 = stack.pop();
                    
                switch (str.charAt(0)) {
                    case '+':
                        stack.push( (operand2 + operand1) );
                        break;
                    case '-':
                        stack.push( (operand2 - operand1) );
                        break;
                    case '*':
                        stack.push( (operand2 * operand1) );
                        break;
                    case '/':
                        stack.push( (operand2 / operand1) );
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }
        }

        return stack.peek();
    }
}

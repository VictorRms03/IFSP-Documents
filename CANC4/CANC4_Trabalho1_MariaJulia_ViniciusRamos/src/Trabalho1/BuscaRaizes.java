package Trabalho1;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *Autores: 
 * Maria Júlia Fantagussi BV3025403
 * Vinícius Ramos Deramio BV3015823
 */

public class BuscaRaizes {
    
    /**
     * Implementação do método Java bissecao.
     * O método Java implementado utiliza do método da bissecao para calcular a
     * raiz da função estabelecida previamente.
     * O método recebe os parâmetros double x1 e x2 como os pontos inicias da 
     * função e o parâmetro inteiro precisão como expoente da base 10 para o
     * cálculo do erro.
     * O método retorna um array de double contendo duas posições a primeira 
     * sendo o valor encontrado da raiz e o segundo o número de iterações
     * necessárias para realizar o método.
     */
    private static double[] bissecao(double x1, double x2, int precisao){
        
        double cont = 0.0;
        double[] resultado = new double [2]; 
        
        while (true){
            double fx1 = (Math.pow(x1, 3)) - (7 * Math.pow(x1, 2)) + (14 * x1) - 6;
            double fx2 = (Math.pow(x2, 3)) - (7 * Math.pow(x2, 2)) + (14 * x2) - 6;
            
            if (fx1 * fx2 < 0){
                double xn = (x1 + x2) / 2;
                double fxn = (Math.pow(xn, 3)) - (7 * Math.pow(xn, 2)) + (14 * xn) - 6;
                cont++;
                
                if (fxn < 0){
                    if (fx1 < 0){
                        x1 = xn;
                    }
                    else if (fx2 < 0){
                        x2 = xn;
                    }
                }
                else if (fxn > 0){
                    if (fx1 > 0){
                        x1 = xn;
                    }
                    else if (fx2 > 0){
                        x2 = xn;
                    }
                }
                
                if ((Math.abs(x2 - x1 )/Math.abs(x2)) < Math.pow(10, (-precisao))){
                    resultado[0] = xn;
                    resultado[1] = cont;
                    break;
                }
            }
        }
        return resultado;
    }
    
    /**
     * Implementação do método Java newton.
     * O método Java implementado utiliza do método de Newton para calcular a
     * raiz da função estabelecida previamente.
     * O método recebe os parâmetros double x e x2 como o chute inicial da
     * função parâmetro inteiro precisão como expoente da base 10 para o
     * cálculo do erro.
     * O método retorna um array de double contendo duas posições a primeira 
     * sendo o valor encontrado da raiz e o segundo o número de iterações
     * necessárias para realizar o método.
     */
    private static double[] newton(double x, double precisao){
        
        double cont = 0.0;
        double[] resultado = new double [2]; 
        
        while (true){
            double fx = (Math.pow(x, 3)) - (7 * Math.pow(x, 2)) + (14 * x) - 6;
            double flx = (3 * Math.pow(x,2)) - (14 * x) + 14;
            double xn = x - (fx/flx);
            
            
            if (Math.abs(xn - x)/Math.abs(xn) < Math.pow(10, (-precisao))){
                resultado[0] = xn;
                resultado[1] = cont;
                break;
            }
            
            x = xn;
            cont++;
        }
        
        return resultado;
    }
    
    /**
     * Implementação do método Java arredondar.
     * O método Java implementado tenta arredondar mais precisamente algum
     * valor encontrado baseado na quantidade de suas casas decimais
     * adicionando mais duas casas de precisão. O método utiliza do parâmetro 
     * double precisão que é transformado em string contabilizando o tamanho da
     * substring "0.".
     * Este valor é utilizado em um for para consturir uma string de `#` que 
     * será utilizada posteriormente em um DecimalFormat.
     * Por fim retorna essa string.
     */
    private static String arredondar(double precisao){
        
        String precisaoString = Double.toString(precisao);
        
        String s = "";
        
        for (int i=0; i < precisaoString.length(); i++){
            s = s + "#";
        }
        
        return s;
    }
    
    public static void main(String[] args){
        
        //teclado como meio de entrada de valores
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Métodos de busca de raízes utilizando:");
        System.out.println("\nMétodo da Bisseção e Método de Newton");
        
        System.out.println("\nFunção: x³ - 7x² + 14x - 6");
        System.out.println("Derivada da função: 3x² - 14x + 14");
        
        try{
            System.out.printf("\nExpoente de precisão: ");
            int precisao = teclado.nextInt(); //leitura do expoente
        
            System.out.println("\nCálculo da raiz no intervalo [0,1]");
        
            double x1 = 1.0; //primeiro valor do intervalo
            double x2 = 0.0; //segundo valor do intervalo
        
            System.out.println("\nUtilizando o Método da Bisseção:");
    
            //declaração do array que recebe os resultados da bissecao 
            double[] resultadosBissecao = new double [2];
            //chamada do metodo Java bissecao 
            resultadosBissecao = bissecao(x1, x2, precisao); 
        
            //transformação do valor do contador em inteiro 
            int contadorBissecao = (int) Math.round(resultadosBissecao[1]); 
        
            System.out.printf("Raiz %f encontrada depois de %d interações.",resultadosBissecao[0],contadorBissecao);
        
            //utilização do DecimalFormat obtendo maior precisão
            String casasDecimaisBissecao = arredondar(resultadosBissecao[0]);
            DecimalFormat arredondamentoBissecao = new DecimalFormat("0." + casasDecimaisBissecao);
        
            System.out.println("\nArredondamento mais preciso: " + arredondamentoBissecao.format(resultadosBissecao[0]) + ".");

            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            System.out.println("\n\nUtilizando o Método de Newton:");
        
            //declaração do array que recebe os resultados de newton
            double[] resultadosNewton = new double [2];
            //chamada do metodo Java newton
            resultadosNewton = newton(x1, precisao);

            //transformação do valor do contador em inteiro
            int contadorNewton = (int) Math.round(resultadosNewton[1]);

            System.out.printf("Raiz %f encontrada depois de %d interações.",resultadosNewton[0],contadorNewton);

            //utilização do DecimalFormat obtendo maior precisão
            String casasDecimaisNewton = arredondar(resultadosNewton[0]);
            DecimalFormat arredondamentoNewton = new DecimalFormat("0." + casasDecimaisNewton);
        
            System.out.println("\nArredondamento mais preciso: " + arredondamentoNewton.format(resultadosNewton[0]) + "."); 
        }
        catch(InputMismatchException ime){
            System.out.println("Formato numérico inválido! Tente números inteiros no expoente de precisão!");
        }
        
        
    }
}

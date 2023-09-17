#include <stdio.h>
#include <stdlib.h>

//Protótipos de funções
int ehPrimo(int n);

//Variaveis globais
int ope=0;

int main(){

    printf( "Aula 02 - Exercicio 02 - Primalidade:\n");

    //Declarando variaveis
    int random;

    //Obtendo numero aleatorio
    srand(time (NULL));
    random = rand() % 100;
    printf( "\nNumero inteiro gerado aleatoriamente (1-100): %d", random);

    //Descobrindo se eh primo
    if (ehPrimo(random) == 0){
        printf( "\nO numero %d NAO eh Primo (Num. Operacoes = %d)", random, ope);
    } else if (ehPrimo(random) == 1){
        printf( "\nO numero %d eh Primo (Num. Operacoes = %d)", random, ope);
    }

    return 0;
}

int ehPrimo(int n){

    // 0 = não primo
    // 1 = primo

    if ( (n == 1) || (n == 0) || (n == -1)){
        ope++;
        return 0;
    } else {
        for (int i=2; i<n/2; i++){
            ope++;
            if ((n % i) == 0){
                ope++;
                return 0;
            }
        }
    }

    return 1;

}

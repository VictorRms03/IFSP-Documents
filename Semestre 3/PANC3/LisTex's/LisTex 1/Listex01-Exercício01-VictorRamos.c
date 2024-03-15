#include <stdio.h>
#include <stdlib.h>

//Protótipos de funções
int maiorElemArray(const int *array, int n);

//Variaveis globais
int ope = 0;

int main(){

    printf( "Aula 02 - Exercicio 01 - Maior Elemento no Array:\n");

    int tamanhoArray;
    int *array;
    int maiorElemento;

    printf( "\nEntre com o tamanho do Array de Inteiros: ");
    scanf( "%d", &tamanhoArray);

    array = (int*) malloc(tamanhoArray * sizeof(int));

    for (int i=0; i<tamanhoArray; i++){
        printf( "Digite o valor para a posicao %d do Array: ", i+1);
        scanf( "%d", &array[i]);
    }

    maiorElemento = maiorElemArray(array, tamanhoArray);

    printf( "\nO maior elemento do Array eh: %d (Num. Operacoes = %d)", maiorElemento, ope);
    return 0;
}

int maiorElemArray(const int *array, int n){

    int maior = array[0];

    for(int i=1; i<n; i++){
        ope++;
        if(array[i]>maior){
            ope++;
            maior = array[i];
        }
    }

    return maior;
}

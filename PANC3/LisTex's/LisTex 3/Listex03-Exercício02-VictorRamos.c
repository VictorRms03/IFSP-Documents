#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/* Prototipação de funções*/
void mergeSortRecursivo(int *array, int ini, int fim);
void intercalaComSentinela(int *array, int ini, int meio, int fim);
void geraArrayAleatorio(int *array);
void printaArray(int *array);

/* Variáveis Globais*/
int tamArray;

int main(){
    printf( "Aula 04 - Exercicio 02 - MergeSort Recursivo com Sentinela:\n");

    int *array;

    printf( "Entre com o tamanho do Array de inteiros: ");
    scanf( " %d", &tamArray);
    array = (int*) malloc(tamArray * sizeof(int));

    geraArrayAleatorio(array);

    printf( "Ordenacao");
    printf( "\n Array Desord.[] = ");
    printaArray(array);

    mergeSortRecursivo(array, 0, tamArray-1);

    printf( "\n Array Ord.   [] = ");
    printaArray(array);

    return 0;
}

/*
    Função printaArray(): printa um array na tela.
*/
void printaArray(int *array){

    for(int i=0; i<tamArray; i++){
        printf( " %d", array[i]);
    }

}

/*
    Função geraArrayAleatório(): gera um array de tamanho n com números aleatório de 0 a 99.
*/
void geraArrayAleatorio(int *array){

    int n;
    srand(time(NULL));

    for(int i=0; i<tamArray; i++){
        n = rand() % 100;
        array[i] = n;
    }

}

/*
    Função mergeSortRecursivo(): função que ordena um array de inteiros utilizando o método Mergesort recursivo.
*/
void mergeSortRecursivo(int *array, int ini, int fim){

    if(ini<fim){
        int meio = ((ini+fim)/2);
        mergeSortRecursivo(array, ini, meio);
        mergeSortRecursivo(array, meio+1, fim);
        intercalaComSentinela(array, ini, meio, fim);
        printf( "\n Array Ord.   [] = ");
        printaArray(array);
    }
}

/*
    Função intercalaComSentinela(): função auxiliar da função mergeSortRecursivo(), que ordena um array pelo método Mergesort com sentinela.
*/
void intercalaComSentinela(int *array, int ini, int meio, int fim){

    int n1 = meio-ini+1;
    int n2 = fim-meio;
    int *L;
    int *R;
    L = (int*) malloc ((n1+1) * sizeof(int));
    R = (int*) malloc ((n2+1) * sizeof(int));

    for(int i=0; i<n1; i++){
        L[i] = array[ini+i];
    }

    for(int j=0; j<n2; j++){
        R[j] = array[meio+1+j];
    }

    L[n1] = 10000000;
    R[n2] = 10000000;

    int i=0;
    int j=0;

    for(int k=ini; k<=fim; k++){
        if(L[i] <= R[j]){
            array[k] = L[i];
            i++;
        } else {
            array[k] = R[j];
            j++;
        }
    }
    free(L);
    free(R);
}

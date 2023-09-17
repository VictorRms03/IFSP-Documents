#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/* Prototipa��o de fun��es*/
void printaArray(int *array);
void geraArrayAleatorio(int *array);
void mergeSortRecursivo(int *array, int ini, int fim);
void intercalaSemSentinela(int *array, int ini, int meio, int fim);

/* Vari�veis Globais*/
int tamArray;

int main(){
    printf( "Aula 04 - Exercicio 03 - MergeSort Recursivo sem Sentinela:\n");

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
    Fun��o printaArray(): printa um array na tela.
*/
void printaArray(int *array){

    for(int i=0; i<tamArray; i++){
        printf( " %d", array[i]);
    }

}

/*
    Fun��o geraArrayAleat�rio(): gera um array de tamanho n com n�meros aleat�rio de 0 a 99.
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
    Fun��o mergeSortRecursivo(): fun��o que ordena um array de inteiros utilizando o m�todo Mergesort recursivo.
*/
void mergeSortRecursivo(int *array, int ini, int fim){

    if(ini<fim){
        int meio = ((ini+fim)/2);
        mergeSortRecursivo(array, ini, meio);
        mergeSortRecursivo(array, meio+1, fim);
        intercalaSemSentinela(array, ini, meio, fim);
        printf( "\n Array Ord.   [] = ");
        printaArray(array);
    }
}

/*
    Fun��o intercalaSemSentinela(): fun��o auxiliar da fun��o mergeSort(), que ordena um array pelo m�todo Mergesort sem sentinela.
*/
void intercalaSemSentinela(int *array, int ini, int meio, int fim){

    int *B;
    B = (int*) malloc ((fim+1) * sizeof(int));

    for(int i=ini; i<=meio; i++){
        B[i] = array[i];
    }

    for(int j=meio+1; j<=fim; j++){
        B[fim+meio+1-j] = array[j];
    }

    int i = ini;
    int j = fim;

    for(int k=ini; k<=fim; k++){
        if(B[i] <= B[j]){
            array[k] = B[i];
            i++;


        } else {
            array[k] = B[j];
            j--;
        }
    }
    free(B);
}

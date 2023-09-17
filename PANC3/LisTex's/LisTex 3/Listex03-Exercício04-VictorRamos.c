#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/* Prototipa��o de fun��es*/
void printaArray(int *array);
void geraArrayAleatorio(int *array);
void mergeSortIterativo(int *array);
void intercalaSemSentinela(int *array, int ini, int meio, int fim);
int min(int x, int y);

/* Vari�veis Globais*/
int tamArray;

int main(){
    printf( "Aula 04 - Exercicio 04 - MergeSort Iterativo sem Sentinela:\n");

    int *array;

    printf( "Entre com o tamanho do Array de inteiros: ");
    scanf( " %d", &tamArray);
    array = (int*) malloc(tamArray * sizeof(int));

    geraArrayAleatorio(array);

    printf( "Ordenacao");
    printf( "\n Array Desord.[] = ");
    printaArray(array);

    mergeSortIterativo(array);

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
    Fun��o mergeSortIterativo(): fun��o que ordena um array de inteiros utilizando o m�todo MergeSort Iterativo.
*/
void mergeSortIterativo(int *array){

    for(int tamAtual=1; tamAtual<tamArray; tamAtual = tamAtual*2){
        for(int ini = 0; ini<tamArray-1; ini += 2*tamAtual){
            int meio = min(ini + tamAtual - 1, tamArray-1);
            int fim = min(ini + 2*tamAtual-1, tamArray-1);
            intercalaSemSentinela(array, ini, meio, fim);
            printf( "\n Array Ord.   [] = ");
            printaArray(array);
        }
    }
}

/*
    Fun��o intercalaSemSentinela(): fun��o auxiliar da fun��o mergeSortIterativo(), utilizando do m�todo MergeSort iterativo.
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

/*
    Fun��o min(): fun��o para descobrir qual o menor entre dois n�meros.
*/
int min(int x, int y){
    if(x<y){
        return x;
    } else {
        return y;
    }
}

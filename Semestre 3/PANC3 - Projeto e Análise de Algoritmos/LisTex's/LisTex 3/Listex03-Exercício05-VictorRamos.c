#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/* Prototipa��o das fun��es */
void geraArrayAleatorio(int *array, int tamArray);
void printaArray(int *array, int tamArray);
void mergeSortRecursivo(int *array, int ini, int fim);
void intercalaSemSentinela(int *array, int ini, int meio, int fim);
int buscaBinariaRecursiva(int *array, int ini, int fim, int procurado);

int main(){
    printf( "Aula 04 - Exercicio 05 - Busca Binaria:");

    int *array;
    int tamArray;
    int procurado;
    int posicaoEncontrada;

    printf( "\n\nEntre com o tamanho do Array de Inteiros: ");
    scanf( " %d", &tamArray);
    array = (int*) malloc (tamArray * sizeof(int));

    geraArrayAleatorio(array, tamArray);
    mergeSortRecursivo(array, 0, tamArray-1);

    printf( "\nArray Gerado Ordenado = ");
    printaArray(array, tamArray);

    printf( "\nEntre com o valor inteiro a ser procurado: ");
    scanf( " %d", &procurado);

    posicaoEncontrada = buscaBinariaRecursiva(array, 0, tamArray-1, procurado);

    if(posicaoEncontrada == NULL){
        printf( "\nO valor %d nao foi encontrado no Array!", procurado);
    } else {
        printf( "\nO valor %d foi encontrado na posicao %d do Array!", procurado, posicaoEncontrada-1);
    }

    return 0;
}

/*
    fun��o geraArrayAleatorio(): gera um array com n�meros aleat�rios de 0 a 99.
*/
void geraArrayAleatorio(int *array, int tamArray){

    srand(time(NULL));

    for(int i=0; i<tamArray; i++){
        int n = rand() % 100;
        array[i] = n;
    }
}

/*
    fun��o printaArray(): printa um array na tela.
*/
void printaArray(int *array, int tamArray){
    for(int i=0; i<tamArray; i++){
        printf( " %d", array[i]);
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
    }
}

/*
    Fun��o intercalaSemSentinela(): fun��o auxiliar da fun��o mergeSortRecursivo(), que ordena um array pelo m�todo Mergesort sem sentinela.
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
    fun��o buscaBinariaRecursiva(): fun��o que busca um n�mero no array e retorna a posi��o em que foi encontrado utilizando o paradigma da divis�o e conquista.
*/
int buscaBinariaRecursiva(int *array, int ini, int fim, int procurado){

    if(ini<=fim){
        int meio = (ini+fim)/2;

        if(procurado == array[meio]){
            return meio+1;
        } else if (procurado > array[meio]){
            buscaBinariaRecursiva(array, meio+1, fim, procurado);
        } else if (procurado < array[meio]){
            buscaBinariaRecursiva(array, ini, meio-1, procurado);
        }
    } else {
        return NULL;
    }
}

#include <stdio.h>
#include <stdlib.h>

void gerarArray(int *array, int tamArray);
void printaArray(int *array, int tamArray);
int procurar(int *array, int tamArray, int procurado);

int main(){

    printf( "Aula 03 - Exercicio 03 - Busca Linear:\n");

    int *array;
    int tamArray;
    int procurado;
    int posicaoEncontrada;

    printf( "\nEntre com o tamanho do Array de Inteiros: ");
    scanf( " %d", &tamArray);

    array = (int*) malloc(tamArray * sizeof(int));

    gerarArray(array, tamArray);

    printf( "Array Gerado = ");
    printaArray(array, tamArray);

    printf( "\nEntre com o valor inteiro a ser procurado: ");
    scanf( " %d", &procurado);

    posicaoEncontrada = procurar(array, tamArray, procurado);

    if(posicaoEncontrada == NULL){
        printf( "\nValor nao encontrado no Array!");
    } else {
        printf( "\nO Valor %d foi encontrado na posicao %d", procurado, posicaoEncontrada);
    }

    return 0;

}

void gerarArray(int *array, int tamArray){

    int n;
    srand(time(NULL));

    for(int i=0; i<tamArray; i++){
        n = rand() % 100;
        array[i] = n;
    }
}

void printaArray(int *array, int tamArray){

    for(int i=0; i<tamArray; i++){
        printf( " %d", array[i]);
    }
}

int procurar(int *array, int tamArray, int procurado){

    for(int i=0; i<tamArray; i++){
        if(array[i] == procurado){
            return i+1;
        }
    }

    return NULL;
}


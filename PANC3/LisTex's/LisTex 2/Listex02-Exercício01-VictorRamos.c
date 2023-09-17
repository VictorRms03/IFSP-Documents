#include <stdio.h>
#include <stdlib.h>

void gerarArray (int *array, int tamArray);
void imprimirArray (int *array, int tamArray, char *c);
void ordenaArray (int *array, int tamArray);

int ope = 0;

int main(){

    printf( "Aula 03 - Exercicio 01 - Ordenacao Decrescente: \n");

    int *array;
    int tamArray;

    printf( "\nEntre com o tamanho do Array de inteiros: ");
    scanf( " %d", &tamArray);
    array = (int*) malloc(tamArray * sizeof(int));

    gerarArray(array, tamArray);

    printf( "\nOrdenacao");
    imprimirArray(array, tamArray, "\n Array Desord.[]");

    ordenaArray(array, tamArray);

    imprimirArray(array, tamArray, "\n Array Ord.   []");

    printf( "\n Numero de Operacoes para Ordenacao: %d", ope);

    return 0;
}

void gerarArray (int *array, int tamArray){

    int n;
    srand(time (NULL));

    for(int i=0; i<tamArray; i++){
        n = rand() % 100;
        array[i] = n;
    }
}

void imprimirArray (int *array, int tamArray, char *c){

    printf( "%s = ", c);

    for(int i=0; i<tamArray; i++){
        printf( " %d", array[i]);
    }


}

void ordenaArray (int *array, int tamArray){

    for(int i=1; i<tamArray; i++){
        ope++;

        int n;
        int j = i;

        while(array[j-1] < array[j]){
            ope++;

            n = array[j-1];
            array[j-1] = array[j];
            array[j] = n;
            j--;
        }
        printf( " - %d\n", array[j]);
        imprimirArray(array, tamArray, " Array Ord. Decrescente[]");

    }
}

#include <stdio.h>
#include <stdlib.h>

void lerArray(int *array, int tamArray);
int buscaBinaria(int *array, int tamArray, int procurado);

int main(){

    int *array;
    int tamArray;
    int procurado;


    printf( "Entre com o tamanho do array: ");
    scanf( " %d", &tamArray);

    array = (int*) malloc (tamArray * sizeof(int));

    printf( "Entre com o Array Ordenado:\n");
    lerArray(array, tamArray);

    printf( "Entre com o Valor a ser Procurado: ");
    scanf( " %d", &procurado);


    return 0;
}

void lerArray(int *array, int tamArray){

    for(int i=0; i<tamArray; i++){
        printf( " Array[%d] = ", i);
        scanf( " %d", &array[i]);
    }
}

int buscaBinaria(int *array, int tamArray, int procurado){

    if()
}

#include <stdio.h>
#include <stdlib.h>

void insertionSort(int tamArray, int *array);
void printaArray(int tamArray, int *array);

int main(){

    int *array;
    int tamArray;

    printf( "Entre com o tamanho do Array: ");
    scanf( " %d", &tamArray);

    array = (int*) malloc(sizeof(int) * tamArray);

    for(int i=0; i<tamArray; i++){
        printf( "A[%d] = ", i);
        scanf( " %d", &array[i]);
    }

    printf( "---------- Metodo de Ordenacao por Insercao ----------\n");
    insertionSort(tamArray, array);
    printf( "Vetor Ord.   [] = ");
    printaArray(tamArray, array);


    return 0;
}

void insertionSort(int tamArray, int *array){
    for(int i=1; i<tamArray; i++){
        int key = array[i];
        int j = i-1;

        while(j>=0 && array[j]>key){
            array[j+1] = array[j];
            j--;
        }
        array[j+1] = key;
        printf( "Vetor Desord.[] = ");
        printaArray(tamArray, array);
        printf( "- %d\n", key);
    }
}

void printaArray(int tamArray, int *array){
    for(int i=0; i<tamArray; i++){
        printf( "%d ", array[i]);
    }
}

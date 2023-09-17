#include <stdio.h>
#include <stdlib.h>
#include <math.h>

void shellSort(int tamArray, int *array, int Np);
void printaArray(int tamArray, int *array);
void ordenaShellSort(int *array, int Inc, int SegCorrente, int tamArray);

int main(){

    int *array;
    int tamArray;
    int Np;

    printf( "Entre com o Np do Shell Sort: ");
    scanf( " %d", &Np);

    printf( "Entre com o tamanho do Array: ");
    scanf( " %d", &tamArray);

    array = (int*) malloc(sizeof(int) * tamArray);

    for(int i=0; i<tamArray; i++){
        printf( "A[%d] = ", i);
        scanf( " %d", &array[i]);
    }

    printf( "---------- Metodo de Ordenacao por Shell Sort ----------\n");
    shellSort(tamArray, array, Np);
    printf( "Vetor Ord.   [] = ");
    printaArray(tamArray, array);

    return 0;
}

void shellSort(int tamArray, int *array, int Np){
    for (int interval = tamArray / Np; interval > 0; interval /= Np) {

        for (int i = interval; i < tamArray; i += 1) {
            int temp = array[i];
            int j;
            for (j = i; j >= interval && array[j - interval] > temp; j -= interval) {
                array[j] = array[j - interval];
            }
            array[j] = temp;

            printf( "Vetor Desord.[] = ");
            printaArray(tamArray, array);
            printf( "- %d\n", temp);
        }
    }
}

void printaArray(int tamArray, int *array){
    for(int i=0; i<tamArray; i++){
        printf( "%d ", array[i]);
    }
}

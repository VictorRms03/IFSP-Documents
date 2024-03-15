#include <stdio.h>
#include <stdlib.h>

void ordenacaoBinaria(int tamArray, int *array);
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

    printf( "---------- Metodo de Ordenacao por Ordenacao Binaria ----------\n");
    ordenacaoBinaria(tamArray, array);
    printf( "Vetor Ord.   [] = ");
    printaArray(tamArray, array);


    return 0;
}

void ordenacaoBinaria(int tamArray, int *array){
    for(int i=1; i<tamArray; i++){
        int chave = array[i];
        int L = 0;
        int R = i;

        while(L<R){
            int meio = (L+R)/2;
            if(chave>=array[meio]){
                L=meio+1;
            } else {
                R=meio;
            }
        }

        for(int j=i; j>L; j--){
            array[j] = array[j-1];
        }

        array[R] = chave;

        printf( "Vetor Desord.[] = ");
        printaArray(tamArray, array);
        printf( "- %d\n", chave);
    }
}

void printaArray(int tamArray, int *array){
    for(int i=0; i<tamArray; i++){
        printf( "%d ", array[i]);
    }
}

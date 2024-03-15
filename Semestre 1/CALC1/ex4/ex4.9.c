#include <stdlib.h>
#include <stdio.h>

int main(){

    int array[5], arrayInvertido[5];
    int tam, tamInvertido;

    tam = (sizeof(array)/sizeof(array[0]));
    tamInvertido = (sizeof(arrayInvertido)/sizeof(arrayInvertido[0]));

    for (int i=0;i<tam;i++){
        printf("array[%d]: ",i);
        scanf("%d", &array[i]);
    }

    printf("\n");

    for (int i=0;i<tamInvertido;i++){
        arrayInvertido[i] = array[tam-1];
        tam--;
    }

    for (int i=0;i<tamInvertido;i++){
        printf("arrayInv[%d] = %d\n",i,arrayInvertido[i]);
    }

    return 0;
}

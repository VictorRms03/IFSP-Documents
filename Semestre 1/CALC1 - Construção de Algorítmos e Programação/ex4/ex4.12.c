#include <stdio.h>
#include <stdlib.h>

int main(){

    int array[5];
    int tam;

    tam = (sizeof(array)/sizeof(array[0]));

    for (int i=0;i<tam;i++){
        printf("array[%d]: ",i);
        scanf("%d", &array[i]);
    }

    printf("\n");

    for (int i=0;i<tam-1;i++){
        array[i] = array[i+1];
        printf("array[%d] = %d\n",i,array[i]);
    }

    return 0;
}

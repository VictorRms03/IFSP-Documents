#include <stdlib.h>
#include <stdio.h>

int main(){

    int array[10];
    int tam;
    int contador = 0;

    tam = (sizeof(array)/sizeof(array[0]));

    for (int i=0;i<tam;i++){
        printf("array[%d]: ",i);
        scanf("%d", &array[i]);
    }

    for (int i=0;i<tam;i++){
        if (array[i]%2!=0){
            array[contador] = array[i];
            contador++;
        }
    }

    for (int i=0;i<contador;i++){
        printf("array[%d] = %d\n",i,array[i]);
    }

    return 0;
}

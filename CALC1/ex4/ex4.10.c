#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>

int main(){

    int array[5], arrayCopia[5];
    int tam, tamCopia;
    int contador = 0;
    int valorCopia;
    bool validarCopia = false;

    tam = (sizeof(array)/sizeof(array[0]));
    tamCopia = (sizeof(arrayCopia)/sizeof(arrayCopia[0]));

    for (int i=0;i<tam;i++){
        printf("array[%d]: ",i);
        scanf("%d", &array[i]);
    }

    printf("\nCopiar maiores que :");
    scanf("%d", &valorCopia);

    for (int i=0;i<tam;i++){
        if (array[i]>valorCopia){
            validarCopia = true;
            arrayCopia[contador] = array[i];
            contador++;
        }
    }

    if (!validarCopia){
        printf("Nao houve copia!");
    }
    else{
        for (int i=0;i<contador;i++){
            printf("arrayCopia[%d] = %d\n",i,arrayCopia[i]);
        }
    }

    return 0;
}

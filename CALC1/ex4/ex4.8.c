#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>

int main(){

    int array[5], arrayPar[5], arrayImpar[5];
    int tam, tamPar, tamImpar;
    int contadorPar = 0, contadorImpar = 0;
    bool existePar = false;
    bool existeImpar = false;

    tam = (sizeof(array)/sizeof(array[0]));
    tamPar = (sizeof(arrayPar)/sizeof(arrayPar[0]));
    tamImpar = (sizeof(arrayImpar)/sizeof(arrayImpar[0]));

    for (int i=0;i<tamPar;i++){
        arrayPar[i] = 0;
    }

    for (int i=0;i<tamImpar;i++){
        arrayImpar[i] = 0;
    }

    for (int i=0;i<tam;i++){
        printf("array[%d]: ",i);
        scanf("%d", &array[i]);

        if (array[i]%2==0){
            arrayPar[contadorPar] = array[i];
            contadorPar++;
            existePar = true;
        }
        else{
            arrayImpar[contadorImpar] = array[i];
            contadorImpar++;
            existeImpar = true;
        }
    }

    printf("Numeros pares: ");

    for (int i=0;i<contadorPar;i++){
        if (i==(contadorPar-1)){
            printf("%d.",arrayPar[i]);
        }
        else{
            printf("%d ",arrayPar[i]);
        }
    }

    if (!existePar){
        printf("nao ha.");
    }

    printf("\nNumeros impares: ");

    for (int i=0;i<contadorImpar;i++){
        if (i==(contadorImpar-1)){
            printf("%d.",arrayImpar[i]);
        }
        else{
            printf("%d ",arrayImpar[i]);
        }
    }


    if (!existeImpar){
        printf("nao ha.");
    }


    return 0;
}

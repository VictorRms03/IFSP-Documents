#include <stdio.h>
#include <stdlib.h>

int main(){

    int array[5], arrayPos[5];
    int tam, tamPos;
    int numero;
    int contador = 0;

    tam = (sizeof(array)/sizeof(array[0]));

    for (int i=0;i<tam;i++){
        printf("array[%d]: ",i);
        scanf("%d", &array[i]);
    }

    printf("Buscar por: ");
    scanf("%d", &numero);

    for (int i=0;i<tam;i++){
        if (array[i] == numero){
            arrayPos[contador] = i;
            contador++;
        }
    }

    if (contador == 0){
        printf("O array nao contem o valor %d.",numero);
    }
    else if (contador == 1){
        for (int i=0;i<contador;i++){
            printf("O valor %d foi encontrado no indice %d do array.",numero,arrayPos[i]);
        }
    }
    else{
        printf("O valor %d foi encontrado nos indices ",numero);
        for (int i=0;i<contador-1;i++){
            printf("%d",arrayPos[i]);
            if(i!=contador-2){
                printf(", ");
            }
        }
        printf(" e %d do array.",arrayPos[contador-1]);
    }

    return 0;
}

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main(){

    int array1[5], array2[5], arrayInter[5];
    int tam1, tam2, tamInter;
    int contador = 0;
    bool verificarRepeticao = false;

    tam1 = (sizeof(array1)/sizeof(array1[0]));
    tam2 = (sizeof(array2)/sizeof(array2[0]));
    tamInter = (sizeof(arrayInter)/sizeof(arrayInter[0]));

    printf("Fornecas os valores do primeiro array:\n");

    for (int i=0;i<tam1;i++){
        printf("\tarray1[%d]: ",i);
        scanf("%d", &array1[i]);
    }

    printf("\nFornecas os valores do segundo array:\n");

    for (int i=0;i<tam2;i++){
        printf("\tarray2[%d]: ",i);
        scanf("%d", &array2[i]);
    }

    for (int i=0;i<tam1;i++){
        for (int j=0;j<tam2;j++){
            if (array1[i] == array2[j]){
                arrayInter[contador] = array1[i];
                contador++;
            }
        }
    }

    if (contador==0){
        printf("Nao ha interseccao entre os elementos dos dois arrays fornecidos!");
    }
    else{
        for (int i=0;i<contador;i++){
            for (int j=0;j<i;j++){
                if (arrayInter[i] == arrayInter[j]){
                    verificarRepeticao = true;
                }
            }
            if (!verificarRepeticao){
                printf("arrayInterseccao[%d] = %d\n",i,arrayInter[i]);
            }
            verificarRepeticao = false;
        }
    }

    return 0;
}

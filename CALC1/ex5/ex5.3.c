#include <stdlib.h>
#include <stdio.h>

int main(){
    int array[3][4];
    int tamLinha;
    int tamColuna;
    int multplicador;

    tamLinha = (sizeof(array)/sizeof(array[0]));
    tamColuna = (sizeof(array[0])/sizeof(array[0][0]));

    for (int i=0;i<tamLinha;i++){
        for (int j=0;j<tamColuna;j++){
            printf("array[%d][%d]: ",i,j);
            scanf("%d", &array[i][j]);
        }
    }

    printf("Multiplicar por: ");
    scanf("%d", &multplicador);

    printf("arrayMult:\n");

    for (int i=0;i<tamLinha;i++){
        for (int j=0;j<tamColuna;j++){
            printf("%03d",(array[i][j]*multplicador));
            if (j!=(tamColuna-1)){
                printf(" ");
            }
        }
        printf("\n");
    }

    return 0;
}

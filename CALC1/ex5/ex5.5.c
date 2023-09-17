#include <stdlib.h>
#include <stdio.h>

int main(){
    int array[3][3];
    int tamLinha;
    int tamColuna;
    int i,j,k;
    int determinante;

    tamLinha = (sizeof(array)/sizeof(array[0]));
    tamColuna = (sizeof(array[0])/sizeof(array[0][0]));

    for (int i=0;i<tamLinha;i++){
        for (int j=0;j<tamColuna;j++){
            printf("array[%d][%d]: ",i,j);
            scanf("%d", &array[i][j]);
        }
    }

    i = (array[1][1] * array[2][2]) - (array[2][1] * array[1][2]);
    j = (array[1][0] * array[2][2]) - (array[2][0] * array[1][2]);
    k = (array[1][0] * array[2][1]) - (array[2][0] * array[1][1]);

    determinante = (array[0][0]*i) - (array[0][1]*j) + (array[0][2]*k);

    printf("Determinante: %d",determinante);

    return 0;
}

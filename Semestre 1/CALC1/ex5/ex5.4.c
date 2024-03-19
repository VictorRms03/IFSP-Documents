#include <stdlib.h>
#include <stdio.h>

int main(){
    int array[2][2];
    int tamLinha;
    int tamColuna;
    int determinante;

    tamLinha = (sizeof(array)/sizeof(array[0]));
    tamColuna = (sizeof(array[0])/sizeof(array[0][0]));

    for (int i=0;i<tamLinha;i++){
        for (int j=0;j<tamColuna;j++){
            printf("array[%d][%d]: ",i,j);
            scanf("%d", &array[i][j]);
        }
    }

    determinante = (array[0][0] * array[1][1]) - (array[0][1] * array[1][0]);

    printf("Determinante: %d",determinante);

    return 0;
}

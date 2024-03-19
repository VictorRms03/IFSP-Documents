#include <stdlib.h>
#include <stdio.h>

int main(){
    int array[3][2];
    int tamLinha;
    int tamColuna;

    tamLinha = (sizeof(array)/sizeof(array[0]));
    tamColuna = (sizeof(array[0])/sizeof(array[0][0]));

    for (int i=0;i<tamLinha;i++){
        for (int j=0;j<tamColuna;j++){
            printf("array[%d][%d]: ",i,j);
            scanf("%d", &array[i][j]);
        }
    }

    for (int i=0;i<tamLinha;i++){
        for (int j=0;j<tamColuna;j++){
            printf("%03d",array[i][j]);
            if (j!=(tamColuna-1)){
                printf(" ");
            }
        }
        printf("\n");
    }

    return 0;
}

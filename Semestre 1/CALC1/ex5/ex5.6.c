#include <stdlib.h>
#include <stdio.h>

int main(){
    int array[2][3];
    int tamLinha;
    int tamColuna;
    int arrayT[3][2];

    tamLinha = (sizeof(array)/sizeof(array[0]));
    tamColuna = (sizeof(array[0])/sizeof(array[0][0]));

    for (int i=0;i<tamLinha;i++){
        for (int j=0;j<tamColuna;j++){
            printf("array[%d][%d]: ",i,j);
            scanf("%d", &array[i][j]);
        }
    }

    for (int i=0;i<tamColuna;i++){
        for (int j=0;j<tamLinha;j++){
            arrayT[i][j] = array[j][i];
        }
    }

    printf("M:\n");

    for (int i=0;i<tamLinha;i++){
        for (int j=0;j<tamColuna;j++){
            printf("%03d",array[i][j]);
            if (j!=(tamColuna-1)){
                printf(" ");
            }
        }
        printf("\n");
    }

    printf("\nMt:\n");

    for (int i=0;i<tamColuna;i++){
        for (int j=0;j<tamLinha;j++){
            printf("%03d",arrayT[i][j]);
            if (j!=(tamLinha-1)){
                printf(" ");
            }
        }
        printf("\n");
    }

    return 0;
}

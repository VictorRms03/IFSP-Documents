#include <stdio.h>
#include <stdlib.h>

int main(){

    int array1[3][2];
    int tamLinha1;
    int tamColuna1;

    int array2[2][3];
    int tamLinha2;
    int tamColuna2;
    int arrayMult[3][3];
    int contador = 0;


    tamLinha1 = (sizeof(array1)/sizeof(array1[0]));
    tamColuna1 = (sizeof(array1[0])/sizeof(array1[0][0]));

    tamLinha2 = (sizeof(array2)/sizeof(array2[0]));
    tamColuna2 = (sizeof(array2[0])/sizeof(array2[0][0]));

    for (int i=0;i<tamLinha1;i++){
        for (int j=0;j<tamColuna1;j++){
            printf("array1[%d][%d]: ",i,j);
            scanf("%d", &array1[i][j]);
        }
    }

    for (int i=0;i<tamLinha2;i++){
        for (int j=0;j<tamColuna2;j++){
            printf("array2[%d][%d]: ",i,j);
            scanf("%d", &array2[i][j]);
        }
    }

    for (int i=0;i<tamLinha1;i++){
        for (int j=0;j<tamColuna2;j++){
            for (int k=0;k<tamLinha2;k++){
                contador = contador + array1[i][k] * array2[k][j];
            }
            arrayMult[i][j] = contador;
            contador = 0;
        }
    }

    printf("A x B =\n");

    for (int i=0;i<tamLinha1;i++){
        for (int j=0;j<tamColuna2;j++){
            printf("%03d",arrayMult[i][j]);
            if (j!=tamColuna2-1){
                printf(" ");
            }
        }
        printf("\n");
    }

    return 0;
}

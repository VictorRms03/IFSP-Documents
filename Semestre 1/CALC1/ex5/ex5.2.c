#include <stdlib.h>
#include <stdio.h>

int main(){
    int array1[3][3];
    int tamLinha1;
    int tamColuna1;

    int array2[3][3];
    int tamLinha2;
    int tamColuna2;

    int arraySoma[3][3];
    int tamLinhaSoma;
    int tamColunaSoma;

    tamLinha1 = (sizeof(array1)/sizeof(array1[0]));
    tamColuna1 = (sizeof(array1[0])/sizeof(array1[0][0]));

    tamLinha2 = (sizeof(array2)/sizeof(array2[0]));
    tamColuna2 = (sizeof(array2[0])/sizeof(array2[0][0]));

    tamLinhaSoma = (sizeof(arraySoma)/sizeof(arraySoma[0]));
    tamColunaSoma = (sizeof(arraySoma[0])/sizeof(arraySoma[0][0]));


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

    for (int i=0;i<tamLinhaSoma;i++){
        for (int j=0;j<tamColunaSoma;j++){
            arraySoma[i][j] = array1[i][j] + array2[i][j];
        }
    }

    printf("array1:       array2:       arraySoma:\n");

    for (int i=0;i<tamColuna1;i++){
        printf("%03d",array1[0][i]);
        if (i!=tamColuna1-1){
            printf(" ");
        }
        else{
            printf("   ");
        }
    }

    for (int i=0;i<tamColuna2;i++){
        printf("%03d",array2[0][i]);
        if (i!=tamColuna2-1){
            printf(" ");
        }
        else{
            printf("   ");
        }
    }

    for (int i=0;i<tamColunaSoma;i++){
        printf("%03d",arraySoma[0][i]);
        if (i!=tamColunaSoma-1){
            printf(" ");
        }
    }

    printf("\n");

    for (int i=0;i<tamColuna1;i++){
        printf("%03d",array1[1][i]);
        if (i!=tamColuna1-1){
            printf(" ");
        }
        else{
            printf(" + ");
        }
    }

    for (int i=0;i<tamColuna2;i++){
        printf("%03d",array2[1][i]);
        if (i!=tamColuna2-1){
            printf(" ");
        }
        else{
            printf(" = ");
        }
    }

    for (int i=0;i<tamColunaSoma;i++){
        printf("%03d",arraySoma[1][i]);
        if (i!=tamColunaSoma-1){
            printf(" ");
        }
    }

    printf("\n");

    for (int i=0;i<tamColuna1;i++){
        printf("%03d",array1[2][i]);
        if (i!=tamColuna1-1){
            printf(" ");
        }
        else{
            printf("   ");
        }
    }

    for (int i=0;i<tamColuna2;i++){
        printf("%03d",array2[2][i]);
        if (i!=tamColuna2-1){
            printf(" ");
        }
        else{
            printf("   ");
        }
    }

    for (int i=0;i<tamColunaSoma;i++){
        printf("%03d",arraySoma[2][i]);
        if (i!=tamColunaSoma-1){
            printf(" ");
        }
        else{
            printf("   ");
        }
    }

    return 0;
}

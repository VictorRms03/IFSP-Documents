#include <stdio.h>
#include <stdlib.h>

int main(){

    int valor;

    printf("Numero entre 1 e 100: ");
    scanf("%d", &valor);

    if (valor>=1 && valor<=100){
        int numero = 1;

        for(int i=1;i<=valor;i++){
            for (int j=1;j<=valor;j++){
                for (int k=0;k<=(valor/2);k++){
                    if ((i==valor-k) || (i==k+1) || (j==valor-k) || (j==k+1)){
                        numero = k + 1;
                        k = valor;
                    }
                }
                printf("%3d",numero);

                if (j<valor){
                    printf(" ");
                }
            }
            printf("\n");
        }
    }
    else{
        printf("Numero incorreto!");
    }

    return 0;
}

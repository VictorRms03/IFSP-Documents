#include <stdio.h>
#include <stdlib.h>

int main(){

    int valor;

    printf("Numero entre 1 e 100: ");
    scanf("%d", &valor);

    if (valor>=1 && valor<=100){
        int numero = 1;

        for(int i=0;i<valor;i++){

            numero = i + 2;

            for (int j=0;j<valor;j++){

                if (i<j){
                    numero++;
                }
                else if (i>j){
                    numero--;
                }
                else{
                    numero = 1;
                }

                printf("%3d",numero);

                if (j<valor-1){
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

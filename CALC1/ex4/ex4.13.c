#include <stdio.h>
#include <stdlib.h>

int main(){

    int array[10];
    int tam;
    int removerPosicao;

    tam = (sizeof(array)/sizeof(array[0]));

    for (int i=0;i<tam;i++){
        printf("array[%d]: ",i);
        scanf("%d", &array[i]);
    }

    do{
        printf("Posicao a ser removida (0 a 9): ");
        scanf("%d", &removerPosicao);

        if (removerPosicao<1 || removerPosicao>9){
            printf("Posicao invalida, forneca novamente!\n");
        }
    }while(removerPosicao<1 || removerPosicao>9);

    for (int i=0;i<tam-1;i++){
        if (i>=removerPosicao){
            array[i] = array[i+1];
        }
    }

    for (int i=0;i<tam-1;i++){
            printf("array[%d] = %d\n",i,array[i]);
    }

    return 0;
}

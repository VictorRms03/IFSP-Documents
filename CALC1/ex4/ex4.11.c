#include <stdio.h>
#include <stdlib.h>

int main(){

    int array[10] = {0};
    int quantidadeElementos;
    int valorInserido;
    int tam;
    int troca;

    tam = (sizeof(array)/sizeof(array[0]));

    do{
        printf("Quantidade de elementos (1 a 9): ");
        scanf("%d", &quantidadeElementos);

        if (quantidadeElementos<1 || quantidadeElementos>9){
            printf("Quantidade incorreta, forneca novamente!\n");
        }
    }while(quantidadeElementos<1 || quantidadeElementos>9);

    for (int i=0;i<quantidadeElementos;i++){
        printf("array[%d]: ",i);
        scanf("%d", &array[i]);
    }

    printf("Valor que sera inserido: ");
    scanf("%d", &valorInserido);

    for (int i=(tam-1);i>0;i--){
        array[i] = array[i-1];
    }
    array[0] = valorInserido;

    for (int i=0;i<tam;i++){
        if (array[i]!=0){
            printf("array[%d] = %d\n",i,array[i]);
        }
    }

    return 0;
}

#include <stdio.h>
#include <stdlib.h>

int buscar (const int *a, int n, int chave);

int main(){

    int array[10];
    int tam = 10;
    int buscarPor;
    int retornoBusca;

    for (int i=0;i<tam;i++){
        printf("n[%d]: ",i);
        scanf("%d",&array[i]);
    }
    printf("Buscar por: ");
    scanf("%d", &buscarPor);

    retornoBusca = buscar(array,tam,buscarPor);

    if(retornoBusca != -1){
        printf("O valor %d foi encontrado na posicao %d.",buscarPor,retornoBusca);
    }
    else{
        printf("O valor %d nao foi encontrado.",buscarPor);
    }

}

int buscar (const int *a, int n, int chave){

    int retorno;

    for (int i=0;i<n;i++){
        if (a[i] == chave){
            retorno = i;
            break;
        }
        else{
            retorno = -1;
        }
    }

    return retorno;
}

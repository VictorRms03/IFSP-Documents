#include <stdlib.h>
#include <stdio.h>

int somaDivisores (int n){

    int somaDiv;

    for (int i=1;i<n;i++){
        if (n%i==0){
            somaDiv = somaDiv + i;
        }
    }

    return somaDiv;
}


int main (){

    int n[5];

    for (int i=0;i<5;i++){
        printf("n[%d]: ",i);
        scanf("%d", &n[i]);

        if (n[i]<0){
            do{
                printf("Entre com um valor positivo: ");
                scanf("%d", &n[i]);
            }while(n[i]<0);
        }
    }

    for (int i=0;i<5;i++){
        printf("Soma dos divisores de %d: %d\n",n[i],somaDivisores(n[i]));
    }

    return 0;
}

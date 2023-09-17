#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>

int lePositivo (){

    int n;

    scanf("%d", &n);

    if (n<0){
        do{
            printf("Entre com um valor positivo: ");
            scanf("%d", &n);
        }while(n<0);
    }

    return n;
}

int somaDivisores (int n){

    int somaDiv = 0;

    for (int i=1;i<n;i++){
        if (n%i==0){
            somaDiv = somaDiv + i;
        }
    }

    return somaDiv;
}

bool saoAmigos (int n1, int n2){

    bool verificadorAmigo;

    if (n1==n2){
        verificadorAmigo = true;
    }
    else{
        verificadorAmigo = false;
    }

    return verificadorAmigo;
}


int main (){

    int n1[5];
    int n2[5];
    int somaDivisores1;
    int somaDivisores2;

    for (int i=0;i<5;i++){
        printf("n1[%d]: ",i);
        n1[i] = lePositivo();
        printf("n2[%d]: ",i);
        n2[i] = lePositivo();
    }

    for (int i=0;i<5;i++){
        somaDivisores1 = somaDivisores(n1[i]);
        somaDivisores2 = somaDivisores(n2[i]);

        if (saoAmigos(n1[i],somaDivisores2) && saoAmigos(n2[i],somaDivisores1)){
            printf("%d e %d sao amigos",n1[i],n2[i]);
        }
        else{
            printf("%d e %d nao sao amigos",n1[i],n2[i]);
        }
        printf("\n");
    }

    return 0;
}

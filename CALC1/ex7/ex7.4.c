#include <stdlib.h>
#include <stdio.h>


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

int somatorio (int n){

    int somar = 0;

    for (int i=1;i<=n;i++){
        somar = somar + i;
    }

    return somar;
}


int main (){

    int n[5];

    for (int i=0;i<5;i++){
        printf("n[%d]: ",i);
        n[i] = lePositivo();
    }

    for (int i=0;i<5;i++){
        printf("Somatorio de 1 a %d: %d\n",n[i],somatorio(n[i]));
    }

    return 0;
}

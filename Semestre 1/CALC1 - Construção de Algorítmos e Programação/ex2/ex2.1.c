#include <stdio.h>
#include <stdlib.h>

int main(){

    int n;

    printf("Entre com um numero:");
    scanf("%d",&n);

    if(n % 2 == 0 ){

            printf("O numero %d e par.",n);
    }

    else{

        printf("O numero %d e impar.",n);
    }

    return 0;

}

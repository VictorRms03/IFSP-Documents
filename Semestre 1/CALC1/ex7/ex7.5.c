#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>


bool ehPar (int n){

    bool verificarPar;

    if (n%2==0){
        verificarPar = true;
    }
    else{
        verificarPar = false;
    }

    return verificarPar;
}

bool ehDivisivel (int dividendo, int divisor){

    bool verificarDivisor;

    if (dividendo%divisor==0){
        verificarDivisor = true;
    }
    else{
        verificarDivisor = false;
    }

    return verificarDivisor;
}


int main (){

    int n1[5];
    int n2[5];

    for (int i=0;i<5;i++){
        printf("n1[%d]: ",i);
        scanf("%d",&n1[i]);
        printf("n2[%d]: ",i);
        scanf("%d",&n2[i]);
    }

    for (int i=0;i<5;i++){
        if (ehPar(n1[i])){
            printf("%d eh par e ",n1[i]);
        }
        else{
            printf("%d eh impar e ",n1[i]);
        }

        if (ehDivisivel(n1[i],n2[i])){
            printf("%d eh divisivel por %d\n",n1[i],n2[i]);
        }
        else{
            printf("%d nao eh divisivel por %d\n",n1[i],n2[i]);
        }
    }
    return 0;
}

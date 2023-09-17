#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>

bool ehPrimo (int n){

    bool verificarPrimo;

    if (n<=1){
        verificarPrimo = false;
    }
    else{
        int contador = 0;
        for (int i=1;i<=n;i++){
            if (n%i==0){
                contador++;
            }
        }
        if (contador==2){
            verificarPrimo = true;
        }
        else{
            verificarPrimo = false;
        }
    }

    return verificarPrimo;
}


int main (){

    for (int i=1;i<=20;i++){
        if (ehPrimo(i)){
            printf("%d: eh primo",i);
        }
        else{
            printf("%d: nao eh primo",i);
        }
        printf("\n");
    }

    return 0;
}

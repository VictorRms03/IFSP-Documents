#include <stdio.h>
#include <stdlib.h>

int fatorialIterativo(int n);

int main(){

    int n;
    int fat;

    printf( "Forneca o numero 'n' requerido: ");
    scanf( " %d", &n);

    printf( "\n");

    fat = fatorialIterativo(n);

    printf( "Fatorial de %d = %d", n, fat);

    return 0;
}

int fatorialIterativo(int n){

    int fat = 1;

    if(n<=1){
        return 1;
    } else {

        for(int i=n; i>=0; i--){
            if(i <= 1){
                return fat;
            } else {
                fat *= i;
            }
        }
    }
}

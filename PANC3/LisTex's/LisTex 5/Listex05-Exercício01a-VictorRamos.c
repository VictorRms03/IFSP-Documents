#include <stdio.h>
#include <stdlib.h>

int fatorialRecursivo(int n);

int main(){

    int n;
    int fat;

    printf( "Forneca o numero 'n' requerido: ");
    scanf( " %d", &n);

    printf( "\n");

    fat = fatorialRecursivo(n);

    printf( "Fatorial de %d = %d", n, fat);

    return 0;
}

int fatorialRecursivo(int n){

    if(n<=1){
        return 1;
    } else {
        return n * fatorialRecursivo(n-1);
    }
}

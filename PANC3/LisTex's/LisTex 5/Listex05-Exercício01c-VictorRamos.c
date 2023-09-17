#include <stdio.h>
#include <stdlib.h>

void hanoi(int n, int origem, int destino, int auxiliar);

int main(){

    int n;

    printf( "Entrar com o numero de discos: ");
    scanf( " %d", &n);

    hanoi( n, 1, 3, 2);
    return 0;
}

void hanoi(int n, int origem, int destino, int auxiliar){

    if(n>0){
        hanoi(n-1, origem, auxiliar, destino);
        printf( "Mover disco da Torre %d para a Torre %d\n", origem, destino);
        hanoi(n-1, auxiliar, destino, origem);
    }
}

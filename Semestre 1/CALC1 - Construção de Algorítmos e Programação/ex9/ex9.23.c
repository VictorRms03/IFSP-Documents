#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <ctype.h>

void imprimirCaixa( const char *str);

int main() {

    char str[41];

    printf( "String: ");
    fgets(str,41,stdin);
    str[strlen(str)-1] = '\0';

    imprimirCaixa(str);
}

void imprimirCaixa( const char *str){

    int tam;
    tam = strlen(str);

    for(int i=0; i<tam+6;i++){
        if (i < 2 || i > tam + 3){
            printf( "+");
        } else {
            printf( "=");
        }

        if(i == tam+5){
            printf( "\n");
        }
    }

    printf( "|| %s ||\n", str);

    for(int i=0; i<tam+6;i++){
        if (i < 2 || i > tam + 3){
            printf( "+");
        } else {
            printf( "=");
        }
    }
}

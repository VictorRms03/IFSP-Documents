#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <ctype.h>

void imprimirCentralizado( const char *str);

int main() {

    char str[41];

    printf( "String: ");
    fgets(str,41,stdin);
    str[strlen(str)-1] = '\0';

    imprimirCentralizado(str);
}

void imprimirCentralizado( const char *str){

    int tam;
    tam = strlen(str);

    for(int i=0; i<40-tam/2;i++){
        printf( " ");
    }
    printf( "%s", str);

    for(int i=0; i<40-tam/2;i++){
        printf( " ");
    }
}

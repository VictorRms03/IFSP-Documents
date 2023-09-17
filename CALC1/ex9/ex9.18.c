#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <ctype.h>

bool ehPalindromo( const char *str);

int main() {

    char str[41];

    printf( "String: ");
    fgets(str,41,stdin);
    str[strlen(str)-1] = '\0';

    if (ehPalindromo(str)){
        printf( "\"%s\" eh um palindromo!", str);
    } else {
        printf( "\"%s\" nao eh um palindromo!", str);
    }
    return 0;

}

bool ehPalindromo( const char *str){

    char destino[41];
    int tam;

    tam = strlen(str);

    for (int i=0;i<tam;i++){
        destino[i] = str[tam-1-i];
    }

    destino[tam] = '\0';

    if (strcmp(destino, str) == 0){
        return true;
    } else {
        return false;
    }
}

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <ctype.h>

bool contem( const char *fonte, const char *aPesquisar);

int main() {

    char fonte[41];
    char aPesquisar[41];

    printf( "String fonte: ");
    fgets(fonte,41,stdin);
    fonte[strlen(fonte)-1] = '\0';

    printf( "String a pesquisar: ");
    fgets(aPesquisar,41,stdin);
    aPesquisar[strlen(aPesquisar)-1] = '\0';

    if (contem(fonte, aPesquisar)){
        printf( "\"%s\" esta contida em \"%s\"", aPesquisar, fonte);
    } else {
        printf( "\"%s\" nao esta contida em \"%s\"", aPesquisar, fonte);
    }

    return 0;
}

bool contem( const char *fonte, const char *aPesquisar){

    int tam;
    int contador = 0;
    tam = strlen(fonte);

    for (int i=0;i<tam;i++){
        if (fonte[i] == aPesquisar[contador])
        contador++;
    }

    if (contador == strlen(aPesquisar)){
        return true;
    } else {
        return false;
    }
}

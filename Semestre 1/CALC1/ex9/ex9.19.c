#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void substring( char *recorte, const char *origem, int inicio, int fim );

int main() {

    char str[41];
    char recorte[41];
    int inicio;
    int fim;

    printf( "Frase: " );
    fgets( str, 41, stdin );
    str[strlen(str)-1] = '\0';

    printf( "Inicio: " );
    scanf( "%d", &inicio );

    printf( "Fim: " );
    scanf( "%d", &fim );

    substring( recorte, str, inicio, fim );

    printf( "Recorte: %s", recorte );

    return 0;

}

void substring( char *recorte, const char *origem,
                int inicio, int fim ) {

     int tamanho = strlen( origem );
     int pRecorte = 0;

     if ( inicio > fim || inicio > tamanho-1 || fim > tamanho-1 ) {
        strcpy( recorte, origem );
     } else {

        for ( int i = inicio; i < fim; i++ ) {
            recorte[pRecorte] = origem[i];
            pRecorte++;
        }

        recorte[pRecorte] = '\0';

     }

}

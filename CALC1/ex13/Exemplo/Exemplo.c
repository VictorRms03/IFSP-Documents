#include <stdio.h>
#include <stdlib.h>

int main() {

    FILE *arquivo = fopen( "dados.txt", "r");
    char linha[100];
    int i = 1;
    int contador = 0;

    if (arquivo != NULL){

        while ( !feof( arquivo ) ){

            fgets( linha, 100, arquivo );
            contador = contador + strlen( linha );
            printf( "Linha %d: %s", i++, linha);
        }

        printf( "\nO arquivo possui %d caracteres.", contador);
    }

    fclose( arquivo );

    return 0;
}

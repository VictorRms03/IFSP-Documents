#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int contarOcorrencias( const char *str, char c );

int main() {

    char frase[41];

    printf( "Frase: " );
    fgets( frase, 41, stdin );
    frase[strlen(frase)-1] = '\0';

    printf( "A/a: %d\n", contarOcorrencias( frase, 'A' ) +
                         contarOcorrencias( frase, 'a' ) );

    printf( "B/b: %d\n", contarOcorrencias( frase, 'B' ) +
                         contarOcorrencias( frase, 'b' ) );

    printf( "C/c: %d\n", contarOcorrencias( frase, 'C' ) +
                         contarOcorrencias( frase, 'c' ) );

    printf( "D/d: %d\n", contarOcorrencias( frase, 'D' ) +
                         contarOcorrencias( frase, 'd' ) );

    printf( "E/e: %d\n", contarOcorrencias( frase, 'E' ) +
                         contarOcorrencias( frase, 'e' ) );

    return 0;

}

int contarOcorrencias( const char *str, char c ) {

    int contador = 0;
    int tamanho = strlen( str );

    for ( int i = 0; i < tamanho; i++ ) {
        if ( str[i] == c ) {
            contador++;
        }
    }

    return contador;

}

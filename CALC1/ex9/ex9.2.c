#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

int main() {

    char str[41];

    printf( "Sentenca: ");
    fgets(str, 41, stdin);
    str[strlen(str)-1] = '\0';

    printf( "Primeiro caractere: %c\n", str[0]);
    printf( "Ultimo caractere: %c\n", str[strlen(str)-1]);
    printf( "Numero de caracteres: %d", strlen(str));

    return 0;
}

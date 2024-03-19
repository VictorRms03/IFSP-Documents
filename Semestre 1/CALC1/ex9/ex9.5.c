#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

int main() {

    char str[41];
    int contador = 0;

    printf( "Nome: ");
    fgets(str, 41, stdin);
    str[strlen(str)-1] = '\0';

    printf( "%s\n", str);
    printf( "%s\n", str);
    printf( "%s\n", str);
    printf( "%s\n", str);
    printf( "%s\n", str);

    return 0;
}

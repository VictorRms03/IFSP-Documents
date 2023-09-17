#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

int main() {

    char str[41];
    int contador = 0;

    printf( "Sentenca: ");
    fgets(str, 41, stdin);
    str[strlen(str)-1] = '\0';

    while (contador < strlen(str)){
        if (contador % 2 != 0){
            if (contador == strlen(str)-1 || contador == strlen(str)-2){
                if (str[contador]==' '){
                    printf( "'%c'", str[contador]);
                } else {
                    printf( "%c", str[contador]);
                }
            } else {
                if (str[contador]==' '){
                    printf( "'%c', ", str[contador]);
                } else {
                    printf( "%c, ", str[contador]);
                }
            }
        }
        contador++;
    }

    return 0;
}

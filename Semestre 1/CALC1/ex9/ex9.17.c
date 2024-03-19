#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

int contarPalavras( const char *str);

int main() {

    char str[41];

    printf( "Frase: ");
    fgets(str,41,stdin);
    str[strlen(str)-1] = '\0';

    printf( "Quantidade de palavras: %d", contarPalavras(str));

    return 0;

}

int contarPalavras( const char *str){

    int tam;
    int palavras = 1;
    tam = strlen(str);

    for (int i=0;i<tam;i++){
        if(str[i] == ' '){
            palavras++;
        }
    }

    return palavras;
}

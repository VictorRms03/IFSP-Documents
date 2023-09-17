#include <stdio.h>
#include <stdlib.h>
#include <string.h>
void inverter(char *destino, const char *origem);

int main() {

    char str[41];
    char inv[41];


    printf("String: ");
    fgets(str,41,stdin);
    str[strlen(str)-1] = '\0';

    inverter(inv,str);

    printf("Invertida: %s", inv);
}

void inverter(char *destino, const char *origem){

    int tam;

    tam = strlen(origem);

    for (int i=0;i<tam;i++){
        destino[i] = origem[tam-1-i];
    }

    destino[tam] = '\0';
}

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int tamanho(const char *str);

int main() {

    char str[41];

    printf("String: ");
    fgets(str,41,stdin);
    str[strlen(str)-1] = '\0';

    printf("%d caractere(s)!", tamanho(str));
}

int tamanho(const char *str){
    int i=0;
    int tamanho=0;

    while(str[i] != '\0'){
        tamanho++;
        i++;
    }

    return tamanho;

}

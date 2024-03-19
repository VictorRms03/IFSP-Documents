#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

void tornarMaiuscula(char *str);

int main() {

    char str[41];


    printf("Frase: ");
    fgets(str,41,stdin);
    str[strlen(str)-1] = '\0';

    tornarMaiuscula(str);

    printf("%s", str);

}

void tornarMaiuscula(char *str){

    int tam;
    tam = strlen(str);

    for (int i=0; i<tam; i++){
        str[i] = toupper(str[i]);
    }
}

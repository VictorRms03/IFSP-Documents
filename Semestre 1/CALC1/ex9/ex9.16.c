#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

void removerLetra(char *str, char c);

int main() {

    char str[41];
    char c;

    printf("Frase: ");
    fgets(str,41,stdin);
    str[strlen(str)-1] = '\0';

    printf("Caractere: ");
    scanf(" %c", &c);

    removerLetra(str, c);

    printf("%s", str);

}

void removerLetra(char *str, char c){

    char straux[41];
    int tam;
    int contador=0;
    tam = strlen(str);



    for (int i=0; i<tam; i++){


        if (str[i] == toupper(c) || str[i] == tolower(c)){

        } else {
            straux[contador++] = str[i];
        }
    }

    straux[contador+1] = '\0';

    strcpy(str,straux);
}

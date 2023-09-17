#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

int contarOcorrencias(const char *str, char c);

int main(){

    char frase[41] = " ";
    char caractere;

    printf("Caractere: ");
    scanf(" %c",&caractere);
    getchar();

    while (strcmp(frase, "fim") != 0){

        printf("Frase: ");
        fgets(frase,41,stdin);
        frase[strlen(frase)-1]='\0';

        if (strcmp(frase, "fim") == 0){
            return 0;
        }

        printf("\"%s\" tem %d ocorrencia(s) do caractere '%c'\n",frase,contarOcorrencias(frase,caractere),caractere);


    }

    return 0;

}

int contarOcorrencias(const char *str, char c){

    int tamanho;
    int contador = 0;

    tamanho = strlen(str);

    for(int i = 0 ; i < tamanho;i++){
        if(str[i] == c){
            contador ++;
        }
    }

    return contador;

}

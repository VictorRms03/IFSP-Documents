#include <stdio.h>
#include <stdlib.h>

int main() {

    FILE *arquivo;
    float nota;
    float soma = 0;
    float media;
    int quantidade;

    arquivo = fopen("notas.txt", "r");

    if (arquivo != NULL){
        while(!feof(arquivo)){
            fscanf(arquivo, "%f", &nota);
            soma += nota;
            quantidade++;
        }

        media = soma/quantidade;

        printf( "Media: %.2f", media);
    }

    fclose(arquivo);

    return 0;
}

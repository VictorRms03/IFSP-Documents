#include <stdio.h>
#include <stdlib.h>

int main() {

    float nota1;
    float nota2;
    float notaop;
    float media;

    printf( "Nota Av. 1: ");
    scanf( "%f", &nota1);

    printf( "Nota Av. 2: ");
    scanf( "%f", &nota2);

    printf( "Nota Optativa: ");
    scanf( "%f", &notaop);

    if (notaop < 0) {
        media = (nota1 + nota2) / 2;
    }

    if ((notaop >= 0) && (notaop < nota1) && (notaop < nota2)) {
        media = (nota1 + nota2) / 2;
    }

    if ((nota1 < nota2) && (notaop > nota1)) {
        media = (notaop + nota2) / 2;
    }

    if ((nota2 < nota1) && (notaop > nota2)) {
        media = (notaop + nota1) / 2;
    }

        printf( "Media: %.2f\n", media);

        if (media >= 6) {
            printf( "Aprovado!");
        }

        if ((media >= 4) && (media < 6)) {
            printf( "Exame.");
        }

        if (media < 4) {
            printf( "Reprovado...");
        }

}

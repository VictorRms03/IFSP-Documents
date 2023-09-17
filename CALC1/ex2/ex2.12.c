#include <stdio.h>
#include <stdlib.h>

int main() {

    int h1;
    int h2;
    int m1;
    int m2;
    int soma;
    int produto;

    printf( "Idade Homem 1: ");
    scanf("%d", &h1);

    printf( "Idade Homem 2: ");
    scanf("%d", &h2);

    printf( "Idade Mulher 1: ");
    scanf("%d", &m1);

    printf( "Idade Mulher 2: ");
    scanf("%d", &m2);


    if ((h1>h2) && (m1<m2)) {
        soma = h1 + m1;
        produto = h2 * m2;
    }

    if ((h1>h2) && (m2<m1)) {
        soma = h1 + m2;
        produto = h2 * m1;
    }

    if ((h2>h1) && (m1<m2)) {
        soma = h2 + m1;
        produto = h1 * m2;
    }

    if ((h2>h1) && (m2<m1)) {
        soma = h2 + m2;
        produto = h1 * m1;
    }

    printf( "Idade homem mais velho + idade mulher mais nova: %d\n", soma);
    printf( "Idade homem mais novo * idade mulher mais velha: %d\n", produto);

}

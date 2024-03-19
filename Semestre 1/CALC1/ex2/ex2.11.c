#include <stdio.h>
#include <stdlib.h>

int main() {

    float alfa;
    float beta;
    float gama;

    printf( "alfa: ");
    scanf("%f", &alfa);

    printf( "beta: ");
    scanf("%f", &beta);

    printf( "gama: ");
    scanf("%f", &gama);

    if (alfa + beta + gama == 180) {

        if ((alfa == 90) || (beta == 90) || (gama == 90)) {
            printf( "Triangulo RETANGULO");
        }

        if ((alfa > 90) || (beta > 90) || (gama > 90)) {
            printf( "Triangulo OBTUSANGULO");
        }

        if ((alfa < 90) && (beta < 90) && (gama < 90)) {
            printf( "Triangulo ACUTANGULO");
        }
    } else {
        printf( "As medidas fornecidas dos angulos nao representam um triangulo valido!");
    }
}

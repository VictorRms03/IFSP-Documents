#include <stdio.h>
#include <stdlib.h>

int main() {

    int lados;
    float lado;
    float result;

    printf( "Entre com a quatidade de lados: ");
    scanf ("%d", &lados);
    printf( "Entre com a medida do lado: ");
    scanf ("%f", &lado);


    if (lados == 3) {
        result = lado * 3;
        printf( "TRIANGULO de perimetro %.2f", result);

    } else {

    if (lados == 4) {
        result = lado * lado;
        printf( "QUADRADO de area %.2f", result);

    } else {

    if (lados == 5) {
        printf( "PENTAGONO");

    } else {
        printf( "Poligono nao identificado");
    }
    }
    }
}

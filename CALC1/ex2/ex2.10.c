#include <stdio.h>
#include <stdlib.h>

int main() {

    float a;
    float b;
    float c;

    printf( "Digite as medidas dos lados do triangulo: \n");
    printf( "a: ");
    scanf("%f", &a);
    printf( "b: ");
    scanf("%f", &b);
    printf( "c: ");
    scanf("%f", &c);


    if (a+b > c && a+c > b && b+c > a){

        if ((a == b) && (b == c)) {
            printf( "Triangulo EQUILATERO");

        } else {

        if ((a == b) && (b != c)) {
            printf ("Triangulo ISOSCELES");

        } else {

        if ((a == c) && (b != a)) {
            printf( "Triangulo ISOSCELES");

        } else {

        if ((b == c) && (a != b)) {
            printf( "Triangulo ISOSCELES");

        } else {

        if ((a != b) && (b != c)) {
            printf ("Triangulo ESCALENO");
        }
        }
        }
        }
        }

    } else {

        printf( "As medidas fornecidas dos lados nao representam um triangulo valido!");

    }
}

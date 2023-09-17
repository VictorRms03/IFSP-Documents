#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(){

    float numero;

    printf( "Numero: ");
    scanf( "%f", &numero);

    printf( "Maior inteiro mais proximo: %.2f\n", ceil(numero));
    printf( "Menor inteiro mais proximo: %.2f", floor(numero));

    return 0;
}

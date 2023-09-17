#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(){

    float numero;

    printf( "Numero: ");
    scanf( "%f", &numero);

    if (numero >= 0){
        printf( "Raiz quadrada de %.2f: %.2f", numero, sqrt(numero));
    } else {
        printf( "Quadrado de %.2f: %.2f", numero, pow(numero, 2));
    }
    return 0;
}

#include <stdio.h>
#include <stdlib.h>

int main() {

    float valor = 0;
    int qnt_valores = 0;
    float somatorio = 0;
    float media = 0;

    while ( valor >= 0 ) {
        printf( "Entre com um valor: ");
        scanf( "%f", &valor);

        if (valor >= 0) {
        qnt_valores++;
        somatorio = valor + somatorio;
        media = somatorio / qnt_valores;
        }
    }

    printf( "Somatorio: %.2f\n", somatorio);
    printf( "Media: %.2f\n", media);
    printf( "Quantidade: %d\n", qnt_valores);

    return 0;
}

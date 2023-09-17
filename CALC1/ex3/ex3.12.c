#include <stdio.h>
#include <stdlib.h>

int main() {

    int n1;
    int n2;
    int contador;

    printf( "N1: ");
    scanf("%d", &n1);

    printf( "N2: ");
    scanf("%d", &n2);

    if (n2>n1) {

        for(int i=n1; i<=n2; i++) {

            int teste;

            teste = i % 2;

            if (teste == 0) {
                contador = contador + 1;
            }
        }

        printf( "Numeros pares entre %d e %d: %d", n1, n2, contador);
    }

    if (n1>n2) {

        for(int i=n2; i<=n1; i++) {

            int teste;

            teste = i % 2;

            if (teste == 0) {
                contador = contador + 1;
            }
        }
        printf( "Numeros pares entre %d e %d: %d", n2, n1, contador);
    }




}

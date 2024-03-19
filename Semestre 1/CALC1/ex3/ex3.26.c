#include <stdio.h>
#include <stdlib.h>

int main() {

    int n1 = 0;
    int maior = 0;
    int menor = 0;
    int qnt = 0;

    while (n1 >= 0) {
        printf( "Entre com um valor: ");
        scanf( "%d", &n1);

        qnt++;


        if (n1 >= 0){

            if (qnt == 1){
            maior = n1;
            menor = n1;
            }

            if (n1 > maior){
            maior = n1;
            }

            if (n1 < menor){
                menor = n1;
            }
        }


    }

    printf( "Menor numero: %d\n", menor);
    printf( "Maior numero: %d", maior);

    return 0;
}

#include <stdio.h>
#include <stdlib.h>

int main() {

    int n;

    printf( "Forneca um numero menor ou igual a zero: ");
    scanf("%d", &n);

    if (n<=0) {

        for(int i=0; i>=n; i--) {
            printf( "%d ", i);
        }

    } else {

        printf( "Valor incorreto (positivo)");
    }
}

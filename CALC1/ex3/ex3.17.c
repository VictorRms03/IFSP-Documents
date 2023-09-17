#include <stdio.h>
#include <stdlib.h>

int main() {

    int n = 0;
    int ant1 = 0;
    int ant2 = 1;
    int termo;

    printf( "Termo desejado: ");
    scanf( "%d", &termo);

    for (int i=0; i<=20; i++) {
        n = ant1 + ant2;

        ant2 = ant1;
        ant1 = n;

        if(i == termo) {
            printf( "Fibonacci de %d e %d", termo, n);
        }
    }
}

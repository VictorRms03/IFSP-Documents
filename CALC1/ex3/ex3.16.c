#include <stdio.h>
#include <stdlib.h>

int main() {

    int n = 0;
    int ant1 = 0;
    int ant2 = 1;

    for (int i=1; i<=20; i++) {
        n = ant1 + ant2;

        printf( "%d ", n);
        ant2 = ant1;
        ant1 = n;
    }
}

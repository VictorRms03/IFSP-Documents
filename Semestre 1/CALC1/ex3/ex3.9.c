#include <stdio.h>
#include <stdlib.h>

int main() {

    int n;

    printf( "Tabuada do Numero: ");
    scanf("%d", &n);

    for(int i=0; i<=10; i++) {

        int result;

        result = i*n;

        printf( "%d x %d = %d\n", n, i, result);
    }
}

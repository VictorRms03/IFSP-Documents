#include <stdio.h>
#include <stdlib.h>

int main() {


    int n1;
    int n2;

    printf( "N1: ");
    scanf("%d", &n1);

    printf( "N2: ");
    scanf("%d", &n2);

    if (n2>n1) {

        for(int i=n1; i<=n2; i++) {
            printf( "%d ", i);
        }

    } else {

        for(int i=n1; i>=n2; i--) {
            printf( "%d ", i);
        }
    }
}

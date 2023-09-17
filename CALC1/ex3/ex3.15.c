#include <stdio.h>
#include <stdlib.h>

int main() {

    int n;
    int p = 1;

    printf("Numero: ");
    scanf("%d", &n);

    if(n > 0){
        for(int i=n; i>=1; i--){
            p = p*i;
        }
        printf("%d! = %d", n, p);
    } else {
        printf( "Nao ha fatorial de numero negativo.");
    }
}

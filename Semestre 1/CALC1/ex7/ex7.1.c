#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int absoluto(int n);


int main(){

    int n0;
    int n1;
    int n2;
    int n3;
    int n4;

    printf( "n0: ");
    scanf("%d", &n0);

    printf( "n1: ");
    scanf( "%d", &n1);

    printf( "n2: ");
    scanf( "%d", &n2);

    printf( "n3: ");
    scanf( "%d", &n3);

    printf( "n4: ");
    scanf( "%d", &n4);

    printf("absoluto(%d) = %d\n", n0, absoluto(n0));
    printf("absoluto(%d) = %d\n", n1, absoluto(n1));
    printf("absoluto(%d) = %d\n", n2, absoluto(n2));
    printf("absoluto(%d) = %d\n", n3, absoluto(n3));
    printf("absoluto(%d) = %d\n", n4, absoluto(n4));

    return 0;
}

int absoluto(int n){
    if (n<0){
        return -n;
    }
    return n;
}

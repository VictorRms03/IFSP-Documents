#include <stdio.h>
#include <stdlib.h>

int main() {

    int n1;
    int n2;
    int n3;
    int n4;
    int n5;

    printf( "N1: ");
    scanf( "%d", &n1);
    printf( "N2: ");
    scanf( "%d", &n2);
    printf( "N3: ");
    scanf( "%d", &n3);
    printf( "N4: ");
    scanf( "%d", &n4);
    printf( "N5: ");
    scanf( "%d", &n5);

    printf( "\n");

    if ((n1 < 0) || (n2 < 0) || (n3 < 0) || (n4 < 0) || (n5 < 0)) {
        printf( "Forneca apenas numeros positivos.");
    } else {
        for (int i=10; i>=1; i--){
            if (n1>=i){
                printf( "%04d  *", i);
            } else {
                printf( "%04d   ", i);
            }
            if (n2>=i){
                printf( "*", i);
            } else {
                printf( " ", i);
            }
            if (n3>=i){
                printf( "*", i);
            } else {
                printf( " ", i);
            }
            if (n4>=i){
                printf( "*", i);
            } else {
                printf( " ", i);
            }
            if (n5>=i){
                printf( "*\n", i);
            } else {
                printf( " \n", i);
            }
        }
    }
}

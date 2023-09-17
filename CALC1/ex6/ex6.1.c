#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(){

    int a;
    int b;
    int c;
    float delta;
    float x1;
    float x2;

    printf( "a: ");
    scanf( "%d", &a);
    printf( "b: ");
    scanf( "%d", &b);
    printf( "c: ");
    scanf( "%d", &c);

    if (a == 0){
        printf( "Nao existe equacao do segundo grau!");
    } else {

        delta = b*b - 4*a*c;
        printf( "Delta: %.2f\n", delta);

        if (delta < 0){
            printf( "S = {}");

        } else if (delta==0){

            x1 = (-b + sqrt(delta)) / (2*a);
            printf( "S = {%.2f}", x1);

        } else {

            x1 = (-b + sqrt(delta)) / (2*a);
            x2 = (-b - sqrt(delta)) / (2*a);

            printf( "S = {%.2f, %.2f}", fmin(x1,x2), fmax(x1,x2));

        }

    }

    return 0;
}

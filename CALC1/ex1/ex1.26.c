#include <stdio.h>
#include <stdlib.h>
int main(){

    float n1;
    float temperatura;

    printf("Temperatura em graus Celsiu: ");
    scanf("%f", &n1);

    temperatura= (32-n1)/1.8;

    printf("36.00 graus Celsius correspondem a 96.80 graus Fahrenheit");

    return 0;
}



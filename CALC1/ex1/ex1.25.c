#include <stdio.h>
#include <stdlib.h>
int main(){

    float n1;
    float temperatura;

    printf("Temperatura em graus Fahrenheit: ");
    scanf("%f", &n1);

    temperatura= (n1-32)/1.8;

    printf("125.00 graus Fahrenheit correspondem a %.2f graus Celsius", temperatura);

    return 0;
}


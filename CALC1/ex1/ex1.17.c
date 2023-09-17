#include <stdio.h>
#include <stdlib.h>
int main(){

    float area;
    float b_maior;
    float b_menor;
    float h;

    printf("Valor da base maior:");
    scanf("%f",&b_maior);
    printf("Valor da base menor:");
    scanf("%f",&b_menor);
    printf("Valor da altura: ");
    scanf("%f",&h);

    area= (b_menor + b_maior)*h/2;

    printf("Area = %.2f",area);

   return 0;
}


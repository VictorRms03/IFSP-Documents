#include <stdio.h>
#include <stdlib.h>
int main(){

    float lado;
    float perimetro;
    float area;

    printf("Valor do lado:");
    scanf("%f",&lado);

    area= lado*lado;
    perimetro= 4*lado;

    printf("Perimetro = %.2f\n", perimetro);

    printf("Area = %.2f\n", area);

    return 0;






}

#include <stdio.h>
#include <stdlib.h>
int main(){

    float area;
    float base;
    float altura;

    printf("Valor da base: ");
    scanf("%f",&base);
    printf("Valor da altura: ");
    scanf("%f",&altura);

    area= (base*altura)/2;

    printf("Area = %.2f\n", area);


    return 0;


}

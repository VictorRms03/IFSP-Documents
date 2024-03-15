#include <stdio.h>
#include <stdlib.h>
int main(){

    float area;
    float d_menor;
    float d_maior;

    printf("Valor da diagonal maior: ");
    scanf("%f",&d_maior);
    printf("Valor da diagonal menor: ");
    scanf("%f",&d_menor);

    area= (d_menor*d_maior)/2;

    printf("Area = %.2f",area);

    return 0;



}

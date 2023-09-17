#include <stdio.h>
#include <stdlib.h>
int main(){

    float diametro;
    float circunferencia;
    float area;
    float raio;
    float Pi=3.141592;

    printf("Valor do raio do circulo: ");
    scanf("%f",&raio);

    diametro=2*raio;
    circunferencia=2*Pi*raio;
    area=Pi*raio*raio;

    printf("Diametro = %.2f\n", diametro);
    printf("Circunferencia = %.2f\n", circunferencia);
    printf("Area = %.2f", area);


    return 0;


}

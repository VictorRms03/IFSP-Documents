#include <stdio.h>
#include <stdlib.h>
#include <math.h>

float areaCirculo(float raio);
float circunferenciaCirculo(float raio);


int main(){

    float raio;

    printf( "Raio: ");
    scanf( "%f", &raio);

    printf( "Area = %.2f\n", areaCirculo(raio));
    printf( "Circunferencia = %.2f", circunferenciaCirculo(raio));

    return 0;
}

float areaCirculo(float raio){
    const double PI = acos(-1);
    return PI * raio * raio;
}

float circunferenciaCirculo(float raio){
    const double PI = acos(-1);
    return 2 * PI * raio;
}

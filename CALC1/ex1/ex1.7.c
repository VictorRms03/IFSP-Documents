#include <stdio.h>
#include <stdlib.h>
int main(){

    int lado;
    int perimetro;
    int area;

    printf("Valor do lado:");
    scanf("%d",&lado);

    area= lado*lado;
    perimetro= 4*lado;

    printf("Perimetro = %d\n", perimetro);

    printf("Area = %d\n", area);

    return 0;
}

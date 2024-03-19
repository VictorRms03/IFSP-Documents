#include <stdio.h>
#include <stdlib.h>
int main(){

    int area;
    int b_maior;
    int b_menor;
    int h;

    printf("Valor da base maior: ");
    scanf("%d",&b_maior);
    printf("Valor da base menor: ");
    scanf("%d",&b_menor);
    printf("Valor da altura: ");
    scanf("%d",&h);

    area= (b_menor + b_maior)*h/2;

    printf("Area = %d",area);

   return 0;




}

#include <stdio.h>
#include <stdlib.h>
int main(){

    int area;
    int d_menor;
    int d_maior;

    printf("Valor da diagonal maior: ");
    scanf("%d",&d_maior);
    printf("Valor da diagonal menor: ");
    scanf("%d",&d_menor);

    area= (d_menor*d_maior)/2;

    printf("Area = %d",area);

    return 0;



}

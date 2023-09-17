#include <stdio.h>
#include <stdlib.h>
int main(){

    int n1;
    int sucessor;
    int antecessor;

    printf("Forneca um numero inteiro: ");
    scanf("%d", &n1);

    sucessor= n1+1;
    antecessor= n1-1;

    printf("Sucessor de 1992: %d\n", sucessor);
    printf("Antecessor de 1992: %d\n", antecessor);

    return 0;



}

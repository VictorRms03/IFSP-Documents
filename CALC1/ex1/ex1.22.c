#include <stdio.h>
#include <stdlib.h>
int main(){

    float n1;
    float desconto;

    printf("Valor do produto: ");
    scanf("%f",&n1);

    desconto = n1 * 0.91;

    printf("Preco de venda com 9%% de desconto: %.2f",desconto);

    return 0;



}

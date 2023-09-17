#include <stdio.h>
#include <stdlib.h>
int main(){

    float n1;
    float n2;
    float n3;
    float salario;

    printf("Valor da hora/aula: ");
    scanf("%f", &n1);
    printf("Quantidade de aulas: ");
    scanf("%f", &n2);
    printf("Porcentagem de desconto do INSS: ");
    scanf("%f", &n3);

    salario= (n1*n2)-(((n1*n2)*n3)/100);

    printf("Salario Liquido: %.2f", salario);


}

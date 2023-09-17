#include <stdio.h>
#include <stdlib.h>

int main(){

    int n1;
    int n2;
    int idade;

    printf("Ano de nascimento:");
    scanf("%d",&n1);
    printf("Ano atual:");
    scanf("%d",&n2);

    idade= n2-n1;

    printf("Idade aproximada: %d anos",idade);

    return 0;

}

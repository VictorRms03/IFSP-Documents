#include <stdio.h>
#include <stdlib.h>

int main(){
    float n;
    float med;
    float soma;
    int i;

    soma = 0;

    printf("Forneca a nota de 10 alunos:\n");

    for (i=1;i<=10;i++){
        printf("Nota %02d: ",i);
        scanf("%f",&n);
        soma = soma + n;
    }

    med = soma / 10;

    printf("A media aritmetica das dez notas e: %.2f",med);

    return 0;
}

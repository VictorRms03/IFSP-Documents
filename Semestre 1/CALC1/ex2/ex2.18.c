#include <stdio.h>
#include <stdlib.h>

int main() {

    float n1;
    float n2;
    char ope;
    float result;

    printf( "N1: ");
    scanf ("%f", &n1);
    printf( "N2: ");
    scanf ("%f", &n2);
    printf ( "Escolha uma operacao de acordo com o menu: \n");
    printf ( "+) Adicao; \n");
    printf ( "-) Subtracao; \n");
    printf ( "*) Multiplicacao; \n");
    printf ( "/) Divisao; \n");
    printf ( "Operacao: ");
    scanf ( " %c", &ope);

    switch (ope) {
        case '+':
            result = n1 + n2;
            printf( "%.2f + %.2f = %.2f", n1, n2, result);
            break;

        case '-':
            result = n1 - n2;
            printf( "%.2f - %.2f = %.2f", n1, n2, result);
            break;

        case '*':
            result = n1 * n2;
            printf( "%.2f * %.2f = %.2f", n1, n2, result);
            break;

        case '/':
            result = n1 / n2;
            printf( "%.2f / %.2f = %.2f", n1, n2, result);
            break;

        default:
            printf( "Opcao invalida!");

    }



}

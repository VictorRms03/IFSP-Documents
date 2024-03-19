#include <stdio.h>
#include <stdlib.h>

int main() {

    int ope;
    float valor;
    float saldo;

        printf( "Saldo inicial: ");
        scanf( "%f", &saldo);

        printf( "Operacoes:\n");
        printf( "    1) Deposito;\n");
        printf( "    2) Saque;\n");
        printf( "    3) Fim.\n");

    while ( ope != 3) {

        printf( "Operacao desejada: ");
        scanf( "%d", &ope);

        if (ope == 1){

            printf( "Valor a depositar: ");
            scanf( "%f", &valor);
            saldo = saldo + valor;

        } else if (ope == 2){

            printf( "Valor a sacar: ");
            scanf( "%f", &valor);
            saldo = saldo - valor;

        } else if (ope == 3){

            if(saldo>0){
                printf( "Saldo final: R$%.2f\n", saldo);
                printf( "Conta preferencial.");

            } else if (saldo == 0){
                printf( "Saldo final: R$%.2f\n", saldo);
                printf( "Sem saldo.");

            } else if (saldo<0){
                saldo = saldo * -1;
                printf( "Saldo final: -R$%.2f\n", saldo);
                printf( "Conta devedora.");
            }

        }
    }

    return 0;
}

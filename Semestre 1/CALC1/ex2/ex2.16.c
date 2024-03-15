#include <stdio.h>
#include <stdlib.h>

int main () {


        int numero;


        printf("Entre com um numero entre 1 e 3999: ");
        scanf("%d", &numero);


       if (numero < 1 || numero > 3999){
            printf("Numero incorreto!");
        }else {
            printf("%d = ", numero);
        }

        char *romanos[] = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int arabicos[] = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        // acha a quantidade de elementos no array
        int indice = (sizeof(arabicos) / sizeof(arabicos[0])) - 1;
        while (numero >= 1 && numero <= 3999) {
            if (numero >= arabicos[indice]) {
                printf("%s", romanos[indice]);
                numero -= arabicos[indice];
            } else {
                indice--;
            }
        }

}

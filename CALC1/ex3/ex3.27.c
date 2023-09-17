#include <stdio.h>
#include <stdlib.h>

int main() {

    float peso = 0;
    float maior60 = 0;
    float maior = 0;
    float peso60 = 0;
    float media = 0;
    int pessoa = 1;

    while ( peso >= 0) {
        printf( "Entre com o peso da pessoa %02d: ", pessoa++);
        scanf( "%f", &peso);

        if ((peso >= 0) && (peso >= 60)){
            maior60++;
            peso60 = peso60 + peso;
            media = peso60 / maior60;
        }

        if (peso >= maior){
            maior = peso;
        }
    }

    printf( "Media dos pesos acima de 60kg: %.2f\n", media);
    printf( "A pessoa mais pesada possui %.2fkg", maior);
    return 0;
}

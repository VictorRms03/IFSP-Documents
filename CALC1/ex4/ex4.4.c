#include <stdio.h>
#include <stdlib.h>

int main() {

    int array[5];
    int buscar;

    for(int i=0; i<5; i++){
        printf("array[%d]: ", i);
        scanf( "%d", &array[i]);
    }

    printf( "Buscar por: ");
    scanf( "%d", &buscar);

    for(int i=0; i<5; i++){
        if (array[i] == buscar){
            printf( "Indice %d: ACHEI\n", i);
        } else {
            printf( "Indice %d: NAO ACHEI\n", i);
        }
    }
    return 0;
}

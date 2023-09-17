#include <stdio.h>
#include <stdlib.h>

int main() {

    int array[5];
    int arrayMult[5];
    int mult;

    for (int i=0; i<5; i++){
        printf( "array[%d]: ", i);
        scanf( "%d", &array[i]);
    }

    printf( "Multiplicar por: ");
    scanf( "%d", &mult);

    for (int i=0; i<5; i++){
        arrayMult[i] = array[i] * mult;

        printf( "arrayMult[%d] = %d\n", i, arrayMult[i]);
    }
}

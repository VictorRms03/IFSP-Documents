#include <stdio.h>
#include <stdlib.h>

int main() {

    for(int i=45; i<=60; i++) {

        float teste;

        teste = i%4;

        if (teste == 0) {

            printf( "%d: divisivel\n", i);

        } else {

            printf( "%d: indivisivel\n", i);
        }
    }
}

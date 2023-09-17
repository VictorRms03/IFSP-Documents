#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int vermelho;
    int verde;
    int azul;
} Cor;

Cor novaCor( int vermelho, int verde, int azul );
void imprimirCor( const Cor *c );

int main() {

    int vermelho;
    int verde;
    int azul;
    Cor cor;

    printf( "Vermelho: ");
    scanf( "%d", &vermelho);

    printf( "Verde: ");
    scanf( "%d", &verde);

    printf( "Azul: ");
    scanf( "%d", &azul);

    cor = novaCor(vermelho, verde, azul);

    printf( "Cor: ");
    imprimirCor(&cor);

    return 0;
}

Cor novaCor( int vermelho, int verde, int azul ){
    Cor cor;

    if (vermelho < 0){
        cor.vermelho = 0;
    } else if (vermelho > 255) {
        cor.vermelho = 255;
    } else{
        cor.vermelho = vermelho;
    }

    if (verde < 0){
        cor.verde = 0;
    } else if (verde > 255) {
        cor.verde = 255;
    } else{
        cor.verde = verde;
    }

    if (azul < 0){
        cor.azul = 0;
    } else if (azul > 255) {
        cor.azul = 255;
    } else{
        cor.azul = azul;
    }

    return cor;
}

void imprimirCor( const Cor *c ){
    printf( "rgb( %d, %d, %d )", c->vermelho, c->verde, c->azul);
}

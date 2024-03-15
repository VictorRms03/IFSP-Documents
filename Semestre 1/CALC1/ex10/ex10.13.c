#include <stdio.h>
#include <stdlib.h>
#include <math.h>

typedef struct{
    int x;
    int y;
} Ponto;

typedef struct{
    Ponto superiorEsquerdo;
    Ponto inferiorDireito;
} Retangulo;

Retangulo novoRetangulo( const Ponto *sEsq, const Ponto *iDir);
void mover( Retangulo *r, int x, int y);
void imprimirRetangulo( const Retangulo *r);

int main() {

    Ponto supEsq;
    Ponto infDir;
    Retangulo retangulo;
    Ponto centro;
    int movX;
    int movY;

    printf( "Ponto superior esquerdo\n");
    printf( "    x: ");
    scanf( "%d", &supEsq.x);
    printf( "    y: ");
    scanf( "%d", &supEsq.y);
    printf( "Ponto inferior direito\n");
    printf( "    x: ");
    scanf( "%d", &infDir.x);
    printf( "    y: ");
    scanf( "%d", &infDir.y);

    printf( "Mover em x: ");
    scanf( "%d", &movX);
    printf( "Mover em y: ");
    scanf( "%d", &movY);


    retangulo = novoRetangulo( &supEsq, &infDir);

    printf( "Retangulo original:\n");
    imprimirRetangulo( &retangulo);
    printf( "\n");

    mover( &retangulo, movX, movY);
    printf( "Retangulo movido:\n");
    imprimirRetangulo( &retangulo);

    return 0;
}

Retangulo novoRetangulo( const Ponto *sEsq, const Ponto *iDir){
    Retangulo retangulo;

    retangulo.inferiorDireito = *iDir;
    retangulo.superiorEsquerdo = *sEsq;

    return retangulo;
}

void mover( Retangulo *r, int x, int y){
    r->superiorEsquerdo.x += x;
    r->inferiorDireito.x += x;
    r->superiorEsquerdo.y += y;
    r->inferiorDireito.y += y;
}

void imprimirRetangulo( const Retangulo *r){
    printf( "(%+02d, %+02d) =====|\n", r->superiorEsquerdo.x, r->superiorEsquerdo.y);
    printf( "|               |\n");
    printf( "|               |\n");
    printf( "|===== (%+02d, %+02d)", r->inferiorDireito.x, r->inferiorDireito.y);
}

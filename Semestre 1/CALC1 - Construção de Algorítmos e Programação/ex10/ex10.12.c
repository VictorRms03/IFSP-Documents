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
Ponto obterCentro (const Retangulo *r);
void imprimirRetangulo( const Retangulo *r);

int main() {

    Ponto supEsq;
    Ponto infDir;
    Retangulo retangulo;
    Ponto centro;

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

    retangulo = novoRetangulo( &supEsq, &infDir);

    centro = obterCentro (&retangulo);

    imprimirRetangulo( &retangulo);

    printf( "Centro: (%+02d, %+02d)", centro.x, centro.y);

    return 0;
}

Retangulo novoRetangulo( const Ponto *sEsq, const Ponto *iDir){
    Retangulo retangulo;

    retangulo.inferiorDireito = *iDir;
    retangulo.superiorEsquerdo = *sEsq;

    return retangulo;
}

Ponto obterCentro (const Retangulo *r){
    Ponto centro;

    centro.x = (r->superiorEsquerdo.x + r->inferiorDireito.x) / 2;
    centro.y = (r->superiorEsquerdo.y + r->inferiorDireito.y) / 2;

    return centro;
}

void imprimirRetangulo( const Retangulo *r){
    printf( "(%+02d, %+02d) =====|\n", r->superiorEsquerdo.x, r->superiorEsquerdo.y);
    printf( "|               |\n");
    printf( "|               |\n");
    printf( "|===== (%+02d, %+02d)\n", r->inferiorDireito.x, r->inferiorDireito.y);
}

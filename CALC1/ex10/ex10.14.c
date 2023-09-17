#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <stdbool.h>

typedef struct{
    int x;
    int y;
} Ponto;

typedef struct{
    Ponto superiorEsquerdo;
    Ponto inferiorDireito;
} Retangulo;

Retangulo novoRetangulo( const Ponto *sEsq, const Ponto *iDir);
bool contem( const Retangulo *r, const Ponto *p);

int main() {

    Ponto supEsq;
    Ponto infDir;
    Retangulo retangulo;
    Ponto contemP[5];

    printf( "Retangulo\n");
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

    printf( "Pontos\n");

    for (int i=0; i<5; i++){
        printf( "  Ponto %d\n", i+1);
        printf( "    x: ");
        scanf( "%d", &contemP[i].x);
        printf( "    y: ");
        scanf( "%d", &contemP[i].y);
    }

    retangulo = novoRetangulo( &supEsq, &infDir);

    for (int i=0; i<5; i++){
        printf( "(%+02d, %+02d): ", contemP[i].x, contemP[i].y);
        if (contem( &retangulo, &contemP[i])){
            printf( "contido!");
        } else {
            printf( "nao contido!");
        }

        if (i != 4){
            printf( "\n");
        }
    }

    return 0;
}

Retangulo novoRetangulo( const Ponto *sEsq, const Ponto *iDir){
    Retangulo retangulo;

    retangulo.inferiorDireito = *iDir;
    retangulo.superiorEsquerdo = *sEsq;

    return retangulo;
}

bool contem( const Retangulo *r, const Ponto *p){
    if (((p->x <= r->inferiorDireito.x) && (p->x >= r->superiorEsquerdo.x)) && ((p->y >= r->inferiorDireito.y) && (p->y <= r->superiorEsquerdo.y))){
        return true;
    } else {
        return false;
    }
}

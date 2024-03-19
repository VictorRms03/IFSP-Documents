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
bool intercepta( const Retangulo *r1, const Retangulo *r2);

int main() {

    Ponto supEsq;
    Ponto infDir;
    Retangulo retangulo1;
    Retangulo retangulo2;

    printf( "Retangulo 1\n");
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

    retangulo1 = novoRetangulo( &supEsq, &infDir);

    printf( "Retangulo 2\n");
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

    retangulo2 = novoRetangulo( &supEsq, &infDir);

    if (intercepta( &retangulo1, &retangulo2)){
        printf( "Os retangulos se interceptam!");
    } else {
        printf( "Os retangulos nao se interceptam!");
    }

    return 0;
}

Retangulo novoRetangulo( const Ponto *sEsq, const Ponto *iDir){
    Retangulo retangulo;

    retangulo.inferiorDireito = *iDir;
    retangulo.superiorEsquerdo = *sEsq;

    return retangulo;
}

bool intercepta( const Retangulo *r1, const Retangulo *r2){
    if ((r1->superiorEsquerdo.x <= r2->inferiorDireito.x) && (r1->inferiorDireito.x >= r2->superiorEsquerdo.x)){
        if ((r1->superiorEsquerdo.y >= r2->inferiorDireito.y) && r1->inferiorDireito.y <= r2->superiorEsquerdo.y){
            return true;
        }
        else{
            return false;
        }
    }
    else{
        return false;
    }
}

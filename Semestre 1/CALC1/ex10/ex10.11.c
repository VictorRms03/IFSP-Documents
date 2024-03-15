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
int calcularArea( const Retangulo *r);
void imprimirRetangulo( const Retangulo *r);

int main() {

    Ponto supEsq;
    Ponto infDir;
    Retangulo retangulo;
    int area;

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

    area = calcularArea( &retangulo);

    imprimirRetangulo( &retangulo);

    printf( "Area: %d", area);


    return 0;
}

Retangulo novoRetangulo( const Ponto *sEsq, const Ponto *iDir){
    Retangulo retangulo;

    retangulo.inferiorDireito = *iDir;
    retangulo.superiorEsquerdo = *sEsq;

    return retangulo;
}

int calcularArea( const Retangulo *r){
    int base;
    int altura;
    int area;

    altura = r->superiorEsquerdo.y - r->inferiorDireito.y;
    base = r->superiorEsquerdo.x - r->inferiorDireito.x;

    area = base * altura;

    if (area < 0){
        area *= -1;
    }

    return area;

}

void imprimirRetangulo( const Retangulo *r){
    printf( "(%+02d, %+02d) =====|\n", r->superiorEsquerdo.x, r->superiorEsquerdo.y);
    printf( "|               |\n");
    printf( "|               |\n");
    printf( "|===== (%+02d, %+02d)\n", r->inferiorDireito.x, r->inferiorDireito.y);
}

#include <stdio.h>
#include <stdlib.h>

typedef struct{
    int vermelho;
    int verde;
    int azul;
} Cor;

Cor novaCor(int vermelho, int verde, int azul);
void imprimirCor(const Cor *c);
Cor clarear(const Cor *c);

int main(){

    int vermelho;
    int verde;
    int azul;
    Cor cor;
    Cor corClara;

    printf("Vermelho: ");
    scanf("%d", &vermelho);
    printf("Verde: ");
    scanf("%d", &verde);
    printf("Azul: ");
    scanf("%d", &azul);

    cor = novaCor(vermelho,verde,azul);

    printf("Cor base: ");
    imprimirCor(&cor);
    printf("\n");

    corClara = clarear(&cor);

    printf("Cor clareada: ");
    imprimirCor(&corClara);

    return 0;
}

Cor novaCor(int vermelho, int verde, int azul){

    Cor cor;

    if (vermelho>=0 && vermelho<=255){
        cor.vermelho = vermelho;
    }
    else if (vermelho<0){
        cor.vermelho = 0;
    }
    else{
        cor.vermelho = 255;
    }

    if (verde>=0 && verde<=255){
        cor.verde = verde;
    }
    else if (verde<0){
        cor.verde = 0;
    }
    else{
        cor.verde = 255;
    }

    if (azul>=0 && azul<=255){
        cor.azul = azul;
    }
    else if (azul<0){
        cor.azul = 0;
    }
    else{
        cor.azul = 255;
    }

    return cor;

}

void imprimirCor(const Cor *c){

    printf("rgb( %d, %d, %d )",c->vermelho,c->verde,c->azul);

}

Cor clarear(const Cor *c){

    Cor corClareada;

    if (c->vermelho == 0 && c->verde == 0 && c->azul == 0){
        corClareada.vermelho = 3;
        corClareada.verde = 3;
        corClareada.azul = 3;

        return corClareada;
    }

    if (c->vermelho > 0 && c->vermelho < 3){
        corClareada.vermelho = 3 / 0.7;
    }
    else{
        corClareada.vermelho = c->vermelho / 0.7;
    }

    if (c->verde > 0 && c->verde < 3){
        corClareada.verde = 3 / 0.7;
    }
    else{
        corClareada.verde = c->verde / 0.7;
    }

    if (c->azul > 0 && c->azul < 3){
        corClareada.azul = 3 / 0.7;
    }
    else{
        corClareada.azul = c->azul / 0.7;
    }

    if (corClareada.vermelho > 255){
        corClareada.vermelho = 255;
    }

    if (corClareada.verde > 255){
        corClareada.verde = 255;
    }

    if (corClareada.azul > 255){
        corClareada.azul = 255;
    }

    return corClareada;
}

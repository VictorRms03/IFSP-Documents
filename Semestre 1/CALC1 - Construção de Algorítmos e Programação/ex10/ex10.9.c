#include <stdio.h>
#include <stdlib.h>

typedef struct{
    int vermelho;
    int verde;
    int azul;
} Cor;

Cor novaCor(int vermelho, int verde, int azul);
void imprimirCor(const Cor *c);
Cor escurecer(const Cor *c);

int main(){

    int vermelho;
    int verde;
    int azul;
    Cor cor;
    Cor corEscura;

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

    corEscura = escurecer(&cor);

    printf("Cor escurecida: ");
    imprimirCor(&corEscura);

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

Cor escurecer(const Cor *c){

    Cor corEscurecida;

    corEscurecida.vermelho = c->vermelho * 0.7;
    corEscurecida.verde = c->verde * 0.7;
    corEscurecida.azul = c->azul * 0.7;

    return corEscurecida;
}

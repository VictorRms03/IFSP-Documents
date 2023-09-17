#include <stdio.h>
#include <stdlib.h>

typedef struct{
    int vermelho;
    int verde;
    int azul;
} Cor;

Cor novaCor(int vermelho, int verde, int azul);
void imprimirCor(const Cor *c);
void setVermelho (Cor *c, int vermelho);
void setVerde (Cor *c, int verde);
void setAzul (Cor *c, int azul);

int main(){

    int vermelho;
    int verde;
    int azul;
    Cor cor;

    printf("Vermelho: ");
    scanf("%d", &vermelho);
    printf("Verde: ");
    scanf("%d", &verde);
    printf("Azul: ");
    scanf("%d", &azul);

    cor = novaCor(vermelho,verde,azul);

    printf("Novo vermelho: ");
    scanf("%d", &vermelho);
    printf("Novo verde: ");
    scanf("%d", &verde);
    printf("Novo azul: ");
    scanf("%d", &azul);

    printf("Cor: ");
    imprimirCor(&cor);
    printf("\nCor alterada: ");

    setVermelho(&cor, vermelho);
    setVerde(&cor, verde);
    setAzul(&cor, azul);

    imprimirCor(&cor);

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

void setVermelho (Cor *c, int vermelho){

    if (vermelho>=0 && vermelho<=255){
        c->vermelho = vermelho;
    }
    else if (vermelho<0){
        c->vermelho = 0;
    }
    else{
        c->vermelho = 255;
    }
}

void setVerde (Cor *c, int verde){

    if (verde>=0 && verde<=255){
        c->verde = verde;
    }
    else if (verde<0){
        c->verde = 0;
    }
    else{
        c->verde = 255;
    }
}

void setAzul (Cor *c, int azul){

    if (azul>=0 && azul<=255){
        c->azul = azul;
    }
    else if (azul<0){
        c->azul = 0;
    }
    else{
        c->azul = 255;
    }
}

#include <stdio.h>
#include <stdlib.h>

typedef struct{
    int vermelho;
    int verde;
    int azul;
} Cor;

Cor novaCor(int vermelho, int verde, int azul);
void imprimirCor(const Cor *c);
int getVermelho (const Cor *c);
int getVerde (const Cor *c);
int getAzul (const Cor *c);

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

    printf("Cor: ");
    imprimirCor(&cor);
    printf("\n");
    printf("getVermelho(): %d\n", getVermelho(&cor));
    printf("getVerde(): %d\n", getVerde(&cor));
    printf("getAzul(): %d\n", getAzul(&cor));

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

int getVermelho (const Cor *c){

    int vermelho = c->vermelho;

    return vermelho;

}

int getVerde (const Cor *c){

    int verde = c->verde;

    return verde;

}

int getAzul (const Cor *c){

    int azul = c->azul;

    return azul;

}

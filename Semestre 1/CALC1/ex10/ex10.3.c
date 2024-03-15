#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int hora;
    int minuto;
    int segundo;
} Hora;

Hora gerarHora( int quantidadeSegundos );
void imprimirHora( const Hora *hora );

int main() {

    int segundos;
    Hora hora;

    printf( "Segundos: ");
    scanf("%d", &segundos);

    hora = gerarHora(segundos);

    printf( "Hora correspondente: ");
    imprimirHora(&hora);

    return 0;
}

Hora gerarHora( int quantidadeSegundos ){
    int hora;
    int minuto;
    int segundo;
    Hora retorno;

    hora = quantidadeSegundos / 3600;
    quantidadeSegundos = quantidadeSegundos % 3600;
    minuto = quantidadeSegundos / 60;
    segundo = quantidadeSegundos % 60;

    retorno.hora = hora;
    retorno.minuto = minuto;
    retorno.segundo = segundo;

    return retorno;
}


void imprimirHora( const Hora *hora ){
    printf( "%02d:%02d:%02d", hora->hora, hora->minuto, hora->segundo);
}

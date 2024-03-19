#include <stdio.h>
#include <stdlib.h>

void decompoeTempo(int totalSegundos,
                   int *horas,
                   int *minutos,
                   int *segundos);

int main() {
    int total;
    int h;
    int m;
    int s;

    printf( "Total de segundos: ");
    scanf( "%d", &total);

    decompoeTempo(total, &h, &m, &s);
    printf( "%d segundo(s) corresponde(m) a:\n", total);
    printf( "    %d hora(s)\n", h);
    printf( "    %d minuto(s)\n", m);
    printf( "    %d segundo(s)", s);

    return 0;
}

void decompoeTempo(int totalSegundos, int *horas, int *minutos, int *segundos){
    *horas = totalSegundos / 3600;
    totalSegundos = totalSegundos % 3600;
    *minutos = totalSegundos / 60;
    *segundos = totalSegundos % 60;
}

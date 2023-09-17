#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int dia;
    int mes;
    int ano;
} Data;

int diaDoAno(const Data *data);
void imprimirData(const Data *data);

int main() {

    Data data;

    printf("dia: ");
    scanf("%d", &data.dia);

    printf("mes: ");
    scanf("%d", &data.mes);

    printf("ano: ");
    scanf("%d", &data.ano);

    printf( "O dia do ano da data ");
    imprimirData(&data);
    printf( " eh %d.", diaDoAno(&data));

    return 0;
}

int diaDoAno(const Data *data){
    int mes[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int diaDoAno = 0;
    int ano4;
    int ano100;
    int ano400;

    ano4 = data->ano % 4;
    ano100 = data->ano % 100;
    ano400 = data->ano % 400;

    if (((ano4 == 0) || (ano400 == 0)) && (ano100 != 0)){
        mes[1] = 29;
    }

    for (int i=1; i < data->mes; i++){
        diaDoAno = diaDoAno + mes[i-1];
    }

    return diaDoAno + data->dia;

}

void imprimirData (const Data *data){
    printf("%02d/%02d/%04d", data->dia, data->mes, data->ano);
}

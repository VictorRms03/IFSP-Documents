#include <stdio.h>
#include <stdlib.h>

void lerArray(int *array, int tamArray);
void imprimirArray (int *array, int tamArray, char *c);
void maxMin1(int *array, int tamArray, int *max, int *min);
void maxMin2(int *array, int tamArray, int *max, int *min);
void maxMin3(int *array, int tamArray, int *max, int *min);

int ope1 = 0;
int ope2 = 0;
int ope3 = 0;

int main(){

    printf( "Aula 03 - Exercicio 02 - Maior e Menor Elemento no Array: \n");

    int *array;
    int tamArray;
    int max;
    int min;

    printf( "\nEntre com o tamanho do Array de Inteiros: ");
    scanf( " %d", &tamArray);

    array = (int*) malloc(tamArray * sizeof(int));


    lerArray(array, tamArray);

    maxMin1(array, tamArray, &max, &min);
    printf( "\nmaxMin1() - Maior Elemento: %d - Menor Elemento: %d (Num. de Operacoes: %d)", max, min, ope1);

    maxMin2(array, tamArray, &max, &min);
    printf( "\nmaxMin2() - Maior Elemento: %d - Menor Elemento: %d (Num. de Operacoes: %d)", max, min, ope2);

    maxMin3(array, tamArray, &max, &min);
    printf( "\nmaxMin3() - Maior Elemento: %d - Menor Elemento: %d (Num. de Operacoes: %d)", max, min, ope3);

    return 0;
}

void lerArray(int *array, int tamArray){

    for(int i=0; i<tamArray; i++){
        printf( "Digite o valor para posicao %d do Array: ", i+1);
        scanf( " %d", &array[i]);
    }
}

void maxMin1(int *array, int tamArray, int *max, int *min){

    *max = array[0];
    *min = array[0];

    for(int i=1; i<tamArray; i++){
        ope1+=2;

        ope1++;
        if(array[i] > *max){
            ope1++;
            *max = array[i];
        }

        ope1++;
        if (array[i] < *min){
            ope1++;
            *min = array[i];
        }
    }
}

void maxMin2(int *array, int tamArray, int *max, int *min){

    *max = array[0];
    *min = array[0];

    for(int i=1; i<tamArray; i++){
        ope1+=2;

        ope2++;
        if(array[i] > *max){
            ope2++;
            *max = array[i];
        } else if (array[i] < *min){
            ope2++;
            *min = array[i];
        }
    }
}

void maxMin3(int *array, int tamArray, int *max, int *min){

    ope3++;
    if(tamArray%2 != 0){
        ope3++;
        array[tamArray] = array[tamArray-1];
        tamArray++;
    }

    *max = array[0];
    *min = array[1];

    ope3++;
    if(array[0] < array[1]){
        ope3++;
        *max = array[1];
        *min = array[0];
    }

    for(int i=2; i<tamArray-1; i+=2){
        ope3+=2;

        ope3++;
        if(array[i] > array[i+1]){
            ope3++;
            if(array[i] > *max){
                ope3++;
                *max = array[i];
            }
            ope3++;
            if(array[i+1] < *min){
                ope3++;
                *min = array[i+1];
            }
        } else {
            ope3++;
            if(array[i] < *min){
                ope3++;
                *min = array[i];
            }
            if(array[i+1] > *max){
                ope3++;
                *max = array[i+1];
            }
        }
    }

}


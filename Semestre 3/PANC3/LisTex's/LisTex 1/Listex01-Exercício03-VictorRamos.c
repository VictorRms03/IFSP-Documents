#include <stdlib.h>
#include <stdio.h>

//Protótipos de funções
void gerarArray(int tamArray, int array[]);
void copiarArray(int tamArray, int *originalArray, int *copiaArray);
void ordenaArray(int tamArray, int *array);
void printaArray(int tamArray, int *array, char *c);

//Variaveis globais
int ope = 0;

int main(){

    printf( "Aula 02 - Exercicio 03 - Ordenacao:\n\n");

    int tamArray;

    printf( "Entre com o tamanho do Array de Inteiros: ");
    scanf( " %d", &tamArray);

    int originalArray[tamArray];
    int copiaArray[tamArray];

    gerarArray(tamArray, originalArray);

    copiarArray(tamArray, originalArray, copiaArray);

    printf( "\nOrdenacao");
    ordenaArray(tamArray, copiaArray);

    printf( "\nArray Ord.   []");
    printaArray(tamArray, copiaArray, "");

    printf( "\nNumero de Operacoes para Ordenacao: %d", ope);

    return 0;
}

void gerarArray(int tamArray, int *array){
    int n;
    srand(time (NULL));
    for(int i=0; i<tamArray; i++){
        n = rand() % 100;
        array[i] = n;
    }
}

void copiarArray(int tamArray, int *originalArray, int *copiaArray){

    for(int i=0; i<tamArray; i++){
        copiaArray[i] = originalArray[i];
    }
}

void ordenaArray(int tamArray, int *array){
    int j;
    int k;
    for(int i=1; i<tamArray; i++){
        ope++;
        k=array[i];
        j = i - 1;
        while((k < array[j]) && (j >= 0)){
            ope++;
            array[j+1] = array[j];
            j = j-1;
        }
        array[j+1] = k;
        printaArray(tamArray, array, "\nArray Desord.[]");
        printf( " - %d", k);
    }
}

void printaArray(int tamArray, int *array, char *c){

    printf( "%s = ", c);
    for(int i=0; i<tamArray; i++){
        printf( "%d ", array[i]);
    }
}





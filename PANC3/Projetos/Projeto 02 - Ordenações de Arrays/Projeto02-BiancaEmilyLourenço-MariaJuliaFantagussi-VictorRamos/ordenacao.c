#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "ordenacao.h"

/* Função: geraArrayAleatorio() - Gerar numeros inteiros aleatorios para um array de tamanho n */
void geraArrayAleatorio(int arrayOriginal[], int n) {
    int valor;

    srand(time(NULL));
    for(int i=0; i< n; i++) {
        valor = rand() % 100;
        arrayOriginal[i] = valor;
    }
}

/* Função: imprimeArray() - Imprime os n números inteiros de um array */
void imprimeArray(int arrayA[], int n) {
    printf("\n ");
    for(int i=0; i<n; i++) {
        printf(" %d", arrayA[i]);
    }
}

/* Função: copiaValoresArray() - Copia os valores do Array Original para um Array Temporario,
                                 com o objetivo de nao perder os valores originais na ordenacao */
void copiaValoresArray(int arrayOriginal[], int arrayA[], int n) {
    for(int i=0; i<n; i++) {
        arrayA[i] = arrayOriginal[i];
    }
}

/*Função: insertionSort() - Método de ordenação de arrays de valores inteiros com base no
                            Algoritmo do Insertion Sort (Ordenacao Direta)  */
void insertionSort(int arrayA[], int n) {
    int i, j, chave;
    for (i=1; i<n; i++) {
        numComparacoesIS++;

        chave = arrayA[i];
        j = i - 1;
        while((chave < arrayA[j]) && (j>=0)) {
            numComparacoesIS++;

            arrayA[j+1] = arrayA[j];
            numTrocasIS++;
            j = j-1;
        }
        arrayA[j+1] = chave;
        numTrocasIS++;
    }
}

/*Função: OrdenaBinaria() - Insere os núumeros em ordem no array por pesquisa binaria. */
void OrdenaBinaria(int arrayA[], int n){
    int i, j;
    int m, x;
    int L, R;

    for(i=1; i<n; i++){
        numComparacoesOB++;
        x = arrayA[i];

        L = 0;
        R = i;

        while (L < R){
            numComparacoesOB++;
            m = (L + R)/2;
            if (x >= arrayA[m]){
                L = m+1;
            } else {
                R = m;
            }
        }


        for(j=i; j>L; j=j-1){
            numComparacoesOB++;
            numTrocasOB++;
            arrayA[j] = arrayA[j-1];
        }

        numTrocasOB++;
        arrayA[R] = x;
    }
}

/*Função: OrdenaShellSort() - Método de ordenação de arrays de valores inteiros com base no
                            Algoritmo do Shell Sort  */
void OrdenaShellSort(int arrayA[], int Inc, int SegCorrente){

    int i, j, x, k;

    for(i=(SegCorrente+Inc); i<n; i+=Inc){
        k = SegCorrente;
        j = i - Inc;
        x = arrayA[i];
        numComparacoesSS++;

        while((j>=SegCorrente)&&(k==SegCorrente)){
            numComparacoesSS++;
            numComparacoesSS++;

            if(x < arrayA[j]){
                numComparacoesSS++;
                numTrocasSS++;
                arrayA[j+Inc] = arrayA[j];
                j = j-Inc;
            } else {
                k=j+Inc;
            }
        }

        numTrocasSS++;
        arrayA[k] = x;
    }
}

/*Função: OrdenaBubbleSort() - Método de ordenação de arrays de valores inteiros com base no
                            Algoritmo do Bubble Sort  */
void OrdenaBubbleSort(int arrayA[], int n){

int aux, i, j;

    for(j=n-1; j>=1; j--){
            numComparacoesBS++;

        for(i=0; i<j; i++){
                numComparacoesBS++;

            if(arrayA[i]>arrayA[i+1]){
                numTrocasBS++;
                aux = arrayA[i];
                arrayA[i] = arrayA[i+1];
                arrayA[i+1] = aux;
            }
        }
    }
}

/*Função: OrdenaShakeSort() - Método de ordenação de arrays de valores inteiros com base no
                            Algoritmo do Shake Sort  */
void OrdenaShakeSort(int Vet[],int Max) {

    int L = 0, R = Max-1, k = Max-1;
    int j, x;
    do{
        for(j=L; j<R; j++) {
            numComparacoesSK++;
            if(Vet[j] > Vet[j+1]) {
                numTrocasSK++;
                x = Vet[j];
                Vet[j] = Vet[j+1];
                Vet[j+1] = x;
                k = j;
            }
        }

        R = k;

        for(j=R; j>L; j--) {
            numComparacoesSK++;

            if(Vet[j-1] > Vet[j]) {
                numTrocasSK++;
                x = Vet[j-1];
                Vet[j-1] = Vet[j];
                Vet[j] = x;
                k = j;
            }
        }

        L = k;

    }while(L<R);
    numComparacoesSK++;
}

/*Função: OrdenaCombSort() - Método de ordenação de arrays de valores inteiros com base no
                            Algoritmo do Comb Sort  */
void OrdenaCombSort(int arrayA[], int n){

    double h = n;
    int x, i, Troca;
    do{
        h=h/1.3;

        if((h == 9)||(h == 10)){
            h=11;
        }

        Troca=0;

        for(i=0; i<(n-h); i++){
            numComparacoesCS++;
            if(arrayA[(int)i] > arrayA[(int)(i+h)]){
                numTrocasCS++;
                x=arrayA[i];
                arrayA[(int)i]=arrayA[(int)(i+h)];
                arrayA[(int)(i+h)]=x;
                Troca=1;
            }
        }
    }while((Troca == 1)||(h >= 1));
}

/*Função: OrdenaQuickSortRecursivo() - Método de ordenação de arrays de valores inteiros com base no
                            Algoritmo do Quick Sort  */
void OrdenaQuickSortRecursivo(int arrayA[], int inicio, int fim){
    int pivo, aux, i, j, meio;
    i = inicio;
    j = fim;
    meio = (int) ((i + j) / 2);
    pivo = arrayA[meio];
    do{
        numComparacoesQS++;

        while (arrayA[i] < pivo){
            i = i + 1;
        }
            numComparacoesQS++;

        while (arrayA[j] > pivo){
            j = j - 1;
        }
            numComparacoesQS++;

            if(i <= j){
                numTrocasQS++;
                aux = arrayA[i];
                arrayA[i] = arrayA[j];
                arrayA[j] = aux;
                i = i + 1;
                j = j - 1;

            }
        } while(j > i);

    numComparacoesQS++;
    if(inicio < j){
        OrdenaQuickSortRecursivo(arrayA, inicio, j);
    }
    numComparacoesQS++;
    if(i < fim){
        OrdenaQuickSortRecursivo(arrayA, i, fim);
    }
}

/*Função: OrdenaSelectSort() - Método de ordenação de arrays de valores inteiros com base no
                            Algoritmo do Select Sort  */
void OrdenaSelectSort(int arrayA[]){
    int i, j, k, x, Comp;

    for(i=0; i<n-1; i++){
        Comp=0;
        k=i;
        x = arrayA[i];
        for(j=i+1; j< n; j++){
            numComparacoesSL++;
            if(arrayA[j] < x){
                k = j;
                x = arrayA[k];
                Comp = 1;
            }
        }
        numComparacoesSL++;
        if(Comp == 1){
            numTrocasSL++;
            arrayA[k] = arrayA[i];
            arrayA[i] = x;
        }
    }
}

/*Função: heapSort() - Método de ordenação de arrays de valores inteiros com base no
                            Algoritmo do Heap Sort  */
void heapSort(int arrayA[], int n){

    for(int i=n/2-1; i>=0; i--){
        numComparacoesHS++;
        Heap(arrayA, n, i);
    }

    for(int i=n-1; i>=0; i--){
        numComparacoesHS++;

        numTrocasHS++;
        int temp = arrayA[0];
        arrayA[0] = arrayA[i];
        arrayA[i] = temp;

        Heap(arrayA, i, 0);
    }
}

/*Função: Heap() - Método de apoio para o método de Ordenação heapSort()  */
void Heap(int arrayA[], int n, int i){

    int largest = i;

    int left = 2 * i + 1;

    int right = 2 * i + 2;

    if (left < n && arrayA[left] > arrayA[largest]){
        numComparacoesHS++;
        largest = left;
    }

    if (right < n && arrayA[right] > arrayA[largest]){
        numComparacoesHS++;
        largest = right;
    }

    if (largest != i) {
        numComparacoesHS++;
        numTrocasHS++;
        int temp = arrayA[i];
        arrayA[i] = arrayA[largest];
        arrayA[largest] = temp;

        Heap(arrayA, n, largest);
    }

}

/*Função: MergeSortRecursivo() - Método de ordenção de arrays de valores inteiros com base no
                        Algoritmo do MergeSort/Intercala */
void MergeSortRecursivo(int arrayA[], int n, int inicio, int fim)
{
    int meio;
    if (inicio < fim ) {
        numComparacoesMS++;
        meio = (inicio + fim) / 2;
        MergeSortRecursivo(arrayA, n, inicio, meio);
        MergeSortRecursivo(arrayA, n, meio + 1, fim);
        IntercalaSemSentinela(arrayA, n, inicio, meio, fim);
    }
}

/*Função: IntercalaSemSentinela() - Método de Auxiliar ao Algoritmo do MergeSort/Intercala
                        que realiza a etapa da combinação */
void IntercalaSemSentinela(int arrayA[], int n, int inicio, int meio, int fim) {
    int i, j;
    int Aux[n];


    for(i=inicio; i<=meio; i++) {
        Aux[i] = arrayA[i];
    }

    for(j=meio+1; j<=fim; j++) {
        Aux[fim+meio+1-j] = arrayA[j];
    }

    i=inicio;
    j=fim;

    for(int k=inicio; k<=fim; k++) {
        numTrocasMS++;
        if(Aux[i] <= Aux[j]) {
            arrayA[k] = Aux[i];
            i++;
        } else {
            arrayA[k] = Aux[j];
            j--;
        }
    }
}

/*Função: OrdenaRadixSort() - Método de ordenação de arrays de valores inteiros com base no
                            Algoritmo do Radix Sort  */
void OrdenaRadixSort(int Vet[],int Max){

    int i, b[Max], m=0, exp=1;

    for(i=0;i<Max;i++){
        numComparacoesRS++;

        numComparacoesRS++;
        if(Vet[i]>m){
            m=Vet[i];
        }
    }

    while(m/exp>0){
        numComparacoesRS++;

        int bucket[10]={0};

        for(i=0;i<Max;i++){
            bucket[Vet[i]/exp%10]++;
        }

        for(i=1;i<10;i++){
            bucket[i]+=bucket[i-1];
        }

        for(i=Max-1;i>=0;i--){
            b[--bucket[Vet[i]/exp%10]]=Vet[i];
            numTrocasRS++;
        }

        for(i=0;i<Max;i++){
            Vet[i]=b[i];
            numTrocasRS++;
        }

        exp*=10;

    }
}

/*Função: OrdenaDoubleSort() - Algoritmo de Ordenação criado pelo grupo, com a intenção de misturar 2 algoritmos de ordenação diferentes*/
void OrdenaDoubleSort(int arrayA[], int n){

    int i, j, k;
    int arrayESQ[n/2];
    int arrayDIR[n/2];

    for(i=0; i<n/2; i++){
        numComparacoesDS++;
        arrayESQ[i] = arrayA[i];
    }

    for(i=0; i<n/2; i++){
        numComparacoesDS++;
        arrayDIR[i] = arrayA[i+(n/2)];
    }

    insertionSortDouble(arrayDIR, n/2);
    OrdenaBubbleSortDouble(arrayESQ, n/2);

    i=0;
    j=0;
    arrayESQ[n/2] = 100000;
    arrayDIR[n/2] = 100000;

    for(int k=0; k<n; k++){
        numComparacoesDS++;
        numTrocasDS++;
        if(arrayESQ[i] < arrayDIR[j]){
            arrayA[k] = arrayESQ[i];
            i++;
        } else {
            arrayA[k] = arrayDIR[j];
            j++;
        }
    }
}

/*Função: insertionSortDouble() - Método de ordenação de arrays de valores inteiros com base no
                            Algoritmo do Insertion Sort (Ordenacao Direta) para utilização do Double Sort  */
void insertionSortDouble(int arrayA[], int n) {
    int i, j, chave;
    for (i=1; i<n; i++) {
        numComparacoesDS++;

        chave = arrayA[i];
        j = i - 1;
        while((chave < arrayA[j]) && (j>=0)) {
            numComparacoesDS++;

            arrayA[j+1] = arrayA[j];
            numTrocasDS++;
            j = j-1;
        }
        arrayA[j+1] = chave;
        numTrocasDS++;
    }
}

/*Função: OrdenaBubbleSortDouble() - Método de ordenação de arrays de valores inteiros com base no
                            Algoritmo do Bubble Sort para utilização do Double Sort  */
void OrdenaBubbleSortDouble(int arrayA[], int n){
    int aux, i, j;
    for(j=n-1; j>=1; j--){
        numComparacoesDS++;
        for(i=0; i<j; i++){
                numComparacoesDS++;
            if(arrayA[i]>arrayA[i+1]){
                numTrocasDS++;
                aux = arrayA[i];
                arrayA[i] = arrayA[i+1];
                arrayA[i+1] = aux;
            }
        }
    }
}


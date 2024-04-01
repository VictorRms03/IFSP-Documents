#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "ordenacao.h"

/* Fun��o: geraArrayAleatorio() - Gerar numeros inteiros aleatorios para um array de tamanho n */
void geraArrayAleatorio(int arrayOriginal[], int n) {
    int valor;

    srand(time(NULL));
    for(int i=0; i< n; i++) {
        valor = rand() % 100;
        arrayOriginal[i] = valor;
    }
}

/* Fun��o: imprimeArray() - Imprime os n n�meros inteiros de um array */
void imprimeArray(int arrayA[], int n) {
    printf("\n ");
    for(int i=0; i<n; i++) {
        printf(" %d", arrayA[i]);
    }
}

/* Fun��o: copiaValoresArray() - Copia os valores do Array Original para um Array Temporario,
                                 com o objetivo de nao perder os valores originais na ordenacao */
void copiaValoresArray(int arrayOriginal[], int arrayA[], int n) {
    for(int i=0; i<n; i++) {
        arrayA[i] = arrayOriginal[i];
    }
}

/*Fun��o: insertionSort() - M�todo de ordena��o de arrays de valores inteiros com base no
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

/*Fun��o: OrdenaBinaria() - Insere os n�umeros em ordem no array por pesquisa binaria. */
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

/*Fun��o: OrdenaShellSort() - M�todo de ordena��o de arrays de valores inteiros com base no
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

/*Fun��o: OrdenaBubbleSort() - M�todo de ordena��o de arrays de valores inteiros com base no
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

/*Fun��o: OrdenaShakeSort() - M�todo de ordena��o de arrays de valores inteiros com base no
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

/*Fun��o: OrdenaCombSort() - M�todo de ordena��o de arrays de valores inteiros com base no
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

/*Fun��o: OrdenaQuickSortRecursivo() - M�todo de ordena��o de arrays de valores inteiros com base no
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

/*Fun��o: OrdenaSelectSort() - M�todo de ordena��o de arrays de valores inteiros com base no
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

/*Fun��o: heapSort() - M�todo de ordena��o de arrays de valores inteiros com base no
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

/*Fun��o: Heap() - M�todo de apoio para o m�todo de Ordena��o heapSort()  */
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

/*Fun��o: MergeSortRecursivo() - M�todo de orden��o de arrays de valores inteiros com base no
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

/*Fun��o: IntercalaSemSentinela() - M�todo de Auxiliar ao Algoritmo do MergeSort/Intercala
                        que realiza a etapa da combina��o */
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

/*Fun��o: OrdenaRadixSort() - M�todo de ordena��o de arrays de valores inteiros com base no
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

/*Fun��o: OrdenaDoubleSort() - Algoritmo de Ordena��o criado pelo grupo, com a inten��o de misturar 2 algoritmos de ordena��o diferentes*/
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

/*Fun��o: insertionSortDouble() - M�todo de ordena��o de arrays de valores inteiros com base no
                            Algoritmo do Insertion Sort (Ordenacao Direta) para utiliza��o do Double Sort  */
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

/*Fun��o: OrdenaBubbleSortDouble() - M�todo de ordena��o de arrays de valores inteiros com base no
                            Algoritmo do Bubble Sort para utiliza��o do Double Sort  */
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


#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "ordenacao.h"

int main()
{
    numComparacoesIS = 0, numTrocasIS = 0;
    numComparacoesMS = 0, numTrocasMS = 0;
    numComparacoesOB = 0, numTrocasOB = 0;
    numTrocasSS = 0, numComparacoesSS = 0;
    numComparacoesBS = 0, numTrocasBS = 0;
    numTrocasQS = 0, numComparacoesQS = 0;
    numComparacoesCS = 0, numTrocasCS = 0;
    numTrocasSK = 0, numComparacoesSK = 0;
    numComparacoesSL = 0, numTrocasSL = 0;

    printf("\n Algoritmos de Ordenacoes: \n");

    //Solicitacao do Tamanho do Array e Alocacao Dinamica da Memoria dos Arrays
    printf("\n Entre com o tamanho (n) do Array: ");
    scanf("%d", &n);
    arrayOriginal = (int*) malloc(n * sizeof(int));
    arrayA = (int*) malloc(n * sizeof(int));

    //Gerando Array com Valores Aleatorios
    geraArrayAleatorio(arrayOriginal, n);

    //Imprimindo Array Gerado Aleatoriamente
    printf("\n Array Original Gerado Aleatoriamente: \n");
    imprimeArray(arrayOriginal, n);

    //Copiando Valor do Array Original para um Array Temporario
    copiaValoresArray(arrayOriginal, arrayA, n);

    //Ordenando Array utilizando o Insertion Sort
    printf("\n\n Ordenando o Array - Insertion Sort(): \n");
    imprimeArray(arrayA, n);
    insertionSort(arrayA, n);
    imprimeArray(arrayA, n);

    //Ordenando Array utilizando o Insertion Sort Alternativo
    printf("\n\n Ordenando o Array - Insertion Sort Alternativo: \n");
    copiaValoresArray(arrayOriginal, arrayA, n);
    imprimeArray(arrayA, n);
    insertionSort(arrayA, n);
    imprimeArray(arrayA, n);

    //Ordenando Array utilizando a Ordenação Binária
    printf("\n\n Ordenando o Array - Ordenacao Binaria: \n");
    copiaValoresArray(arrayOriginal, arrayA, n);
    imprimeArray(arrayA, n);
    OrdenaBinaria(arrayA, n);
    imprimeArray(arrayA, n);

    //Ordenando Array utilizando o Shell Sort
    printf("\n\n Ordenando o Array - Shell Sort: \n");
    copiaValoresArray(arrayOriginal, arrayA, n);
    imprimeArray(arrayA, n);
    int Np = 2;
    for(int i=Np; i>=0; i--){
        Inc = (int)pow(2.0, i);
        for(int SegCorrente=0; SegCorrente<Inc; SegCorrente++){
            OrdenaShellSort(arrayA, Inc, SegCorrente);
        }
    }
    imprimeArray(arrayA, n);

    //Ordenando Array utilizando o Bubble Sort
    printf("\n\n Ordenando o Array - Bubble Sort: \n");
    copiaValoresArray(arrayOriginal, arrayA, n);
    imprimeArray(arrayA, n);
    OrdenaBubbleSort(arrayA, n);
    imprimeArray(arrayA, n);

    //Ordenando Array utilizando o Shake Sort
    printf("\n\n Ordenando o Array - Shake Sort: \n");
    copiaValoresArray(arrayOriginal, arrayA, n);
    imprimeArray(arrayA, n);
    OrdenaShakeSort(arrayA, n);
    imprimeArray(arrayA, n);

    //Ordenando Array utilizando o Comb Sort
    printf("\n\n Ordenando o Array - Comb Sort: \n");
    copiaValoresArray(arrayOriginal, arrayA, n);
    imprimeArray(arrayA, n);
    OrdenaCombSort(arrayA, n);
    imprimeArray(arrayA, n);

    //Ordenando Array utilizando o Quick Sort
    printf("\n\n Ordenando o Array - Quick Sort: \n");
    copiaValoresArray(arrayOriginal, arrayA, n);
    imprimeArray(arrayA, n);
    OrdenaQuickSortRecursivo(arrayA, 0, n-1);
    imprimeArray(arrayA, n);

    //Ordenando Array utilizando o Select Sort
    printf("\n\n Ordenando o Array - Select Sort: \n");
    copiaValoresArray(arrayOriginal, arrayA, n);
    imprimeArray(arrayA, n);
    OrdenaSelectSort(arrayA);
    imprimeArray(arrayA, n);

    //Ordenando Array utilizando o Heap Sort
    printf("\n\n Ordenando o Array - Heap Sort: \n");
    copiaValoresArray(arrayOriginal, arrayA, n);
    imprimeArray(arrayA, n);
    heapSort(arrayA, n);
    imprimeArray(arrayA, n);

    //Ordenando Array utilizando o MergeSort sem Sentinela
    printf("\n\n Ordenando o Array - MergeSort sem Sentinela: \n");
    copiaValoresArray(arrayOriginal, arrayA, n);
    imprimeArray(arrayA, n);
    MergeSortRecursivo(arrayA, n, 0, n-1);
    imprimeArray(arrayA, n);

    //Ordenando Array utilizando o Radix Sort
    printf("\n\n Ordenando o Array - Radix Sort: \n");
    copiaValoresArray(arrayOriginal, arrayA, n);
    imprimeArray(arrayA, n);
    OrdenaRadixSort(arrayA, n);
    imprimeArray(arrayA, n);

    //Ordenando Array utilizando array Criado pelo Grupo (Double Sort)
    printf( "\n\n Ordenando o Array - Double Sort: \n");
    copiaValoresArray(arrayOriginal, arrayA, n);
    imprimeArray(arrayA, n);
    OrdenaDoubleSort(arrayA, n);
    imprimeArray(arrayA, n);


    //Impressao do Numero de Comparacoes e Trocas dos Algoritmos de Ordenação
    printf("\n\n Analise dos Algoritmos de Ordenacao");
    printf("\n\t\t Comparacoes \t Trocas");
    printf("\n IS\t\t %d \t\t %d", numComparacoesIS, numTrocasIS);
    printf("\n OB\t\t %d \t\t %d", numComparacoesOB, numTrocasOB);
    printf("\n SS\t\t %d \t\t %d", numComparacoesSS, numTrocasSS);
    printf("\n BS\t\t %d \t\t %d", numComparacoesBS, numTrocasBS);
    printf("\n SK\t\t %d \t\t %d", numComparacoesSK, numTrocasSK);
    printf("\n CS\t\t %d \t\t %d", numComparacoesCS, numTrocasCS);
    printf("\n QS\t\t %d \t\t %d", numComparacoesQS, numTrocasQS);
    printf("\n SL\t\t %d \t\t %d", numComparacoesSL, numTrocasSL);
    printf("\n HL\t\t %d \t\t %d", numComparacoesHS, numTrocasHS);
    printf("\n MS\t\t %d \t\t %d", numComparacoesMS, numTrocasMS);
    printf("\n RS\t\t %d \t\t %d", numComparacoesRS, numTrocasRS);
    printf("\n DS\t\t %d \t\t %d", numComparacoesDS, numTrocasDS);

    return 0;
}

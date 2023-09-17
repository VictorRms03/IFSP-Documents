#include <stdio.h>
#include <stdlib.h>
#include "threesum.h"

int qtdOperacoes3SumFB=0;
int qtdOperacoes3SumMelhorado=0;

/* treeSumForcaBruta(): */
void treeSumForcaBruta(int A[], int n) {

    int numeroTripla = 0;

    for(int i=0; i<n-2; i++){
        qtdOperacoes3SumFB++;

        for(int j=i+1; j<n-1; j++){
            qtdOperacoes3SumFB++;

            for(int k=j+1; k<n; k++){
                qtdOperacoes3SumFB++;

                if(A[i] + A[j] + A[k] == 0){
                    numeroTripla++;
                    printf( " %d Tripla Encontrada: [%d, %d, %d]\n", numeroTripla, A[i], A[j], A[k]);
                }

            }
        }
    }

    printf( " Total Triplas Encontradas pela Forca Bruta: %d", numeroTripla);


}

/* treeSumMelhorado(): */
void treeSumMelhorado(int A[], int n) {

    int numeroTripla=0;

    for(int i=0; i<n-1; i++){
        qtdOperacoes3SumMelhorado++;

        for(int j=i+1; j<n; j++){
            qtdOperacoes3SumMelhorado++;

            int numeroPreciso = 0 - A[i] - A[j];
            int posicaoNumero = BuscaBinaria(numeroPreciso, A, j+1, n-1);

            if(posicaoNumero != -1){
                numeroTripla++;
                printf( " \n%d Tripla Encontrada: [%d, %d, %d]", numeroTripla, A[i], A[j], A[posicaoNumero]);
            }
        }
    }
}

/* BuscaBinaria(): */
int BuscaBinaria (int x, int A[], int inicio, int fim)
{
    int meio = (inicio+fim)/2;

    if(inicio>fim){
        return -1;
    }

    if(A[meio] == x){
        return meio;
    }

    if(A[meio] < x){
        return BuscaBinaria(x, A, meio+1, fim);
    } else {
        return BuscaBinaria(x, A, inicio, meio-1);
    }
}

/* MergeSortRecursivo(): */
void MergeSortRecursivo(int A[], int inicio, int fim, int n)
{
    if(inicio<fim){
        int meio = ((inicio+fim)/2);
        MergeSortRecursivo(A, inicio, meio, n);
        MergeSortRecursivo(A, meio+1, fim, n);
        IntercalaSemSentinela(A, inicio, meio, fim, n);
    }
}

/* IntercalaSemSentinela(): */
void IntercalaSemSentinela(int A[], int inicio, int meio, int fim, int n)
{
    int *B;
    B = (int*) malloc ((fim+1) * sizeof(int));

    for(int i=inicio; i<=meio; i++){
        B[i] = A[i];
    }

    for(int j=meio+1; j<=fim; j++){
        B[fim+meio+1-j] = A[j];
    }

    int i = inicio;
    int j = fim;

    for(int k=inicio; k<=fim; k++){
        if(B[i] <= B[j]){
            A[k] = B[i];
            i++;


        } else {
            A[k] = B[j];
            j--;
        }
    }
    free(B);
}

/* ImprimeArray(): */
void ImprimeArray(int A[], char Msg[], int n)
{
    printf(Msg);
    for(int i=0; i<n; i++){
        printf( " %d", A[i]);
    }
}

/* ImprimeQtdOperacoes():  */
void ImprimeQtdOperacoes()
{
    printf( "\n\n Quantidade de Operacoes - 3SUM - Forca Bruta: %d", qtdOperacoes3SumFB);
    printf( "\n Quantidade de Operacoes - 3SUM - Melhorado: %d", qtdOperacoes3SumMelhorado);
}

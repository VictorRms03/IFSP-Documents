#include <stdio.h>
#include <stdlib.h>
#include "threesum.h"

/* Variáveis Globais */
int *A;

int main()
{
    int n;
    printf("\n ---Projeto 01 - 3SUM--- \n");

    printf("\n Definir o tamanho do Array: ");
    scanf("%d", &n);

    A = (int*) malloc (n * sizeof(int));

    for(int i=0; i<n; i++) {
        printf(" Entre com o %d elemento do Array: ", i+1);
        scanf("%d", &A[i]);
    }

    ImprimeArray(A, "\nArray Infor.   [] = ", n);

    printf( "\n\n ---3SUM - Forca Bruta:---\n\n");
    treeSumForcaBruta(A, n);

    printf( "\n\n ---3SUM - Melhorado:---\n\n");

    MergeSortRecursivo(A, 0, n-1, n);
    ImprimeArray(A, " Array Ord.   [] = ", n);
    treeSumMelhorado(A, n);

    ImprimeQtdOperacoes();

    return 0;
}


#include <stdio.h>
#include <stdlib.h>

void produtoInterno (const double *a1, const double *a2, double *p, int n);

int main(){

    double array1[5];
    double array2[5];
    double produto[5];
    int tam = 5;

    for (int i=0;i<tam;i++){
        printf("a1[%d]: ",i);
        scanf("%lf", &array1[i]);
    }

    for (int i=0;i<tam;i++){
        printf("a2[%d]: ",i);
        scanf("%lf", &array2[i]);
    }

    produtoInterno(array1,array2,produto,tam);

    for (int i=0;i<tam;i++){
        printf("%.2lf x %.2lf = %.2lf\n",array1[i],array2[i],produto[i]);
    }

}

void produtoInterno (const double *a1, const double *a2, double *pi, int n){

    for (int i=0;i<n;i++){
        pi[i] = a1[i] * a2[i];
    }

}

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <stdbool.h>

void imprimeDuplaClassificada (int n1, int n2, bool emOrdemCrescente){

    if (emOrdemCrescente){
       printf("%d e %d: %0.f <= %0.f\n",n1,n2,fmin(n1,n2),fmax(n1,n2));
    }
    else{
        printf("%d e %d: %0.f >= %0.f\n",n1,n2,fmax(n1,n2),fmin(n1,n2));
    }
}

int main(){

    int n1[5];
    int n2[5];

    for (int i=0;i<5;i++){
        printf("n1[%d]: ",i);
        scanf("%d",&n1[i]);
        printf("n2[%d]: ",i);
        scanf("%d",&n2[i]);
    }

    for (int i=0;i<5;i++){
        if (i%2==0){
            imprimeDuplaClassificada(n1[i],n2[i],true);
        }
        else{
            imprimeDuplaClassificada(n1[i],n2[i],false);
        }
    }

    return 0;
}

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

void classificaDupla (int n1, int n2){

    printf("%d e %d: %0.f <= %0.f\n",n1,n2,fmin(n1,n2),fmax(n1,n2));
}

int main(){

    int n1[3];
    int n2[3];

    for (int i=0;i<3;i++){
        printf("n1[%d]: ",i);
        scanf("%d",&n1[i]);
        printf("n2[%d]: ",i);
        scanf("%d",&n2[i]);
    }

    for (int i=0;i<3;i++){
        classificaDupla(n1[i],n2[i]);
    }

    return 0;
}

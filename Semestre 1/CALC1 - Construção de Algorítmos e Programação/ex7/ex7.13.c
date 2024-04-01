#include <stdio.h>
#include <stdlib.h>
#include <math.h>

void classificaTrinca (int n1, int n2, int n3){

    float maior;
    float menor;
    float valormedio;

    maior = fmax(fmax(n1,n2),fmax(n1,n3));
    menor = fmin(fmin(n1,n2),fmin(n1,n3));

    if (n1<maior && n1>menor){
        valormedio = n1;
    }
    else if (n2<maior && n2>menor){
        valormedio = n2;
    }
    else if (n3<maior && n3>menor){
        valormedio = n3;
    }
    else if (maior == menor){
        valormedio = maior;
    }

    printf("%d, %d e %d: %0.f <= %0.f <= %0.f\n",n1,n2,n3,menor,valormedio,maior);
}

int main(){

    int n1[3];
    int n2[3];
    int n3[3];

    for (int i=0;i<3;i++){
        printf("n1[%d]: ",i);
        scanf("%d",&n1[i]);
        printf("n2[%d]: ",i);
        scanf("%d",&n2[i]);
        printf("n3[%d]: ",i);
        scanf("%d",&n3[i]);
    }

    for (int i=0;i<3;i++){
        classificaTrinca(n1[i],n2[i],n3[i]);
    }

    return 0;
}

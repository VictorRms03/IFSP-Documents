#include <stdlib.h>
#include <stdio.h>
#include <math.h>

float maiorNumero (float n1, float n2){

    float resultadoNum;

    if (n1==n2){
        resultadoNum = -1;
    }
    else{
        resultadoNum = fmax(n1,n2);
    }

    return resultadoNum;
}


int main (){

    float n1[5];
    float n2[5];
    float maiorN = 0.0;

    for (int i=0;i<5;i++){
        printf("n1[%d]: ",i);
        scanf("%f", &n1[i]);

        if (n1[i]<0){
            do{
                printf("Entre com um valor positivo!\n");
                printf("n1[%d]: ",i);
                scanf("%f",&n1[i]);
            }while(n1[i]<0);
        }
        printf("n2[%d]: ",i);
        scanf("%f", &n2[i]);

        if (n2[i]<0){
            do{
                printf("Entre com um valor positivo!\n");
                printf("n2[%d]: ",i);
                scanf("%f",&n2[i]);
            }while(n2[i]<0);
        }
    }

    for (int i=0;i<5;i++){
        maiorN = maiorNumero(n1[i],n2[i]);

        if (maiorN == -1){
            printf("%.2f, %.2f: Eles sao iguais\n",n1[i],n2[i]);
        }
        else{
            printf("%.2f, %.2f: O maior valor e %.2f\n",n1[i],n2[i],maiorN);
        }
    }

    return 0;
}

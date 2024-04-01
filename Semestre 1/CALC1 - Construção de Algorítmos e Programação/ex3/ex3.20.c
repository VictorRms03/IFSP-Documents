#include <stdio.h>
#include <stdlib.h>

int main(){
    int i;
    int j;

    for (i=0;i<5;i++){
        for (j=0;j<=i;j++){
            printf("*");
        }
        printf("\n");
    }

    printf("\n");

    for(i=5;i>=1;i--){
        for (j=i;j>=1;j--){
            printf("*");
        }
        printf("\n");
    }

    printf("\n");

    for(i=1;i<=5;i++){
        for (j=1;j<=5;j++){
            if ((i+j)>=6){
                printf("*");
            }
            else{
                printf(" ");
            }
        }
        printf("\n");
    }

    printf("\n");

    for(i=1;i<=5;i++){
        for (j=1;j<=5;j++){
            if (i==j || i<j){
                printf("*");
            }
            else{
                printf(" ");
            }
        }
        printf("\n");
    }

    return 0;
}

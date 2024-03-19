#include <stdio.h>
#include <stdlib.h>

int main(){
    int h;
    int i;
    int j;

    printf("Altura: ");
    scanf("%d",&h);

    if(h>0){
        for(i=1;i<=h;i++){
            for(j=1;j<(h+i);j++){
                if((i+j)>h){
                    printf("*");
                }
                else{
                    printf(" ");
                }
            }
            printf("\n");
        }
    }
    else if (h<0){
        h = h * -1;

        for (i=h;i>=1;i--){
            for (j=1;j<(h+i);j++){
                if ((i+j)>h){
                    printf("*");
                }
                else{
                    printf(" ");
                }
            }
            printf("\n");
        }
    }

    return 0;
}

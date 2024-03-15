#include <stdio.h>
#include <stdlib.h>
int main(){
    float n1;
    float n2;
    float ad;
    float sub;
    float mult;
    float div;

    printf("primeiro numero: ");
    scanf ("%f",&n1);
    printf("segundo numero: ");
    scanf ("%f",&n2);

    ad= n1 + n2;
    sub= n1 - n2;
    mult= n1 * n2;
    div= n1 / n2;

    printf("%.2f + %.2f = %.2f\n",n1,n2,ad);

    printf("%.2f - %.2f = %.2f\n",n1,n2,sub);

    printf("%.2f * %.2f = %.2f\n",n1,n2,mult);

    printf("%.2f / %.2f = %.2f\n",n1,n2,div);


    return 0;










}

#include <stdio.h>
#include <stdlib.h>
int main(){

    int n1;
    int n2;
    int ad;
    int sub;
    int mult;
    int div;
    printf ("primeiro numero:");
    scanf ("%d",&n1);
    printf("segundo numero:");
    scanf ("%d",&n2);

    ad=n1+n2;
    sub=n1-n2;
    mult=n1*n2;
    div=n1/n2;

    printf("%d + %d = %d\n",n1,n2,ad);

    printf("%d - %d = %d\n",n1,n2,sub);

    printf("%d * %d = %d\n",n1,n2,mult);

    printf("%d / %d = %d\n",n1,n2,div);


    return 0;
}

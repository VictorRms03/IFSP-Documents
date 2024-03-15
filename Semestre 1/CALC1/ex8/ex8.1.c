#include <stdio.h>
#include <stdlib.h>

void somatorioMedia(float a[],
                    int n,
                    float *somatorio,
                    float *media);

int main() {

    float a[10];
    int n = 10;
    float somatorio;
    float media;

    for(int i=0;i<n;i++){
        printf( "n[%d]: ", i);
        scanf( " %f", &a[i]);
    }

    somatorioMedia(a, n, &somatorio, &media);

    printf( "Somatorio: %.2f\n", somatorio);
    printf( "Media: %.2f", media);

    return 0;
}

void somatorioMedia(float a[], int n, float *somatorio, float *media) {

    for(int i=0;i<n;i++){
        *somatorio = *somatorio + a[i];
    }
    *media = *somatorio/10;


}

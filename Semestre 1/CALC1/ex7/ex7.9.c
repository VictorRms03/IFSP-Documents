#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <math.h>

int lePositivo (){

    int n;

    scanf("%d", &n);

    if (n<0){
        do{
            printf("Entre com um valor positivo: ");
            scanf("%d", &n);
        }while(n<0);
    }

    return n;
}

bool ehTriangulo (int ladoA, int ladoB, int ladoC){

    bool verificadorTriangulo;

    if (ladoA > abs(ladoB - ladoC) && ladoA < (ladoB + ladoC) && ladoB > abs(ladoA - ladoC) && ladoB < (ladoA + ladoC) &&
        ladoC > abs(ladoB - ladoA) && ladoC < (ladoB + ladoA)){

            verificadorTriangulo = true;
        }
    else{
        verificadorTriangulo = false;
    }

    return verificadorTriangulo;
}

int tipoTriangulo (int ladoA, int ladoB, int ladoC){

    int verificadorTipo = 0;

    if (ladoA == ladoB && ladoB == ladoC){
        verificadorTipo = 1;
    }
    else if (ladoA != ladoB && ladoA != ladoC && ladoB != ladoC){
        verificadorTipo = 3;
    }
    else{
        verificadorTipo = 2;
    }

    return verificadorTipo;
}


int main (){

    int ladoA[5];
    int ladoB[5];
    int ladoC[5];

    for (int i=0;i<5;i++){
        printf("ladoA[%d]: ",i);
        ladoA[i] = lePositivo();
        printf("LadoB[%d]: ",i);
        ladoB[i] = lePositivo();
        printf("LadoC[%d]: ",i);
        ladoC[i] = lePositivo();
    }

    for (int i=0;i<5;i++){
        if (ehTriangulo(ladoA[i],ladoB[i],ladoC[i])){
            if (tipoTriangulo(ladoA[i],ladoB[i],ladoC[i]) == 1){
                printf("Valores %d, %d e %d: triangulo equilatero",ladoA[i],ladoB[i],ladoC[i]);
            }
            else if (tipoTriangulo(ladoA[i],ladoB[i],ladoC[i]) == 2){
                printf("Valores %d, %d e %d: triangulo isosceles",ladoA[i],ladoB[i],ladoC[i]);
            }
            else if (tipoTriangulo(ladoA[i],ladoB[i],ladoC[i]) == 3){
                printf("Valores %d, %d e %d: triangulo escaleno",ladoA[i],ladoB[i],ladoC[i]);
            }
        }
        else{
            printf("Valores %d, %d e %d: nao formam um triangulo",ladoA[i],ladoB[i],ladoC[i]);
        }
        printf("\n");
    }

    return 0;
}

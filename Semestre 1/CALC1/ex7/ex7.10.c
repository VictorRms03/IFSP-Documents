#include <stdlib.h>
#include <stdio.h>

int calculaDigito (int n){

    int contadorDigitos = 0;

    if (n >= 1000){
        contadorDigitos = 4;
    }
    else if (n >= 100 && n < 1000){
        contadorDigitos = 3;
    }
    else if (n >= 10 && n < 100){
        contadorDigitos = 2;
    }
    else{
        contadorDigitos = 1;
    }

    int digitos[contadorDigitos];
    int contador = 0;

    if (n/1000>=1){
        digitos[contador] = n/1000;
        n = n%1000;
        contador++;
    }
    if (n/100>=1){
        digitos[contador] = n/100;
        n = n%100;
        contador++;
    }
    if (n/10>=1){
        digitos[contador] = n/10;
        n = n%10;
        contador++;
    }
    digitos[contador] = n;

    int multplicador = 2;
    int somatorio = 0;

    for (int i=contador;i>=0;i--){
        digitos[i] = digitos[i] * multplicador;
        somatorio = somatorio + digitos[i];
        multplicador++;
    }

    int resto = somatorio % 11;

    int digitoVerificador = 11 - resto;

    if (digitoVerificador == 10 || digitoVerificador == 11){
        digitoVerificador = 0;
    }

    return digitoVerificador;

}


int main (){

    int n;

    printf("Numero: ");
    scanf("%d", &n);

    if (n>=1 && n<=9999){
        printf("Digito verificador de %d: %d",n,calculaDigito(n));
    }

    return 0;
}

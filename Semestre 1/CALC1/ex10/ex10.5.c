#include <stdio.h>
#include <stdlib.h>

typedef struct {
    float numerador;
    float denominador;
} Fracao;

Fracao somar( const Fracao *f1, const Fracao *f2 );
Fracao subtrair( const Fracao *f1, const Fracao *f2 );
Fracao multiplicar( const Fracao *f1, const Fracao *f2 );
Fracao dividir( const Fracao *f1, const Fracao *f2 );
void imprimirFracao( const Fracao *f );

int main() {

    Fracao f1;
    Fracao f2;
    Fracao soma;
    Fracao sub;
    Fracao mult;
    Fracao div;

    printf( "Fracao 1\n");
    printf( "    Numerador: ");
    scanf( "%f", &f1.numerador);
    printf( "    Denominador: ");
    scanf( "%f", &f1.denominador);
    printf( "Fracao 2\n");
    printf( "    Numerador: ");
    scanf( "%f", &f2.numerador);
    printf( "    Denominador: ");
    scanf( "%f", &f2.denominador);

    soma = somar(&f1, &f2);
    sub = subtrair(&f1, &f2);
    mult = multiplicar(&f1, &f2);
    div = dividir(&f1, &f2);

    imprimirFracao(&f1);
    printf( " + ");
    imprimirFracao(&f2);
    printf( " = ");
    imprimirFracao(&soma);
    printf( "\n");

    imprimirFracao(&f1);
    printf( " - ");
    imprimirFracao(&f2);
    printf( " = ");
    imprimirFracao(&sub);
    printf( "\n");

    imprimirFracao(&f1);
    printf( " * ");
    imprimirFracao(&f2);
    printf( " = ");
    imprimirFracao(&mult);
    printf( "\n");

    imprimirFracao(&f1);
    printf( " / ");
    imprimirFracao(&f2);
    printf( " = ");
    imprimirFracao(&div);

    return 0;
}

Fracao somar( const Fracao *f1, const Fracao *f2 ){
    Fracao f;

    if (f1->denominador != f2->denominador){
        f.denominador = f1->denominador * f2->denominador;
        f.numerador = ((f.denominador / f1->denominador) * f1->numerador) + ((f.denominador / f2->denominador) * f2->numerador);
    } else {
        f.denominador = f1->denominador;
        f.numerador = f1->numerador + f2->numerador;
    }

    return f;
}

Fracao subtrair( const Fracao *f1, const Fracao *f2 ){
    Fracao f;

    if (f1->denominador != f2->denominador){
        f.denominador = f1->denominador * f2->denominador;
        f.numerador = ((f.denominador / f1->denominador) * f1->numerador) - ((f.denominador / f2->denominador) * f2->numerador);
    } else {
        f.denominador = f1->denominador;
        f.numerador = f1->numerador - f2->numerador;
    }

    return f;
}

Fracao multiplicar( const Fracao *f1, const Fracao *f2 ){
    Fracao f;

    f.numerador = f1->numerador * f2->numerador;
    f.denominador = f1->denominador * f2->denominador;

    return f;
}

Fracao dividir( const Fracao *f1, const Fracao *f2 ){
    Fracao f;

    f.numerador = f1->numerador * f2->denominador;
    f.denominador = f2->numerador * f1->denominador;

    return f;
}

void imprimirFracao( const Fracao *f ){
    printf( "%.2f/%.2f", f->numerador, f->denominador);
}

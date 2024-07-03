function alertFahrenheit ( fahrenheit ) {
    window.alert( "Exercício 1 : " + ( 5/9 ) * ( fahrenheit - 32 ) );
}

function calcDelta ( a, b, c ) {
    return b*b - 4*a*c;
}

function calcRoots ( a, b, c ) {
    x1 = ( -b + Math.sqrt( calcDelta(a, b, c) ) ) / 2*a;
    x2 = ( -b - Math.sqrt( calcDelta(a, b, c) ) ) / 2*a;

    document.write("Raiz 1 = " + x1 + " - Raiz 2 = " + x2);
}

function arithmeticProgression1 ( P1, R, qntdElem ){
    for( let i=0; i < qntdElem-1; i++ ) { P1 += R; }

    document.write( P1 );
}

function arithmeticProgression2 ( P1, R, qntdElem ){
    for( let i=0; i < qntdElem-1; i++ ) { P1 *= R; }
    document.write( P1 );
}
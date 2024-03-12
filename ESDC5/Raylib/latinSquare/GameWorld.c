/**
 * @file GameWorld.h
 * @author Prof. Dr. David Buzatto
 * @brief GameWorld implementation.
 * 
 * @copyright Copyright (c) 2024
 */
#include <stdio.h>
#include <stdlib.h>

#include "raylib.h"
//#include "raymath.h"
//#define RAYGUI_IMPLEMENTATION
//#include "raygui.h"
//#undef RAYGUI_IMPLEMENTATION

#include "GameWorld.h"
#include "ResourceManager.h"

/*--------------------------------------------
 * Constants. 
 -------------------------------------------*/
#define SquareSize 7
#define SquareDrawSize 50

/*--------------------------------------------
 * Functions prototypes. 
 -------------------------------------------*/
bool solve( int linearPosition );
bool isLineCandidate(char letter, int line);
bool isColumnCandidate(char letter, int column);
int generateLinearPositions ( void );
bool isSolved( void );

/*--------------------------------------------
 * Global variables. 
 -------------------------------------------*/
char latinSquare[SquareSize][SquareSize] = {
    { '1', ' ', ' ', ' ', ' ', ' ', ' ' },
    { ' ', '2', ' ', ' ', ' ', ' ', ' ' },
    { ' ', ' ', '3', ' ', ' ', ' ', ' ' },
    { ' ', ' ', ' ', '4', ' ', ' ', ' ' },
    { ' ', ' ', ' ', ' ', '5', ' ', ' ' },
    { ' ', ' ', ' ', ' ', ' ', '6', ' ' },
    { ' ', ' ', ' ', ' ', ' ', ' ', '7' },
};

char symbols[SquareSize] = { '1', '2', '3', '4', '5', '6', '7'};

int *linearPositions;
int blankSlots = 0;

bool hasSolution;

/*--------------------------------------------
 * Functions. 
 -------------------------------------------*/
GameWorld* createGameWorld( void ) {

    GameWorld *gw = (GameWorld*) malloc( sizeof( GameWorld ) );

    gw->dummy = 0;

    blankSlots = generateLinearPositions();
    solve(0);
    hasSolution = isSolved();

    return gw;

}

void destroyGameWorld( GameWorld *gw ) {
    free( gw );
}

void inputAndUpdateGameWorld( GameWorld *gw ) {
    
}

void drawGameWorld( GameWorld *gw ) {

    BeginDrawing();
    ClearBackground( WHITE );

    //Desenho do Quadrado Latino
    for(int i=0; i<SquareSize; i++){
        for(int j=0; j<SquareSize; j++){
            DrawRectangleLines(100 + SquareDrawSize*i, 20 + SquareDrawSize*j, SquareDrawSize, SquareDrawSize, BLACK);
            DrawText( TextFormat("%c", latinSquare[i][j]), (113 + SquareDrawSize*i), (28 + SquareDrawSize*j), 40, BLACK );
        }
    }

    //Escreve se o Quadrado Latino foi resolvido ou não
    if( hasSolution ){
        DrawText( " Resolvido! ", ((SquareDrawSize * (SquareSize-1)/2) ), (30 + (SquareDrawSize * SquareSize) + SquareSize), 50, GREEN );
    } else {
        DrawText( "Sem Solução!", ((SquareDrawSize * (SquareSize-1)/2) ), (30 + (SquareDrawSize * SquareSize) + SquareSize), 50, RED );
    }

    EndDrawing();

}

bool solve( int linearPosition ){
    
    //a posição linear deve ser processada?
    if(linearPosition < blankSlots) { 

        //calcula em qual linha e coluna o algoritmo vai processar
        int line = linearPositions[linearPosition] / SquareSize;
        int column = linearPositions[linearPosition] % SquareSize;
        int errors = 0;

        //testa cada uma das possibilidades
        for(int i=0; i<SquareSize; i++){
            char c = symbols[i];

            //c é um candidato na linha e na coluna?
            if( isLineCandidate(c, line) && isColumnCandidate(c, column) ){

                //assume-se que c é a solução no momento
                latinSquare[line][column] = c;

                // vai processar a próxima
                // se retornar true, quer dizer que encaixou pelo menos uma
                // alternativa
                if(!solve(linearPosition + 1 ) ){
                    // se não encontrou nenhuma alternativa, o símbolo atual está errado
                    latinSquare[line][column] = ' ';
                }

            } else {
                errors++;
            }

        }

        // caso a quantidade de erros seja igual ao tamanho
        // do array de símbolos, ou seja, nenhum símbolo serviu
        // quer dizer que a escolha anterior foi errada, então retorna falso
        if ( errors == SquareSize ) {
            return false;
        }

        //foi encontrado pelo menos um simbolo correto
        return true;
    }

    //chegou na ultima posição
    return true;

}

bool isLineCandidate(char letter, int line){

    for (int j=0; j<SquareSize; j++){
        if( latinSquare[line][j] == letter ){
            return false;
        }
    }

    return true;

}

bool isColumnCandidate(char letter, int column){
    for( int i=0; i<SquareSize; i++){
        if( latinSquare[i][column] == letter ) {
            return false;
        }
    }
    
    return true;
}

int generateLinearPositions ( void ) {

    
    //Determina o tamanho que o array 'linearPositions' deve ter (pois não há lista em C)
    int size=0;
    for(int i=0; i<SquareSize; i++){
        for( int j=0; j<SquareSize; j++){
            if(latinSquare[i][j] == ' '){
                size++;
            }
        }
    }

    linearPositions = (int*)malloc(size * sizeof(int));

    // Gera as posições lineares dos espaços em brancos
    int linearPositionCounter = 0;
    int k = 0;

    for (int i=0; i<SquareSize; i++) {
        for(int j=0; j<SquareSize; j++){
            if(latinSquare[i][j] == ' '){
                linearPositions[k] = linearPositionCounter;
                k++;
            }
            linearPositionCounter++;
        }
    }

    return size;
}

//Retorna se o Quadrado Latino foi resolvido
bool isSolved( void ) {
    
    for (int i=0; i<SquareSize; i++){
        for (int j=0; j<SquareSize; j++){
            if(latinSquare[i][j] == ' '){
                return false;
            }
        }
    }

    return true;
}
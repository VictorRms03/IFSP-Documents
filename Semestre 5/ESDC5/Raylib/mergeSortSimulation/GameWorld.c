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
#define SquareSize 40
#define arraySize 10

/*--------------------------------------------
* Functions prototypes. 
-------------------------------------------*/
void generateArray ( int *array);
void mergeSort( int *array, int start, int end );
void merge( int *array, int start, int middle, int end);


/*--------------------------------------------
 * Global variables. 
 -------------------------------------------*/
int array[arraySize];
int originalArray[arraySize];

/*--------------------------------------------
 * Functions. 
 -------------------------------------------*/
GameWorld* createGameWorld( void ) {

    GameWorld *gw = (GameWorld*) malloc( sizeof( GameWorld ) );

    gw->dummy = 0;

    generateArray(array);
    mergeSort(array, 0, arraySize-1);

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

    for(int i=0; i<arraySize; i++){
        DrawRectangleLines( ( GetScreenWidth()/2 - SquareSize*(arraySize/2) ) + ( SquareSize*i ), 10, SquareSize, SquareSize, BLACK );
        DrawText( TextFormat("%d", originalArray[i]), ( 5 + ( GetScreenWidth()/2 - SquareSize*(arraySize/2) ) + ( SquareSize*i ) ), 15, 30, BLACK);
    }

    for(int i=0; i<arraySize; i++){
        DrawRectangleLines(10 + (SquareSize*i), 50, SquareSize, SquareSize, BLACK);
        DrawText( TextFormat("%d", array[i]), (15 + (SquareSize*i)), 50, 30, BLACK);
    }
    

    EndDrawing();

}

void generateArray ( int *array){

    for(int i=0; i<arraySize; i++){
        int randNumber = GetRandomValue(0, 10);
        originalArray[i] = randNumber;
        array[i] = randNumber;
    }
    
}

void mergeSort( int *array, int start, int end ){

    if(start<end){
        int middle = ((start + end) / 2);
        mergeSort(array, start, middle);
        mergeSort(array, middle+1, end);
        merge(array, start, middle, end);
    }
}



void merge( int *array, int start, int middle, int end){
    int *auxArray;
    auxArray = (int*) malloc ((end+1) * sizeof(int));

    for(int i=start; i<=middle; i++){
        auxArray[i] = array[i];
    }

    for(int i=middle+1; i<=end; i++){
        auxArray[end+middle+1-i] = array[i];
    }

    int i=start;
    int j=end;

    for(int k=start; k<=end; k++){
        if(auxArray[i] <= auxArray[j]){
            array[k] = auxArray[i];
            i++;
        } else {
            array[k] = auxArray[j];
            j--;
        }
    }

    free(auxArray);
}
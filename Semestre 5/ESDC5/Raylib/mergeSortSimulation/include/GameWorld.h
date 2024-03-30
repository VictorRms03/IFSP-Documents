/**
 * @file GameWorld.h
 * @author Prof. Dr. David Buzatto
 * @brief GameWorld struct and functions declarations.
 * 
 * @copyright Copyright (c) 2024
 */
#pragma once

#include "ArrayCopy.h"
#include <stdbool.h>

typedef struct GameWorld {
    
    int* array;
    size_t size;

    // new array copies are appended to the tail
    // the data structure grows from head to tail
    ArrayCopy* copiesTail;     // list tail
    ArrayCopy* copiesHead;     // list head
    ArrayCopy* currentCopy;    // copy to render

    float timeAcum;
    float timeToWait;

} GameWorld;

/**
 * @brief Creates a dinamically allocated GameWorld struct instance.
 */
GameWorld* createGameWorld( void );

/**
 * @brief Destroys a GameWindow object and its dependecies.
 */
void destroyGameWorld( GameWorld *gw );

/**
 * @brief Reads user input and updates the state of the game.
 */
void inputAndUpdateGameWorld( GameWorld *gw );

/**
 * @brief Draws the state of the game.
 */
void drawGameWorld( GameWorld *gw );

/**
 * @brief Indicates if the position is the left position of the array 
 */
bool isLeftPosition( int position, ArrayCopy* array  ); //

/**
 * @brief Indicates if the position is the middle position of the array 
 */
bool isMiddlePosition( int position, ArrayCopy* array  ); //

/**
 * @brief Indicates if the position is the right position of the array 
 */

bool isRightPosition( int position, ArrayCopy* array  ); //

void createAndAddNewArrayCopy( GameWorld* gw, int firstPosition, int middlePosition, int rightPosition );
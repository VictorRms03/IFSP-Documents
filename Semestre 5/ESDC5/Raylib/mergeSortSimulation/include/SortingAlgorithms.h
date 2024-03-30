#pragma once

#include "GameWorld.h"

void mergeSort( GameWorld* gw );
void mergeSortR( GameWorld* gw, int start, int end, int* temp );
void merge( GameWorld* gw, int start, int middle, int end, int* temp );

void populateArray( int* array, size_t size );
void shuffeArray( int* array, size_t size );
void copyArray( const int* source, int* destination, size_t size );
void swap( int* array, int p1, int p2 );

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#include "GameWorld.h"
#include "SortingAlgorithms.h"
#include "raylib.h"

void mergeSort( GameWorld* gw ) {
    int* temp = (int*) malloc( sizeof(int) * gw->size );
    mergeSortR( gw, 0, gw->size - 1, temp );
    free( temp );
}

void mergeSortR( GameWorld* gw, int start, int end, int* temp ) {
    if ( start < end ) {
        int middle = ( start + end ) / 2;
        mergeSortR( gw, start, middle, temp );
        mergeSortR( gw, middle + 1, end, temp );
        merge( gw, start, middle, end, temp );
    }
}

void merge( GameWorld* gw, int start, int middle, int end, int* temp ) {

    int i = start;
    int j = middle + 1;

    for ( int k = start; k <= end; k++ ) {
        temp[k] = gw->array[k];
    }

    for ( int k = start; k <= end; k++ ) {
        
        if ( i > middle ) {
            gw->array[k] = temp[j++];
        } else if ( j > end ) {
            gw->array[k] = temp[i++];
        } else if ( temp[j] < temp[i] ) {
            gw->array[k] = temp[j++];
        } else {
            gw->array[k] = temp[i++];
        }

        createAndAddNewArrayCopy( gw, start, middle, end );

    }

}

void populateArray( int* array, size_t size ) {
    for ( size_t i = 0; i < size; i++ ) {
        array[i] = (int) (i + 1);
    }
}

void shuffeArray( int* array, size_t size ) {
    for ( size_t i = 0; i < size; i++ ) {
        swap( array, i, GetRandomValue( 0, (int) (size - 1) ) );
    }
}

void copyArray( const int* source, int* destination, size_t size ) {
    for ( size_t i = 0; i < size; i++ ) {
        destination[i] = source[i];
    }
}

void swap( int* array, int p1, int p2 ) {
    int t = array[p1];
    array[p1] = array[p2];
    array[p2] = t;
}
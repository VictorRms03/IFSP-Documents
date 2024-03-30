#include "ArrayCopy.h"

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "GameWorld.h"
#include "SortingAlgorithms.h"

ArrayCopy* createArrayCopy( GameWorld* gw, int firstPosition, int middlePosition, int rightPosition ) {
    
    ArrayCopy* copy = (ArrayCopy*) malloc( sizeof( ArrayCopy ) );
    *copy = (ArrayCopy){0};

    copy->size = gw->size;
    copy->leftPosition = firstPosition;
    copy->middlePosition = middlePosition;
    copy->rightPosition = rightPosition;
    copy->data = (int*) malloc( sizeof(int) * copy->size );

    copyArray( gw->array, copy->data, copy->size );

    return copy;

}

void destroyArrayCopy( ArrayCopy* copy ) {
    free( copy->data );
    free( copy );
}
